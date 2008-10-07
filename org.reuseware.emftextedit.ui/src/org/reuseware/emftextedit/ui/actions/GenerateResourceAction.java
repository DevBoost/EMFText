package org.reuseware.emftextedit.ui.actions;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.reuseware.emftextedit.EMFTextEditPlugin;
import org.reuseware.emftextedit.codegen.ResourcePackage;
import org.reuseware.emftextedit.codegen.ResourcePackageGenerator;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.ui.EMFTextEditUIPlugin;
import org.reuseware.emftextedit.ui.MarkerHelper;

/**
 * An action that calls the generator and in addition generates a
 * <code><plugin.xml</code> and <code>MANIFEST.MF</code> file.
 * 
 * @author jj2
 *
 */
public class GenerateResourceAction implements IObjectActionDelegate {
    
	// these must add up to 100
	protected static final int TICKS_CREATE_PROJECT = 2;
	protected static final int TICKS_OPEN_PROJECT = 2;
	protected static final int TICKS_SET_CLASSPATH = 2;
	protected static final int TICKS_CREATE_META_FOLDER = 2;
	protected static final int TICKS_CREATE_MANIFEST = 2;
	protected static final int TICKS_CREATE_PLUGIN_XML = 2;
	protected static final int TICKS_CREATE_MODELS_FOLDER = 2;
	protected static final int TICKS_GENERATE_RESOURCE = 26;
	protected static final int TICKS_GENERATE_METAMODEL_CODE = 40;
	protected static final int TICKS_REFRESH_PROJECT = 20;
	
	private ISelection selection;

    /**
     * Calls {@link #process(IFile)} for all selected <i>cs</i> files .
     */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    if (file.getFileExtension().startsWith("cs")) {
                    	process(file);
                    }
                }
            }
		}
	}
    
	/**
	 * Creates a new Java project in the Workspace and calls the generators,
	 * 
	 * @param file The file that contains the concrete syntax definition.
	 */
    public void process(final IFile file) {
        try {                 
        	
        	IRunnableWithProgress runnable = new IRunnableWithProgress(){
        		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        			try {
        				SubMonitor progress = SubMonitor.convert(monitor, 100);
        				Resource csResource = getResource(file);

        				MarkerHelper.unmark(csResource);
        				if (containsProblems(csResource)) {
        					MarkerHelper.mark(csResource);
        					return;
        				}
			            
        				final ConcreteSyntax cSyntax = (ConcreteSyntax) csResource.getContents().get(0);
        				String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
        				String projectName = csPackageName;
			    
        				if (projectName == null) { 
        					return;
        				}
        				
        				//create a project
        				IProject project = createProject(progress, projectName);
			            
        				//generate the resource class, parser, and printer
        				ResourcePackage pck = new ResourcePackage(cSyntax, csPackageName, getSrcFolder(project), copyMapFromPreferenceStore());
        				ResourcePackageGenerator.generate(pck, progress.newChild(TICKS_GENERATE_RESOURCE));
			             
        				//errors from parser generator?
        				if (containsProblems(csResource)) {
        					MarkerHelper.mark(csResource);
        				}
			  
			            boolean overridePluginConfig = EMFTextEditUIPlugin.getDefault().getPreferenceStore().getBoolean(EMFTextEditUIPlugin.OVERRIDE_PLUGIN_CONFIG_NAME);
        			      	  
        				createMetaFolder(progress, project);
        				createManifest(progress, cSyntax, projectName, overridePluginConfig, project);
        				createPluginXML(progress, cSyntax, projectName, overridePluginConfig, project);
        				
        				markErrors(cSyntax);
			             
        				IFolder modelsFolder = createModelFolder(progress,
								project);
        				URI csFileURI = URI.createPlatformResourceURI(modelsFolder.getFullPath().append(cSyntax.getName() + ".cs").toString(), true);
        				csResource.setURI(csFileURI);
        				
        				createMetaModelCode(progress, cSyntax);
        				
        				project.refreshLocal(IProject.DEPTH_INFINITE, progress.newChild(TICKS_REFRESH_PROJECT));
        			}
			        catch (CoreException e) {
			        	throw new InvocationTargetException(e);
			        }
        		}

				private IProject createProject(SubMonitor progress,
						String projectName) throws CoreException,
						JavaModelException {
					IJavaProject javaProject = createJavaProject(progress, projectName);
					IProject project = javaProject.getProject();
					setClasspath(javaProject, progress);
					return project;
				}

				private void createMetaModelCode(SubMonitor progress,
						final ConcreteSyntax cSyntax) {
					//call EMF code generator if specified
					if (EMFTextEditUIPlugin.getDefault().getPreferenceStore().getBoolean(EMFTextEditUIPlugin.GENERATE_GEN_MODEL)) {
						generateMetaModelCode(cSyntax.getPackage(), progress.newChild(TICKS_GENERATE_METAMODEL_CODE));
					} else {
						progress.internalWorked(TICKS_GENERATE_METAMODEL_CODE);
					}
				}

				private IJavaProject createJavaProject(SubMonitor progress,
						String projectName) throws CoreException,
						JavaModelException {
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (!project.exists()) {
						project.create(progress.newChild(TICKS_CREATE_PROJECT));
					} else {
						progress.internalWorked(TICKS_CREATE_PROJECT);
					}
					project.open(progress.newChild(TICKS_OPEN_PROJECT));
					IProjectDescription description = project.getDescription();
					description.setNatureIds(new String [] {JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature"});
					ICommand command1 = description.newCommand();
					command1.setBuilderName("org.eclipse.jdt.core.javabuilder");
					ICommand command2 = description.newCommand();
					command2.setBuilderName("org.eclipse.pde.ManifestBuilder");
					ICommand command3 = description.newCommand();
					command3.setBuilderName("org.eclipse.pde.SchemaBuilder");
					description.setBuildSpec(new ICommand [] {command1,command2,command3});
					project.setDescription(description,null);
					
					IJavaProject javaProject = JavaCore.create(project);
					return javaProject;
				}

				private IFolder getSrcFolder(IProject project) {
					return project.getFolder("/src");
				}

				private IFolder getOutFolder(IProject project) {
					return project.getFolder("/bin");
				}

				private void setClasspath(IJavaProject javaProject, SubMonitor progress) throws JavaModelException {
					IFolder srcFolder = getSrcFolder(javaProject.getProject());
					IFolder outFolder = getOutFolder(javaProject.getProject());
					javaProject.setRawClasspath(
					   new IClasspathEntry [] {
							JavaCore.newSourceEntry(srcFolder.getFullPath()), 
							JavaRuntime.getJREVariableEntry(), 
							JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins"))},
					   outFolder.getFullPath(), progress.newChild(TICKS_SET_CLASSPATH));
				}

				private Resource getResource(final IFile file) {
					ResourceSet rs = new ResourceSetImpl();
					Resource csResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
					return csResource;
				}

				private boolean containsProblems(Resource csResource) {
					return !csResource.getErrors().isEmpty()
							|| !csResource.getWarnings().isEmpty();
				}

				private void createMetaFolder(SubMonitor progress,
						IProject project) throws CoreException {
					IFolder metaFolder = project.getFolder("/META-INF");
					if (!metaFolder.exists()) {
						metaFolder.create(true, true, progress.newChild(TICKS_CREATE_META_FOLDER));
					} else {
						progress.internalWorked(TICKS_CREATE_META_FOLDER);
					}
				}

				private void createManifest(SubMonitor progress,
						final ConcreteSyntax cSyntax, String projectName,
						boolean overridePluginConfig, IProject project)
						throws CoreException {
    				IFile manifestMFFile = project.getFile("/META-INF/MANIFEST.MF");
					if (manifestMFFile.exists()){
						if (overridePluginConfig) {
							manifestMFFile.setContents(new ByteArrayInputStream(generateManifestMF(cSyntax, projectName).getBytes()),true,true, progress.newChild(TICKS_CREATE_MANIFEST));
						} else {
							progress.internalWorked(TICKS_CREATE_MANIFEST);
						}
					}
					else {
						manifestMFFile.create(new ByteArrayInputStream(generateManifestMF(cSyntax, projectName).getBytes()),true, progress.newChild(TICKS_CREATE_MANIFEST));            	 
					}
				}

				private void createPluginXML(SubMonitor progress,
						final ConcreteSyntax cSyntax, String projectName,
						boolean overridePluginConfig, IProject project)
						throws CoreException {
    				IFile pluginXMLFile = project.getFile("/plugin.xml");
					if (pluginXMLFile.exists()){
						if (overridePluginConfig) {
							pluginXMLFile.setContents(new ByteArrayInputStream(generatePluginXml(cSyntax, projectName).getBytes()),true,true,progress.newChild(TICKS_CREATE_PLUGIN_XML));
						} else {
							progress.internalWorked(TICKS_CREATE_PLUGIN_XML);
						}
					}
					else {
						pluginXMLFile.create(new ByteArrayInputStream(generatePluginXml(cSyntax, projectName).getBytes()),true,progress.newChild(TICKS_CREATE_PLUGIN_XML));
					}
				}

				private void markErrors(final ConcreteSyntax cSyntax)
						throws CoreException {
					//also mark errors on imported concrete syntaxes
					for(Import aImport : cSyntax.getImports()) {
						ConcreteSyntax importedCS = aImport.getConcreteSyntax();
						if (importedCS != null) {
							MarkerHelper.unmark(importedCS.eResource());
							MarkerHelper.mark(aImport.eResource());
						}
					}
				}

				private IFolder createModelFolder(SubMonitor progress,
						IProject project) throws CoreException {
					//copy the cs definition to the plugin for reuse
					IFolder modelsFolder = project.getFolder("/model");
					if (!modelsFolder.exists()) {
						modelsFolder.create(true, true, progress.newChild(TICKS_CREATE_MODELS_FOLDER));
					} else {
						progress.internalWorked(TICKS_CREATE_MODELS_FOLDER);
					}
					return modelsFolder;
				}
        		
        	};
        	
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
        }
        catch (InvocationTargetException e){
        	e.getTargetException().printStackTrace();
        }
        catch (InterruptedException e){
        	e.printStackTrace();
        }
     }
    
    /**
     * Copies general generator settings to be passed to the resource package generator.
     * 
     * @return a preference mapping
     */
    private static Map<String,Boolean> copyMapFromPreferenceStore(){
    	Map<String,Boolean> preferences = new HashMap<String,Boolean>();
    	IPreferenceStore store = EMFTextEditUIPlugin.getDefault().getPreferenceStore();
    	preferences.put(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME,store.getBoolean(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME));
    	preferences.put(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME,store.getBoolean(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME));
    	return preferences;
    }
    
    
    /**
     * Generate the XML file describing the plugin.
     * 
     * @param cSyntax Concrete syntax model.
     * @param packageName Name of the Java package.
     * @return Generated code.
     */
    private static String generatePluginXml(ConcreteSyntax cSyntax, String packageName) {
        StringBuffer s = new StringBuffer();
        String factoryClassName = cSyntax.getName().substring(0, 1).toUpperCase() + 
        						  cSyntax.getName().substring(1) + "ResourceFactoryImpl";
        
        s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        s.append("<?eclipse version=\"3.2\"?>\n");
        s.append("<plugin>\n");

        //register the generated resource factory
        s.append("   <extension\n");
        s.append("         point=\"org.eclipse.emf.ecore.extension_parser\">\n");
        s.append("      <parser\n");
        s.append("            class=\"" + packageName + "." + factoryClassName + "\"\n");
        s.append("            type=\"" + cSyntax.getName() + "\">\n");
        s.append("      </parser>\n");
        s.append("   </extension>\n\n");
        
        //register the cs file
        s.append("   <extension\n");
        s.append("         point=\"" + EMFTextEditPlugin.EP_CONCRETESYNTAX_ID + "\">\n");
        s.append("      <concretesyntax\n");
        s.append("            uri=\"" + cSyntax.getPackage().getNSURI() + "\"\n");
        s.append("            csName=\"" + cSyntax.getName() + "\"\n");
        s.append("            csDefinition=\"model/" + cSyntax.getName() + ".cs\">\n");
        s.append("      </concretesyntax>\n");
        s.append("   </extension>\n\n");
        
        //registers the file extension for the EMF Text Editor
        s.append("   <extension\n");
        s.append("         point=\"org.eclipse.core.contenttype.contentTypes\">\n");
        s.append("      <file-association\n");
        s.append("            content-type=\"org.reuseware.emftextedit.filetype\"\n");
        s.append("            file-extensions=\""+cSyntax.getName()+ "\">\n");
        s.append("      </file-association>\n");
        s.append("   </extension>\n\n");
        
        if(EMFTextEditUIPlugin.getDefault().getPreferenceStore().getBoolean(EMFTextEditUIPlugin.GENERATE_TEST_ACTION_NAME)){
            String baseId = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getName();
            
            s.append("\t<extension\n");
            s.append("\t\t\tpoint=\"org.eclipse.ui.popupMenus\">\n");
            s.append("\t\t<objectContribution\n");
            s.append("\t\t\t\tid=\""+baseId+".contributions\"\n");
            s.append("\t\t\t\tobjectClass=\"org.eclipse.core.resources.IFile\"\n");
            s.append("\t\t\t\tnameFilter=\"*."+cSyntax.getName()+"\">\n");
            s.append("\t\t\t<action\n");
            s.append("\t\t\t\t\tclass=\"org.reuseware.emftextedit.test.actions.ValidateParserPrinterAction\"\n");
            s.append("\t\t\t\t\tenablesFor=\"1\"\n");
            s.append("\t\t\t\t\tid=\""+baseId+".validate\"\n");
            s.append("\t\t\t\t\tlabel=\"Validate\"\n");
            s.append("\t\t\t\t\tmenubarPath=\"org.reuseware.emftextedit.test.menu1/group1\">\n");
            s.append("\t\t\t</action>\n");
            s.append("\t\t</objectContribution>\n");
            s.append("\t</extension>\n");        	
        }
 
        s.append("</plugin>\n");
      
        return s.toString();
    }

    /**
     * Generate the MANIFEST.MF file for the plugin
     * 
     * @param cSyntax Concrete syntax model.
     * @param packageName Name of the Java package.
     * @return Generated code.
     */
    private static String generateManifestMF(ConcreteSyntax cSyntax, String packageName) {
        StringBuffer s = new StringBuffer();
        
        s.append("Manifest-Version: 1.0\n");
        s.append("Bundle-ManifestVersion: 2\n");
        s.append("Bundle-Name: EMFTextEdit Parser Plugin: " + cSyntax.getName() + "\n");
        s.append("Bundle-SymbolicName: " + packageName + ";singleton:=true\n");
        s.append("Bundle-Version: 1.0.0\n");
        s.append("Bundle-Vendor: Software Engineering Group - TU Dresden Germany\n");
        //s.append("Bundle-Localization: plugin\n");
        s.append("Require-Bundle: org.eclipse.core.runtime,\n");
        s.append("  org.eclipse.emf.ecore,\n");
        s.append("  " + cSyntax.getPackage().getGenModel().getModelPluginID() + ",\n");
        if(EMFTextEditUIPlugin.getDefault().getPreferenceStore().getBoolean(EMFTextEditUIPlugin.GENERATE_TEST_ACTION_NAME)){
            s.append("  org.reuseware.emftextedit.test,\n");	
        }
        EList<GenModel> importedPlugins = new BasicEList<GenModel>();
        for(Import aImport : cSyntax.getImports()) {
        	GenModel m = aImport.getPackage().getGenModel();
        	if (!importedPlugins.contains(m)) {
                s.append("  " + m.getModelPluginID() + ",\n");
        		importedPlugins.add(m);
        	}
        }
        s.append(" org.reuseware.emftextedit\n");
        s.append("Bundle-ActivationPolicy: lazy\n");
        s.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
        // export the generated package
        s.append("Export-Package: " + packageName + "\n");
        
        return s.toString();
    }
    
    private static void generateMetaModelCode(GenPackage genPackage, IProgressMonitor monitor) {
    	monitor.setTaskName("generating metamodel code...");
    	GenModel genModel = genPackage.getGenModel();
		genModel.setCanGenerate(true);

        //generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,  
				new BasicMonitor.EclipseSubProgress(monitor, 100));
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        //this.part = targetPart;
	}
}

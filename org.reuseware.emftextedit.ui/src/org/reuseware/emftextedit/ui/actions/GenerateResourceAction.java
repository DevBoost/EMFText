package org.reuseware.emftextedit.ui.actions;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.HashMap;

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
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
    
	private ISelection selection;
    private IWorkbenchPart part;

    /**
     * Calls {@link #process(IFile)} for all selected <i>cs</i> files .
     */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    if (file.getFileExtension().startsWith("cs")) process(file);
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
        		public void run(IProgressMonitor monitor)throws InvocationTargetException, InterruptedException {
        			try{
        				SubMonitor progress = SubMonitor.convert(monitor, 100);
        				ResourceSet rs = new ResourceSetImpl();
        				Resource csResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
			  
        				MarkerHelper.unmark(csResource);
        				if (!csResource.getErrors().isEmpty()) {
        					MarkerHelper.mark(csResource);
        					return;
        				}
			            
        				final ConcreteSyntax cSyntax = (ConcreteSyntax) csResource.getContents().get(0);
        				String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
        				String projectName = csPackageName;
			    
        				if (projectName == null) 
        					return;
        				
        				//create a project
        				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        				if (!project.exists()) {
        					project.create(progress.newChild(10));
        				}
        				project.open(progress.newChild(10));
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
			             
        				IFolder srcFolder = project.getFolder("/src");
        				IFolder outFolder = project.getFolder("/bin");
			 
        				IJavaProject jp = JavaCore.create(project);
			             
        				jp.setRawClasspath(
        				   new IClasspathEntry [] {
        						JavaCore.newSourceEntry(srcFolder.getFullPath()), 
        						JavaRuntime.getJREVariableEntry(), 
        						JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins"))},
			               outFolder.getFullPath(), progress.newChild(5));
			             
        				//generate the resource class, parser, and printer
        				//generator.generate(absSrcFolderName);
        				ResourcePackage pck = new ResourcePackage(cSyntax,csPackageName,srcFolder,copyMapFromPreferenceStore());
        				ResourcePackageGenerator.generate(pck,progress.newChild(50));
			             
        				//erors from parser generator?
        				if (!csResource.getErrors().isEmpty()) {
        					MarkerHelper.mark(csResource);
        				}
			  
			             
        				IFolder metaFolder = project.getFolder("/META-INF");
        				IFile manifestMFFile = project.getFile("/META-INF/MANIFEST.MF");
        				IFile pluginXMLFile = project.getFile("/plugin.xml");
        				if (!metaFolder.exists()) 
        					metaFolder.create(true, true, progress.newChild(5));
			             
        				if (manifestMFFile.exists()){
        					manifestMFFile.setContents(new ByteArrayInputStream(generateManifestMF(cSyntax, projectName).getBytes()),true,true,progress.newChild(5));
        				}
        				else{
        					manifestMFFile.create(new ByteArrayInputStream(generateManifestMF(cSyntax, projectName).getBytes()),true,progress.newChild(5));            	 
        				}
			             
        				if (pluginXMLFile.exists()){
        					pluginXMLFile.setContents(new ByteArrayInputStream(generatePluginXml(cSyntax, projectName).getBytes()),true,true,progress.newChild(5));
        				}
        				else{
        					pluginXMLFile.create(new ByteArrayInputStream(generatePluginXml(cSyntax, projectName).getBytes()),true,progress.newChild(5));
			 
        				}
        				project.refreshLocal(IProject.DEPTH_INFINITE,progress.newChild(10));
			             
        				//also mark errors on imported concrete syntaxes
        				for(Import aImport : cSyntax.getImports()) {
        					ConcreteSyntax importedCS = aImport.getConcreteSyntax();
        					if (importedCS != null) {
        						MarkerHelper.unmark(importedCS.eResource());
        						MarkerHelper.mark(aImport.eResource());
        					}
        				}
			             
        				//copy the cs definition to the plugin for reuse
        				IFolder modelsFolder = project.getFolder("/model");
        				if (!modelsFolder.exists()) 
        					modelsFolder.create(true, true, progress.newChild(5));
        			     URI csFileURI = URI.createPlatformResourceURI(modelsFolder.getFullPath().append(cSyntax.getName() + ".cs").toString(), true);
        				csResource.setURI(csFileURI);
        			}
			        catch (CoreException e) {
			        	throw new InvocationTargetException(e);
			        }
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
    
    private static HashMap<String,Boolean> copyMapFromPreferenceStore(){
    	HashMap<String,Boolean> preferences = new HashMap<String,Boolean>();
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
        s.append("Bundle-Localization: plugin\n");
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
        s.append("Eclipse-LazyStart: true\n");
        // export the generated package
        s.append("Export-Package: " + packageName + "\n");
        
        return s.toString();
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
        this.part = targetPart;
	}
    

}

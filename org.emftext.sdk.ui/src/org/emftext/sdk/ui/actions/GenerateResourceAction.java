package org.emftext.sdk.ui.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
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
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.sdk.codegen.ManifestGenerator;
import org.emftext.sdk.codegen.PluginXMLGenerator;
import org.emftext.sdk.codegen.ResourcePackage;
import org.emftext.sdk.codegen.ResourcePackageGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.ui.EMFTextEditSDKUIPlugin;

/**
 * An action that calls the generator and in addition generates a
 * <code><plugin.xml</code> and <code>MANIFEST.MF</code> file.
 * 
 * @author jj2
 * 
 */
public class GenerateResourceAction extends AbstractConcreteSyntaxAction
		implements IObjectActionDelegate {

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
			for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i
					.hasNext();) {
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
	 * @param file
	 *            The file that contains the concrete syntax definition.
	 */
	public void process(final IFile file) {
		try {

			IRunnableWithProgress runnable = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						SubMonitor progress = SubMonitor.convert(monitor, 100);
						Resource csResource = getResource(file);

						MarkerHelper.unmark(csResource);
						if (containsProblems(csResource)) {
							MarkerHelper.mark(csResource);
							return;
						}

						final ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource
								.getContents().get(0);
						final String csPackageName = getPackageName(concreteSyntax);
						final String projectName = csPackageName;

						if (projectName == null) {
							return;
						}

						// create a project
						IProject project = createProject(progress, projectName);

						// generate the resource class, parser, and printer
						ResourcePackage pck = new ResourcePackage(
								concreteSyntax, csPackageName,
								getSrcFolder(project),
								copyMapFromPreferenceStore());
						ResourcePackageGenerator.generate(pck, progress
								.newChild(TICKS_GENERATE_RESOURCE));

						// errors from parser generator?
						if (containsProblems(csResource)) {
							MarkerHelper.mark(csResource);
						}

						boolean overridePluginConfig = EMFTextEditSDKUIPlugin
								.getDefault()
								.getPreferenceStore()
								.getBoolean(
										EMFTextEditSDKUIPlugin.OVERRIDE_PLUGIN_CONFIG_NAME);

						createMetaFolder(progress, project);
						createManifest(progress, concreteSyntax, projectName,
								overridePluginConfig, project, pck);
						createPluginXML(progress, concreteSyntax, projectName,
								overridePluginConfig, project, file);

						markErrors(concreteSyntax);

						createMetaModelCode(progress, concreteSyntax);

						project.refreshLocal(IProject.DEPTH_INFINITE, progress
								.newChild(TICKS_REFRESH_PROJECT));
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}

				private String getPackageName(final ConcreteSyntax cSyntax) {
					return (cSyntax.getPackage().getBasePackage() == null ? ""
							: cSyntax.getPackage().getBasePackage() + ".")
							+ cSyntax.getPackage().getEcorePackage().getName()
							+ ".resource." + cSyntax.getName();
				}

			};

			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
					runnable);
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Copies general generator settings to be passed to the resource package
	 * generator.
	 * 
	 * @return a preference mapping
	 */
	private Map<String, Boolean> copyMapFromPreferenceStore() {
		Map<String, Boolean> preferences = new HashMap<String, Boolean>();
		IPreferenceStore store = EMFTextEditSDKUIPlugin.getDefault()
				.getPreferenceStore();
		preferences
				.put(
						ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME,
						store
								.getBoolean(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME));
		preferences
				.put(
						ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME,
						store
								.getBoolean(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME));
		preferences.put(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME, store
				.getBoolean(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME));
		preferences
				.put(
						ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME,
						store
								.getBoolean(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME));
		preferences
				.put(
						ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME,
						store
								.getBoolean(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME));
		preferences
				.put(
						ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME,
						store
								.getBoolean(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME));
		preferences
				.put(
						ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME,
						store
								.getBoolean(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME));
		return preferences;
	}

	private void generateMetaModelCode(GenPackage genPackage,
			IProgressMonitor monitor) {
		monitor.setTaskName("generating metamodel code...");
		
	
		GenModel genModel = genPackage.getGenModel();
		genModel.setCanGenerate(true);

		// generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		generator.generate(genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.EclipseSubProgress(monitor, 100));
	}

	private IProject createProject(SubMonitor progress, String projectName)
			throws CoreException, JavaModelException {
		IJavaProject javaProject = createJavaProject(progress, projectName);
		IProject project = javaProject.getProject();
		setClasspath(javaProject, progress);
		return project;
	}

	private void createMetaModelCode(SubMonitor progress,
			final ConcreteSyntax cSyntax) {
		// do not generate code for genmodels imported from deployed plugins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (EMFTextEditSDKUIPlugin.getDefault().getPreferenceStore().getBoolean(
				EMFTextEditSDKUIPlugin.GENERATE_GEN_MODEL)) {
			generateMetaModelCode(cSyntax.getPackage(), progress
					.newChild(TICKS_GENERATE_METAMODEL_CODE));
		} else {
			progress.internalWorked(TICKS_GENERATE_METAMODEL_CODE);
		}
	}

	private IJavaProject createJavaProject(SubMonitor progress,
			String projectName) throws CoreException, JavaModelException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectName);
		if (!project.exists()) {
			project.create(progress.newChild(TICKS_CREATE_PROJECT));
		} else {
			progress.internalWorked(TICKS_CREATE_PROJECT);
		}
		project.open(progress.newChild(TICKS_OPEN_PROJECT));
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				"org.eclipse.pde.PluginNature" });
		ICommand command1 = description.newCommand();
		command1.setBuilderName("org.eclipse.jdt.core.javabuilder");
		ICommand command2 = description.newCommand();
		command2.setBuilderName("org.eclipse.pde.ManifestBuilder");
		ICommand command3 = description.newCommand();
		command3.setBuilderName("org.eclipse.pde.SchemaBuilder");
		description
				.setBuildSpec(new ICommand[] { command1, command2, command3 });
		project.setDescription(description, null);

		IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}

	private IFolder getSrcFolder(IProject project) {
		return project.getFolder("/src");
	}

	private IFolder getOutFolder(IProject project) {
		return project.getFolder("/bin");
	}

	private void setClasspath(IJavaProject javaProject, SubMonitor progress)
			throws JavaModelException {
		IFolder srcFolder = getSrcFolder(javaProject.getProject());
		IFolder outFolder = getOutFolder(javaProject.getProject());
		javaProject.setRawClasspath(new IClasspathEntry[] {
				JavaCore.newSourceEntry(srcFolder.getFullPath()),
				JavaRuntime.getJREVariableEntry(),
				JavaCore.newContainerEntry(new Path(
						"org.eclipse.pde.core.requiredPlugins")) }, outFolder
				.getFullPath(), progress.newChild(TICKS_SET_CLASSPATH));
	}

	private void createMetaFolder(SubMonitor progress, IProject project)
			throws CoreException {
		IFolder metaFolder = project.getFolder("/META-INF");
		if (!metaFolder.exists()) {
			metaFolder.create(true, true, progress
					.newChild(TICKS_CREATE_META_FOLDER));
		} else {
			progress.internalWorked(TICKS_CREATE_META_FOLDER);
		}
	}

	private void createManifest(SubMonitor progress,
			final ConcreteSyntax cSyntax, String projectName,
			boolean overridePluginConfig, IProject project,
			ResourcePackage resourcePackage) throws CoreException {
		IFile manifestMFFile = project.getFile("/META-INF/MANIFEST.MF");
		if (manifestMFFile.exists()) {
			if (overridePluginConfig) {
				ManifestGenerator mGenerator = new ManifestGenerator(cSyntax, projectName, resourcePackage, isGenerateTestActionEnabled());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				mGenerator.generate(new PrintWriter(outputStream));
				manifestMFFile.setContents(new ByteArrayInputStream(
						outputStream.toByteArray()), true, true,
						progress.newChild(TICKS_CREATE_MANIFEST));
			} else {
				progress.internalWorked(TICKS_CREATE_MANIFEST);
			}
		} else {
			ManifestGenerator mGenerator = new ManifestGenerator(cSyntax, projectName, resourcePackage, isGenerateTestActionEnabled());
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			mGenerator.generate(new PrintWriter(outputStream));
			manifestMFFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true,
					progress.newChild(TICKS_CREATE_MANIFEST));
		}
	}

	private void createPluginXML(SubMonitor progress,
			final ConcreteSyntax cSyntax, String projectName,
			boolean overridePluginConfig, IProject project, IFile file)
			throws CoreException {
		IFile pluginXMLFile = project.getFile("/plugin.xml");
		if (pluginXMLFile.exists()) {
			if (overridePluginConfig) {
				PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(
						cSyntax, projectName, file,
						isGenerateTestActionEnabled()
				);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				pluginXMLGenerator.generate(new PrintWriter(outputStream));
				pluginXMLFile.setContents(new ByteArrayInputStream(
						outputStream.toByteArray()), true, true, progress
						.newChild(TICKS_CREATE_PLUGIN_XML));
			} else {
				progress.internalWorked(TICKS_CREATE_PLUGIN_XML);
			}
		} else {
			PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(
					cSyntax, projectName, file,
					isGenerateTestActionEnabled()
			);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			pluginXMLGenerator.generate(new PrintWriter(outputStream));
			pluginXMLFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true, progress
					.newChild(TICKS_CREATE_PLUGIN_XML));
		}
	}

	private boolean isGenerateTestActionEnabled() {
		return EMFTextEditSDKUIPlugin.getDefault().getPreferenceStore().getBoolean(
				EMFTextEditSDKUIPlugin.GENERATE_TEST_ACTION_NAME);
	}

	private void markErrors(final ConcreteSyntax cSyntax) throws CoreException {
		// also mark errors on imported concrete syntaxes
		for (Import aImport : cSyntax.getImports()) {
			ConcreteSyntax importedCS = aImport.getConcreteSyntax();
			if (importedCS != null) {
				MarkerHelper.unmark(importedCS.eResource());
				MarkerHelper.mark(aImport.eResource());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.
	 * action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// this.part = targetPart;
	}
}

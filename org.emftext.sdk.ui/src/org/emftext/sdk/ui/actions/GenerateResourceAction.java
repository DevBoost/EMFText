package org.emftext.sdk.ui.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.ManifestGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.PluginXMLGenerator;
import org.emftext.sdk.codegen.PutEverywhereSyntaxExtender;
import org.emftext.sdk.codegen.ResourceGenerationContext;
import org.emftext.sdk.codegen.ResourcePackageGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

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
						ResourceGenerationContext context = new ResourceGenerationContext(concreteSyntax);

						new PutEverywhereSyntaxExtender().generatePutEverywhereExtensions(context.getConcreteSyntax());

						// create a project
						createProject(context, progress);

						// generate the resource class, parser, and printer
						ResourcePackageGenerator.generate(context, progress
								.newChild(TICKS_GENERATE_RESOURCE));

						// errors from parser generator?
						if (containsProblems(csResource)) {
							MarkerHelper.mark(csResource);
						}

						createMetaFolder(context, progress);
						createManifest(context, progress);
						createPluginXML(context, progress, file);

						markErrors(context.getConcreteSyntax());

						createMetaModelCode(context, progress);

						context.getProject().refreshLocal(IProject.DEPTH_INFINITE, progress
								.newChild(TICKS_REFRESH_PROJECT));
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
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

	private void createProject(ResourceGenerationContext context, SubMonitor progress)
			throws CoreException, JavaModelException {
		String projectName = context.getPackageName();
		IJavaProject javaProject = createJavaProject(progress, projectName);
		context.setJavaProject(javaProject);
		setClasspath(context, progress);
	}

	private void createMetaModelCode(ResourceGenerationContext context, SubMonitor progress) {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		
		// do not generate code for genmodels imported from deployed plugins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (OptionManager.INSTANCE.getBooleanOption(cSyntax, ICodeGenOptions.GENERATE_CODE_FROM_GENERATOR_MODEL)) {
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

	private void setClasspath(ResourceGenerationContext context, SubMonitor progress)
			throws JavaModelException {
		IFolder srcFolder = context.getTargetFolder();
		IFolder outFolder = context.getOutputFolder();
		context.getJavaProject().setRawClasspath(new IClasspathEntry[] {
				JavaCore.newSourceEntry(srcFolder.getFullPath()),
				JavaCore.newContainerEntry(new Path(JavaRuntime.JRE_CONTAINER)),
				JavaCore.newContainerEntry(new Path(
						"org.eclipse.pde.core.requiredPlugins")) }, outFolder
				.getFullPath(), progress.newChild(TICKS_SET_CLASSPATH));
	}

	private void createMetaFolder(ResourceGenerationContext context, SubMonitor progress)
			throws CoreException {
		IProject project = context.getProject();
		IFolder metaFolder = project.getFolder("/META-INF");
		if (!metaFolder.exists()) {
			metaFolder.create(true, true, progress
					.newChild(TICKS_CREATE_META_FOLDER));
		} else {
			progress.internalWorked(TICKS_CREATE_META_FOLDER);
		}
	}

	private void createManifest(ResourceGenerationContext context,
			SubMonitor progress) throws CoreException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		IProject project = context.getProject();
		String projectName = project.getName();

		boolean overrideManifest = OptionManager.INSTANCE.getBooleanOption(cSyntax, ICodeGenOptions.OVERRIDE_MANIFEST);

		IFile manifestMFFile = project.getFile("/META-INF/MANIFEST.MF");
		if (manifestMFFile.exists()) {
			if (overrideManifest) {
				ManifestGenerator mGenerator = new ManifestGenerator(cSyntax, projectName, context, isGenerateTestActionEnabled(cSyntax));
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				mGenerator.generate(new PrintWriter(outputStream));
				manifestMFFile.setContents(new ByteArrayInputStream(
						outputStream.toByteArray()), true, true,
						progress.newChild(TICKS_CREATE_MANIFEST));
			} else {
				progress.internalWorked(TICKS_CREATE_MANIFEST);
			}
		} else {
			ManifestGenerator manifestGenerator = new ManifestGenerator(cSyntax, projectName, context, isGenerateTestActionEnabled(cSyntax));
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			manifestGenerator.generate(new PrintWriter(outputStream));
			manifestMFFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true,
					progress.newChild(TICKS_CREATE_MANIFEST));
		}
	}

	private void createPluginXML(ResourceGenerationContext context, SubMonitor progress,
			IFile file)
			throws CoreException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		IProject project = context.getProject(); 
		String projectName = project.getName();
		
		boolean overridePluginXML = OptionManager.INSTANCE.getBooleanOption(cSyntax, ICodeGenOptions.OVERRIDE_PLUGIN_XML);
		
		IFile pluginXMLFile = project.getFile("/plugin.xml");
		if (pluginXMLFile.exists()) {
			if (overridePluginXML) {
				PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(
						cSyntax, projectName, file,
						isGenerateTestActionEnabled(cSyntax)
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
					isGenerateTestActionEnabled(cSyntax)
			);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			pluginXMLGenerator.generate(new PrintWriter(outputStream));
			pluginXMLFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true, progress
					.newChild(TICKS_CREATE_PLUGIN_XML));
		}
	}

	private boolean isGenerateTestActionEnabled(ConcreteSyntax syntax) {
		return OptionManager.INSTANCE.getBooleanOption(syntax, ICodeGenOptions.GENERATE_TEST_ACTION);
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

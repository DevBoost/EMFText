package org.emftext.sdk.ui.jobs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.codegen.generators.PluginXMLGenerator;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.ui.EMFTextSDKUIPlugin;

/**
 * An eclipse job that generates a resource plug-in from a
 * CS specification and a meta model.
 */
public class GenerateResourcePluginJob extends AbstractConcreteSyntaxJob {

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
	
	private final IFile csFile;

	public GenerateResourcePluginJob(String name, IFile csFile) {
		super(name);
		this.csFile = csFile;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			SubMonitor progress = SubMonitor.convert(monitor, 100);
			final ITextResource csResource = getResource(csFile);

			MarkerHelper.unmark(csResource);
			if (containsErrors(csResource)) {
				MarkerHelper.mark(csResource);
				return Status.OK_STATUS;
			}

			final ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource
					.getContents().get(0);
			
			IProblemCollector collector = new IProblemCollector() {

				public void addProblem(GenerationProblem problem) {
					addGenerationProblem(csResource, problem);
				}
			};
			if (checkAbstract(concreteSyntax)) {
				return Status.OK_STATUS;
			}
			
			GenerationContext context = new GenerationContext(concreteSyntax, collector);
			// create a project
			createProject(context, progress);

			// generate the resource class, parser, and printer
			ResourcePluginGenerator pluginGenerator = new ResourcePluginGenerator();
			pluginGenerator.generate(context, progress
					.newChild(TICKS_GENERATE_RESOURCE));

			// errors from parser generator?
			if (containsProblems(csResource)) {
				MarkerHelper.mark(csResource);
			}

			createMetaFolder(context, progress);
			createManifest(context, progress);
			createPluginXML(context, progress);

			markErrors(context.getConcreteSyntax());

			createMetaModelCode(context, progress);

			context.getProject().refreshLocal(IProject.DEPTH_INFINITE, progress
					.newChild(TICKS_REFRESH_PROJECT));
		} catch (CoreException e) {
			EMFTextRuntimePlugin.logError("Exception while generating resource plug-in.", e);
			return new Status(Status.ERROR, EMFTextSDKUIPlugin.PLUGIN_ID, CoreException.class.getSimpleName(), new InvocationTargetException(e));
		}
		return Status.OK_STATUS;
	}

	private boolean checkAbstract(final ConcreteSyntax concreteSyntax) {
		if (concreteSyntax.getModifier() != null) {
			// show error message, because we can not generate plug-ins for
			// abstract syntaxes
			EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Abstract syntax", "Can't generate resource plug-in for abstract syntax definition.");
			return true;
		}
		return false;
	}

	private static void addGenerationProblem(ITextResource csResource,
			GenerationProblem problem) {
		if(problem.getSeverity() == GenerationProblem.Severity.WARNING){
			csResource.addWarning(problem.getMessage(),problem.getCause());
		}
		else{
			csResource.addError(problem.getMessage(),problem.getCause());
			
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

	private void createProject(GenerationContext context, SubMonitor progress)
			throws CoreException, JavaModelException {
		String projectName = context.getPackageName();
		IJavaProject javaProject = createJavaProject(progress, projectName);
		context.setJavaProject(javaProject);
		setClasspath(context, progress);
	}

	private void createMetaModelCode(GenerationContext context, SubMonitor progress) {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		
		// do not generate code for genmodels imported from deployed plugins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.GENERATE_CODE_FROM_GENERATOR_MODEL)) {
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

	private void setClasspath(GenerationContext context, SubMonitor progress)
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

	private void createMetaFolder(GenerationContext context, SubMonitor progress)
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

	private void createManifest(GenerationContext context,
			SubMonitor progress) throws CoreException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		final IProject project = context.getProject();

		boolean overrideManifest = OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.OVERRIDE_MANIFEST);

		IFile manifestMFFile = project.getFile("/META-INF/MANIFEST.MF");
		if (manifestMFFile.exists()) {
			if (overrideManifest) {
				InputStream stream = generateManifest(context);
				manifestMFFile.setContents(stream, true, true, progress.newChild(TICKS_CREATE_MANIFEST));
			} else {
				progress.internalWorked(TICKS_CREATE_MANIFEST);
			}
		} else {
			InputStream stream = generateManifest(context);
			manifestMFFile.create(stream, true, progress.newChild(TICKS_CREATE_MANIFEST));
		}
	}

	private InputStream generateManifest(GenerationContext context) {
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		ManifestGenerator mGenerator = new ManifestGenerator(context, isGenerateTestActionEnabled(cSyntax));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		mGenerator.generate(new PrintWriter(outputStream));
		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	private void createPluginXML(GenerationContext context, SubMonitor progress)
			throws CoreException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		IProject project = context.getProject();
		
		boolean overridePluginXML = OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.OVERRIDE_PLUGIN_XML);
		
		IFile pluginXMLFile = project.getFile("/plugin.xml");
		if (pluginXMLFile.exists()) {
			if (overridePluginXML) {
				PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(context,
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
			PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(context,
					isGenerateTestActionEnabled(cSyntax)
			);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			pluginXMLGenerator.generate(new PrintWriter(outputStream));
			pluginXMLFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true, progress
					.newChild(TICKS_CREATE_PLUGIN_XML));
		}
	}

	private boolean isGenerateTestActionEnabled(ConcreteSyntax syntax) {
		return OptionManager.INSTANCE.getBooleanOptionValue(syntax, ICodeGenOptions.GENERATE_TEST_ACTION);
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
}

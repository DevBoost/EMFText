package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;

public class DotProjectGenerator extends BaseGenerator {

	private GenerationContext context;

	public DotProjectGenerator(GenerationContext context) {
		super("", ".project");
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<projectDescription>");
		sc.add("<name>" + context.getPluginName() + "</name>");
		sc.add("<comment></comment>");
		sc.add("<projects>");
		sc.add("</projects>");
		sc.add("<buildSpec>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.jdt.core.javabuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.pde.ManifestBuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.pde.SchemaBuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("</buildSpec>");
		sc.add("<natures>");
		sc.add("<nature>org.eclipse.jdt.core.javanature</nature>");
		sc.add("<nature>org.eclipse.pde.PluginNature</nature>");
		sc.add("</natures>");
		sc.add("</projectDescription>");
		
		out.write(sc.toString());
		return true;
	}
	
	/*
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
		description.setBuildSpec(new ICommand[] { command1, command2, command3 });
		project.setDescription(description, null);

		IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}
	*/
}

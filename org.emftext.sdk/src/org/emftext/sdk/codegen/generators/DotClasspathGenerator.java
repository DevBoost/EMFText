package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;

public class DotClasspathGenerator extends BaseGenerator {

	public DotClasspathGenerator(GenerationContext context) {
		super("", ".project");
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<classpath>");
		sc.add("<classpathentry kind=\"src\" path=\"src\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
		sc.add("<classpathentry kind=\"output\" path=\"bin\"/>");
		sc.add("</classpath>");
		
		out.write(sc.toString());
		return true;
	}

	/*
	private void setClasspath(GenerationContext context, SubMonitor progress)
	throws JavaModelException {
	
	UIGenerationContext uiContext = (UIGenerationContext) context;

	IWorkspace workspace = ResourcesPlugin.getWorkspace();
	IWorkspaceRoot root = workspace.getRoot();
	
	IPath srcLocation= Path.fromOSString(context.getSourceFolder().getAbsolutePath());
	IFile[] srcFolders = root.findFilesForLocation(srcLocation);
	IFile srcFolder = srcFolders[0];
	
	IPath outLocation= Path.fromOSString(context.getOutputFolder().getAbsolutePath());
	IFile[] outFolders = root.findFilesForLocation(outLocation);
	IFile outFolder = outFolders[0];
	
	uiContext.getJavaProject().setRawClasspath(new IClasspathEntry[] {
			JavaCore.newSourceEntry(srcFolder.getFullPath()),
			JavaCore.newContainerEntry(new Path(JavaRuntime.JRE_CONTAINER)),
			JavaCore.newContainerEntry(new Path(
					"org.eclipse.pde.core.requiredPlugins")) }, outFolder
			.getFullPath(), progress.newChild(TICKS_SET_CLASSPATH));
	}
	*/
}

package org.emftext.sdk.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator;

/**
 * A custom task for the ANT build tool that generates
 * a resource plug-in for a given syntax specification. 
 */
public class GenerateTextResourceTask extends Task {

	private File syntaxFile;

	@Override
	public void execute() throws BuildException {
		IFile csFile = null;
		try {
			new ResourcePluginGenerator().run(csFile, new DevNullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSyntax(File syntaxFile) {
		this.syntaxFile = syntaxFile;
	}
}

package org.emftext.sdk.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * A custom task for the ANT build tool that generates
 * a resource plug-in for a given syntax specification. 
 */
public class GenerateTextResourceTask extends Task {

	private File syntaxFile;

	@Override
	public void execute() throws BuildException {
		// TODO call generators for resource plug-in
	}
	
	public void setSyntax(File syntaxFile) {
		this.syntaxFile = syntaxFile;
	}
}

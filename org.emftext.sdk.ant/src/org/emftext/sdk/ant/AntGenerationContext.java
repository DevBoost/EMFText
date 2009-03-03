package org.emftext.sdk.ant;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class implements a custom GenerationContext that is slightly
 * different from the GenerationContext used when generating text
 * resource plug-in in Eclipse.
 */
public class AntGenerationContext extends GenerationContext {

	private File workspaceRootFolder;
	private String syntaxProjectName;

	public AntGenerationContext(
			ConcreteSyntax concreteSyntax,
			File workspaceRootFolder,
			String syntaxProjectName,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
		this.workspaceRootFolder = workspaceRootFolder;
		this.syntaxProjectName = syntaxProjectName;
	}

	public File getPluginProjectFolder() {
		return new File(workspaceRootFolder.getAbsolutePath() + File.separator + getPluginName());
	}

	@Override
	public String getSyntaxProjectName() {
		return syntaxProjectName;
	}

	@Override
	public String getSyntaxProjectRelativePath() {
		return getConcreteSyntaxFile().getAbsolutePath().substring(syntaxProjectName.length());
	}
}

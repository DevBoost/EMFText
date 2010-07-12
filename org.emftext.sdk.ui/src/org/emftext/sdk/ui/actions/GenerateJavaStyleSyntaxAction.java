package org.emftext.sdk.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.sdk.ui.jobs.JavaStyleGenerationProcess;

public class GenerateJavaStyleSyntaxAction extends AbstractGenerateSyntaxAction {
    
	@Override
	public String getSyntaxName() {
		return "Java-like Syntax";
	}

	@Override
	public IRunnableWithProgress createGenerationProcess(IFile file) {
		return new JavaStyleGenerationProcess(file);
	}
}

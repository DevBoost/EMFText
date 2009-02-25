package org.emftext.sdk.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator.Result;
import org.emftext.sdk.ui.EMFTextSDKUIPlugin;

/**
 * An eclipse job that generates a resource plug-in from a
 * CS specification and a meta model.
 */
public class GenerateResourcePluginJob extends AbstractConcreteSyntaxJob {

	private final IFile csFile;

	public GenerateResourcePluginJob(String name, IFile csFile) {
		super(name);
		this.csFile = csFile;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			Result result = new ResourcePluginGenerator().run(csFile, monitor);
			switch (result) {
			case ERROR_ABSTRACT_SYNTAX :  {
				// show error message, because we can not generate plug-ins for
				// abstract syntaxes
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Abstract syntax", "Can't generate resource plug-in for abstract syntax definition.");
				break;
			}
			case ERROR_SYNTAX_HAS_ERRORS :  {
				// show error message, because we can not generate plug-ins for
				// abstract syntaxes
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Errors in syntax", "Can't generate resource plug-in, because the syntax definition contains errors.");
				break;
			}
			case SUCCESS :  {
				return Status.OK_STATUS;
			}
			}
		} catch (CoreException e) {
			EMFTextRuntimePlugin.logError("Exception while generating resource plug-in.", e);
			return new Status(Status.ERROR, EMFTextSDKUIPlugin.PLUGIN_ID, CoreException.class.getSimpleName(), new InvocationTargetException(e));
		}
		return Status.OK_STATUS;
	}
}

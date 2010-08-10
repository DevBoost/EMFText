/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.CreateResourcePluginsJob.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsTextResourceUtil;
import org.emftext.sdk.ui.EMFTextSDKUIPlugin;

/**
 * An Eclipse job that generates resource plug-ins from a
 * CS specification and a meta model.
 */
public class GenerateResourcePluginsJob extends AbstractConcreteSyntaxJob {

	private final IFile csFile;

	public GenerateResourcePluginsJob(String name, IFile csFile) {
		super(name);
		this.csFile = csFile;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {

		try {
			final CsResource csResource = CsTextResourceUtil.getResource(csFile);
			IProblemCollector problemCollector = new IProblemCollector() {
				public void addProblem(GenerationProblem problem) {
					addGenerationProblem(csResource, problem);
				}
			};
			final ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
			GenerationContext context = new UIGenerationContext(new WorkspaceConnector(), problemCollector, concreteSyntax);
			
			Result result = new UICreateResourcePluginsJob().run(context, new WorkspaceMarker(), monitor);
			switch (result) {
			case ERROR_ABSTRACT_SYNTAX :  {
				// show error message, because we can not generate plug-ins for
				// abstract syntaxes
				CsUIPlugin.showErrorDialog("Abstract syntax", "Can't generate resource plug-ins for abstract syntax definition.");
				break;
			}
			case ERROR_SYNTAX_HAS_ERRORS :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes with errors
				CsUIPlugin.showErrorDialog("Errors in syntax", "Can't generate resource plug-ins, because the syntax definition contains errors.");
				break;
			}
			case ERROR_FOUND_UNRESOLVED_PROXIES :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes dangling references
				CsUIPlugin.showErrorDialog("Errors in syntax", "Can't generate resource plug-ins, because the syntax definition contains references that can not be resolved.");
				break;
			}
			case ERROR_GEN_PACKAGE_NOT_FOUND :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes with missing generator packages
				CsUIPlugin.showErrorDialog("Errors in syntax", "Can't generate resource plug-ins. A generator package was not found.");
				break;
			}
			case SUCCESS :  {
				return Status.OK_STATUS;
			}
			}
		} catch (Exception e) {
			EMFTextSDKPlugin.logError("Exception while generating resource plug-ins.", e);
			return new Status(Status.ERROR, EMFTextSDKUIPlugin.PLUGIN_ID, CoreException.class.getSimpleName(), new InvocationTargetException(e));
		}
		return Status.OK_STATUS;
	}

	private static void addGenerationProblem(CsResource csResource,
			GenerationProblem problem) {
		if (problem.getSeverity() == GenerationProblem.Severity.WARNING) {
			csResource.addProblem(new CsProblem(problem.getMessage(), ECsProblemType.GENERATION_WARNING), problem.getCause());
		} else {
			csResource.addProblem(new CsProblem(problem.getMessage(), ECsProblemType.GENERATION_ERROR), problem.getCause());
		}
	}
}

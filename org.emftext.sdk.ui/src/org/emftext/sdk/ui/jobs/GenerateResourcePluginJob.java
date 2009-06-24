/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.util.TextResourceUtil;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.syntax_analysis.CsProblem;
import org.emftext.sdk.syntax_analysis.ECsProblemType;
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
			final ITextResource csResource = TextResourceUtil.getResource(csFile);
			IProblemCollector collector = new IProblemCollector() {
				public void addProblem(GenerationProblem problem) {
					addGenerationProblem(csResource, problem);
				}
			};
			final ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
			GenerationContext context = new UIGenerationContext(concreteSyntax, collector);
			
			Result result = new UIResourcePluginGenerator().run(concreteSyntax, context, new WorkspaceMarker(), monitor);
			switch (result) {
			case ERROR_ABSTRACT_SYNTAX :  {
				// show error message, because we can not generate plug-ins for
				// abstract syntaxes
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Abstract syntax", "Can't generate resource plug-in for abstract syntax definition.");
				break;
			}
			case ERROR_SYNTAX_HAS_ERRORS :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes with errors
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Errors in syntax", "Can't generate resource plug-in, because the syntax definition contains errors.");
				break;
			}
			case ERROR_FOUND_UNRESOLVED_PROXIES :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes dangling references
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Errors in syntax", "Can't generate resource plug-in, because the syntax definition contains references that can not be resolved.");
				break;
			}
			case ERROR_GEN_PACKAGE_NOT_FOUND :  {
				// show error message, because we can not generate plug-ins for
				// syntaxes with missing generator packages
				EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("Errors in syntax", "Can't generate resource plug-in. A generator package was not found.");
				break;
			}
			case SUCCESS :  {
				return Status.OK_STATUS;
			}
			}
		} catch (Exception e) {
			EMFTextRuntimePlugin.logError("Exception while generating resource plug-in.", e);
			return new Status(Status.ERROR, EMFTextSDKUIPlugin.PLUGIN_ID, CoreException.class.getSimpleName(), new InvocationTargetException(e));
		}
		return Status.OK_STATUS;
	}

	private static void addGenerationProblem(ITextResource csResource,
			GenerationProblem problem) {
		if (problem.getSeverity() == GenerationProblem.Severity.WARNING) {
			csResource.addProblem(new CsProblem(problem.getMessage(), ECsProblemType.GENERATION_WARNING), problem.getCause());
		} else {
			csResource.addProblem(new CsProblem(problem.getMessage(), ECsProblemType.GENERATION_ERROR), problem.getCause());
		}
	}
}

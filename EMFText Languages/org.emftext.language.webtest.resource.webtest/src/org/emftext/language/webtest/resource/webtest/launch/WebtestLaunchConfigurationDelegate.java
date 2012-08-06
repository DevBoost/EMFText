/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.webtest.resource.webtest.launch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.webtest.resource.webtest.interpreter.IWebtestFailureHandler;
import org.emftext.language.webtest.resource.webtest.interpreter.WebtestContext;
import org.emftext.language.webtest.resource.webtest.interpreter.WebtestInterpreter;

/**
 * A class that handles launch configurations.
 */
public class WebtestLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		WebtestLaunchConfigurationHelper helper = new WebtestLaunchConfigurationHelper();
		WebtestInterpreter interpreter = new WebtestInterpreter();
		EObject root = helper.getModelRoot(configuration);
		interpreter.addObjectTreeToInterpreteTopDown(root);
		IWebtestFailureHandler failureHandler = new IWebtestFailureHandler() {
			
			public void handleFailedAssertion(String message, String expected, String actual) {
				System.out.println("handleFailedAssertion(" + message + ")");
			}
		};
		WebtestContext context = new WebtestContext(failureHandler);
		helper.launchInterpreter(configuration, mode, launch, monitor, interpreter, context);
	}
	
}

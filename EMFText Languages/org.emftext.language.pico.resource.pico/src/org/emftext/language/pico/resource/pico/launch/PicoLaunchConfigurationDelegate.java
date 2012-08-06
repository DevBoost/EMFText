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
package org.emftext.language.pico.resource.pico.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpretationContext;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpreter;

/**
 * A class that handles launch configurations.
 */
public class PicoLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		PicoLaunchConfigurationHelper helper = new PicoLaunchConfigurationHelper();
		PicoInterpreter interpreter = new PicoInterpreter();
		PicoInterpretationContext context = new PicoInterpretationContext();
		EObject modelRoot = helper.getModelRoot(configuration);
		interpreter.addObjectToInterprete(modelRoot);
		helper.launchInterpreter(configuration, mode, launch, monitor, interpreter, context);
	}
}

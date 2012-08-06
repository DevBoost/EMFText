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
package org.emftext.language.simplemath.resource.sm.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.emftext.language.simplemath.Expression;

/**
 * An example class that shows how to implement launch configurations.
 */
public class SmLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		SmLaunchConfigurationHelper helper = new SmLaunchConfigurationHelper();
		Expression modelRoot = (Expression) helper.getModelRoot(configuration);
		final String message = "The value of the expression is " + modelRoot.getValue() + ".";
		// show a message box
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
		        MessageBox mb = new MessageBox(Display.getCurrent().getActiveShell(), SWT.NONE);
		        mb.setText("SimpleMath expression");
		        mb.setMessage(message);
		        mb.open();
			}
		});
	}
}

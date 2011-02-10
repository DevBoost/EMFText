/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.sdk.ui.jobs.HUTNGenerationProcess;


/**
 * An action that generates a HUTN based concrete syntax for the given generator
 * model.
 */
public class GenerateHUTNAction extends AbstractGenerateSyntaxAction {

	@Override
	public String getSyntaxName() {
		return "HUTN Syntax";
	}

	@Override
	public IRunnableWithProgress createGenerationProcess(IFile file) {
		return new HUTNGenerationProcess(file);
	}
}

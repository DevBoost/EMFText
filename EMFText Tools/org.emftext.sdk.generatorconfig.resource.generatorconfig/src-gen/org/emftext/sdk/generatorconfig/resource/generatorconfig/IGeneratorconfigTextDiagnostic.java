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
package org.emftext.sdk.generatorconfig.resource.generatorconfig;

// An extended diagnostic that gives access to the exact position of the problem
// in a character stream.
public interface IGeneratorconfigTextDiagnostic extends org.eclipse.emf.ecore.resource.Resource.Diagnostic {

	// @return Position of the first character of the problem area.
	public int getCharStart();

	// @return Position of the last character of the problem area.
	public int getCharEnd();

	// @return The column of the problem area.
	public int getColumn();

	// @return The line that contains the problem area.
	public int getLine();

	// Returns the problem that was found.
	//
	// @return
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem getProblem();

	// Checks whether the problem was caused by the given element.
	public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element);
}

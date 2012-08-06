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
package org.emftext.language.formsextension.example;

/**
 * This example class is automatically extended by a call to the
 * forms interpreter.
 */
public class Example1GUI {
	
	public void showForm() throws Exception {
	new org.emftext.language.forms.interpreter.FormInterpreter ( ).interprete ( "src/org/emftext/language/formsextension/example/Example1.formsextension" ) ;
	}
}

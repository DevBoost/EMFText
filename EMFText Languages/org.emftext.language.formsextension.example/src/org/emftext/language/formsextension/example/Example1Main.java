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

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.formsextension.resource.formsextension.mopp.FormsextensionResourceFactory;

/**
 * This example class is automatically extended by a call to the
 * forms interpreter.
 */
public class Example1Main {
	
	public static void main(String[] args) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"formsextension",
				new FormsextensionResourceFactory());

		Example1GUI example1 = new Example1GUI();
		try {
			example1.showForm(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

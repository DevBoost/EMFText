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
package org.emftext.language.java.sqljava.resource.sqljava.mopp.helper;

import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;

public class ReferenceHelper {

	public static StringReference getNewStringReference(String value){
		
		StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
		stringReference.setValue(value);
		return stringReference;
	}
	
	public static IdentifierReference getNewIdentifierReference(ReferenceableElement element){
		
		IdentifierReference identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
		identifierReference.setTarget(element);
		return identifierReference;
	}
}

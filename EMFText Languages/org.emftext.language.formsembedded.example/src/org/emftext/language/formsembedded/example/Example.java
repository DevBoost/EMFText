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
package org.emftext.language.formsembedded.example;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.interpreter.FormInterpreter;
import org.emftext.language.forms.resource.forms.mopp.FormsResourceFactory;
import java.util.List;


public class Example {
	public static void main (String [] args) {
	Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap ( ).put ( "forms" , new FormsResourceFactory ( ) ) ;
	URIConverter.URI_MAP.put ( URI.createURI ( "platform:/resource/" ) , URI.createURI ( "../" ) ) ;
	new Example ( ).printAndShowForm ( ) ;
}
	public void printAndShowForm () {
	Form f = ( org.emftext.language.forms.Form ) new org.emftext.language.forms.interpreter.FormInterpreter ( ).load ( "platform:/resource/org.emftext.language.formsembedded.example/src/org/emftext/language/formsembedded/example/Test.formsembedded.forms" ) ;
	new FormInterpreter ( ).interprete ( f ) ;
	List < Group > groups = f.getGroups ( ) ;
	for ( Group next : groups ) {
		System.out.println ( "Group: " + next ) ;
	}
}
}

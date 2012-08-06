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
package org.emftext.language.java.jtemplates.test;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.customer.resource.customer.mopp.CustomerMetaInformation;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateMetaInformation;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateResourceFactory;
import org.emftext.language.java.resource.java.mopp.JavaMetaInformation;
import org.emftext.language.templateconcepts.interpreter.test.AbstractInterpreterTestCase;

public class JavaTemplateInterpreterTest extends AbstractInterpreterTestCase {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("test1.javatemplate", "test1.customer", "public class T1 { }");
		testInterpretation("test2.javatemplate", "test2.customer", "public class T1 { public int cheese ; public int cucumbers ; }");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new JavaMetaInformation().getSyntaxName(),
				new org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new JavatemplateMetaInformation().getSyntaxName(),
				new JavatemplateResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new CustomerMetaInformation().getSyntaxName(),
				new org.emftext.language.customer.resource.customer.mopp.CustomerResourceFactory());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}

	@Override
	protected String getOutputFileExtension() {
		return "java";
	}
}

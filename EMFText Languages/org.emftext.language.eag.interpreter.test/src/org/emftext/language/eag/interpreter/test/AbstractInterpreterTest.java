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
package org.emftext.language.eag.interpreter.test;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.interpreter.Interpreter;
import org.emftext.language.eag.interpreter.InterpreterFactory;
import org.emftext.language.eag.resource.eag.mopp.EagMetaInformation;
import org.emftext.language.eag.resource.eag.mopp.EagResourceFactory;
import org.emftext.language.pl0.attributes.AttributesPackage;
import org.junit.Before;

public abstract class AbstractInterpreterTest extends TestCase {

	private static final String EAG_FILE_EXTENSION = new EagMetaInformation().getSyntaxName();

	protected ResourceSet rs;
	
	@Before
	public void setUp() throws Exception {
		// register resource factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				EAG_FILE_EXTENSION,
				new EagResourceFactory());
		
		EPackage.Registry.INSTANCE.put(AttributesPackage.eINSTANCE.getNsURI(), AttributesPackage.eINSTANCE);
		EcorePackage.eINSTANCE.getEAnnotation();
		rs = new ResourceSetImpl();
	}

	public void assertInterpretation(Object expected, EObject root,
			AttributeGrammar grammar, String attributeName) {
		Object result = interpret(root, grammar, attributeName);
		assertEquals(expected, result);
	}

	public Object interpret(EObject root, AttributeGrammar grammar,
			String attributeName) {
		Interpreter interpreter = InterpreterFactory.eINSTANCE.createInterpreter();
		Attribute attribute = grammar.getAttribute(attributeName);
		assertNotNull(attribute);
		Object result = interpreter.interpret(root, grammar, attribute);
		assertNotNull(result);
		return result;
	}

	public AttributeGrammar loadGrammar(String filename) {
		EObject rootObject = load(filename);
		EcoreUtil.resolveAll(rootObject.eResource().getResourceSet());
		TreeIterator<EObject> eAllContents = rootObject.eAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			EList<EObject> eCrossReferences = next.eCrossReferences();
			for (EObject reference : eCrossReferences) {
				if (reference.eIsProxy()) {
					fail("loadGrammar() found unresolved proxy: " + reference + " in " + next);
				}
			}
		}
		assertTrue(rootObject instanceof AttributeGrammar);
		return (AttributeGrammar) rootObject;
	}

	public EObject load(String filename) {
		Resource resource = rs.getResource(URI.createURI(filename), true);
		EObject rootObject = getRootObject(resource);
		return rootObject;
	}

	public EObject getRootObject(Resource resource) {
		assertNotNull(resource);
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertEquals("Resource must not be empty.", 1, contents.size());
		return contents.get(0);
	}
}

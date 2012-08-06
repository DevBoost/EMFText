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
package org.emftext.language.forms.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.forms.Choice;
import org.emftext.language.forms.Decision;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.FormsFactory;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.Item;
import org.emftext.language.forms.ItemType;
import org.emftext.language.forms.Option;
import org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation;
import org.emftext.language.forms.resource.forms.mopp.FormsPrinter2;
import org.emftext.language.forms.resource.forms.mopp.FormsResourceFactory;

public class FormsTest extends TestCase {

	private static final FormsFactory FACTORY = FormsFactory.eINSTANCE;
	private static final String FILE_EXTENSION = new FormsMetaInformation().getSyntaxName();
	private static final String LINE_BREAK = System.getProperty("line.separator");

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				FILE_EXTENSION,
				new FormsResourceFactory());
	}
	
	public void testPrinting() {
		
		Item item = FACTORY.createItem();
		item.setText("D");
		
		Option option1 = FACTORY.createOption();
		option1.setText("e");
		Option option2 = FACTORY.createOption();
		option2.setText("f");

		Decision decision = FACTORY.createDecision();
		decision.getOptions().add(option1);
		decision.getOptions().add(option2);
		item.setItemType(decision);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		FormsPrinter2 printer = new FormsPrinter2(outStream, null);
		try {
			printer.print(item);
			String result = outStream.toString();
			assertEquals("Unexpected result from printer", "ITEM\"D\":DECISION(\"e\",\"f\")" + LINE_BREAK, result);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testReferenceResolving() {
		// this is a test for bug 1524
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + FILE_EXTENSION));
		assertNotNull(r);
		String input =
			"FORM \"f\" " +
			"GROUP \"g\" " +
			"ITEM \"target\" : CHOICE (REF : \"a\", \"b\") " +
			"ITEM \"source\" ONLY IF REF : NUMBER";
		try {
			r.load(new ByteArrayInputStream(input.getBytes()), null);
			assertTrue(r.getErrors().isEmpty());
			EList<EObject> contents = r.getContents();
			assertFalse(contents.isEmpty());
			EObject root = contents.get(0);
			assertTrue(root instanceof Form);
			Form form = (Form) root;
			EList<Group> groups = form.getGroups();
			assertFalse(groups.isEmpty());
			Group group = groups.get(0);
			EList<Item> items = group.getItems();
			assertEquals(2, items.size());
			Item item1 = items.get(0);
			ItemType itemType1 = item1.getItemType();
			assertTrue(itemType1 instanceof Choice);
			Choice choice = (Choice) itemType1;
			
			Item item2 = items.get(1);
			EList<Option> dependentOf = item2.getDependentOf();
			assertEquals(1, dependentOf.size());
			assertSame(dependentOf.get(0), choice.getOptions().get(0));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}

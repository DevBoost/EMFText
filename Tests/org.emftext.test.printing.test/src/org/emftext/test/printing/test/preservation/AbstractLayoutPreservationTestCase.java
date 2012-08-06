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
package org.emftext.test.printing.test.preservation;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.test.printing.M10;
import org.emftext.test.printing.modellayout.resource.modellayout.IModellayoutTextResource;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutPrinter2;
import org.emftext.test.printing.modellayout.resource.modellayout.util.ModellayoutLayoutUtil;
import org.emftext.test.printing.resource.printing.IPrintingTextResource;
import org.emftext.test.printing.resource.printing.mopp.PrintingMetaInformation;
import org.emftext.test.printing.resource.printing.mopp.PrintingPrinter2;
import org.emftext.test.printing.resource.printing.mopp.PrintingResource;
import org.emftext.test.printing.test.AbstractPrintingTestCase;

/**
 * A test for the printer2 implementation that checks whether
 * the layout (i.e., whitespace and line breaks) are preserved.
 */
public abstract class AbstractLayoutPreservationTestCase extends AbstractPrintingTestCase {

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new PrintingMetaInformation().getSyntaxName(),
				selectResourceFactory());
	}

	protected abstract Resource.Factory selectResourceFactory();
	
	protected abstract void doAfterParsing(EObject root);

	protected abstract boolean noLayoutExpected();

	public void testPreservationM39() {
		assertParseAndPrint("m39 \"value\"");
		assertParseAndPrint("m39\"value\"");
	}

	public void testPreservationM1() {
		assertParseAndPrint("m1");
		assertParseAndPrint(" m1");
		assertParseAndPrint("  m1");
	}

	public void testPreservationM2() {
		assertParseAndPrint("m2a m2b");
		assertParseAndPrint("m2a  m2b");
		assertParseAndPrint("  m2a   m2b");
		assertParseAndPrint("  " + NEW_LINE + "m2a   " + NEW_LINE + "m2b");
	}

	public void testPreservationM3() {
		assertParseAndPrint("m3 name1");
		assertParseAndPrint("m3  name1");
	}

	public void testPreservationM4() {
		assertParseAndPrint("m4 name1");
		assertParseAndPrint("m4  name1   name2 name3");
	}

	public void testPreservationM5() {
		assertParseAndPrint("m5 name1,");
		assertParseAndPrint("m5 name1,   name2, name3,");
	}

	public void testPreservationM6() {
		assertParseAndPrint("m6 name1");
		assertParseAndPrint("m6 name1,    name2,  name3");
	}

	public void testPreservationM10() {
		assertParseAndPrint("m10 a1 -> a1");
		assertParseAndPrint("m10 a1 ->  a1");
		EObject root = assertParseAndPrint("m10  a1  ->  a1");
		// test changing the name of object 'm10'
		assertTrue(root instanceof M10 || root instanceof org.emftext.test.printing.modellayout.M10);
		if (root instanceof M10) {
			M10 m10 = (M10) root;
			m10.setName("a2");
		} else {
			org.emftext.test.printing.modellayout.M10 m10 = (org.emftext.test.printing.modellayout.M10) root;
			m10.setName("a2");
		}
		if (noLayoutExpected()) {
			assertPrintingWithoutLayout(root);
		} else {
			assertPrinting(root, "m10 a2  ->  a2", true, false);
		}
		
	}

	public void testPreservationM11() {
		assertParseAndPrint("m11 m1");
		assertParseAndPrint("m11    m1");
	}

	public void testPreservationM14() {
		assertParseAndPrint("m14 m1");
		assertParseAndPrint("m14    m1,  m1");
	}

	public void testPreservationM23() {
		assertParseAndPrint("m23 yes");
		assertParseAndPrint("m23 true");
		assertParseAndPrint("m23   yes");
		assertParseAndPrint("m23    true");
	}

	public void testPreservationM24() {
		assertParseAndPrint("m24 name1  name1   name1");
	}

	public void testPreservationM25() {
		assertParseAndPrint("m25 1  1   1");
	}

	public void testPreservationM26() {
		assertParseAndPrint("m26 true  true   true");
	}

	public void testPreservationM27() {
		assertParseAndPrint("m27 m3 a1 a1  a1   a1");
		assertParseAndPrint("m27 m3 a1 m3 a2 m3 a3    a1  a2   a3");
	}

	public void testPreservationM32() {
		assertParseAndPrint("m32a m32b");
		assertParseAndPrint("m32a" + NEW_LINE + "m32b");
	}

	public void testPreservationM33() {
		assertParseAndPrint("m33 m1");
		assertParseAndPrint("m33" + NEW_LINE + "m1");
	}
	
	public void testPreservationAtEndOfFile() {
		if (!noLayoutExpected()) {
			Resource resource = createTempResource();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			// this text contains whitespace after the last element.
			// the test checks whether this whitespace is preserved.
			String textWithWhiteSpaceAtEnd = "m33 m1   ";
			EObject root = parse(textWithWhiteSpaceAtEnd);
			String printer2result;
			if (resource instanceof PrintingResource) {
				PrintingPrinter2 printer2 = new PrintingPrinter2(outputStream, (IPrintingTextResource) resource);
				printer2result = getPrintResult(root, printer2, outputStream);
			} else {
				ModellayoutPrinter2 printer2 = new ModellayoutPrinter2(outputStream, (IModellayoutTextResource) resource);
				//this is usually done in doSave() of the resource
				new ModellayoutLayoutUtil().transferAllLayoutInformationFromModel(root);
				printer2result = getPrintResult(root, printer2, outputStream);
			}
			
			assertEquals(textWithWhiteSpaceAtEnd, printer2result);
		}
	}

	private EObject assertParseAndPrint(String text) {
		EObject root = parse(text);
		doAfterParsing(root);
		printTree(root, "");
		if (noLayoutExpected()) {
			assertPrintingWithoutLayout(root);
		} else {
			assertPrinting(root, text, true, false);
		}
		return root;
	}

	private void printTree(EObject root, String tab) {
		System.out.println(tab + root);
		for (EObject eObject : root.eCrossReferences()) {
			System.out.println(tab  + "->" + eObject);
		}
		for (EObject eObject : root.eContents()) {
			printTree(eObject, tab + " ");
		}
	}
}

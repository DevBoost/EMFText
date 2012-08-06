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
package org.emftext.language.regexp.test.translation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTextPrinter;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.regexp.test.AbstractTestCase;

public class ANTLR2SDFTranslationTest extends AbstractTestCase {
	
	public void testTranslation() {
		translate("'a'..'z'", "[a-z]");
	}

	private void translate(String antlrRegexp, String expectedSDFRegexp) {
		EObject root = parse(antlrRegexp, new Regexp_antlrMetaInformation().getSyntaxName());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		IRegexp_sdfTextPrinter printer = new Regexp_sdfMetaInformation().createPrinter(out, null);
		try {
			printer.print(root);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String result = out.toString();
		System.out.println("ANTLR2SDFTranslationTest.testTranslation() " + result);
		assertEquals(expectedSDFRegexp, result);
	}
}

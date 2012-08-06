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
package org.emftext.language.abnf.test;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.abnf.RuleSet;
import org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation;
import org.emftext.language.abnf.resource.abnf.util.AbnfResourceUtil;

import junit.framework.TestCase;

public class UnicodeTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new AbnfMetaInformation().registerResourceFactory();
	}
	
	public void testUnicodeDefinition() {
		assertParsing("rule = %x00-FF\n");
		assertParsing("rule = %x0000-FFFF\n");
	}

	private void assertParsing(String text) {
		RuleSet content = AbnfResourceUtil.getResourceContent(text);
		assertNotNull(content);
		EList<Diagnostic> errors = content.eResource().getErrors();
		for (Diagnostic error : errors) {
			System.out.println("UnicodeTest.assertParsing() " + error);
		}
		assertTrue(errors.isEmpty());
	}
}

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
package org.emftext.language.test.code_completion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp_antlr.IRegexp_antlrTextResource;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_antlr.ui.Regexp_antlrCodeCompletionHelper;
import org.emftext.language.regexp.resource.regexp_antlr.ui.Regexp_antlrCompletionProposal;

public class Bug1379Test extends TestCase {

	private static final Regexp_antlrMetaInformation REGEXP_ANTLR_META_INFORMATION = new Regexp_antlrMetaInformation();
	private static final String FILE_EXTENSION = REGEXP_ANTLR_META_INFORMATION.getSyntaxName();

	public void setUp() {
		REGEXP_ANTLR_META_INFORMATION.registerResourceFactory();
	}
	
	public void testPerformance() {
		long startTime = System.currentTimeMillis();
		testPerformance(10);
		testPerformance(100);
		// 1000 is about the size which was reported in the bug report.
		// before the fix, this took about 15 seconds. subsequent calls
		// with bigger input data could not be handled at all, because
		// the complexity of the algorithm was O(n^2) before the fix.
		testPerformance(1000);
		testPerformance(10000);
		testPerformance(100000);
		// now the overall test takes about 10 seconds
		long endTime = System.currentTimeMillis();
		assertTrue("Code completion computations must not take more than 5 minutes.", endTime - startTime < 5 * 60 * 1000);
	}

	private void testPerformance(int size) {
		String largeRegex = createLargeRegex(size);
		// check completion at end of document
		testPerformance(size, largeRegex, largeRegex.length(), 8);
		// check completion at start of document
		testPerformance(size, largeRegex, 0, 6);
	}

	private void testPerformance(int size, String largeRegex, int cursorOffset, int expectedNumberOfProposals) {
		IRegexp_antlrTextResource textResource = createResource(largeRegex);
		Regexp_antlrCodeCompletionHelper helper = new Regexp_antlrCodeCompletionHelper();
		long before = System.currentTimeMillis();
		Regexp_antlrCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, largeRegex, cursorOffset);
		List<Regexp_antlrCompletionProposal> matchingProposals = new ArrayList<Regexp_antlrCompletionProposal>();
		for (Regexp_antlrCompletionProposal proposal : proposals) {
			boolean matchesPrefix = proposal.getMatchesPrefix();
			//System.out.println("Bug1379Test.testPerformance() " + proposal.getInsertString() + (matchesPrefix ? " (matches)" : ""));
			if (matchesPrefix) {
				matchingProposals.add(proposal);
			}
		}
		//assertEquals(expectedNumberOfProposals, matchingProposals.size());
		// ( ) * + ? . | ~ 
		// 'someFrom' 'someValue'
		long after = System.currentTimeMillis();
		System.out.println("testPerformance(" + size + ") took " + (after - before) + "ms");
	}

	public void testNPE() {
		Regexp_antlrCodeCompletionHelper helper = new Regexp_antlrCodeCompletionHelper();
		String content = "('a'|'b')+";
		IRegexp_antlrTextResource textResource = createResource(content);
		Regexp_antlrCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, 0);
		assertEquals(6, proposals.length);
		// ( . | ~ 'someFrom' 'someValue'
	}

	private IRegexp_antlrTextResource createResource(String content) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(content.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals("Resource must not have errors.", 0, resource.getErrors().size());
		assertTrue(resource instanceof IRegexp_antlrTextResource);
		IRegexp_antlrTextResource textResource = (IRegexp_antlrTextResource) resource;
		return textResource;
	}
	
	private String createLargeRegex(int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("'a'|");
		}
		sb.append("'b'");
		return sb.toString();
	}
}

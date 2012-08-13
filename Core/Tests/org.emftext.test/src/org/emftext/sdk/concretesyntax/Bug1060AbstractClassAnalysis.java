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
package org.emftext.sdk.concretesyntax;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis.SubclassRestrictionAnalyser;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Test;

public class Bug1060AbstractClassAnalysis {

	private ResourceSet resourceSet;

	public Bug1060AbstractClassAnalysis() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
	}

	@Test
	public void testOntologyImportsDeresolve() {
		resourceSet = new ResourceSetImpl();
		
		URI inuri = URI.createURI("./testInput/CSAbstractSyntax.cs");
		Resource inresource = resourceSet.getResource(inuri, true);
		assertTrue("Resource loaded",inresource.getContents().size() == 1 );
		ConcreteSyntax cs = (ConcreteSyntax) inresource.getContents().get(0);
		SubclassRestrictionAnalyser sra = new SubclassRestrictionAnalyser();
		sra.analyse(cs);
		
		EList<Diagnostic> errors =  inresource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println(diagnostic.getMessage());
		}
		assertArrayEquals("No errors expected" , Collections.EMPTY_LIST.toArray(), errors.toArray());
	}
}

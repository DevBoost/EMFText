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
package org.emftext.test.booleanterminal.test;

import java.io.File;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.test.expectationcomputer.AbstractExpectationComputerTestCase;

public class FirstFollowTest extends AbstractExpectationComputerTestCase {

	private ConcreteSyntax btSyntax;
	
	public void setUp() {
		super.setUp();
		btSyntax = loadSyntax(".." + File.separator + "org.emftext.test.booleanterminal" + File.separator + "metamodel" + File.separator + "booleanterminal.cs");
	}
	
	public void testFirstSets() {
		assertFirstSet(
				findBooleanTerminals(btSyntax).get(0), 
				findBooleanTerminals(btSyntax).get(0) 
		);
		assertFirstSet(
				findBooleanTerminals(btSyntax).get(1), 
				findBooleanTerminals(btSyntax).get(1)
		);
		assertFirstSet(
				findBooleanTerminals(btSyntax).get(2), 
				findBooleanTerminals(btSyntax).get(2)
		);
	}
	
	public void testFollowSets() {
		assertFollowSet(
				findBooleanTerminals(btSyntax).get(0), 
				findKeyword(btSyntax, ";", 0)
		);
		assertFollowSet(
				findBooleanTerminals(btSyntax).get(1), 
				findKeyword(btSyntax, ";", 1)
		);
		assertFollowSet(
				findBooleanTerminals(btSyntax).get(2), 
				findKeyword(btSyntax, ";", 2) 
		);
		assertFollowSet(
				findKeyword(btSyntax, "b", 0),
				findBooleanTerminals(btSyntax).get(1), 
				findKeyword(btSyntax, ";", 1)
		);
	}
}

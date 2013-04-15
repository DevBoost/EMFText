/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.test;

import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.MismatchedNotSetException;
import org.antlr.runtime3_4_0.MismatchedRangeException;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.MismatchedTreeNodeException;
import org.antlr.runtime3_4_0.MissingTokenException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.UnwantedTokenException;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxErrorMessageConverter;
import org.junit.Test;

public class SyntaxErrorMessageConverterTest {

	@Test
	public void testNPE() {
		assertNoNPE(new RecognitionException());
		assertNoNPE(new EarlyExitException());
		assertNoNPE(new FailedPredicateException());
		assertNoNPE(new MismatchedRangeException());
		assertNoNPE(new MismatchedSetException());
		assertNoNPE(new MismatchedNotSetException());
		assertNoNPE(new MismatchedTokenException());
		assertNoNPE(new MissingTokenException());
		assertNoNPE(new UnwantedTokenException());
		assertNoNPE(new MismatchedTreeNodeException());
		assertNoNPE(new NoViableAltException());
	}

	private void assertNoNPE(RecognitionException e) {
		String[] tokenNames = new String[0];
		CsSyntaxErrorMessageConverter converter = new CsSyntaxErrorMessageConverter(tokenNames);
		converter.translateParseError(e);
	}
}

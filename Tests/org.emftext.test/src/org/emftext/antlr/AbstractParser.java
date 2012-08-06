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
package org.emftext.antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.TokenStream;

public abstract class AbstractParser extends org.antlr.runtime3_4_0.Parser {

	protected List<RecognitionException> errors = new ArrayList<RecognitionException>();

	public AbstractParser(TokenStream input) {
		super(input);
	}

	public AbstractParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	@Override
	public void reportError(RecognitionException e) {
		errors.add(e);
	}
	
	public abstract String root() throws RecognitionException;
	
	public abstract List<RecognitionException> getErrors();
}

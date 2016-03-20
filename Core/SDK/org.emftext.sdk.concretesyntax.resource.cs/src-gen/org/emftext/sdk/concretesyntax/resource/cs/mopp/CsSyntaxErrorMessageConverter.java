/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.List;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.MismatchedNotSetException;
import org.antlr.runtime3_4_0.MismatchedRangeException;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.MismatchedTreeNodeException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.Token;

public class CsSyntaxErrorMessageConverter {
	
	private String[] tokenNames;
	
	public CsSyntaxErrorMessageConverter(String[] tokenNames) {
		this.tokenNames = tokenNames;
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage translateLexicalError(RecognitionException e, List<RecognitionException> lexerExceptions, List<Integer> lexerExceptionPositions)  {
		String message = getMessage(e);
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage(message, e.charPositionInLine, e.line, lexerExceptionPositions.get(lexerExceptions.indexOf(e)), lexerExceptionPositions.get(lexerExceptions.indexOf(e)));
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage translateParseError(RecognitionException e)  {
		String message = getMessage(e);
		
		if (e.token instanceof CommonToken) {
			CommonToken ct = (CommonToken) e.token;
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage(message, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			int position = 1;
			int line = 1;
			if (e.token != null) {
				position = e.token.getCharPositionInLine();
				line = e.token.getLine();
			}
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage(message, position, line, 1, 5);
		}
	}
	
	protected String getMessage(RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof MismatchedTokenException) {
			MismatchedTokenException mte = (MismatchedTokenException) e;
			String expectedTokenName = getTokenName(mte.expecting);
			message = "Syntax error on token \"" + toString(e.token) + "\" ";
			message += "Expected: \"" + expectedTokenName + "\".";
		} else if (e instanceof MismatchedTreeNodeException) {
			MismatchedTreeNodeException mtne = (MismatchedTreeNodeException) e;
			String expectedTokenName = getTokenName(mtne.expecting);
			String actualTokenName = getTokenName(mtne.getUnexpectedType());
			message = "Mismatched tree node: \"" + actualTokenName + "\". Expected: \"" + expectedTokenName + "\"";
		} else if (e instanceof NoViableAltException) {
			message = "Syntax error on token \"" + toString(e.token) + "\". Check following tokens.";
		} else if (e instanceof EarlyExitException) {
			message = "Syntax error on token \"" + toString(e.token) + "\". Delete this token.";
		} else if (e instanceof MismatchedSetException) {
			MismatchedSetException mse = (MismatchedSetException) e;
			message = "Mismatched token: " + toString(e.token) + "; expecting set " + mse.expecting;
		} else if (e instanceof MismatchedNotSetException) {
			MismatchedNotSetException mse = (MismatchedNotSetException) e;
			message = "Mismatched token: " +  toString(e.token) + "; expecting set " + mse.expecting;
		} else if (e instanceof MismatchedRangeException) {
			message = "Mismatched token: " + toString(e.token) + "; expecting range";
		} else if (e instanceof FailedPredicateException) {
			FailedPredicateException fpe = (FailedPredicateException) e;
			message = "Rule " + fpe.ruleName + " failed. Predicate: {" +  fpe.predicateText + "}?";
		}
		
		return message;
	}
	
	protected String toString(Token token)  {
		if (token == null) {
			return "<UNKNOWN>";
		}
		
		StringBuilder result = new StringBuilder();
		String tokenName = getTokenName(token.getType());
		String tokenText = token.getText();
		result.append(tokenText);
		// We mention the name of the actual token only if it differs from the actual
		// token text to reduce confusion in error messages.
		if (tokenText != null && !tokenText.equals(tokenName)) {
			result.append(" (");
			result.append(tokenName);
			result.append(")");
		}
		return result.toString();
	}
	
	protected String getTokenName(int tokenType)  {
		String tokenName = "<unknown>";
		if (tokenType < 0) {
			tokenName = "EOF";
		} else {
			if (tokenType >= tokenNames.length) {
				return tokenName;
			}
			tokenName = tokenNames[tokenType];
			tokenName = org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.formatTokenName(tokenName);
		}
		return tokenName;
	}
	
}

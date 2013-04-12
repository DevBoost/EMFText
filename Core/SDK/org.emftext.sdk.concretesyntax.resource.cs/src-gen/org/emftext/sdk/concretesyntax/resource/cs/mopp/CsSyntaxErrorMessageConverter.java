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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsSyntaxErrorMessageConverter {
	
	private String[] tokenNames;
	
	public CsSyntaxErrorMessageConverter(String[] tokenNames) {
		this.tokenNames = tokenNames;
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage translateLexicalError(org.antlr.runtime3_4_0.RecognitionException e, java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions, java.util.List<Integer> lexerExceptionPositions)  {
		String message = getMessage(e);
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage(message, e.charPositionInLine, e.line, lexerExceptionPositions.get(lexerExceptions.indexOf(e)), lexerExceptionPositions.get(lexerExceptions.indexOf(e)));
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage translateParseError(org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = getMessage(e);
		
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
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
	
	protected String getMessage(org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = getTokenName(mte.expecting);
			String actualTokenName = getTokenName(e.token.getType());
			String actualText = e.token.getText();
			message = "Syntax error on token \"" + actualText + "\" ";
			// We mention the name of the actual token only if it differs from the actual
			// token text to reduce confusion in error messages.
			if (actualText != null && !actualText.equals(actualTokenName)) {
				message += "(" + actualTokenName + "). ";
			}
			message += "Expected: \"" + expectedTokenName + "\".";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = getTokenName(mtne.expecting);
			String actualTokenName = getTokenName(mtne.getUnexpectedType());
			message = "Mismatched tree node: \"" + actualTokenName + "\". Expected: \"" + expectedTokenName + "\"";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\". Check following tokens.";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\". Delete this token.";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "Mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "Mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			message = "Mismatched token: " +  e.token + "; expecting range";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "Rule " + fpe.ruleName + " failed. Predicate: {" +  fpe.predicateText + "}?";
		}
		
		return message;
	}
	
	protected String getTokenName(int tokenType)  {
		String tokenName = "<unknown>";
		if (tokenType < 0) {
			tokenName = "EOF";
		} else {
			if (tokenType < 0) {
				return tokenName;
			}
			tokenName = tokenNames[tokenType];
			tokenName = org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.formatTokenName(tokenName);
		}
		return tokenName;
	}
	
}

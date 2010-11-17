/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;

/**
 * An analyser that checks whether all quoted token definitions either use no
 * escape character at all or the same escape character for all definitions
 * which have the same prefix and suffix. This is necessary, because using
 * different escape characters results in regular expressions that overlap.
 * 
 * TODO add quick fix that sets the escape character for all definitions to
 * the same
 */
public class QuotenTokenAnalyser extends AbstractPostProcessor {
	
	public final static String MESSAGE_1 = "The quoted token must be consistently used either with or without escape character.";
	public final static String MESSAGE_2 = "The quoted token must be consistently used with the same escape character.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		List<CompleteTokenDefinition> tokens = syntax.getActiveTokens();
		Collection<CompleteTokenDefinition> handledTokens = new LinkedHashSet<CompleteTokenDefinition>(); 
		for (CompleteTokenDefinition tokenDefinition : tokens) {
			if (tokenDefinition instanceof QuotedTokenDefinition) {
				checkEscapeCharacterConsistency(tokens,
						handledTokens, tokenDefinition);
			}
		}
	}

	private void checkEscapeCharacterConsistency(
			List<CompleteTokenDefinition> tokens,
			Collection<CompleteTokenDefinition> handledTokens,
			CompleteTokenDefinition tokenDefinition) {
		handledTokens.add(tokenDefinition);
		QuotedTokenDefinition quotedToken = (QuotedTokenDefinition) tokenDefinition;
		for (CompleteTokenDefinition tokenDefinition2 : tokens) {
			if (tokenDefinition2 instanceof QuotedTokenDefinition) {
				QuotedTokenDefinition quotedToken2 = (QuotedTokenDefinition) tokenDefinition2;
				// ignore the first token when searching for a second
				if (handledTokens.contains(tokenDefinition2)) {
					continue;
				}
				String prefix1 = quotedToken.getPrefix();
				if (prefix1 == null) {
					continue;
				}
				String prefix2 = quotedToken2.getPrefix();
				if (prefix2 == null) {
					continue;
				}
				if (!prefix1.equals(prefix2)) {
					continue;
				}
				String suffix1 = quotedToken.getSuffix();
				if (suffix1 == null) {
					continue;
				}
				String suffix2 = quotedToken2.getSuffix();
				if (suffix2 == null) {
					continue;
				}
				if (!suffix1.equals(suffix2)) {
					continue;
				}
				String escapeCharacter1 = quotedToken.getEscapeCharacter();
				String escapeCharacter2 = quotedToken2.getEscapeCharacter();
				if (escapeCharacter1 == null) {
					if (escapeCharacter2 == null) {
						continue;
					} else {
						addProblem(quotedToken, quotedToken2, MESSAGE_1);
					}
				} else {
					if (escapeCharacter2 == null) {
						addProblem(quotedToken, quotedToken2, MESSAGE_1);
					} else {
						if (!escapeCharacter1.equals(escapeCharacter2)) {
							addProblem(quotedToken, quotedToken2, MESSAGE_2);
						}
					}
				}
			}
		}
	}

	private void addProblem(QuotedTokenDefinition quotedToken1, QuotedTokenDefinition quotedToken2, String message) {
		addTokenProblem(CsAnalysisProblemType.QUOTED_TOKEN_CONFLICT, MESSAGE_1, quotedToken1);
		addTokenProblem(CsAnalysisProblemType.QUOTED_TOKEN_CONFLICT, MESSAGE_1, quotedToken2);
	}
}

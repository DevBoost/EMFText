package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.CsProblem;
import org.emftext.sdk.ECsProblemType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;

public class QuotenTokenAnalyser extends AbstractPostProcessor {
	
	public final static String MESSAGE_1 = "The quoted token must be consistently used either with or without escape character.";
	public final static String MESSAGE_2 = "The quoted token must be consistently used with the same escape character.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<TokenDefinition> tokens = syntax.getActiveTokens();
		Collection<TokenDefinition> handledTokens = new LinkedHashSet<TokenDefinition>(); 
		for (TokenDefinition tokenDefinition1 : tokens) {
			if (tokenDefinition1 instanceof QuotedToken) {
				handledTokens.add(tokenDefinition1);
				QuotedToken quotedToken1 = (QuotedToken) tokenDefinition1;
				for (TokenDefinition tokenDefinition2 : tokens) {
					if (tokenDefinition2 instanceof QuotedToken) {
						QuotedToken quotedToken2 = (QuotedToken) tokenDefinition2;
						// ignore the first token when searching for a second
						if (handledTokens.contains(tokenDefinition2)) {
							continue;
						}
						String prefix1 = quotedToken1.getPrefix();
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
						String suffix1 = quotedToken1.getSuffix();
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
						String escapeCharacter1 = quotedToken1.getEscapeCharacter();
						String escapeCharacter2 = quotedToken2.getEscapeCharacter();
						if (escapeCharacter1 == null) {
							if (escapeCharacter2 == null) {
								continue;
							} else {
								addProblem(resource, quotedToken1, quotedToken2, MESSAGE_1);
							}
						} else {
							if (escapeCharacter2 == null) {
								addProblem(resource, quotedToken1, quotedToken2, MESSAGE_1);
							} else {
								if (!escapeCharacter1.equals(escapeCharacter2)) {
									addProblem(resource, quotedToken1, quotedToken2, MESSAGE_2);
								}
							}
						}
					}
				}
			}
		}
	}

	private void addProblem(ITextResource resource, QuotedToken quotedToken1, QuotedToken quotedToken2, String message) {
		resource.addProblem(new CsProblem(MESSAGE_1, ECsProblemType.QUOTED_TOKEN_CONFLICT), quotedToken1.getAttributeReferences().get(0));
		resource.addProblem(new CsProblem(MESSAGE_1, ECsProblemType.QUOTED_TOKEN_CONFLICT), quotedToken2.getAttributeReferences().get(0));
	}
}

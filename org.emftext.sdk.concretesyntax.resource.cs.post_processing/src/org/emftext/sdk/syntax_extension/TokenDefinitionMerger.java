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
package org.emftext.sdk.syntax_extension;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * The TokenDefinitionMerger is responsible to derive a list of all
 * tokens from the set of imported tokens, the set of defined tokens
 * and the set of synthetic tokens. The result of this merge process
 * is the set of tokens that will actually be used.
 */
public class TokenDefinitionMerger extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<TokenDirective> allImportedTokens = new ArrayList<TokenDirective>();
		List<String> mustOverrideTokenNames = new ArrayList<String>();
		
		// first we add the (merged) tokens from the imported syntax
    	for (Import nextImport : syntax.getImports()) {
    		ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
    		if (importedSyntax != null) {
    			List<CompleteTokenDefinition> importedTokens = importedSyntax.getActiveTokens();
    			// for each token we must check whether we have already
    			// a token with the same name - if the regular expressions
    			// match we're fine, otherwise we have a conflict
    			for (CompleteTokenDefinition importedToken : importedTokens) {
    				CompleteTokenDefinition previousToken = findTokenWithSameName(allImportedTokens, importedToken);
    				if (previousToken == null) {
    					// no token with the same name was found
    					allImportedTokens.add(importedToken);
    				} else {
	    				if (isCompatible(previousToken, importedToken)) {
	    					//allImportedTokens.add(importedToken);
	    					
	    					// we must redirect all placeholders that use the
	    					// duplicate token to use the previousToken
	    					redirect(importedToken, previousToken);
	    				} else {
	    					mustOverrideTokenNames.add(importedToken.getName());
	    				}
    				}
    			}
    		}
    	}
    	
		List<TokenDirective> mergeResult = new ArrayList<TokenDirective>();
    	// then we add the tokens in this syntax, if there are already imported
    	// tokens, we override them
    	for (TokenDirective tokenDirective : syntax.getTokens()) {
    		handleTokenDirective(mergeResult, tokenDirective);
    	}
    	for (TokenDirective tokenDirective : syntax.getSyntheticTokens()) {
    		handleTokenDirective(mergeResult, tokenDirective);
    	}
    	
		List<String> overriddenTokens = new ArrayList<String>();
    	// now handle token overriding
    	for (TokenDirective importedToken : allImportedTokens) {
			CompleteTokenDefinition previousToken = findTokenWithSameName(mergeResult, importedToken);
			if (previousToken == null) {
				// no token with the same name was found
				// search for a redefinition
				TokenRedefinition redefinition = findRedefinition(mergeResult, importedToken);
				if (redefinition != null) {
					redirect(redefinition.getRedefinedToken(), redefinition);
				} else {
					mergeResult.add(importedToken);
				}
			} else {
				// there is a token with this name which overrides the
				// imported token
				assert importedToken instanceof CompleteTokenDefinition;
				CompleteTokenDefinition importedTokenDefinition = (CompleteTokenDefinition) importedToken;
				overriddenTokens.add(importedTokenDefinition.getName());
				redirect(importedTokenDefinition, previousToken);
				continue;
			}
		}
    	
    	// then check whether all tokens that needed to be overridden because they had
    	// mismatching regular expressions are overridden indeed
    	for (String mustOverrideTokenName : mustOverrideTokenNames) {
    		if (!overriddenTokens.contains(mustOverrideTokenName)) {
    			addProblem(resource, ECsProblemType.TOKEN_MUST_BE_OVERRIDDEN, "The token " + mustOverrideTokenName + " must be overridden, because it has different definitions.", syntax);
    		}
    	}
    	
    	// finally set the merged tokens in the syntax model
    	List<TokenDirective> allTokenDirectives = syntax.getAllTokenDirectives();
		allTokenDirectives.clear();
    	allTokenDirectives.addAll(mergeResult);
    	
    	List<CompleteTokenDefinition> activeTokens = syntax.getActiveTokens();
    	activeTokens.clear();

    	List<TokenDirective> handledDirectives = new ArrayList<TokenDirective>();
    	// replace the priority directive with the actual tokens
    	for (TokenDirective tokenDirective : allTokenDirectives) {
    		if (handledDirectives.contains(tokenDirective)) {
    			continue;
    		}
    		handledDirectives.add(tokenDirective);
			if (tokenDirective instanceof TokenPriorityDirective) {
				TokenPriorityDirective priorityDirective = (TokenPriorityDirective) tokenDirective;
				CompleteTokenDefinition prioritizedToken = priorityDirective.getToken();
				activeTokens.add(prioritizedToken);
				handledDirectives.add(prioritizedToken);
			} else {
				activeTokens.add((CompleteTokenDefinition) tokenDirective);
			}
		}
	}

	private TokenRedefinition findRedefinition(List<TokenDirective> allTokens, TokenDirective redefinedToken) {
		for (TokenDirective tokenDirective : allTokens) {
			if (tokenDirective instanceof TokenRedefinition) {
				TokenRedefinition redefinition = (TokenRedefinition) tokenDirective;
				if (redefinedToken == redefinition.getRedefinedToken()) {
					return redefinition;
				}
			}
		}
		return null;
	}

	private void redirect(CompleteTokenDefinition oldToken, CompleteTokenDefinition newToken) {
		List<Placeholder> references = oldToken.getAttributeReferences();
		List<Placeholder> referencesToRedirect = new ArrayList<Placeholder>();
		referencesToRedirect.addAll(references);
		for (Placeholder placeholder : referencesToRedirect) {
			placeholder.setToken(newToken);
		}
	}

	private void handleTokenDirective(List<TokenDirective> mergeResult,
			TokenDirective tokenDirective) {
		if (tokenDirective instanceof CompleteTokenDefinition) {
			// only add definitions that are not contained already
			// they may have been inserted before by a TokenPriorityDirective
			if (!mergeResult.contains(tokenDirective)) {
				mergeResult.add((CompleteTokenDefinition) tokenDirective);
			}
		} else if (tokenDirective instanceof TokenPriorityDirective) {
			//TokenPriorityDirective priorityDirective = (TokenPriorityDirective) tokenDirective;
			//TokenDefinition prioritizeToken = priorityDirective.getToken();
			//mergeResult.remove(prioritizeToken);
			mergeResult.add(tokenDirective);
		} else if (tokenDirective instanceof PartialTokenDefinition) {
			// ignore partial token definitions
		} else if (tokenDirective instanceof TokenRedefinition) {
			mergeResult.add(tokenDirective);
		} else {
			throw new RuntimeException("Found unknown TokenDirective (" + tokenDirective.getClass().getName() + ").");
		}
	}

	private CompleteTokenDefinition findTokenWithSameName(
			List<TokenDirective> allTokens,
			TokenDirective tokenToSearchFor) {
		for (TokenDirective nextToken : allTokens) {
			if (!(nextToken instanceof CompleteTokenDefinition)) {
				continue;
			}
			CompleteTokenDefinition token = (CompleteTokenDefinition) tokenToSearchFor;
			CompleteTokenDefinition nextDefinition = (CompleteTokenDefinition) nextToken;
			if (token.getName().equals(nextDefinition.getName())) {
				return nextDefinition;
			}
		}
		return null;
	}

	private boolean isCompatible(CompleteTokenDefinition previousToken, CompleteTokenDefinition newToken) {
		// TODO use automata here instead of comparing the regular expression via string comparison
		String existingRegex = previousToken.getRegex();
		String importedRegex = newToken.getRegex();
		if (existingRegex.equals(importedRegex)) {
			// the regular expressions match - ignore new token
			return true;
		} else {
			// error: found two tokens with same name, but different expressions
			// user must override to have a unique definition
			return false;
		}
	}

	protected boolean doResolveProxiesBeforeAnalysis() {
		return false;
	}

	@Override
	protected boolean doAnalysisAfterPreviousErrors() {
		return false;
	}
}

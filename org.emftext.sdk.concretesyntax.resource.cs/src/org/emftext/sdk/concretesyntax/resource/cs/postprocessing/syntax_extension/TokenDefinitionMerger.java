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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_extension;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.regex.SorterException;

/**
 * The TokenDefinitionMerger is responsible to derive a list of all
 * tokens from the set of imported tokens, the set of defined tokens
 * and the set of synthetic tokens. The result of this merge process
 * is the set of tokens that will actually be used.
 */
public class TokenDefinitionMerger extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
    	boolean disableTokenSorting = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.DISABLE_TOKEN_SORTING);

    	List<CompleteTokenDefinition> allImportedTokens = new ArrayList<CompleteTokenDefinition>();
		
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
    					// no token with the same name was found, let's look for a token
    					// with the same regular expression
        				CompleteTokenDefinition compatibleToken = findCompatibleToken(allImportedTokens, importedToken);
	    				if (compatibleToken != null) {
	    					redirect(importedToken, compatibleToken);
	    				} else {
	    					allImportedTokens.add(importedToken);
	    				}
    				} else {
	    				if (isCompatible(previousToken, importedToken)) {
	    					// we must redirect all placeholders that use the
	    					// duplicate token to use the previousToken
	    					redirect(importedToken, previousToken);
	    				} else {
	    					// found two tokens with the same name, but incompatible
	    					// regular expressions. these tokens must be overridden,
	    					// which is detected later on by searching for tokens with
	    					// the same name, but different regular expression
	    					allImportedTokens.add(importedToken);
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
    	
    	// now handle token overriding
    	for (CompleteTokenDefinition importedToken : allImportedTokens) {
			CompleteTokenDefinition previousToken = findTokenWithSameName(mergeResult, importedToken);
			if (previousToken == null) {
				// no token with the same name was found, let's look for a token
				// with the same regular expression
				CompleteTokenDefinition compatibleToken = findCompatibleToken(mergeResult, importedToken);
				if (compatibleToken != null) {
					redirect(importedToken, compatibleToken);
				} else {
					// search for a redefinition
					TokenRedefinition redefinition = findRedefinition(mergeResult, importedToken);
					if (redefinition != null) {
						redirect(redefinition.getRedefinedToken(), redefinition);
					} else {
						mergeResult.add(importedToken);
					}
				}
			} else {
				// there is a token with this name which overrides the
				// imported token
				assert importedToken instanceof CompleteTokenDefinition;
				CompleteTokenDefinition importedTokenDefinition = (CompleteTokenDefinition) importedToken;
				redirect(importedTokenDefinition, previousToken);
				continue;
			}
		}
    	
		// merge tokens with same name and same regular expression
		List<TokenDirective> mergeResultCopy = new ArrayList<TokenDirective>();
		mergeResultCopy.addAll(mergeResult);
		Set<TokenDirective> handledTokens = new LinkedHashSet<TokenDirective>();
		for (TokenDirective nextToken : mergeResult) {
			if (handledTokens.contains(nextToken)) {
				continue;
			}
			if (nextToken instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition namedToken = (CompleteTokenDefinition) nextToken;
				Set<CompleteTokenDefinition> tokensWithSameName = getTokensByName(mergeResult, namedToken.getName());
				for (CompleteTokenDefinition otherToken : tokensWithSameName) {
					if (otherToken != nextToken) {
						if (isCompatible(otherToken, namedToken)) {
							redirect(otherToken, namedToken);
							mergeResultCopy.remove(otherToken);
							handledTokens.add(otherToken);
						}
					}
				}
			}
		}
		mergeResult = mergeResultCopy;
		
		// check whether there is still tokens with the same name
		Set<String> handledTokenNames = new LinkedHashSet<String>();
		for (TokenDirective nextToken : mergeResult) {
			if (nextToken instanceof NamedTokenDefinition) {
				NamedTokenDefinition namedToken = (NamedTokenDefinition) nextToken;
				if (handledTokenNames.contains(namedToken.getName())) {
					continue;
				}
				if (countOccurrences(mergeResult, namedToken) > 1) {
	    			addProblem(CsAnalysisProblemType.TOKEN_MUST_BE_OVERRIDDEN, "The token " + namedToken.getName() + " must be overridden, because it has different definitions.", syntax);
				}
				handledTokenNames.add(namedToken.getName());
			}
		}
		
    	// finally set the merged tokens in the syntax model
    	List<TokenDirective> allTokenDirectives = syntax.getAllTokenDirectives();
		allTokenDirectives.clear();
    	allTokenDirectives.addAll(mergeResult);
    	
    	List<CompleteTokenDefinition> activeTokens = new ArrayList<CompleteTokenDefinition>();

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
				if (!disableTokenSorting) {
					String message = 
						"Token priorities are ignored since token sorting is enabled. " + 
						"Use the " + OptionTypes.DISABLE_TOKEN_SORTING.getLiteral() + " option to disable sorting.";
					addProblem(CsAnalysisProblemType.TOKEN_PRIORIZATION_USELESS_WHEN_TOKEN_SORTING_ENABLED, message, priorityDirective);
				}
			} else {
				activeTokens.add((CompleteTokenDefinition) tokenDirective);
			}
		}

		// this is a fix for bug 1458
    	if (!disableTokenSorting) {
    		try {
    			activeTokens = sortTokens(activeTokens);
    		} catch (SorterException e) {
    			// Can't sort tokens automatically, user must define token order
    			// manually.
    			String message = 
    				"Automatic token sorting failed. " +
					"Use the " + OptionTypes.DISABLE_TOKEN_SORTING.getLiteral() + " option to disable sorting and define token order manually.";
				addProblem(CsAnalysisProblemType.TOKEN_SORTING_FAILED, message, syntax);
    		}
		}
		
		// set active tokens in syntax model
    	List<CompleteTokenDefinition> currentActiveTokens = syntax.getActiveTokens();
    	currentActiveTokens.clear();
    	currentActiveTokens.addAll(activeTokens);
	}

	private List<CompleteTokenDefinition> sortTokens(
			List<CompleteTokenDefinition> tokens) throws SorterException {
		// sort resulting list of active tokens (includes tokens both from 
    	// imported syntax files and the current CS file)
		tokens = tokenSorter.sortTokens(tokens, false);
		return tokens;
	}

	private Set<CompleteTokenDefinition> getTokensByName(
			List<TokenDirective> mergeResult, String name) {
		Set<CompleteTokenDefinition> tokensWithSameName = new LinkedHashSet<CompleteTokenDefinition>();
		for (TokenDirective nextToken : mergeResult) {
			if (nextToken instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition namedToken = (CompleteTokenDefinition) nextToken;
				if (namedToken.getName().equals(name)) {
					tokensWithSameName.add(namedToken);
				}
			}
		}
		return tokensWithSameName;
	}

	private int countOccurrences(List<TokenDirective> mergeResult,
			NamedTokenDefinition namedToken) {
		String name = namedToken.getName();
		int count = 0;
		for (TokenDirective tokenDirective : mergeResult) {
			if (tokenDirective instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition nextToken = (CompleteTokenDefinition) tokenDirective;
				if (name.equals(nextToken.getName())) {
					count++;
				}
			}
		}
		return count;
	}

	private CompleteTokenDefinition findCompatibleToken(
			List<? extends TokenDirective> allTokens,
			CompleteTokenDefinition token) {
		for (TokenDirective tokenDirective : allTokens) {
			if (tokenDirective instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition completeDefinition = (CompleteTokenDefinition) tokenDirective;
				if (isCompatible(token, completeDefinition)) {
					return completeDefinition;
				}
			}
		}
		return null;
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

	private void redirect(ReferencableTokenDefinition oldToken, ReferencableTokenDefinition newToken) {
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
			List<? extends TokenDirective> allTokens,
			NamedTokenDefinition tokenToSearchFor) {
		for (TokenDirective nextToken : allTokens) {
			if (nextToken instanceof CompleteTokenDefinition) {
				//CompleteTokenDefinition token = (CompleteTokenDefinition) tokenToSearchFor;
				//CompleteTokenDefinition nextDefinition = (CompleteTokenDefinition) nextToken;
				CompleteTokenDefinition completeToken = (CompleteTokenDefinition) nextToken;
				if (tokenToSearchFor.getName().equals(completeToken.getName())) {
					return completeToken;
				}
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

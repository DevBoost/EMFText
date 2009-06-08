package org.emftext.sdk.syntax_extension;

import java.util.ArrayList;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;

/**
 * The TokenDefinitionMerger is responsible to derive a list of all
 * tokens from the set of imported tokens, the set of defined tokens
 * and the set of synthetic tokens. The result of this merge process
 * is the set of tokens that will actually be used.
 */
public class TokenDefinitionMerger extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<TokenDirective> allImportedTokens = new ArrayList<TokenDirective>();
		List<String> mustOverrideTokenNames = new ArrayList<String>();
		
		// first we add the (merged) tokens from the imported syntax
    	for (Import nextImport : syntax.getImports()) {
    		ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
    		if (importedSyntax != null) {
    			List<TokenDefinition> importedTokens = importedSyntax.getActiveTokens();
    			// for each token we must check whether we have already
    			// a token with the same name - if the regular expressions
    			// match we're fine, otherwise we have a conflict
    			for (TokenDefinition importedToken : importedTokens) {
    				TokenDefinition previousToken = findTokenWithSameName(allImportedTokens, importedToken);
    				if (previousToken == null) {
    					// no token with the same name was found
    					allImportedTokens.add(importedToken);
    				} else {
	    				if (isCompatible(previousToken, importedToken)) {
	    					allImportedTokens.add(importedToken);
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
			TokenDefinition previousToken = findTokenWithSameName(mergeResult, importedToken);
			if (previousToken == null) {
				// no token with the same name was found
				mergeResult.add(importedToken);
			} else {
				// there is a token with this name which override the
				// imported token
				assert importedToken instanceof TokenDefinition;
				overriddenTokens.add(((TokenDefinition) importedToken).getName());
				continue;
			}
		}
    	
    	// then check whether all token that needed to be overridden because they had
    	// mismatching regular expressions are overridden indeed
    	for (String mustOverrideTokenName : mustOverrideTokenNames) {
    		if (!overriddenTokens.contains(mustOverrideTokenName)) {
    			resource.addError("The token " + mustOverrideTokenName + " must be overridden, because it has different definitions.", syntax);
    		}
    	}
    	
    	// finally set the merged tokens in the syntax model
    	List<TokenDirective> allTokenDirectives = syntax.getAllTokenDirectives();
		allTokenDirectives.clear();
    	allTokenDirectives.addAll(mergeResult);
    	
    	List<TokenDefinition> activeTokens = syntax.getActiveTokens();
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
				TokenDefinition prioritizedToken = priorityDirective.getToken();
				activeTokens.add((TokenDefinition) prioritizedToken);
				handledDirectives.add(prioritizedToken);
			} else {
				activeTokens.add((TokenDefinition) tokenDirective);
			}
		}
	}

	private void handleTokenDirective(List<TokenDirective> mergeResult,
			TokenDirective tokenDirective) {
		if (tokenDirective instanceof TokenDefinition) {
			// only add definition that are not contained already
			// they may have been inserted before by a TokenPriorityDirective
			if (!mergeResult.contains(tokenDirective)) {
				mergeResult.add((TokenDefinition) tokenDirective);
			}
		} else if (tokenDirective instanceof TokenPriorityDirective) {
			//TokenPriorityDirective priorityDirective = (TokenPriorityDirective) tokenDirective;
			//TokenDefinition prioritizeToken = priorityDirective.getToken();
			//mergeResult.remove(prioritizeToken);
			mergeResult.add(tokenDirective);
		} else {
			throw new RuntimeException("Found unknown TokenDefinition.");
		}
	}

	private TokenDefinition findTokenWithSameName(
			List<TokenDirective> tokens,
			TokenDirective tokenDirective) {
		for (TokenDirective directive : tokens) {
			if (!(directive instanceof TokenDefinition)) {
				continue;
			}
			TokenDefinition token = (TokenDefinition) tokenDirective;
			TokenDefinition tokenDefinition = (TokenDefinition) directive;
			if (token.getName().equals(tokenDefinition.getName())) {
				return tokenDefinition;
			}
		}
		return null;
	}

	private boolean isCompatible(TokenDefinition previousToken, TokenDefinition newToken) {
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
}

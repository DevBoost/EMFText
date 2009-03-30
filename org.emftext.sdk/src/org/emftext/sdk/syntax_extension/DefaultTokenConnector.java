package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.EPredefinedTokens;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * The DefaultTokenConnector looks for PlaceholderUsingDefaultToken. 
 * For each PlaceholderUsingDefaultToken that is found in the resource, 
 * the 'token' reference is set.
 */
public class DefaultTokenConnector extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		String standardTokenName = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.DEFAULT_TOKEN_NAME);
		if (standardTokenName == null) {
			standardTokenName = EPredefinedTokens.STANDARD.getTokenName();
		}
		
		TreeIterator<EObject> allObjectsIterator = syntax.eAllContents();
		while (allObjectsIterator.hasNext()) {
			EObject next = allObjectsIterator.next();
			if (next instanceof PlaceholderUsingDefaultToken) {
				PlaceholderUsingDefaultToken placeholder = (PlaceholderUsingDefaultToken) next;
				// this placeholder must use the standard token
				TokenDefinition definition = findToken(syntax, standardTokenName);
				if (definition == null) {
					resource.addError("There is no token definition for the default token \"" + standardTokenName + "\".", placeholder);
				} else {
					placeholder.setToken(definition);
				}
			}
		}
	}

	private TokenDefinition findToken(ConcreteSyntax syntax,
			String standardTokenName) {
		for (TokenDefinition next : syntax.getAllTokens()) {
			if (standardTokenName.equals(next.getName())) {
				return next;
			}
		}
		return null;
	}
}

package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.EPredefinedTokens;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.analysis.AbstractPostProcessor;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * The StandardTokenConnector looks for DerivedPlaceholders that do not have a 
 * suffix and prefix and thus use the standard token. For each DerivedPlaceholder
 * that is found in the resource, the 'token' reference is set.
 */
public class StandardTokenConnector extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		String standardTokenName = OptionManager.INSTANCE.getStringOptionValue(syntax, ICodeGenOptions.CS_OPTION_STD_TOKEN_NAME);
		if (standardTokenName == null) {
			standardTokenName = EPredefinedTokens.STANDARD.getTokenName();
		}
		
		TreeIterator<EObject> allObjectsIterator = syntax.eAllContents();
		while (allObjectsIterator.hasNext()) {
			EObject next = allObjectsIterator.next();
			if (next instanceof DerivedPlaceholder) {
				DerivedPlaceholder placeholder = (DerivedPlaceholder) next;
				boolean hasPrefix = placeholder.getNormalizedPrefix() != null;
				boolean hasSuffix = placeholder.getNormalizedSuffix() != null;
				if (!hasPrefix && !hasSuffix) {
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

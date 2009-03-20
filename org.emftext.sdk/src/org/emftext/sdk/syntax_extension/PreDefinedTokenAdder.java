package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.EPredefinedTokens;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.analysis.AbstractPostProcessor;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.PreDefinedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * The PreDefinedTokenAdder adds all predefined tokens to the syntax
 * unless the option to disable the usage of predefined tokens was set.
 */
public class PreDefinedTokenAdder extends AbstractPostProcessor {

	/**
	 * We override process() because we do not want to resolve all proxies before
	 * running this processor.
	 */
	@Override
	public void process(ITextResource resource) {
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				analyse(resource, (ConcreteSyntax) next);
			}
		}
	}
	
	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		boolean usePredefinedTokens = OptionManager.INSTANCE.getBooleanOptionValue(syntax, ICodeGenOptions.CS_OPTION_USE_PREDEFINED_TOKENS);
		if (!usePredefinedTokens) {
			return;
		}
		
		// TODO mseifert: figure why TEXT was not added here before refactoring
		for (EPredefinedTokens predefinedToken : EPredefinedTokens.values()) {
			// first look whether there is a PreDefinedToken
			boolean found = searchForPredefinedTokenDeclaration(syntax, predefinedToken);
			if (found) {
				continue;
			}
			
			// if not create one and add it to the end of the token list
			TokenDefinition definition = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
			definition.setName(predefinedToken.getTokenName());
			definition.setRegex(predefinedToken.getExpression());
			syntax.getSyntheticTokens().add(definition);
		}
	}

	private boolean searchForPredefinedTokenDeclaration(ConcreteSyntax syntax,
			EPredefinedTokens predefinedToken) {
		for (TokenDefinition next : syntax.getTokens()) {
			if (next instanceof PreDefinedToken) {
				PreDefinedToken predefined = (PreDefinedToken) next;
				if (predefinedToken.getTokenName().equals(predefined.getName())) {
					// found a declaration for the predefined token
					predefined.setRegex(predefinedToken.getExpression());
					return true;
				}
			}
		}
		return false;
	}

}

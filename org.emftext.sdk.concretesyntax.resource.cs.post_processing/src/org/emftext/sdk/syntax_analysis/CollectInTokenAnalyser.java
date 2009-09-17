package org.emftext.sdk.syntax_analysis;

import java.util.Collection;

import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.ECsProblemType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;

public class CollectInTokenAnalyser extends AbstractPostProcessor {

	private static final String COLLECT_IN_TOKEN_USED_IN_RULE_WARNING = 
		"Token %s will never be matched here, since it is a collect-in token.";
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		for (Rule rule : syntax.getAllRules()) {
			Collection<Placeholder> placeholders = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholder());
			for (Placeholder placeholder : placeholders) {
				TokenDefinition token = placeholder.getToken();
				if (token.getAttributeName() != null) {
					addProblem(
							resource,
							ECsProblemType.COLLECT_IN_TOKEN_USED_IN_RULE,
							String.format(COLLECT_IN_TOKEN_USED_IN_RULE_WARNING, token.getName()),
							placeholder);
				}
			}
		}
	}

}

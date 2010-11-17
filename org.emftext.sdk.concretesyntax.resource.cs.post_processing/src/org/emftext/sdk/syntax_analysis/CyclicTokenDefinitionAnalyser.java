package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;

/**
 * An analyser that detects cyclic token definitions (i.e., token definition
 * that transitively references itself).
 */
public class CyclicTokenDefinitionAnalyser extends AbstractPostProcessor {

	private static final String CYCLIC_TOKEN_DEFINITIONS_NOT_ALLOWED = 
		"The regular expression for token %s is cyclic.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<NamedTokenDefinition> cyclicTokens = findCyclicTokens(syntax);
		for (NamedTokenDefinition cyclicToken : cyclicTokens) {
			addProblem(
					CsAnalysisProblemType.CYCLIC_TOKEN_DEFINITION,
					String.format(CYCLIC_TOKEN_DEFINITIONS_NOT_ALLOWED, cyclicToken.getName()),
					cyclicToken);
		}
	}


	@Override
	protected boolean doResolveProxiesBeforeAnalysis() {
		return true;
	}

	private Collection<NamedTokenDefinition> findCyclicTokens(ConcreteSyntax syntax) {
		Set<NamedTokenDefinition> cyclicTokens = new LinkedHashSet<NamedTokenDefinition>();
		
		List<TokenDirective> tokenDirectives = syntax.getTokens();
		for (TokenDirective directive : tokenDirectives) {
			if (directive instanceof NamedTokenDefinition) {
				NamedTokenDefinition tokenDefinition = (NamedTokenDefinition) directive;
				if (hasReferenceTo(tokenDefinition, tokenDefinition)) {
					cyclicTokens.add(tokenDefinition);
				}
			}
		}
		return cyclicTokens;
	}

	private boolean hasReferenceTo(AbstractTokenDefinition source,
			AbstractTokenDefinition target) {
		Set<AbstractTokenDefinition> references = collectReferences(source);
		return references.contains(target);
	}

	private Set<AbstractTokenDefinition> collectReferences(AbstractTokenDefinition token) {
		LinkedHashSet<AbstractTokenDefinition> visitedReferences = new LinkedHashSet<AbstractTokenDefinition>();
		collectReferences(token, visitedReferences);
		return visitedReferences;
	}
	
	private void collectReferences(AbstractTokenDefinition token, Set<AbstractTokenDefinition> visitedReferences) {
		if (token instanceof RegexComposite) {
			RegexComposite sourceToken = (RegexComposite) token;
			List<RegexPart> parts = sourceToken.getRegexParts();
			for (RegexPart part : parts) {
				if (part instanceof RegexReference) {
					RegexReference reference = (RegexReference) part;
					AbstractTokenDefinition target = reference.getTarget();
					if (target != null) {
						if (!visitedReferences.contains(target)) {
							visitedReferences.add(target);
							collectReferences(target, visitedReferences);
						}
						visitedReferences.add(target);
					}
				}
			}
		}
	}
}

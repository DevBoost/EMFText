package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that detects cyclic token definitions (i.e., token definition
 * that transitively reference itself).
 */
public class CyclicTokenDefinitionAnalyser extends AbstractPostProcessor {

	private static final String CYCLIC_TOKEN_DEFINITIONS_NOT_ALLOWED = 
		"The regular expression for token %s is cyclic.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Collection<CompleteTokenDefinition> cyclicTokens = findCyclicTokens(syntax);
		for (CompleteTokenDefinition cyclicToken : cyclicTokens) {
			addProblem(
					resource,
					ECsProblemType.CYCLIC_TOKEN_DEFINITION,
					String.format(CYCLIC_TOKEN_DEFINITIONS_NOT_ALLOWED, cyclicToken.getName()),
					cyclicToken);
		}
	}


	@Override
	protected boolean doResolveProxiesBeforeAnalysis() {
		return true;
	}

	private Collection<CompleteTokenDefinition> findCyclicTokens(ConcreteSyntax syntax) {
		Set<CompleteTokenDefinition> cyclicTokens = new LinkedHashSet<CompleteTokenDefinition>();
		
		List<CompleteTokenDefinition> activeTokens = syntax.getActiveTokens();
		for (CompleteTokenDefinition tokenDefinition : activeTokens) {
			if (hasReferenceTo(tokenDefinition, tokenDefinition)) {
				cyclicTokens.add(tokenDefinition);
			}
		}
		return cyclicTokens;
	}

	private boolean hasReferenceTo(CompleteTokenDefinition source,
			CompleteTokenDefinition target) {
		Set<CompleteTokenDefinition> references = collectReferences(source);
		return references.contains(target);
	}

	private Set<CompleteTokenDefinition> collectReferences(CompleteTokenDefinition token) {
		LinkedHashSet<CompleteTokenDefinition> visitedReferences = new LinkedHashSet<CompleteTokenDefinition>();
		collectReferences(token, visitedReferences);
		return visitedReferences;
	}
	
	private void collectReferences(CompleteTokenDefinition token, Set<CompleteTokenDefinition> visitedReferences) {
		if (token instanceof NormalToken) {
			NormalToken sourceToken = (NormalToken) token;
			List<RegexPart> parts = sourceToken.getRegexParts();
			for (RegexPart part : parts) {
				if (part instanceof RegexReference) {
					RegexReference reference = (RegexReference) part;
					CompleteTokenDefinition target = reference.getTarget();
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

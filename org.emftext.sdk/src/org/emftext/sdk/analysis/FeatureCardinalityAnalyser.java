package org.emftext.sdk.analysis;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Terminal;

/**
 * An analyser that checks whether the cardinality of a feature
 * matches the cardinality given in the syntax.
 */
public class FeatureCardinalityAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		TreeIterator<EObject> contents = syntax.eAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Terminal) {
				Terminal terminal = (Terminal) next;
				final Cardinality cardinality = terminal.getCardinality();
				if (cardinality != null && cardinality instanceof STAR) { 
					final GenFeature genFeature = terminal.getFeature();
					if (genFeature.getEcoreFeature().getUpperBound() != -1) {
						resource.addError("Multiplicity of feature \"" + genFeature.getName() + "\" does not match cardinality.", terminal);
					}
				}
			}
		}
	}
}

package org.emftext.sdk.quickfixes;

import java.io.IOException;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix;

/**
 * A quick fix that adjusts the cardinality of a structural feature. This fix 
 * can be applied when the min/max occurrences in the syntax do not match the
 * lower/upper bounds defined in the metamodel.
 */
public class SetFeatureBoundsQuickFix extends CsQuickFix {

	private GenFeature feature;
	private int lowerBound;
	private int upperBound;

	public SetFeatureBoundsQuickFix(Rule rule, GenFeature feature, int lowerBound, int upperBound) {
		// TODO add image for this quick fix
		super("Adjust bounds in metamodel", null, rule);
		this.feature = feature;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void applyChanges() {
		// do changes
		EStructuralFeature ecoreFeature = feature.getEcoreFeature();
		ecoreFeature.setLowerBound(lowerBound);
		ecoreFeature.setUpperBound(upperBound);
		
		// save external (non-CS) resources
		try {
			ecoreFeature.eResource().save(null);
		} catch (IOException ioe) {
			CsPlugin.logError("Exception while applying quick fix.", ioe);
		}
	}
}

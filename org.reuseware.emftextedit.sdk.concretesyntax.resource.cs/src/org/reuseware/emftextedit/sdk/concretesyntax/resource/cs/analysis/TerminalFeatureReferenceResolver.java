package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.reuseware.emftextedit.runtime.resource.ReferenceMapping;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;
import org.reuseware.emftextedit.sdk.concretesyntax.Containment;
import org.reuseware.emftextedit.sdk.concretesyntax.Placeholder;
import org.reuseware.emftextedit.sdk.concretesyntax.Rule;

public class TerminalFeatureReferenceResolver extends ReferenceResolverImpl {
	
	private interface FeatureResolveResult extends ResolveResult {
		public boolean foundFeatureWithCorrectName();
		public void setFoundFeatureWithCorrectName();
	}
	
	private class FeatureResolveResultImpl implements FeatureResolveResult {
		
		private ResolveResult result;
		private boolean foundFeatureWithCorrectName = false;

		public FeatureResolveResultImpl(ResolveResult result) {
			this.result = result;
		}

		public boolean foundFeatureWithCorrectName() {
			return foundFeatureWithCorrectName;
		}

		public String getErrorMessage() {
			return result.getErrorMessage();
		}

		public Collection<ReferenceMapping> getMappings() {
			return result.getMappings();
		}

		public boolean wasResolved() {
			return result.wasResolved();
		}

		public boolean wasResolvedMultiple() {
			return result.wasResolvedMultiple();
		}

		public boolean wasResolvedUniquely() {
			return result.wasResolvedUniquely();
		}

		public void setErrorMessage(String message) {
			result.setErrorMessage(message);
		}

		public void addMapping(String identifier, EObject target) {
			result.addMapping(identifier, target);
		}

		public void setFoundFeatureWithCorrectName() {
			foundFeatureWithCorrectName = true;
		}

		public void addMapping(String identifier, String newIdentifier) {
			result.addMapping(identifier, newIdentifier);
		}
	}
	
	private interface GenFeatureFilter {
		public void accept(GenFeature feature, FeatureResolveResult result);
	}
	
	private abstract class NameFilter implements GenFeatureFilter {
		protected final String identifier;

		public NameFilter(String identifier) {
			this.identifier = identifier;
		}

		protected abstract boolean doNamesMatch(String identifier, String featureName);
	}

	private abstract class NameEqualsFilter extends NameFilter {

		public NameEqualsFilter(String identifier) {
			super(identifier);
		}

		protected boolean doNamesMatch(String identifier, String featureName) {
			if (featureName == null) {
				return false;
			}
			if (!featureName.equals(identifier)) {
				return false;
			}
			return true;
		}
	}

	private class NameStartsWithFilter extends NameFilter {

		public NameStartsWithFilter(String identifier) {
			super(identifier);
		}

		public void accept(GenFeature feature, FeatureResolveResult result) {
			String featureName = feature.getName();
			boolean featureNameIsCorrect = doNamesMatch(identifier, featureName);
			if (!featureNameIsCorrect) {
				return;
			}
			result.setFoundFeatureWithCorrectName();
			result.addMapping(featureName, feature);
		}
		
		@Override
		protected boolean doNamesMatch(String identifier, String featureName) {
			if (featureName == null) {
				return false;
			}
			if (!featureName.startsWith(identifier)) {
				return false;
			}
			return true;
		}
	}

	private class NameAndContainmentFilter extends NameEqualsFilter {

		private final EObject container;

		private NameAndContainmentFilter(String identifier, EObject container) {
			super(identifier);
			this.container = container;
		}

		public void accept(GenFeature feature, FeatureResolveResult result) {
			String featureName = feature.getName();
			boolean featureNameIsCorrect = doNamesMatch(identifier, featureName);
			if (!featureNameIsCorrect) {
				return;
			}
			result.setFoundFeatureWithCorrectName();
			boolean hasCorrectContainmentType = hasCorrectContainmentType(container, feature, featureName);
			if (hasCorrectContainmentType) {
				result.addMapping(featureName, feature);
			}
		}
	}

	@Override
	protected void doResolve(final String identifier, final EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {
		if (resolveFuzzy) {
			doResolveFuzzy(identifier, container, result);
		} else {
			doResolveStrict(identifier, container, result);
		}
	}

	private void doResolveFuzzy(String identifier, EObject container, ResolveResult result) {
		doResolveFeature(container, new NameStartsWithFilter(identifier), identifier, result);
	}

	private void doResolveStrict(String identifier, EObject container, ResolveResult result) {
		doResolveFeature(container, new NameAndContainmentFilter(identifier, container), identifier, result);
	}

	private void doResolveFeature(EObject container, GenFeatureFilter filter, String identifier, ResolveResult result) {
		Rule rule = getContainingRule(container);
		
		if (rule == null) {
			return;
		}
		if (rule.getMetaclass().eIsProxy()) {
			return;
		}
		FeatureResolveResult resultForFeature = new FeatureResolveResultImpl(result); 
		for (GenFeature feature : rule.getMetaclass().getAllGenFeatures()) {
			filter.accept(feature, resultForFeature);
		}
		if (resultForFeature.foundFeatureWithCorrectName() && !result.wasResolved()) {
			// found a feature with correct name, but wrong containment
			result.setErrorMessage(createFeatureHasWrongContainmentTypeResult(identifier, getExpectedContainmentValue(container)));
		} else {
			result.setErrorMessage(createFeatureNotExistsResult(identifier));
		}
	}

	@Override
	public String deResolve(EObject element, EObject container, EReference reference){
		GenFeature feature = (GenFeature) element;
		return feature.getName();
	}

	private Rule getContainingRule(EObject container) {
		Rule rule = null;
		EObject o = container;
		do {
			if (o instanceof Rule) {
				rule = (Rule) o;
			}
			else {
				o = o.eContainer();
			}
		} while (rule == null && o != null);
		return rule;
	}

	private boolean hasCorrectContainmentType(EObject container,
			GenFeature genFeature, String featureName) {
		EStructuralFeature feature = genFeature.getEcoreFeature();
		
		boolean isContainment = getContainmentValue(feature);
		boolean expectedValue = getExpectedContainmentValue(container);
		return isContainment == expectedValue;
	}

	private boolean getExpectedContainmentValue(EObject container) {
		if (container instanceof Placeholder) {
			return false;
		} else if (container instanceof Containment) {
			return true;
		} else {
			// TODO is this the right return value?
			return false;
		}
	}

	private boolean getContainmentValue(EStructuralFeature ecoreFeature) {
		return ecoreFeature instanceof EReference && ((EReference)ecoreFeature).isContainment();
	}
	
	private String createFeatureNotExistsResult(String identifier) {
		return "Feature \"" + identifier + "\" does not exist.";
	}

	private String createFeatureHasWrongContainmentTypeResult(String identifier, boolean expected) {
		return "Feature \"" + identifier + "\" does exist, but has wrong containment type (expected was: " + expected + ").";
	}
}

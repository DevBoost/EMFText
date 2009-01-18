package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.impl.DelegatingResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;

public class TerminalFeatureReferenceResolver extends AbstractReferenceResolver<Terminal> {
	
	private interface FeatureResolveResult extends IResolveResult {
		public boolean foundFeatureWithCorrectName();
		public void setFoundFeatureWithCorrectName();
	}
	
	private class FeatureResolveResultImpl extends DelegatingResolveResult implements FeatureResolveResult {
		
		private boolean foundFeatureWithCorrectName = false;

		public FeatureResolveResultImpl(IResolveResult result) {
			super(result);
		}

		public boolean foundFeatureWithCorrectName() {
			return foundFeatureWithCorrectName;
		}

		public void setFoundFeatureWithCorrectName() {
			foundFeatureWithCorrectName = true;
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
	protected void doResolve(final String identifier, final Terminal container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		if (resolveFuzzy) {
			doResolveFuzzy(identifier, container, result);
		} else {
			doResolveStrict(identifier, container, result);
		}
	}

	private void doResolveFuzzy(String identifier, Terminal container, IResolveResult result) {
		doResolveFeature(container, new NameStartsWithFilter(identifier), identifier, result);
	}

	private void doResolveStrict(String identifier, Terminal container, IResolveResult result) {
		doResolveFeature(container, new NameAndContainmentFilter(identifier, container), identifier, result);
	}

	private void doResolveFeature(EObject container, GenFeatureFilter filter, String identifier, IResolveResult result) {
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
	public String deResolve(EObject element, Terminal container, EReference reference){
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

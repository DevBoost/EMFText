/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDelegatingResolveResult;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

public class TerminalFeatureReferenceResolver implements ICsReferenceResolver<Terminal, GenFeature> {
	
	private interface FeatureResolveResult extends ICsReferenceResolveResult<GenFeature> {
		public boolean foundFeatureWithCorrectName();
		public void setFoundFeatureWithCorrectName();
	}
	
	private class FeatureResolveResultImpl extends CsDelegatingResolveResult<GenFeature> implements FeatureResolveResult {
		
		private boolean foundFeatureWithCorrectName = false;

		public FeatureResolveResultImpl(ICsReferenceResolveResult<GenFeature> result) {
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

	private class AcceptAllFilter extends NameFilter {

		public AcceptAllFilter(String identifier) {
			super(identifier);
		}

		public void accept(GenFeature feature, FeatureResolveResult result) {
			String featureName = feature.getName();
			result.setFoundFeatureWithCorrectName();
			result.addMapping(featureName, feature);
		}
		
		@Override
		protected boolean doNamesMatch(String identifier, String featureName) {
			return true;
		}
	}

	private class NameAndContainmentFilter extends NameEqualsFilter {

		private final Terminal container;

		private NameAndContainmentFilter(String identifier, Terminal container) {
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

	public void resolve(final String identifier, final Terminal container,
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenFeature> result) {
		if (resolveFuzzy) {
			doResolveFuzzy(identifier, container, result);
		} else {
			doResolveStrict(identifier, container, result);
		}
	}

	private void doResolveFuzzy(String identifier, Terminal container, ICsReferenceResolveResult<GenFeature> result) {
		doResolveFeature(container, new AcceptAllFilter(identifier), identifier, result);
	}

	private void doResolveStrict(String identifier, Terminal container, ICsReferenceResolveResult<GenFeature> result) {
		doResolveFeature(container, new NameAndContainmentFilter(identifier, container), identifier, result);
	}

	private void doResolveFeature(Terminal container, GenFeatureFilter filter, String identifier, ICsReferenceResolveResult<GenFeature> result) {
		Rule rule = getContainingRule(container);
		
		if (rule == null) {
			return;
		}
		GenClass metaclass = rule.getMetaclass();
		if (metaclass.eIsProxy()) {
			return;
		}
		if (metaclass.getEcoreClass() == null) {
			return;
		}
		FeatureResolveResult resultForFeature = new FeatureResolveResultImpl(result);
		List<GenFeature> availableFeatures = metaclass.getAllGenFeatures();
		// for placeholders it is allowed to use an anonymous features,
		// which means that the token is thrown away
		if (container instanceof Placeholder) {
			availableFeatures.add(ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE);
		}
		for (GenFeature feature : availableFeatures) {
			filter.accept(feature, resultForFeature);
		}
		if (resultForFeature.foundFeatureWithCorrectName() && !result.wasResolved()) {
			// found a feature with correct name, but wrong containment
			result.setErrorMessage(createFeatureHasWrongContainmentTypeResult(identifier, getExpectedContainmentValue(container)));
		} else {
			result.setErrorMessage(createFeatureNotExistsResult(identifier));
		}
	}

	public String deResolve(GenFeature feature, Terminal container, EReference reference){
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

	private boolean hasCorrectContainmentType(Terminal container,
			GenFeature genFeature, String featureName) {
		EStructuralFeature feature = genFeature.getEcoreFeature();
		
		boolean isContainment = getContainmentValue(feature);
		boolean expectedValue = getExpectedContainmentValue(container);
		return isContainment == expectedValue;
	}

	private boolean getExpectedContainmentValue(Terminal container) {
		if (container instanceof Containment) {
			//definitely containment
			return true;
		} else if (container instanceof Placeholder) {
			//definitely no containment
			return false;
		} else if (container instanceof BooleanTerminal) {
			//definitely no containment
			return false;
		} else if (container instanceof EnumTerminal) {
			//definitely no containment
			return false;
		} else {
			//Terminal has no other subclasses
			assert(false);
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

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}

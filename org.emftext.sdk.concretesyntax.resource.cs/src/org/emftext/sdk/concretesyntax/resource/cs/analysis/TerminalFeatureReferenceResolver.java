/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.runtime.resource.impl.DelegatingResolveResult;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;

public class TerminalFeatureReferenceResolver extends AbstractReferenceResolver<Terminal, GenFeature> {
	
	private interface FeatureResolveResult extends IReferenceResolveResult<GenFeature> {
		public boolean foundFeatureWithCorrectName();
		public void setFoundFeatureWithCorrectName();
	}
	
	private class FeatureResolveResultImpl extends DelegatingResolveResult<GenFeature> implements FeatureResolveResult {
		
		private boolean foundFeatureWithCorrectName = false;

		public FeatureResolveResultImpl(IReferenceResolveResult<GenFeature> result) {
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
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<GenFeature> result) {
		if (resolveFuzzy) {
			doResolveFuzzy(identifier, container, result);
		} else {
			doResolveStrict(identifier, container, result);
		}
	}

	private void doResolveFuzzy(String identifier, Terminal container, IReferenceResolveResult<GenFeature> result) {
		doResolveFeature(container, new NameStartsWithFilter(identifier), identifier, result);
	}

	private void doResolveStrict(String identifier, Terminal container, IReferenceResolveResult<GenFeature> result) {
		doResolveFeature(container, new NameAndContainmentFilter(identifier, container), identifier, result);
	}

	private void doResolveFeature(Terminal container, GenFeatureFilter filter, String identifier, IReferenceResolveResult<GenFeature> result) {
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
		}
		else {
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

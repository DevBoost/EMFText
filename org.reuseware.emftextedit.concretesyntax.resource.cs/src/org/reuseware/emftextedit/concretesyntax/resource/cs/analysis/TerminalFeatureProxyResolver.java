package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.Placeholder;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class TerminalFeatureProxyResolver extends ProxyResolverImpl {
	
	private class Pair<S,T> {
		public final S left;
		public final T right;

		public Pair(S s, T t) {
			this.left = s;
			this.right = t;
		}
	}
		
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		return doResolveFeature(proxy, container).left;
	}

	private Pair<EObject, Boolean> doResolveFeature(InternalEObject proxy, EObject container) {
		Rule rule = getContainingRule(container);
		
		if (rule.getMetaclass().eIsProxy()) {
			return new Pair<EObject, Boolean>(null, false);
		}
		
		boolean foundFeatureWithCorrectName = false;
		for (GenFeature feature : rule.getMetaclass().getAllGenFeatures()) {
			URI proxyURI = proxy.eProxyURI();
			String featureName = feature.getName();
			if (featureName == null) {
				continue;
			}
			if (featureName.equals(proxyURI.fragment())) {
				foundFeatureWithCorrectName = true;
				boolean isContainment = feature.getEcoreFeature() instanceof EReference && ((EReference)feature.getEcoreFeature()).isContainment();
				
				if(container instanceof Placeholder && !isContainment
					|| container instanceof Containment && isContainment)
					return new Pair<EObject, Boolean>(feature, true);
			}
		}
		return new Pair<EObject, Boolean>(null, foundFeatureWithCorrectName);
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
		} while (rule == null);
		return rule;
	}

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		// TODO it is somewhat stupid to resolve the proxy here again, but
		// the result of doResolve() is not known when this method is
		// called. in order to give a more meaningful error message the 
		// proxy must be resolved again.
		boolean foundFeatureWithCorrectName = doResolveFeature(proxy, container).right;
		if (foundFeatureWithCorrectName) {
			return "Feature \"" + proxy.eProxyURI().fragment() + "\" does exist, but has wrong containment type.";
		} else {
			return "Feature \"" + proxy.eProxyURI().fragment() + "\" does not exist.";
		}
	}
	
	public String deResolve(EObject element, EObject container,EReference reference){
		GenFeature feature = (GenFeature)element;
		return feature.getName();
	}
}

package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;
import org.reuseware.emftextedit.concretesyntax.Placeholder;

public class TerminalFeatureProxyResolver extends ProxyResolverImpl {
		
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		Rule rule = null;
		EObject o = container;
		do {
			if (o instanceof Rule) {
				rule = (Rule) o;
			}
			else {
				o = o.eContainer();
			}
		} while(rule == null);
		
		if (rule.getMetaclass().eIsProxy()) return null;
		
		
		for(GenFeature feature : rule.getMetaclass().getAllGenFeatures()) {
			if (feature.getName().equals(proxy.eProxyURI().fragment())) {
				boolean isContainment = feature.getEcoreFeature() instanceof EReference && ((EReference)feature.getEcoreFeature()).isContainment();
				
				if(container instanceof Placeholder && !isContainment
					|| container instanceof Containment && isContainment)
					return feature;
			}
		}
		
		produceResolveErrorMessage(proxy,container,reference,resource);
		
		return null;
	}

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String msg = "Feature \"" + proxy.eProxyURI().fragment() + "\" does not exist.";
		return msg;
	}
	
	public String deResolve(EObject element, EObject container,EReference reference){
		GenFeature feature = (GenFeature)element;
		return feature.getName();
	}
	
}

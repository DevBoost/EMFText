package org.reuseware.emftextedit.resource.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.reuseware.emftextedit.resource.EMFTextTreeAnalyser;
import org.reuseware.emftextedit.resource.ProxyResolver;
import org.reuseware.emftextedit.resource.TextResource;

/**
 * Base implementation for all generated tree analysers. 
 * It implements the specifications from {@link EMFTextTreeAnalyser}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public class EMFTextTreeAnalyserImpl implements EMFTextTreeAnalyser {
	
	protected ProxyResolver proxyResolver = new ProxyResolverImpl();
	
	@SuppressWarnings("unchecked")
	public void analyse(TextResource resource) {
		
		//for fixpoint iteration
		boolean changed        = true;
		boolean reportErrors   = false;
		
		while(!reportErrors) {
			if (!changed) reportErrors = true;
			changed = false;
			
			for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
				EObject container = i.next();
				for(EStructuralFeature sf : container.eClass().getEAllStructuralFeatures()) {
					
					if (sf instanceof EReference) {
						EReference reference = (EReference) sf;
						Object value = container.eGet(reference, false);
						
						if(value instanceof EList<?>) {
							EList<EObject> l = (EList<EObject>) value;
							for(Object proxy : new BasicEList<EObject>(l)) {
								if (((EObject)proxy).eIsProxy()
										&& /*check if proxy is local*/ ((InternalEObject)proxy
												).eProxyURI().trimFragment().equals(resource.getURI()) ) {
									EObject element = resolve((InternalEObject)proxy, container, 
											reference, resource, reportErrors);
									
									if (element != null) {
										EcoreUtil.replace(container, reference, proxy, element);
										changed = true;
									}
								}
							}
						}
						else if (value != null && ((EObject)value).eIsProxy() 
								&& /*check if proxy is local*/ ((InternalEObject)value).eProxyURI().trimFragment().equals(resource.getURI()) ) {
							EObject element = resolve((InternalEObject)value, container, 
									reference, resource, reportErrors);
							
							if (element != null) {
								container.eSet(reference, element);
								changed = true;
							}
						}
					}
				}
			}
		}
		
	}
	
	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource) {
		return proxyResolver.resolve(proxy, container, reference, resource,true);
	}
	
	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		return proxyResolver.resolve(proxy, container, reference, resource, reportErrors);
	}
	
	public String deResolve(EObject refObject, EObject container, EReference reference) {
		return proxyResolver.deResolve(refObject, container, reference);
	}

	
}

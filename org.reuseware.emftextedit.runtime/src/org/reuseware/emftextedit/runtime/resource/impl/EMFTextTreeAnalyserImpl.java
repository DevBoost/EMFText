package org.reuseware.emftextedit.runtime.resource.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.reuseware.emftextedit.runtime.resource.EMFTextTreeAnalyser;
import org.reuseware.emftextedit.runtime.resource.ProxyResolver;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * Base implementation for all generated tree analysers. 
 * It implements the specifications from {@link EMFTextTreeAnalyser}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public abstract class EMFTextTreeAnalyserImpl implements EMFTextTreeAnalyser {
	
	protected ProxyResolver proxyResolver = new ProxyResolverImpl();
	
	private final static String DUPLICATE_EXCEPTION_MESSAGE = "The 'no duplicates' constraint is violated";
	
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
							//iterate over a list copy with unresolved value
							for(EObject proxy : ((InternalEList<EObject>)l).basicList()) {
								if (proxy.eIsProxy()
										&& /*check if proxy is local*/ ((InternalEObject)proxy
												).eProxyURI().trimFragment().equals(resource.getURI()) ) {
									EObject element = resolve((InternalEObject)proxy, container, 
											reference, resource, reportErrors);
									
									if (element != null) {
										try {
											EcoreUtil.replace(container, reference, proxy, element);
											changed = true;
										} catch (IllegalArgumentException iae) {
											if (DUPLICATE_EXCEPTION_MESSAGE.equals(iae.getMessage())) {
												resource.addError("Reference " + container.eClass().getName() + "." + reference.getName() + " is unique, but same element of type " + element.eClass().getName() + " was found twice.", proxy);
											} else {
												iae.printStackTrace();
											}
										}
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

package org.reuseware.emftextedit.runtime.resource.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.reuseware.emftextedit.runtime.resource.EMFTextTreeAnalyser;
import org.reuseware.emftextedit.runtime.resource.ElementMapping;
import org.reuseware.emftextedit.runtime.resource.IdentifierMapping;
import org.reuseware.emftextedit.runtime.resource.ReferenceMapping;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * Base implementation for all generated tree analysers. 
 * It implements the specifications from {@link EMFTextTreeAnalyser}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public abstract class EMFTextTreeAnalyserImpl implements EMFTextTreeAnalyser {
	
	private final static String DUPLICATE_EXCEPTION_MESSAGE = "The 'no duplicates' constraint is violated";
	
	@SuppressWarnings("unchecked")
	public void analyse(TextResource resource) {
		// TODO only resolve the unresolved proxies
		//for fixpoint iteration
		boolean changed = true;
		
		Map<EObject, ResolveResult> unresolvedProxies = new HashMap<EObject, ResolveResult>();
		while (changed) {
			changed = false;
			unresolvedProxies.clear();
			
			for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
				EObject container = i.next();
				for (EStructuralFeature sf : container.eClass().getEAllStructuralFeatures()) {
					
					if (sf instanceof EReference) {
						EReference reference = (EReference) sf;
						Object value = container.eGet(reference, false);
						
						if (value instanceof EList<?>) {
							EList<EObject> list = (EList<EObject>) value;
							//iterate over a list copy with unresolved value
							int position = 0;
							for (EObject proxy : ((InternalEList<EObject>) list).basicList()) {
								if (!proxy.eIsProxy()) {
									continue;
								}
								if (!isInternalProxy(proxy, container)) {
									continue;
								}
								ResolveResult result = new ResolveResultImpl();
								resolve(((InternalEObject)proxy).eProxyURI().fragment(), container, 
										reference, position, false, result);
								
								assert result != null;
								if (result.wasNotResolved()) {
									unresolvedProxies.put(proxy, result);										
								} else {
									int proxyPosition = list.indexOf(proxy);
									boolean success = list.remove(proxy);
									assert success;
									for (ReferenceMapping mapping : result.getMappings()) {
										EObject target = null;
										if (mapping instanceof ElementMapping) {
											target = ((ElementMapping) mapping).getTargetElement();
										} else if (mapping instanceof IdentifierMapping) {
											target = EcoreUtil.copy(proxy);
											String uri = ((IdentifierMapping) mapping).getTargetIdentifier();
											((InternalEObject) target).eSetProxyURI(URI.createURI(uri));
										} else {
											assert false;
										}
										try {
											if (proxyPosition == list.size()) {
												list.add(target);
											} else {
												list.add(proxyPosition++, target);
											}
											//EcoreUtil.replace(container, reference, proxy, target);
											changed = true;
										} catch (IllegalArgumentException iae) {
											if (DUPLICATE_EXCEPTION_MESSAGE.equals(iae.getMessage())) {
												resource.addError("Reference " + container.eClass().getName() + "." + reference.getName() + " is unique, but same element of type " + target.eClass().getName() + " was found twice.", proxy);
											} else {
												iae.printStackTrace();
											}
										}
									}
								}
								position++;
							}
						} else if (value != null && ((EObject) value).eIsProxy()) {
							EObject proxy = (EObject) value;
							if (!isInternalProxy(proxy, container)) {
								continue;
							}
							ResolveResult result = new ResolveResultImpl();
							resolve(((InternalEObject)value).eProxyURI().fragment(), container, 
									reference, 0, false, result);
							
							assert result != null;
							if (result.wasNotResolved()) {
								unresolvedProxies.put((EObject) value, result);
							} else if (result.wasResolvedUniquely()) {
								ReferenceMapping mapping = result.getMappings().iterator().next();
								if (mapping instanceof ElementMapping) {
									EObject target = ((ElementMapping) mapping).getTargetElement();
									container.eSet(reference, target);
								} else if (mapping instanceof IdentifierMapping) {
									String uri = ((IdentifierMapping) mapping).getTargetIdentifier();
									((InternalEObject) proxy).eSetProxyURI(URI.createURI(uri));
								} else {
									assert false;
								}
								changed = true;
							} else {
								// TODO mseifert: add error if multiple objects returned by a resolver
							}
						}
					}
				}
			}
		}
		// attach errors to resource
		for (EObject unresolvedProxy : unresolvedProxies.keySet()) {
			ResolveResult result = unresolvedProxies.get(unresolvedProxy);
			assert result != null;
			String errorMessage = result.getErrorMessage();
			if (errorMessage == null) {
				resource.addError(getErrorMessage(((InternalEObject) unresolvedProxy).eProxyURI().fragment()), unresolvedProxy);
			} else {
				resource.addError(errorMessage, unresolvedProxy);
			}
		}
	}

	private boolean isInternalProxy(EObject proxy, EObject container) {
		return ((InternalEObject) proxy).eProxyURI().trimFragment().equals(container.eResource().getURI());
	}


	/**
	 * Produces a standard error message using the reference type
	 * and the proxy URI fragment.
	 * 
	 * @param identifier The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @return The error message.
	 */
	private String getErrorMessage(String identifier) {
		return " \"" + identifier + "\" not declared";  
	}
}

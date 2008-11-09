package org.reuseware.emftextedit.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A proxy resolver tries to resolve a proxy by replacing it with another non-proxy object 
 * in the same tree.
 * 
 * @author Jendrik Johannes (jj2)
 *
 */
public interface ProxyResolver {
	
	/**
	 * Attempts to resolve a proxy object.
	 * 
	 * @param proxy The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @param reportErrors Whether resolution errors should be reported as diagnostics in the resource.
	 * @return The resolved object.
	 */
	public EObject resolve(EObject proxy, EObject container, 
			EReference reference, TextResource resource, boolean reportErrors);
	
	/**
	 * Attempts to resolve a proxy object. This method should reports all errors.
	 * 
	 * @param proxy The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @return The resolved object.
	 */
	public EObject resolve(EObject proxy, EObject container, 
			EReference reference, TextResource resource);
	
	/**
	 * Reverse of the resolve operation: constructs a representing String of the given
	 * object.
	 * 
	 * @param proxy The model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element. 
	 * @return The identification string for the proxy
	 */	
	public String deResolve(EObject element, EObject container,EReference reference);
	
}

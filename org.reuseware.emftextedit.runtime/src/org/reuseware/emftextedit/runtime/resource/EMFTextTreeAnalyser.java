package org.reuseware.emftextedit.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Analyses the output of a <code>EMFTextParser</code> (that is a tree of <code>EObject</code>s)
 * and resolves proxies in this output.
 * 
 * @author Jendrik Johannes (jj2)
 */
public interface EMFTextTreeAnalyser {
	
	/**
	 * Do the analysis. Resolves all proxies or attaches diagnostics to the given text resource,
	 * if resolving is not possible.
	 * 
	 * @param resource The text resource with the content to analyse.
	 */
	public void analyse(TextResource resource);

	
	/**
	 * Attempts to resolve a proxy object by invoking an adequate proxy resolver. 
	 * The resolver may report errors.
	 * 
	 * @param proxy The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @return The resolved object.
	 */	
	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErros);
	
	
	/**
	 * Delegates a de - resolvement step to a proxy resolver. This method should be used instead of revert 
	 * if the containing model has not be changed.
	 * 
	 * @param refObject The reference value.
	 * @param container The reference holder.
	 * @param reference The reference.
	 * @return The replacement String for value (might be null)
	 */
	public String deResolve(EObject refObject, EObject container, EReference reference);
	
	

}

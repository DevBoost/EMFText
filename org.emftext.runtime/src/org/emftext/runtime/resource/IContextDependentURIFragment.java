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
package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An <code>IContextDependentURIFragment</code> points at an element
 * referenced from another element throughan  <code>identifier</code>.
 * In contrast to a normal EMF URI fragment (<code>URI.fragment</code>), 
 * which is a String that can be resolved to an element within a 
 * <code>Resource</code>, the <code>identifier</code> of a 
 * <code>IContextDependentURIFragment</code> does not have
 * to be globally unique. 
 * <p>
 * An <code>IContextDependentURIFragment</code> is registered 
 * a <code>ITextResource</code> for a proxy for which it defines the URI fragment.
 * <code>ITextResource.getEObject()</code> uses the 
 * <code>IContextDependentURIFragment.resolve()</code> instead of the normal
 * <code>URI.fragment</code>-based resolving when an
 * <code>IContextDependentURIFragment.resolve()</code> is available.
 * 
 * @param <ReferenceType> the type of the reference that can be resolved by this fragment
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 * 
 * TODO figure out whether this interface must really be exposed
 */
public interface IContextDependentURIFragment<ReferenceType extends EObject> {

	/**
	 * A prefix that can be used in a <code>URI.fragment</code> String of a proxy
	 * to indicate the existence of an <code>IContextDependentURIFragment</code>.
	 */
	public static final String INTERNAL_URI_FRAGMENT_PREFIX = "EMFTEXT_INTERNAL_URI_FRAGMENT_";
	
	/**
	 * @return The proxy object.
	 */
	public EObject getProxy();
	
	/**
	 * @return An identifier that identifies the element(s) at which the proxy points in context.
	 */
	public String getIdentifier();

	/**
	 * @return The element that references the proxy.
	 */
	public EObject getContainer();

	/**
	 * @return The references of the container's <code>EClass</code> that holds the proxy.
	 */
	public EReference getReference();
	
	/**
	 * @return The position if reference is multiple; -1 otherwise.
	 */
	public int getPositionInReference();

	/**
	 * Resolves the proxy to the real element(s) using context information.
	 * 
	 * @return result of resolving process
	 */
	public IReferenceResolveResult<ReferenceType> resolve();
	
	/**
	 * @return <code>true</code> if <code>resolve()</code> was called successfully before.
	 */
	public boolean isResolved();
}

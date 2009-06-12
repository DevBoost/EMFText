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
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IElementMapping;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.IURIMapping;
import org.emftext.runtime.util.CastUtil;

/**
 * Standard implementation of <code>IContextDependentURIFragment</code>.
 * 
 * @param <ContainerType> the type of the object that contains the reference which shall be resolved by this fragment.
 * @param <ReferenceType> the type of the reference which shall be resolved by this fragment.
 */
public abstract class ContextDependentURIFragment<ContainerType extends EObject, ReferenceType extends EObject> implements IContextDependentURIFragment<ReferenceType> {

	protected String     identifier;
	protected ContainerType    container;
	protected EReference reference;
	protected int        positionInReference;
	protected EObject    proxy;
	protected IReferenceResolveResult<ReferenceType> result;
	
	private boolean resolving;
	
	public ContextDependentURIFragment(String identifier, ContainerType container,
			EReference reference, int positionInReference, EObject proxy) {
		this.identifier = identifier;
		this.container = container;
		this.reference = reference;
		this.positionInReference = positionInReference;
		this.proxy = proxy;
	}

	public boolean isResolved() {
		return result != null;
	}
	
	public synchronized IReferenceResolveResult<ReferenceType> resolve() {
		if (resolving) {
			return null;
		}
		resolving = true;
		if (result == null || !result.wasResolved()) {
			result = new ReferenceResolveResult<ReferenceType>(false);
			//set an initial default error message
			result.setErrorMessage(getStdErrorMessage());
			
			IReferenceResolver<ContainerType, ReferenceType> resolver = getResolver();
			//do the actual resolving
			resolver.resolve(
					this.getIdentifier(),
					this.getContainer(), 
					this.getReference(), 
					this.getPositionInReference(), 
					false, result);
			
			//EMFText allows proxies to resolve to multiple objects
			//the first is returned, the others are added here to the reference
			if(result.wasResolvedMultiple()) {
				handleMultipleResults();
			}
			
		}
		resolving = false;
		return result;
	}
	
	public abstract IReferenceResolver<ContainerType, ReferenceType> getResolver();

	private void handleMultipleResults() {
		EList<EObject> list = null;
		Object temp = container.eGet(reference);
		if (temp instanceof EList<?>) {
			list = CastUtil.cast(temp);
		}
		
		boolean first = true; 
		for(IReferenceMapping<ReferenceType> mapping : result.getMappings()) {
			if (first) {
				first = false;
			}
			else if (list != null) {
				addResultToList(mapping, proxy, list);
			}
			else {
				EMFTextRuntimePlugin.logError(
						container.eClass().getName() +
						"." + reference.getName() + 
						" has multiplicity 1 but was resolved to multiple elements", 
						null);
			}
		}
	}

	private void addResultToList(IReferenceMapping<ReferenceType> mapping, EObject proxy, EList<EObject> list) {
		EObject target = null;
		int proxyPosition = list.indexOf(proxy);
		
		if (mapping instanceof IElementMapping<?>) {
			target = ((IElementMapping<ReferenceType>) mapping).getTargetElement();
		} else if (mapping instanceof IURIMapping<?>) {
			target = EcoreUtil.copy(proxy);
			URI uri = ((IURIMapping<ReferenceType>) mapping).getTargetIdentifier();
			((InternalEObject) target).eSetProxyURI(uri);
		} else {
			assert false;
		}
		try {
			// if target is an another proxy and list is "unique" 
			// add() will try to resolve the new proxy to check for uniqueness.
			// There seems to be no way to avoid that. Until now this does not 
			// cause any problems.
			if (proxyPosition + 1 == list.size()) {
				list.add(target);
			} else {
				list.add(proxyPosition + 1, target);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private String getStdErrorMessage() {
		String typeName = this.getReference().getEType().getName();
		String msg = typeName + " '" + identifier + "' not declared";  
		return msg;
	}
	
	
	public String getIdentifier() {
		return identifier;
	}

	public ContainerType getContainer() {
		return container;
	}

	public EReference getReference() {
		return reference;
	}

	public int getPositionInReference() {
		return positionInReference;
	}

	public EObject getProxy() {
		return proxy;
	}

}

package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.IElementMapping;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.IURIMapping;

/**
 * TODO jjohannes: add documentation
 */
public class ContextDependentURIFragment {

	protected String     identifier;
	protected EObject    container;
	protected EReference reference;
	protected int        positionInReference;
	protected EObject    proxy;
	protected IResolveResult result;
	
	private boolean resolving;
	
	public ContextDependentURIFragment(String identifier, EObject container,
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
	
	public synchronized IResolveResult resolve(IReferenceResolverSwitch resolverSwitch) {
		if (resolving) {
			return null;
		}
		resolving = true;
		if (result == null || !result.wasResolved()) {
			result = new ResolveResult(false);
			//set an initial default error message
			result.setErrorMessage(getStdErrorMessage());
			//do the actual resolving
			resolverSwitch.resolve(
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

	private void handleMultipleResults() {
		EList<EObject> list = null;
		Object temp = container.eGet(reference);
		if (temp instanceof EList) {
			list = Util.cast(temp);
		}
		
		boolean first = true; 
		for(IReferenceMapping mapping : result.getMappings()) {
			if (first) {
				first = false;
			}
			else if (list != null) {
				addResultToList(mapping, proxy, list);
			}
			else {
				EMFTextPlugin.logError("", null);
			}
		}
	}

	private void addResultToList(IReferenceMapping mapping, EObject proxy, EList<EObject> list) {
		EObject target = null;
		int proxyPosition = list.indexOf(proxy);
		
		if (mapping instanceof IElementMapping) {
			target = ((IElementMapping) mapping).getTargetElement();
		} else if (mapping instanceof IURIMapping) {
			target = EcoreUtil.copy(proxy);
			URI uri = ((IURIMapping) mapping).getTargetIdentifier();
			((InternalEObject) target).eSetProxyURI(uri);
		} else {
			assert false;
		}
		try {
			if (proxyPosition + 1 == list.size()) {
				list.add(target);
			} else {
				//TODO jjohannes: if target is an external proxy and list is "unique" 
				//     add() will try to resolve the external proxy to check for uniqueness.
				//     That should be avoided somehow...
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

	public EObject getContainer() {
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

package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ContextDependentURIFragment {

	protected String     identifier;
	protected EObject    container;
	protected EReference reference;
	protected int        positionInReference;
	protected EObject    proxy;
	
	public ContextDependentURIFragment(String identifier, EObject container,
			EReference reference, int positionInReference, EObject proxy) {
		this.identifier = identifier;
		this.container = container;
		this.reference = reference;
		this.positionInReference = positionInReference;
		this.proxy = proxy;
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

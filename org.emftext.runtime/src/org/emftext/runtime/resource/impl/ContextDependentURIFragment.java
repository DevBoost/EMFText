package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.EMFTextTreeAnalyser;
import org.emftext.runtime.resource.ResolveResult;

public class ContextDependentURIFragment {

	protected String     identifier;
	protected EObject    container;
	protected EReference reference;
	protected int        positionInReference;
	protected EObject    proxy;
	protected ResolveResult result;
	
	public ContextDependentURIFragment(String identifier, EObject container,
			EReference reference, int positionInReference, EObject proxy) {
		this.identifier = identifier;
		this.container = container;
		this.reference = reference;
		this.positionInReference = positionInReference;
		this.proxy = proxy;
		

	}
	
	public ResolveResult resolve(EMFTextTreeAnalyser treeAnalyser) {
		if (result == null) {
			result = new ResolveResultImpl(false);
			//set an initial default error message
			result.setErrorMessage(getStdErrorMessage());
			//do the actual resolving
			treeAnalyser.resolve(
					this.getIdentifier(),
					this.getContainer(), 
					this.getReference(), 
					this.getPositionInReference(), 
					false, result);
		}
		return result;
	}
	
	public boolean isResolved() {
		return result != null;
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

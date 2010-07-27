/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public abstract class CsQuickFix implements org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix {
	
	private String displayString;
	private org.eclipse.emf.ecore.resource.Resource resource;
	private java.util.Collection<org.eclipse.emf.ecore.EObject> contextObjects;
	
	public CsQuickFix(String displayString, org.eclipse.emf.ecore.EObject contextObject) {
		super();
		if (displayString == null) {
			throw new IllegalArgumentException("displayString must not be null.");
		}
		if (contextObject == null) {
			throw new IllegalArgumentException("contextObject must not be null.");
		}
		this.displayString = displayString;
		this.contextObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(1);
		this.contextObjects.add(contextObject);
		this.resource = contextObject.eResource();
	}
	
	public CsQuickFix(String displayString, java.util.Collection<org.eclipse.emf.ecore.EObject> contextObjects) {
		super();
		if (displayString == null) {
			throw new IllegalArgumentException("displayString must not be null.");
		}
		if (contextObjects == null) {
			throw new IllegalArgumentException("contextObjects must not be null.");
		}
		if (contextObjects.isEmpty()) {
			throw new IllegalArgumentException("contextObjects must not be empty.");
		}
		this.displayString = displayString;
		this.contextObjects = contextObjects;
		this.resource = contextObjects.iterator().next().eResource();
	}
	
	public CsQuickFix(String displayString, java.util.Collection<org.eclipse.emf.ecore.EObject> contextObjects, org.eclipse.emf.ecore.resource.Resource resource) {
		super();
		if (displayString == null) {
			throw new IllegalArgumentException("displayString must not be null.");
		}
		if (contextObjects == null) {
			throw new IllegalArgumentException("contextObjects must not be null.");
		}
		if (contextObjects.isEmpty()) {
			throw new IllegalArgumentException("contextObjects must not be empty.");
		}
		this.displayString = displayString;
		this.contextObjects = contextObjects;
		this.resource = resource;
	}
	
	public String apply(String currentText) {
		applyChanges();
		try {
			java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
			getResource().save(output, null);
			return output.toString();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract void applyChanges();
	
	public org.eclipse.emf.ecore.resource.Resource getResource() {
		return resource;
	}
	
	public String getDisplayString() {
		return displayString;
	}
	
	public java.util.Collection<org.eclipse.emf.ecore.EObject> getContextObjects() {
		return contextObjects;
	}
	
	public String getContextAsString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append(getType());
		result.append(",");
		for (org.eclipse.emf.ecore.EObject contextObject : contextObjects) {
			result.append(org.eclipse.emf.ecore.util.EcoreUtil.getURI(contextObject));
			result.append(",");
		}
		return result.toString();
	}
	
	private String getType() {
		return this.getClass().getName();
	}
	
}

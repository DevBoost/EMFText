/*******************************************************************************
 * Copyright (c) 2006-2013
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsParseResult implements org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap;
	
	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> commands = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>>();
	
	public CsParseResult() {
		super();
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> getPostParseCommands() {
		return commands;
	}
	
}

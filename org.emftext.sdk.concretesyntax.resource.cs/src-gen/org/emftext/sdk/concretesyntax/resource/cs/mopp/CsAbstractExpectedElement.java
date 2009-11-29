/*******************************************************************************
 * Copyright (c) 2006-2009 
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

// Abstract super class for all expected elements. Provides methods to
// add followers
public abstract class CsAbstractExpectedElement implements org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement {
	
	private java.util.Set<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> followers = new java.util.LinkedHashSet<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement>();
	
	public CsAbstractExpectedElement() {
		super();
	}
	
	public void addFollower(org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement follower) {
		followers.add(follower);
	}
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> getFollowers() {
		return followers;
	}
	
}

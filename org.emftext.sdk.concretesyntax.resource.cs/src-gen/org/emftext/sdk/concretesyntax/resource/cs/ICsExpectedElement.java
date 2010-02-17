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

package org.emftext.sdk.concretesyntax.resource.cs;

// An element that is expected at a given position in a resource
// stream.
public interface ICsExpectedElement {
	
	public java.lang.String getTokenName();
	public void addFollower(org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement follower);
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> getFollowers();
}

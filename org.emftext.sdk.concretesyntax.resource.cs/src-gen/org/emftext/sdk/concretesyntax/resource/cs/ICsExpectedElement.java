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

package org.emftext.sdk.concretesyntax.resource.cs;

// An element that is expected at a given position in a resource
// stream.
public interface ICsExpectedElement {
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens);
	public int getStartExcludingHiddenTokens();
	public int getStartIncludingHiddenTokens();
	public String getPrefix();
	public void setPrefix(String prefix);
	public int getFollowSetID();
}

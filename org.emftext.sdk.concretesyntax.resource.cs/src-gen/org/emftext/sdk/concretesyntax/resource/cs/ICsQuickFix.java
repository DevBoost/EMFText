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

public interface ICsQuickFix {
	
	/**
	 * Returns a string that briefly describes the quick fix.
	 * 
	 * @return brief description to display
	 */
	public String getDisplayString();
	
	/**
	 * Applies the fix and returns the new text for the resource. If the fix does not
	 * change the current resource, but others, null must be returned.
	 */
	public String apply(String currentText);
	
	/**
	 * Returns a collection of objects the fix refers to. This collection is used to
	 * check whether the fix is can still be applied even after a workbench restart.
	 */
	public java.util.Collection<org.eclipse.emf.ecore.EObject> getContextObjects();
	
	public String getContextAsString();
	
}

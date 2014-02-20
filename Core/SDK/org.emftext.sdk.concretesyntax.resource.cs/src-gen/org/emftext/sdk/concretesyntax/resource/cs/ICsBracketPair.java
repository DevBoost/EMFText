/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs;


/**
 * A simple interface to access information about bracket handling.
 */
public interface ICsBracketPair {
	
	/**
	 * Returns the opening bracket.
	 */
	public String getOpeningBracket();
	
	/**
	 * Returns the closing bracket.
	 */
	public String getClosingBracket();
	
	/**
	 * Returns whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public boolean isClosingEnabledInside();
	
	/**
	 * Sets whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public void setClosingEnabledInside(boolean closingEnabledInside);
	
	/**
	 * Returns whether this bracket pair shall be automatically closed, when a line
	 * break is entered. If this method returns false, the closing bracket is inserted
	 * right away when the opening bracket is typed.
	 */
	public boolean isCloseAfterEnter();
	
	/**
	 * Sets whether this bracket pair shall be automatically closed, when a line break
	 * is entered. If this method returns false, the closing bracket is inserted right
	 * away when the opening bracket is typed.
	 */
	public void setCloseAfterEnter(boolean closingAfterEnter);
	
}

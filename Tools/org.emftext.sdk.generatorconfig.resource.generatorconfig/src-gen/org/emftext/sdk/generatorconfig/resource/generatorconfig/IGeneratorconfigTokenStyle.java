/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.generatorconfig.resource.generatorconfig;

// A common interface for token styles. Text resources must
// return style information using object implementing this
// interface.
public interface IGeneratorconfigTokenStyle {

	// Returns the color of the token as array of length 3.
	public int[] getColorAsRGB();

	// Returns true if the token must be displayed in bold face.
	public boolean isBold();

	// Returns true if the token must be displayed in italic face.
	public boolean isItalic();

	// Returns true if the token must be displayed in strike through style.
	public boolean isStrikethrough();

	// Returns true if the token must be displayed underline.
	public boolean isUnderline();
}

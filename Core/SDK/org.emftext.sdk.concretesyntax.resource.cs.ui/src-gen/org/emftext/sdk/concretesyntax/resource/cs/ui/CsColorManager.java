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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A class for RGB-based color objects.
 */
public class CsColorManager {
	
	protected java.util.Map<org.eclipse.swt.graphics.RGB, org.eclipse.swt.graphics.Color> fColorTable = new java.util.LinkedHashMap<org.eclipse.swt.graphics.RGB, org.eclipse.swt.graphics.Color>(10);
	
	/**
	 * Disposes all colors in the cache.
	 */
	public void dispose() {
		java.util.Iterator<org.eclipse.swt.graphics.Color> e = fColorTable.values().iterator();
		while (e.hasNext()) {
			e.next().dispose();
		}
	}
	
	/**
	 * Constructs and caches the given color.
	 * 
	 * @param rgb The color as org.eclipse.swt.graphics.RGB
	 * 
	 * @return The color (from cache or newly constructed)
	 */
	public org.eclipse.swt.graphics.Color getColor(org.eclipse.swt.graphics.RGB rgb) {
		org.eclipse.swt.graphics.Color color = fColorTable.get(rgb);
		if (color == null) {
			color = new org.eclipse.swt.graphics.Color(org.eclipse.swt.widgets.Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}

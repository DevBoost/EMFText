/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.composites;

/**
 * A custom StringComposite that can be used to build manifests
 * for Eclipse plug-ins.
 */
public class ManifestComposite extends StringComposite {

	public ManifestComposite() {
		super(true);
	}

	@Override
	protected boolean isLineBreaker(Component component) {
		return true;
	}
}

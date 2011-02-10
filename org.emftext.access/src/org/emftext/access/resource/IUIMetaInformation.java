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
package org.emftext.access.resource;

public interface IUIMetaInformation extends IMetaInformation {

	public IColorManager createColorManager();
	
	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 * 
	 * @deprecated this method is only available for plug-ins generated with EMFText 1.3.0 or before
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IColorManager colorManager);

	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 * 
	 * @since EMFText 1.3.1
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IResource resource, IColorManager colorManager);
}

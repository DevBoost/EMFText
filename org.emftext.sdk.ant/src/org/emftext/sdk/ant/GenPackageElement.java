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
package org.emftext.sdk.ant;

/**
 * This class is used to represent nested 'genPackage'
 * elements that can be used in a {@link GenerateTextResourceTask}.
 */
public class GenPackageElement {

	private String namespaceURI;
	private String ePackageClassName;

	public String getNamespaceURI() {
		return namespaceURI;
	}
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	public String getEPackageClassName() {
		return ePackageClassName;
	}
	public void setEPackageClassName(String packageClassName) {
		ePackageClassName = packageClassName;
	}
}

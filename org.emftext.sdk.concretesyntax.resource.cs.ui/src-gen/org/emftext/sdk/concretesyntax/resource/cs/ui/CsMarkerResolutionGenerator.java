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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsMarkerResolutionGenerator implements org.eclipse.ui.IMarkerResolutionGenerator, org.eclipse.ui.IMarkerResolution {
	
	public org.eclipse.ui.IMarkerResolution[] getResolutions(org.eclipse.core.resources.IMarker marker) {
		return new org.eclipse.ui.IMarkerResolution[] {this};
	}
	
	public String getLabel() {
		return "I do fix";
	}
	
	public void run(org.eclipse.core.resources.IMarker marker) {
		System.out.println("CsMarkerResolutionGenerator.run()");
	}
	
}

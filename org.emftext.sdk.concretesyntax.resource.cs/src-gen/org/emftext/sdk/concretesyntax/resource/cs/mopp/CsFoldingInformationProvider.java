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
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsFoldingInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
		};
	}
	
}

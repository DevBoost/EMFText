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
package org.emftext.test.code_completion.test.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.test.code_completion.test.access.IExpectedStructuralFeature;

public class ExpectedStructuralFeature implements IExpectedStructuralFeature {

	private EStructuralFeature feature;

	public ExpectedStructuralFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public String toString() {
		return "EFeature " + feature.getEContainingClass().getName() + "." + feature.getName();
	}
}

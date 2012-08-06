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
package org.emftext.sdk.codegen.resource.generators.code_completion.helpers;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * A ContainmentLink represents a containment feature in the context of a 
 * metaclass.
 */
public class ContainmentLink {

	private GenClass containerClass;
	private GenFeature genFeature;
	
	public ContainmentLink(GenClass containerClass, GenFeature genFeature) {
		super();
		this.containerClass = containerClass;
		this.genFeature = genFeature;
	}
	
	public GenClass getContainerClass() {
		return containerClass;
	}

	public GenFeature getFeature() {
		return genFeature;
	}
	
	public String toString() {
		return genFeature.getName() + "->" + containerClass.getName();
	}
}

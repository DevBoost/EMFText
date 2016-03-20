/*******************************************************************************
 * Copyright (c) 2006-2015
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
 * A ContainmentLink represents a containment feature in the context of a metaclass.
 */
public class ContainmentLink {

	private final GenClass containerClass;
	private final GenFeature genFeature;
	
	public ContainmentLink(GenClass containerClass, GenFeature genFeature) {
		this.containerClass = containerClass;
		this.genFeature = genFeature;
	}
	
	public GenClass getContainerClass() {
		return containerClass;
	}

	public GenFeature getFeature() {
		return genFeature;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((containerClass == null) ? 0 : containerClass.hashCode());
		result = prime * result + ((genFeature == null) ? 0 : genFeature.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ContainmentLink other = (ContainmentLink) obj;
		if (containerClass == null) {
			if (other.containerClass != null) {
				return false;
			}
		} else if (!containerClass.equals(other.containerClass)) {
			return false;
		}
		if (genFeature == null) {
			if (other.genFeature != null) {
				return false;
			}
		} else if (!genFeature.equals(other.genFeature)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return genFeature.getName() + "->" + containerClass.getName();
	}
}

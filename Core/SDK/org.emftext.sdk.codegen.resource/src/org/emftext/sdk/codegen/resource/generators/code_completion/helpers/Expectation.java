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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;

/**
 * A container class that holds the expected element (i.e., an object contained 
 * in a concrete syntax rule) and some information about the path to the 
 * expected element (starting from the element used to compute the expectation).
 */
public class Expectation {

	private GenClass metaClass;
	private EObject expectedElement;
	private List<ContainmentLink> containmentTrace;
	
	public Expectation(EObject expectedElement) {
		super();
		this.expectedElement = expectedElement;
	}
	
	public GenClass getMetaClass() {
		return metaClass;
	}
	
	public void setMetaClass(GenClass metaClass) {
		this.metaClass = metaClass;
	}

	public EObject getExpectedElement() {
		return expectedElement;
	}

	public List<ContainmentLink> getContainmentTrace() {
		if (containmentTrace == null) {
			containmentTrace = new ArrayList<ContainmentLink>(1);
		}
		return containmentTrace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((containmentTrace == null) ? 0 : containmentTrace.hashCode());
		result = prime * result
				+ ((expectedElement == null) ? 0 : expectedElement.hashCode());
		result = prime * result
				+ ((metaClass == null) ? 0 : metaClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expectation other = (Expectation) obj;
		if (containmentTrace == null) {
			if (other.containmentTrace != null)
				return false;
		} else if (!containmentTrace.equals(other.containmentTrace))
			return false;
		if (expectedElement == null) {
			if (other.expectedElement != null)
				return false;
		} else if (!expectedElement.equals(other.expectedElement))
			return false;
		if (metaClass == null) {
			if (other.metaClass != null)
				return false;
		} else if (!metaClass.equals(other.metaClass))
			return false;
		return true;
	}

	public String toString() {
		return "Expectation(" + expectedElement + ") " + containmentTrace;
	}
}

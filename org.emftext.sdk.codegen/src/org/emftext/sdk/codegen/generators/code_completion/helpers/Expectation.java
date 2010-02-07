package org.emftext.sdk.codegen.generators.code_completion.helpers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;

/**
 * A container class that holds the expected element (i.e.,
 * an object contained in a concrete syntax rule) and some
 * information about the path to the expected element 
 * (starting from the element used to compute the expectation).
 */
public class Expectation {

	private EObject expectedElement;
	private List<GenFeature> containmentTrace;
	
	public Expectation(EObject expectedElement) {
		super();
		this.expectedElement = expectedElement;
	}
	
	public EObject getExpectedElement() {
		return expectedElement;
	}

	public List<GenFeature> getContainmentTrace() {
		if (containmentTrace == null) {
			containmentTrace = new ArrayList<GenFeature>(1);
		}
		return containmentTrace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expectedElement == null) ? 0 : expectedElement.hashCode());
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
		Expectation other = (Expectation) obj;
		if (expectedElement == null) {
			if (other.expectedElement != null) {
				return false;
			}
		} else if (!expectedElement.equals(other.expectedElement)) {
			return false;
		}
		return true;
	}
}

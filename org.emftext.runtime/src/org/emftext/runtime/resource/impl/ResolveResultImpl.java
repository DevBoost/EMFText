package org.emftext.runtime.resource.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ReferenceMapping;
import org.emftext.runtime.resource.ResolveResult;

public class ResolveResultImpl implements ResolveResult {
	
	private Collection<ReferenceMapping> mappings;
	private String errorMessage;

	public ResolveResultImpl() {
		super();
	}

	public String getErrorMessage() {
		assert mappings == null || mappings.size() == 0;
		return errorMessage;
	}

	public Collection<ReferenceMapping> getMappings() {
		assert errorMessage == null;
		return mappings;
	}

	public boolean wasResolved() {
		return mappings != null;
	}

	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}

	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}

	public void setErrorMessage(String message) {
		if (mappings != null) {
			return;
		}
		errorMessage = message;
	}

	public void addMapping(String identifier, EObject target) {
		addMapping(identifier, target, null);
	}

	public void addMapping(String identifier, EObject target, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<ReferenceMapping>();
		}
		mappings.add(new ElementMappingImpl(identifier, target, warning));
		errorMessage = null;
	}

	public void addMapping(String identifier, String newIdentifier) {
		addMapping(identifier, newIdentifier, null);
	}
	
	public void addMapping(String identifier, String newIdentifier, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<ReferenceMapping>();
		}
		mappings.add(new IdentifierMappingImpl(identifier, newIdentifier, warning));
	}
}

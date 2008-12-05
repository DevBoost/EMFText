package org.reuseware.emftextedit.runtime.resource.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.runtime.resource.IdentifierMapping;
import org.reuseware.emftextedit.runtime.resource.ReferenceMapping;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;

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

	public boolean wasNotResolved() {
		return mappings == null;
	}

	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}

	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}

	public void addError(String message) {
		if (mappings != null) {
			return;
		}
		errorMessage = message;
	}

	public void addMapping(String identifier, EObject target) {
		if (mappings == null) {
			mappings = new ArrayList<ReferenceMapping>();
		}
		mappings.add(new ElementMappingImpl(identifier, target));
		errorMessage = null;
	}

	public void addMapping(String identifier, String newIdentifier) {
		if (mappings == null) {
			mappings = new ArrayList<ReferenceMapping>();
		}
		mappings.add(new IdentifierMappingImpl(identifier, newIdentifier));
	}
}

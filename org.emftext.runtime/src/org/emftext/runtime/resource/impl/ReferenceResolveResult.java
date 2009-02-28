package org.emftext.runtime.resource.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;

/**
 * A basic implementation of IResolveResult interface
 * that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this result
 */
public class ReferenceResolveResult<ReferenceType> implements IReferenceResolveResult<ReferenceType> {
	
	private Collection<IReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;

	public ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Collection<IReferenceMapping<ReferenceType>> getMappings() {
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
		errorMessage = message;
	}

	public void addMapping(String identifier, ReferenceType target) {
		if (resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}

	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<IReferenceMapping<ReferenceType>>();
		}
		mappings.add(new ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}

	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<IReferenceMapping<ReferenceType>>();
		}
		mappings.add(new URIMapping<ReferenceType>(identifier, uri, warning));
	}
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolveResult interface that
 * collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class Cct5ReferenceResolveResult<ReferenceType> implements org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolveResult<ReferenceType> {
	
	private Collection<org.emftext.test.cct5.resource.cct5.ICct5ReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> quickFixes;
	
	public Cct5ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.test.cct5.resource.cct5.ICct5QuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.test.cct5.resource.cct5.ICct5QuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.test.cct5.resource.cct5.ICct5QuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5ReferenceMapping<ReferenceType>> getMappings() {
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
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5URIMapping<ReferenceType>(identifier, uri, warning));
	}
}

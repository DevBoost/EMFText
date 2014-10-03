/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * org.emftext.test.cct5.resource.cct5.ICct5URIMapping interface that can map
 * identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.test.cct5.resource.cct5.ICct5URIMapping.
 */
public class Cct5URIMapping<ReferenceType> implements org.emftext.test.cct5.resource.cct5.ICct5URIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public Cct5URIMapping(String identifier, URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}

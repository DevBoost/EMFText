/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class Cct5ParseResult implements org.emftext.test.cct5.resource.cct5.ICct5ParseResult {
	
	private EObject root;
	
	private org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap;
	
	private Collection<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>> commands = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>>();
	
	public Cct5ParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5LocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>> getPostParseCommands() {
		return commands;
	}
	
}

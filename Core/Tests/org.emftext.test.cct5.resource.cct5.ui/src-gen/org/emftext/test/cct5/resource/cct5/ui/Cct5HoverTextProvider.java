/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.emf.ecore.EObject;

public class Cct5HoverTextProvider implements org.emftext.test.cct5.resource.cct5.ICct5HoverTextProvider {
	
	private org.emftext.test.cct5.resource.cct5.ui.Cct5DefaultHoverTextProvider defaultProvider = new org.emftext.test.cct5.resource.cct5.ui.Cct5DefaultHoverTextProvider();
	
	public String getHoverText(EObject container, EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}

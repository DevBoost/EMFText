package org.emftext.sdk.concretesyntax.resource.cs;

public class CsHoverTextProvider extends org.emftext.runtime.resource.impl.AbstractHoverTextProvider {
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if (object == null)		return null;
		org.eclipse.emf.ecore.EClass eClass = object.eClass();
		String label = "<strong>" + eClass.getName() + "</strong>";
		for (org.eclipse.emf.ecore.EAttribute attribute : eClass.getEAllAttributes()) {
			java.lang.Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (java.lang.Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				label += "<br />" + attribute.getName() + ": " + object.eGet(attribute).toString();
			}
		}
		return label;
	}
}

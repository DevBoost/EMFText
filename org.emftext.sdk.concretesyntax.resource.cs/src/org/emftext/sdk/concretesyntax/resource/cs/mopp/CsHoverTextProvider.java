package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class CsHoverTextProvider implements org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider {
	
	public java.lang.String getHoverText(EObject object) {
		if (object == null) {
			return null;
		}
		String htmlForObject = getHTML(object);
		if (object instanceof GenClass) {
			// for generator classes we do also show the properties of the
			// corresponding EClass
			GenClass genClass = (GenClass) object;
			EClass ecoreClass = genClass.getEcoreClass();
			String htmlForEClass = getHTML(ecoreClass);
			return htmlForEClass + "<br/><br/>" + htmlForObject;
		}
		if (object instanceof GenPackage) {
			// for generator classes we do also show the properties of the
			// corresponding EClass
			GenPackage genPackage = (GenPackage) object;
			EPackage ecorePackage = genPackage.getEcorePackage();
			String htmlForEPackage = getHTML(ecorePackage);
			return htmlForEPackage + "<br/><br/>" + htmlForObject;
		}
		return htmlForObject;
	}

	private java.lang.String getHTML(EObject object) {
		if (object == null) {
			return "";
		}
		EClass eClass = object.eClass();
		
		String label = "<strong>" + eClass.getName() + "</strong>";
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				label += "<br />" + attribute.getName() + ": " + object.eGet(attribute).toString();
			}
		}
		return label;
	}
}

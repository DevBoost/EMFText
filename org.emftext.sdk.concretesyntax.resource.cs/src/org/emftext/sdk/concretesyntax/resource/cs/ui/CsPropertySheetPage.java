package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;

/**
 * A custom implementation for the PropertySheetPage class.
 * This replacement for the generated PropertySheetPage is 
 * needed because of a bug in the EMF framework, which will
 * not be resolved.
 */
public class CsPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		//-------- Can be removed when https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301 is fixed in EMF
		// Unfortunately Ed Merks refuses to fix it, so we need to solve it here
		if (event.getSelection() instanceof CsEObjectSelection) {
			final CsEObjectSelection selection = (CsEObjectSelection)event.getSelection();
			final EObject selectedObject = selection.getSelectedObject();
			// check whether the selected object or one of its children contains
			// a proxy which is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)
			if (containsGenProxy(selectedObject)) {
				return;
			}
		}
		//--------
		
		selectionChanged(null, event.getSelection());
	}

	private boolean containsGenProxy(EObject selectedObject) {
		boolean isGenProxy = isGenProxy(selectedObject);
		if (isGenProxy) {
			return true;
		}
		for (EObject child : selectedObject.eCrossReferences()) {
			if (isGenProxy(child)) {
				return true;
			}
		}
		for (EObject child : selectedObject.eContents()) {
			if (containsGenProxy(child)) {
				return true;
			}
		}
		return false;
	}

	private boolean isGenProxy(EObject selectedObject) {
		boolean isGenMetaclass = selectedObject instanceof GenClass;
		isGenMetaclass |= selectedObject instanceof GenFeature;
		isGenMetaclass |= selectedObject instanceof GenPackage;
		boolean isProxy = selectedObject.eIsProxy();
		return isGenMetaclass && isProxy;
	}
}

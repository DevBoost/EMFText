package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		// this is a workaround for a bug in EMF
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301
		// unfortunately Ed Merks refuses to fix it, so we need to solve it here
		if (event.getSelection() instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection) {
			final org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection selection = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection) event.getSelection();
			final org.eclipse.emf.ecore.EObject selectedObject = selection.getSelectedObject();
			// check whether the selected object or one of its children contains
			// a proxy which is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)
			if (containsGenProxy(selectedObject)) {
				return;
			}
		}
		// end of workaround
		selectionChanged(null, event.getSelection());
	}
	
	private boolean containsGenProxy(org.eclipse.emf.ecore.EObject selectedObject) {
		boolean isGenProxy = isGenProxy(selectedObject);
		if (isGenProxy) {
			return true;
		}
		for (org.eclipse.emf.ecore.EObject child : selectedObject.eCrossReferences()) {
			if (isGenProxy(child)) {
				return true;
			}
		}
		for (org.eclipse.emf.ecore.EObject child : selectedObject.eContents()) {
			if (containsGenProxy(child)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isGenProxy(org.eclipse.emf.ecore.EObject selectedObject) {
		boolean isGenMetaclass = isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenClass", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenFeature", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenPackage", selectedObject);
		boolean isProxy = selectedObject.eIsProxy();
		return isGenMetaclass && isProxy;
	}
	
	private boolean isInstanceOf(String className, Object object) {
		try {
			Class<?> clazz = Class.forName(className);
			return clazz.isInstance(object);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}

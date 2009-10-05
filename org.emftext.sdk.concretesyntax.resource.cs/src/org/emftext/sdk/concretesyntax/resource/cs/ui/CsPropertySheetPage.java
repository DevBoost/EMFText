package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.emftext.sdk.concretesyntax.Rule;

public class CsPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		//-------- Can be removed when https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301 is fixed in EMF
		if (event.getSelection() instanceof CsEObjectSelection) {
			if(((CsEObjectSelection)event.getSelection()).getSelectedObject() instanceof Rule) {
				Rule rule = (Rule) ((CsEObjectSelection)event.getSelection()).getSelectedObject();
				if (rule.getMetaclass().eIsProxy()) {
					return;
				}
			}
		}
		//--------
		
		selectionChanged(null, event.getSelection());
	}
	
}

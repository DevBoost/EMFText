package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
}

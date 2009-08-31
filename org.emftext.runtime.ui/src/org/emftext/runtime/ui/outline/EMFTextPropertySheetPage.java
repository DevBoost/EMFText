package org.emftext.runtime.ui.outline;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class EMFTextPropertySheetPage extends PropertySheetPage implements ISelectionChangedListener {
	
	@Override
	public void handleEntrySelection(ISelection selection) {
		super.handleEntrySelection(selection);
		getControl().setEnabled(false);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}

}

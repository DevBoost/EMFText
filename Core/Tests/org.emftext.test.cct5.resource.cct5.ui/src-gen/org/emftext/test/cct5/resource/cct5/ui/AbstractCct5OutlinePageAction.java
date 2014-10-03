/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractCct5OutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer;
	
	public AbstractCct5OutlinePageAction(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = org.emftext.test.cct5.resource.cct5.ui.Cct5ImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}

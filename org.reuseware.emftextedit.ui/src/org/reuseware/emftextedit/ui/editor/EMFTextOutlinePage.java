package org.reuseware.emftextedit.ui.editor;

import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

/**
 * Simple Outline Page using the ReflectiveItemAdapters provided by EMF
 * 
 * @author cw
 * 
 */
public class EMFTextOutlinePage extends ContentOutlinePage {

	private TreeViewer contentOutlineViewer;
	private EMFTextEditor editor;

	public EMFTextOutlinePage(EMFTextEditor textEditor) {
		this.editor = textEditor;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);

		// Set up the tree viewer.
		//

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		contentOutlineViewer
				.setContentProvider(new AdapterFactoryContentProvider(
						adapterFactory));
		contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		contentOutlineViewer.setInput(editor.getResourceSet().getResources()
				.get(0));

		// Make sure our popups work.
		//
		// createContextMenuFor(contentOutlineViewer);

		if (!editor.getResourceSet().getResources().isEmpty()) {
			// Select the root object in the view.
			//
			contentOutlineViewer.setSelection(new StructuredSelection(editor
					.getResourceSet().getResources().get(0)), true);
		}
	}

	// @Override
	// public void makeContributions(IMenuManager menuManager, IToolBarManager
	// toolBarManager, IStatusLineManager statusLineManager)
	// {
	// super.makeContributions(menuManager, toolBarManager, statusLineManager);
	// contentOutlineStatusLineManager = statusLineManager;
	// }
	//
	// @Override
	// public void setActionBars(IActionBars actionBars)
	// {
	// super.setActionBars(actionBars);
	// getActionBarContributor().shareGlobalActions(this, actionBars);
	// }
}

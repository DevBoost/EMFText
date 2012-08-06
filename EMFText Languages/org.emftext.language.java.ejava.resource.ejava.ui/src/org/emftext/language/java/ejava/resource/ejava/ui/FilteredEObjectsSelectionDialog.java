/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.ejava.resource.ejava.ui;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;

/**
 * @author Jan Reimann
 *
 */
public class FilteredEObjectsSelectionDialog extends FilteredItemsSelectionDialog {

	private Collection<? extends EObject> elements;
	private String name;
	private Composite dialogArea;
	private Composite composite;
	private EObject selectedObject;
	
	public FilteredEObjectsSelectionDialog(Shell shell, Collection<? extends EObject> elements, String name) {
		super(shell, false);
		this.elements = elements;
		this.name = name;
		initialize();
		this.create();
	}

	private void initialize(){
		ILabelProvider provider = new LabelProvider() {

			@Override
			public Image getImage(Object object) {
				EObject element = (EObject) object;
				AdapterFactoryLabelProvider labelProvider = getLabelProvider();
				Image image = labelProvider.getImage(element);
				if (image != null) {
					return image;
				}
				return super.getImage(object);
			}

			@Override
			public String getText(Object element) {
				EObject object = (EObject) element;
				AdapterFactoryLabelProvider labelProvider = getLabelProvider();
				String label = labelProvider.getText(object);
				if(label != null){
					return label;
				}
				return super.getText(element);
			}

			private AdapterFactoryLabelProvider getLabelProvider() {
				ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				return labelProvider;
			}

		};
		setListLabelProvider(provider);
		setDetailsLabelProvider(provider);
		setTitle(name);
		setInitialPattern("**");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {
		ItemsFilter filter = new ItemsFilter(new SearchPattern(
				SearchPattern.RULE_CAMELCASE_MATCH
				| SearchPattern.RULE_EXACT_MATCH
				| SearchPattern.RULE_PATTERN_MATCH
				| SearchPattern.RULE_PREFIX_MATCH)) {
			
			@Override
			public boolean matchItem(Object item) {
				if(!(item instanceof EObject)){
					return false;
				}
				return matches(((EObject) item).toString());
			}
			
			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
		return filter;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider(org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.AbstractContentProvider, org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		progressMonitor.beginTask("Looking for elements...", elements.size());
		for (EObject element : elements) {
			contentProvider.add(element, itemsFilter);
			progressMonitor.worked(1);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getDialogSettings()
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		Resource resource = elements.iterator().next().eResource();
		String root = resource.getURI().toString();
		IDialogSettings settings = new DialogSettings(root);
		return settings;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 */
	@Override
	public String getElementName(Object item) {
		return ((EObject) item).toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<?> getItemsComparator() {
		Comparator<EObject> comparator = new Comparator<EObject>() {
			
			public int compare(EObject o1, EObject o2) {	
				EcoreItemProviderAdapterFactory factory = new EcoreItemProviderAdapterFactory();
				if(factory.isFactoryForType(IItemLabelProvider.class)){
					IItemLabelProvider labelProvider1 = (IItemLabelProvider) factory.adapt(o1, IItemLabelProvider.class);
					IItemLabelProvider labelProvider2 = (IItemLabelProvider) factory.adapt(o2, IItemLabelProvider.class);
					String label1 = labelProvider1.getText(o1);
					String label2 = labelProvider2.getText(o2);
					return String.CASE_INSENSITIVE_ORDER.compare(label1, label2);
				}
				return 1;
			}
		};
		return comparator;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		dialogArea = (Composite) super.createDialogArea(parent); 
		return dialogArea;
	}

	/**
	 * @return the dialogArea
	 */
	public Composite getDialogArea() {
		return dialogArea;
	}

	@Override
	protected void handleSelected(StructuredSelection selection) {
		super.handleSelected(selection);
		if(selection != null){
			Object firstElement = selection.getFirstElement();
			if(firstElement instanceof EObject){
				selectedObject = (EObject) firstElement;
			}
		}
	}

	/**
	 * @return the selectedObject
	 */
	public EObject getSelectedObject() {
		return selectedObject;
	}

	@Override
	protected Control createContents(Composite parent) {
		composite = (Composite) super.createContents(parent);
		return composite;
	}

	/**
	 * @return the composite
	 */
	public Composite getComposite() {
		return dialogArea;
	}
}

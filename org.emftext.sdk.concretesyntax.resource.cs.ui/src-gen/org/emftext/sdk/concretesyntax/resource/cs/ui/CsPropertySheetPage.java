/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
	public void selectionChanged(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection iSelection) {
		// this is a workaround for a bug in EMF see
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301unfortunately Ed Merks
		// refuses to fix it, so we need to solve it here
		if (iSelection instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection) {
			final org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection selection = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection) iSelection;
			final org.eclipse.emf.ecore.EObject selectedObject = selection.getSelectedObject();
			// check whether the selected object or one of its children contains a proxy which
			// is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)
			if (containsGenProxy(selectedObject)) {
				return;
			}
		}
		if (iSelection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) iSelection;
			java.util.Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				final Object next = it.next();
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					if (containsGenProxy((org.eclipse.emf.ecore.EObject) next)) {
						return;
					}
				}
			}
		}
		// end of workaround
		super.selectionChanged(part, iSelection);
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

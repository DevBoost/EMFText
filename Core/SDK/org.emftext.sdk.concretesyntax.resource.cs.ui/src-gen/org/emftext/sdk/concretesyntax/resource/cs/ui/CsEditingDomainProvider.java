/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * The EditingDomainProvider is used by the editor to obtain an EMF editing
 * domain. This default implementation creates a new editing domain for each
 * editor input.
 */
public class CsEditingDomainProvider {
	
	public org.eclipse.emf.edit.domain.EditingDomain getEditingDomain(org.eclipse.ui.IEditorInput editorInput) {
		return createEditingDomain();
	}
	
	private org.eclipse.emf.edit.domain.EditingDomain createEditingDomain() {
		org.eclipse.emf.common.notify.AdapterFactory adapterFactory = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsAdapterFactoryProvider().getAdapterFactory();
		
		org.eclipse.emf.common.command.BasicCommandStack commandStack = new org.eclipse.emf.common.command.BasicCommandStack();
		
		return new org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain(adapterFactory, commandStack, new java.util.LinkedHashMap<org.eclipse.emf.ecore.resource.Resource, Boolean>());
	}
	
}

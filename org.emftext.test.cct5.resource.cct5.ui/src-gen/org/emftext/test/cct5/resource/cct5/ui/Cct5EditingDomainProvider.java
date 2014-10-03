/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import java.util.LinkedHashMap;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorInput;

/**
 * The EditingDomainProvider is used by the editor to obtain an EMF editing
 * domain. This default implementation creates a new editing domain for each
 * editor input.
 */
public class Cct5EditingDomainProvider {
	
	public EditingDomain getEditingDomain(IEditorInput editorInput) {
		return createEditingDomain();
	}
	
	private EditingDomain createEditingDomain() {
		AdapterFactory adapterFactory = new org.emftext.test.cct5.resource.cct5.ui.Cct5AdapterFactoryProvider().getAdapterFactory();
		
		BasicCommandStack commandStack = new BasicCommandStack();
		
		// Register resource factories (esp. for additional extensions).
		new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().registerResourceFactory();
		
		return new AdapterFactoryEditingDomain(adapterFactory, commandStack, new LinkedHashMap<Resource, Boolean>());
	}
	
}

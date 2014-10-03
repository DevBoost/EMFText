/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.core.resources.IResource;

public class Cct5UIMetaInformation extends org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation {
	
	public org.emftext.test.cct5.resource.cct5.ICct5HoverTextProvider getHoverTextProvider() {
		return new org.emftext.test.cct5.resource.cct5.ui.Cct5HoverTextProvider();
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.Cct5ImageProvider getImageProvider() {
		return org.emftext.test.cct5.resource.cct5.ui.Cct5ImageProvider.INSTANCE;
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager createColorManager() {
		return new org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.test.cct5.resource.cct5.ICct5TextResource,
	 * org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager) instead.
	 */
	public org.emftext.test.cct5.resource.cct5.ui.Cct5TokenScanner createTokenScanner(org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager colorManager) {
		return (org.emftext.test.cct5.resource.cct5.ui.Cct5TokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.ICct5TokenScanner createTokenScanner(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource, org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager colorManager) {
		return new org.emftext.test.cct5.resource.cct5.ui.Cct5TokenScanner(resource, colorManager);
	}
	
	public org.emftext.test.cct5.resource.cct5.ui.Cct5CodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.test.cct5.resource.cct5.ui.Cct5CodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new org.emftext.test.cct5.resource.cct5.ui.debug.Cct5LineBreakpointAdapter();
	}
	
}

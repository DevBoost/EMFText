package org.emftext.access.resource;

public interface IUIMetaInformation extends IMetaInformation {

	public IColorManager createColorManager();
	
	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 * 
	 * @deprecated this method is only available for plug-ins generated with EMFText 1.3.0 or before
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IColorManager colorManager);

	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 * 
	 * @since EMFText 1.3.1
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IResource resource, IColorManager colorManager);
}

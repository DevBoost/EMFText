package org.emftext.access.resource;

public interface IUIMetaInformation extends IMetaInformation {

	public IColorManager createColorManager();
	
	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IColorManager colorManager);
}

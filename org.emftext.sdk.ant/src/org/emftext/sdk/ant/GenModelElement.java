package org.emftext.sdk.ant;

/**
 * This class is used to represent nested 'genModel'
 * elements that can be used in a {@link GenerateTextResourceTask}.
 */
public class GenModelElement {

	private String namespaceURI;
	private String genModelURI;

	public String getNamespaceURI() {
		return namespaceURI;
	}
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	public String getGenModelURI() {
		return genModelURI;
	}
	public void setGenModelURI(String genmodelURI) {
		this.genModelURI = genmodelURI;
	}
}

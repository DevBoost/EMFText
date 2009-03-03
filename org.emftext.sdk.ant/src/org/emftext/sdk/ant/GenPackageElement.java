package org.emftext.sdk.ant;

/**
 * This class is used to represent nested 'genPackage'
 * elements that can be used in a {@link GenerateTextResourceTask}.
 */
public class GenPackageElement {

	private String namespaceURI;
	private String ePackageClassName;

	public String getNamespaceURI() {
		return namespaceURI;
	}
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	public String getEPackageClassName() {
		return ePackageClassName;
	}
	public void setEPackageClassName(String packageClassName) {
		ePackageClassName = packageClassName;
	}
}

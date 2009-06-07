package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.ecore.EClass;

public class CsMetaInformation implements org.emftext.runtime.resource.ITextResourcePluginMetaInformation {
	
	public org.emftext.runtime.resource.ITextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsParser().createInstance(inputStream, encoding);
	}

	public EClass[] getClassesWithSyntax() {
		// TODO mseifert: regenerate CS text resource plug-in to obtain
		// correct implementation of this method
		return null;
	}
}

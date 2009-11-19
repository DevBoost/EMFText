package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsNewFileContentProvider {
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation getMetaInformation() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	}
	
	public java.lang.String getNewFileContent(java.lang.String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		String content = "SYNTAXDEF myFileExtension\nFOR <http://www.some-domain.org/myLanguage> <optional/path/to/myLanguage.genmodel>\nSTART StartMetaClass\n\nOPTIONS {\n\treloadGeneratorModel = \"true\";\n}\n\nRULES {\n\t// syntax definition for class 'StartMetaClass'\n\tStartMetaClass   ::= \"myKeyword\" attributeOfStartMetaClass[] aContainmentReference* ;\n\t\n\t// syntax definition for class 'AnotherMetaClass'\n\tAnotherMetaClass ::= \"otherKeyword\" aNonContainmentReference[];\n}".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPrinter(outputStream, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource());
	}
	
}

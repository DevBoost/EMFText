package org.emftext.sdk.concretesyntax.resource.cs;

public class CsMetaInformation implements org.emftext.runtime.resource.ITextResourcePluginMetaInformation {
	
	public org.emftext.runtime.resource.ITextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsParser().createInstance(inputStream, encoding);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPLUS(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSTAR(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getQUESTIONMARK(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAbstract(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(),
		};
	}
}

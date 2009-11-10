package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsFoldingInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
		};
	}
	
}

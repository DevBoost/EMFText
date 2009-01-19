package org.emftext.sdk.concretesyntax.resource.cs; 

public class CsReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver concreteSyntaxPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver importPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypeReferenceResolver containmentTypeReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypeReferenceResolver();

	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 1) {
			concreteSyntaxPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == 2) {
			importPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == 1) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder && reference.getFeatureID() == 2) {
			definedPlaceholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == 2) {
			containmentTypeReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, reference, position, false, result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == 2) {
			containmentTypeReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, reference, position, false, result);
			return;
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == 2) {
			return importPackageReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Import) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Import) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Rule) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Rule) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == 2) {
			return containmentTypeReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Containment) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == 2) {
			return containmentTypeReferenceResolver.deResolve(refObject, (org.emftext.sdk.concretesyntax.Containment) container, reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		concreteSyntaxPackageReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		importPackageReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		containmentTypeReferenceResolver.setOptions(options);
		containmentTypeReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(3);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(3);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(3);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(3);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(2);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				importPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getDefinedPlaceholder().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(2);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				definedPlaceholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(1);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(2);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				containmentTypeReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}

		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(2);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				containmentTypeReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
	}

}

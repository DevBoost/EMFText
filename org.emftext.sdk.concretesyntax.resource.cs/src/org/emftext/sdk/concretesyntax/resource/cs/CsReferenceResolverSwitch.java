package org.emftext.sdk.concretesyntax.resource.cs; 

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;
public class CsReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver importPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver concreteSyntaxPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();

	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			importPackageReferenceResolver.resolve(identifier, (Import) container, reference, position, false, result);
			return;
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, (Terminal) container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			concreteSyntaxPackageReferenceResolver.resolve(identifier, (ConcreteSyntax) container, reference, position, false, result);
			return;
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			definedPlaceholderTokenReferenceResolver.resolve(identifier, (DefinedPlaceholder)container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, (Import) container, reference, position, false, result);
			return;
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject,(Rule)container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			return importPackageReferenceResolver.deResolve(refObject,(Import)container,reference);
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject,(Terminal)container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject,(ConcreteSyntax)container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageReferenceResolver.deResolve(refObject,(ConcreteSyntax)container,reference);
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenReferenceResolver.deResolve(refObject,(DefinedPlaceholder)container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxReferenceResolver.deResolve(refObject,(Import)container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		ruleMetaclassReferenceResolver.setOptions(options);
		importPackageReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxPackageReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule();
			int featureID = 1; 
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport();
			int featureID = 2;
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal();
			int featureID = 1;
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax();
			int featureID = 3; 
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax();
			int featureID = 1; 
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getDefinedPlaceholder();
			int featureID = 2; 
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
		{
			org.eclipse.emf.ecore.EClass eClass = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport();
			int featureID = 1; 
			if (eClass.isInstance(container)) {
				org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
				if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
					return;
				}
				ruleMetaclassReferenceResolver.resolve(identifier, (Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
			}
		}
	}
}

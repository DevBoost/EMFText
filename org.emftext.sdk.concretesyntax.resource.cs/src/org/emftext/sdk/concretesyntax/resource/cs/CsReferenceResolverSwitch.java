package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class CsReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {
	
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver genPackageDependentElementPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver containmentTypesReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver();
	
	public <ContainerType extends EObject, ReferenceType> void resolve(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<ReferenceType> result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <ContainerType, ReferenceType> void resolveStrict(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, IReferenceResolveResult<ReferenceType> result) {
		if (container instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE) {
			genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, reference, position, false, (IReferenceResolveResult<GenPackage>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, (IReferenceResolveResult<GenClass>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference, position, false, (IReferenceResolveResult<GenClass>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE) {
			genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, reference, position, false, (IReferenceResolveResult<GenPackage>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, reference, position, false, (IReferenceResolveResult<ConcreteSyntax>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS) {
			ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, reference, position, false, (IReferenceResolveResult<GenClass>)result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, (IReferenceResolveResult<GenFeature>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN) {
			definedPlaceholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, reference, position, false, (IReferenceResolveResult<TokenDefinition>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, (IReferenceResolveResult<GenFeature>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, reference, position, false, (IReferenceResolveResult<GenFeature>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES) {
			containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, reference, position, false, (IReferenceResolveResult<GenClass>) result);
			return;
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES) {
			containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, reference, position, false, (IReferenceResolveResult<GenClass>) result);
			return;
		}
	}
	
	public <ContainerType extends EObject, ReferenceType> java.lang.String deResolve(ReferenceType refObject, ContainerType container, org.eclipse.emf.ecore.EReference reference) {
		if (container instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE) {
			return genPackageDependentElementPackageReferenceResolver.deResolve((GenPackage) refObject, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve((GenClass) refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve((GenClass) refObject, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE) {
			return genPackageDependentElementPackageReferenceResolver.deResolve((GenPackage) refObject, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Import && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX) {
			return importConcreteSyntaxReferenceResolver.deResolve((ConcreteSyntax) refObject, (org.emftext.sdk.concretesyntax.Import) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Rule && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS) {
			return ruleMetaclassReferenceResolver.deResolve((GenClass) refObject, (org.emftext.sdk.concretesyntax.Rule) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			return terminalFeatureReferenceResolver.deResolve((GenFeature) refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN) {
			return definedPlaceholderTokenReferenceResolver.deResolve((TokenDefinition) refObject, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			return terminalFeatureReferenceResolver.deResolve((GenFeature) refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Terminal && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE) {
			return terminalFeatureReferenceResolver.deResolve((GenFeature) refObject, (org.emftext.sdk.concretesyntax.Terminal) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES) {
			return containmentTypesReferenceResolver.deResolve((GenClass) refObject, (org.emftext.sdk.concretesyntax.Containment) container, reference);
		}
		if (container instanceof org.emftext.sdk.concretesyntax.Containment && reference.getFeatureID() == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES) {
			return containmentTypesReferenceResolver.deResolve((GenClass) refObject, (org.emftext.sdk.concretesyntax.Containment) container, reference);
		}
		return null;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		genPackageDependentElementPackageReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		genPackageDependentElementPackageReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		containmentTypesReferenceResolver.setOptions(options);
		containmentTypesReferenceResolver.setOptions(options);
	}
	
	@SuppressWarnings("unchecked")
	public <ContainerType extends EObject, ReferenceType> void resolveFuzzy(java.lang.String identifier, ContainerType container, int position, org.emftext.runtime.resource.IReferenceResolveResult<ReferenceType> result) {
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenPackage>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenClass>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenClass>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenPackage>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<ConcreteSyntax>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenClass>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenFeature>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getDefinedPlaceholder().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				definedPlaceholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.DefinedPlaceholder) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<TokenDefinition>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenFeature>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenFeature>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenClass>) result);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, (IReferenceResolveResult<GenClass>) result);
			}
		}
	}
}

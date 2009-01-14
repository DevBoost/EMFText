package org.emftext.sdk.concretesyntax.resource.cs; 

import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
public class CsReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolver {

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver importPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver concreteSyntaxPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver();

	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver();

	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			importPackageReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			concreteSyntaxPackageReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			definedPlaceholderTokenReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			return importPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenReferenceResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		ruleMetaclassReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		importPackageReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		concreteSyntaxPackageReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

		resolveFuzzy(Rule.class, identifier, container, position, 1, ruleMetaclassReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 1, importConcreteSyntaxReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 3, concreteSyntaxStartSymbolsReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 2, importPackageReferenceResolver, result);
		resolveFuzzy(Terminal.class, identifier, container, position, 1, terminalFeatureReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 1, concreteSyntaxPackageReferenceResolver, result);
		resolveFuzzy(DefinedPlaceholder.class, identifier, container, position, 2, definedPlaceholderTokenReferenceResolver, result);
	}

	protected void resolveFuzzy(java.lang.Class<?> clazz, java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.IReferenceResolver resolver, org.emftext.runtime.resource.IResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
	}

}

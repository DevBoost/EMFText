package org.emftext.sdk.concretesyntax.resource.cs; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.*;

public class CsTreeAnalyser implements org.emftext.runtime.resource.IReferenceResolver {

	protected ImportPackageReferenceResolver importPackageReferenceResolver = new ImportPackageReferenceResolver();

	protected RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new RuleMetaclassReferenceResolver();

	protected ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new ConcreteSyntaxStartSymbolsReferenceResolver();

	protected TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new TerminalFeatureReferenceResolver();

	protected DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new DefinedPlaceholderTokenReferenceResolver();

	protected ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new ImportConcreteSyntaxReferenceResolver();

	protected ConcreteSyntaxPackageReferenceResolver concreteSyntaxPackageReferenceResolver = new ConcreteSyntaxPackageReferenceResolver();

	public void resolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(String identifier, EObject container, EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
		if (container instanceof Import && reference.getFeatureID() == 2) {
			importPackageReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			definedPlaceholderTokenReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			concreteSyntaxPackageReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Import && reference.getFeatureID() == 2) {
			return importPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		importPackageReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		concreteSyntaxPackageReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

		resolveFuzzy(Import.class, identifier, container, position, 2, importPackageReferenceResolver, result);
		resolveFuzzy(Rule.class, identifier, container, position, 1, ruleMetaclassReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 3, concreteSyntaxStartSymbolsReferenceResolver, result);
		resolveFuzzy(Terminal.class, identifier, container, position, 1, terminalFeatureReferenceResolver, result);
		resolveFuzzy(DefinedPlaceholder.class, identifier, container, position, 2, definedPlaceholderTokenReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 1, importConcreteSyntaxReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 1, concreteSyntaxPackageReferenceResolver, result);
	}

	protected void resolveFuzzy(Class<?> clazz, String identifier, EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.IReferenceResolver resolver, org.emftext.runtime.resource.IResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (EReference) feature, position, true, result);
	}

}

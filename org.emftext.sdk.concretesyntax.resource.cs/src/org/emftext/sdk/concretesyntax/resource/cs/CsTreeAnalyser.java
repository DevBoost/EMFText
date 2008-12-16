package org.emftext.sdk.concretesyntax.resource.cs; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxPackageReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.DefinedPlaceholderTokenReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportPackageReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver;

public class CsTreeAnalyser implements IReferenceResolver {

	protected RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new RuleMetaclassReferenceResolver();

	protected ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new ImportConcreteSyntaxReferenceResolver();

	protected ImportPackageReferenceResolver importPackageReferenceResolver = new ImportPackageReferenceResolver();

	protected ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new ConcreteSyntaxStartSymbolsReferenceResolver();

	protected ConcreteSyntaxPackageReferenceResolver concreteSyntaxPackageReferenceResolver = new ConcreteSyntaxPackageReferenceResolver();

	protected DefinedPlaceholderTokenReferenceResolver definedPlaceholderTokenReferenceResolver = new DefinedPlaceholderTokenReferenceResolver();

	protected TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new TerminalFeatureReferenceResolver();

	public void resolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(String identifier, EObject container, EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			ruleMetaclassReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			importConcreteSyntaxReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			importPackageReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, container, reference, position, false, result);
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
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			terminalFeatureReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			return importPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureReferenceResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		ruleMetaclassReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		importPackageReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		concreteSyntaxPackageReferenceResolver.setOptions(options);
		definedPlaceholderTokenReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

		resolveFuzzy(Rule.class, identifier, container, position, 1, ruleMetaclassReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 1, importConcreteSyntaxReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 2, importPackageReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 3, concreteSyntaxStartSymbolsReferenceResolver, result);
		resolveFuzzy(ConcreteSyntax.class, identifier, container, position, 1, concreteSyntaxPackageReferenceResolver, result);
		resolveFuzzy(DefinedPlaceholder.class, identifier, container, position, 2, definedPlaceholderTokenReferenceResolver, result);
		resolveFuzzy(Terminal.class, identifier, container, position, 1, terminalFeatureReferenceResolver, result);
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

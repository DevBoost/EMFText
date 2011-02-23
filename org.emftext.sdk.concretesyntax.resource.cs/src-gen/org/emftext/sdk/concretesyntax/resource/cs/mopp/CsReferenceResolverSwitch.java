/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsReferenceResolverSwitch implements org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch {
	
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver genPackageDependentElementPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.PlaceholderTokenReferenceResolver placeholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.PlaceholderTokenReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.EnumLiteralTerminalLiteralReferenceResolver enumLiteralTerminalLiteralReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.EnumLiteralTerminalLiteralReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver containmentTypesReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenRedefinitionRedefinedTokenReferenceResolver tokenRedefinitionRedefinedTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenRedefinitionRedefinedTokenReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenPriorityDirectiveTokenReferenceResolver tokenPriorityDirectiveTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenPriorityDirectiveTokenReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RegexReferenceTargetReferenceResolver regexReferenceTargetReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RegexReferenceTargetReferenceResolver();
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver getGenPackageDependentElementPackageReferenceResolver() {
		return genPackageDependentElementPackageReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver getConcreteSyntaxStartSymbolsReferenceResolver() {
		return concreteSyntaxStartSymbolsReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver getImportConcreteSyntaxReferenceResolver() {
		return importConcreteSyntaxReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver getRuleMetaclassReferenceResolver() {
		return ruleMetaclassReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver getTerminalFeatureReferenceResolver() {
		return terminalFeatureReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.PlaceholderTokenReferenceResolver getPlaceholderTokenReferenceResolver() {
		return placeholderTokenReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.EnumLiteralTerminalLiteralReferenceResolver getEnumLiteralTerminalLiteralReferenceResolver() {
		return enumLiteralTerminalLiteralReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver getContainmentTypesReferenceResolver() {
		return containmentTypesReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenRedefinitionRedefinedTokenReferenceResolver getTokenRedefinitionRedefinedTokenReferenceResolver() {
		return tokenRedefinitionRedefinedTokenReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.TokenPriorityDirectiveTokenReferenceResolver getTokenPriorityDirectiveTokenReferenceResolver() {
		return tokenPriorityDirectiveTokenReferenceResolver;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.RegexReferenceTargetReferenceResolver getRegexReferenceTargetReferenceResolver() {
		return regexReferenceTargetReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		genPackageDependentElementPackageReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		placeholderTokenReferenceResolver.setOptions(options);
		enumLiteralTerminalLiteralReferenceResolver.setOptions(options);
		containmentTypesReferenceResolver.setOptions(options);
		tokenRedefinitionRedefinedTokenReferenceResolver.setOptions(options);
		tokenPriorityDirectiveTokenReferenceResolver.setOptions(options);
		regexReferenceTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenPackage> frr = new CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("package")) {
				genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("startSymbols")) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().isInstance(container)) {
			CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax> frr = new CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("concreteSyntax")) {
				importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("metaclass")) {
				ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenFeature> frr = new CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholder().isInstance(container)) {
			CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.ReferencableTokenDefinition> frr = new CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.ReferencableTokenDefinition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("token")) {
				placeholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Placeholder) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral> frr = new CsFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("literal")) {
				enumLiteralTerminalLiteralReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.EnumLiteralTerminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new CsFuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("types")) {
				containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().isInstance(container)) {
			CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.CompleteTokenDefinition> frr = new CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("redefinedToken")) {
				tokenRedefinitionRedefinedTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.TokenRedefinition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().isInstance(container)) {
			CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.CompleteTokenDefinition> frr = new CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("token")) {
				tokenPriorityDirectiveTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.TokenPriorityDirective) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().isInstance(container)) {
			CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.NamedTokenDefinition> frr = new CsFuzzyResolveResult<org.emftext.sdk.concretesyntax.NamedTokenDefinition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				regexReferenceTargetReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.RegexReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement_Package()) {
			return genPackageDependentElementPackageReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax_StartSymbols()) {
			return concreteSyntaxStartSymbolsReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport_ConcreteSyntax()) {
			return importConcreteSyntaxReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule_Metaclass()) {
			return ruleMetaclassReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal_Feature()) {
			return terminalFeatureReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholder_Token()) {
			return placeholderTokenReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal_Literal()) {
			return enumLiteralTerminalLiteralReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment_Types()) {
			return containmentTypesReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition_RedefinedToken()) {
			return tokenRedefinitionRedefinedTokenReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective_Token()) {
			return tokenPriorityDirectiveTokenReferenceResolver;
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference_Target()) {
			return regexReferenceTargetReferenceResolver;
		}
		return null;
	}
	
}

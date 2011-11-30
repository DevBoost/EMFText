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
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage> getGenPackageDependentElementPackageReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement_Package(), genPackageDependentElementPackageReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass> getConcreteSyntaxStartSymbolsReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax_StartSymbols(), concreteSyntaxStartSymbolsReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax> getImportConcreteSyntaxReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport_ConcreteSyntax(), importConcreteSyntaxReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass> getRuleMetaclassReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule_Metaclass(), ruleMetaclassReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature> getTerminalFeatureReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal_Feature(), terminalFeatureReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.ReferencableTokenDefinition> getPlaceholderTokenReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholder_Token(), placeholderTokenReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.EnumLiteralTerminal, org.eclipse.emf.ecore.EEnumLiteral> getEnumLiteralTerminalLiteralReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal_Literal(), enumLiteralTerminalLiteralReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass> getContainmentTypesReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment_Types(), containmentTypesReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.TokenRedefinition, org.emftext.sdk.concretesyntax.CompleteTokenDefinition> getTokenRedefinitionRedefinedTokenReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition_RedefinedToken(), tokenRedefinitionRedefinedTokenReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition> getTokenPriorityDirectiveTokenReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective_Token(), tokenPriorityDirectiveTokenReferenceResolver);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.NamedTokenDefinition> getRegexReferenceTargetReferenceResolver() {
		return getResolverChain(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference_Target(), regexReferenceTargetReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
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
			return getResolverChain(reference, genPackageDependentElementPackageReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax_StartSymbols()) {
			return getResolverChain(reference, concreteSyntaxStartSymbolsReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport_ConcreteSyntax()) {
			return getResolverChain(reference, importConcreteSyntaxReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule_Metaclass()) {
			return getResolverChain(reference, ruleMetaclassReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal_Feature()) {
			return getResolverChain(reference, terminalFeatureReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholder_Token()) {
			return getResolverChain(reference, placeholderTokenReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal_Literal()) {
			return getResolverChain(reference, enumLiteralTerminalLiteralReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment_Types()) {
			return getResolverChain(reference, containmentTypesReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition_RedefinedToken()) {
			return getResolverChain(reference, tokenRedefinitionRedefinedTokenReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective_Token()) {
			return getResolverChain(reference, tokenPriorityDirectiveTokenReferenceResolver);
		}
		if (reference == org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference_Target()) {
			return getResolverChain(reference, regexReferenceTargetReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver) {
			org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver replacingResolver = (org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceCache) {
					org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver nextResolver = (org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver) next;
					if (nextResolver instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.sdk.concretesyntax.resource.cs.ICsDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}

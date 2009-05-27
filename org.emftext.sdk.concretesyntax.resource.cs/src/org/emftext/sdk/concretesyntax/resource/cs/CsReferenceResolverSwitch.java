/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs;

public class CsReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {
	
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver genPackageDependentElementPackageReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.GenPackageDependentElementPackageReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver concreteSyntaxStartSymbolsReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ConcreteSyntaxStartSymbolsReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver importConcreteSyntaxReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver ruleMetaclassReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.RuleMetaclassReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver terminalFeatureReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.TerminalFeatureReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.PlaceholderTokenReferenceResolver placeholderTokenReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.PlaceholderTokenReferenceResolver();
	protected org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver containmentTypesReferenceResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver();
	
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.analysis.ContainmentTypesReferenceResolver getContainmentTypesReferenceResolver() {
		return containmentTypesReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		genPackageDependentElementPackageReferenceResolver.setOptions(options);
		concreteSyntaxStartSymbolsReferenceResolver.setOptions(options);
		importConcreteSyntaxReferenceResolver.setOptions(options);
		ruleMetaclassReferenceResolver.setOptions(options);
		terminalFeatureReferenceResolver.setOptions(options);
		placeholderTokenReferenceResolver.setOptions(options);
		containmentTypesReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getGenPackageDependentElement().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenPackage> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				genPackageDependentElementPackageReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.GenPackageDependentElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				concreteSyntaxStartSymbolsReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.ConcreteSyntax) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				importConcreteSyntaxReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Import) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				ruleMetaclassReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTerminal().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenFeature> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TERMINAL__FEATURE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				terminalFeatureReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholder().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.sdk.concretesyntax.TokenDefinition> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.sdk.concretesyntax.TokenDefinition>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER__TOKEN);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				placeholderTokenReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Placeholder) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.emf.codegen.ecore.genmodel.GenClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				containmentTypesReferenceResolver.resolve(identifier, (org.emftext.sdk.concretesyntax.Containment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}

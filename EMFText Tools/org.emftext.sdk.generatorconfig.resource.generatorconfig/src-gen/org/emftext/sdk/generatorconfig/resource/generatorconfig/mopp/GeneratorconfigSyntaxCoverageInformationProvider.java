/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigSyntaxCoverageInformationProvider {

	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassName(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatures(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRuleReference(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRuleReference(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureName(),
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeature(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPLUS(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSTAR(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getQUESTIONMARK(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAbstract(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(),
		};
	}

	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig(),
		};
	}

}

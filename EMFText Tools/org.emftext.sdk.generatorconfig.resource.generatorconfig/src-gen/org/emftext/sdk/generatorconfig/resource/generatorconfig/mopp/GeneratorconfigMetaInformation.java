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

public class GeneratorconfigMetaInformation implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigMetaInformation {

	public java.lang.String getSyntaxName() {
		return "generatorconfig";
	}

	public java.lang.String getURI() {
		return "http://www.emftext.org/sdk/generatorconfig";
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextScanner createLexer() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigAntlrScanner(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigLexer());
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParser().createInstance(inputStream, encoding);
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPrinter(outputStream, resource);
	}

	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}

	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigSyntaxCoverageInformationProvider().getStartSymbols();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolverFactory();
	}

	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.sdk.generatorconfig/model/config.cs";
	}

	public java.lang.String[] getTokenNames() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParser(null).getTokenNames();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair> getBracketPairs() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigBracketInformationProvider().getBracketPairs();
	}

	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigFoldingInformationProvider().getFoldableClasses();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigHoverTextProvider getHoverTextProvider() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigHoverTextProvider();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager createColorManager() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigTokenScanner createTokenScanner(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager colorManager) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigTokenScanner(colorManager);
	}

	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigResourceFactory();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigNewFileContentProvider();
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCodeCompletionHelper();
	}

}

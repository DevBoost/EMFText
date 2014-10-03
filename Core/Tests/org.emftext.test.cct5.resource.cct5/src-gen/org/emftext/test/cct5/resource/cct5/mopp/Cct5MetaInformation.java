/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class Cct5MetaInformation implements org.emftext.test.cct5.resource.cct5.ICct5MetaInformation {
	
	public String getSyntaxName() {
		return "cct5";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/cct5";
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextScanner createLexer() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5AntlrScanner(new org.emftext.test.cct5.resource.cct5.mopp.Cct5Lexer());
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextParser createParser(InputStream inputStream, String encoding) {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5Parser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextPrinter createPrinter(OutputStream outputStream, org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5Printer2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5SyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5SyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch();
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.test.cct5/metamodel/cct5.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.test.cct5.resource.cct5.mopp.Cct5Parser.tokenNames;
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5BracketPair> getBracketPairs() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5BracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5FoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5ResourceFactory();
	}
	
	public org.emftext.test.cct5.resource.cct5.mopp.Cct5NewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5NewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.test.cct5.resource.cct5.mopp.Cct5ResourceFactoryDelegator());
		}
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.test.cct5.resource.cct5.ui.launchConfigurationType";
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5NameProvider createNameProvider() {
		return new org.emftext.test.cct5.resource.cct5.analysis.Cct5DefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.test.cct5.resource.cct5.mopp.Cct5AntlrTokenHelper tokenHelper = new org.emftext.test.cct5.resource.cct5.mopp.Cct5AntlrTokenHelper();
		List<String> highlightableTokens = new ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}

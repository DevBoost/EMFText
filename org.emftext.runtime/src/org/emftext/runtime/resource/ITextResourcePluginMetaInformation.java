package org.emftext.runtime.resource;

import java.io.InputStream;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

/**
 * This interface provides information about a generated EMFText
 * text resource plug-in.
 */
public interface ITextResourcePluginMetaInformation {

	public String getURI();
	
	/**
	 * Returns the name of the concrete syntax. This name is used
	 * as file extension.
	 * 
	 * @return
	 */
	public String getSyntaxName();
	
	// TODO add documentation
	public String getPathToCSDefinition();
	
	/**
	 * Return a lexer capable to split the underlying text file into tokens.
	 * 
	 * @return a lexer instance.
	 */
	public ITextScanner createLexer();
	
	/**
	 * Returns an instance of the parser. This factory method
	 * is needed, because we can not create ANTLR parsers using
	 * the default constructor without arguments, because they
	 * expect the input stream or rather a token stream.
	 * 
	 * @param inputStream
	 * @param encoding
	 * @return
	 */
	public ITextParser createParser(InputStream inputStream,
			String encoding);

	/**
	 * Returns all meta classes for which syntax was defined. This 
	 * information is used both by the NewFileWizard and the code
	 * completion.
	 */
	public EClass[] getClassesWithSyntax();

	/**
	 * Returns an instance of the reference resolver switch class.
	 */
	public IReferenceResolverSwitch getReferenceResolverSwitch();

	/**
	 * Returns an instance of the token resolver factory.
	 */
	public ITokenResolverFactory getTokenResolverFactory();

	/**
	 * Returns a list of all tokens defined in the syntax.
	 * 
	 * @return
	 */
	public String[] getTokenNames();
	
	/**
	 * Return the default style that should be used to present tokens of the
	 * given type.
	 *  
	 * @param tokenName the name of the token type
	 * @return a style object or null if not default style is set
	 */
	public ITokenStyle getDefaultTokenStyle(String tokenName);
	
	// TODO add documentation
	public Collection<IBracketPair> getBracketPairs();

	/**
	 * Returns all classes for which folding should be enabled
	 * in the editor.
	 */
	public EClass[] getFoldableClasses();
	
	// TODO hoang-kim add IHoverTextProvider getHoverTextProvider()
}

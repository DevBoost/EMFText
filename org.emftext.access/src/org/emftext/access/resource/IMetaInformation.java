package org.emftext.access.resource;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;

/**
 * This interface provides information about a generated EMFText
 * text resource plug-in.
 */
public interface IMetaInformation {

	public String getURI();
	
	/**
	 * Returns the name of the concrete syntax. This name is used
	 * as file extension.
	 * 
	 * @return
	 */
	public String getSyntaxName();
	
	/**
	 * Returns the relative path to the .cs file within the plug-in.
	 * @return
	 */
	public String getPathToCSDefinition();
	
	/**
	 * Return a lexer capable to split the underlying text file into tokens.
	 * 
	 * @return a lexer instance.
	 */
	public ITextScanner createLexer();
	
	public IColorManager createColorManager();
	
	/**
	 * Return a scanner capable to split the underlying text file into JFace
	 * tokens.
	 * 
	 * @return a scanner instance.
	 */
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(IColorManager colorManager);
	
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
}

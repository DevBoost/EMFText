package org.emftext.runtime.resource;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;

/**
 * This interface provides information about a generated EMFText
 * text resource plug-in.
 */
public interface ITextResourcePluginMetaInformation {

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
}

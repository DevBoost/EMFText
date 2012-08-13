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
package org.emftext.access.resource;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

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
	public IScanner createLexer();
	
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
	public IParser createParser(InputStream inputStream,
			String encoding);

	/**
	 * Creates a new instance of the printer class, which
	 * can be used to convert models to text.
	 * 
	 * @param stream the stream to write to
	 * @param resource the resource that contains the model (can be null)
	 * 
	 * @return
	 */
	public IPrinter createPrinter(OutputStream stream, IResource resource);

	/**
	 * Returns all meta classes for which syntax was defined. This 
	 * information is used both by the NewFileWizard and the code
	 * completion.
	 */
	public EClass[] getClassesWithSyntax();

	/**
	 * Returns the meta classes that can be root elements.
	 * 
	 * @return
	 */
	public EClass[] getStartSymbols();

	/**
	 * Returns a factory that can be used to create resources for
	 * the generated syntax. 
	 * 
	 * @return
	 */
	public Factory createResourceFactory();
	
	public INewFileContentProvider getNewFileContentProvider();
}

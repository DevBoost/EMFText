/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.regex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime3_2_0.ANTLRInputStream;
import org.antlr.runtime3_2_0.CommonTokenStream;
import org.antlr.runtime3_2_0.RecognitionException;

public class RegexpTranslationHelper {

	// FIXME this method does not handle all ANTLR expression correctly!
	// For example '|' is not correctly translated. Neither is '~'.
	public static String translateANTLRToJavaStyle(String exp) throws IOException,
			RecognitionException {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		ANTLRexpLexer lexer = new ANTLRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		ANTLRexpParser parser = new ANTLRexpParser(tokenStream);
		String javaStyle = parser.root().toString();
		return javaStyle;
	}

	// TODO this method does not correctly handle unicode characters
	public static String translateANTLRToAutomatonStyle(String exp) throws IOException, RecognitionException {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		AutomatonRexpLexer lexer = new AutomatonRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		AutomatonRexpParser parser = new AutomatonRexpParser(tokenStream);
		String automatonStyle = parser.root().toString();
		return automatonStyle;
	}
}

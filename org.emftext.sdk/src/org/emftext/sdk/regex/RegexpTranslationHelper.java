/*******************************************************************************
 * Copyright (c) 2006-2009 
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

	public static String translateAntLRToJavaStyle(String exp) throws IOException,
			RecognitionException {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		ANTLRexpLexer lexer = new ANTLRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		ANTLRexpParser parser = new ANTLRexpParser(tokenStream);
		String javaStyle = parser.root().toString();
		return javaStyle;
	}

	public static String translateAntLRToAutomatonStyle(String exp) throws IOException, RecognitionException {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		AutomatonRexpLexer lexer = new AutomatonRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		AutomatonRexpParser parser = new AutomatonRexpParser(tokenStream);
		String automatonStyle = parser.root().toString();
		return automatonStyle;
		
	}

}

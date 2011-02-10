/*******************************************************************************
 * Copyright (c) 2006-2011
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


/**
 * A simple utility class to generate the lexer and parser for the regular
 * expressions using ANTLR.
 */
public class RunAntlr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		String dest = new java.io.File(".").getAbsolutePath();
		org.antlr.Tool antlrTool = new org.antlr.Tool(new String[] { "-o",
				dest ,
				 "./src/org/emftext/sdk/regex/ANTLRexp.g" });
		antlrTool.process();
		
		antlrTool = new org.antlr.Tool(new String[] { "-o",
				dest,
				 "./src/org/emftext/sdk/regex/AutomatonRexp.g" });
		antlrTool.process();
		System.out.println(antlrTool.getOutputDirectory());

	
	}
}

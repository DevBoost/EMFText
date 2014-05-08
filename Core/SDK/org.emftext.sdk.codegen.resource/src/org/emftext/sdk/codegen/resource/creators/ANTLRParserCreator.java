/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;

import org.antlr.Tool;
import org.antlr.tool.ANTLRErrorListener;
import org.antlr.tool.ErrorManager;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;

/**
 * Runs ANTLR on a .g file to generate Java classes for the parser and the lexer
 * from the ANTLR grammar specification.
 */
public class ANTLRParserCreator implements IArtifactCreator<GenerationContext> {

	public void createArtifacts(IPluginDescriptor plugin, GenerationContext context) {
		if (context.getANTLRGrammarHasChanged()) {
			File antlrFile = context.getANTLRGrammarFile(context.getResourcePlugin());
        	
			ANTLRErrorListener listener = new TextResourceGeneratorANTLRErrorListener(context);
			ErrorManager.setErrorListener(listener);
			
			String[] arguments = new String[] { "-Xconversiontimeout", "10000",
					"-o", antlrFile.getParentFile().getAbsolutePath(),
					antlrFile.getAbsolutePath() };
			Tool antlrTool = new Tool(arguments);
        	antlrTool.process();
		}
	}

	public String getArtifactTypeDescription() {
		return "ANTLR lexer and parser";
	}
}

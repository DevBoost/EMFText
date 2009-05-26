package org.emftext.sdk.codegen.creators;

import java.io.File;

import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.util.TextResourceGeneratorANTLRErrorListener;

/**
 * Runs ANTLR on a .g file to generate Java classes for the parser and
 * the lexer from the ANTLR grammar specification.
 */
public class ANTLRParserCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		File antlrFile = context.getANTLRGrammarFile();
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(context.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-Xconversiontimeout", "10000", "-o", antlrFile.getParentFile().getAbsolutePath(), antlrFile.getAbsolutePath()});
        antlrTool.process();
	}

	public String getArtifactDescription() {
		return "ANTLR lexer and parser";
	}
}

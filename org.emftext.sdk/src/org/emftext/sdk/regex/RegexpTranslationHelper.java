package org.emftext.sdk.regex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

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

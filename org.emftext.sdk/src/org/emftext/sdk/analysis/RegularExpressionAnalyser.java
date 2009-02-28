package org.emftext.sdk.analysis;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.generators.AntlrTokenDerivator;
import org.emftext.sdk.codegen.regex.ANTLRexpLexer;
import org.emftext.sdk.codegen.regex.ANTLRexpParser;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
import org.emftext.sdk.concretesyntax.NewDefinedToken;

public class RegularExpressionAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		AntlrTokenDerivator tokenDerivator = new AntlrTokenDerivator(syntax);
		for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof DerivedPlaceholder) {
				DerivedPlaceholder placeholder = (DerivedPlaceholder) next;
				String prefix = placeholder.getPrefix();
				String suffix = placeholder.getSuffix();
				// normalize prefix and suffix
				if (prefix.length() == 0) prefix = null;
				if (suffix.length() == 0) suffix = null;
				String derivedExpression = tokenDerivator.deriveTokenDefinition(prefix, suffix);
		
				checkRegexp(resource, derivedExpression, placeholder);
			}
    		
			if (next instanceof NewDefinedToken) {
				NewDefinedToken def = (NewDefinedToken) next;
				checkRegexp(resource, def.getRegex(), def);
			}
		}
	}

	private void checkRegexp(ITextResource resource, String regExp, EObject container) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
		w.print(regExp);
		w.flush();
		w.close();

		try {
			ANTLRexpLexer lexer = new ANTLRexpLexer(
					new ANTLRInputStream(new ByteArrayInputStream(out
							.toByteArray())));
			ANTLRexpParser parser = new ANTLRexpParser(
					new CommonTokenStream(lexer));
			parser.root();
			if (!parser.recExceptions.isEmpty()) {
				for (RecognitionException e : parser.recExceptions) {
					String message = lexer.getErrorMessage(e, lexer.getTokenNames());
					if (message == null || message.equals(""))
						message = parser.getErrorMessage(e, parser.getTokenNames());
					resource.addError(message, container);
				}
			}

		} catch (Exception e) {
			resource.addError(e.getMessage(), container);
		}
	}
}

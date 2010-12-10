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
package org.emftext.sdk.syntax_analysis;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime3_3_0.ANTLRInputStream;
import org.antlr.runtime3_3_0.CommonTokenStream;
import org.antlr.runtime3_3_0.RecognitionException;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;
import org.emftext.sdk.regex.ANTLRexpLexer;
import org.emftext.sdk.regex.ANTLRexpParser;

/**
 * An analyser that checks all regular expressions used in a syntax
 * definition to be well-formed.
 */
public class RegularExpressionAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<CompleteTokenDefinition> completeTokens = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCompleteTokenDefinition());
		for (CompleteTokenDefinition next : completeTokens) {
			checkRegexp((CompleteTokenDefinition) next);
		}
	}

	private void checkRegexp(CompleteTokenDefinition tokenDefinition) {
		String expression = tokenDefinition.getRegex();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
		w.print(expression);
		w.flush();
		w.close();

		// parse the regular expression
		List<String> errors = new ArrayList<String>();
		try {
			ANTLRexpLexer lexer = new ANTLRexpLexer(
					new ANTLRInputStream(new ByteArrayInputStream(out
							.toByteArray())));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			ANTLRexpParser parser = new ANTLRexpParser(tokenStream);
			parser.root();
			
			if (!parser.recExceptions.isEmpty()) {
				for (RecognitionException e : parser.recExceptions) {
					String message = lexer.getErrorMessage(e, lexer.getTokenNames());
					if (message == null || message.equals("")) {
						message = parser.getErrorMessage(e, parser.getTokenNames());
					}
					errors.add("Invalid regular expression: " + message);
				}
			}
			// TODO cwende: this check worked with ANTLR 3.2.0, but does not
			// with ANTLR 3.3.0
			/*
			// check whether all tokens were consumed
			if (errors.isEmpty() && tokenStream.index() < tokenStream.size()) {
				errors.add("End of regular expression expected");
			}
			*/
		} catch (Exception e) {
			errors.add(e.getMessage());
		}
		
		// add the found errors (if any) to the resource
		for (String error : errors) {
			if (tokenDefinition instanceof NormalTokenDefinition || tokenDefinition instanceof TokenRedefinition) {
				addProblem(CsAnalysisProblemType.INVALID_REGULAR_EXPRESSION, error, tokenDefinition);
			} else if (tokenDefinition instanceof QuotedTokenDefinition) {
				// actually this should never happen, because the regular expressions
				// for quoted token definitions are derived and must be correct by
				// construction. however, if there is a problem we might as well 
				// report it so it gets obvious that the problem is caused by a
				// quoted token
				List<Placeholder> placeholders = tokenDefinition.getAttributeReferences();
				for (Placeholder next : placeholders) {
					addProblem(CsAnalysisProblemType.INVALID_REGULAR_EXPRESSION, error, next);
				}
			} else {
				throw new RuntimeException("Found unknown type of token definition (" + tokenDefinition.getClass().getName() + ").");
			}
		}
	}
}

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
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime3_2_0.ANTLRInputStream;
import org.antlr.runtime3_2_0.CommonTokenStream;
import org.antlr.runtime3_2_0.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.regex.ANTLRexpLexer;
import org.emftext.sdk.regex.ANTLRexpParser;

/**
 * An analyser that checks all regular expressions used in a syntax
 * definition.
 */
public class RegularExpressionAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof CompleteTokenDefinition) {
				checkRegexp(resource, (CompleteTokenDefinition) next);
			}
		}
	}

	private void checkRegexp(CsResource resource, CompleteTokenDefinition tokenDefinition) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
		w.print(tokenDefinition.getRegex());
		w.flush();
		w.close();

		List<String> errors = new ArrayList<String>();
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
					errors.add("Invalid regular expression: " + message);
				}
			}

		} catch (Exception e) {
			errors.add(e.getMessage());
		}
		
		for (String error : errors) {
			if (tokenDefinition instanceof CompleteTokenDefinition) {
				addProblem(resource, ECsProblemType.INVALID_REGULAR_EXPRESSION, error, tokenDefinition);
			} else {
				List<Placeholder> placeholders = tokenDefinition.getAttributeReferences();
				for (Placeholder next : placeholders) {
					addProblem(resource, ECsProblemType.INVALID_REGULAR_EXPRESSION, error, next);
				}
			}
		}
	}
}

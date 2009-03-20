/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.regex.ANTLRexpLexer;
import org.emftext.sdk.codegen.regex.ANTLRexpParser;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * An analyser that checks all regular expressions used in a syntax
 * definition.
 */
public class RegularExpressionAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof TokenDefinition) {
				checkRegexp(resource, (TokenDefinition) next);
			}
		}
	}

	private void checkRegexp(ITextResource resource, TokenDefinition tokenDefinition) {
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
			if (tokenDefinition instanceof NewDefinedToken) {
				resource.addError(error, tokenDefinition);
			} else {
				List<Placeholder> placeholders = tokenDefinition.getAttributeReferences();
				for (Placeholder next : placeholders) {
					resource.addError(error, next);
				}
			}
		}
	}
}

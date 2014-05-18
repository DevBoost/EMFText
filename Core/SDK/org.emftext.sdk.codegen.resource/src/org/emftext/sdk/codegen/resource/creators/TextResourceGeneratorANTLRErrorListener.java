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

import org.antlr.tool.ANTLRErrorListener;
import org.antlr.tool.Message;
import org.antlr.tool.ToolMessage;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An error listener for the ANTLR Tool that reports errors by attaching
 * diagnostics to the given resource (containing a concrete syntax model). This
 * ensures that errors that occur when the generated grammar file is processed
 * by the ANTLR Tool, are reported. However, since the file is generated, such
 * errors should not occur.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class TextResourceGeneratorANTLRErrorListener implements
		ANTLRErrorListener {

	private final GenerationContext context;

	public TextResourceGeneratorANTLRErrorListener(GenerationContext context) {
		super();
		this.context = context;
	}

	public void error(Message message) {
		getProblemCollector().addProblem(createError(message));
	}

	public void error(ToolMessage message) {
		getProblemCollector().addProblem(createError(message));
	}

	public void info(String message) {
		getProblemCollector().addProblem(createWarning(message));
	}

	public void warning(Message message) {
		getProblemCollector().addProblem(createWarning(formatMessage(message)));
	}

	private GenerationProblem createError(Message message) {
		String formattedMessage = formatMessage(message);
		ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		Severity error = Severity.ERROR;
		return new GenerationProblem(formattedMessage, concreteSyntax, error);
	}

	private GenerationProblem createWarning(String message) {
		String formattedMessage = formatMessage(message);
		ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		Severity warning = Severity.WARNING;
		return new GenerationProblem(formattedMessage, concreteSyntax, warning);
	}

	private String formatMessage(Message msg) {
		return formatMessage(msg + "");
	}

	private IProblemCollector getProblemCollector() {
		return context.getProblemCollector();
	}

	/**
	 * Converts a message from the ANTLR tool to something that is human
	 * readable and that can be attached to a resource.
	 * 
	 * @param message
	 *            Message from the ANTLR Tool
	 * @return a readable message
	 */
	private String formatMessage(String message) {
		message = message.substring(message.indexOf(":") + 1);
		message = message.substring(message.indexOf(":") + 1);
		message = message.substring(message.indexOf(":") + 2);
		message = message.toString();

		String text = message.substring(message.indexOf(":") + 1);
		return text.replace("\n", "").replace("\r", "");
	}
}

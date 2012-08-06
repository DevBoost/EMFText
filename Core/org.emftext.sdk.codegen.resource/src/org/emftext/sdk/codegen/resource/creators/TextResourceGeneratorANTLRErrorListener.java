/*******************************************************************************
 * Copyright (c) 2006-2012
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
import org.emftext.sdk.codegen.resource.GenerationContext;

/**
 * An error listener for the ANTLR Tool that reports errors by attaching diagnostics to
 * the given resource (containing a concrete syntax model). This ensures that errors that
 * occur when the generated grammar file is processed by the ANTLR Tool, are reported. However,
 * since the file is generated, such errors should not occur.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class TextResourceGeneratorANTLRErrorListener implements ANTLRErrorListener {

    protected GenerationContext context;
    
    public TextResourceGeneratorANTLRErrorListener(GenerationContext context) {
        this.context = context;
    }
    
    public void error(Message msg) {
    	context.getProblemCollector().addProblem(new GenerationProblem(formatMessage(msg), context.getConcreteSyntax(), Severity.ERROR));
    }

    public void error(ToolMessage msg) {
    	context.getProblemCollector().addProblem(new GenerationProblem(formatMessage(msg), context.getConcreteSyntax(), Severity.ERROR));
    }

    public void info(String msg) {
    	context.getProblemCollector().addProblem(new GenerationProblem(formatMessage(msg), context.getConcreteSyntax(), Severity.WARNING));
    }

    public void warning(Message msg) {
    	context.getProblemCollector().addProblem(new GenerationProblem(formatMessage(msg), context.getConcreteSyntax(), Severity.WARNING));
    }
    
    private String formatMessage(Message msg) {
        return formatMessage(msg + "");
    }
    
    /**
     * Converts a message from the ANTLR tool to something that is human
     * readable and that can be attached to a resource.
     * 
     * @param msg Message from the ANTLR Tool
     * @return a readable message
     */
    private String formatMessage(String msg) {
    	msg = msg.substring(msg.indexOf(":") + 1);
    	msg = msg.substring(msg.indexOf(":") + 1);
        msg = msg.substring(msg.indexOf(":") + 2);        
        msg = msg.toString();
        
        String text = msg.substring(msg.indexOf(":") + 1);
        return text.replace("\n", "").replace("\r", "");
     }
}

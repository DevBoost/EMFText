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
package org.emftext.language.petrinets.resource.petrinets.mopp;

public class JavaStringBuffer {

	private StringBuffer stringBuffer;
	private int indent;

	public JavaStringBuffer() {
		this.stringBuffer = new StringBuffer();
	}
	
	private void indent() {
		this.indent++;
	}
	
	private void unIndent() {
		this.indent--;
	}
	
	public void append(String s) {
		if (s.trim().endsWith("}") && !s.contains("{")) unIndent();
		stringBuffer.append(s);
		if (s.trim().endsWith("{")) indent();
	}
	
	public void appendLine(String line) {
		stringBuffer.append("\n");
		if (line.trim().endsWith("}") && !line.contains("{")) unIndent();
		for(int i = 0; i<indent; i++) {
			stringBuffer.append("\t");
		}
		stringBuffer.append(line);
		if (line.trim().endsWith("{")) indent();
	}
	
	public String toString() {
		return stringBuffer.toString();
	}

	public void newline() {
		stringBuffer.append("\n");
		
	}
}

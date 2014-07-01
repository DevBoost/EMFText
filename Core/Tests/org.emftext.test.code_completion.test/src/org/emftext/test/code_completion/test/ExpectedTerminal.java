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
package org.emftext.test.code_completion.test;

import org.emftext.test.code_completion.test.access.IContainmentTrace;
import org.emftext.test.code_completion.test.access.IExpectedElement;
import org.emftext.test.code_completion.test.access.IExpectedTerminal;

public class ExpectedTerminal implements IExpectedTerminal {

	private IExpectedElement terminal;
	private int startIncludingHidden;
	private int startExcludingHidden;
	
	public ExpectedTerminal(IExpectedElement terminal,
			int startIncludingHidden, int startExcludingHidden) {
		super();
		this.terminal = terminal;
		this.startIncludingHidden = startIncludingHidden;
		this.startExcludingHidden = startExcludingHidden;
	}

	public int getStartExcludingHiddenTokens() {
		return startExcludingHidden;
	}

	public int getStartIncludingHiddenTokens() {
		return startIncludingHidden;
	}

	public void setPosition(int beginIncl, int beginExcl) {
		throw new UnsupportedOperationException();
	}

	public IExpectedElement getTerminal() {
		return terminal;
	}
	
	// we delegate toString() to the terminal to allow
	// comparison of the terminals
	public String toString() {
		return terminal.toString() + " at " + startIncludingHidden + "/" + startExcludingHidden;
	}

	public boolean equals(java.lang.Object o) {
		// we need to compare using the string representation
		// because the type of 'o' is not known here
		return o.toString().startsWith(this.toString());
	}

	public int getFollowSetID() {
		throw new UnsupportedOperationException();
	}

	public IContainmentTrace getContainmentTrace() {
		throw new UnsupportedOperationException();
	}
}

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
package org.emftext.tools.restricted;

public class RestrictedExpression {
	
	private static final String INV = "inv: ";
	private final String oclExpression;
	private final String violationMessage;
	
	public RestrictedExpression(String oclExpression, String violationMessage) {
		super();
		this.oclExpression = oclExpression;
		this.violationMessage = violationMessage;
	}
	
	public RestrictedExpression(String line) {
		String[] l = line.split("!-!");
		if (l.length == 1) {
			this.oclExpression = l[0];
			this.violationMessage = "No Message given";
		} else {
			this.oclExpression = l[1];
			this.violationMessage = l[0];
		}
	}

	public String getViolationMessage() {
		return violationMessage;
	}

	public String getOclExpression() {
		if (isInvariant()) {
			return oclExpression.split(INV)[1];
		} else {
			return oclExpression;
		}
	}
	
	public String getInvariantContext() {
		assert isInvariant();
		
		String fullContext = oclExpression.split(INV)[0];
		fullContext = fullContext.trim();
		String qualifiedType = fullContext.substring("context ".length());
		return qualifiedType;
	}
	
	public boolean isInvariant() {
		String[] parts = oclExpression.split(INV);
		if (parts.length == 1) {
			return false;
		}
		if (parts.length == 2) {
			return true;
		} else {
			// TODO throw error message
			assert false;
			return false;
		}
	}
}

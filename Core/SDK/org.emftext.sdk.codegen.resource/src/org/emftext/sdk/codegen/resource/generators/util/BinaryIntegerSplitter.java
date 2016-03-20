/*******************************************************************************
 * Copyright (c) 2006-2015
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
package org.emftext.sdk.codegen.resource.generators.util;

public class BinaryIntegerSplitter {

	private final int value;
	private int operations = 1;

	public BinaryIntegerSplitter(int value) {
		this.value = value;
	}
	
	public String getComputationCode() {
		if (value == 0) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		int left = value;
		while (left > 0) {
			boolean lowestBitIsSet = left % 2 == 1;
			if (lowestBitIsSet) {
				result.append("1");
			} else {
				result.append("0");
			}
			operations++;
			
			left = left / 2;
			if (left > 0) {
				result.append(",");
			}
		}
		return result.toString();
	}

	public int getOperations() {
		return operations;
	}
}

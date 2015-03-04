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

public class ExpectationIndexInterval {

	private final String metaclassAccessor;
	private final int start;
	private int end;

	public ExpectationIndexInterval(String metaclassAccessor, int start) {
		this.metaclassAccessor = metaclassAccessor;
		this.start = start;
	}

	public void close(int end) {
		this.end = end;
	}

	public String getMetaclassAccessor() {
		return metaclassAccessor;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
}

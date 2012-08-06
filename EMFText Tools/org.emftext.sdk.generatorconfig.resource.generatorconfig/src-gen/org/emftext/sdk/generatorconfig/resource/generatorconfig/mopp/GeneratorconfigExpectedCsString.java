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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class GeneratorconfigExpectedCsString extends org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigAbstractExpectedElement {

	private String value;

	public GeneratorconfigExpectedCsString(org.eclipse.emf.ecore.EClass ruleMetaclass, java.lang.String value) {
		super(ruleMetaclass);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getTokenName() {
		return "'" + value + "'";
	}

	public String toString() {
		return "CsString \"" + value + "\"";
	}

	public boolean equals(Object o) {
		if (o instanceof GeneratorconfigExpectedCsString) {
			return this.value.equals(((GeneratorconfigExpectedCsString) o).value);
		}
		return false;
	}

}

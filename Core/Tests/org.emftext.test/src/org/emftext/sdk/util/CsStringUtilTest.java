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
package org.emftext.sdk.util;

import junit.framework.TestCase;

import org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil;

public class CsStringUtilTest extends TestCase {

	public void testCamelCaseMatching() {
		assertNotNull(CsStringUtil.matchCamelCase("SomeStringInCamelCase", "SomeStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("SSICC", "SomeStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("*SSICC", "SomeStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("S*C", "SomeStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("s", "someLowerStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("sL", "someLowerStringInCamelCase"));
		assertNotNull(CsStringUtil.matchCamelCase("s*L", "someLowerStringInCamelCase"));
		
		assertNull(CsStringUtil.matchCamelCase("SSICC", "prefixSomeStringInCamelCase"));
		
		assertNull(CsStringUtil.matchCamelCase("a[", "prefixSomeStringInCamelCase"));
	}
}

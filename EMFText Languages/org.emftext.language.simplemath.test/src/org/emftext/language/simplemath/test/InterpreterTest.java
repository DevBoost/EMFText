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
package org.emftext.language.simplemath.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.emftext.language.simplemath.Expression;
import org.emftext.language.simplemath.interpreter.InterpretingPostProcessor;
import org.emftext.language.simplemath.resource.sm.ISmOptions;
import org.emftext.language.simplemath.resource.sm.ISmResourcePostProcessor;
import org.emftext.language.simplemath.resource.sm.ISmResourcePostProcessorProvider;


public class InterpreterTest extends AbstractSimpleMathTestCase {

	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void testInterpretation() {
		assertRootValue(3.0, "1+2");
		assertRootValue(7.0, "1+2*3");
		assertRootValue(3.6, "(1+8)/(2/4+1*2)");
		assertRootValue(512, "2^3^2");
		assertRootValue(0, "1-1+2+(-2)");
	}

	private void assertRootValue(double result, String expression) {
		try {
			Expression root = loadResource(expression, "from memory");
			assertEquals(result, root.getValue());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private Expression loadResource(String text, String fileIdentifier) throws IOException {
		return loadResource(new ByteArrayInputStream(text.getBytes()), fileIdentifier);
	}

	@Override
	public Map<?, ?> getLoadOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ISmOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new ISmResourcePostProcessorProvider() {
			
			public ISmResourcePostProcessor getResourcePostProcessor() {
				return new InterpretingPostProcessor();
			}
		});
		return options;
	}
}

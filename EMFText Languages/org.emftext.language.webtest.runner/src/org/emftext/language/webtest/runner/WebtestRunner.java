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
package org.emftext.language.webtest.runner;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.webtest.Command;
import org.emftext.language.webtest.TestScript;
import org.emftext.language.webtest.resource.webtest.interpreter.IWebtestFailureHandler;
import org.emftext.language.webtest.resource.webtest.interpreter.WebtestContext;
import org.emftext.language.webtest.resource.webtest.interpreter.WebtestInterpreter;
import org.emftext.language.webtest.resource.webtest.util.WebtestResourceUtil;
import org.junit.Assert;

public class WebtestRunner {
	
	public void runTest(String pathToScript) {
		URI uri = URI.createURI(pathToScript);
		TestScript script = WebtestResourceUtil.getResourceContent(uri);
		
		WebtestInterpreter interpreter = new WebtestInterpreter();
		List<Command> commands = script.getCommands();
		interpreter.addObjectsToInterpreteInReverseOrder(commands);
		interpreter.interprete(new WebtestContext(new IWebtestFailureHandler() {
			
			public void handleFailedAssertion(String message, String expected,
					String actual) {
				Assert.fail(message + " EXPECTED: " + expected + " ACTUAL: " + actual);
			}
		}));
	}
}

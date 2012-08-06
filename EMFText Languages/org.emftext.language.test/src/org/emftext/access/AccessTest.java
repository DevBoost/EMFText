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
package org.emftext.access;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.emftext.access.resource.IMetaInformation;
import org.emftext.language.test.TestLanguageRegistry;
import org.junit.Before;
import org.junit.Test;

public class AccessTest extends TestCase {

	@Before
	public void setUp() {
		new TestLanguageRegistry().registerAllLanguages();
	}

	@Test
	public void testAccessInterfaces() throws Exception {
		for (IMetaInformation metaInformation : EMFTextAccessPlugin.getConcreteSyntaxRegistry()) {
			invokeAllMethods(metaInformation, IMetaInformation.class);
		}
	}


	protected void invokeAllMethods(
			Object accessProxy, Class<?> accessInterface) throws Exception {
		for (Method method : accessInterface.getMethods()) {
			int argNo = method.getParameterTypes().length;
			Object[] emptyArgs = new Object [argNo];
			for(int i = 0; i < argNo; i++) {
				if (method.getParameterTypes() [i] == InputStream.class) {
					emptyArgs[i] = new ByteArrayInputStream(new byte[]{});
				}
				else if (method.getParameterTypes() [i] == String.class) {
					emptyArgs[i] = "UTF-8";
				}
				else {
					emptyArgs[i] = null;
				}
			}

			Object result = null;
			try {
				result = method.invoke(accessProxy, emptyArgs);
			} catch (InvocationTargetException e) {
				if (!(e.getCause() instanceof IllegalArgumentException)) {
					e.getCause().printStackTrace();
					fail("Exceptions other than IllegalArgumentException are not allowed (was " + e.getCause() + ".");
				}
			}
			//only an error is reported but no exception is thrown if the method is not found
			//the result will be null, but it can also be null because the impl method returns null
			//therefore, there is no assertion can be done here

			if (isAccessInterface(method.getReturnType())) {
				if (result != null) {
					invokeAllMethods(result, method.getReturnType());
				}
				else {
					System.err.println("WARNING: " + method + " returned null. Can not test " + method.getReturnType());
				}
			}
		}
	}

	private boolean isAccessInterface(Class<?> returnType) {
		for (Class<?> nextType : EMFTextAccessProxy.DEFAULT_ACCESS_INTERFACES) {
			if (nextType == returnType) {
				return true;
			}
		}
		return false;
	}

}

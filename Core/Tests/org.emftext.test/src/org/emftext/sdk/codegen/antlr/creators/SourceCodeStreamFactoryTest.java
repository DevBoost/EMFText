/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.antlr.creators;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.antlr.runtime3_4_0.ANTLRFileStream;
import org.emftext.sdk.util.StreamUtil;
import org.junit.Test;

/**
 * The {@link SourceCodeStreamFactoryTest} checks whether the ANTLR runtime 
 * source files can be found in packaged JAR files. This is somewhat tricky,
 * because the localization of the source code of these classes must work both
 * when the EMFText plug-ins are present as projects (i.e., not packaged as JAR
 * files) and when they're packaged (e.g., when using them in builds that rely
 * on EMFText).
 */
public class SourceCodeStreamFactoryTest {

	@Test
	public void testGetSourceCodeStream() {
		SourceCodeStreamFactory streamFactory = new SourceCodeStreamFactory();
		try {
			InputStream stream = streamFactory.getSourceCodeStream(SourceCodeStreamTestReferenceClass.class, ANTLRFileStream.class.getName());
			assertNotNull("Stream expected", stream);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			StreamUtil.copy(stream, output);
			stream.close();
			String sourceCode = output.toString();
			assertTrue("Source code must contain class definition.", sourceCode.contains("public class ANTLRFileStream"));
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}

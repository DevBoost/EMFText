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
package org.emftext.language.templateconcepts.interpreter.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.templateconcepts.Template;
import org.emftext.language.templateconcepts.interpreter.ITemplateInterpreter;
import org.emftext.language.templateconcepts.interpreter.TemplateInterpreterFactory;

public abstract class AbstractInterpreterTestCase extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}

	protected void testInterpretation(String templateFileName, String customerFileName, String expectedResult) {
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();

			String path = getInputFolder() + File.separator + customerFileName;
			Resource resource = resourceSet.createResource(URI.createFileURI(path));
			assertNotNull("Can't create resource for '" + path + "'- probably there is no suitable registered factory.", resource);
			resource.load(null);
			EObject inputModelRoot = (EObject) resource.getContents().get(0);

			Resource templateResource = resourceSet.createResource(URI.createFileURI(getInputFolder() + File.separator + templateFileName));
			templateResource.load(null);
			Template template = (Template) templateResource.getContents().get(0);

			ITemplateInterpreter interpreter = TemplateInterpreterFactory.createTemplateInterpreter();
			EObject templateInstanceAST = interpreter.interprete(template, inputModelRoot, Collections.<Diagnostic>emptyList());
			assertNotNull(templateInstanceAST);

			// pretty print templateInstanceAST
			String outputPath = "output." + getOutputFileExtension();
			Resource instance = resourceSet.createResource(URI.createURI(outputPath));
			assertNotNull("Can't create resource for '" + outputPath + "'- probably there is no suitable registered factory.", resource);
			instance.getContents().add(templateInstanceAST);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			instance.save(outputStream, null);

			// normalize output
			String result = new String(outputStream.toByteArray());
			result = result.replace("\n", " ");
			result = result.replace("\r", " ");
			result = result.replace("\t", " ");
			result = result.replace("  ", " ");
			result = result.trim();

			System.out.println("AbstractInterpreterTest.testInterpretation() expected:\n" + expectedResult);
			System.out.println("AbstractInterpreterTest.testInterpretation() actual:\n" + result);
			// compare output with expected result
			assertEquals(expectedResult, result);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	protected abstract String getOutputFileExtension();
	protected abstract String getInputFolder();
	protected abstract void registerResourceFactories();
}

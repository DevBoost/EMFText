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
package org.emftext.sdk.syntaxgen;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.ui.jobs.HUTNGenerationProcess;
import org.emftext.sdk.util.StreamUtil;
import org.emftext.test.PluginTestHelper;

public class SyntaxGeneratorTest extends TestCase {

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		new CsMetaInformation().registerResourceFactory();

		EPackage.Registry.INSTANCE.put(
				GenModelPackage.eNS_URI, 
				GenModelPackage.eINSTANCE
		);
		EPackage.Registry.INSTANCE.put(
				EcorePackage.eNS_URI, 
				EcorePackage.eINSTANCE
		);
	}
	
	public void testHutnGeneration() {
		String testName = "hutntest1";

		HUTNGenerationProcess hutnProcess = new HUTNGenerationProcess(null);
		
		ConcreteSyntax concreteSyntax = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		
		Class<?> clazz = this.getClass();
		String packageName = clazz.getPackage().getName();

		// use the class loaded to figure out where the plug-in is located
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(clazz);
		
		String pathToCurrentDir = pluginRootPath + File.separator + "src" + File.separator + packageName.replace(".", File.separator) + File.separator;
		String pathToGenModel = pathToCurrentDir + testName + ".genmodel";
		File genModelFile = new File(pathToGenModel);
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource genModelResource = resourceSet.getResource(URI.createFileURI(genModelFile.getAbsolutePath()), true);
		try {
			genModelResource.load(null);
		} catch (IOException e1) {
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		assertNotNull(genModelResource);
		EList<EObject> contents = genModelResource.getContents();
		EcoreUtil.resolveAll(resourceSet);
		assertNotNull(contents);
		assertTrue(contents.size() > 0);
		EObject root = contents.get(0);
		assertTrue(root instanceof GenModel);
		GenModel genModel = (GenModel) root;
		hutnProcess.fillSyntax(concreteSyntax, genModel);
		
		Resource syntaxResource = resourceSet.createResource(URI.createURI("test_result.cs"));
		syntaxResource.getContents().add(concreteSyntax);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			syntaxResource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String result = outputStream.toString();
		System.out.println("SyntaxGeneratorTest.testHutnGeneration() RESULT IS ==>" + result + "<==");

		File expectationFile = new File(pathToCurrentDir + testName + ".expected");
		String expectedResult = null;
		try {
			expectedResult = StreamUtil.getContentAsString(expectationFile);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			return;
		}
		// replace line breaks with the ones on the current system
		String separator = System.getProperty("line.separator");
		expectedResult = expectedResult.replace("\r\n", separator);
		expectedResult = expectedResult.replaceAll("\\r[^\\n]", separator);
		expectedResult = expectedResult.replace("[^\\r]\\n", separator);
		
		System.out.println("SyntaxGeneratorTest.testHutnGeneration() EXPECTED IS ==>" + expectedResult + "<==");
		assertEquals(expectedResult, result);
	}
}

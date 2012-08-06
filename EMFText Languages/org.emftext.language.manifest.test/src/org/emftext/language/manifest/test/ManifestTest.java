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
package org.emftext.language.manifest.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestPackage;
import org.emftext.language.manifest.resource.manifest.mopp.MFResourceFactory;
import org.emftext.language.manifest.resource.manifest.util.MFStreamUtil;
import org.junit.Test;

/**
 * Test for parsing several MANIFEST.MF files.
 * Copy MANIFEST.MF files generated from PDE into the input folder and then run the suite.
 * The suite loads all files as Manifest models and saves (prints) them. After that the content
 * as String will be compared. 
 * 
 * @author jreimann
 *
 */
public class ManifestTest extends TestCase {

	private static final String INPUT_FOLDER = "input";

	private File inputFolder;

	public void setUp() {
		initInputFolder();
		registerPackages();
	}

	private void registerPackages() {
		EPackage.Registry.INSTANCE.put(ManifestPackage.eNS_URI, ManifestPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("MF", new MFResourceFactory());
	}

	private void initInputFolder() {
		inputFolder = new File(INPUT_FOLDER);
		assertEquals("Input folder doesn't exist", true, inputFolder.exists());
	}

	@Test
	public void testManifestFileParsing(){
		File[] manifestFiles = inputFolder.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.endsWith(".MF");
			}
		});
		ResourceSet rs = new ResourceSetImpl();
		for (File file : manifestFiles) {
			System.out.println("Trying to print: " + file.getName());
			URI uri = URI.createFileURI(file.getAbsolutePath());
			Resource resource = rs.getResource(uri, true);
			assertNotNull("Resource could not be loaded", resource);
			Manifest manifest = (Manifest) resource.getContents().get(0);
			assertNotNull("Resource must contain a Manifest model", manifest);
			OutputStream os = new ByteArrayOutputStream();
			try {
				resource.save(os, null);
				os.flush();
			} catch (IOException e) {
				fail("Error while saving model");
			}
			String printResult = normalizeLineBreaks(os.toString());
			try {
				String original = MFStreamUtil.getContent(new FileInputStream(file));
				original = normalizeLineBreaks(original);
				
				System.out.println("Original was ==>" + original + "<==");
				System.out.println("Print result is ==>" + printResult + "<==");
				assertEquals("Files are not equal", original, printResult);
			} catch (FileNotFoundException e) {
				fail("File not found");
			} catch (IOException e) {
				fail("Error while reading file");
			}
		}
	}

	private String normalizeLineBreaks(String text) {
		text = text.replace("\r\n", "\n");
		text = text.replace("\r", "\n");
		return text;
	}
}

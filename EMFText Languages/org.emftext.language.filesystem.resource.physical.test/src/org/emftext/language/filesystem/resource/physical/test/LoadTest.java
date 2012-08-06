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
package org.emftext.language.filesystem.resource.physical.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.filesystem.Folder;
import org.emftext.language.filesystem.resource.physical.PhysicalFilesystemResourceFactory;

import junit.framework.TestCase;

public class LoadTest extends TestCase {

	public void testLoadDirectory() {
		registerResourceFactories();

		String folderName = "test1.modeldir";

		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI("input" + File.separator + folderName));
		assertNotNull(r);
		try {
			r.load(null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		List<EObject> contents = r.getContents();
		assertNotNull(contents);
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertNotNull(root);
		assertTrue(root instanceof Folder);
		Folder rootFolder = (Folder) root;
		assertEquals(folderName, rootFolder.getName());
		List<org.emftext.language.filesystem.File> filesInFolder = rootFolder.getContents();
		assertNotNull(filesInFolder);
		assertEquals(1, filesInFolder.size());
		org.emftext.language.filesystem.File fileInFolder = filesInFolder.get(0);
		assertNotNull(fileInFolder);
		assertEquals("SomeFile.txt", fileInFolder.getName());
	}

	private void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"modeldir",
				new PhysicalFilesystemResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new EcoreResourceFactoryImpl());
	}
}

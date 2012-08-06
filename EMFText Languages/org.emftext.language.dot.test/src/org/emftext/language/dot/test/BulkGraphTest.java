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
package org.emftext.language.dot.test;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.dot.resource.dot.mopp.DotResourceFactory;

public class BulkGraphTest extends TestCase {

	public static class ZipEntryTest extends TestCase {

		private ZipFile file;
		private ZipEntry entry;

		public ZipEntryTest(ZipFile file, ZipEntry entry) {
			super(entry.getName());
			this.file = file;
			this.entry = entry;
		}

		public void runTest() {
			Resource resource = new ResourceSetImpl().createResource(URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + file.getName().replaceAll("\\\\", "/") + "!/" + entry.getName()));
			try {
				resource.load(null);
				assertEquals("Found errors in resource.", 0, resource.getErrors().size());
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
	}

	public static Test suite() {
		registerResourceFactory();
		TestSuite suite = new TestSuite("All tests");
		try {
			ZipFile testZip = new ZipFile(new File("input" + File.separator + "test-graphs.zip"));
			Enumeration<? extends ZipEntry> entries = testZip.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				suite.addTest(new ZipEntryTest(testZip, entry));
			}
		} catch (ZipException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return suite;
	}

	private static void registerResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"gv", new DotResourceFactory());
	}
}

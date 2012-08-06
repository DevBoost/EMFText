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
package org.emftext.language.javaproperties.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.javaproperties.KeyValuePair;
import org.emftext.language.javaproperties.PropertySet;
import org.emftext.language.javaproperties.resource.properties.mopp.PropertiesMetaInformation;
import org.emftext.language.javaproperties.resource.properties.mopp.PropertiesResourceFactory;
import org.emftext.language.javaproperties.resource.properties.analysis.PropertiesVALUETokenResolver;

public class PropertiesTest extends TestCase {

	private static final String FILE_EXTENSION = new PropertiesMetaInformation().getSyntaxName();

	public void setUp() {
		registerResourceFactories();
	}
	
	private void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				FILE_EXTENSION,
				new PropertiesResourceFactory());
	}

	public void testParsing() {
		File[] inputFiles = new File(".." + File.separator + PropertySet.class.getPackage().getName() + File.separator + "metamodel").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith("." + FILE_EXTENSION);
			}
		});
		assertTrue("There must be at least one test file", inputFiles.length > 0);
		
		for (File file : inputFiles) {
			PropertySet ecoreProperties = loadAsEcoreModel(file);
			Properties javaProperties = loadAsJavaObject(file);
			compare(ecoreProperties, javaProperties);
		}
	}

	private void compare(PropertySet ecoreProperties, Properties javaProperties) {
		List<KeyValuePair> ecorePairs = ecoreProperties.getProperties();
		int ecoreCount = ecorePairs.size();
		int javaCount = javaProperties.size();
		int commonCount = Math.min(ecoreCount, javaCount);
		Set<Object> javaKeys = javaProperties.keySet();
		List<Object> javaKeyList = new ArrayList<Object>();
		javaKeyList.addAll(javaKeys);
		for (int i = 0; i < commonCount; i++) {
			KeyValuePair ecorePair = ecorePairs.get(i);
			System.out.println("----------------------------------------------------------------");
			String ecoreKey = ecorePair.getKey();
			System.out.println("Ecore key:   '" + ecoreKey + "'");
			String ecoreValue = ecorePair.getValue();
			System.out.println("Ecore value: '" + ecoreValue + "'");
			Object javaValue = javaProperties.get(ecoreKey);
			assertNotNull("Found no java value for ecore key '" + ecoreKey + "'", javaValue);
			assertEquals("Values do not equal", ecoreValue, javaValue);
		}
	}

	private PropertySet loadAsEcoreModel(File file) {
		System.out.println("loadAsEcoreModel(" + file.getAbsolutePath() + ")");
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("PropertiesTest.loadAsEcoreModel() " + diagnostic);
		}
		assertTrue("Resource must not contain errors.", errors.isEmpty());
		List<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof PropertySet);
		PropertySet propertySet = (PropertySet) root;
		return propertySet;
	}

	private Properties loadAsJavaObject(File file) {
		Properties properties = new Properties();
		try {
			FileInputStream stream = new FileInputStream(file);
			properties.load(stream);
			stream.close();
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return properties;
	}
	
	public void testRegexps() {
		String regex = PropertiesVALUETokenResolver.VALUE_PREFIX_REGEX;
		assertEquals("abc", "   abc".replaceAll(regex, ""));
		assertEquals("abc", " = abc".replaceAll(regex, ""));
		assertEquals("abc", " : abc".replaceAll(regex, ""));
	}
}

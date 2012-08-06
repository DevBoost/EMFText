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
package org.emftext.language.java.ejava.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptions;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation;
import org.emftext.language.java.ejava.resource.util.EJavaPostProcessor;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;

/**
 * A test that loads all EJava files and checks that they do not contain errors.
 */
public class LoadAllEJavaFilesTest extends TestCase {
	
	private static final String GENMODEL_GENMODEL_URI = "platform:/plugin/org.eclipse.emf.codegen.ecore/";
	private static final String ECORE_GENMODEL_URI = "platform:/plugin/org.eclipse.emf.ecore/";
	
	private static final String EJAVA_NEW_FILE = "eJava.newfile.ejava";
	
	private Map<URI, URI> uriMap = new LinkedHashMap<URI, URI>();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		map(ECORE_GENMODEL_URI, EClass.class);
		map(GENMODEL_GENMODEL_URI, GenClass.class);
		// register resource factories
		ConcreteSyntaxTestHelper.registerResourceFactories();
		// support text.ecore files
		EcoreResourceFactoryDelegator ecoreResourceFactoryDelegator = new EcoreResourceFactoryDelegator();
		ecoreResourceFactoryDelegator.getResourceFactoriesMap().put("text", new TextEcoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", ecoreResourceFactoryDelegator);
		//initialize JaMoPP to load normal java files
		JaMoPPUtil.initialize();
		new EjavaMetaInformation().registerResourceFactory();
		// initialize packages
		EcorePackage.eINSTANCE.getEClass();
		GenModelPackage.eINSTANCE.getGenClass();
		// register generator models
		ConcreteSyntaxTestHelper.registerEcoreGenModel();
		ConcreteSyntaxTestHelper.registerGenModelGenModel();

		// configure classpath
		JavaClasspath javaClasspath = JavaClasspath.get();
		// *** TODO ideally, this is extracted from the dependencies of the plugin in which the eJava file is located
		javaClasspath.registerClassifierJar(URI.createURI(getJarPath(EClass.class)));
		javaClasspath.registerClassifierJar(URI.createURI(getJarPath(EList.class)));
		javaClasspath.registerClassifierJar(URI.createURI(getJarPath(GenClass.class)));
		javaClasspath.registerSourceOrClassFileFolder(URI.createFileURI("../org.emftext.language.java/src"));
		// ***
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// clear generator model locations
		EcorePlugin.getEPackageNsURIToGenModelLocationMap().clear();
	}

	private String getJarPath(Class<?> clazz) {
		String path = getClassFileLocation(clazz);
		path = path.replace("!/", "");
		return path;
	}

	private void map(String baseURI, Class<?> clazz) {
		URI from = URI.createURI(baseURI);
		URI to = getURI(clazz);
		uriMap.put(from, to);
	}

	private URI getURI(Class<?> clazz) {
		String path = getClassFileLocation(clazz);
		path = path.replace("file:/", "archive:file:/");
		URI uri = URI.createURI(path);
		return uri;
	}

	private String getClassFileLocation(Class<?> clazz) {
		String path = clazz.getResource(clazz.getSimpleName() + ".class").getFile();
		path = path.replaceAll("!.*", "!/");
		return path;
	}

	public void testURIMapping() {
		testLoading(ECORE_GENMODEL_URI + "model/Ecore.ecore");
		testLoading(ECORE_GENMODEL_URI + "model/Ecore.genmodel");
		testLoading(GENMODEL_GENMODEL_URI + "model/GenModel.ecore");
		testLoading(GENMODEL_GENMODEL_URI + "model/GenModel.genmodel");
	}

	public void testLoadAllEJavaFiles() throws IOException {
		List<File> files = findEJavaFiles(new File("..").getAbsoluteFile());
		System.out.println("Found files: " + files.size());
		assertFalse("No EJava files found.", files.isEmpty());
		
		for (File file : files) {
			if (file.getName().equals(EJAVA_NEW_FILE)) {
				//exclude the new file prototype of eJava, which points at a non-existing ecore package
				continue;
			}
			URI uri = URI.createFileURI(file.getCanonicalPath());
			
			//ATTENTION!
			//each file needs to be loaded in a separate resource set, since 
			//eJava creates "virtual" resource inside the set when wrapping 
			//Ecore into Java types. If more that one eJava file is loaded,
			//the real resources overlap with the virtual ones.
			ResourceSet rs = createNewResourceSet();
			Resource resource = rs.getResource(uri, true);
			EcoreUtil.resolveAll(resource);
			List<Diagnostic> errors = resource.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Found error in " + uri.toString() + ": " + error);
			}
			assertTrue("Resource must not have errors.", errors.isEmpty());
		}
	}

	private ResourceSet createNewResourceSet() {
		ResourceSetImpl rs = new ResourceSetImpl();
		
		// configure URI map
		rs.getURIConverter().getURIMap().putAll(uriMap);
		// create and configure resource set
		List<Object> options = new ArrayList<Object>();
		options.add(new EJavaPostProcessor());
		options.add(new org.emftext.language.java.ejava.resource.EJavaPostProcessor());
		
		rs.getLoadOptions().put(IEjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, options);

		return rs;
	}

	private void testLoading(String path) {
		URI uri = URI.createURI(path);
		Resource resource = createNewResourceSet().getResource(uri, true);
		System.out.println("testLoading() uri = " + resource.getURI());
		System.out.println("testLoading() contents = " + resource.getContents());
	}

	private List<File> findEJavaFiles(File dir) {
		List<File> foundFiles = new ArrayList<File>();
		File[] eJavaFiles = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && 
						file.getName().endsWith(".ejava");
			}
		});
		if (eJavaFiles != null) {
			for (File file : eJavaFiles) {
				foundFiles.add(file);
			}
		}
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isDirectory() && 
						!file.getName().startsWith(".");
			}
		});
		if (subDirs == null) {
			return foundFiles;
		}
		for (File subDir : subDirs) {
			foundFiles.addAll(findEJavaFiles(subDir));
		}
		return foundFiles;
	}
}

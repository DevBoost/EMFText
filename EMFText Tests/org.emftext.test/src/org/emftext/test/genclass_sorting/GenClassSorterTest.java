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
package org.emftext.test.genclass_sorting;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.resource.GenClassInheritanceComparator;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;

/**
 * This is a test for bug 1870: Exception while generating AbstractInterpreter 
 * when using Java7.
 */
public class GenClassSorterTest extends TestCase {

	public void testSorting1() {
		GenModelPackage.eINSTANCE.getGenClass();
		EcorePackage.eINSTANCE.getEClass();
		
		ConcreteSyntaxTestHelper.registerEcoreGenModel();
		ConcreteSyntaxTestHelper.registerGenModelGenModel();
		ConcreteSyntaxTestHelper.registerResourceFactories();
		
		String packagePath = GenClassSorterTest.class.getPackage().getName().replace(".", File.separator);
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(GenClassSorterTest.class);
		String fullPackagePath = pluginRootPath + File.separator + "src" + File.separator + packagePath + File.separator;
		String genModelPath = fullPackagePath + "iec61131.genmodel";
		
		File file = new File(genModelPath);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		
		assertNotNull(resource);
		
		List<EObject> contents = resource.getContents();
		assertFalse(contents.isEmpty());
		
		List<GenClass> genClasses = new ArrayList<GenClass>();
		for (EObject contentRoot : contents) {
			Iterator<EObject> iterator = contentRoot.eAllContents();
			while (iterator.hasNext()) {
				EObject eObject = (EObject) iterator.next();
				if (eObject instanceof GenClass) {
					GenClass genClass = (GenClass) eObject;
					genClasses.add(genClass);
				}
			}
		}
		checkContract(genClasses);
		Collections.sort(genClasses, new GenClassInheritanceComparator());
	}
	
	public void testSorting2() {
		List<GenClass> genClasses = createTestGenModel();
		Collections.sort(genClasses, new GenClassInheritanceComparator());
	}

	public void testSorting3() {
		List<GenClass> genClasses = createTestGenModel();
		checkContract(genClasses);
	}

	private List<GenClass> createTestGenModel() {
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		
		GenPackage genPackage = GenModelFactory.eINSTANCE.createGenPackage();
		
		GenClass g1 = createGenClass(genPackage, "G1");
		GenClass g2 = createGenClass(genPackage, "G2");
		GenClass subOfG1 = createGenClass(genPackage, "SubOfG1");
		subOfG1.getEcoreClass().getESuperTypes().add(g1.getEcoreClass());
		GenClass subOfG2 = createGenClass(genPackage, "SubOfG2");
		subOfG2.getEcoreClass().getESuperTypes().add(g2.getEcoreClass());
		GenClass subOfSubOfG2 = createGenClass(genPackage, "SubOfSubOfG2");
		subOfSubOfG2.getEcoreClass().getESuperTypes().add(subOfG2.getEcoreClass());
		createGenClass(genPackage, "G3");

		genModel.getGenPackages().add(genPackage);
		return genPackage.getGenClasses();
	}

	private GenClass createGenClass(GenPackage genPackage, String name) {
		GenClass genClass = GenModelFactory.eINSTANCE.createGenClass();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		genClass.setEcoreClass(eClass);
		genPackage.getGenClasses().add(genClass);
		return genClass;
	}

	private void checkContract(List<GenClass> genClasses) {
		GenClassInheritanceComparator comparator = new GenClassInheritanceComparator();
		// compare every class with every other class (pair-wise)
		for (GenClass genClass1 : genClasses) {
			for (GenClass genClass2 : genClasses) {
				if (genClass1 == genClass2) {
					continue;
				}
				int result1 = comparator.compare(genClass1, genClass2);
				int result2 = comparator.compare(genClass2, genClass1);
				// check asymmetry
				assertEquals(genClass1.getName() + " and " + genClass2.getName() + " do not yield an asymmetric comparison result.", result1, -result2);
			}
		}
	}
}

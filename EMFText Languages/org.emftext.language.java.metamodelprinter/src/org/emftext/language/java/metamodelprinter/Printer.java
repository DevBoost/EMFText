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
package org.emftext.language.java.metamodelprinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaPackage;

/**
 * A printer for Ecore meta models. It counts the number of classes
 * (both abstract and concrete ones) and prints their names to the
 * console.
 */
public class Printer {

	public final static class NamedAndTypedFeature {

		private String name;
		private String typeName;

		public NamedAndTypedFeature(String name, String typeName) {
			super();
			this.name = name;
			this.typeName = typeName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result
					+ ((typeName == null) ? 0 : typeName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NamedAndTypedFeature other = (NamedAndTypedFeature) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (typeName == null) {
				if (other.typeName != null)
					return false;
			} else if (!typeName.equals(other.typeName))
				return false;
			return true;
		}
	}

	/**
	 * Run this method without arguments to obtain a print for
	 * the JaMoPP meta model. Pass a path to file to get a print
	 * for a different .ecore file.
	 */
	public static void main(String[] args) throws IOException {
		registerResourceFactories();

		List<EPackage> packages;
		if (args.length > 0) {
			packages = getPackages(args[0]);
		} else {
			JavaPackage jPackage = JavaPackage.eINSTANCE;
			packages = jPackage.getESubpackages();
		}
		doCount(packages);
	}

	private static List<EPackage> getPackages(String filename) throws IOException {
		List<EPackage> packages = new ArrayList<EPackage>();
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI(filename));
		r.load(null);
		TreeIterator<EObject> it = r.getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof EPackage) {
				System.out.println("Printer.main() adding " + next);
				packages.add((EPackage) next);
			}
		}
		return packages;
	}

	public static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
	}

	private static void doCount(List<EPackage> packages) {
		int abstractClasses = 0;
		int concreteClasses = 0;
		int packageCount = 0;
		Map<NamedAndTypedFeature, List<EClass>> featureNamesToClasses = new HashMap<NamedAndTypedFeature, List<EClass>>();

		for (EPackage nextPackage : packages) {
			System.out.println(nextPackage.getName());
			EList<EClassifier> classifiers = nextPackage.getEClassifiers();
			for (EClassifier nextClassifier : classifiers) {
				if (nextClassifier instanceof EClass) {
					EClass nextEClass = (EClass) nextClassifier;
					if (nextEClass.isAbstract()) {
						System.out.println("A:: " + nextEClass.getName());
						abstractClasses++;
					} else {
						System.out.println(nextEClass.getName());
						concreteClasses++;
					}
					EList<EStructuralFeature> features = nextEClass.getEStructuralFeatures();
					for (EStructuralFeature feature : features) {
						String featureTypeName = feature.getEType().getName();
						NamedAndTypedFeature featureName = new NamedAndTypedFeature(feature.getName(), featureTypeName);
						if (!featureNamesToClasses.containsKey(featureName)) {
							featureNamesToClasses.put(featureName, new ArrayList<EClass>());
						}
						featureNamesToClasses.get(featureName).add(nextEClass);
					}
				}
			}
			packageCount++;
			System.out.println();
		}

		for (NamedAndTypedFeature featureName : featureNamesToClasses.keySet()) {
			List<EClass> nextClassList = featureNamesToClasses.get(featureName);
			if (nextClassList.size() > 1) {
				System.out.println("Duplicate feature '" + featureName.name + ":" + featureName.typeName + "' in " + toString(nextClassList));
			}
		}
		System.out.println();

		System.out.println("Concrete classes: " + concreteClasses);
		System.out.println("Abstract classes: " + abstractClasses);
		System.out.println("Packages: " + packageCount);
	}

	private static String toString(List<EClass> nextClassList) {
		String result = "";
		for (EClass class1 : nextClassList) {
			result += class1.getName() + ", ";
		}
		return result;
	}
}

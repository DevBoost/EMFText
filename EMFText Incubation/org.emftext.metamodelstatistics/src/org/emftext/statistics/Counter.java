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
package org.emftext.statistics;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class Counter {
	
	private int elements = 0;
	private Map<String, Integer> countByType = new LinkedHashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		new Counter().run();
	}

	private void run() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());

		File input = new File("models");
		File[] ecoreFiles = input.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".ecore");
			}
		});
		for (File ecoreFile : ecoreFiles) {
			try {
				handleFile(ecoreFile);
			} catch (Exception e) {
				System.err.println("Error in " + ecoreFile.getName());
			}
		}
		System.out.println("total elements = " + elements);
		System.out.println("countByType = " + countByType);
	}

	private void handleFile(File ecoreFile) {
		String path = ecoreFile.getAbsolutePath();
		URI uri = URI.createFileURI(path);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			String name = next.eClass().getName();
			incCountByType(name);
			System.out.println(name);
			elements++;
		}
	}

	private void incCountByType(String name) {
		if (countByType.get(name) == null) {
			countByType.put(name, 1);
		} else {
			countByType.put(name, countByType.get(name) + 1);
		}
	}
}

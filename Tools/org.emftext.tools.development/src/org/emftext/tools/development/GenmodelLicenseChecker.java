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
package org.emftext.tools.development;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil;

public class GenmodelLicenseChecker {

	public static void main(String[] args) throws Exception {
		File root = new File("C:\\Projects\\SVN-Working-Copies\\Reuseware");
		new GenmodelLicenseChecker().traverse(root);
	}

	private String copyrightText;
	
	public GenmodelLicenseChecker() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		GenModelPackage.eINSTANCE.getEClassifiers();
		
		copyrightText = CsStreamUtil.getContent(new FileInputStream(new File("genmodel_licence.txt")));
	}

	private void traverse(File directory) throws IOException {
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if ("Third-Party-Plugins".equals(directory.getName())) {
					continue;
				}
				traverse(file);
			} else if (file.getName().endsWith(".genmodel")) {
				//System.out.println("Found genmodel: " + file.getAbsolutePath());
				check(file);
			}
		}
	}

	private void check(File file) throws IOException {
		GenModel genModel = loadGenModel(file);
		String copyrightText = genModel.getCopyrightText();
		if (copyrightText == null || "".equals(copyrightText.trim())) {
			System.out.println("Found genmodel without copyright text: " + file.getAbsolutePath());
			genModel.setCopyrightText(this.copyrightText);
			genModel.eResource().save(null);
		}
	}

	private GenModel loadGenModel(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource genResource = new ResourceSetImpl().getResource(uri, true);
		for (EObject content : genResource.getContents()) {
			if (content instanceof GenModel) {
				return (GenModel) content;
			}
		}
		return null;
	}
}

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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigNewFileContentProvider {
	
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigMetaInformation getMetaInformation() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation();
	}
	
	public java.lang.String getNewFileContent(java.lang.String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		String content = "ClassRule ersteRegel ::= \"einfacher\" \"test\";\nFeatureRule featureRegel ::= \"feature\";".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPrinter(outputStream, new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigResource());
	}
	
}

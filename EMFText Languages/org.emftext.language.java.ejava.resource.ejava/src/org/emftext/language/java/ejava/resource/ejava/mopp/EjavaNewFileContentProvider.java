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
package org.emftext.language.java.ejava.resource.ejava.mopp;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.java.ejava.EClassifierClassWrapper;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.EjavaFactory;
import org.emftext.language.java.ejava.resource.ejava.IEjavaTextPrinter;
import org.emftext.language.java.ejava.resource.ejava.util.EjavaLayoutUtil;
import org.emftext.language.java.ejava.resource.ejava.util.EjavaRuntimeUtil;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsFactory;

public class EjavaNewFileContentProvider {
	
	public org.emftext.language.java.ejava.resource.ejava.IEjavaMetaInformation getMetaInformation() {
		return new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.java.ejava.EjavaPackage.eINSTANCE.getEPackageWrapper(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "// This file should be placed in a folder next to your\n// Ecore model. The folder should have the name of your \n// EPackage. This is similar to how Java source code is\n// structured in folders according to package declarations\n// in the code.\n//\n// You need one eJava file per EClass that is named similar\n// to the EClass.\nepackage MyEPackage;\n\n// plain Java imports\nimport org.eclipse.emf.ecore.EObject;\nimport org.eclipse.emf.common.util.EList;\nimport org.eclipse.emf.common.util.BasicEList;\n \n// import of other EClasses\nimport MyEPackage.MyEClass2;\n\neclass MyEClass {\n\t\n\tmyEOperation() {\n\t\t// Your code goes here. It is automatically added \n\t\t// to your your Ecore model as annotation and will\n\t\t// be considered during EMF code generation.\n\t\tEList<EObject> result = new BasicEList<EObject>();\n\t\t// add some code here that fills the derived list\n\t\treturn result;\n\t}\n}".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	public String getNewFileContent(EPackage metamodel, GenModel genmodel, EClass metaclass) {
		EPackageWrapper packageWrapper = createModel(metamodel, genmodel, metaclass);
		if(packageWrapper == null){
			return "";
		}
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		IEjavaTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(packageWrapper);
		} catch (java.io.IOException e) {
			new EjavaRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}

	private EPackageWrapper createModel(EPackage metamodel, GenModel genmodel, EClass metaclass) {
		GenPackage genPackage = genmodel.findGenPackage(metamodel);
		EPackage ecorePackage = genPackage.getEcorePackage();
		EjavaFactory factory = EjavaFactory.eINSTANCE;
		EPackageWrapper packageWrapper = factory.createEPackageWrapper();
		packageWrapper.setName(ecorePackage.getName());
		packageWrapper.setEPackage(ecorePackage);
		packageWrapper.setGenPackage(genPackage);
		EPackage currentPackage = ecorePackage;
		List<String> namespaces = new ArrayList<String>();
		do {
			namespaces.add(currentPackage.getName());
			currentPackage = currentPackage.getESuperPackage();
		} while (currentPackage != null);
		Collections.reverse(namespaces);
		packageWrapper.getNamespaces().addAll(namespaces);
		EClassifierClassWrapper classWrapper = factory.createEClassifierClassWrapper();
		classWrapper.setEClassifier(metaclass);
		classWrapper.setName(metaclass.getName());
		List<EOperation> operations = metaclass.getEOperations();
		for (EOperation operation : operations) {
			EOperationWrapper operationWrapper = factory.createEOperationWrapper();
			operationWrapper.setName(operation.getName());
			operationWrapper.setEOperation(operation);
			classWrapper.getMembers().add(operationWrapper);
		}
		packageWrapper.getClassifiers().add(classWrapper);
		ClassifierImport classifierImport = ImportsFactory.eINSTANCE.createClassifierImport();
		
		/*
		KeywordLayoutInformation layoutInformation = LayoutFactory.eINSTANCE.createKeywordLayoutInformation();
		layoutInformation.setHiddenTokenText("// Plain Java imports");
		layoutInformation.setVisibleTokenText("import");
		layoutInformation.setSyntaxElementID("JAVA_3_0_0_0");
		classifierImport.getLayoutInformations().add(layoutInformation);
		*/
		
		EClassifierClassWrapper eobjectImport = factory.createEClassifierClassWrapper();
		eobjectImport.setName(EObject.class.getName());
		eobjectImport.setEClassifier(EcorePackage.Literals.EOBJECT);
		classifierImport.setClassifier(eobjectImport);
		packageWrapper.getImports().add(classifierImport);
		return packageWrapper;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, Collection<EClass> allClassesWithSyntax) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.java.ejava.resource.ejava.util.EjavaMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.java.ejava.resource.ejava.IEjavaTextPrinter printer = getPrinter(buffer);
		try {
			new EjavaLayoutUtil().transferAllLayoutInformationFromModel(root);
			printer.print(root);
		} catch (java.io.IOException e) {
			new org.emftext.language.java.ejava.resource.ejava.util.EjavaRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.java.ejava.resource.ejava.IEjavaTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource());
	}

}

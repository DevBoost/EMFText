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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.commons.layout.LayoutInformation;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.resource.ejava.EjavaEProblemType;
import org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder;
import org.emftext.language.java.ejava.resource.ejava.IEjavaTextPrinter;
import org.emftext.language.java.ejava.resource.ejava.util.EjavaLayoutUtil;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.statements.Statement;

public class EjavaBuilder implements IEjavaBuilder {

	private final EjavaLayoutUtil layoutUtil = new EjavaLayoutUtil();

	public boolean isBuildingNeeded(URI uri) {
		// return true to enable building of all resources
		return true;
	}

	public IStatus build(EjavaResource resource, IProgressMonitor monitor) {
		new EjavaMarkerHelper().unmark(resource, EjavaEProblemType.BUILDER_ERROR);

		if (!resource.getContents().isEmpty()) {
			createBodyAnnotations(resource);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}


	private void createBodyAnnotations(EjavaResource resource) {
		EPackageWrapper ePackageWrapper = null;
		if (resource.getContents().get(0) instanceof EPackageWrapper) {
			ePackageWrapper = (EPackageWrapper) resource.getContents().get(0);
		}
		else {
			return;
		}

		EcoreUtil.resolveAll(resource);

		if (!resource.getErrors().isEmpty()) {
			return;
		}

		for(Resource r : new ArrayList<Resource>(resource.getResourceSet().getResources())) {
			if(!r.getContents().isEmpty()) {
				if(r.getContents().get(0) instanceof EPackageWrapper) {
					setToRealJavaPackage((EPackageWrapper) r.getContents().get(0));
				}
			}
		}

		resource.getResourceSet().getLoadOptions().put(
				JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES, Boolean.TRUE);

		for(ConcreteClassifier concreteClassifier : ePackageWrapper.getClassifiers()) {
			for (Member member : concreteClassifier.getMembers()) {
				if (member instanceof EOperationWrapper) {
					EOperationWrapper wrapper = (EOperationWrapper) member;
					// TODO this is a temporary fix for a bug that was introduced in revision 13360
					//
					// the original intent of the fix was to allow empty method bodies, but the fix
					// causes problems when multiple eJava files refer to the same metamodel. In this
					// case, saving one eJava file removes all the method bodies that are defined in
					// the other eJava files from the Ecore model. This is because there are wrapper
					// objects for related methods, but their actual body is not known when building
					// one eJava file.
					if (wrapper.getStatements().isEmpty()) {
						continue;
					}
					EOperation eOperation = wrapper.getEOperation();
					EAnnotation genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI);
					if (genModelAnnotation == null) {
						genModelAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
						eOperation.getEAnnotations().add(genModelAnnotation);
					}
					genModelAnnotation.setSource(GenModelPackage.eNS_URI);
					genModelAnnotation.getDetails().put("body", printBody(wrapper, resource));
					String documentation = "";
					for(String s : wrapper.getComments()) {
						s = s.trim();
						if (s.startsWith("/**") && s.endsWith("*/")) {
							s = s.substring(3, s.length() - 1);
							s = s.replaceAll("\n.*\\*", "\n");
							documentation += s;
						}

					}
					genModelAnnotation.getDetails().put("documentation", documentation);
				}
			}
		}

		final Resource ecoreResource = ePackageWrapper.getEPackage().eResource();
		try {
			saveResource(ecoreResource);
		} catch (IOException e) {
			EjavaPlugin.logError("Error saving Ecore model: " + ecoreResource.getURI(), e);
		}
	}

	/**
	 * Saves the given resource, but temporarily modifies the system line
	 * separator to Unix style to avoid irrelevant changes when using eJava on
	 * machines with a different OS.
	 */
	private void saveResource(Resource resource) throws IOException {
		String key = "line.separator";
		String currentLineBreak = System.getProperty(key);
		System.setProperty(key, "\n");
		resource.save(resource.getResourceSet().getLoadOptions());
		System.setProperty(key, currentLineBreak);
	}

	private void setToRealJavaPackage(EPackageWrapper wrapper) {
		// the only way to find the base package is to go to the genmodel
		wrapper.getNamespaces().clear();
		String basePackage = wrapper.getGenPackage().getBasePackage();
		if (basePackage == null) {
			basePackage = "";
		}
		wrapper.getNamespaces().addAll(
				Arrays.asList(basePackage.split("\\.")));
		wrapper.getNamespaces().add(wrapper.getEPackage().getName());

	}

	private String printBody(EOperationWrapper wrapper, EjavaResource resource) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// we use a custom printer, because object instantiations need to be printed
		// differently from what is defined in ejava.cs
		IEjavaTextPrinter printer = new PlainJavaEjavaPrinter(outputStream, resource);
		for (Statement statement : wrapper.getStatements()) {
			try {
				removeLeadingTabs(statement);
				layoutUtil.transferAllLayoutInformationFromModel(statement);
				printer.print(statement);
			} catch (IOException e) {
				EjavaPlugin.logError("Error while printing eJava method body.", e);
			}
		}
		return trimNewLines(outputStream.toString());
	}

	private String trimNewLines(String s) {
		s = s.trim();
		if (s.startsWith("\n")) {
			s = s.substring(1);
		}
		if (s.endsWith("\n")) {
			s = s.substring(0, s.length() - 2);
		}
		return s;
	}

	private void removeLeadingTabs(Commentable element) {
		EList<LayoutInformation> layoutInformations = element.getLayoutInformations();
		for (LayoutInformation layoutInformation : layoutInformations) {
			String hiddenTokenText = layoutInformation.getHiddenTokenText();
			if (hiddenTokenText.contains("\r\n\t\t")) {
				hiddenTokenText = hiddenTokenText.replaceAll("\r\n\t\t", "\n");
			} else if (hiddenTokenText.contains("\n\t\t")) {
				hiddenTokenText = hiddenTokenText.replaceAll("\n\t\t", "\n");
			} else if (hiddenTokenText.startsWith("\t\t")) {
				hiddenTokenText = hiddenTokenText.substring(2);
			}
			layoutInformation.setHiddenTokenText(hiddenTokenText);
		}
		for (EObject contained : element.eContents()) {
			if (contained instanceof Commentable) {
				removeLeadingTabs((Commentable) contained);
			}
		}
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}

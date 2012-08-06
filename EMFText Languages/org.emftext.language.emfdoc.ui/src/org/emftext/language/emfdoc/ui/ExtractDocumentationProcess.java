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
package org.emftext.language.emfdoc.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.language.emfdoc.Documentation;
import org.emftext.language.emfdoc.DocumentationElement;
import org.emftext.language.emfdoc.EmfdocFactory;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocPlugin;
import org.emftext.language.emfdoc.resource.emfdoc.util.EmfdocEObjectUtil;

public class ExtractDocumentationProcess implements IRunnableWithProgress {
	
	private final URI ecoreURI;
	private final URI ecoreDocURI;

	public ExtractDocumentationProcess(URI ecoreURI, URI ecoreDocURI) {
		this.ecoreURI = ecoreURI;
		this.ecoreDocURI = ecoreDocURI;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		ResourceSet rs = new ResourceSetImpl();
		Resource ecoreResource = rs.getResource(ecoreURI, true);
		Resource ecoreDocResource = null;
		try {
			ecoreDocResource = rs.getResource(ecoreDocURI, true);
		} catch (Exception e) {
			// ecoredoc file does not seem to exist
			ecoreDocResource = rs.createResource(ecoreDocURI);
		}
		EList<EObject> contents = ecoreResource.getContents();
		if (contents.isEmpty()) {
			return;
		}
		EObject root = contents.get(0);
		
		Documentation existingDoc = null;
		EList<EObject> docContents = ecoreDocResource.getContents();
		if (docContents.isEmpty()) {
			Documentation newDocumentation = EmfdocFactory.eINSTANCE.createDocumentation();
			docContents.add(newDocumentation);
		}
		existingDoc = (Documentation) docContents.get(0);
		
		if (root instanceof EPackage) {
			EPackage ePackage = (EPackage) root;
			if (existingDoc.getDocumentedPackage() == null) {
				existingDoc.setDocumentedPackage(ePackage);
			}
			Collection<EModelElement> elements = EmfdocEObjectUtil.getObjectsByType(ePackage.eAllContents(), EcorePackage.eINSTANCE.getEModelElement());
			for (EModelElement element : elements) {
				String documentation = EcoreUtil.getDocumentation(element);
				String existingDocumentation = findExistingDocumentation(existingDoc, element);
				if (existingDocumentation != null) {
					// found some documentation
				} else {
					if (documentation != null && documentation.trim().length() != 0) {
						DocumentationElement newDocElement = EmfdocFactory.eINSTANCE.createDocumentationElement();
						newDocElement.setDocumentedElement(element);
						newDocElement.setText(documentation);
						existingDoc.getDocumentationElements().add(newDocElement);
					}
				}
			}
		}
		try {
			ecoreDocResource.save(null);
		} catch (IOException e) {
			EmfdocPlugin.logError("Exception while saving ecore documentation.", e);
		}
	}

	private String findExistingDocumentation(Documentation existingDoc,
			EModelElement element) {
		for (DocumentationElement docElement : existingDoc.getDocumentationElements()) {
			if (docElement.getDocumentedElement() == element) {
				return docElement.getText();
			}
		}
		return null;
	}
}

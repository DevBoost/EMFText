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
package org.emftext.language.emfdoc.resource.emfdoc.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.emfdoc.Documentation;
import org.emftext.language.emfdoc.DocumentationElement;

public class EmfdocBuilder implements org.emftext.language.emfdoc.resource.emfdoc.IEmfdocBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		EList<EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		EObject root = contents.get(0);
		Documentation documentation = (Documentation) root;
		// transfer documentation to Ecore model
		for (DocumentationElement element : documentation.getDocumentationElements()) {
			EModelElement documentedElement = element.getDocumentedElement();
			EcoreUtil.setDocumentation(documentedElement, element.getText());
		}
		// save Ecore model
		EPackage documentedPackage = documentation.getDocumentedPackage();
		if (documentedPackage == null) {
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		try {
			Resource eResource = documentedPackage.eResource();
			if (eResource == null) {
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
			eResource.save(null);
			return org.eclipse.core.runtime.Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, EmfdocPlugin.PLUGIN_ID, "Exception while adding documentation to Ecore model.");
		}
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}

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
package org.emftext.language.emfdoc.resource.emfdoc.analysis;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.emfdoc.DocumentationElement;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocReferenceResolveResult;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocReferenceResolver;
import org.emftext.language.emfdoc.resource.emfdoc.util.EmfdocEObjectUtil;

public class DocumentationElementDocumentedElementReferenceResolver implements IEmfdocReferenceResolver<DocumentationElement, EModelElement> {
	
	public void resolve(String identifier, DocumentationElement container, EReference reference, int position, boolean resolveFuzzy, final IEmfdocReferenceResolveResult<EModelElement> result) {
		EPackage documentedPackage = container.getDocumentation().getDocumentedPackage();
		Collection<EModelElement> elements = EmfdocEObjectUtil.getObjectsByType(documentedPackage.eAllContents(), EcorePackage.eINSTANCE.getEModelElement());
		for (EModelElement element : elements) {
			String path = getPath(element);
			if (path == null) {
				continue;
			}
			if (resolveFuzzy || identifier.equals(path)) {
				result.addMapping(path, element);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	private String getPath(EObject element) {
		if (element == null) {
			return null;
		}
		if (element instanceof EPackage) {
			return null;
		}
		if (element instanceof ENamedElement) {
			ENamedElement namedElement = (ENamedElement) element;
			String parentPath = getPath(namedElement.eContainer());
			if (parentPath == null) {
				return namedElement.getName();
			} else {
				return parentPath + "." + namedElement.getName();
			}
		}
		return getPath(element.eContainer());
	}

	public String deResolve(EModelElement element, DocumentationElement container, EReference reference) {
		return getPath(element);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
}

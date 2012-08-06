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
package org.emftext.language.emfdoc.constraints;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.emfdoc.DocumentationElement;
import org.emftext.language.emfdoc.EmfdocPackage;
import org.emftext.language.emfdoc.resource.emfdoc.EmfdocEProblemSeverity;
import org.emftext.language.emfdoc.resource.emfdoc.EmfdocEProblemType;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocProblem;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocQuickFix;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessor;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocProblem;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocQuickFix;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocResource;
import org.emftext.language.emfdoc.resource.emfdoc.util.EmfdocEObjectUtil;

public class DuplicateDocumentationElementChecker implements IEmfdocResourcePostProcessor {

	public void process(EmfdocResource resource) {
		Set<EModelElement> documentedElements = new LinkedHashSet<EModelElement>();
		EList<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			Collection<DocumentationElement> documentationElements = EmfdocEObjectUtil.getObjectsByType(content.eAllContents(), EmfdocPackage.eINSTANCE.getDocumentationElement());
			for (final DocumentationElement documentationElement : documentationElements) {
				EModelElement documentedElement = documentationElement.getDocumentedElement();
				if (documentedElements.contains(documentedElement)) {
					IEmfdocQuickFix quickFix = new EmfdocQuickFix("Remove documentation", "IMG_ELCL_REMOVE", documentationElement) {
						
						@Override
						public void applyChanges() {
							EcoreUtil.remove(documentationElement);
						}
					};
					IEmfdocProblem problem = new EmfdocProblem(
							"Found duplicate documentation",
							EmfdocEProblemType.ANALYSIS_PROBLEM,
							EmfdocEProblemSeverity.ERROR, 
							quickFix
					);
					resource.addProblem(
							problem, 
							documentationElement
					);
				} else {
					documentedElements.add(documentedElement);
				}
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}

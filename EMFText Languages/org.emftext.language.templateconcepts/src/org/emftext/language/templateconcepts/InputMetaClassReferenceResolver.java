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
package org.emftext.language.templateconcepts;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.templateconcepts.Template;

public class InputMetaClassReferenceResolver {

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.templateconcepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		EClass eClass = (EClass) element;
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == null) {
			return null;
		}
		return ePackage.getNsURI() + "::" + eClass.getName();
	}

	public EClass resolve(String identifier, Template container, EReference reference, int position, boolean resolveFuzzy) {
		String[] namespaceAndClassName = identifier.split("::");
		if (namespaceAndClassName.length == 2) {
			String namespace = namespaceAndClassName[0];
			String className = namespaceAndClassName[1];
			EClassifier classifier = findEClassifier(namespace, className);
			if (classifier == null) {
				return null;
			}
			if (classifier instanceof EClass) {
				return (EClass) classifier;
			}
		}
		return null;
	}

	private EClassifier findEClassifier(String nsURI, String eClassName) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
	    if (ePackage == null) {
	    	return null;
	    } else {
	    	return ePackage.getEClassifier(eClassName);
	    }
	}
}

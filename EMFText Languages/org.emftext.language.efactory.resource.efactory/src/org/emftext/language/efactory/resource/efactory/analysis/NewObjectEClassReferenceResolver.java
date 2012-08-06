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
package org.emftext.language.efactory.resource.efactory.analysis;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.PackageImport;

public class NewObjectEClassReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.NewObject, org.eclipse.emf.ecore.EClass> {
	
	// TODO mseifert: use cache in default reference resolver instead
	private Map<String, EClass> nameToEClassMap = new LinkedHashMap<String, EClass>();

	public void resolve(java.lang.String identifier, org.emftext.language.efactory.NewObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EClass eClassInCache = nameToEClassMap.get(identifier);
		if (eClassInCache != null && !resolveFuzzy) {
			//System.out.println("Cache hit");
			result.addMapping(identifier, eClassInCache);
			return;
		}
		//System.out.println("Cache miss");
		Factory factory = findFactory(container);
		if (factory == null) {
			return;
		}
		EList<PackageImport> ePackages = factory.getEpackages();
		for (PackageImport packageImport : ePackages) {
			EList<EClassifier> eClassifiers = packageImport.getEPackage().getEClassifiers();
			for (EClassifier classifier : eClassifiers) {
				if (classifier != null && classifier instanceof EClass) {
					if (resolveFuzzy) {
						result.addMapping(classifier.getName(), (EClass) classifier);
					} else {
						if (identifier.equals(classifier.getName())) {
							nameToEClassMap.put(classifier.getName(), (EClass) classifier);
							result.addMapping(classifier.getName(), (EClass) classifier);
							return;
						}
					}
				}
			}
		}
	}
	
	private Factory findFactory(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Factory) {
			return (Factory) object;
		}
		return findFactory(object.eContainer());
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.efactory.NewObject container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}

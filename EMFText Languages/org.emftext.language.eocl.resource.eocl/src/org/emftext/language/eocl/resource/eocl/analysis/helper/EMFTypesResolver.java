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
package org.emftext.language.eocl.resource.eocl.analysis.helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.eocl.resource.eocl.IEoclReferenceResolveResult;

public class EMFTypesResolver {


	protected Resource resource = null;

	public void doResolve(java.lang.String identifier,
			EObject container,
			org.eclipse.emf.ecore.EReference reference,
			EClass typeToResolve,
			boolean resolveFuzzy, IEoclReferenceResolveResult<?> result) {



		EPackage ePackage = null;
		String eClassName = identifier;
		List<EClassifier> candidates = new LinkedList<EClassifier>();
		resource = container.eResource();

		if(eClassName.contains("::")) {
			//class resides in another package
			String[] namespaces = eClassName.split("::");
			eClassName = namespaces[namespaces.length - 1];
			String packagePrefix = namespaces[0];


			EObject rootContainer = EcoreUtil.getRootContainer(container);
			if (rootContainer instanceof EPackage &&
					((EPackage)rootContainer).getName().equals(packagePrefix)) {
				//this package?
				ePackage = (EPackage) rootContainer;
				candidates = ePackage.getEClassifiers();
			}
			else {
				//import
				Map<String, EPackage> imports = new HashMap<String, EPackage>();
				collectImports(container, imports);

				ePackage = imports.get(packagePrefix);

				if(ePackage == null) {
					result.setErrorMessage("EPackage '" + packagePrefix + "' not found");
					return;
				}
			}

			//subpackages
			outer : for(int i = 1; i < namespaces.length - 1; i++) {
				for(EPackage subPackage : ePackage.getESubpackages()) {
					if(namespaces[i].equals(subPackage.getName())) {
						ePackage = subPackage;
						continue outer;
					}
				}
				result.setErrorMessage("Nested EPackage '" + namespaces[i] + "' not found");
				return;
			}
			candidates = ePackage.getEClassifiers();
		}
		else {
			EObject parent = container;
			while (parent.eContainer() != null /* && !(parent instanceof EPackage)*/) {
				parent = parent.eContainer();
			}
			TreeIterator<EObject> allContents = parent.eAllContents();
			while (allContents.hasNext()) {
				EObject object = (EObject) allContents.next();
				if (object instanceof EClassifier) candidates.add((EClassifier) object);
			}
		}



		addResults(identifier, eClassName, candidates, typeToResolve, resolveFuzzy, result);
		if (!result.wasResolved() && !identifier.contains("::")) {
			//try the "default" package Ecore
			addResults(identifier, identifier, EcorePackage.eINSTANCE.getEClassifiers(), typeToResolve, resolveFuzzy, result);
		}
	}

	private void addResults(String identifier, String className, List<EClassifier> candidates,
			EClass typeToResolve, boolean resolveFuzzy, IEoclReferenceResolveResult result) {
		for (EClassifier next : candidates) {
			if (typeToResolve.isInstance(next)) {
				EClassifier classifier = (EClassifier) next;

				if (resolveFuzzy) {
					if (classifier.getName().startsWith(className)) {
						result.addMapping(classifier.getName(), classifier);
					}
				} else {
					if (classifier.getName().equals(className)) {
						result.addMapping(identifier, classifier);
						return;
					}
				}

				//type parameter?
				for(ETypeParameter typeParameter : classifier.getETypeParameters()) {
					if (typeParameter.getName().equals(className)) {
						result.addMapping(identifier, classifier);
						return;
					}
				}
			}
		}
	}

	private void collectImports(EObject element, Map<String, EPackage> imports) {
		EAnnotation importAnnotation = null;
		if (element instanceof EModelElement) {
			importAnnotation = ((EModelElement)element).getEAnnotation("import");
			if (importAnnotation != null) {
				for(String key : importAnnotation.getDetails().keySet()) {
					if (!imports.containsKey(key)) {
						EPackage importedEPackage = findEPackage(importAnnotation.getDetails().get(key));
						imports.put(key, importedEPackage);
					}
				}
			}
		}
		if (element.eContainer() != null) {
			collectImports(element.eContainer(), imports);
		}
	}

	private EPackage findEPackage(String uriString) {
		if(resource == null) {
			return null;
		}
		ResourceSet rs = resource.getResourceSet();
		if (rs == null) {
			return null;
		}
		Resource ePackageResource = null;
		URI uri = URI.createURI(uriString);
		uri = uri.resolve(resource.getURI()); //relative
		try {
			ePackageResource = rs.getResource(uri, true);
		} catch (Exception e) {}

		if (ePackageResource.getContents().isEmpty() ||
				!(ePackageResource.getContents().get(0) instanceof EPackage)) {
			return null;
		}
		return (EPackage) ePackageResource.getContents().get(0);
	}



}




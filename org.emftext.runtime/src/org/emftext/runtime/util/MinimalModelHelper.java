/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A helper class that is able to create minimal model instances for Ecore
 * models.
 * 
 * TODO mseifert: add cross references where possible
 *                Proxies are now added with a pointer to nowhere. This way we have 
 *                at least something that can be printed even if it results in an error.
 */
public class MinimalModelHelper {

	private final static EClassUtil eClassUtil = new EClassUtil();

	public EObject getMinimalModel(EClass eClass, Collection<EClass> allAvailableClasses) {
		return getMinimalModel(eClass, allAvailableClasses.toArray(new EClass[allAvailableClasses.size()]), null);
	}
	
	public EObject getMinimalModel(EClass eClass, EClass[] allAvailableClasses) {
		return getMinimalModel(eClass, allAvailableClasses, null);
	}
	
	public EObject getMinimalModel(EClass eClass, EClass[] allAvailableClasses, String name) {
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == null) {
			return null;
		}
		EObject root = ePackage.getEFactoryInstance().create(eClass);
		List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isUnsettable()) {
					continue;
				}
				if (!reference.isChangeable()) {
					continue;
				}

				EClassifier type = reference.getEType();
				if (type instanceof EClass) {
					EClass typeClass = (EClass) type;
					if (eClassUtil.isNotConcrete(typeClass)) {
						// find subclasses
						List<EClass> subClasses = eClassUtil.getSubClasses(typeClass, allAvailableClasses);
						if (subClasses.size() == 0) {
							continue;
						} else {
							// pick the first subclass
							typeClass = subClasses.get(0);
						}
					}
					int lowerBound = reference.getLowerBound();
					for (int i = 0; i < lowerBound; i++) {
						EObject subModel = null;
						if (reference.isContainment()) {
							subModel = getMinimalModel(typeClass, allAvailableClasses);
						}
						else {
							// TODO jjohannes: can we actually do this? proxies with
							// URIs that can not be resolved cause problem when printing
							// them. I think we should rather use object that exists in
							// the model and fill non-containment references with them.
							//
							// the code below prevents the NewFileWizard for the CS language
							// to work
							/*
							subModel = typeClass.getEPackage().getEFactoryInstance().create(typeClass);
							//set some proxy URI to make this object a proxy
							String initialValue = "#some" + StringUtil.capitalize(typeClass.getName());
							URI proxyURI = URI.createURI(initialValue);
							((InternalEObject)subModel).eSetProxyURI(proxyURI);
							*/
						}
						if (subModel == null) {
							continue;
						}

						Object value = root.eGet(reference);
						if (value instanceof List<?>) {
							List<EObject> list = ListUtil.castListUnchecked(value);
							list.add(subModel);
						} else {
							root.eSet(reference, subModel);
						}
					}
				}
			} else if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if ("EString".equals(attribute.getEType().getName())) {
					String initialValue;
					if(attribute.getName().equals("name") && name != null) {
						initialValue = name;
					}
					else {
						initialValue = "some" + StringUtil.capitalize(attribute.getName());
					}
					Object value = root.eGet(attribute);
					if (value instanceof List<?>) {
						List<String> list = ListUtil.castListUnchecked(value);
						list.add(initialValue);
					} else {
						root.eSet(attribute, initialValue);
					}
				}
			}
		}
		return root;
	}
}

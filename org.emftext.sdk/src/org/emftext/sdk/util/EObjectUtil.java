/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A utility class that can be used to work with EObjects.
 * While many similar methods are provided by EMF's own
 * EcoreUtil class, the missing ones are collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class EObjectUtil {

	/**
	 * Returns all objects that are found by the iterator, which has
	 * the given type.
	 * 
	 * @param <T>
	 * @param iterator
	 * @param type
	 * @return
	 */
	public static <T> Collection<T> getObjectsByType(Iterator<?> iterator,
			EClassifier type) {
		Collection<T> result = new ArrayList<T>();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (type.isInstance(object)) {
				@SuppressWarnings("unchecked")
				T t = (T) object;
				result.add(t);
			}
		}
		return result;
	}

	/**
	 * Returns the root (top most) container of the given
	 * object.
	 * 
	 * @param object
	 * @return
	 */
	public static EObject findRootContainer(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}

	/**
	 * Returns a list of indices that represent the path to the
	 * given object in the containment hierarchy of the model
	 * that contains the object. For the root element an empty
	 * path is returned. 
	 * 
	 * @param object
	 * @return
	 */
	public static List<Integer> getPath(EObject object) {
		EObject parent = object.eContainer();
		if (parent == null) {
			return new ArrayList<Integer>();
		} else {
			List<Integer> parentPath = getPath(parent);
			
			EStructuralFeature feature = object.eContainingFeature();
			Object value = parent.eGet(feature);
			if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				parentPath.add(list.indexOf(object));
			} else {
				parentPath.add(0);
			}
			return parentPath;
		}
	}
}

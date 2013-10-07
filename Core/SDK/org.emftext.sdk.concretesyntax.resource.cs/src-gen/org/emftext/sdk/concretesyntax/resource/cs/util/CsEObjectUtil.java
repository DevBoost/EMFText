/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.util;

/**
 * A utility class that can be used to work with EObjects. While many similar
 * methods are provided by EMF's own EcoreUtil class, the missing ones are
 * collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class CsEObjectUtil {
	
	public static <T> java.util.Collection<T> getObjectsByType(java.util.Iterator<?> iterator, org.eclipse.emf.ecore.EClassifier type) {
		java.util.Collection<T> result = new java.util.ArrayList<T>();
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
	 * Use EcoreUtil.getRootContainer() instead.
	 */
	@Deprecated
	public static org.eclipse.emf.ecore.EObject findRootContainer(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}
	
	/**
	 * Returns the ancestor with the given type.
	 */
	public static org.eclipse.emf.ecore.EObject findAncestorByType(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EClass type) {
		org.eclipse.emf.ecore.EObject ancestor = null;
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		while (container != null) {
			if (type.isInstance(container)) {
				ancestor = container;
			}
			container = container.eContainer();
		}
		return ancestor;
	}
	
	/**
	 * Returns the closest ancestor with the given type.
	 */
	public static org.eclipse.emf.ecore.EObject findClosestAncestorByType(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EClass type) {
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		while (container != null) {
			if (type.isInstance(container)) {
				return container;
			}
			container = container.eContainer();
		}
		return null;
	}
	
	public static Object invokeOperation(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EOperation o) {
		java.lang.reflect.Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				Object result = method.invoke(element, new Object[]{});
				return result;
			}
		} catch (SecurityException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while matching proxy URI.", e);
		} catch (java.lang.reflect.InvocationTargetException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while matching proxy URI.", e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void setFeature(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EStructuralFeature eFeature, Object value, boolean clearIfList) {
		int upperBound = eFeature.getUpperBound();
		if (upperBound > 1 || upperBound < 0) {
			Object oldValue = object.eGet(eFeature);
			if (oldValue instanceof java.util.List<?>) {
				java.util.List<Object> list = (java.util.List<Object>) oldValue;
				if (clearIfList) {
					list.clear();
				}
				list.add(value);
			} else {
				assert false;
			}
		} else {
			object.eSet(eFeature, value);
		}
	}
	
	/**
	 * Returns the depth of the given element in the containment tree.
	 */
	public static int getDepth(org.eclipse.emf.ecore.EObject element) {
		org.eclipse.emf.ecore.EObject parent = element.eContainer();
		if (parent == null) {
			return 0;
		} else {
			return getDepth(parent) + 1;
		}
	}
	
	/**
	 * Returns the value of the given feature. If the feature is a list, the list item
	 * at the given index is returned. Proxy objects are resolved.
	 */
	public static Object getFeatureValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int index) {
		return getFeatureValue(eObject, feature, index, true);
	}
	
	/**
	 * Returns the value of the given feature. If the feature is a list, the list item
	 * at the given index is returned.
	 */
	public static Object getFeatureValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int index, boolean resolve) {
		// get value of feature
		Object o = eObject.eGet(feature, resolve);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			o = list.get(index);
		}
		return o;
	}
	
	/**
	 * Checks whether the root container of the given object has an EAdapter that is
	 * an instance of the given class. If one is found, it is returned, otherwise the
	 * result is null.
	 */
	public static <T> T getEAdapterFromRoot(org.eclipse.emf.ecore.EObject object, Class<T> clazz) {
		org.eclipse.emf.ecore.EObject root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(object);
		return getEAdapter(root, clazz);
	}
	
	/**
	 * Checks whether the given object has an EAdapter that is an instance of the
	 * given class. If one is found, it is returned, otherwise the result is null.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getEAdapter(org.eclipse.emf.ecore.EObject object, Class<T> clazz) {
		java.util.List<org.eclipse.emf.common.notify.Adapter> eAdapters = object.eAdapters();
		for (org.eclipse.emf.common.notify.Adapter adapter : eAdapters) {
			if (clazz.isInstance(adapter)) {
				return (T) adapter;
			}
		}
		return null;
	}
	
}

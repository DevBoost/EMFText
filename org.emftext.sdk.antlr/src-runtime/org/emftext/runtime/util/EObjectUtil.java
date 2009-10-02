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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.emftext.runtime.EMFTextRuntimePlugin;

/**
 * A utility class that can be used to work with EObjects.
 * While many similar methods are provided by EMF's own
 * EcoreUtil class, the missing ones are collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class EObjectUtil {

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

	public static EObject findRootContainer(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}

	public static Object invokeOperation(EObject element, EOperation o) {
		Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				Object result = method.invoke(element, new Object[]{});
				return result;
			}
		} catch (SecurityException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (InvocationTargetException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		}
		return null;
	}
}

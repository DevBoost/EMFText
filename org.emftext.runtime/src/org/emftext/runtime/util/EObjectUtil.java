package org.emftext.runtime.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;

/**
 * A utility class that can be used to work with EObjects.
 * While many similar methods are provided by EMF's own
 * EcoreUtil class, the missing ones are collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class EObjectUtil {

	public static <T> Collection<T> getObjectsByType(TreeIterator<?> iterator,
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
}

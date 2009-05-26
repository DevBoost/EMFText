package org.emftext.runtime.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;

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

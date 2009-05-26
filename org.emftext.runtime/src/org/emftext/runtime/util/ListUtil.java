package org.emftext.runtime.util;

import java.util.List;

/**
 * A utility class that encapsulates some case operations that need to be performed
 * unchecked, because of Java's type erasure.
 */
public class ListUtil {

	@SuppressWarnings("unchecked")
	public <T> List<T> castListUnchecked(Object list) {
		return (List<T>) list;
	}
}

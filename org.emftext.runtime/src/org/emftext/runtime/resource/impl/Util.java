package org.emftext.runtime.resource.impl;

/**
 * Utility class that provides a method to cast objects to
 * type parameterized classes without a warning.
 */
public class Util {

	@SuppressWarnings("unchecked")
	public static <T > T cast(Object temp) {
		return (T) temp;
	}
}

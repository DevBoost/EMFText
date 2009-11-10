package org.emftext.sdk.concretesyntax.resource.cs.util;

// Utility class that provides a method to cast objects to
// type parameterized classes without a warning.
public class CsCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}

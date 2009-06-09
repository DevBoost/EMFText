package org.emftext.runtime.util;

import org.eclipse.emf.common.util.EMap;

public class MapUtil {
	
	/**
	 * This method encapsulate an unchecked cast from Object to
	 * EMap<Object, Object>. This case can not be performed type
	 * safe, because type parameters are not available for
	 * reflective access to Ecore models.
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static EMap<Object, Object> castToMap(Object value) {
		return (EMap<Object,Object>) value;
	}
}

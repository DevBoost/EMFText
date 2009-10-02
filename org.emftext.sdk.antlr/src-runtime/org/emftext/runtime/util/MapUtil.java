package org.emftext.runtime.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;

public class MapUtil {
	
	/**
	 * This method encapsulate an unchecked cast from Object to
	 * Map<Object, Object>. This case can not be performed type
	 * safe, because type parameters are not available for
	 * reflective access to Ecore models.
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Object, Object> castToMap(Object value) {
		return (Map<Object,Object>) value;
	}
	
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
	public static EMap<Object, Object> castToEMap(Object value) {
		return (EMap<Object,Object>) value;
	}

	public static Map<Object, Object> copySafelyToObjectToObjectMap(Map<?, ?> map) {
		Map<Object, Object> castedCopy = new HashMap<Object, Object>();
		
		if(map == null) {
			return castedCopy;
		}
		
		Iterator<?> it = map.keySet().iterator();
		while (it.hasNext()) {
			Object nextKey = it.next();
			castedCopy.put(nextKey, map.get(nextKey));
		}
		return castedCopy;
	}
}

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
package org.emftext.sdk.concretesyntax.resource.cs.util;

public class CsMapUtil {
	
	/**
	 * This method encapsulate an unchecked cast from Object to java.util.Map<Object,
	 * Object>. This case can not be performed type safe, because type parameters are
	 * not available for reflective access to Ecore models.
	 * 
	 * @param value the object to cast
	 * 
	 * @return the same object casted to a map
	 */
	@SuppressWarnings("unchecked")	
	public static java.util.Map<Object, Object> castToMap(Object value) {
		return (java.util.Map<Object,Object>) value;
	}
	
	/**
	 * This method encapsulate an unchecked cast from Object to
	 * org.eclipse.emf.common.util.EMap<Object, Object>. This case can not be
	 * performed type safe, because type parameters are not available for reflective
	 * access to Ecore models.
	 * 
	 * @return the same object casted to a map
	 */
	@SuppressWarnings("unchecked")	public static org.eclipse.emf.common.util.EMap<Object, Object> castToEMap(Object value) {
		return (org.eclipse.emf.common.util.EMap<Object,Object>) value;
	}
	
	public static java.util.Map<Object, Object> copySafelyToObjectToObjectMap(java.util.Map<?, ?> map) {
		java.util.Map<Object, Object> castedCopy = new java.util.LinkedHashMap<Object, Object>();
		
		if (map == null) {
			return castedCopy;
		}
		
		java.util.Iterator<?> it = map.keySet().iterator();
		while (it.hasNext()) {
			Object nextKey = it.next();
			castedCopy.put(nextKey, map.get(nextKey));
		}
		return castedCopy;
	}
	
}

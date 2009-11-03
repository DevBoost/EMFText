/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

public class GenClassCache {

	private Map<GenClass, String> qualifiedInterfaceNameCache = new HashMap<GenClass, String>();

	public String getQualifiedInterfaceName(GenClass genClass) {
		if (!qualifiedInterfaceNameCache.containsKey(genClass)) {
			String qualifiedInterfaceName = genClass.getQualifiedInterfaceName();
			qualifiedInterfaceNameCache.put(genClass, qualifiedInterfaceName);
		}
		return qualifiedInterfaceNameCache.get(genClass);
	}
}

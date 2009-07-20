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

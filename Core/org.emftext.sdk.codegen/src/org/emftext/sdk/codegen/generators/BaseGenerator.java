/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.util.LinkedHashMap;
import java.util.Map;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.IContext;

/**
 * A basic implementation for generators which generate Java or ANTLR code.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class BaseGenerator<ContextType extends IContext<ContextType>, ParameterType> extends AbstractGenerator<ContextType, ParameterType> {
	
	private final Map<String, String> javaNativeTypeMapping = new LinkedHashMap<String, String>();
	
	public BaseGenerator() {
		super();
		initializeTypeMapping();
	}
	
	private void initializeTypeMapping() {
		javaNativeTypeMapping.put("int", "java.lang.Integer");
		javaNativeTypeMapping.put("short", "java.lang.Short");
		javaNativeTypeMapping.put("long", "java.lang.Long");
		javaNativeTypeMapping.put("double", "java.lang.Double");
		javaNativeTypeMapping.put("byte", "java.lang.Byte");
		javaNativeTypeMapping.put("boolean", "java.lang.Boolean");
		javaNativeTypeMapping.put("float", "java.lang.Float");
		javaNativeTypeMapping.put("char", "java.lang.Character");
	}

    protected String getObjectTypeName(String typeName){
    	if (javaNativeTypeMapping.containsKey(typeName)) {
    		return javaNativeTypeMapping.get(typeName);
    	}
    	return typeName;
    }
}

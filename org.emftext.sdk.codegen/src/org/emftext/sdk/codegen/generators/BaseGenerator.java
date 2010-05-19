/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.generators;

import java.util.HashMap;
import java.util.Map;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.IContext;

/**
 * A basic implementation for generators which generate Java or ANTLR code.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class BaseGenerator<ContextType extends IContext, ParameterType> extends AbstractGenerator<ContextType, ParameterType> {
	
	protected static final Map<String, String> javaNativeTypeMapping;
	static {
		javaNativeTypeMapping = new HashMap<String, String>();
		
		javaNativeTypeMapping.put("int", "java.lang.Integer");
		javaNativeTypeMapping.put("short", "java.lang.Short");
		javaNativeTypeMapping.put("long", "java.lang.Long");
		javaNativeTypeMapping.put("double", "java.lang.Double");
		javaNativeTypeMapping.put("byte", "java.lang.Byte");
		javaNativeTypeMapping.put("boolean", "java.lang.Boolean");
		javaNativeTypeMapping.put("float", "java.lang.Float");
		javaNativeTypeMapping.put("char", "java.lang.Character");
	}

	public BaseGenerator() {
		super();
	}
	
	/**
	 * A BaseGenerator generates its output on a PrintWriter. All its GenerationProblems should be reported
	 * via addProblem(GenerationProblem).<br/>
	 * Important:  Even with valid output there might be problems.
	 * 
	 * @param out - the target stream to write on
	 */
	// TODO mseifert: remove this
	//public abstract void generate(PrintWriter out);
	
    protected String getObjectTypeName(String typeName){
    	if (BaseGenerator.javaNativeTypeMapping.containsKey(typeName)) {
    		return BaseGenerator.javaNativeTypeMapping.get(typeName);
    	}
    	return typeName;
    }
}

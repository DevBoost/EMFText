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

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.emftext.sdk.codegen.ClassNameHelper;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;

/**
 * A basic implementation for generators which generate Java or ANTLR code. 
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class BaseGenerator implements IGenerator, IProblemCollector {
	
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

	
	private List<GenerationProblem> errors;
	private List<GenerationProblem> warnings;
	protected GenerationContext context;
	private String resourceClassName;
	private String resourcePackageName;

	protected ClassNameHelper classNameHelper;

	public BaseGenerator() {
		super();
	}
	
	/**
	 * Creates a new BaseGenerator that can be used to generate an 
	 * artifact of the given type.
	 * 
	 * @param artifact the type of artifact to be generated
	 */
	public BaseGenerator(GenerationContext context, EArtifact artifact) {
		errors = new LinkedList<GenerationProblem>();
		warnings = new LinkedList<GenerationProblem>();

		this.context = context;
		this.classNameHelper = new ClassNameHelper(context);
		this.resourcePackageName = context.getPackageName(artifact);
		this.resourceClassName = context.getClassName(artifact);
	}

	public ClassNameHelper getClassNameHelper() {
		return classNameHelper;
	}

	/**
	 * A ResourceGenerator generates its output on a PrintWriter. All its GenerationProblems should be reported
	 * via addProblem(GenerationProblem).<br/> 
	 * Important:  Even with valid output there might be problems.
	 * 
	 * @param out - the target stream to write on
	 * @return true, iff the result is valid
	 */
	public abstract boolean generate(PrintWriter out);
	
	public GenerationContext getContext() {
		return context;
	}

	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	public void addProblem(GenerationProblem problem){
		if (problem.getSeverity().equals(GenerationProblem.Severity.ERROR)) {
			errors.add(problem);
		} else {
			warnings.add(problem);
		}
	}
	
	
	public Collection<GenerationProblem> getCollectedErrors(){
		return errors;
	}
	
	public Collection<GenerationProblem> getCollectedProblems(){
		List<GenerationProblem> allProblems = new LinkedList<GenerationProblem>(errors);
		allProblems.addAll(warnings);
		return allProblems;
	}
	
	protected String getResourceClassName() {
    	return resourceClassName;
    }
    
    protected String getResourcePackageName() {
    	return resourcePackageName;
    }
    
    protected String getObjectTypeName(String typeName){
    	if (BaseGenerator.javaNativeTypeMapping.containsKey(typeName)) {
    		return BaseGenerator.javaNativeTypeMapping.get(typeName);
    	}
    	return typeName;
    }
}

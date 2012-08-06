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
package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class ClosureQVTOStatisticUtil extends AbstractStatisticUtil {

	private int countNewConstructorCallClosures = 0;
	private int countNewConstructorCall = 0;
	
	private int countMethodCallsClosures = 0;
	private int countMethodCalls = 0;
	
	private int countAssignmentExpressionClosures = 0;
	private int countAssignmentExpression = 0;
	
	private int countLocalVariableClosures = 0;
	private int countLocalVariable = 0;
	
	private int countReturnClosures = 0;
	private int countReturn = 0;
	
	private int countAllClosures = 0;
	
	private int countAnonymousClass = 0;
	private int countClasses = 0;
	
	public void setCountAllClosures(int countAllClosures) {
		this.countAllClosures += countAllClosures;
	}

	public void setCountAnonymousClass(int countAnonymousClass) {
		this.countAnonymousClass += countAnonymousClass;
	}
	
	public void setCountNewConstructorCallClosures(
			int countNewConstructorCallClosures) {
		this.countNewConstructorCallClosures += countNewConstructorCallClosures;
	}

	public void setCountMethodCallsClosures(int countMethodCallsClosures) {
		this.countMethodCallsClosures += countMethodCallsClosures;
	}

	public void setCountAssignmentExpressionClosures(
			int countAssignmentExpressionClosures) {
		this.countAssignmentExpressionClosures += countAssignmentExpressionClosures;
	}

	public void setCountLocalVariableClosures(int countLocalVariableClosures) {
		this.countLocalVariableClosures += countLocalVariableClosures;
	}

	public void setCountReturnClosures(int countReturnClosures) {
		this.countReturnClosures += countReturnClosures;
	}

	public void setCountNewConstructorCall(int countNewConstructorCall) {
		this.countNewConstructorCall += countNewConstructorCall;
	}

	public void setCountMethodCalls(int countMethodCalls) {
		this.countMethodCalls += countMethodCalls;
	}

	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void setCountAssignmentExpression(int countAssignmentExpression) {
		this.countAssignmentExpression += countAssignmentExpression;
	}

	public void setCountLocalVariable(int countLocalVariable) {
		this.countLocalVariable += countLocalVariable;
	}

	public void setCountReturn(int countReturn) {
		this.countReturn += countReturn;
	}
	
	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		
		System.out.println("NewConstructorCall: "+countNewConstructorCall);
		System.out.println("NewConstructorCallClosures: "+countNewConstructorCallClosures);
		
		System.out.println("MethodCalls: "+countMethodCalls);
		System.out.println("MethodCallsClosures: "+countMethodCallsClosures);
		
		System.out.println("AssignmentExpression: "+countAssignmentExpression);
		System.out.println("AssignmentExpressionClosures: "+countAssignmentExpressionClosures);
		
		System.out.println("LocalVariable: "+countLocalVariable);
		System.out.println("LocalVariableClosures: "+countLocalVariableClosures);
		
		System.out.println("Return: "+countReturn);
		System.out.println("ReturnClosures: "+countReturnClosures);
		
		System.out.println("ges. Closures: "+ countAllClosures);
		System.out.println("anonym. Klassen: "+countAnonymousClass);
	}


	@Override
	public void init(){
		
		getRuleNames().put("Instantiations_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("Closures_Closure_NewConstructorCall", Arrays.asList("setCountNewConstructorCallClosures","setCountAllClosures"));
		
		getRuleNames().put("References_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("Closures_Closure_MethodCall", Arrays.asList("setCountMethodCallsClosures","setCountAllClosures"));
		
		getRuleNames().put("Statements_Return", Arrays.asList("setCountReturn"));
		getRuleNames().put("Closures_Closure_Return", Arrays.asList("setCountReturnClosures","setCountAllClosures"));
		
		getRuleNames().put("Variables_LocalVariable", Arrays.asList("setCountLocalVariable"));
		getRuleNames().put("Closures_Closure_LocalVariable", Arrays.asList("setCountLocalVariableClosures","setCountAllClosures"));
		
		getRuleNames().put("Expressions_AssignmentExpression", Arrays.asList("setCountAssignmentExpression"));
		getRuleNames().put("Closures_Closure_AssignmentExpression", Arrays.asList("setCountAssignmentExpressionClosures","setCountAllClosures"));
		
		getRuleNames().put("Count_Classifiers_AnonymousClass", Arrays.asList("setCountAnonymousClass"));
		getRuleNames().put("Count_Classifiers_Class", Arrays.asList("setCountClasses"));
	
		getRuleNames().put("Closure2Ncc", Arrays.asList("setCountAllClosures"));
//		getRuleNames().put("Closures_Closure", Arrays.asList("setCountAllClosures"));
		
		
	}

}

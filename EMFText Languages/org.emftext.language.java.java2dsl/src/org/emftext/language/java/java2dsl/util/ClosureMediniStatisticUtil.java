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

public class ClosureMediniStatisticUtil extends AbstractStatisticUtil {

	private int countNewConstructorCallClosures = 0;
	private int countNewConstructorCall = 0;
	
	private int countMethodCallsClosures = 0;
	private int countMethodCalls = 0;
	
	private int countClasses = 0;
	private int countAnonymousClasses = 0;
	
	private int countAssignmentExpressionClosures = 0;
	private int countAssignmentExpression = 0;
	
	private int countLocalVariableClosures = 0;
	private int countLocalVariable = 0;
	
	private int countReturnClosures = 0;
	private int countReturn = 0;
	
	public void setCountAnonymousClasses(int anonymousClasses) {
		this.countAnonymousClasses += anonymousClasses;
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
		
		System.out.println("ges. anonym. Classes: "+
				(countAnonymousClasses+
				countNewConstructorCallClosures+
				countMethodCallsClosures+
				countAssignmentExpressionClosures+
				countLocalVariableClosures+
				countReturnClosures));
		
		System.out.println("ges. Closures: "+
				(countNewConstructorCallClosures+
				countMethodCallsClosures+
				countAssignmentExpressionClosures+
				countLocalVariableClosures+
				countReturnClosures));
	}


	@Override
	public void init(){
		
		getRuleNames().put("CompilationUnit_Class", Arrays.asList("setCountClasses"));
		getRuleNames().put("Members_Class", Arrays.asList("setCountClasses"));
		
		getRuleNames().put("Instantiations_NewConstructorCall_Closure", Arrays.asList("setCountNewConstructorCallClosures"));
		getRuleNames().put("Statements_StatementListContainer_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_Reference_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_Argumentable_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		
		getRuleNames().put("References_MethodCall_Closure", Arrays.asList("setCountMethodCallsClosures"));
		getRuleNames().put("Statements_StatementListContainer_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("References_Reference_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("References_Argumentable_MethodCall", Arrays.asList("setCountMethodCalls"));
				
		getRuleNames().put("Return_ReturnValue_Closure", Arrays.asList("setCountReturnClosures"));
		getRuleNames().put("Return_ReturnValue_Expression", Arrays.asList("setCountReturn"));
		
		getRuleNames().put("LocalVariable_InitialValue_Expression", Arrays.asList("setCountLocalVariable"));
		getRuleNames().put("LocalVariable_InitialValue_Closure", Arrays.asList("setCountLocalVariableClosures"));
		
		getRuleNames().put("AssignmentExpression_Value_Closure", Arrays.asList("setCountAssignmentExpressionClosures"));
		getRuleNames().put("AssignmentExpression_Value_Expression", Arrays.asList("setCountAssignmentExpression"));
		getRuleNames().put("Instantiations_NewConstructorCall", Arrays.asList("setCountAnonymousClasses"));
		
	}

}

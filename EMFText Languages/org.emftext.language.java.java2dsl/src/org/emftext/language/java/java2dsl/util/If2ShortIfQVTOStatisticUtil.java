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

public class If2ShortIfQVTOStatisticUtil extends AbstractStatisticUtil {

	private int if2shortIf = 0;
	private int shortIf2if = 0;
	private int countClasses = 0;
	private int countIfs = 0;
	private int countShortIfs = 0;
	
	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void setIf2shortIf(int if2shortIf) {
		this.if2shortIf += if2shortIf;
	}    

	public void setShortIf2if(int shortIf2if) {
		this.shortIf2if += shortIf2if;
	}
	
	public void setCountIfs(int countIfs) {
		this.countIfs += countIfs;
	}

	public void setCountShortIfs(int countShortIfs) {
		this.countShortIfs += countShortIfs;
	}
	
	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("Ifs: "+countIfs);
		System.out.println("ShortIfs: "+countShortIfs);
		System.out.println("If->ShortIf: "+if2shortIf);
		System.out.println("If<-ShortIf: "+shortIf2if);

	}

	@Override
	public void init(){
		
		getRuleNames().put("expressions_ConditionalExpression", Arrays.asList("setIf2shortIf"));
		getRuleNames().put("CondExpr2Cond", Arrays.asList("setShortIf2if"));
		getRuleNames().put("Classifiers_Class", Arrays.asList("setCountClasses"));
		getRuleNames().put("Statements_Condition", Arrays.asList("setCountIfs"));
		getRuleNames().put("Expressions_ConditionalExpression", Arrays.asList("setCountShortIfs"));
		
	}

}

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

public class For2ShortForQVTOStatisticUtil extends AbstractStatisticUtil {

	private int for2shortFor = 0;
	private int shortFor2For = 0;
	private int countClasses = 0;
	private int countFors = 0;
	private int countShortFors = 0;
	
	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void setFor2shortFor(int for2shortFor) {
		this.for2shortFor += for2shortFor;
	}

	public void setShortFor2For(int shortFor2For) {
		this.shortFor2For += shortFor2For;
	}

	public void setCountFors(int countFors) {
		this.countFors += countFors;
	}

	public void setCountShortFors(int countShortFors) {
		this.countShortFors += countShortFors;
	}
	
	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("Fors: "+countFors);
		System.out.println("ShortFors: "+countShortFors);
		System.out.println("For->ShortFor: "+for2shortFor);
		System.out.println("For<-ShortFor: "+shortFor2For);

	}

	@Override
	public void init(){
		
		getRuleNames().put("ForLoopToForEachLoop", Arrays.asList("setFor2shortFor"));
		getRuleNames().put("ForEachLoopToForLoop", Arrays.asList("setShortFor2For"));
		getRuleNames().put("Classifiers_Class", Arrays.asList("setCountClasses"));
		getRuleNames().put("Statements_ForLoop", Arrays.asList("setCountFors"));
		getRuleNames().put("Statements_ForEachLoop", Arrays.asList("setCountShortFors"));
		
	}

}

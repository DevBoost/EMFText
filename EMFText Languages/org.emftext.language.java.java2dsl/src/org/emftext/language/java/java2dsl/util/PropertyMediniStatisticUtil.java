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


public class PropertyMediniStatisticUtil extends AbstractStatisticUtil{

	private int countProperties = 0;
	private int countPropertiesReadonly = 0;
	private int countFields = 0;
	private int countClasses = 0;
	private int countInterface = 0;
	private int countEnumeration = 0;
	private int countAnnotation = 0;
	
	public void addProperty(int value){
		countProperties += value;
	}
	
	public void addPropertyReadOnly(int value){
		countPropertiesReadonly += value;
	}
	
	public void addField(int value){
		countFields += value;
	}
	
	public void addClass(int value){
		countClasses += value;
	}
	
	public void addEnumeration(int value){
		countEnumeration += value;
	}
	
	public void addInterface(int value){
		countInterface += value;
	}
	
	public void addAnnotation(int value){
		countAnnotation += value;
	}
	
	@Override
	public void writeStatistic(){
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("Felder: "+countFields);
		System.out.println("Interfaces: "+countInterface);
		System.out.println("Enumerations: "+countEnumeration);
		System.out.println("Annotations: "+countAnnotation);
		System.out.println("gefundene Properties: "+countProperties);
		System.out.println("gefundene readonly Properties: "+countPropertiesReadonly);

	}
	
	@Override
	public void init(){
		
		getRuleNames().put("Members_Property", Arrays.asList("addProperty","addField"));
		getRuleNames().put("Members_PropertyReadOnly", Arrays.asList("addPropertyReadOnly","addField"));
		getRuleNames().put("Members_Field", Arrays.asList("addField"));
		getRuleNames().put("Members_Class", Arrays.asList("addClass"));
		getRuleNames().put("CompilationUnit_Class", Arrays.asList("addClass"));
		getRuleNames().put("CompilationUnit_Interface", Arrays.asList("addInterface"));
		getRuleNames().put("CompilationUnit_Enumeration", Arrays.asList("addEnumeration"));
		getRuleNames().put("CompilationUnit_Annotation", Arrays.asList("addAnnotation"));
		
	}
}

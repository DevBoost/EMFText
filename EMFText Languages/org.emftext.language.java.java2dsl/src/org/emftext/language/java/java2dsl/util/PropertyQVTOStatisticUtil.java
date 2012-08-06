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


public class PropertyQVTOStatisticUtil extends AbstractStatisticUtil{

	private int countProperties = 0;
	private int countPropertiesReadonly = 0;
	private int countPropertiesSetter = 0;
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
		
	public void setCountPropertiesSetter(int countPropertiesSetter) {
		this.countPropertiesSetter += countPropertiesSetter;
	}

	@Override
	public void writeStatistic(){
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("Felder: "+countFields);
		System.out.println("Interfaces: "+countInterface);
		System.out.println("Enumerations: "+countEnumeration);
		System.out.println("Annotations: "+countAnnotation);
		System.out.println("gefundene Properties: "+countProperties);
		if(countPropertiesReadonly == 0 && countPropertiesSetter != 0)
			System.out.println("gefundene readonly Properties: "+(countProperties-countPropertiesSetter));
		else
			System.out.println("gefundene readonly Properties: "+countPropertiesReadonly);

	}
	
	@Override
	public void init(){
		
		getRuleNames().put("Member_Property", Arrays.asList("addProperty"));
		getRuleNames().put("Member_PropertyToField", Arrays.asList("addProperty"));
		
		getRuleNames().put("Member_Property_ReadOnly", Arrays.asList("addPropertyReadOnly"));

		getRuleNames().put("Member_PropertyToSetter", Arrays.asList("setCountPropertiesSetter"));
		
		getRuleNames().put("Member_Field", Arrays.asList("addField"));
		
		getRuleNames().put("Classifiers_Class", Arrays.asList("addClass"));
		getRuleNames().put("Classifiers_Interface", Arrays.asList("addInterface"));
		getRuleNames().put("Classifiers_Enumeration", Arrays.asList("addEnumeration"));
		getRuleNames().put("Classifiers_Annotation", Arrays.asList("addAnnotation"));
		
	}
}

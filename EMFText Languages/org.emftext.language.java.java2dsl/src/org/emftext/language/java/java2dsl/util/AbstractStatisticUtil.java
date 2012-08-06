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

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStatisticUtil {

	private long startTime = 0;
	private long endTime = 0;
	
	private Map<String,List<String>> ruleNames = new HashMap<String,List<String>>();
	
	public AbstractStatisticUtil() {
		init();
	}

	public void setStartTime(long time){
		startTime = time;
	}
	
	public void writeEndTime(long time){
		
		endTime = Calendar.getInstance().getTimeInMillis();
		long seconds = (endTime-startTime)/1000;
		if(seconds <= 60){
			System.out.println("Gesamtdauer Transformationen: "+seconds+" Sekunden.");
		}
		else if (seconds <= 3600){
			long minutes = seconds/60;
			System.out.println("Gesamtdauer Transformationen: "+minutes+" Minuten.");
		}
		else{	
			long minutes = (seconds/60)/60;
			System.out.println("Gesamtdauer Transformationen: "+minutes+" Stunden.");
		}
	}
	
	public Map<String, List<String>> getRuleNames() {
		return ruleNames;
	}

	public abstract void writeStatistic();
	
	public abstract void init();
}

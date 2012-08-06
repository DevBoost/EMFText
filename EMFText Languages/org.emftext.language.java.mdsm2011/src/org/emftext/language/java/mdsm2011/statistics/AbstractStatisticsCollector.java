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
package org.emftext.language.java.mdsm2011.statistics;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStatisticsCollector {

	private long startTime = 0;
	private long endTime = 0;
	
	private Map<String,List<String>> ruleNames = new HashMap<String,List<String>>();
	
	public AbstractStatisticsCollector() {
		init();
	}

	public void setStartTime(long time) {
		startTime = time;
	}
	
	public void setEndTime(long time) {
		endTime = Calendar.getInstance().getTimeInMillis();
		long seconds = (endTime - startTime) / 1000;
		System.out.println("Total transformation time: " + seconds + " second(s).");
	}
	
	public Map<String, List<String>> getRuleNames() {
		return ruleNames;
	}

	public abstract void writeStatistic();
	
	public abstract void init();

	public abstract void registerOperationCall(String operatioName);
}

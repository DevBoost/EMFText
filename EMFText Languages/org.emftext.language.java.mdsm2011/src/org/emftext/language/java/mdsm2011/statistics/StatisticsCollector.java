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

import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsCollector extends AbstractStatisticsCollector {
	
	private Map<String, Integer> operationCalls = new LinkedHashMap<String, Integer>();

	@Override
	public void writeStatistic() {
		for (String operation : operationCalls.keySet()) {
			System.out.println("Statistics: Operation '" + operation + "' was called/matched(?) " + operationCalls.get(operation) + " times.");
		}
	}

	@Override
	public void init() {
		// not used
	}

	@Override
	public void registerOperationCall(String operationName) {
		if (!operationCalls.containsKey(operationName)) {
			operationCalls.put(operationName, 0);
		}
		int calls = operationCalls.get(operationName);
		operationCalls.put(operationName, calls + 1);
	}
	
	public Map<String, Integer> getOperationCalls() {
		return operationCalls;
	}
}

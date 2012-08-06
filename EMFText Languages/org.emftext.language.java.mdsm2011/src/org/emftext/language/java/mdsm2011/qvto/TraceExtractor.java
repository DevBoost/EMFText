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
package org.emftext.language.java.mdsm2011.qvto;

import org.eclipse.m2m.internal.qvt.oml.trace.EMappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.emftext.language.java.mdsm2011.statistics.AbstractStatisticsCollector;

@SuppressWarnings("restriction")
public class TraceExtractor {


	public void extractOperationCalls(Trace trace, AbstractStatisticsCollector statisticUtil) {
		for (TraceRecord entryData : trace.getTraceRecords()) {
			EMappingOperation mappingOperation = entryData.getMappingOperation();
			String mappingOperationName = mappingOperation.getName();
			
			statisticUtil.registerOperationCall(mappingOperationName);
		}
	}
}

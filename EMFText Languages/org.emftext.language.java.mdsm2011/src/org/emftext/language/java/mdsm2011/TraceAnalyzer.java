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
package org.emftext.language.java.mdsm2011;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TracePackage;
import org.emftext.language.java.mdsm2011.qvto.FileFinder;
import org.emftext.language.java.mdsm2011.qvto.QVTORegisteringUtil;
import org.emftext.language.java.mdsm2011.qvto.TraceExtractor;
import org.emftext.language.java.mdsm2011.statistics.StatisticsCollector;

@SuppressWarnings("restriction")
public class TraceAnalyzer {

	public static void main(String[] args) {

		String traceFolder = "C:\\Projects\\output_qvto_for2foreach\\";

		String[] projects = new String[] {
				"andromda-3.3",
				"apache-ant-1.8.1",
				"apache-commons-math-1.2",
				"apache-tomcat-6.0.18",
				//"eclipse-3.4.1",
				"gwt-1.5.3",
				//"jacks_javac_1.6.0_07_passed",
				"jboss-5.0.0.GA",
				//"jdownloader_0.9579",
				//"jdt_test_files",
				"mantissa-7.2",
				//"netbeans-6.5.1",
				"spring-framework-3.0.0.M1",
				"struts-2.1.6",
				//"sun_jdk_1.5.0_16",
				"Xerces-J-2.9.1"
			};

			TracePackage.eINSTANCE.getTrace();
			for (String projectName : projects) {
				ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				new QVTORegisteringUtil().registerQVTResourceFactory(resourceSetImpl);
				File folder = new File(traceFolder + projectName);
				List<File> traces = new FileFinder().findAllFilesInFolder(folder, new String[] {".qvtotrace"}, new String[0]);
				//System.out.println("Found " + traces.size() + " traces in " + folder.getName());
				StatisticsCollector statisticUtil = new StatisticsCollector();
				for (File traceFile : traces) {
					Resource resource = resourceSetImpl.getResource(URI.createFileURI(traceFile.getAbsolutePath()), true);
					EList<EObject> contents = resource.getContents();
					if (contents.size() == 0) {
						continue;
					}
					EObject root = contents.get(0);
					if (root instanceof Trace) {
						Trace trace = (Trace) root;
						new TraceExtractor().extractOperationCalls(trace, statisticUtil);
					}
				}
				Map<String, Integer> operationCalls = statisticUtil.getOperationCalls();
				System.out.println(projectName + " & " + 
						operationCalls.get("countForLoopReplacements") + " & " +
						operationCalls.get("countForLoops"));
			}
	}
}

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

import org.emftext.language.java.mdsm2011.qvto.FileFinder;

public class BulkEvaluation {

	public static void main(String[] args) {
		MDSM2011Evaluation eva = new MDSM2011Evaluation();
		try {
			String[] projects = new String[] {
				"andromda-3.3",
				"apache-ant-1.8.1",
				"apache-commons-math-1.2",
				"apache-tomcat-6.0.18",
				"eclipse-3.4.1",
				"gwt-1.5.3",
				"jacks_javac_1.6.0_07_passed",
				"jboss-5.0.0.GA",
				"jdownloader_0.9579",
				"jdt_test_files",
				"mantissa-7.2",
				"netbeans-6.5.1",
				"spring-framework-3.0.0.M1",
				"struts-2.1.6",
				"sun_jdk_1.5.0_16",
				"Xerces-J-2.9.1"
			};

			for (String projectName : projects) {
				File file = new File("C:\\Projects\\output_xmi\\" + projectName);
				List<File> files = new FileFinder().findAllFilesInFolder(file, new String[] {".java.xmi"}, new String[0]);
				System.out.println(projectName + "\t" + files.size());
				//eva.run("for2foreach.qvto", "C:\\Projects\\output_xmi", projectName, "java.xmi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		StatisticsCollector statistics = eva.getStatistics();
		Map<String, Integer> operationCalls = statistics.getOperationCalls();
		for (String operation : operationCalls.keySet()) {
			System.out.println("Statistics: Operation '" + operation + "' was called/matched(?) " + operationCalls.get(operation) + " times.");
		}
		*/
	}
}

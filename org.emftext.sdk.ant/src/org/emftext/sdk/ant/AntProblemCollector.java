/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;

/**
 * This class implements a problem collector that sends all
 * collected problems to the console using the log() method
 * in org.apache.tools.ant.Task.
 */
public class AntProblemCollector implements IProblemCollector {
	
	private Task antTask;

	public AntProblemCollector(Task antTask) {
		this.antTask = antTask;
	}

	public void addProblem(GenerationProblem problem) {
		antTask.log("Error while generating text resource: " + problem.getMessage());
	}
}

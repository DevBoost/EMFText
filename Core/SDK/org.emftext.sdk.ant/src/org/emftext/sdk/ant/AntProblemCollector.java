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
package org.emftext.sdk.ant;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.tools.ant.Task;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.IProblemCollector;

/**
 * This class implements a problem collector that sends all
 * collected problems to the console using the log() method
 * in org.apache.tools.ant.Task.
 */
public class AntProblemCollector implements IProblemCollector {
	
	private Task antTask;
	private Collection<GenerationProblem> errors = new ArrayList<GenerationProblem>();

	public AntProblemCollector(Task antTask) {
		this.antTask = antTask;
	}

	public void addProblem(GenerationProblem problem) {
		if (problem.getSeverity() == Severity.ERROR) {
			antTask.log("Error while generating text resource: " + problem.getMessage());
			errors.add(problem);
		} else {
			antTask.log("Warning while generating text resource: " + problem.getMessage());
		}
	}

	public Collection<GenerationProblem> getErrors() {
		return errors;
	}
}

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

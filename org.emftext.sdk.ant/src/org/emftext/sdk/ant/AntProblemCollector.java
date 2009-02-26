package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;

public class AntProblemCollector implements IProblemCollector {
	
	private Task antTask;

	public AntProblemCollector(Task antTask) {
		this.antTask = antTask;
	}

	public void addProblem(GenerationProblem problem) {
		antTask.log("Error while generating text resource: " + problem.getMessage());
	}
}

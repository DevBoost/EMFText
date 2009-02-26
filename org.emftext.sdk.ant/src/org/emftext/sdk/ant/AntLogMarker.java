package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.codegen.generators.IResourceMarker;

public class AntLogMarker implements IResourceMarker {

	private Task antTask;

	public AntLogMarker(Task antTask) {
		this.antTask = antTask;
	}

	public void mark(Resource resource) {
		for (Diagnostic error : resource.getErrors()) {
			antTask.log("Error in resource: \"" + error.getMessage() + "\" (" + error.getLocation() + " at " + error.getLine() + "," + error.getColumn() + ")");
		}
	}

	public void unmark(Resource resource) {
		antTask.log("Removing all markings from " + resource);
	}
}

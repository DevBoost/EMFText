/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.codegen.generators.IResourceMarker;

/**
 * This class delegates calls to the IResourceMarker interface to
 * and ANT task. Errors contained in the resource are logged using
 * the log() method in org.apache.tools.ant.Task.
 */
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
	}
}

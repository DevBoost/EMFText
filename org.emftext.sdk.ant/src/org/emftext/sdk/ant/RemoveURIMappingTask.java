/*******************************************************************************
 * Copyright (c) 2006-2011
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

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * A custom ANT task that allows to register a URI mapping in
 * EMF's global URI map.
 */
public class RemoveURIMappingTask extends Task {
	
	private String from;

	@Override
	public void execute() throws BuildException {
		if (getFrom() == null) {
			throw new BuildException("from is not set.");
		}
		
		URI fromURI = URI.createURI(from);
		
		log("removing mapping from " + from + " to " + URIConverter.URI_MAP.get(fromURI));
		
		URIConverter.URI_MAP.remove(fromURI);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}



}

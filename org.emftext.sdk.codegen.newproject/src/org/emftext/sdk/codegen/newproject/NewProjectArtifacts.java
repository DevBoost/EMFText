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
package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;

/**
 * This class contains constants for all artifacts that are created while
 * generating a new EMFText project.
 */
public class NewProjectArtifacts {
	
	public final static ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters<NewProjectGenerationContext>> DOT_CLASSPATH = new ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters<NewProjectGenerationContext>>(null, "", "", null, null);
	public final static ArtifactDescriptor<NewProjectGenerationContext, DotProjectParameters<NewProjectGenerationContext>> DOT_PROJECT = new ArtifactDescriptor<NewProjectGenerationContext, DotProjectParameters<NewProjectGenerationContext>>(null, "", "", null, null);
}

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
package org.emftext.sdk.codegen;

/**
 * An IArtifactCreator uses one or more IGenerators and
 * creates IArtifact objects from their output. Depending
 * on the value of code generation options the artifacts 
 * may be created, overridden or left alone.
 */
public interface IArtifactCreator {
	
	/**
	 * Returns the name of the artifact(s) that is
	 * created by this creator.
	 * 
	 * @return the artifacts name
	 */
	public String getArtifactDescription();
	
	/**
	 * Creates one or more artifacts.
	 * 
	 * @param context
	 */
	public void createArtifacts(GenerationContext context);
}

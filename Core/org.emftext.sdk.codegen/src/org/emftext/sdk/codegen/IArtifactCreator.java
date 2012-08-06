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
package org.emftext.sdk.codegen;

import org.emftext.sdk.IPluginDescriptor;

/**
 * An IArtifactCreator uses one or more IGenerators and
 * creates IArtifact objects from their output. Depending
 * on the value of code generation options the artifacts 
 * may be created, overridden or left alone.
 * 
 * In contrast to a generator, which produces simply an 
 * array of bytes in memory, a creator is responsible for
 * storing created artifacts to disc.
 */
public interface IArtifactCreator<ContextType> {
	
	/**
	 * Returns the name of the type of artifact(s) that are
	 * created by this creator.
	 * 
	 * @return the artifacts name
	 */
	public String getArtifactTypeDescription();
	
	/**
	 * Creates one or more artifacts.
	 * 
	 * @param context
	 */
	public void createArtifacts(IPluginDescriptor plugin, ContextType context);
}

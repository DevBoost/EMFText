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

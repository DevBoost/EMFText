/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;

/**
 * An experimental (not yet implemented) generator that must call the 
 * SGLR compiler framework to create a parser from an SDF grammar.
 */
//TODO sheyden: implement this creator
public class SGLRParserCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
	}

	public String getArtifactDescription() {
		return null;
	}
}

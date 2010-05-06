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
package org.emftext.sdk.codegen;

import java.io.OutputStream;
import java.util.Collection;

/**
 * A basic generator interface which should be implemented by all generators 
 * in org.emftext.sdk.codegen.generators. Generators can create content for
 * arbitrary artifacts (e.g., Java classes). They do not care about whether 
 * this content is eventually put into a file or somewhere else.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface IGenerator<GeneraionContextType> {
	
	public boolean generate(OutputStream out);
	
	public Collection<GenerationProblem> getCollectedProblems();
	public Collection<GenerationProblem> getCollectedErrors();

	public IGenerator<GeneraionContextType> newInstance(GeneraionContextType context);
}

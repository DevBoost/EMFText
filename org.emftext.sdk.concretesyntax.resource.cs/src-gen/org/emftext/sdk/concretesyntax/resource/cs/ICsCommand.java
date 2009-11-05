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
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface ICsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}

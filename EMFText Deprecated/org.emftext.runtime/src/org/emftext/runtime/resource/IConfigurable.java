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
package org.emftext.runtime.resource;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a
 * map of options (or parameters).
 */
public interface IConfigurable {
	
	/**
	 * Passed the options given by the map to the configurable
	 * objects. 
	 */
	public void setOptions(Map<?,?> options);
}

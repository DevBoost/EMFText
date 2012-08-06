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
package org.emftext.access.resource;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a
 * map of options (or parameters).
 */
public interface IConfigurable {
	
	/**
	 * Passed the options given by the map to the configurable
	 * object. 
	 */
	public void setOptions(Map<?,?> options);
}

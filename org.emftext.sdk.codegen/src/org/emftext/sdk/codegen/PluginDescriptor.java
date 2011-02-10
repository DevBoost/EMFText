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
package org.emftext.sdk.codegen;

import org.emftext.sdk.IPluginDescriptor;

public class PluginDescriptor implements IPluginDescriptor {

	private String name;
	
	public PluginDescriptor(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

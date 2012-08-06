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
package org.emftext.language.ecore.resource;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class does not extend or change the functionality of 
 * <code>org.eclipse.emf.ecore.impl.EcoreFactoryImpl</code>.
 * It is used in the 
 * <code>org.eclipse.emf.ecore.factory_override</code>
 * extension point to be instantiated when the ecore model
 * processing machinery starts. It then replaces the
 * <code>org.emftext.language.ecore.resource.EcoreResourceFactoryImpl</code>
 * with the delegating factory
 * <code>EcoreResourceFactoryDegator</code>
 * to support multiple Ecore formats that are specified though hierarchical 
 * file names (e.g., ".tecore.ecore").
 * 
 *
 */
public class EcoreFactoryImpl extends
		org.eclipse.emf.ecore.impl.EcoreFactoryImpl {

	public EcoreFactoryImpl() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryDelegator());
	}
}

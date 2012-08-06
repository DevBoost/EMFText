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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// A basic implementation of the IElementMapping interface.
//
// @param <ReferenceType> the type of the reference that can be mapped to
//
public class GeneratorconfigElementMapping<ReferenceType> implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigElementMapping<ReferenceType> {

	private final ReferenceType target;
	private String identifier;
	private String warning;

	public GeneratorconfigElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}

	public ReferenceType getTargetElement() {
		return target;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getWarning() {
		return warning;
	}
}

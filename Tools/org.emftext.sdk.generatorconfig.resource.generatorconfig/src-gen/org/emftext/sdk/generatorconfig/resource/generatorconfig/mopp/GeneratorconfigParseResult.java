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

public class GeneratorconfigParseResult implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult {

	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>> commands = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>>();

	public GeneratorconfigParseResult() {
		super();
	}

	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}

	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>> getPostParseCommands() {
		return commands;
	}

}

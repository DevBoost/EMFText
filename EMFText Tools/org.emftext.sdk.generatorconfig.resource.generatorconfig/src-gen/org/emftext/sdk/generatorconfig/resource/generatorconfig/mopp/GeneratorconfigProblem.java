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

public class GeneratorconfigProblem implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem {

	private java.lang.String message;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType type;

	public GeneratorconfigProblem(java.lang.String message, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType getType() {
		return type;
	}

	public java.lang.String getMessage() {
		return message;
	}

}

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
package org.emftext.sdk.ant;

import java.lang.reflect.Field;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.EPackage;

public class RegisterEPackageTask extends Task {

	private String namespaceURI;
	private String packageClass;

	@Override
	public void execute() throws BuildException {

		try {
			Field factoryInstance = Class.forName(packageClass).getField("eINSTANCE");
			Object ePackageObject = factoryInstance.get(null);
			EPackage.Registry.INSTANCE.put(namespaceURI, ePackageObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException(e.getMessage());
		}
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public String getPackageClass() {
		return packageClass;
	}

	public void setPackageClass(String packageClass) {
		this.packageClass = packageClass;
	}
}

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

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.BuildException;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Ant task to register a resource factory for a file extension.
 */
public class RegisterResourceFactoryTask extends AbstractEMFTextAntTask {
	
	private String className;
	private String type;
	
	@Override
	public void execute() throws BuildException {
		if (getClassName() == null) {
			throw new BuildException("className is not set.");
		}
		if (getType() == null) {
			throw new BuildException("type is not set.");
		}
		
		AntClassLoader taskloader = setClassLoader();
		
		Resource.Factory newResourceFactory = instantiateFactory(className);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				getType(), newResourceFactory);
		
		resetClassLoader(taskloader); 
	}

	private Resource.Factory instantiateFactory(String resourceFactoryClassName) {
		try {
			Class<?> factoryClass = Class.forName(resourceFactoryClassName);
			Resource.Factory factory = (Resource.Factory) factoryClass.newInstance();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException("Error while creating resource factory " + resourceFactoryClassName, e);
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

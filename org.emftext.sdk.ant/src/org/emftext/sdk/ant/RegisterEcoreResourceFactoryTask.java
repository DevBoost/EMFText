/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ant;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A custom ANT task that loads a model using
 * a given resource factory and save it under
 * another URI using a different resource factory
 */
public class RegisterEcoreResourceFactoryTask extends Task {
	
	private String className;
	private String type;

	private Resource.Factory ecoreFactoryDelagator = null;
	
	@Override
	public void execute() throws BuildException {
		if (getClassName() == null) {
			throw new BuildException("className is not set.");
		}
		if (getType() == null) {
			throw new BuildException("type is not set.");
		}
		
		// Get the task class loader we used to load this tag.
		AntClassLoader taskloader = 
			(AntClassLoader)this.getClass().getClassLoader();
		// Shove it into the Thread, replacing the thread's ClassLoader:
		taskloader.setThreadContextLoader();
		
		Resource.Factory newEcoreFactory = instantiateFactory(className);
		String ecoreEcoreResourceFactoryDelegatorClassName = 
			"org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator";
	
		if (ecoreFactoryDelagator == null) {
			ecoreFactoryDelagator = (Resource.Factory) instantiateFactory(ecoreEcoreResourceFactoryDelegatorClassName);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore",
					ecoreFactoryDelagator);
		}

		try {
			Class<?> factoryClass = Class.forName(ecoreEcoreResourceFactoryDelegatorClassName);
			Method m = factoryClass.getMethod("getEcoreResourceFactoriesMap");
			Map ecoreFactoriesMap = (Map) m.invoke(ecoreFactoryDelagator, null);
			if (!ecoreFactoriesMap.containsKey(getType())) {
				ecoreFactoriesMap.put(getType(), newEcoreFactory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			 // Reset the Thread's original ClassLoader.
			taskloader.resetThreadContextLoader(); 
			throw new BuildException(e);
		}
		 // Reset the Thread's original ClassLoader.
		taskloader.resetThreadContextLoader(); 
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

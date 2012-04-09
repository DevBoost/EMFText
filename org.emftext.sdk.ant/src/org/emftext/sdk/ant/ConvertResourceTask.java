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

import java.util.Collections;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A custom ANT task that loads a model using
 * a given resource factory and save it under
 * another URI using a different resource factory
 */
public class ConvertResourceTask extends Task {
	
	private String loadURI;
	private String saveURI;
	
	private String loadResourceFactory;
	private String saveResourceFactory;;

	@Override
	public void execute() throws BuildException {
		if (getLoadURI() == null) {
			throw new BuildException("loadURI is not set.");
		}
		if (getSaveURI() == null) {
			throw new BuildException("saveURI is not set.");
		}
		if (getLoadResourceFactory() == null) {
			throw new BuildException("loadResourceFactory is not set.");
		}
		if (getSaveResourceFactory() == null) {
			throw new BuildException("saveResourceFactory is not set.");
		}
		
		Resource.Factory loadFactory = instantiateFactory(loadResourceFactory);
		Resource.Factory saveFactory = instantiateFactory(saveResourceFactory);
		
		Resource loadResource = loadFactory.createResource(URI.createURI(loadURI));
		Resource saveResource = saveFactory.createResource(URI.createURI(saveURI));
		
		//TODO if required the task might also support load/save options in the future
		try {
			log("loading " + loadURI);
			loadResource.load(Collections.EMPTY_MAP);
		} catch (Exception e) {
			e.printStackTrace();
			log("Error while loading " + loadURI);
			throw new BuildException("Error while loading " + loadURI, e);
		}
		
		saveResource.getContents().addAll(loadResource.getContents());
		
		try {
			log("saving " + saveURI);
			saveResource.save(Collections.EMPTY_MAP);
		} catch (Exception e) {
			e.printStackTrace();
			log("Error while loading " + loadURI);
			throw new BuildException("Error while saving " + saveURI, e);
		}
		
	}

	
	private Resource.Factory instantiateFactory(String resourceFactoryClassName) {
		try {
			Class<?> factoryInstance = Class.forName(resourceFactoryClassName);
			Resource.Factory factory = (Resource.Factory) factoryInstance.newInstance();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException("Error while creating resource factory " + resourceFactoryClassName, e);
		}
	}


	public String getLoadURI() {
		return loadURI;
	}

	public void setLoadURI(String loadURI) {
		this.loadURI = loadURI;
	}

	public String getSaveURI() {
		return saveURI;
	}

	public void setSaveURI(String saveURI) {
		this.saveURI = saveURI;
	}

	public String getLoadResourceFactory() {
		return loadResourceFactory;
	}

	public void setLoadResourceFactory(String loadResourceFactory) {
		this.loadResourceFactory = loadResourceFactory;
	}

	public String getSaveResourceFactory() {
		return saveResourceFactory;
	}

	public void setSaveResourceFactory(String saveResourceFactory) {
		this.saveResourceFactory = saveResourceFactory;
	}




}

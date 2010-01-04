/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.ant;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.codegen.creators.PluginsCreator.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsTextResourceUtil;

/**
 * A custom task for the ANT build tool that generates
 * a resource plug-in for a given syntax specification.
 * 
 * TODO there should be a build exception when the syntax
 * contains errors (e.g., issued by ANTLR)
 */
public class GenerateTextResourceTask extends Task {

	private File rootFolder;
	private File syntaxFile;
	private String syntaxProjectName;

	private List<GenModelElement> genModels = new ArrayList<GenModelElement>();
	private List<GenPackageElement> genPackages = new ArrayList<GenPackageElement>();
	private SyntaxProcessor preprocessor;
	
	@Override
	public void execute() throws BuildException {
		checkParameters();
		
		// Get the task class loader we used to load this tag.
		AntClassLoader taskloader = null;
		ClassLoader loader = this.getClass().getClassLoader();
		if (loader instanceof AntClassLoader) {
			taskloader = (AntClassLoader) loader;
		}
		// Shove it into the Thread, replacing the thread's ClassLoader:
		if (taskloader != null) {
			taskloader.setThreadContextLoader();
		}

		registerResourceFactories();
		try {
			log("loading syntax file...");
			ICsTextResource csResource = CsTextResourceUtil.getResource(syntaxFile, new SDKOptionProvider().getOptions());
			EList<EObject> contents = csResource.getContents();
			if (contents.size() < 1) {
				throw new BuildException("Generation failed, because the syntax file could not be loaded. Probably it contains syntactical errors.");
			}
			ConcreteSyntax syntax = (ConcreteSyntax) contents.get(0);
			performPreprocessing(syntax);
			
			Result result = new AntResourcePluginGenerator().run(
					syntax, 
					new AntGenerationContext(syntax, rootFolder, syntaxProjectName, new AntProblemCollector(this)), 
					new AntLogMarker(this), 
					new AntDelegateProgressMonitor(this)
			);
			if (result != Result.SUCCESS) {
				if (result == Result.ERROR_FOUND_UNRESOLVED_PROXIES) {
					for (EObject unresolvedProxy : result.getUnresolvedProxies()) {
						log("Found unresolved proxy \"" + ((InternalEObject) unresolvedProxy).eProxyURI() + "\" in " + unresolvedProxy.eResource());
					}
					 // Reset the Thread's original ClassLoader.
					if (taskloader != null) {
						taskloader.resetThreadContextLoader();
					}
					throw new BuildException("Generation failed " + result);
				} else {
					 // Reset the Thread's original ClassLoader.
					if (taskloader != null) {
						taskloader.resetThreadContextLoader();
					}
					throw new BuildException("Generation failed " + result);
				}
			}
		} catch (Exception e) {
			 // Reset the Thread's original ClassLoader.
			if (taskloader != null) {
				taskloader.resetThreadContextLoader();
			}
			e.printStackTrace();
			throw new BuildException(e);
		}
		// Reset the Thread's original ClassLoader.
		if (taskloader != null) {
			taskloader.resetThreadContextLoader();
		}
	}
	
	private void performPreprocessing(ConcreteSyntax syntax) {
		if (preprocessor == null) {
			return;
		}
		preprocessor.process(syntax);
	}
	
	public void setPreprocessor(SyntaxProcessor preprocessor) {
		this.preprocessor = preprocessor;
	}

	private void checkParameters() {
		if (syntaxFile == null) {
			throw new BuildException("Parameter \"syntax\" is missing.");
		}
		if (rootFolder == null) {
			throw new BuildException("Parameter \"rootFolder\" is missing.");
		}
		if (syntaxProjectName == null) {
			throw new BuildException("Parameter \"syntaxProjectName\" is missing.");
		}
	}
	


	public void setSyntax(File syntaxFile) {
		this.syntaxFile = syntaxFile;
	}

	public void setRootFolder(File rootFolder) {
		this.rootFolder = rootFolder;
	}
	
	public void setSyntaxProjectName(String syntaxProjectName) {
		this.syntaxProjectName = syntaxProjectName;
	}
	
	public void addGenModel(GenModelElement factory) {
		genModels.add(factory);
	}

	public void addGenPackage(GenPackageElement factory) {
		genPackages.add(factory);
	}

	public void registerResourceFactories() {
		//in case a old version from last run is registered here
		EPackage.Registry.INSTANCE.remove("http://www.emftext.org/sdk/concretesyntax");
		registerFactory("cs", new CsResourceFactory());
		
		//TODO: the rest of this method is never used in our build scripts at the moment
		for (GenModelElement genModelElement : genModels) {
			String namespaceURI = genModelElement.getNamespaceURI();
			String genModelURI = genModelElement.getGenModelURI();
			try {
				log("registering genmodel " + namespaceURI + " at " + genModelURI);
				EcorePlugin.getEPackageNsURIToGenModelLocationMap().put(
						namespaceURI,
						URI.createURI(genModelURI)
				);
				
				//register a mapping for "resource:/plugin/..." URIs in case 
				//one genmodel imports another genmodel using this URI
				String filesSystemURI = genModelURI;
				int startIdx = filesSystemURI.indexOf("/plugins");
				int versionStartIdx = filesSystemURI.indexOf("_",startIdx);
				int filePathStartIdx = filesSystemURI.lastIndexOf("!/") + 1;
				if(startIdx > -1 && versionStartIdx > startIdx && filePathStartIdx > versionStartIdx) {
					String platformPluginURI = "platform:"  + filesSystemURI.substring(startIdx, versionStartIdx);
					platformPluginURI = platformPluginURI + filesSystemURI.substring(filePathStartIdx);
					platformPluginURI = platformPluginURI.replace("/plugins/", "/plugin/");
					
					//gen model
					log("adding mapping from " + platformPluginURI + " to " + filesSystemURI);
					URIConverter.URI_MAP.put(
							URI.createURI(platformPluginURI),
							URI.createURI(filesSystemURI));
					
					//ecore model (this code assumes that both files are named equally)
					filesSystemURI = filesSystemURI.replace(".genmodel", ".ecore");
					platformPluginURI = platformPluginURI.replace(".genmodel", ".ecore");
					log("adding mapping from " + platformPluginURI + " to " + filesSystemURI);
					URIConverter.URI_MAP.put(
							URI.createURI(platformPluginURI),
							URI.createURI(filesSystemURI));
				}
			} catch (Exception e) {
				throw new BuildException("Error while registering genmodel " + namespaceURI, e);
			}
		}

		for (GenPackageElement genPackage : genPackages) {
			String namespaceURI = genPackage.getNamespaceURI();
			String ePackageClassName = genPackage.getEPackageClassName();
			try {
				log("registering ePackage " + namespaceURI + " at " + ePackageClassName);
				Field factoryInstance = Class.forName(ePackageClassName).getField("eINSTANCE");
				Object ePackageObject = factoryInstance.get(null);
				EPackage.Registry.INSTANCE.put(namespaceURI, ePackageObject);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BuildException("Error while registering EPackage " + namespaceURI, e);
			}
		}
	}

	private void registerFactory(String extension, Object factory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove(extension);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				extension,
				factory);
	}
}

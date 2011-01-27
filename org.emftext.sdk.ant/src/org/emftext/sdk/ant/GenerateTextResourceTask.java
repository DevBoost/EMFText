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
import java.util.Set;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.BuildException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.resource.ui.CreateResourcePluginsJob.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsTextResourceUtil;

/**
 * A custom task for the ANT build tool that generates
 * a resource plug-in for a given syntax specification.
 * 
 * TODO there should be a build exception when the syntax
 * contains errors (e.g., issued by ANTLR)
 */
public class GenerateTextResourceTask extends AbstractEMFTextAntTask {

	private File rootFolder;
	private File syntaxFile;
	private String syntaxProjectName;

	private List<GenModelElement> genModels = new ArrayList<GenModelElement>();
	private List<GenPackageElement> genPackages = new ArrayList<GenPackageElement>();
	private SyntaxProcessor preprocessor;
	private boolean generateANTLRPlugin;
	private boolean generateModelCode = true;
	
	@Override
	public void execute() throws BuildException {
		checkParameters();
		
		AntClassLoader taskloader = setClassLoader();

		registerResourceFactories();
		try {
			log("loading syntax file...");
			ICsTextResource csResource = CsTextResourceUtil.getResource(syntaxFile, new SDKOptionProvider().getOptions());
			EList<EObject> contents = csResource.getContents();
			if (contents.size() < 1) {
				if (!csResource.getErrors().isEmpty()) {
					log("Resource has the following errors:");
					for (Resource.Diagnostic diagnostic : csResource.getErrors()) {
						log(diagnostic.getMessage() + " (line " + diagnostic.getLine() + ", column " + diagnostic.getColumn() + ")");
					}
				}
				throw new BuildException("Generation failed, because the syntax file could not be loaded. Probably it contains syntactical errors.");
			}
			ResourceSet resourceSet = csResource.getResourceSet();
			EcoreUtil.resolveAll(resourceSet);
			Set<EObject> unresolvedProxies = CsResourceUtil.findUnresolvedProxies(resourceSet);
			for (EObject unresolvedProxy : unresolvedProxies) {
				log("Found unresolved proxy: " + unresolvedProxy);
			}
			if (unresolvedProxies.size() > 0) {
				throw new BuildException("Generation failed, because the syntax file contains unresolved proxy objects.");
			}
			ConcreteSyntax syntax = (ConcreteSyntax) contents.get(0);
			performPreprocessing(syntax);
			
			AntResourcePluginGenerator generator = new AntResourcePluginGenerator();
			IFileSystemConnector folderConnector = new IFileSystemConnector() {
				
				public File getProjectFolder(IPluginDescriptor plugin) {
					return new File(rootFolder.getAbsolutePath() + File.separator + plugin.getName());
				}
			};
			
			AntGenerationContext context = new AntGenerationContext(folderConnector, new AntProblemCollector(this), syntax, rootFolder, syntaxProjectName, generateANTLRPlugin, generateModelCode);
			Result result = generator.run(
					context, 
					new AntLogMarker(this), 
					new AntDelegateProgressMonitor(this)
			);
			if (result != Result.SUCCESS) {
				if (result == Result.ERROR_FOUND_UNRESOLVED_PROXIES) {
					for (EObject unresolvedProxy : result.getUnresolvedProxies()) {
						log("Found unresolved proxy \"" + ((InternalEObject) unresolvedProxy).eProxyURI() + "\" in " + unresolvedProxy.eResource());
					}
					resetClassLoader(taskloader);
					throw new BuildException("Generation failed " + result);
				} else {
					resetClassLoader(taskloader);
					throw new BuildException("Generation failed " + result);
				}
			}
		} catch (Exception e) {
			resetClassLoader(taskloader);
			e.printStackTrace();
			throw new BuildException(e);
		}
		resetClassLoader(taskloader);
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
	
	public void setGenerateANTLRPlugin(boolean generateANTLRPlugin) {
		this.generateANTLRPlugin = generateANTLRPlugin;
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
	
	public void setGenerateModelCode(boolean generateModelCode) {
		this.generateModelCode = generateModelCode;
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

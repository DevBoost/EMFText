package org.emftext.sdk.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A custom task for the ANT build tool that generates
 * a resource plug-in for a given syntax specification. 
 */
public class GenerateTextResourceTask extends Task {

	private final static TextResourceHelper resourceHelper = new TextResourceHelper();

	private File rootFolder;
	private File syntaxFile;
	private String syntaxProjectName;

	@Override
	public void execute() throws BuildException {
		checkParameters();
		registerResourceFactories();
		try {
			log("Loading syntax file");
			final ITextResource csResource = resourceHelper.getResource(syntaxFile);
			ConcreteSyntax syntax = (ConcreteSyntax) csResource.getContents().get(0);
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
					throw new BuildException("Generation failed " + result);
				} else {
					throw new BuildException("Generation failed " + result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException(e);
		}
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

	public void registerResourceFactories() {
		org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory csResourceFactoryImpl = new org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cs",
				csResourceFactoryImpl);
	}
}

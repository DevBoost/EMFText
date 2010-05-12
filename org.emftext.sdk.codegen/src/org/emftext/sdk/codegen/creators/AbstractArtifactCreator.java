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
package org.emftext.sdk.codegen.creators;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.util.StreamUtil;

/**
 * An abstract superclass for all creators. It that handles overriding
 * of existing artifacts.
 */
public abstract class AbstractArtifactCreator<ContextType extends IContext, ParameterType> extends AbstractGenerationComponent implements IArtifactCreator<ContextType> {
	
	private String artifactName;
	protected ParameterType parameters;

	public AbstractArtifactCreator(String artifactName, ParameterType parameters) {
		super();
		this.artifactName = artifactName;
		this.parameters = parameters;
	}

	public String getArtifactDescription() {
		return artifactName;
	}

	public void createArtifacts(IPluginDescriptor plugin, ContextType context) {
		setFileSystemConnector(context.getFileSystemConnector());
		boolean doOverride = doOverride(context);
		
		Collection<IArtifact> artifacts = getArtifactsToCreate(plugin, context, parameters);
		for (IArtifact artifact : artifacts) {
			File targetFile = artifact.getTargetFile();
			boolean exists = targetFile.exists();
			boolean doSave = !exists || doOverride;
		    if (doSave) {
		    	try {
					boolean changed = StreamUtil.storeContentIfChanged(targetFile, artifact.getContentStream());
					if (changed) {
						notifyArtifactChanged(context);
					}
				} catch (IOException e) {
					getProblemCollector().addProblem(new GenerationProblem("Exception while generating artifact.", null, GenerationProblem.Severity.ERROR, e));
				}
		    }
		}
	}

	/**
	 * Does nothing. Subclasses may override this method to react to changes made
	 * to artifacts during code generation.
	 * 
	 * @param context
	 */
	public void notifyArtifactChanged(ContextType context) {
		// do nothing
	}

	protected Collection<IArtifact> createArtifact(ContextType context,
			IGenerator<ContextType, ParameterType> generator, File targetFile, String errorMessage) {

		InputStream stream = invokeGeneration(generator, getProblemCollector());
	    if (stream == null) {
			getProblemCollector().addProblem(new GenerationProblem(errorMessage, null, GenerationProblem.Severity.ERROR, null));
	    	return new ArrayList<IArtifact>();
	    }
	    Artifact artifact = new Artifact(targetFile, stream);
	    return toList(artifact);
	}

	private InputStream invokeGeneration(IGenerator<ContextType, ParameterType> generator, IProblemCollector collector) {
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       try {
    	   if (generator.generate(stream)) {
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }
		} catch (Exception e) {
			// we do not need to propagate the exception, because in the
			// case if an exception this method returns null. This is then
			// handled in createArtifact() by adding a generation problem
			// to the problem collector
			EMFTextSDKPlugin.logError("Exception while invoking code generator.", e);
		} finally {
			Collection<GenerationProblem> collectedProblems = generator.getCollectedProblems();
			if (collectedProblems != null) {
				for (GenerationProblem problem : collectedProblems) {
					collector.addProblem(problem);
				}
			}
		}
		return null;
	}

	protected Collection<IArtifact> toList(Artifact artifact) {
		Collection<IArtifact> list = new ArrayList<IArtifact>(1);
		list.add(artifact);
		return list;
	}

	/**
	 * Subclasses must override this method to signal whether the artifact must
	 * be overridden or not.
	 * 
	 * @param context
	 * @return
	 */
	public abstract boolean doOverride(ContextType context);

	/**
	 * Subclasses must override this method and return all artifact that need to
	 * be created.
	 * 
	 * @param plugin
	 * @param context
	 * @param parameter
	 * @return a collection of artifacts which will be created
	 */
	public abstract Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, ParameterType parameter);
}

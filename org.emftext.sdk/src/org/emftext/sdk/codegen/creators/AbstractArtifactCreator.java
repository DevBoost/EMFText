package org.emftext.sdk.codegen.creators;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class AbstractArtifactCreator implements IArtifactCreator {
	
	private String artifactName;

	public AbstractArtifactCreator(String artifactName) {
		super();
		this.artifactName = artifactName;
	}
	
	public String getArtifactDescription() {
		return artifactName;
	}

	public void createArtifacts(GenerationContext context) {
		OptionTypes overrideOption = getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
		
		Collection<IArtifact> artifacts = getArtifactsToCreate(context);
		for (IArtifact artifact : artifacts) {
			File targetFile = artifact.getTargetFile();
			boolean exists = targetFile.exists();
			boolean doSave = !exists || doOverride;
		    if (doSave) {
		    	try {
					setContents(targetFile, artifact.getContentStream());
				} catch (IOException e) {
					context.getProblemCollector().addProblem(new GenerationProblem("Exception while generating artifact.", null, GenerationProblem.Severity.ERROR, e));
				}
		    }
		}
	}

	public abstract Collection<IArtifact> getArtifactsToCreate(GenerationContext context);

	/**
	 * Returns the option that enables/disables this
	 * creator. If the option is set to true the creator
	 * should create or override the artifact. Otherwise
	 * the artifact should be created only in case it does
	 * not exist yet.
	 * 
	 * @return the option to enabled this creator
	 */
	public abstract OptionTypes getOverrideOption();

	protected InputStream invokeGeneration(IGenerator generator, IProblemCollector collector) {
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
	   PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
       try {
    	   if (generator.generate(out)) {
    		   out.flush();
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }
		} catch (Exception e) {
			EMFTextRuntimePlugin.logError("Exception while invoking code generator.", e);
		} finally {
			out.close();
			Collection<GenerationProblem> collectedProblems = generator.getCollectedProblems();
			if (collectedProblems != null) {
				for (GenerationProblem problem : collectedProblems) {
					collector.addProblem(problem);
				}
			}
		}
		return null;
	}

	private void setContents(File target, InputStream in) throws IOException {
		target.getParentFile().mkdirs();
		FileOutputStream fos = new FileOutputStream(target);
		int next = -1;
		while ((next = in.read()) >= 0) {
			fos.write(next);
		}
		fos.close();
	}

	protected Collection<IArtifact> toList(Artifact artifact) {
		Collection<IArtifact> list = new ArrayList<IArtifact>(1);
		list.add(artifact);
		return list;
	}
}

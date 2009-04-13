package org.emftext.sdk.codegen;

/**
 * An IArtifactCreator uses one or more IGenerators and
 * creates IArtifact objects from their output. Depending
 * on the value of code generation options the artifacts 
 * may be created, overridden or left alone.
 */
public interface IArtifactCreator {
	
	/**
	 * Returns the name of the artifact(s) that is
	 * created by this creator.
	 * 
	 * @return the artifacts name
	 */
	public String getArtifactDescription();
	
	/**
	 * Creates one or more artifacts.
	 * 
	 * @param context
	 */
	public void createArtifacts(GenerationContext context);
}

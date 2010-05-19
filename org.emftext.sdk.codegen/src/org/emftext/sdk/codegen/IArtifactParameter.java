package org.emftext.sdk.codegen;

/**
 * An interface for all parameter classes that provide information about the
 * artifact to be generated.
 *
 * @param <ContextType>
 * @param <ParameterType>
 */
public interface IArtifactParameter<ContextType, ParameterType> {

	public ArtifactDescriptor<ContextType, ParameterType> getArtifact();
}

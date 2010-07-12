package org.emftext.sdk.codegen.parameters;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

/**
 * A simple generic parameter class that holds both an artifact descriptor and
 * a single parameter of arbitrary type.
 *
 * @param <ParameterType>
 */
public class SimpleParameter<ContextType extends IContext<ContextType>, ParameterType> extends AbstractArtifactParameter<ContextType, SimpleParameter<ContextType, ParameterType>> {

	private ParameterType parameter;

	public SimpleParameter(ArtifactDescriptor<ContextType, SimpleParameter<ContextType, ParameterType>> artifact, ParameterType parameter) {
		super(artifact);
		this.parameter = parameter;
	}

	public ParameterType getParameter() {
		return parameter;
	}
}

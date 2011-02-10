/*******************************************************************************
 * Copyright (c) 2006-2011
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

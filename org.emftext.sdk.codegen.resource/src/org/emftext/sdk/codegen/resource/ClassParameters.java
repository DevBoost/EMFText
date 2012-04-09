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
package org.emftext.sdk.codegen.resource;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.resource.generators.EmptyClassGenerator;

public class ClassParameters implements IArtifactParameter<GenerationContext, ClassParameters> {

	private String className;
	private ArtifactDescriptor<GenerationContext, ?> targetPackage;
	
	public ClassParameters(
			String className,
			ArtifactDescriptor<GenerationContext, ?> targetPackage) {
		super();
		this.className = className;
		this.targetPackage = targetPackage;
	}

	public String getClassName() {
		return className;
	}

	public ArtifactDescriptor<GenerationContext, ?> getTargetPackage() {
		return targetPackage;
	}

	public ArtifactDescriptor<GenerationContext, ClassParameters> getArtifact() {
		return new ArtifactDescriptor<GenerationContext, ClassParameters>(null, "empty", "", EmptyClassGenerator.class, null);
	}
}

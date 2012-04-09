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
package org.emftext.sdk.codegen.resource.creators;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IPluginCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An abstract superclass for creator that produce Eclipse plug-ins.
 * It takes care of tracking the creation progress.
 *
 * @param <ParameterType>
 */
public abstract class AbstractPluginCreator<ParameterType> implements IPluginCreator<GenerationContext, ParameterType> {

	public void create(IPluginDescriptor plugin, GenerationContext context, ParameterType parameters, IProgressMonitor monitor) throws IOException {
		SubMonitor progress = SubMonitor.convert(monitor, "generating " + getPluginName() + " plug-in...", 100);
	    
		ConcreteSyntax syntax = context.getConcreteSyntax();
		Resource csResource = syntax.eResource();
		EcoreUtil.resolveAll(csResource);
	    
	    List<IArtifactCreator<GenerationContext>> creators = getCreators(context);
	    // TODO implement extension mechanism to allow code generator plug-ins
	    // to add more creators
	
	    for (IArtifactCreator<GenerationContext> creator : creators) {
			String description = creator.getArtifactTypeDescription();
			progress.setTaskName("creating " + description + "...");
			creator.createArtifacts(plugin, context);
		    progress.worked(100 / creators.size());
	    }
	}

	public abstract String getPluginName();

	public abstract List<IArtifactCreator<GenerationContext>> getCreators(GenerationContext context);
}

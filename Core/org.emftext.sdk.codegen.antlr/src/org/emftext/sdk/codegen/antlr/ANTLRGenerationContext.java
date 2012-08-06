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
package org.emftext.sdk.codegen.antlr;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.ISyntaxContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class is passed along the creators and generators of the ANTLR commons
 * plug-in. It carries a concrete syntax object, which is used to determine the
 * value of override options.
 */
public class ANTLRGenerationContext extends AbstractGenerationContext<ANTLRGenerationContext> implements ISyntaxContext {

	private ConcreteSyntax concreteSyntax;
	private IPluginDescriptor antlrPlugin;

	public ANTLRGenerationContext(IFileSystemConnector fileSystemConnector, IProblemCollector problemCollector, ConcreteSyntax concreteSyntax, IPluginDescriptor antlrPlugin) {
		super(fileSystemConnector, problemCollector);
		this.concreteSyntax = concreteSyntax;
		this.antlrPlugin = antlrPlugin;
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<ANTLRGenerationContext, ?> artifact) {
		throw new UnsupportedOperationException();
	}

	public File getProjectFolder(IPluginDescriptor plugin) {
		return getFileSystemConnector().getProjectFolder(plugin);
	}

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}

	public IPluginDescriptor getAntlrPlugin() {
		return antlrPlugin;
	}
}

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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the content for .classpath files, which are used by Eclipse to determine the
 * classes used by generated text resource plug-ins.
 */
public class DotClasspathGenerator extends BaseGenerator {

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private EPlugins plugin;

	public DotClasspathGenerator(GenerationContext context, EPlugins plugin) {
		super(context, EArtifact.DOT_CLASSPATH);
		this.plugin = plugin;
	}

	@Override
	public boolean generate(PrintWriter out) {
		String sourceFolderName = csUtil.getSourceFolderName(getContext().getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(getContext().getConcreteSyntax(), OptionTypes.SOURCE_GEN_FOLDER);
		
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<classpath>");
		sc.add("<classpathentry kind=\"src\" path=\"" + sourceFolderName + "\"/>");
		// only the resource plug-in has a 'src-gen' folder
		if (plugin == EPlugins.RESOURCE_PLUGIN) {
			sc.add("<classpathentry kind=\"src\" path=\"" + sourceGenFolderName + "\"/>");
		}
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
		sc.add("<classpathentry kind=\"output\" path=\"bin\"/>");
		sc.add("</classpath>");
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		throw new UnsupportedOperationException();
	}
}

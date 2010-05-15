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

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;

/**
 * Creates the content for .classpath files, which are used by Eclipse to determine the
 * classes used by generated plug-ins. The content of the file is determined by
 * the given parameters.
 */
public class DotClasspathGenerator<ContextType> extends AbstractGenerator<ContextType, ClassPathParameters> {

	public DotClasspathGenerator(ICodeGenerationComponent parent, ContextType context, ClassPathParameters parameters) {
		super(parent, context, parameters);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<classpath>");
		for (String sourceFolder : parameters.getSourceFolders()) {
			sc.add("<classpathentry kind=\"src\" path=\"" + sourceFolder + "\"/>");
		}
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
		sc.add("<classpathentry kind=\"output\" path=\"bin\"/>");
		sc.add("</classpath>");
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator<ContextType, ClassPathParameters> newInstance(ICodeGenerationComponent parent, ContextType context, ClassPathParameters parameters) {
		return new DotClasspathGenerator<ContextType>(parent, context, parameters);
	}
}

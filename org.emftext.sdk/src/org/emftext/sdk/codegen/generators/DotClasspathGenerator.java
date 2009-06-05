/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the content for .classpath files, which are used by Eclipse to determine the
 * classes used by generated text resource plug-ins.
 */
public class DotClasspathGenerator extends BaseGenerator {

	private GenerationContext context;

	public DotClasspathGenerator(GenerationContext context) {
		super("", ".classpath");
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		
		String sourceOptionValue = OptionManager.INSTANCE.getStringOptionValue(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceFolder;
		if (sourceOptionValue == null) {
			sourceFolder = "src";
		} else {
			sourceFolder = sourceOptionValue;
		}
		
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<classpath>");
		sc.add("<classpathentry kind=\"src\" path=\"" + sourceFolder + "\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
		sc.add("<classpathentry kind=\"output\" path=\"bin\"/>");
		sc.add("</classpath>");
		
		out.write(sc.toString());
		return true;
	}
}

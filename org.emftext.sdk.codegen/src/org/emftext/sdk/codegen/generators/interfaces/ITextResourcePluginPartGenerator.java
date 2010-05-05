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
package org.emftext.sdk.codegen.generators.interfaces;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextResourcePluginPartGenerator extends JavaBaseGenerator {

	public ITextResourcePluginPartGenerator() {
		super();
	}

	private ITextResourcePluginPartGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextResourcePluginPartGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This interface is extended by some other generated classes. " +
			"It provides access to the plug-in meta information."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns a meta information object for the language plug-in " +
			"that contains this part."
		);
		sc.add("public " + iMetaInformationClassName + " getMetaInformation();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}

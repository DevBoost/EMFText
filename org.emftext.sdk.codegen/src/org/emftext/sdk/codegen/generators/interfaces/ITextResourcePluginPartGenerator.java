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

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextResourcePluginPartGenerator extends JavaBaseGenerator {

	private String iMetaInformationClassName;

	public ITextResourcePluginPartGenerator() {
		super();
	}

	private ITextResourcePluginPartGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_RESOURCE_PLUGIN_PART);
		iMetaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextResourcePluginPartGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// This interface is extended by all other EMFText runtime");
		sc.add("// API interfaces for generated components. It provides");
		sc.add("// access to the plug-in meta information.");
		
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns a meta information object for the language plug-in");
		sc.add("// that contains this part.");
		
		sc.add("public " + iMetaInformationClassName + " getMetaInformation();");
		sc.add("}");
		return true;
	}
}

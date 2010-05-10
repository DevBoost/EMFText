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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IOptionsGenerator extends JavaBaseGenerator<Object> {

	public IOptionsGenerator() {
		super();
	}

	private IOptionsGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_OPTIONS);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new IOptionsGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A list of constants that contains the keys for some options that " +
			"are built into EMFText. Generated resource plug-ins do automatically " +
			"recognize this options and use them if they are configured properly."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("The key for the option to provide a stream pre-processor.");
		sc.add("public String INPUT_STREAM_PREPROCESSOR_PROVIDER = \"INPUT_STREAM_PREPROCESSOR_PROVIDER\";");
		sc.addLineBreak();
		
		sc.addJavadoc("The key for the option to provide a resource post-processor.");
		sc.add("public String RESOURCE_POSTPROCESSOR_PROVIDER = \"RESOURCE_POSTPROCESSOR_PROVIDER\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The key for the option to specify an expected content type in text resources and text parsers. " +
			"A content type is an EClass that specifies the root object of a text resource. If this option " +
			"is set, the parser does not use the start symbols defined in the .cs specification, use the " +
			"given EClass as start symbol instead."
		);
		sc.add("public final String RESOURCE_CONTENT_TYPE = \"RESOURCE_CONTENT_TYPE\";");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}

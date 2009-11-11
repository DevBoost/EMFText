/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IOptionsGenerator extends JavaBaseGenerator {

	public IOptionsGenerator() {
		super();
	}

	private IOptionsGenerator(GenerationContext context) {
		super(context, EArtifact.I_OPTIONS);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IOptionsGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A list of constants that contains the keys for some options that");
		sc.add("// are built into EMFText. Generated resource plug-ins do automatically");
		sc.add("// recognize this options and use them if they are configured properly.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// The key for the option to provide a stream pre-processor.");
		sc.add("public String INPUT_STREAM_PREPROCESSOR_PROVIDER = \"INPUT_STREAM_PREPROCESSOR_PROVIDER\";");
		sc.addLineBreak();
		
		sc.add("// The key for the option to provide a resource post-processor.");
		sc.add("public String RESOURCE_POSTPROCESSOR_PROVIDER = \"RESOURCE_POSTPROCESSOR_PROVIDER\";");
		sc.addLineBreak();
		
		sc.add("// The key for the option specify an expected content type in text resources and text parsers.");
		sc.add("public final String RESOURCE_CONTENT_TYPE = \"RESOURCE_CONTENT_TYPE\";");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}

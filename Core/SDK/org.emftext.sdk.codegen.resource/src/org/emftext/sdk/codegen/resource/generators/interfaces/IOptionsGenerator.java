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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IOptionsGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public static final String DISABLE_CREATING_MARKERS_FOR_PROBLEMS = "DISABLE_CREATING_MARKERS_FOR_PROBLEMS";
	public static final String DISABLE_LOCATION_MAP                  = "DISABLE_LOCATION_MAP";
	public static final String DISABLE_LAYOUT_INFORMATION_RECORDING  = "DISABLE_LAYOUT_INFORMATION_RECORDING";
	public static final String ADDITIONAL_REFERENCE_RESOLVERS  = "ADDITIONAL_REFERENCE_RESOLVERS";
	public static final String OPTION_ENCODING = "OPTION_ENCODING";
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A list of constants that contains the keys for some options that " +
			"are built into EMFText. Generated resource plug-ins do automatically " +
			"recognize these options and use them if they are configured properly."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("The key for the option to provide a stream pre-processor.");
		sc.add("public String INPUT_STREAM_PREPROCESSOR_PROVIDER = new " + metaInformationClassName + "().getInputStreamPreprocessorProviderOptionKey();");
		sc.addLineBreak();
		
		sc.addJavadoc("The key for the option to provide a resource post-processor.");
		sc.add("public String RESOURCE_POSTPROCESSOR_PROVIDER = new " + metaInformationClassName + "().getResourcePostProcessorProviderOptionKey();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The key for the option to provide additional reference resolvers. " +
			"The value for this option must be a map that used EReferences as keys " +
			"and either single reference resolvers or collections of resolvers as values. " +
			"By setting this option one can customize the resolving of references at " +
			"run-time.");
		sc.add("public String " + ADDITIONAL_REFERENCE_RESOLVERS + " = \"" + ADDITIONAL_REFERENCE_RESOLVERS + "\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The key for the option to specify an expected content type in text resources and text parsers. " +
			"A content type is an EClass that specifies the root object of a text resource. If this option " +
			"is set, the parser does not use the start symbols defined in the .cs specification, but uses the " +
			"given EClass as start symbol instead. Note that the value for this option must be an EClass object " +
			"and not the name of the EClass."
		);
		sc.add("public final String RESOURCE_CONTENT_TYPE = \"RESOURCE_CONTENT_TYPE\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The key for the option to disable marker creation for resource problems. " +
			"If this option is set to <code>true</code> when loading resources, " +
			"reported problems will not be added as Eclipse workspace markers. " +
			"This option is used by the MarkerResolutionGenerator class, which will end up " +
			"in an infinite loop if markers are created when loading resources as this creation " +
			"triggers the loading of the same resource and so on."
		);
		sc.add("public final String " + DISABLE_CREATING_MARKERS_FOR_PROBLEMS + " = \"" + DISABLE_CREATING_MARKERS_FOR_PROBLEMS + "\";");
		sc.addLineBreak();

		sc.addJavadoc(
				"The key for the option to disable the location map that " +
				"maps EObjects to the position of their textual representations. " +
				"If this option is set to <code>true</code>, the " +
				"memory footprint of large models is reduced. Disabling the " +
				"location map, however, disables functionality that relies on it " +
				"(e.g. navigation in the text editor)."
			);
		sc.add("public final String " + DISABLE_LOCATION_MAP + " = \"" + DISABLE_LOCATION_MAP + "\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
				"The key for the option to disable the recording of layout information. " +
				"If this option is set to <code>true</code>, the " +
				"memory footprint of large models is reduced. When " +
				"layout information recording is disabled, a new layout is " +
				"computed during printing and the original layout is not preserved."
			);
		sc.add("public final String " + DISABLE_LAYOUT_INFORMATION_RECORDING + " = \"" + DISABLE_LAYOUT_INFORMATION_RECORDING + "\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
				"The key for the option to set the encoding to use when loading or " +
				"saving resources. This is equivalent to the same option specified in " +
				"class <code>org.eclipse.emf.ecore.xmi.XMLResource</code>.",
				"@see org.eclipse.emf.ecore.xmi.XMLResource"
			);
		sc.add("public final String " + OPTION_ENCODING + " = \"ENCODING\";");
		sc.addLineBreak();
		
		sc.add("}");
	}
}

package org.emftext.sdk.codegen.resource.ui.generators.ui;


import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_DAMAGER_REPAIRER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOKEN_SCANNER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class DamagerRepairerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"This class subclasses the {@link " + DEFAULT_DAMAGER_REPAIRER(sc) + "} and modifies "
			+ "of a damage region to not damage only the line where the modification event occurred." +
			"It damages the whole region of the model element which corresponds "
			+ "to the offset at which the modification event occurred."
		);
		sc.add("public class " + getResourceClassName() + " extends " + DEFAULT_DAMAGER_REPAIRER(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
				"Creates a new damager repairer.",
				"@param tokenScanner the token scanner for retrieving the tokens for syntax coloring",
				"@param resourceProvider the resource provider giving access to the resource which contains the model"
			);
			sc.add("public " + getResourceClassName() + "(" + I_TOKEN_SCANNER(sc) + " tokenScanner, " + iResourceProviderClassName + " resourceProvider) {");
			sc.add("super(tokenScanner);");
			sc.add("this.resourceProvider = resourceProvider;");
			sc.add("}");
			sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.addLineBreak();
	}
}

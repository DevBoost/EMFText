package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IQuickFixGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Returns a string that briefly describes the quick fix.",
			"@return brief description to display"
		);
		sc.add("public String getDisplayString();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Applies the fix and returns the new text for the resource. " +
			"If the fix does not change the current resource, but others, " +
			"null must be returned."
		);
		sc.add("public String apply(String currentText);");
		sc.addLineBreak();

		sc.addJavadoc(
			"Returns a collection of objects the fix refers to. This " +
			"collection is used to check whether the fix is can still " + 
			"be applied even after a workbench restart."
		);
		sc.add("public " + COLLECTION + "<" + E_OBJECT + "> getContextObjects();");
		sc.addLineBreak();

		// TODO mseifert add comment
		sc.add("public String getContextAsString();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}

package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class INameProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Returns a list of potential identifiers that may be used to reference the " +
			"given element. This method can be used to customize the identification " +
			"of elements."
		);
		sc.add("public " + LIST + "<String> getNames(" + E_OBJECT + " element);");
		sc.addLineBreak();
		sc.add("}");
	}

}

package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IReferenceCacheGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc("Returns all EObjects of the given type.");
		sc.add("public " + SET + "<" + E_OBJECT + "> getObjects(" + E_CLASS + " type);");
		sc.addLineBreak();

		sc.addJavadoc(
			"Initializes the cache with the object tree that is rooted at <code>root</code>. " +
			"If the cache was already initialized, no action is performed."
		);
		sc.add("public void initialize(" + E_OBJECT + " root);");
		sc.addLineBreak();

		sc.addJavadoc("Clears the cache.");
		sc.add("public void clear();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}

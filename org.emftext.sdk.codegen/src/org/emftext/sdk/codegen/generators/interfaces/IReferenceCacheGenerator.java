package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IReferenceCacheGenerator extends JavaBaseGenerator {

	public IReferenceCacheGenerator() {
		super();
	}

	private IReferenceCacheGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_REFERENCE_CACHE);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IReferenceCacheGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.add("public " + OBJECT + " get(" + STRING + " identifier);");
		sc.add("public void put(" + STRING + " identifier, " + OBJECT + " target);");
		sc.add("}");
		return true;
	}
}

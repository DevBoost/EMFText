package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IHoverTextProviderGenerator extends BaseGenerator {

	public IHoverTextProviderGenerator() {
		super();
	}

	private IHoverTextProviderGenerator(GenerationContext context) {
		super(context, EArtifact.I_HOVER_TEXT_PROVIDER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IHoverTextProviderGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public String getHoverText(" + E_OBJECT + " object);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}

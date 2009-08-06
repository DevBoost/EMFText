package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.resource.impl.AbstractHoverTextProvider;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class HoverTextProviderGenerator extends BaseGenerator {
	
	private GenerationContext context;

	public HoverTextProviderGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.HOVER_TEXT_PROVIDER));
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + AbstractHoverTextProvider.class.getName() + " {");
		sc.addLineBreak();
		// TODO hoang-kim generate getHoverText(EObject object)
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

}

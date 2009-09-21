package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IBackgroundParsingListenerGenerator extends BaseGenerator {

	public IBackgroundParsingListenerGenerator() {
		super();
	}

	private IBackgroundParsingListenerGenerator(GenerationContext context) {
		super(context, EArtifact.I_BACKGROUND_PARSING_LISTENER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IBackgroundParsingListenerGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A listener interface for classes that need notification");
		sc.add("// when a background parsing pass has completed.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Signals that the given resource has been changed and");
		sc.add("// the background parsing is completed.");
		sc.add("//");
		sc.add("// @param resource the resource that has changed");
		sc.add("public void parsingCompleted(" + RESOURCE + " resource);");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}

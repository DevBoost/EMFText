package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DotClasspathGenerator extends BaseGenerator {

	private GenerationContext context;

	public DotClasspathGenerator(GenerationContext context) {
		super("", ".classpath");
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		
		String sourceOptionValue = OptionManager.INSTANCE.getStringOptionValue(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceFolder;
		if (sourceOptionValue == null) {
			sourceFolder = "src";
		} else {
			sourceFolder = sourceOptionValue;
		}
		
		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<classpath>");
		sc.add("<classpathentry kind=\"src\" path=\"" + sourceFolder + "\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
		sc.add("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
		sc.add("<classpathentry kind=\"output\" path=\"bin\"/>");
		sc.add("</classpath>");
		
		out.write(sc.toString());
		return true;
	}
}

package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuildPropertiesGenerator extends BaseGenerator {

	private GenerationContext context;

	public BuildPropertiesGenerator(GenerationContext context) {
		super("", "build.properties");
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
		
		StringBuilder sc = new StringBuilder();
		
		sc.append("bin.includes = icons/,\\\n");
		sc.append("plugin.xml,\\\n");
		sc.append("META-INF/,\\\n");
		sc.append(".\n");
		sc.append("source.. = " + sourceFolder + "/\n");
		
		out.write(sc.toString());
		return true;
	}
}

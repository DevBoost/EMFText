package org.emftext.sdk.codegen.regex;

import java.io.File;

import org.antlr.Tool;

public class RunAntlr {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		Tool antlrTool = new Tool(new String[] { "-o",
				new File(".").getAbsolutePath(),
				"./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" });
		antlrTool.process();
	}
}

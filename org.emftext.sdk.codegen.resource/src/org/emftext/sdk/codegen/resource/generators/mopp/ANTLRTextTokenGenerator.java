package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ANTLRTextTokenGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + textTokenClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetTokenNameMethod(sc);
		generatorUtil.addCanBeUsedForSyntaxHighlightingMethod(sc, true);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final static " + iMetaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + TOKEN + " antlrToken) {");
		sc.add("super(" +
				"getTokenName(metaInformation.getTokenNames(), antlrToken.getType()), " +
				"antlrToken.getText(), " +
				"((" + COMMON_TOKEN + ") antlrToken).getStartIndex(), " +
				"((" + COMMON_TOKEN + ") antlrToken).getStopIndex() - ((" + COMMON_TOKEN + ") antlrToken).getStartIndex() + 1, " +
				"antlrToken.getLine(), " +
				"antlrToken.getCharPositionInLine(), " +
				"canBeUsedForSyntaxHighlighting(antlrToken.getType()));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(JavaComposite sc) {
		sc.add("public static String getTokenName(String[] tokenNames, int index) {");
		sc.add("if (tokenNames == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("String tokenName = tokenNames[index];");
		sc.add("if (tokenName != null && tokenName.startsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(1, tokenName.length() - 1).trim();");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
	}
}

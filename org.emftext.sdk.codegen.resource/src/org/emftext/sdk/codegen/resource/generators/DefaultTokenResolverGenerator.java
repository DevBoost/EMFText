/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_DATA_TYPE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ENUM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ENUM_LITERAL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class DefaultTokenResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A default implementation for token resolvers. It tries to resolve lexems using Java methods.");
		sc.add("public class " + getResourceClassName() + " implements " + iTokenResolverClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addDeResolveMethod(sc);
		addResolveMethod(sc);
		addSetEscapeKeywordsMethod(sc);
		addSetOptionsMethod(sc);
		addGetOptionsMethod(sc);
	}

	private void addGetOptionsMethod(StringComposite sc) {
		sc.add("public " + MAP + "<?, ?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?, ?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveMethod(JavaComposite sc) {
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result) {");
		sc.add("if (escapeKeywords && lexem.startsWith(\"_\")) {");
		sc.addComment("Unescape keywords if required");
		sc.add("for (" + keywordClassName + " keyword : " + grammarInformationProviderClassName + ".KEYWORDS) {");
		sc.add("String keywordValue = keyword.getValue();");
		sc.add("if (lexem.endsWith(keywordValue)) {");
		sc.add("String prefix = lexem.substring(0, lexem.length() - keywordValue.length());");
		sc.add("if (prefix.matches(\"_+\")) {");
		sc.add("lexem = lexem.substring(1);");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add("if (feature.getEType() instanceof " + E_ENUM + ") {");
		sc.add(E_ENUM_LITERAL + " literal = ((" + E_ENUM + ") feature.getEType()).getEEnumLiteralByLiteral(lexem);");
		sc.add("if (literal != null) {");
		sc.add("result.setResolvedToken(literal.getInstance());");
		sc.add("return;");
		sc.add("} else {");
		sc.add("result.setErrorMessage(\"Could not map lexem '\" + lexem + \"' to enum '\" + feature.getEType().getName() + \"'.\");");
		sc.add("return;");
		sc.add("}");
		sc.add("} else if (feature.getEType() instanceof " + E_DATA_TYPE + ") {");
		sc.add("try {");
		sc.add("result.setResolvedToken(" + ECORE_UTIL + ".createFromString((" + E_DATA_TYPE + ") feature.getEType(), lexem));");
		sc.add("} catch (Exception e) {");
		sc.add("result.setErrorMessage(\"Could not convert '\" + lexem + \"' to '\" + feature.getEType().getName() + \"'.\");");
		sc.add("}");
		sc.add("String typeName = feature.getEType().getInstanceClassName();");
		sc.add("if (typeName.equals(\"boolean\") || java.lang.Boolean.class.getName().equals(typeName)) {");
		sc.add("String featureName = feature.getName();");
		sc.add("boolean featureNameMatchesLexem = featureName.equals(lexem);");
		sc.add("if (featureName.length() > 2 && featureName.startsWith(\"is\")) {");
		sc.add("featureNameMatchesLexem |= (featureName.substring(2, 3).toLowerCase() + featureName.substring(3)).equals(lexem);");
		sc.add("}");
		sc.add("result.setResolvedToken(Boolean.parseBoolean(lexem) || featureNameMatchesLexem);");
		sc.add("return;");
		sc.add("}");
		sc.add("} else {");
		sc.add("assert false;");
		sc.add("}");
		sc.add("} else {");
		sc.add("result.setResolvedToken(lexem);");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeResolveMethod(JavaComposite sc) {
		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container) {");
		sc.add("if (value == null) {");
		sc.add("return \"null\";");
		sc.add("}");
		sc.add("String text = value.toString();");
		sc.add("if (escapeKeywords) {");
		sc.addComment("Escape keywords if required");
		sc.add("for (" + keywordClassName + " keyword : " + grammarInformationProviderClassName + ".KEYWORDS) {");
		sc.add("String keywordValue = keyword.getValue();");
		sc.add("if (text.endsWith(keywordValue)) {");
		sc.add("String prefix = text.substring(0, text.length() - keywordValue.length());");
		sc.add("if (prefix.matches(\"_*\")) {");
		sc.add("text = \"_\" + text;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return text;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private boolean escapeKeywords = true;");
		sc.addLineBreak();
	}
	
	private void addSetEscapeKeywordsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method can be used to disable automatic escaping and unescaping of tokens that " +
			"match keywords of the syntax."
		);
		sc.add("public void setEscapeKeywords(boolean escapeKeywords) {");
		sc.add("this.escapeKeywords = escapeKeywords;");
		sc.add("}");
		sc.addLineBreak();
	}
}

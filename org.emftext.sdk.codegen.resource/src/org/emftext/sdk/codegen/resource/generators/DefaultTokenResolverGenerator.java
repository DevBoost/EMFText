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
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addConstructors(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
	}

	private void addConstructor1(JavaComposite sc) {
		sc.addJavadoc(
			"This constructor is used by token resolvers that were generated before EMFText 1.3.5. " +
			"It does not enable automatic escaping and unescaping of keywords.");
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("this(false);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.addJavadoc(
			"This constructor is used by token resolvers that were generated with EMFText 1.3.5 and later releases. " +
			"It can optionally enable automatic escaping and unescaping of keywords.");
		sc.add("public " + getResourceClassName() + "(boolean escapeKeywords) {");
		sc.add("super();");
		sc.add("this.escapeKeywords = escapeKeywords;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addResolveMethod1(sc);
		addResolveMethod2(sc);
		addDeResolveMethod1(sc);
		addDeResolveMethod2(sc);
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

	private void addResolveMethod1(JavaComposite sc) {
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result) {");
		sc.add("resolve(lexem, feature, result, null, null, null);");
		sc.add("}");
		sc.addLineBreak();
	}
		
	private void addResolveMethod2(JavaComposite sc) {
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result, String suffix, String prefix, String escapeCharacter) {");
		
		sc.addComment("Step 1: unescape keywords if required");
		sc.add("if (escapeKeywords && lexem.startsWith(\"_\")) {");
		sc.add("for (" + keywordClassName + " keyword : " + grammarInformationProviderClassName + ".KEYWORDS) {");
		sc.add("String keywordValue = keyword.getValue();");
		sc.add("if (lexem.endsWith(keywordValue)) {");
		sc.add("String keywordPrefix = lexem.substring(0, lexem.length() - keywordValue.length());");
		sc.add("if (keywordPrefix.matches(\"_+\")) {");
		sc.add("lexem = lexem.substring(1);");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Step 2: remove prefix, suffix and unescape escaped suffixes");
		sc.addComment("Step 2a: remove prefix");
		sc.add("if (prefix != null) {");
		sc.add("int count = prefix.length();");
		sc.add("lexem = lexem.substring(count);");		
		sc.add("}");
		sc.addComment("Step 2b: remove suffix");
		sc.add("if (suffix != null) {");
		sc.add("int count = suffix.length();");
		sc.add("lexem = lexem.substring(0, lexem.length() - count );");
		sc.addComment("take care of the escape character (may be null)");
		sc.addComment("Step 2c: replaced escaped suffixes and escaped escape sequences");
		sc.add("if (escapeCharacter != null) {");
		sc.add("lexem = lexem.replace(escapeCharacter + suffix, suffix);");
		sc.add("lexem = lexem.replace(escapeCharacter + escapeCharacter, escapeCharacter);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Step 3: convert text to Java object");
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

	private void addDeResolveMethod1(JavaComposite sc) {
		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container) {");
		sc.add("return deResolve(value, feature, container, null, null, null);");
		sc.add("}");
		sc.addLineBreak();
	}
		
	private void addDeResolveMethod2(JavaComposite sc) {
		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container, String prefix, String suffix, String escapeCharacter) {");
		sc.addComment("Step 1: convert Java object to text");
		sc.add("String result = null;");
		sc.add("if (value != null) {");
		sc.add("result = value.toString();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment("Step 2: escape suffixes, add prefix and suffix");
		sc.addComment("Step 2a: escaped suffix");
		sc.add("if (suffix != null) {");
		sc.addComment("take care of the escape character (may be null)");
		sc.add("if (escapeCharacter != null) {");
		sc.add("result = result.replace(escapeCharacter, escapeCharacter + escapeCharacter);");
		sc.add("result = result.replace(suffix, escapeCharacter + suffix);");
		sc.add("}");
		sc.addComment("Step 2b: append suffix");
		sc.add("result += suffix;");
		sc.add("}");
		sc.addComment("Step 2c: prepend prefix");
		sc.add("if (prefix != null) {");
		sc.add("result = prefix + result;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment("Step 3: escape keywords if required");
		sc.add("if (escapeKeywords) {");
		sc.addComment("Escape keywords if required");
		sc.add("for (" + keywordClassName + " keyword : " + grammarInformationProviderClassName + ".KEYWORDS) {");
		sc.add("String keywordValue = keyword.getValue();");
		sc.add("if (result.endsWith(keywordValue)) {");
		sc.add("String keywordPrefix = result.substring(0, result.length() - keywordValue.length());");
		sc.add("if (keywordPrefix.matches(\"_*\")) {");
		sc.add("result = \"_\" + result;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private boolean escapeKeywords;");
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

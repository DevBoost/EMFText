/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.TokenResolverParameters;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.util.StringUtil;

/**
 * A TokenResolverGenerator generates a single TokenResolver for a given TokenDefinition.
 * 
 * For a definition with prefix and suffix it generates code which removes these 
 * strings from the beginning and the end of a lexem and then passes the manipulated 
 * lexem to the default token resolver. In the deresolvement the conversion from 
 * object to string is also delegated to the default resolver. 
 * Finally the deresolved String will be decorated by pre- and suffixes again. 
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
@SyntaxDependent
public class TokenResolverGenerator extends JavaBaseGenerator<TokenResolverParameters> {
	
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final NameUtil nameUtil = new NameUtil();
	
	private CompleteTokenDefinition definition;
	
	public void generateJavaContents(JavaComposite sc) {
		setTokenDefinition(getParameters().getDefinition());

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		sc.add("public class " + nameUtil.getTokenResolverClassName(syntax, definition) + " implements " + iTokenResolverClassName + " {");
		sc.addLineBreak();
		
		// do not generate a resolver for imported tokens
		boolean isImportedToken = definition.isImported(syntax);
		if (isImportedToken) {
			String importedTokenResolverClassName = nameUtil.getQualifiedTokenResolverClassName(syntax, definition, true);
			sc.addComment(
				"If this line does not compile, the imported language plug-ins were generated before EMFText 1.4.0. " +
				"To resolve the compilation error remove the argument from the constructor call."
			);
			sc.add("private " + importedTokenResolverClassName + " importedResolver = new " + importedTokenResolverClassName + "(true);");
			sc.addLineBreak();
			generateDeResolveMethod2(sc);
			generateResolveMethod2(sc);
		    generatorUtil.addSetOptionsMethod(sc, "importedResolver.setOptions(options);", null);
		} else {
			sc.add("private " + defaultTokenResolverClassName + " defaultTokenResolver = new " + defaultTokenResolverClassName + "(true);");
			sc.addLineBreak();
			generateDeResolveMethod1(sc);
			generateResolveMethod1(sc);
		    generatorUtil.addSetOptionsMethod(sc, "defaultTokenResolver.setOptions(options);", null);
		}
		sc.add("}");
	}

	private void generateDeResolveMethod1(JavaComposite sc) {
		String prefix = getPrefix();
		String suffix = getSuffix();
		String escapeCharacter = getEscapeCharacter();

		String javaSourcePrefix = escape(prefix);
		String javaSourceSuffix = escape(suffix);
		String javaSourceEscapeCharacter = escape(escapeCharacter);

		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container) {");
		sc.addComment("By default token de-resolving is delegated to the DefaultTokenResolver.");
		sc.add("String result = defaultTokenResolver.deResolve(value, feature, container, " + javaSourcePrefix + ", " + javaSourceSuffix + ", " + javaSourceEscapeCharacter + ");");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateDeResolveMethod2(StringComposite sc) {
		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container) {");
		sc.add("String result = importedResolver.deResolve(value, feature, container);");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateResolveMethod1(JavaComposite sc) {
		String prefix = getPrefix();
		String suffix = getSuffix();
		String escapeCharacter = getEscapeCharacter();
		
		String javaSourcePrefix = escape(prefix);
		String javaSourceSuffix = escape(suffix);
		String javaSourceEscapeCharacter = escape(escapeCharacter);

		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result) {");
		sc.addComment("By default token resolving is delegated to the DefaultTokenResolver.");
		sc.add("defaultTokenResolver.resolve(lexem, feature, result, " + javaSourcePrefix + ", " + javaSourceSuffix + ", " + javaSourceEscapeCharacter + ");");
		sc.add("}");
		sc.addLineBreak();
	}

	private String escape(String prefix) {
		String javaSourcePrefix = StringUtil.escapeToJavaString(prefix);
		if (javaSourcePrefix != null) {
			javaSourcePrefix = "\"" + javaSourcePrefix + "\"";
		}
		return javaSourcePrefix;
	}
	
	private void generateResolveMethod2(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		ConcreteSyntax containingSyntax = definition.getContainingSyntax(syntax);
		String importedTokenResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT, containingSyntax);
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, final " + iTokenResolveResultClassName + " result) {");
		sc.add("importedResolver.resolve(lexem, feature, new " + importedTokenResolveResultClassName + "() {");
		sc.add("public String getErrorMessage() {");
		sc.add("return result.getErrorMessage();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public Object getResolvedToken() {");
		sc.add("return result.getResolvedToken();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setErrorMessage(String message) {");
		sc.add("result.setErrorMessage(message);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setResolvedToken(Object resolvedToken) {");
		sc.add("result.setResolvedToken(resolvedToken);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private String getPrefix() {
		String prefix = null;
		if (definition instanceof QuotedTokenDefinition) {
			prefix = ((QuotedTokenDefinition) definition).getPrefix();
		}
		return prefix;
	}

	private String getSuffix() {
		String suffix = null;
		if (definition instanceof QuotedTokenDefinition) {
			suffix = ((QuotedTokenDefinition) definition).getSuffix();
		}
		return suffix;
	}

	private String getEscapeCharacter() {
		String suffix = null;
		if (definition instanceof QuotedTokenDefinition) {
			suffix = ((QuotedTokenDefinition) definition).getEscapeCharacter();
		}
		return suffix;
	}

	private void setTokenDefinition(CompleteTokenDefinition tokenDefinition) {
		this.definition = tokenDefinition;
	}
}

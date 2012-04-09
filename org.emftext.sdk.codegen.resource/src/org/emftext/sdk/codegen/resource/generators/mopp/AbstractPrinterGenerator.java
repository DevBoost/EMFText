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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.StringUtil;

public abstract class AbstractPrinterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();

	private GenClassCache genClassCache;
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		genClassCache = getContext().getConcreteSyntax().getGenClassCache();
	}

	protected String getMetaClassName(Rule rule) {
		if (rule.getSyntax().getGenClassCache().hasMapType(rule.getMetaclass()) ) {
			return rule.getMetaclass().getQualifiedClassName();
		}
		return genClassCache.getQualifiedInterfaceName(rule.getMetaclass());
	}

	protected String getMethodName(Rule rule) {
		String ruleName = rule.getSyntax().getGenClassCache().getEscapedTypeName(rule.getMetaclass());
		return "print_" + ruleName;
	}

	protected void addAddWarningToResourceMethod(JavaComposite sc) {
		sc.add("protected void addWarningToResource(final String errorMessage, " + E_OBJECT + " cause) {");
		sc.add(iTextResourceClassName + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.addComment("the resource can be null if the printer is used stand alone");
		sc.add("return;");
		sc.add("}");
    	sc.add("resource.addProblem(new " + problemClassName + "(errorMessage, " + eProblemTypeClassName + ".PRINT_PROBLEM, " + eProblemSeverityClassName + ".WARNING), cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetOptionsMethod(StringComposite sc) {
		sc.add("public " + MAP + "<?,?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetEncoding(JavaComposite sc) {
		sc.add("public String getEncoding() {");
		sc.add("return encoding;");
		sc.add("}");
		sc.addLineBreak();	
	}
	protected void addSetEncoding(JavaComposite sc) {
		sc.add("public void setEncoding(String encoding) {");
		sc.add("if (encoding != null) {");
		sc.add("this.encoding = encoding;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	protected void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("protected " + referenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("return (" + referenceResolverSwitchClassName + ") new " + metaInformationClassName + "().getReferenceResolverSwitch();");
        sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + iTextResourceClassName + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	// TODO mseifert: this code should go to class GenClassCache
	protected String getAccessMethod(GenClassCache genClassCache, GenClass genClass, GenFeature genFeature) {
		if (genClassCache.hasMapType(genClass)) {
			return "get" + StringUtil.capitalize(genFeature.getName()) + "()";
		}
		else {
			String method = "eGet(element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "))";
			return method;
		}
	}

	protected String getTabString(int count) {
		return StringUtil.getRepeatingString(count, '\t');
	}

	protected String getWhiteSpaceString(int count) {
		return StringUtil.getRepeatingString(count, ' ');
	}

	protected void addGetWhiteSpaceStringMethod(StringComposite sc) {
		sc.add("protected String getWhiteSpaceString(int count) {");
		sc.add("return getRepeatingString(count, ' ');");
		sc.add("}");
		sc.addLineBreak();
	}
	
	protected void addGetRepeatingStringMethod(StringComposite sc) {
		sc.add("private String getRepeatingString(int count, char character) {");
		sc.add("StringBuffer result = new StringBuffer();");
		sc.add("for (int i = 0; i < count; i++) {");
		sc.add("result.append(character);");
		sc.add("}");
		sc.add("return result.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	protected int getTokenSpace() {
		String tokenSpaceString = OptionManager.INSTANCE.getStringOptionValue(getContext().getConcreteSyntax(), OptionTypes.TOKENSPACE);
		try {
			int tokenSpace = Integer.parseInt(tokenSpaceString);
			if (tokenSpace < 0) {
				tokenSpace = 1;
			}
			return tokenSpace;
		} catch (NumberFormatException nfe) {
			assert 
				tokenSpaceString == null ||
				OptionManager.TOKEN_SPACE_VALUE_AUTOMATIC.equals(tokenSpaceString);
			// token space handling is either not set (default is 1) or set to automatic
			// (actual value does not matter in this case)
			return 1;
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Rule;

import de.devboost.codecomposers.java.JavaComposite;

public class PreferenceConstantsGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String BRACKETS_EXPRESSION 	= "[\\(\\)\\{\\}\\[\\]\\<\\>]";
	private static final String DELIMITERS_EXPRESSION	= "[;,\"]";
	
	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.addJavadoc(
				"An interface that defines some constants used to create " +
						"the keys for preferences."
				);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();

		sc.addComment("Constants for syntax highlighting");
		sc.addJavadoc("Preference key suffix to enable syntax highlighting for a token type.");
		sc.add("public static final String EDITOR_ENABLE_SUFFIX = \"_enable\";");
		sc.add("public static final String EDITOR_COLOR_SUFFIX = \"_color\";");
		sc.addLineBreak();

		sc.addComment("Constants for brackets");
		sc.add("public static final String EDITOR_MATCHING_BRACKETS_COLOR = \"_matchingBracketsColor\";");
		sc.add("public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = \"_matchingBracketsCheckbox\";");
		sc.add("public static final String EDITOR_BRACKETS_SUFFIX = \"_brackets\";");
		sc.addLineBreak();

		sc.addComment("Constants for content assists");
		sc.add("public static final String EDITOR_CONTENT_ASSIST_ENABLED 	= \"_activationEnabled\";");
		sc.add("public static final String EDITOR_CONTENT_ASSIST_DELAY 		= \"_activationDelay\";");
		sc.add("public static final String EDITOR_CONTENT_ASSIST_TRIGGERS 	= \"_activationTriggers\";");
		sc.addComment("and their defaults");
		sc.add("public static final boolean EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT	= true;");
		sc.add("public static final int EDITOR_CONTENT_ASSIST_DELAY_DEFAULT			= 200;");
		String activationTokens = getSingleActivationTokens();
		sc.add("public static final String EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT 	= \"" + activationTokens + "\";");
		
		sc.addLineBreak();
		sc.add("}");
	}

	private String getSingleActivationTokens() {
		Set<String> tokenSet = new LinkedHashSet<String>();
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			TreeIterator<EObject> iterator = rule.eAllContents();
			while (iterator.hasNext()) {
				EObject element = (EObject) iterator.next();
				if(element instanceof CsString){
					CsString csString = (CsString) element;
					String stringValue = csString.getValue();
					if(stringValue.length() == 1){
						// \w = A word character, short for [a-zA-Z_0-9]
						if(!stringValue.matches("\\w") && !stringValue.matches(BRACKETS_EXPRESSION) && !stringValue.matches(DELIMITERS_EXPRESSION)){
							tokenSet.add(stringValue);
						}
					}
				}
			}
		}
		String tokens = "";
		Iterator<String> iterator = tokenSet.iterator();
		while (iterator.hasNext()) {
			String token = (String) iterator.next();
			tokens += token;
		}
		return tokens;
	}
}

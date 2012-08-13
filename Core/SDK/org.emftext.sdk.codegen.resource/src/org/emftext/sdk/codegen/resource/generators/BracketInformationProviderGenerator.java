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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.sdk.util.StringUtil;

@SyntaxDependent
public class BracketInformationProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static class BracketPair {
		private final String openingBracket;
		private final String closingBracket;
		private final boolean closeInsideEnabled;
		
		public BracketPair(String openingBracket, String closingBracket,
				boolean closeInsideEnabled) {
			super();
			this.openingBracket = openingBracket;
			this.closingBracket = closingBracket;
			this.closeInsideEnabled = closeInsideEnabled;
		}
		
		public String getOpeningBracket() {
			return openingBracket;
		}

		public String getClosingBracket() {
			return closingBracket;
		}

		public boolean isCloseInsideEnabled() {
			return closeInsideEnabled;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((closingBracket == null) ? 0 : closingBracket.hashCode());
			result = prime
					* result
					+ ((openingBracket == null) ? 0 : openingBracket.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BracketPair other = (BracketPair) obj;
			if (closingBracket == null) {
				if (other.closingBracket != null)
					return false;
			} else if (!closingBracket.equals(other.closingBracket))
				return false;
			if (openingBracket == null) {
				if (other.openingBracket != null)
					return false;
			} else if (!openingBracket.equals(other.openingBracket))
				return false;
			return true;
		}
	}
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
		addBracketPairClass(sc);
		addGetBracketPairsMethod(sc);
		sc.add("}");
	}

	private void addBracketPairClass(StringComposite sc) {
		sc.add("public class BracketPair implements " + iBracketPairClassName + " {");
        sc.addLineBreak();
        sc.add("private String opening;");
        sc.add("private String closing;");
        sc.add("private boolean closingEnabledInside;");
        sc.addLineBreak();
        sc.add("public BracketPair(String opening, String closing, boolean closingEnabledInside) {");
        sc.add("super();");
        sc.add("this.opening = opening;");
        sc.add("this.closing = closing;");
        sc.add("this.closingEnabledInside = closingEnabledInside;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public String getOpeningBracket() {");
        sc.add("return opening;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public String getClosingBracket() {");
        sc.add("return closing;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isClosingEnabledInside() {");
        sc.add("return closingEnabledInside;");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
    }

	private void addGetBracketPairsMethod(StringComposite sc) {
		
		Collection<BracketPair> defaultPairs = new ArrayList<BracketPair>();
		defaultPairs.add(new BracketPair("{", "}", false));
		defaultPairs.add(new BracketPair("(", ")", false));
		defaultPairs.add(new BracketPair("[", "]", false));
		defaultPairs.add(new BracketPair("<", ">", false));
		defaultPairs.add(new BracketPair("\"", "\"", false));
		defaultPairs.add(new BracketPair("'", "'", false));
		
		Collection<BracketPair> foundPairs = new LinkedHashSet<BracketPair>();
		findBracketPairsInCsStrings(defaultPairs, foundPairs);
		findBracketPairsInQuotedPlaceholders(defaultPairs, foundPairs);

		sc.add("public " + COLLECTION + "<" + iBracketPairClassName + "> getBracketPairs() {");
		sc.add(COLLECTION + "<" + iBracketPairClassName + "> result = new " + ARRAY_LIST + "<" + iBracketPairClassName + ">();");
		for (BracketPair foundPair : foundPairs) {
			final String left = StringUtil.escapeToJavaString(foundPair.getOpeningBracket());
			final String right = StringUtil.escapeToJavaString(foundPair.getClosingBracket());
			final boolean isClosingInsideEnabled = foundPair.isCloseInsideEnabled();
			sc.add("result.add(new BracketPair(\"" + left + "\", \"" + right + "\", " + isClosingInsideEnabled + "));");
		}
		sc.add("return result;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void findBracketPairsInCsStrings(
			Collection<BracketPair> defaultPairs,
			Collection<BracketPair> foundPairs) {
		List<Rule> rules = getContext().getConcreteSyntax().getAllRules();
		for (Rule rule : rules) {
			Collection<CsString> csStrings = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			Collection<String> csStringValues = new LinkedHashSet<String>();
			for (CsString csString : csStrings) {
				csStringValues.add(csString.getValue());
			}
			for (BracketPair defaultPair : defaultPairs) {
				final String left = defaultPair.getOpeningBracket();
				final String right = defaultPair.getClosingBracket();
				if (csStringValues.contains(left) && csStringValues.contains(right)) {
					foundPairs.add(new BracketPair(left, right, true));
				}
			}
		}
	}

	private void findBracketPairsInQuotedPlaceholders(
			Collection<BracketPair> defaultPairs,
			Collection<BracketPair> foundPairs) {
		List<Rule> rules = getContext().getConcreteSyntax().getAllRules();
		for (Rule rule : rules) {
			Collection<PlaceholderInQuotes> placeholdersInQuotes = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholder : placeholdersInQuotes) {
				final String left = placeholder.getNormalizedPrefix();
				final String right = placeholder.getNormalizedSuffix();
				for (BracketPair defaultPair : defaultPairs) {
					String defaultLeft = defaultPair.getOpeningBracket();
					String defaultRight = defaultPair.getClosingBracket();
					if (defaultLeft.equals(left) && defaultRight.equals(right)) {
						foundPairs.add(new BracketPair(left, right, false));
					}
				}
			}
		}
	}

	
}

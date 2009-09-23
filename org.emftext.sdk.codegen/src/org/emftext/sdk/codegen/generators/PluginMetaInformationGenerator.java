package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.runtime.util.StringUtil;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenStyle;

// TODO generate information that changes frequently (token styles, classes with syntax, brackets) to
// separate classes
public class PluginMetaInformationGenerator extends BaseGenerator {

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
	
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GenClassUtil genClassUtil = new GenClassUtil();
	
	public PluginMetaInformationGenerator() {
		super();
	}

	private PluginMetaInformationGenerator(GenerationContext context) {
		super(context, EArtifact.META_INFORMATION);
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " implements " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " {");
        sc.addLineBreak();
        addTokenStyleImplClass(sc);
        addBracketPairClass(sc);
    	addGetConcreteSyntaxName(sc);
    	addGetURIMethod(sc);
    	addCreateLexerMethod(sc);
		addCreateParserMethod(sc);
		addGetClassesWithSyntaxMethod(sc);
        addGetReferenceResolverSwitchMethod(sc);
        addGetTokenResolverFactoryMethod(sc);
        addGetPathTOCSDefinitionMethod(sc);
        addGetTokenNamesMethod(sc);
        addGetDefaultStyleMethod(sc);
        addGetBracketPairsMethod(sc);
        addGetFoldableClassesMethod(sc);
    	addGetHoverTextProviderMethod(sc);
        sc.add("}");
    	
		out.print(sc.toString());
    	return true;	
	}

	private void addGetHoverTextProviderMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_HOVER_TEXT_PROVIDER() + " getHoverTextProvider() {");
		sc.add("return new " + getContext().getQualifiedClassName(EArtifact.HOVER_TEXT_PROVIDER)+"();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFoldableClassesMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + "[] getFoldableClasses() {");
		
		List<GenClass> foldableClasses = new ArrayList<GenClass>();
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		for (Rule rule : syntax.getAllRules()) {
			for (Annotation annotation : rule.getAnnotations()) {
				if (AnnotationType.FOLDABLE == annotation.getType()) {
					// found rule for foldable class
					foldableClasses.add(rule.getMetaclass());
				}
			}
		}
		sc.add("return new " + E_CLASS + "[] {");
		for (GenClass foldableClass : foldableClasses) {
			sc.add(genClassUtil.getAccessor(foldableClass) + ",");
		}
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addBracketPairClass(StringComposite sc) {
		sc.add("public class BracketPair implements " + getClassNameHelper().getI_BRACKET_PAIR() + " {");
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

	private void addCreateLexerMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TEXT_SCANNER()+ " createLexer() {");
		if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
			sc.add("return new " + getContext().getQualifiedClassName(EArtifact.SCANNERLESS_SCANNER) + "();");
		} else {
			final String qualifiedAntlrScannerClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_SCANNER);
			final String qualifiedAntlrLexerClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_LEXER);
			sc.add("return new " + qualifiedAntlrScannerClassName + "(new " + qualifiedAntlrLexerClassName + "());");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addTokenStyleImplClass(StringComposite sc) {
		sc.add("public class TokenStyleImpl implements " + getClassNameHelper().getI_TOKEN_STYLE() + " {");
        sc.addLineBreak();
        sc.add("private int[] color;");
        sc.add("private boolean bold;");
        sc.add("private boolean italic;");
        sc.add("private boolean strikethrough;");
        sc.add("private boolean underline;");
        sc.addLineBreak();
        sc.add("public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {");
        sc.add("super();");
        sc.add("this.color = color;");
        sc.add("this.bold = bold;");
        sc.add("this.italic = italic;");
        sc.add("this.strikethrough = striketrough;");
        sc.add("this.underline = underline;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public int[] getColorAsRGB() {");
        sc.add("return color;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isBold() {");
        sc.add("return bold;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isItalic() {");
        sc.add("return italic;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isStrikethrough() {");
        sc.add("return strikethrough;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isUnderline() {");
        sc.add("return underline;");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public " + STRING +"[] getTokenNames() {");
		if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
			sc.add("return new " + getContext().getQualifiedClassName(EArtifact.SCANNERLESS_PARSER) + "().getTokenNames();");
		} else {
			sc.add("return new " + getContext().getQualifiedClassName(EArtifact.ANTLR_PARSER) + "(null).getTokenNames();");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetDefaultStyleMethod(StringComposite sc) {
		List<TokenStyle> styles = getContext().getConcreteSyntax().getAllTokenStyles();
		
		sc.add("public " + getClassNameHelper().getI_TOKEN_STYLE() + " getDefaultTokenStyle(" + STRING + " tokenName) {");
		for (TokenStyle nextStyle : styles) {
			String name = nextStyle.getTokenName();
			sc.add("if (\"" + name + "\".equals(tokenName)) {");
			String rgb = nextStyle.getRgb();
			String color = "new int[] {0x" + rgb.substring(0, 2)+ ", 0x" + rgb.substring(2, 4) + ", 0x" + rgb.substring(4, 6) + "}";
			String bold = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.BOLD));
			String italic = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.ITALIC));
			String strikethrough = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.STRIKETHROUGH));
			String underline = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.UNDERLINE));
			sc.add("return new TokenStyleImpl(" + color + ", " + bold + ", " + italic + ", " + strikethrough + ", " + underline + ");");
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetPathTOCSDefinitionMethod(StringComposite sc) {
		sc.add("public " + STRING +" getPathToCSDefinition() {");
        sc.add("return \"" + getContext().getSyntaxProjectName() + "/" + getContext().getProjectRelativePathToSyntaxFile() + "\";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetURIMethod(StringComposite sc) {
		sc.add("public " + STRING +" getURI() {");
		sc.add("return \"" + getContext().getConcreteSyntax().getPackage().getNSURI() + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetConcreteSyntaxName(StringComposite sc) {
		sc.add("public " + STRING +" getSyntaxName() {");
    	sc.add("return \"" + getContext().getConcreteSyntax().getName() + "\";");
    	sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateParserMethod(StringComposite sc) {
		String parserClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_PARSER);
	    if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
	    	parserClassName = getContext().getQualifiedClassName(EArtifact.SCANNERLESS_PARSER);
	    }
		
		sc.add("public " + getClassNameHelper().getI_TEXT_PARSER() + " createParser(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("return new " + parserClassName + "().createInstance(inputStream, encoding);");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetClassesWithSyntaxMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		
		Collection<GenClass> classesWithSyntax = csUtil.getClassesWithSyntax(syntax);
		sc.add("public " + E_CLASS + "[] getClassesWithSyntax() {");
		sc.add("return new " + E_CLASS + "[] {");
		for (GenClass classWithSyntax : classesWithSyntax) {
			sc.add(genClassUtil.getAccessor(classWithSyntax) + ",");
		}
		sc.add("};");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		String resolverSwitchClassName = getContext().getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);

		sc.add("public " + getClassNameHelper().getI_REFERENCE_RESOLVER_SWITCH() + " getReferenceResolverSwitch() {");
		sc.add("return new " + resolverSwitchClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenResolverFactoryMethod(StringComposite sc) {
		String tokenResolverFactoryClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);

		sc.add("public " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY() + " getTokenResolverFactory() {");
		sc.add("return new " + tokenResolverFactoryClassName + "();");
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

		sc.add("public " + COLLECTION + "<" + getClassNameHelper().getI_BRACKET_PAIR() + "> getBracketPairs() {");
		sc.add(COLLECTION + "<" + getClassNameHelper().getI_BRACKET_PAIR() + "> result = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_BRACKET_PAIR() + ">();");
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

	public IGenerator newInstance(GenerationContext context) {
		return new PluginMetaInformationGenerator(context);
	}
}
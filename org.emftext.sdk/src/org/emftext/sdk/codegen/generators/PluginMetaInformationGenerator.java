package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_BRACKET_PAIR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_TOKEN_STYLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_TEXT_RESOURCE_PLUGIN_META_INFORMATION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_BRACKET_PAIR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REFERENCE_RESOLVER_SWITCH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_PARSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_SCANNER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_RESOLVER_FACTORY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_STYLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.codegen.util.Pair;
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

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassUtil genClassUtil = new GenClassUtil();
	
	private GenerationContext context;

	public PluginMetaInformationGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.META_INFORMATION));
		this.context = context;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " extends " + ABSTRACT_TEXT_RESOURCE_PLUGIN_META_INFORMATION + " {");
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

        sc.add("}");
    	
		out.print(sc.toString());
    	return true;	
	}

	private void addBracketPairClass(StringComposite sc) {
		sc.add("public class BracketPair extends " + ABSTRACT_BRACKET_PAIR + " {");
        sc.addLineBreak();
        sc.add("private String opening;");
        sc.add("private String closing;");
        sc.addLineBreak();
        sc.add("public BracketPair(String opening, String closing) {");
        sc.add("super();");
        sc.add("this.opening = opening;");
        sc.add("this.closing = closing;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public String getOpeningBracket() {");
        sc.add("return opening;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public String getClosingBracket() {");
        sc.add("return closing;");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateLexerMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_SCANNER+ " createLexer() {");
		if (OptionManager.INSTANCE.useScalesParser(context.getConcreteSyntax())) {
			sc.add("return new " + context.getQualifiedClassName(EArtifact.SCANNERLESS_SCANNER) + "();");
		} else {
			final String qualifiedAntlrScannerClassName = context.getQualifiedClassName(EArtifact.ANTLR_SCANNER);
			final String qualifiedAntlrLexerClassName = context.getQualifiedClassName(EArtifact.ANTLR_LEXER);
			sc.add("return new " + qualifiedAntlrScannerClassName + "(this, new " + qualifiedAntlrLexerClassName + "());");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addTokenStyleImplClass(StringComposite sc) {
		sc.add("public class TokenStyleImpl extends " + ABSTRACT_TOKEN_STYLE + " {");
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
		if (OptionManager.INSTANCE.useScalesParser(context.getConcreteSyntax())) {
			sc.add("return new " + context.getQualifiedClassName(EArtifact.SCANNERLESS_PARSER) + "().getTokenNames();");
		} else {
			sc.add("return new " + context.getQualifiedClassName(EArtifact.ANTLR_PARSER) + "(null).getTokenNames();");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetDefaultStyleMethod(StringComposite sc) {
		List<TokenStyle> styles = context.getConcreteSyntax().getAllTokenStyles();
		
		sc.add("public " + I_TOKEN_STYLE + " getDefaultTokenStyle(" + STRING + " tokenName) {");
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
        sc.add("return \"" + context.getSyntaxProjectName() + "/" + context.getProjectRelativePathToSyntaxFile() + "\";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetURIMethod(StringComposite sc) {
		sc.add("public " + STRING +" getURI() {");
		sc.add("return \"" + context.getConcreteSyntax().getPackage().getNSURI() + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetConcreteSyntaxName(StringComposite sc) {
		sc.add("public " + STRING +" getSyntaxName() {");
    	sc.add("return \"" + context.getConcreteSyntax().getName() + "\";");
    	sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateParserMethod(StringComposite sc) {
		String parserClassName = context.getQualifiedClassName(EArtifact.ANTLR_PARSER);
	    if (OptionManager.INSTANCE.useScalesParser(context.getConcreteSyntax())) {
	    	parserClassName = context.getQualifiedClassName(EArtifact.SCANNERLESS_PARSER);
	    }
		
		sc.add("public " + I_TEXT_PARSER + " createParser(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("return new " + parserClassName + "().createInstance(inputStream, encoding);");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetClassesWithSyntaxMethod(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		Collection<GenClass> classesWithSyntax = generatorUtil.getClassesWithSyntax(syntax);
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
		String resolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);

		sc.add("public " + I_REFERENCE_RESOLVER_SWITCH + " getReferenceResolverSwitch() {");
		sc.add("return new " + resolverSwitchClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenResolverFactoryMethod(StringComposite sc) {
		String tokenResolverFactoryClassName = context.getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);

		sc.add("public " + I_TOKEN_RESOLVER_FACTORY + " getTokenResolverFactory() {");
		sc.add("return new " + tokenResolverFactoryClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetBracketPairsMethod(StringComposite sc) {
		
		Collection<Pair<String, String>> defaultPairs = new ArrayList<Pair<String, String>>();
		defaultPairs.add(new Pair<String, String>("{", "}"));
		defaultPairs.add(new Pair<String, String>("(", ")"));
		defaultPairs.add(new Pair<String, String>("[", "]"));
		defaultPairs.add(new Pair<String, String>("<", ">"));
		
		Collection<Pair<String, String>> foundPairs = new LinkedHashSet<Pair<String, String>>();
		findBracketPairsInCsStrings(defaultPairs, foundPairs);
		findBracketPairsInQuotedPlaceholders(defaultPairs, foundPairs);

		sc.add("public " + COLLECTION + "<" + I_BRACKET_PAIR + "> getBracketPairs() {");
		sc.add(COLLECTION + "<" + I_BRACKET_PAIR + "> result = new " + ARRAY_LIST + "<" + I_BRACKET_PAIR + ">();");
		for (Pair<String, String> foundPair : foundPairs) {
			final String left = foundPair.getLeft();
			final String right = foundPair.getRight();
			sc.add("result.add(new BracketPair(\"" + left + "\", \"" + right + "\"));");
		}
		sc.add("return result;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void findBracketPairsInCsStrings(
			Collection<Pair<String, String>> defaultPairs,
			Collection<Pair<String, String>> foundPairs) {
		List<Rule> rules = context.getConcreteSyntax().getAllRules();
		for (Rule rule : rules) {
			Collection<CsString> csStrings = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			Collection<String> csStringValues = new LinkedHashSet<String>();
			for (CsString csString : csStrings) {
				csStringValues.add(csString.getValue());
			}
			for (Pair<String, String> defaultPair : defaultPairs) {
				final String left = defaultPair.getLeft();
				final String right = defaultPair.getRight();
				if (csStringValues.contains(left) && csStringValues.contains(right)) {
					foundPairs.add(new Pair<String, String>(left, right));
				}
			}
		}
	}

	private void findBracketPairsInQuotedPlaceholders(
			Collection<Pair<String, String>> defaultPairs,
			Collection<Pair<String, String>> foundPairs) {
		List<Rule> rules = context.getConcreteSyntax().getAllRules();
		for (Rule rule : rules) {
			Collection<PlaceholderInQuotes> placeholdersInQuotes = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholder : placeholdersInQuotes) {
				final String left = placeholder.getNormalizedPrefix();
				final String right = placeholder.getNormalizedSuffix();
				for (Pair<String, String> defaultPair : defaultPairs) {
					String defaultLeft = defaultPair.getLeft();
					String defaultRight = defaultPair.getRight();
					if (defaultLeft.equals(left) && defaultRight.equals(right)) {
						foundPairs.add(new Pair<String, String>(left, right));
					}
				}
			}
		}
	}
}

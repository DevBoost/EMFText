package org.emftext.sdk.codegen.generators;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.resource.impl.AbstractTextResourcePluginMetaInformation;
import org.emftext.runtime.resource.impl.BasicTokenStyle;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.TokenStyle;

public class PluginMetaInformationGenerator extends BaseGenerator {

	private static final String I_TOKEN_RESOLVER_FACTORY = ITokenResolverFactory.class.getName();

	private static final String I_REFERENCE_RESOLVER_SWITCH = IReferenceResolverSwitch.class.getName();

	private static final String E_CLASS = EClass.class.getName();

	private static final String INPUT_STREAM = InputStream.class.getName();

	private static final String I_TEXT_PARSER = ITextParser.class.getName();

	private static final String BASIC_TOKEN_STYLE = BasicTokenStyle.class.getName();

	private static final String ABSTRACT_TEXT_RESOURCE_PLUGIN_META_INFORMATION = AbstractTextResourcePluginMetaInformation.class.getName();

	private static final String I_TOKEN_STYLE = ITokenStyle.class.getName();

	private static final String STRING = String.class.getName();

	private final static GeneratorUtil generatorUtil = new GeneratorUtil();
	private final static GenClassUtil genClassUtil = new GenClassUtil();
	
	private GenerationContext context;

	public PluginMetaInformationGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getMetaInformationClassName());
		this.context = context;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " extends " + ABSTRACT_TEXT_RESOURCE_PLUGIN_META_INFORMATION + " {");
        sc.addLineBreak();
    	addGetConcreteSyntaxName(sc);
    	addGetURIMethod(sc);
		addCreateParserMethod(sc);
		addGetClassesWithSyntaxMethod(sc);
        addGetReferenceResolverSwitchMethod(sc);
        addGetTokenResolverFactoryMethod(sc);
        addGetPathTOCSDefinitionMethod(sc);
        addGetTokenNamesMethod(sc);
        addGetDefaultStyleMethod(sc);
    	
        sc.add("}");
    	
		out.print(sc.toString());
    	return true;	
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public " + STRING +"[] getTokenNames() {");
        sc.add("return new " + context.getQualifiedParserClassName() + "(null).getTokenNames();");
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
			sc.add("return new " + BASIC_TOKEN_STYLE + "(" + color + ", " + bold + ", " + italic + ", " + strikethrough + ", " + underline + ");");
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
	}

	private void addGetURIMethod(StringComposite sc) {
		sc.add("public " + STRING +" getURI() {");
		sc.add("return \"" + context.getConcreteSyntax().getPackage().getNSURI() + "\";");
		sc.add("}");
	}

	private void addGetConcreteSyntaxName(StringComposite sc) {
		sc.add("public " + STRING +" getSyntaxName() {");
    	sc.add("return \"" + context.getConcreteSyntax().getName() + "\";");
    	sc.add("}");
	}

	private void addCreateParserMethod(StringComposite sc) {
		String parserClassName = context.getQualifiedParserClassName();
		
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
		String resolverSwitchClassName = context.getQualifiedReferenceResolverSwitchClassName();

		sc.add("public " + I_REFERENCE_RESOLVER_SWITCH + " getReferenceResolverSwitch() {");
		sc.add("return new " + resolverSwitchClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenResolverFactoryMethod(StringComposite sc) {
		String tokenResolverFactoryClassName = context.getQualifiedTokenResolverFactoryClassName();

		sc.add("public " + I_TOKEN_RESOLVER_FACTORY + " getTokenResolverFactory() {");
		sc.add("return new " + tokenResolverFactoryClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}
}

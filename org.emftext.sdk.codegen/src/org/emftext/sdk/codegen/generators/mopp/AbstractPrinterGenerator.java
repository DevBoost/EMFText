package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.StringUtil;

public abstract class AbstractPrinterGenerator extends JavaBaseGenerator {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();

	private GenClassCache genClassCache;
	
	public AbstractPrinterGenerator() {
		super();
	}

	public AbstractPrinterGenerator(GenerationContext context, ArtifactDescriptor<GenerationContext> artifact) {
		super(context, artifact);
		genClassCache = context.getConcreteSyntax().getGenClassCache();
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
		sc.add("protected void addWarningToResource(final " + STRING + " errorMessage, " + E_OBJECT + " cause) {");
		sc.add(iTextResourceClassName + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.addComment("the resource can be null if the printer is used stand alone");
		sc.add("return;");
		sc.add("}");
    	sc.add("resource.addProblem(new " + problemClassName + "(errorMessage, " + eProblemTypeClassName + ".ERROR), cause);");
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

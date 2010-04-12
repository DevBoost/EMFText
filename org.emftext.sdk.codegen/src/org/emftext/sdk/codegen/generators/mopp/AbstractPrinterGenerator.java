package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.EArtifact;
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
	
	private int tokenSpace;

	public AbstractPrinterGenerator() {
		super();
	}

	public AbstractPrinterGenerator(GenerationContext context, EArtifact artifact) {
		super(context, artifact);
		genClassCache = context.getConcreteSyntax().getGenClassCache();
		initializeTokenSpace();
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
        sc.add("return (" + referenceResolverSwitchClassName + ") new " + getClassNameHelper().getMETA_INFORMATION() + "().getReferenceResolverSwitch();");
        sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TEXT_RESOURCE() + " getResource() {");
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
		return getRepeatingString(count, '\t');
	}

	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer spaces = new StringBuffer();
		for (int i = 0; i < count; i++) {
			spaces.append(character);
		}
		return spaces.toString();
	}

	protected int getTokenSpace() {
		return tokenSpace;
	}
		
	private void initializeTokenSpace() {
		tokenSpace = OptionManager.INSTANCE.getIntegerOptionValue(getContext().getConcreteSyntax(), OptionTypes.TOKENSPACE, true, this);
		if (tokenSpace < 0) {
			tokenSpace = 1;
		}
	}
}

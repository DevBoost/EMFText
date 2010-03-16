package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.StringUtil;

public abstract class AbstractPrinterGenerator extends JavaBaseGenerator {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	private GenClassCache genClassCache;
	
	private String referenceResolverSwitchClassName;

	public AbstractPrinterGenerator() {
		super();
	}

	public AbstractPrinterGenerator(GenerationContext context, EArtifact artifact) {
		super(context, artifact);
		genClassCache = context.getConcreteSyntax().getGenClassCache();
		this.referenceResolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
	}

	protected String getMetaClassName(Rule rule) {
		if (hasMapType(rule.getMetaclass()) ) {
			return rule.getMetaclass().getQualifiedClassName();
		}
		return genClassCache.getQualifiedInterfaceName(rule.getMetaclass());
	}

	protected String getMethodName(Rule rule) {
		String className = getMetaClassName(rule);
		
		// first escape underscore with their unicode value
		className = className.replace("_", "_005f");
		// then replace package separator with underscore
		className = className.replace(".", "_");
		return "print_" +  className;
	}

	protected void addAddWarningToResourceMethod(StringComposite sc) {
		sc.add("protected void addWarningToResource(final " + STRING + " errorMessage, " + E_OBJECT + " cause) {");
		sc.add(getClassNameHelper().getI_TEXT_RESOURCE() + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the printer is used stand alone");
		sc.add("return;");
		sc.add("}");
    	sc.add("resource.addProblem(new " + getContext().getQualifiedClassName(EArtifact.PROBLEM) + "(errorMessage, " + getClassNameHelper().getE_PROBLEM_TYPE() + ".ERROR), cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addDoPrintMethod(StringComposite sc, List<Rule> rules) {
		sc.add("protected void doPrint(" + E_OBJECT + " element, " + PRINTER_WRITER + " out, " + STRING + " globaltab) {");
		sc.add("if (element == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write.\");");
		sc.add("}");
		sc.add("if (out == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write on.\");");
		sc.add("}");
		sc.addLineBreak();
		Queue<Rule> ruleQueue = new LinkedList<Rule>(rules);
		while (!ruleQueue.isEmpty()) {
			Rule rule = ruleQueue.remove();
			// check whether all subclass calls have been printed
			if (csUtil.hasSubClassesWithCS(rule.getMetaclass(),
					ruleQueue)) {
				ruleQueue.add(rule);
			} else {
				sc.add("if (element instanceof " + getMetaClassName(rule) + ") {");
				sc.add(getMethodName(rule) + "((" + getMetaClassName(rule)
						+ ") element, globaltab, out);");
				sc.add("return;");
				sc.add("}");
			}
		}
		sc.addLineBreak();
		sc.add("addWarningToResource(\"The printer can not handle \" + element.eClass().getName() + \" elements\", element);");
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

	// TODO mseifert: I think this code is also somewhere else
	protected String getAccessMethod(GenClass genClass, GenFeature genFeature) {
		if (hasMapType(genClass)) {
			return "get" + StringUtil.capitalize(genFeature.getName()) + "()";
		}
		else {
			String method = "eGet(element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "))";
			return method;
		}
	}

	// TODO mseifert: this should go somewhere else
	protected boolean hasMapType(GenClass genClass) {
		return java.util.Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName());
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
}

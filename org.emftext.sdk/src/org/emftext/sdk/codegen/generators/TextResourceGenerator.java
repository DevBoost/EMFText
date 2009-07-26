/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BASIC_E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CAST_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ELEMENT_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EMFTEXT_RUNTIME_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_PROBLEM_TYPE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTEXT_DEPENDENT_URI_FRAGMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_ELEMENT_MAPPING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXTENSION_REGISTRY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_LOCATION_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_OPTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_OPTION_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROBLEM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REFERENCE_MAPPING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REFERENCE_RESOLVE_RESULT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE_POST_PROCESSOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE_POST_PROCESSOR_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_URI_MAPPING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MANY_INVERSE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.POSITION_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOLVER_SWITCH_FIELD_NAME;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import java.io.PrintWriter;

import org.emftext.runtime.IInputStreamProcessorProvider;
import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.impl.AbstractTextResource;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Generates the resource class. The created <code>doLoad()</code> and 
 * <code>doSave()</code> methods will call the generated parser and 
 * printer.
 * 
 * @see org.emftext.runtime.resource.ITextResource
 */
public class TextResourceGenerator extends BaseGenerator {

	private ConcreteSyntax concreteSyntax;
	private String qualifiedResolverSwitchClassName;
	private String qualifiedPrinterClassName;
	private String csSyntaxName;
	private String qualifiedMetaInformationClassName;
	private String qualifiedProblemClassName;
	private String qualifiedLocationMapClassName;

	public TextResourceGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.RESOURCE));
		this.concreteSyntax = context.getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		this.qualifiedResolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
		this.qualifiedPrinterClassName = context.getQualifiedClassName(EArtifact.PRINTER);
		this.qualifiedProblemClassName = context.getQualifiedClassName(EArtifact.PROBLEM);
		this.qualifiedMetaInformationClassName = context.getQualifiedClassName(EArtifact.META_INFORMATION);
		this.qualifiedLocationMapClassName = context.getClassName(EArtifact.LOCATION_MAP);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " extends " + AbstractTextResource.class.getName() + " {");

		sc.addLineBreak();
		sc.add("private " + IReferenceResolverSwitch.class.getName() + " " + RESOLVER_SWITCH_FIELD_NAME + ";");
		sc.addLineBreak();
		
    	addFields(sc);
    	
		addConstructors(sc);
        addDoLoadMethod(sc);
        addDoSaveMethod(sc);
        addGetSyntaxNameMethod(sc);
        addGetReferenceResolverSwitchMethod(sc);
    	addGetMetaInformationMethod(sc);

    	addResetLocationMapMethod(sc);
    	addAddURIFragmentMethod(sc);
    	addRegisterContextDependentProxyMethod(sc);
    	addGetEObjectMethod(sc);
    	addGetResultElementMethod(sc);
    	addRemoveDiagnosticsMethod(sc);
    	addAttachErrorsMethod(sc);
    	addAttachWarningsMethod(sc);
    	addDoUnloadMethod(sc);
    	addRunPostProcessorsMethod(sc);
    	addLoadMethod(sc);
    	addSetURIMethod(sc);
    	addGetLocationMapMethod(sc);

    	addAddProblemMethod1(sc);
    	addAddProblemMethod2(sc);
    	addGetDiagnosticsMethod(sc);

    	addAddDefaultLoadOptionsMethod(sc);
    	addLoadOptionsMethod(sc);
    	
    	addElementBasedTextDiagnosticClass(sc);
    	addPositionBasedTestDiagnosticClass(sc);
    	
    	sc.add("}");
    	
    	out.print(sc.toString());
    	return true;
    }

	private void addPositionBasedTestDiagnosticClass(StringComposite sc) {
		sc.add("public class " + POSITION_BASED_TEXT_DIAGNOSTIC + " implements " + I_TEXT_DIAGNOSTIC + " {");
    	sc.addLineBreak();
    	sc.add("private final " + URI + " uri;");
    	sc.addLineBreak();
    	sc.add("private int column;");
    	sc.add("private int line;");
    	sc.add("private int charStart;");
    	sc.add("private int charEnd;");
    	sc.add("private " + I_PROBLEM + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + POSITION_BASED_TEXT_DIAGNOSTIC + "(" + URI + " uri, " + I_PROBLEM + " problem, int column, int line, int charStart, int charEnd) {");
    	sc.addLineBreak();
    	sc.add("super();");
    	sc.add("this.uri = uri;");
    	sc.add("this.column = column;");
    	sc.add("this.line = line;");
    	sc.add("this.charStart = charStart;");
    	sc.add("this.charEnd = charEnd;");
    	sc.add("this.problem = problem;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + I_PROBLEM + " getProblem() {");
    	sc.add("return problem;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getCharStart() {");
    	sc.add("return charStart;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getCharEnd() {");
    	sc.add("return charEnd;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getColumn() {");
    	sc.add("return column;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getLine() {");
    	sc.add("return line;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + STRING + " getLocation() {");
    	sc.add("return uri.toString();");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + STRING + " getMessage() {");
    	sc.add("return problem.getMessage();");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public boolean wasCausedBy(" + E_OBJECT + " element) {");
    	sc.add("return false;");
    	sc.add("}");
    	sc.add("}");
	}

	private void addElementBasedTextDiagnosticClass(StringComposite sc) {
		sc.add("public class " + ELEMENT_BASED_TEXT_DIAGNOSTIC + " implements " + I_TEXT_DIAGNOSTIC + " {");
    	sc.addLineBreak();
    	sc.add("private final " + I_LOCATION_MAP + " locationMap;");
    	sc.add("private final " + URI + " uri;");
    	sc.add("private final " + E_OBJECT + " element;");
    	sc.add("private final " + I_PROBLEM + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(" + I_LOCATION_MAP + " locationMap, " + URI + " uri, " + I_PROBLEM + " problem, " + E_OBJECT + " element) {");
    	sc.add("super();");
    	sc.add("this.uri = uri;");
    	sc.add("this.locationMap = locationMap;");
    	sc.add("this.element = element;");
    	sc.add("this.problem = problem;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + STRING + " getMessage() {");
    	sc.add("return problem.getMessage();");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + I_PROBLEM + " getProblem() {");
    	sc.add("return problem;");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public " + STRING + " getLocation() {");
    	sc.add("return uri.toString();");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getCharStart() {");
    	sc.add("return Math.max(0, locationMap.getCharStart(element));");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getCharEnd() {");
    	sc.add("return Math.max(0, locationMap.getCharEnd(element));");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getColumn() {");
    	sc.add("return Math.max(0, locationMap.getColumn(element));");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public int getLine() {");
    	sc.add("return Math.max(0, locationMap.getLine(element));");
    	sc.add("}");
    	sc.addLineBreak();
    	sc.add("public boolean wasCausedBy(" + E_OBJECT + " element) {");
    	sc.add("if (this.element == null) {");
    	sc.add("return false;");
    	sc.add("}");
    	sc.add("return this.element.equals(element);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addLoadOptionsMethod(StringComposite sc) {
		sc.add("// Adds a new key,value pair to the list of options. If there");
    	sc.add("// is already an option with the same key, the two values are ");
    	sc.add("// collected in a list.");
    	sc.add("private void addLoadOption(" + MAP + "<" + OBJECT + ", " + OBJECT + "> options," + OBJECT + " key, " + OBJECT + " value) {");
    	sc.add("// check if there is already an option set");
    	sc.add("if (options.containsKey(key)) {");
    	sc.add(OBJECT + " currentValue = options.get(key);");
    	sc.add("if (currentValue instanceof " + LIST + "<?>) {");
    	sc.add("// if the current value is a list, we add the new value to");
    	sc.add("// this list");
    	sc.add(LIST + "<?> currentValueAsList = (" + LIST + "<?>) currentValue;");
    	sc.add(LIST + "<" + OBJECT + "> currentValueAsObjectList = " + LIST_UTIL + ".copySafelyToObjectList(currentValueAsList);");
    	sc.add("if (value instanceof " + COLLECTION + "<?>) {");
    	sc.add("currentValueAsObjectList.addAll((" + COLLECTION + "<?>) value);");
    	sc.add("} else {");
    	sc.add("currentValueAsObjectList.add(value);");
    	sc.add("}");
    	sc.add("options.put(key, currentValueAsObjectList);");
    	sc.add("} else {");
    	sc.add("// if the current value is not a list, we create a fresh list");
    	sc.add("// and add both the old (current) and the new value to this list");
    	sc.add(LIST + "<" + OBJECT + "> newValueList = new " + ARRAY_LIST + "<" + OBJECT + ">();");
    	sc.add("newValueList.add(currentValue);");
    	sc.add("if (value instanceof " + COLLECTION + "<?>) {");
    	sc.add("newValueList.addAll((" + COLLECTION + "<?>) value);");
    	sc.add("} else {");
    	sc.add("newValueList.add(value);");
    	sc.add("}");
    	sc.add("options.put(key, newValueList);");
    	sc.add("}");
    	sc.add("} else {");
    	sc.add("options.put(key, value);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddDefaultLoadOptionsMethod(StringComposite sc) {
		sc.add("protected " + MAP + "<" + OBJECT + ", " + OBJECT + "> addDefaultLoadOptions(" + MAP + "<?, ?> loadOptions) {");
    	sc.add(MAP + "<" + OBJECT + ", " + OBJECT + "> loadOptionsCopy = " + MAP_UTIL + ".copySafelyToObjectToObjectMap(loadOptions); ");
    	sc.add("if (" + PLATFORM + ".isRunning()) {");
    	sc.add("// find default load option providers");
    	sc.add(I_EXTENSION_REGISTRY + " extensionRegistry = " + PLATFORM + ".getExtensionRegistry();");
    	sc.add(I_CONFIGURATION_ELEMENT + " configurationElements[] = extensionRegistry.getConfigurationElementsFor(" + EMFTEXT_RUNTIME_PLUGIN + ".EP_DEFAULT_LOAD_OPTIONS_ID);");
    	sc.add("for (" + I_CONFIGURATION_ELEMENT + " element : configurationElements) {");
    	sc.add("try {");
    	sc.add(STRING + " csName = element.getAttribute(" + I_OPTION_PROVIDER + ".CS_NAME);");
    	sc.add("if (getSyntaxName().equals(csName) || ARBITRARY_SYNTAX_NAME.equals(csName)) {");
    	sc.add(I_OPTION_PROVIDER + " provider = (" + I_OPTION_PROVIDER + ") element.createExecutableExtension(\"class\");");
    	sc.add("final " + MAP + "<?, ?> options = provider.getOptions();");
    	sc.add("final " + COLLECTION + "<?> keys = options.keySet();");
    	sc.add("for (" + OBJECT + " key : keys) {");
    	sc.add("addLoadOption(loadOptionsCopy, key, options.get(key));");
    	sc.add("}");
    	sc.add("} else {");
    	sc.add("continue;");
    	sc.add("}");
    	sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
    	sc.add(EMFTEXT_RUNTIME_PLUGIN + ".logError(\"Exception while getting default options.\", ce);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return loadOptionsCopy;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod1(StringComposite sc) {
		sc.add("public void addProblem(" + I_PROBLEM + " problem, " + E_OBJECT + " element) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(locationMap, getURI(), problem, element));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod2(StringComposite sc) {
		sc.add("public void addProblem(" + I_PROBLEM + " problem, int column, int line, int charStart,");
    	sc.add("int charEnd) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + POSITION_BASED_TEXT_DIAGNOSTIC + "(getURI(), problem, column, line, charStart, charEnd));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetDiagnosticsMethod(StringComposite sc) {
		sc.add("private " + LIST + "<" + DIAGNOSTIC + "> getDiagnostics(" + E_PROBLEM_TYPE + " type) {");
		sc.add("if (type == " + E_PROBLEM_TYPE + ".ERROR) {");
		sc.add("return getErrors();");
		sc.add("} else {");
		sc.add("return getWarnings();");
		sc.add("}");
		sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetLocationMapMethod(StringComposite sc) {
		sc.add("public " + I_LOCATION_MAP + " getLocationMap() {");
    	sc.add("return locationMap;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addSetURIMethod(StringComposite sc) {
		sc.add("public void setURI(" + URI  + " uri) {");
    	sc.add("//because of the context dependent proxy resolving it is ");
    	sc.add("//essential to resolve all proxies before the URI is changed");
    	sc.add("//which can cause loss of object identities");
    	sc.add(ECORE_UTIL + ".resolveAll(this);");
    	sc.add("super.setURI(uri);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addLoadMethod(StringComposite sc) {
		sc.add("public void load(" + MAP + "<?, ?> options) throws " + IO_EXCEPTION + " {");
    	sc.add(MAP + "<" + OBJECT + ", " + OBJECT + "> loadOptions = addDefaultLoadOptions(options);");
    	sc.add("super.load(loadOptions);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRunPostProcessorsMethod(StringComposite sc) {
		sc.add("protected void runPostProcessors(" + MAP + "<?, ?> loadOptions) {");
    	sc.add("if (loadOptions == null) {");
    	sc.add("return;");
    	sc.add("}");
    	sc.add(OBJECT + " resourcePostProcessorProvider = loadOptions.get(" + I_OPTIONS + ".RESOURCE_POSTPROCESSOR_PROVIDER);");
    	sc.add("if (resourcePostProcessorProvider != null) {");
    	sc.add("if (resourcePostProcessorProvider instanceof " + I_RESOURCE_POST_PROCESSOR_PROVIDER + ") {");
    	sc.add("((" + I_RESOURCE_POST_PROCESSOR_PROVIDER + ") resourcePostProcessorProvider).getResourcePostProcessor().process(this);");
    	sc.add("} else if (resourcePostProcessorProvider instanceof " + COLLECTION + "<?>) {");
    	sc.add("@SuppressWarnings(\"unchecked\")");
    	sc.add(COLLECTION + "<" + I_RESOURCE_POST_PROCESSOR_PROVIDER + "> resourcePostProcessorProviderCollection = (" + COLLECTION + "<" + I_RESOURCE_POST_PROCESSOR_PROVIDER + ">) resourcePostProcessorProvider;");
    	sc.add("for (" + I_RESOURCE_POST_PROCESSOR_PROVIDER + " processorProvider : resourcePostProcessorProviderCollection) {");
    	sc.add(I_RESOURCE_POST_PROCESSOR + " postProcessor = processorProvider.getResourcePostProcessor();");
    	sc.add("try {");
    	sc.add("postProcessor.process(this);");
    	sc.add("} catch (" + EXCEPTION + " e) {");
    	sc.add(EMFTEXT_RUNTIME_PLUGIN + ".logError(\"Exception while running a post-processor.\", e);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addDoUnloadMethod(StringComposite sc) {
		sc.add("// Extends the super implementation by clearing all information about element positions.");
    	sc.add("protected void doUnload() {");
    	sc.add("super.doUnload();");
    	sc.add("//clear concrete syntax information");
    	sc.add("resetLocationMap();");
    	sc.add("internalURIFragmentMap.clear();");
    	sc.add("proxyCounter = 0;");
    	sc.add(RESOLVER_SWITCH_FIELD_NAME + " = null;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachWarningsMethod(StringComposite sc) {
		sc.add("private void attachWarnings(" + I_REFERENCE_RESOLVE_RESULT + "<? extends " + E_OBJECT + "> result, " + E_OBJECT + " proxy) {");
    	sc.add("assert result != null;");
    	sc.add("assert result.wasResolved();");
    	sc.add("if (result.wasResolved()) {");
    	sc.add("for (" + I_REFERENCE_MAPPING + "<? extends " + E_OBJECT + "> mapping : result.getMappings()) {");
    	sc.add("final " + STRING + " warningMessage = mapping.getWarning();");
    	sc.add("if (warningMessage == null) {");
    	sc.add("continue;");
    	sc.add("}");
    	sc.add("addProblem(new " + qualifiedProblemClassName + "(warningMessage, " + E_PROBLEM_TYPE + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachErrorsMethod(StringComposite sc) {
		sc.add("private void attachErrors(" + I_REFERENCE_RESOLVE_RESULT + "<?> result, " + E_OBJECT + " proxy) {");
    	sc.add("// attach errors to resource");
    	sc.add("assert result != null;");
    	sc.add("final " + STRING + " errorMessage = result.getErrorMessage();");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addProblem(new " + qualifiedProblemClassName + "(errorMessage, " + E_PROBLEM_TYPE + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRemoveDiagnosticsMethod(StringComposite sc) {
		sc.add("private void removeDiagnostics(" + E_OBJECT + " proxy, " + LIST + "<" + DIAGNOSTIC + "> diagnostics) {");
    	sc.add("// remove errors/warnings from resource");
    	sc.add("for (" + DIAGNOSTIC + " errorCand : new " + BASIC_E_LIST + "<" + DIAGNOSTIC + ">(diagnostics)) {");
    	sc.add("if (errorCand instanceof " + I_TEXT_DIAGNOSTIC + ") {");
    	sc.add("if (((" + I_TEXT_DIAGNOSTIC + ") errorCand).wasCausedBy(proxy)) {");
    	sc.add("diagnostics.remove(errorCand);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetResultElementMethod(StringComposite sc) {
		sc.add("private " + E_OBJECT + " getResultElement(" + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + "> uriFragment, " + I_REFERENCE_MAPPING + "<? extends " + E_OBJECT + "> mapping, " + E_OBJECT + " proxy, final " + STRING + " errorMessage) {");
    	sc.add("if (mapping instanceof " + I_URI_MAPPING + "<?>) {");
    	sc.add(URI + " uri = ((" + I_URI_MAPPING + "<? extends " + E_OBJECT + ">)mapping).getTargetIdentifier();");
    	sc.add("if (uri != null) {");
    	sc.add(E_OBJECT + " result = null;");
    	sc.add("try {");
    	sc.add("result = this.getResourceSet().getEObject(uri, true);");
    	sc.add("} catch (" + EXCEPTION + " e) {");
    	sc.add("//we can catch exceptions here, because EMF will try to resolve again and handle the exception");
    	sc.add("}");
    	sc.add("if (result == null || result.eIsProxy()) {");
    	sc.add("//unable to resolve: attach error");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addProblem(new " + qualifiedProblemClassName + "(errorMessage, " + E_PROBLEM_TYPE + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return result;");
    	sc.add("}");
    	sc.add("return null;");
    	sc.add("} else if (mapping instanceof " + I_ELEMENT_MAPPING + "<?>) {");
    	sc.add(E_OBJECT + " element = ((" + I_ELEMENT_MAPPING + "<? extends " + E_OBJECT + ">)mapping).getTargetElement();");
    	sc.add(E_REFERENCE + " reference = uriFragment.getReference();");
    	sc.add(E_REFERENCE + " oppositeReference = uriFragment.getReference().getEOpposite();");
    	sc.add("if (!uriFragment.getReference().isContainment() && oppositeReference != null) {");
    	sc.add("if (reference.isMany()) {");
    	sc.add(MANY_INVERSE + "<" + E_OBJECT + "> list = " + CAST_UTIL + ".cast(element.eGet(oppositeReference, false));					");
    	sc.add("//avoids duplicate entries in the reference caused by adding to the oppositeReference ");
    	sc.add("list.basicAdd(uriFragment.getContainer(),null);");
    	sc.add("} else {");
    	sc.add("uriFragment.getContainer().eSet(uriFragment.getReference(), element);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return element;");
    	sc.add("} else {");
    	sc.add("assert(false);");
    	sc.add("return null;");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetEObjectMethod(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getEObject(String id) {");
    	sc.add("if (internalURIFragmentMap.containsKey(id)) {");
    	sc.add(I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + "> uriFragment = internalURIFragmentMap.get(id);");
    	sc.add("boolean wasResolvedBefore = uriFragment.isResolved();");
    	sc.add(I_REFERENCE_RESOLVE_RESULT + "<? extends " + E_OBJECT + "> result = uriFragment.resolve();");
    	sc.add("if (result == null) {");
    	sc.add("//the resolving did call itself");
    	sc.add("return null;");
    	sc.add("}");
    	sc.add("if (!wasResolvedBefore && !result.wasResolved()) {");
    	sc.add("attachErrors(result, uriFragment.getProxy());");
    	sc.add("return null;");
    	sc.add("} else if (!result.wasResolved()) {");
    	sc.add("return null;");
    	sc.add("} else {");
    	sc.add("//remove an error that might have been added by an earlier attempt");
    	sc.add("removeDiagnostics(uriFragment.getProxy(), getErrors());");
    	sc.add("//remove old warnings and attach new");
    	sc.add("removeDiagnostics(uriFragment.getProxy(), getWarnings());");
    	sc.add("attachWarnings(result, uriFragment.getProxy());");
    	sc.add(I_REFERENCE_MAPPING + "<? extends " + E_OBJECT + "> mapping = result.getMappings().iterator().next();");
    	sc.add("return getResultElement(uriFragment, mapping, uriFragment.getProxy(), result.getErrorMessage());");
    	sc.add("}");
    	sc.add("} else {");
    	sc.add("return super.getEObject(id);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRegisterContextDependentProxyMethod(StringComposite sc) {
		sc.add("public <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" + I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY + "<ContainerType, ReferenceType> factory, ContainerType container, " + E_REFERENCE + " reference, " + STRING + " id, " + E_OBJECT + " proxyElement) {");
    	sc.add("int pos = -1;");
    	sc.add("if (reference.isMany()) {");
    	sc.add("pos = ((" + LIST + "<?>)container.eGet(reference)).size();");
    	sc.add("}");
    	sc.add(INTERNAL_E_OBJECT + " proxy = (" + INTERNAL_E_OBJECT + ") proxyElement;");
    	sc.add(STRING + " internalURIFragment = " + I_CONTEXT_DEPENDENT_URI_FRAGMENT+ ".INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + \"_\" + id;");
    	sc.add(I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<?> uriFragment = factory.create(id, container, reference, pos, proxy);");
    	sc.add("proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));");
    	sc.add("addURIFragment(internalURIFragment, uriFragment);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddURIFragmentMethod(StringComposite sc) {
		sc.add("public void addURIFragment(" + STRING + " internalURIFragment, " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + "> uriFragment) {");
    	sc.add("internalURIFragmentMap.put(internalURIFragment, uriFragment);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addResetLocationMapMethod(StringComposite sc) {
		sc.add("protected void resetLocationMap() {");
    	sc.add("locationMap = new " + qualifiedLocationMapClassName + "();");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private static final " + STRING + " ARBITRARY_SYNTAX_NAME = \"*\";");
    	sc.add("private "+ I_LOCATION_MAP + " locationMap;");
    	sc.add("private int proxyCounter = 0;");
    	sc.add("private " + MAP + "<" + STRING + ", " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + ">> internalURIFragmentMap = new " + HASH_MAP + "<" + STRING + ", " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + ">>();");
	}

	private void addGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + ITextResourcePluginMetaInformation.class.getName() + " getMetaInformation() {");
		sc.add("return new " + qualifiedMetaInformationClassName + "();");
		sc.add("}");
	}

	private void addGetSyntaxNameMethod(StringComposite sc) {
		sc.add("protected String getSyntaxName() {");
		sc.add("return \"" + csSyntaxName + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("public " + IReferenceResolverSwitch.class.getName() + " getReferenceResolverSwitch() {");
        sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new " + qualifiedResolverSwitchClassName + "();");
        sc.add("}");
        sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addDoSaveMethod(StringComposite sc) {
		sc.add("protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add(qualifiedPrinterClassName + " printer = new " + qualifiedPrinterClassName + "(outputStream, this);");
        sc.add(IReferenceResolverSwitch.class.getName() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add("for(" + E_OBJECT + " root : getContents()) {");
        sc.add("printer.print(root);");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addConstructors(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
    	sc.add("resetLocationMap();");
		sc.add("}");
        sc.addLineBreak();
        
		sc.add("public " + getResourceClassName() + "(" + org.eclipse.emf.common.util.URI.class.getName() + " uri) {");
		sc.add("super(uri);");
    	sc.add("resetLocationMap();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addDoLoadMethod(StringComposite sc) {
		sc.add("protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add("resetLocationMap();");
        sc.add("java.lang.String encoding = null;");
        sc.add("java.io.InputStream actualInputStream = inputStream;");
        sc.add("java.lang.Object inputStreamPreProcessorProvider = null;");
        sc.add("if (options!=null) {");
		sc.add("inputStreamPreProcessorProvider = options.get(" + I_OPTIONS + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		sc.add("}");
		sc.add("if (inputStreamPreProcessorProvider != null) {");
		sc.add("if (inputStreamPreProcessorProvider instanceof " + IInputStreamProcessorProvider.class.getName() + ") {");
		sc.add(IInputStreamProcessorProvider.class.getName() + " provider = (" + IInputStreamProcessorProvider.class.getName() + ") inputStreamPreProcessorProvider;");
		sc.add(InputStreamProcessor.class.getName() + " processor = provider.getInputStreamProcessor(inputStream);");
		sc.add("actualInputStream = processor;");
		sc.add("encoding = processor.getOutputEncoding();");
		sc.add("}");
		sc.add("}");
        sc.addLineBreak();
        
        sc.add(ITextParser.class.getName() + " parser = getMetaInformation().createParser(actualInputStream, encoding);");
        sc.add("parser.setResource(this);");
        sc.add("parser.setOptions(options);");
        sc.add(IReferenceResolverSwitch.class.getName() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add(E_OBJECT + " root = parser.parse();");
        sc.add("if (root != null) {");
        sc.add("getContents().add(root);");
        sc.add("}");
        sc.add("getReferenceResolverSwitch().setOptions(options);");
        sc.add("runPostProcessors(options);");
        sc.add("}");
        sc.addLineBreak();
	}
}

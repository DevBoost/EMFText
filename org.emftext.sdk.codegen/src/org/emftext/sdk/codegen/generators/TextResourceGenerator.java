/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BASIC_E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ELEMENT_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXTENSION_REGISTRY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MANY_INVERSE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.POSITION_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOLVER_SWITCH_FIELD_NAME;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_IMPL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Generates the resource class. The created <code>doLoad()</code> and 
 * <code>doSave()</code> methods will call the generated parser and 
 * printer.
 * 
 * @see org.emftext.runtime.resource.ITextResource
 */
public class TextResourceGenerator extends JavaBaseGenerator {

	private ConcreteSyntax concreteSyntax;
	private String resolverSwitchClassName;
	private String iPrinterClassName;
	private String csSyntaxName;
	private String problemClassName;
	private String locationMapClassName;
	private String iResourcePostProcessorProviderClassName;
	private String iContextDependentURIFragmentFactoryClassName;
	private String layoutInformationAdapterClassName;
	
	private boolean saveChangedResourcesOnly = false;

	public TextResourceGenerator() {
		super();
	}

	private TextResourceGenerator(GenerationContext context) {
		super(context, EArtifact.RESOURCE);
		this.concreteSyntax = context.getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		resolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
		iPrinterClassName = context.getQualifiedClassName(EArtifact.I_TEXT_PRINTER);
		problemClassName = context.getQualifiedClassName(EArtifact.PROBLEM);
		locationMapClassName = context.getQualifiedClassName(EArtifact.LOCATION_MAP);
		iResourcePostProcessorProviderClassName = context.getQualifiedClassName(EArtifact.I_RESOURCE_POST_PROCESSOR_PROVIDER);
		iContextDependentURIFragmentFactoryClassName = context.getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		layoutInformationAdapterClassName = context.getQualifiedClassName(EArtifact.LAYOUT_INFORMATION_ADAPTER);
		saveChangedResourcesOnly = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.SAVE_CHANGED_RESOURCES_ONLY);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " extends " + RESOURCE_IMPL + " implements " + getClassNameHelper().getI_TEXT_RESOURCE() + " {");
		sc.addLineBreak();
		
    	addInnerClasses(sc);
    	addFields(sc);
		addMethods(sc);
    	
    	sc.add("}");
    	return true;
    }

	private void addInnerClasses(StringComposite sc) {
		addElementBasedTextDiagnosticClass(sc);
    	addPositionBasedTestDiagnosticClass(sc);
	}

	private void addMethods(JavaComposite sc) {
		addConstructors(sc);
        addDoLoadMethod(sc);
        addReloadMethod(sc);
        addCancelReloadMethod(sc);
        addDoSaveMethod(sc);
        
        if(saveChangedResourcesOnly) {
        	addSaveOnlyIfChangedWithMemoryBuffer(sc);
        	addGetPrint(sc);
        }
        
        addGetSyntaxNameMethod(sc);
        addGetReferenceResolverSwitchMethod(sc);
    	getContext().addGetMetaInformationMethod(sc);

    	addResetLocationMapMethod(sc);
    	addAddURIFragmentMethod(sc);
    	addRegisterContextDependentProxyMethod(sc);
    	addGetEObjectMethod(sc);
    	addReplaceProxyInLayoutAdaptersMethod(sc);
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
    	addAddErrorMethod(sc);
    	addAddWarningMethod(sc);
    	addGetDiagnosticsMethod(sc);

    	addAddDefaultLoadOptionsMethod(sc);
    	addLoadOptionsMethod(sc);
    	
    	addClearStateMethod(sc);
    	addGetContentsMethod(sc);
    	addGetWarningsMethod(sc);
    	addGetErrorsMethod(sc);
	}

	private void addPositionBasedTestDiagnosticClass(StringComposite sc) {
		sc.add("public class " + POSITION_BASED_TEXT_DIAGNOSTIC + " implements " + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + " {");
    	sc.addLineBreak();
    	sc.add("private final " + URI + " uri;");
    	sc.addLineBreak();
    	sc.add("private int column;");
    	sc.add("private int line;");
    	sc.add("private int charStart;");
    	sc.add("private int charEnd;");
    	sc.add("private " + getClassNameHelper().getI_PROBLEM() + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + POSITION_BASED_TEXT_DIAGNOSTIC + "(" + URI + " uri, " + getClassNameHelper().getI_PROBLEM() + " problem, int column, int line, int charStart, int charEnd) {");
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
    	sc.add("public " + getClassNameHelper().getI_PROBLEM() + " getProblem() {");
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
    	sc.addLineBreak();
	}

	private void addElementBasedTextDiagnosticClass(StringComposite sc) {
		sc.add("public class " + ELEMENT_BASED_TEXT_DIAGNOSTIC + " implements " + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + " {");
    	sc.addLineBreak();
    	sc.add("private final " + getClassNameHelper().getI_LOCATION_MAP() + " locationMap;");
    	sc.add("private final " + URI + " uri;");
    	sc.add("private final " + E_OBJECT + " element;");
    	sc.add("private final " + getClassNameHelper().getI_PROBLEM() + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(" + getClassNameHelper().getI_LOCATION_MAP() + " locationMap, " + URI + " uri, " + getClassNameHelper().getI_PROBLEM() + " problem, " + E_OBJECT + " element) {");
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
    	sc.add("public " + getClassNameHelper().getI_PROBLEM() + " getProblem() {");
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

	private void addLoadOptionsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds a new key,value pair to the list of options. If there " +
    		"is already an option with the same key, the two values are " +
    		"collected in a list."
    	);
    	sc.add("private void addLoadOption(" + MAP + "<" + OBJECT + ", " + OBJECT + "> options," + OBJECT + " key, " + OBJECT + " value) {");
    	sc.addComment("check if there is already an option set");
    	sc.add("if (options.containsKey(key)) {");
    	sc.add(OBJECT + " currentValue = options.get(key);");
    	sc.add("if (currentValue instanceof " + LIST + "<?>) {");
    	sc.addComment("if the current value is a list, we add the new value to this list");
    	sc.add(LIST + "<?> currentValueAsList = (" + LIST + "<?>) currentValue;");
    	sc.add(LIST + "<" + OBJECT + "> currentValueAsObjectList = " + getClassNameHelper().getLIST_UTIL() + ".copySafelyToObjectList(currentValueAsList);");
    	sc.add("if (value instanceof " + COLLECTION + "<?>) {");
    	sc.add("currentValueAsObjectList.addAll((" + COLLECTION + "<?>) value);");
    	sc.add("} else {");
    	sc.add("currentValueAsObjectList.add(value);");
    	sc.add("}");
    	sc.add("options.put(key, currentValueAsObjectList);");
    	sc.add("} else {");
    	sc.addComment(
    		"if the current value is not a list, we create a fresh list " +
    		"and add both the old (current) and the new value to this list"
    	);
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

	private void addAddDefaultLoadOptionsMethod(JavaComposite sc) {
		sc.add("protected " + MAP + "<" + OBJECT + ", " + OBJECT + "> addDefaultLoadOptions(" + MAP + "<?, ?> loadOptions) {");
    	sc.add(MAP + "<" + OBJECT + ", " + OBJECT + "> loadOptionsCopy = " + getClassNameHelper().getMAP_UTIL() + ".copySafelyToObjectToObjectMap(loadOptions);");
    	sc.add("if (" + PLATFORM + ".isRunning()) {");
    	sc.addComment("find default load option providers");
    	sc.add(I_EXTENSION_REGISTRY + " extensionRegistry = " + PLATFORM + ".getExtensionRegistry();");
    	sc.add(I_CONFIGURATION_ELEMENT + " configurationElements[] = extensionRegistry.getConfigurationElementsFor(" + getClassNameHelper().getPLUGIN_ACTIVATOR() + ".EP_DEFAULT_LOAD_OPTIONS_ID);");
    	sc.add("for (" + I_CONFIGURATION_ELEMENT + " element : configurationElements) {");
    	sc.add("try {");
    	sc.add(getClassNameHelper().getI_OPTION_PROVIDER() + " provider = (" + getClassNameHelper().getI_OPTION_PROVIDER() + ") element.createExecutableExtension(\"class\");");
    	sc.add("final " + MAP + "<?, ?> options = provider.getOptions();");
    	sc.add("final " + COLLECTION + "<?> keys = options.keySet();");
    	sc.add("for (" + OBJECT + " key : keys) {");
    	sc.add("addLoadOption(loadOptionsCopy, key, options.get(key));");
    	sc.add("}");
    	sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
    	sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"Exception while getting default options.\", ce);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return loadOptionsCopy;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod1(StringComposite sc) {
		sc.add("public void addProblem(" + getClassNameHelper().getI_PROBLEM() + " problem, " + E_OBJECT + " element) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(locationMap, getURI(), problem, element));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod2(StringComposite sc) {
		sc.add("public void addProblem(" + getClassNameHelper().getI_PROBLEM() + " problem, int column, int line, int charStart, int charEnd) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + POSITION_BASED_TEXT_DIAGNOSTIC + "(getURI(), problem, column, line, charStart, charEnd));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddErrorMethod(StringComposite sc) {
		sc.add("public void addError(" + STRING + " message, " + E_OBJECT + " cause) {");
    	sc.add("addProblem(new " + getContext().getQualifiedClassName(EArtifact.PROBLEM) + "(message, " + getContext().getQualifiedClassName(EArtifact.E_PROBLEM_TYPE) + ".ERROR), cause);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddWarningMethod(StringComposite sc) {
		sc.add("public void addWarning(" + STRING + " message, " + E_OBJECT + " cause) {");
    	sc.add("addProblem(new " + getContext().getQualifiedClassName(EArtifact.PROBLEM) + "(message, " + getContext().getQualifiedClassName(EArtifact.E_PROBLEM_TYPE) + ".WARNING), cause);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetDiagnosticsMethod(StringComposite sc) {
		sc.add("private " + LIST + "<" + DIAGNOSTIC + "> getDiagnostics(" + getClassNameHelper().getE_PROBLEM_TYPE() + " type) {");
		sc.add("if (type == " + getClassNameHelper().getE_PROBLEM_TYPE() + ".ERROR) {");
		sc.add("return getErrors();");
		sc.add("} else {");
		sc.add("return getWarnings();");
		sc.add("}");
		sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetLocationMapMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_LOCATION_MAP() + " getLocationMap() {");
    	sc.add("return locationMap;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addSetURIMethod(JavaComposite sc) {
		sc.add("public void setURI(" + URI  + " uri) {");
		sc.addComment(
			"because of the context dependent proxy resolving it is " +
    		"essential to resolve all proxies before the URI is changed " +
    		"which can cause loss of object identities"
    	);
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
    	String iOptionsClassName = getClassNameHelper().getI_OPTIONS();
    	String postProcessorClassName = getClassNameHelper().getI_RESOURCE_POST_PROCESSOR();
    	String postProcessorProviderClassName = getClassNameHelper().getI_RESOURCE_POST_PROCESSOR_PROVIDER();

    	sc.add("protected void runPostProcessors(" + MAP + "<?, ?> loadOptions) {");
    	sc.add("if (loadOptions == null) {");
    	sc.add("return;");
    	sc.add("}");
		sc.add(OBJECT + " resourcePostProcessorProvider = loadOptions.get(" + iOptionsClassName + ".RESOURCE_POSTPROCESSOR_PROVIDER);");
    	sc.add("if (resourcePostProcessorProvider != null) {");
		sc.add("if (resourcePostProcessorProvider instanceof " + postProcessorProviderClassName + ") {");
    	sc.add("((" + postProcessorProviderClassName + ") resourcePostProcessorProvider).getResourcePostProcessor().process(this);");
    	sc.add("} else if (resourcePostProcessorProvider instanceof " + COLLECTION + "<?>) {");
    	sc.add("java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;");
    	sc.add("for (Object processorProvider : resourcePostProcessorProviderCollection) {");
    	sc.add("if (processorProvider instanceof " + iResourcePostProcessorProviderClassName + ") {");
    	sc.add(iResourcePostProcessorProviderClassName + " csProcessorProvider = (" + iResourcePostProcessorProviderClassName + ") processorProvider;");
    	sc.add(postProcessorClassName + " postProcessor = csProcessorProvider.getResourcePostProcessor();");
    	sc.add("try {");
    	sc.add("postProcessor.process(this);");
    	sc.add("} catch (" + EXCEPTION + " e) {");
    	sc.add(getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR) + ".logError(\"Exception while running a post-processor.\", e);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addDoUnloadMethod(JavaComposite sc) {
		sc.addJavadoc("Extends the super implementation by clearing all information about element positions.");
    	sc.add("protected void doUnload() {");
    	sc.add("super.doUnload();");
    	sc.add("clearState();");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addClearStateMethod(JavaComposite sc) {
		sc.addJavadoc("Extends the super implementation by clearing all information about element positions.");
    	sc.add("protected void clearState() {");
    	sc.addComment("clear concrete syntax information");
    	sc.add("resetLocationMap();");
    	sc.add("internalURIFragmentMap.clear();");
    	sc.add("getErrors().clear();");
    	sc.add("getWarnings().clear();");
    	sc.add("proxyCounter = 0;");
    	sc.add(RESOLVER_SWITCH_FIELD_NAME + " = null;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachWarningsMethod(StringComposite sc) {
		sc.add("private void attachWarnings(" + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<? extends " + E_OBJECT + "> result, " + E_OBJECT + " proxy) {");
    	sc.add("assert result != null;");
    	sc.add("assert result.wasResolved();");
    	sc.add("if (result.wasResolved()) {");
    	sc.add("for (" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<? extends " + E_OBJECT + "> mapping : result.getMappings()) {");
    	sc.add("final " + STRING + " warningMessage = mapping.getWarning();");
    	sc.add("if (warningMessage == null) {");
    	sc.add("continue;");
    	sc.add("}");
    	sc.add("addProblem(new " + problemClassName + "(warningMessage, " + getClassNameHelper().getE_PROBLEM_TYPE() + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachErrorsMethod(JavaComposite sc) {
		sc.add("private void attachErrors(" + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<?> result, " + E_OBJECT + " proxy) {");
    	sc.addComment("attach errors to this resource");
    	sc.add("assert result != null;");
    	sc.add("final " + STRING + " errorMessage = result.getErrorMessage();");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addProblem(new " + problemClassName + "(errorMessage, " + getClassNameHelper().getE_PROBLEM_TYPE() + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRemoveDiagnosticsMethod(JavaComposite sc) {
		sc.add("private void removeDiagnostics(" + E_OBJECT + " proxy, " + LIST + "<" + DIAGNOSTIC + "> diagnostics) {");
    	sc.addComment("remove all errors/warnings this resource");
    	sc.add("for (" + DIAGNOSTIC + " errorCand : new " + BASIC_E_LIST + "<" + DIAGNOSTIC + ">(diagnostics)) {");
    	sc.add("if (errorCand instanceof " + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + ") {");
    	sc.add("if (((" + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + ") errorCand).wasCausedBy(proxy)) {");
    	sc.add("diagnostics.remove(errorCand);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetResultElementMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " getResultElement(" + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<? extends " + E_OBJECT + "> uriFragment, " + getClassNameHelper().getI_REFERENCE_MAPPING() + "<? extends " + E_OBJECT + "> mapping, " + E_OBJECT + " proxy, final " + STRING + " errorMessage) {");
    	sc.add("if (mapping instanceof " + getClassNameHelper().getI_URI_MAPPING() + "<?>) {");
    	sc.add(URI + " uri = ((" + getClassNameHelper().getI_URI_MAPPING() + "<? extends " + E_OBJECT + ">)mapping).getTargetIdentifier();");
    	sc.add("if (uri != null) {");
    	sc.add(E_OBJECT + " result = null;");
    	sc.add("try {");
    	sc.add("result = this.getResourceSet().getEObject(uri, true);");
    	sc.add("} catch (" + EXCEPTION + " e) {");
    	sc.addComment("we can catch exceptions here, because EMF will try to resolve again and handle the exception");
    	sc.add("}");
    	sc.add("if (result == null || result.eIsProxy()) {");
    	sc.addComment("unable to resolve: attach error");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addProblem(new " + problemClassName + "(errorMessage, " + getClassNameHelper().getE_PROBLEM_TYPE() + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return result;");
    	sc.add("}");
    	sc.add("return null;");
    	sc.add("} else if (mapping instanceof " + getClassNameHelper().getI_ELEMENT_MAPPING() + "<?>) {");
    	sc.add(E_OBJECT + " element = ((" + getClassNameHelper().getI_ELEMENT_MAPPING() + "<? extends " + E_OBJECT + ">)mapping).getTargetElement();");
    	sc.add(E_REFERENCE + " reference = uriFragment.getReference();");
    	sc.add(E_REFERENCE + " oppositeReference = uriFragment.getReference().getEOpposite();");
    	sc.add("if (!uriFragment.getReference().isContainment() && oppositeReference != null) {");
    	sc.add("if (reference.isMany()) {");
    	sc.add(MANY_INVERSE + "<" + E_OBJECT + "> list = " + getClassNameHelper().getCAST_UTIL() + ".cast(element.eGet(oppositeReference, false));					");
    	sc.addComment("avoids duplicate entries in the reference caused by adding to the oppositeReference ");
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

	private void addGetEObjectMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT + " getEObject(String id) {");
    	sc.add("if (internalURIFragmentMap.containsKey(id)) {");
    	sc.add(getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<? extends " + E_OBJECT + "> uriFragment = internalURIFragmentMap.get(id);");
    	sc.add("boolean wasResolvedBefore = uriFragment.isResolved();");
    	sc.add(getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<? extends " + E_OBJECT + "> result = uriFragment.resolve();");
    	sc.add("if (result == null) {");
    	sc.addComment("the resolving did call itself");
    	sc.add("return null;");
    	sc.add("}");
    	sc.add("if (!wasResolvedBefore && !result.wasResolved()) {");
    	sc.add("attachErrors(result, uriFragment.getProxy());");
    	sc.add("return null;");
    	sc.add("} else if (!result.wasResolved()) {");
    	sc.add("return null;");
    	sc.add("} else {");
    	sc.add(E_OBJECT + " proxy = uriFragment.getProxy();");
    	sc.addComment("remove an error that might have been added by an earlier attempt");
    	sc.add("removeDiagnostics(proxy, getErrors());");
    	sc.addComment("remove old warnings and attach new");
    	sc.add("removeDiagnostics(proxy, getWarnings());");
    	sc.add("attachWarnings(result, proxy);");
    	sc.add(getClassNameHelper().getI_REFERENCE_MAPPING() + "<? extends " + E_OBJECT + "> mapping = result.getMappings().iterator().next();");
    	sc.add(E_OBJECT + " resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());");
    	sc.add(E_OBJECT + " container = uriFragment.getContainer();");
    	sc.add("replaceProxyInLayoutAdapters(container, proxy, resultElement);");
    	sc.add("return resultElement;");
    	sc.add("}");
    	sc.add("} else {");
    	sc.add("return super.getEObject(id);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addReplaceProxyInLayoutAdaptersMethod(StringComposite sc) {
    	sc.add("protected void replaceProxyInLayoutAdapters(" + E_OBJECT + " container, " + E_OBJECT + " proxy, " + E_OBJECT + " target) {");
		sc.add("for (" + ADAPTER + " adapter : container.eAdapters()) {");
		sc.add("if (adapter instanceof " + layoutInformationAdapterClassName + ") {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = (" + layoutInformationAdapterClassName + ") adapter;");
		sc.add("layoutInformationAdapter.replaceProxy(proxy, target);");
		sc.add("}");
		sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRegisterContextDependentProxyMethod(StringComposite sc) {
		sc.add("public <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" + iContextDependentURIFragmentFactoryClassName + "<ContainerType, ReferenceType> factory, ContainerType container, " + E_REFERENCE + " reference, " + STRING + " id, " + E_OBJECT + " proxyElement) {");
    	sc.add("int pos = -1;");
    	sc.add("if (reference.isMany()) {");
    	sc.add("pos = ((" + LIST + "<?>)container.eGet(reference)).size();");
    	sc.add("}");
    	sc.add(INTERNAL_E_OBJECT + " proxy = (" + INTERNAL_E_OBJECT + ") proxyElement;");
    	sc.add(STRING + " internalURIFragment = " + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT()+ ".INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + \"_\" + id;");
    	sc.add(getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<?> uriFragment = factory.create(id, container, reference, pos, proxy);");
    	sc.add("proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));");
    	sc.add("addURIFragment(internalURIFragment, uriFragment);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddURIFragmentMethod(StringComposite sc) {
		sc.add("public void addURIFragment(" + STRING + " internalURIFragment, " + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<? extends " + E_OBJECT + "> uriFragment) {");
    	sc.add("internalURIFragmentMap.put(internalURIFragment, uriFragment);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addResetLocationMapMethod(StringComposite sc) {
		sc.add("protected void resetLocationMap() {");
    	sc.add("locationMap = new " + locationMapClassName + "();");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getClassNameHelper().getI_REFERENCE_RESOLVER_SWITCH() + " " + RESOLVER_SWITCH_FIELD_NAME + ";");
    	sc.add("private "+ getClassNameHelper().getI_LOCATION_MAP() + " locationMap;");
    	sc.add("private int proxyCounter = 0;");
    	sc.add("private " + getClassNameHelper().getI_TEXT_PARSER() + " parser;");
    	sc.add("private " + MAP + "<" + STRING + ", " + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<? extends " + E_OBJECT + ">> internalURIFragmentMap = new " + LINKED_HASH_MAP + "<" + STRING + ", " + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<? extends " + E_OBJECT + ">>();");
        if(saveChangedResourcesOnly) {
        	sc.add("private String textPrintAfterLoading = null;");
        }
    	sc.addLineBreak();
	}

	private void addGetSyntaxNameMethod(StringComposite sc) {
		sc.add("protected String getSyntaxName() {");
		sc.add("return \"" + csSyntaxName + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_REFERENCE_RESOLVER_SWITCH() + " getReferenceResolverSwitch() {");
        sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new " + resolverSwitchClassName + "();");
        sc.add("}");
        sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addDoSaveMethod(StringComposite sc) {
		sc.add("protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add(iPrinterClassName + " printer = getMetaInformation().createPrinter(outputStream, this);");
        sc.add(getClassNameHelper().getI_REFERENCE_RESOLVER_SWITCH() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add("for(" + E_OBJECT + " root : getContents()) {");
        sc.add("printer.print(root);");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}
	
	private void addSaveOnlyIfChangedWithMemoryBuffer(StringComposite sc) {
		sc.add("protected void saveOnlyIfChangedWithMemoryBuffer(" + MAP + "<?, ?> options) throws " + IO_EXCEPTION + " {");
		sc.add("String currentPrint = getPrint(options);");
		sc.add("if (textPrintAfterLoading != null && textPrintAfterLoading.equals(currentPrint)) {");
		sc.add("return;");
		sc.add("} else {");
		sc.add("super.saveOnlyIfChangedWithFileBuffer(options);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetPrint(StringComposite sc) {
		sc.add("private String getPrint("+ MAP + "<?, ?> options) throws " + IO_EXCEPTION + " {");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " outputStream = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add("doSave(outputStream, options);");
		sc.add("return outputStream.toString();");
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
		sc.add("protected void doLoad(" + INPUT_STREAM + " inputStream, " + MAP + "<?,?> options) throws " + IO_EXCEPTION + " {");
        sc.add(STRING + " encoding = null;");
        sc.add(INPUT_STREAM + " actualInputStream = inputStream;");
        sc.add(OBJECT + " inputStreamPreProcessorProvider = null;");
        sc.add("if (options!=null) {");
		sc.add("inputStreamPreProcessorProvider = options.get(" + getClassNameHelper().getI_OPTIONS() + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		sc.add("}");
		sc.add("if (inputStreamPreProcessorProvider != null) {");
		sc.add("if (inputStreamPreProcessorProvider instanceof " + getClassNameHelper().getI_INPUT_STREAM_PROCESSOR_PROVIDER() + ") {");
		sc.add(getClassNameHelper().getI_INPUT_STREAM_PROCESSOR_PROVIDER() + " provider = (" + getClassNameHelper().getI_INPUT_STREAM_PROCESSOR_PROVIDER() + ") inputStreamPreProcessorProvider;");
		sc.add(getClassNameHelper().getINPUT_STREAM_PROCESSOR() + " processor = provider.getInputStreamProcessor(inputStream);");
		sc.add("actualInputStream = processor;");
		sc.add("encoding = processor.getOutputEncoding();");
		sc.add("}");
		sc.add("}");
        sc.addLineBreak();
        
        sc.add("parser = getMetaInformation().createParser(actualInputStream, encoding);");
        sc.add("parser.setOptions(options);");
        sc.add(getClassNameHelper().getI_REFERENCE_RESOLVER_SWITCH() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add(getClassNameHelper().getI_PARSE_RESULT() + " result = parser.parse();");
        sc.add("clearState();");
    	sc.add("getContents().clear();");
        sc.add("if (result != null) {");
        sc.add(E_OBJECT + " root = result.getRoot();");
        sc.add("if (root != null) {");
        sc.add("getContents().add(root);");
        sc.add("}");
        sc.add(COLLECTION + "<" + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">> commands = result.getPostParseCommands();");
        sc.add("if (commands != null) {");
        sc.add("for (" + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">  command : commands) {");
        sc.add("command.execute(this);");
        sc.add("}");
        sc.add("}");
        sc.add("}");
        sc.add("getReferenceResolverSwitch().setOptions(options);");
        sc.add("if (getErrors().isEmpty()) {");
        sc.add("runPostProcessors(options);");
        sc.add("}");
        if(saveChangedResourcesOnly) {
        	sc.add("textPrintAfterLoading = getPrint(options);");
        }
        sc.add("}");
        sc.addLineBreak();
	}

	private void addReloadMethod(JavaComposite sc) {
		sc.add("public void reload(" + INPUT_STREAM + " inputStream, " + MAP + "<?,?> options) throws " + IO_EXCEPTION + " {");
        sc.add("try {");
        sc.add("isLoaded = false;");
        sc.add(MAP + "<" + OBJECT + ", " + OBJECT + "> loadOptions = addDefaultLoadOptions(options);");
        sc.add("doLoad(inputStream, loadOptions);");
        sc.add("} catch (" + getClassNameHelper().getTERMINATE_PARSING_EXCEPTION() + " tpe) {");
        sc.addComment("do nothing - the resource is left unchanged if this exception is thrown");
        sc.add("}");
        sc.add("isLoaded = true;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCancelReloadMethod(StringComposite sc) {
		sc.add("public void cancelReload() {");
        sc.add(getClassNameHelper().getI_TEXT_PARSER() + " parserCopy = parser;");
        sc.add("parserCopy.terminate();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetContentsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + E_OBJECT + "> getContents() {");
        sc.add("return new " + getClassNameHelper().getCOPIED_E_OBJECT_INTERNAL_E_LIST() + "((" + INTERNAL_E_LIST + "<" + E_OBJECT + ">) super.getContents());");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetWarningsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + DIAGNOSTIC + "> getWarnings() {");
        sc.add("return new " + getClassNameHelper().getCOPIED_E_LIST() + "<" + DIAGNOSTIC + ">(super.getWarnings());");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetErrorsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + DIAGNOSTIC + "> getErrors() {");
        sc.add("return new " + getClassNameHelper().getCOPIED_E_LIST() + "<" + DIAGNOSTIC + ">(super.getErrors());");
        sc.add("}");
        sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new TextResourceGenerator(context);
	}
}

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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BASIC_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CONSTRAINT_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DIAGNOSTICIAN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ELEMENT_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.EVALUATION_MODE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_BATCH_VALIDATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_EXTENSION_REGISTRY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MANY_INVERSE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MODEL_VALIDATION_SERVICE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.POSITION_BASED_TEXT_DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOLVER_SWITCH_FIELD_NAME;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.THROWABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Generates the resource class. The created <code>doLoad()</code> and 
 * <code>doSave()</code> methods will call the generated parser and 
 * printer.
 * 
 * @see org.emftext.runtime.resource.ITextResource
 */
public class TextResourceGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private ConcreteSyntax concreteSyntax;
	private String csSyntaxName;
	private boolean saveChangedResourcesOnly = false;

	@Override
	public void generateJavaContents(JavaComposite sc) {
		this.concreteSyntax = getContext().getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		saveChangedResourcesOnly = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.SAVE_CHANGED_RESOURCES_ONLY);
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " extends " + RESOURCE_IMPL + " implements " + iTextResourceClassName + " {");
		sc.addLineBreak();
		
    	addInnerClasses(sc);
    	addFields(sc);
		addMethods(sc);
    	
    	sc.add("}");
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
        
        if (saveChangedResourcesOnly) {
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
    	addRunValidatorsMethods(sc);
	}

	private void addRunValidatorsMethods(JavaComposite sc) {
		boolean disableEValidators = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.DISABLE_EVALIDATORS);
		boolean disableEMFValidationConstraints = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS);
		
		sc.add("private void runValidators(" + E_OBJECT + " root) {");
		if (!disableEValidators) {
			sc.addComment("check constraints provided by EMF validator classes");
			sc.add(DIAGNOSTIC + " diagnostics = " + DIAGNOSTICIAN + ".INSTANCE.validate(root);");
			sc.add("addDiagnostics(diagnostics, root);");
		} else {
			sc.addComment("checking constraints provided by EMF validator classes was disabled");
		}
		if (!disableEMFValidationConstraints) {
			sc.addComment("check EMF validation constraints");
			sc.addComment("EMF validation does not work if OSGi is not running");
			sc.add("if (" + PLATFORM + ".isRunning()) {");
			sc.addComment(
				"The EMF validation framework code throws a NPE if the validation plug-in is not loaded. " +
				"This is a bug, which is fixed in the helios release. Nonetheless, we need to catch the " +
				"exception here."
			);
			sc.add("try {");
			sc.add(MODEL_VALIDATION_SERVICE + " service = " + MODEL_VALIDATION_SERVICE + ".getInstance();");
			sc.add(I_BATCH_VALIDATOR + " validator = (" + I_BATCH_VALIDATOR + ") service.newValidator(" + EVALUATION_MODE + ".BATCH);");
			sc.add("validator.setIncludeLiveConstraints(true);");
			sc.add(I_STATUS + " status = validator.validate(root);");
			sc.add("addStatus(status, root);");
			sc.add("} catch (" + THROWABLE + " t) {");
			sc.add(pluginActivatorClassName + ".logError(\"Exception while checking contraints provided by EMF validator classes.\", t);");
			sc.add("}");
			sc.add("}");
		} else {
			sc.addComment("checking EMF validation constraints was disabled");
		}
		sc.add("}");
		sc.addLineBreak();

		if (!disableEValidators) {
			addAddDiagnosticsMethod(sc);
		}
		if (!disableEMFValidationConstraints) {
			addAddStatusMethod(sc);
		}
	}

	private void addAddDiagnosticsMethod(JavaComposite sc) {
		sc.add("private void addDiagnostics(" + DIAGNOSTIC + " diagnostics, " + E_OBJECT + " root) {");
		sc.add(E_OBJECT + " cause = root;");
		sc.add(LIST + "<?> data = diagnostics.getData();");
		sc.add("if (data != null && data.size() > 0) {");
		sc.add(OBJECT + " causeObject = data.get(0);");
		sc.add("if (causeObject instanceof " + E_OBJECT + ") {");
		sc.add("cause = (" + E_OBJECT + ") causeObject;");
		sc.add("}");
		sc.add("}");
		sc.add(LIST + "<" + DIAGNOSTIC + "> children = diagnostics.getChildren();");
		sc.add("if (children.size() == 0) {");
		sc.add("if (diagnostics.getSeverity() == " + I_STATUS + ".ERROR) {");
		sc.add("addError(diagnostics.getMessage(), cause);");
		sc.add("}");
		sc.add("if (diagnostics.getSeverity() == " + I_STATUS + ".WARNING) {");
		sc.add("addWarning(diagnostics.getMessage(), cause);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + DIAGNOSTIC + " diagnostic : children) {");
		sc.add("addDiagnostics(diagnostic, root);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddStatusMethod(JavaComposite sc) {
		sc.add("private void addStatus(" + I_STATUS + " status, " + E_OBJECT + " root) {");
		sc.add(LIST + "<" + E_OBJECT + "> causes = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add("causes.add(root);");
		sc.add("if (status instanceof " + CONSTRAINT_STATUS + ") {");
		sc.add(CONSTRAINT_STATUS + " constraintStatus = (" + CONSTRAINT_STATUS + ") status;");
		sc.add(SET + "<" + E_OBJECT + "> resultLocus = constraintStatus.getResultLocus();");
		sc.add("causes.clear();");
		sc.add("causes.addAll(resultLocus);");
		sc.add("}");
		sc.add("if (status.getSeverity() == " + I_STATUS + ".ERROR) {");
		sc.add("for (" + E_OBJECT + " cause : causes) {");
		sc.add("addError(status.getMessage(), cause);");
		sc.add("}");
		sc.add("}");
		sc.add("if (status.getSeverity() == " + I_STATUS + ".WARNING) {");
		sc.add("for (" + E_OBJECT + " cause : causes) {");
		sc.add("addWarning(status.getMessage(), cause);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + I_STATUS + " child : status.getChildren()) {");
		sc.add("addStatus(child, root);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPositionBasedTestDiagnosticClass(StringComposite sc) {
		sc.add("public class " + POSITION_BASED_TEXT_DIAGNOSTIC + " implements " + iTextDiagnosticClassName + " {");
    	sc.addLineBreak();
    	sc.add("private final " + URI + " uri;");
    	sc.addLineBreak();
    	sc.add("private int column;");
    	sc.add("private int line;");
    	sc.add("private int charStart;");
    	sc.add("private int charEnd;");
    	sc.add("private " + iProblemClassName + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + POSITION_BASED_TEXT_DIAGNOSTIC + "(" + URI + " uri, " + iProblemClassName + " problem, int column, int line, int charStart, int charEnd) {");
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
    	sc.add("public " + iProblemClassName + " getProblem() {");
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
		sc.add("public class " + ELEMENT_BASED_TEXT_DIAGNOSTIC + " implements " + iTextDiagnosticClassName + " {");
    	sc.addLineBreak();
    	sc.add("private final " + iLocationMapClassName + " locationMap;");
    	sc.add("private final " + URI + " uri;");
    	sc.add("private final " + E_OBJECT + " element;");
    	sc.add("private final " + iProblemClassName + " problem;");
    	sc.addLineBreak();
    	sc.add("public " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(" + iLocationMapClassName + " locationMap, " + URI + " uri, " + iProblemClassName + " problem, " + E_OBJECT + " element) {");
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
    	sc.add("public " + iProblemClassName + " getProblem() {");
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
    	sc.add(LIST + "<" + OBJECT + "> currentValueAsObjectList = " + listUtilClassName + ".copySafelyToObjectList(currentValueAsList);");
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
    	sc.add(MAP + "<" + OBJECT + ", " + OBJECT + "> loadOptionsCopy = " + mapUtilClassName + ".copySafelyToObjectToObjectMap(loadOptions);");
    	sc.add("if (" + PLATFORM + ".isRunning()) {");
    	sc.addComment("find default load option providers");
    	sc.add(I_EXTENSION_REGISTRY + " extensionRegistry = " + PLATFORM + ".getExtensionRegistry();");
    	sc.add(I_CONFIGURATION_ELEMENT + " configurationElements[] = extensionRegistry.getConfigurationElementsFor(" + pluginActivatorClassName + ".EP_DEFAULT_LOAD_OPTIONS_ID);");
    	sc.add("for (" + I_CONFIGURATION_ELEMENT + " element : configurationElements) {");
    	sc.add("try {");
    	sc.add(iOptionProviderClassName + " provider = (" + iOptionProviderClassName + ") element.createExecutableExtension(\"class\");");
    	sc.add("final " + MAP + "<?, ?> options = provider.getOptions();");
    	sc.add("final " + COLLECTION + "<?> keys = options.keySet();");
    	sc.add("for (" + OBJECT + " key : keys) {");
    	sc.add("addLoadOption(loadOptionsCopy, key, options.get(key));");
    	sc.add("}");
    	sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
    	sc.add(pluginActivatorClassName + ".logError(\"Exception while getting default options.\", ce);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return loadOptionsCopy;");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod1(StringComposite sc) {
		sc.add("public void addProblem(" + iProblemClassName + " problem, " + E_OBJECT + " element) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(locationMap, getURI(), problem, element));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddProblemMethod2(StringComposite sc) {
		sc.add("public void addProblem(" + iProblemClassName + " problem, int column, int line, int charStart, int charEnd) {");
    	sc.add("getDiagnostics(problem.getType()).add(new " + POSITION_BASED_TEXT_DIAGNOSTIC + "(getURI(), problem, column, line, charStart, charEnd));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddErrorMethod(StringComposite sc) {
		sc.add("public void addError(" + STRING + " message, " + E_OBJECT + " cause) {");
    	sc.add("addProblem(new " + problemClassName + "(message, " + eProblemTypeClassName + ".ERROR), cause);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddWarningMethod(StringComposite sc) {
		sc.add("public void addWarning(" + STRING + " message, " + E_OBJECT + " cause) {");
    	sc.add("addProblem(new " + problemClassName + "(message, " + eProblemTypeClassName + ".WARNING), cause);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetDiagnosticsMethod(StringComposite sc) {
		sc.add("private " + LIST + "<" + RESOURCE_DIAGNOSTIC + "> getDiagnostics(" + eProblemTypeClassName + " type) {");
		sc.add("if (type == " + eProblemTypeClassName + ".ERROR) {");
		sc.add("return getErrors();");
		sc.add("} else {");
		sc.add("return getWarnings();");
		sc.add("}");
		sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetLocationMapMethod(StringComposite sc) {
		sc.add("public " + iLocationMapClassName + " getLocationMap() {");
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
    	sc.add("protected void runPostProcessors(" + MAP + "<?, ?> loadOptions) {");
    	sc.add("if (loadOptions == null) {");
    	sc.add("return;");
    	sc.add("}");
		sc.add(OBJECT + " resourcePostProcessorProvider = loadOptions.get(" + iOptionsClassName + ".RESOURCE_POSTPROCESSOR_PROVIDER);");
    	sc.add("if (resourcePostProcessorProvider != null) {");
		sc.add("if (resourcePostProcessorProvider instanceof " + iResourcePostProcessorProviderClassName + ") {");
    	sc.add("((" + iResourcePostProcessorProviderClassName + ") resourcePostProcessorProvider).getResourcePostProcessor().process(this);");
    	sc.add("} else if (resourcePostProcessorProvider instanceof " + COLLECTION + "<?>) {");
    	sc.add("java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;");
    	sc.add("for (Object processorProvider : resourcePostProcessorProviderCollection) {");
    	sc.add("if (processorProvider instanceof " + iResourcePostProcessorProviderClassName + ") {");
    	sc.add(iResourcePostProcessorProviderClassName + " csProcessorProvider = (" + iResourcePostProcessorProviderClassName + ") processorProvider;");
    	sc.add(iResourcePostProcessorClassName + " postProcessor = csProcessorProvider.getResourcePostProcessor();");
    	sc.add("try {");
    	sc.add("postProcessor.process(this);");
    	sc.add("} catch (" + EXCEPTION + " e) {");
    	sc.add(pluginActivatorClassName + ".logError(\"Exception while running a post-processor.\", e);");
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
		sc.add("private void attachWarnings(" + iReferenceResolveResultClassName + "<? extends " + E_OBJECT + "> result, " + E_OBJECT + " proxy) {");
    	sc.add("assert result != null;");
    	sc.add("assert result.wasResolved();");
    	sc.add("if (result.wasResolved()) {");
    	sc.add("for (" + iReferenceMappingClassName + "<? extends " + E_OBJECT + "> mapping : result.getMappings()) {");
    	sc.add("final " + STRING + " warningMessage = mapping.getWarning();");
    	sc.add("if (warningMessage == null) {");
    	sc.add("continue;");
    	sc.add("}");
    	sc.add("addProblem(new " + problemClassName + "(warningMessage, " + eProblemTypeClassName + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachErrorsMethod(JavaComposite sc) {
		sc.add("private void attachErrors(" + iReferenceResolveResultClassName + "<?> result, " + E_OBJECT + " proxy) {");
    	sc.addComment("attach errors to this resource");
    	sc.add("assert result != null;");
    	sc.add("final " + STRING + " errorMessage = result.getErrorMessage();");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addProblem(new " + problemClassName + "(errorMessage, " + eProblemTypeClassName + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addRemoveDiagnosticsMethod(JavaComposite sc) {
		sc.add("private void removeDiagnostics(" + E_OBJECT + " proxy, " + LIST + "<" + RESOURCE_DIAGNOSTIC + "> diagnostics) {");
    	sc.addComment("remove all errors/warnings this resource");
    	sc.add("for (" + RESOURCE_DIAGNOSTIC + " errorCand : new " + BASIC_E_LIST + "<" + RESOURCE_DIAGNOSTIC + ">(diagnostics)) {");
    	sc.add("if (errorCand instanceof " + iTextDiagnosticClassName + ") {");
    	sc.add("if (((" + iTextDiagnosticClassName + ") errorCand).wasCausedBy(proxy)) {");
    	sc.add("diagnostics.remove(errorCand);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetResultElementMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " getResultElement(" + iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT + "> uriFragment, " + iReferenceMappingClassName + "<? extends " + E_OBJECT + "> mapping, " + E_OBJECT + " proxy, final " + STRING + " errorMessage) {");
    	sc.add("if (mapping instanceof " + iUriMappingClassName + "<?>) {");
    	sc.add(URI + " uri = ((" + iUriMappingClassName + "<? extends " + E_OBJECT + ">)mapping).getTargetIdentifier();");
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
    	sc.add("addProblem(new " + problemClassName + "(errorMessage, " + eProblemTypeClassName + ".ERROR), proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("return result;");
    	sc.add("}");
    	sc.add("return null;");
    	sc.add("} else if (mapping instanceof " + iElementMappingClassName + "<?>) {");
    	sc.add(E_OBJECT + " element = ((" + iElementMappingClassName + "<? extends " + E_OBJECT + ">)mapping).getTargetElement();");
    	sc.add(E_REFERENCE + " reference = uriFragment.getReference();");
    	sc.add(E_REFERENCE + " oppositeReference = uriFragment.getReference().getEOpposite();");
    	sc.add("if (!uriFragment.getReference().isContainment() && oppositeReference != null) {");
    	sc.add("if (reference.isMany()) {");
    	sc.add(MANY_INVERSE + "<" + E_OBJECT + "> list = " + castUtilClassName + ".cast(element.eGet(oppositeReference, false));					");
    	sc.addComment("avoids duplicate entries in the reference caused by adding to the oppositeReference");
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
    	sc.add(iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT + "> uriFragment = internalURIFragmentMap.get(id);");
    	sc.add("boolean wasResolvedBefore = uriFragment.isResolved();");
    	sc.add(iReferenceResolveResultClassName + "<? extends " + E_OBJECT + "> result = uriFragment.resolve();");
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
    	sc.add(iReferenceMappingClassName + "<? extends " + E_OBJECT + "> mapping = result.getMappings().iterator().next();");
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
		sc.add("public <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" + iContextDependentUriFragmentFactoryClassName + "<ContainerType, ReferenceType> factory, ContainerType container, " + E_REFERENCE + " reference, " + STRING + " id, " + E_OBJECT + " proxyElement) {");
    	sc.add("int pos = -1;");
    	sc.add("if (reference.isMany()) {");
    	sc.add("pos = ((" + LIST + "<?>)container.eGet(reference)).size();");
    	sc.add("}");
    	sc.add(INTERNAL_E_OBJECT + " proxy = (" + INTERNAL_E_OBJECT + ") proxyElement;");
    	sc.add(STRING + " internalURIFragment = " + iContextDependentUriFragmentClassName+ ".INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + \"_\" + id;");
    	sc.add(iContextDependentUriFragmentClassName + "<?> uriFragment = factory.create(id, container, reference, pos, proxy);");
    	sc.add("proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));");
    	sc.add("addURIFragment(internalURIFragment, uriFragment);");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddURIFragmentMethod(StringComposite sc) {
		sc.add("public void addURIFragment(" + STRING + " internalURIFragment, " + iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT + "> uriFragment) {");
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
		sc.add("private " + iReferenceResolverSwitchClassName + " " + RESOLVER_SWITCH_FIELD_NAME + ";");
    	sc.add("private "+ iLocationMapClassName + " locationMap;");
    	sc.add("private int proxyCounter = 0;");
    	sc.add("private " + iTextParserClassName + " parser;");
    	sc.add("private " + MAP + "<" + STRING + ", " + iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT + ">> internalURIFragmentMap = new " + LINKED_HASH_MAP + "<" + STRING + ", " + iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT + ">>();");
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
		sc.add("public " + iReferenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new " + referenceResolverSwitchClassName + "();");
        sc.add("}");
        sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addDoSaveMethod(StringComposite sc) {
		sc.add("protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add(iTextPrinterClassName + " printer = getMetaInformation().createPrinter(outputStream, this);");
        sc.add(iReferenceResolverSwitchClassName + " referenceResolverSwitch = getReferenceResolverSwitch();");
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
        
		sc.add("public " + getResourceClassName() + "(" + URI + " uri) {");
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
		sc.add("inputStreamPreProcessorProvider = options.get(" + iOptionsClassName + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		sc.add("}");
		sc.add("if (inputStreamPreProcessorProvider != null) {");
		sc.add("if (inputStreamPreProcessorProvider instanceof " + iInputStreamProcessorProviderClassName + ") {");
		sc.add(iInputStreamProcessorProviderClassName + " provider = (" + iInputStreamProcessorProviderClassName + ") inputStreamPreProcessorProvider;");
		sc.add(inputStreamProcessorClassName + " processor = provider.getInputStreamProcessor(inputStream);");
		sc.add("actualInputStream = processor;");
		sc.add("encoding = processor.getOutputEncoding();");
		sc.add("}");
		sc.add("}");
        sc.addLineBreak();
        
        sc.add("parser = getMetaInformation().createParser(actualInputStream, encoding);");
        sc.add("parser.setOptions(options);");
        sc.add(iReferenceResolverSwitchClassName + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add(iParseResultClassName + " result = parser.parse();");
        sc.add("clearState();");
    	sc.add("getContents().clear();");
        sc.add(E_OBJECT + " root = null;");
        sc.add("if (result != null) {");
        sc.add("root = result.getRoot();");
        sc.add("if (root != null) {");
        sc.add("getContents().add(root);");
        sc.add("}");
        sc.add(COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> commands = result.getPostParseCommands();");
        sc.add("if (commands != null) {");
        sc.add("for (" + iCommandClassName + "<" + iTextResourceClassName + ">  command : commands) {");
        sc.add("command.execute(this);");
        sc.add("}");
        sc.add("}");
        sc.add("}");
        sc.add("getReferenceResolverSwitch().setOptions(options);");
        sc.add("if (getErrors().isEmpty()) {");
        sc.add("runPostProcessors(options);");
        sc.add("if (root != null) {");
        sc.add("runValidators(root);");
        sc.add("}");
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
        sc.add("} catch (" + terminateParsingExceptionClassName + " tpe) {");
        sc.addComment("do nothing - the resource is left unchanged if this exception is thrown");
        sc.add("}");
        sc.add("isLoaded = true;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCancelReloadMethod(StringComposite sc) {
		sc.add("public void cancelReload() {");
        sc.add(iTextParserClassName + " parserCopy = parser;");
        sc.add("parserCopy.terminate();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetContentsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + E_OBJECT + "> getContents() {");
        sc.add("return new " + copiedEObjectInternalEListClassName + "((" + INTERNAL_E_LIST + "<" + E_OBJECT + ">) super.getContents());");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetWarningsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + RESOURCE_DIAGNOSTIC + "> getWarnings() {");
        sc.add("return new " + copiedEListClassName + "<" + RESOURCE_DIAGNOSTIC + ">(super.getWarnings());");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetErrorsMethod(StringComposite sc) {
		sc.add("public " + E_LIST + "<" + RESOURCE_DIAGNOSTIC + "> getErrors() {");
        sc.add("return new " + copiedEListClassName + "<" + RESOURCE_DIAGNOSTIC + ">(super.getErrors());");
        sc.add("}");
        sc.addLineBreak();
	}
}

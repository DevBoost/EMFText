/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.BASIC_E_LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.DIAGNOSTICIAN;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.MANY_INVERSE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.NOTIFICATION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_IMPL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionsGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

/**
 * Generates the resource class. The created <code>doLoad()</code> and
 * <code>doSave()</code> methods will call the generated parser and printer.
 */
@SyntaxDependent
public class TextResourceGenerator extends
		JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String RESOLVER_SWITCH_FIELD_NAME = "resolverSwitch";

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	private ConcreteSyntax concreteSyntax;
	private String csSyntaxName;
	private boolean saveChangedResourcesOnly = false;
	private boolean removeEclipseDependentCode = false;

	@Override
	public void generateJavaContents(JavaComposite sc) {
		this.concreteSyntax = getContext().getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		saveChangedResourcesOnly = OptionManager.INSTANCE
				.getBooleanOptionValue(concreteSyntax,
						OptionTypes.SAVE_CHANGED_RESOURCES_ONLY);
		removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.add("public class " + getResourceClassName() + " extends "
				+ RESOURCE_IMPL(sc) + " implements " + iTextResourceClassName
				+ " {");
		sc.addLineBreak();
		addInnerClasses(sc);
		addFields(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addInnerClasses(JavaComposite sc) {
		addElementBasedTextDiagnosticClass(sc);
		addPositionBasedTextDiagnosticClass(sc);
	}

	private void addMethods(JavaComposite jc) {
		GenerationContext context = getContext();
		addConstructors(jc);
		addDoLoadMethod(jc);
		addUnloadAndClearContentsMethod(jc);
		addProcessTerminationRequestedMethod(jc);
		addNotifyDelayedMethod(jc);
		addENotifyMethod(jc);
		addReloadMethod(jc);
		addCancelReloadMethod(jc);
		addDoSaveMethod(jc);

		if (saveChangedResourcesOnly) {
			addSaveOnlyIfChangedWithMemoryBuffer(jc);
			addGetPrint(jc);
		}
		addGetSyntaxNameMethod(jc);
		addGetEncoding(jc);
		addGetReferenceResolverSwitchMethod(jc);
		generatorUtil.addGetMetaInformationMethod(jc, context);
		addResetLocationMapMethod(jc);
		addAddURIFragmentMethod(jc);
		addRegisterContextDependentProxyMethod(jc);
		addGetEObjectMethod(jc);
		addReplaceProxyInLayoutAdaptersMethod(jc);
		addGetResultElementMethod(jc);
		addRemoveDiagnosticsMethod(jc);
		addAttachResolveErrorMethod(jc);
		addAttachResolveWarningsMethod(jc);
		addDoUnloadMethod(jc);
		addRunPostProcessorsMethod(jc);
		addRunPostProcessorMethod(jc);
		addLoadMethod(jc);
		addResolveAfterParsingMethod(jc);
		addSetURIMethod(jc);
		addGetLocationMapMethod(jc);
		addAddProblemMethod1(jc);
		addAddProblemMethod2(jc);
		addAddQuickFixesToQuickFixMap(jc);
		addAddErrorMethod1(jc);
		addAddErrorMethod2(jc);
		addAddWarningMethod1(jc);
		addAddWarningMethod2(jc);
		addGetDiagnosticsMethod(jc);
		addAddDefaultLoadOptionsMethod(jc);
		addClearStateMethod(jc);
		addGetContentsMethod(jc);
		addGetContentsInternalMethod(jc);
		addGetWarningsMethod(jc);
		addGetErrorsMethod(jc);
		addHasErrorsMethod(jc);
		addRunValidatorsMethods(jc);
		addGetQuickFixMethod(jc);
		addMarkMethod(jc);
		addUnmarkMethod1(jc);
		addUnmarkMethod2(jc);
		addGetMarkerHelperMethod(jc);

		generatorUtil.addIsMarkerCreationEnabledMethod(jc, context, "loadOptions");
		generatorUtil.addIsLocationMapEnabledMethod(jc, context, "loadOptions");
		generatorUtil.addIsLayoutInformationRecordingEnabled(jc, context, "loadOptions");
	}

	private void addUnloadAndClearContentsMethod(JavaComposite sc) {
		sc.add("protected void unloadAndClearContents() {");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> contentsInternal = getContentsInternal();");
		sc.addComment("unload the root objects");
		sc.add("for (" + E_OBJECT(sc) + " eObject : contentsInternal) {");
		sc.add("if (eObject instanceof " + INTERNAL_E_OBJECT(sc) + ") {");
		sc.add("unloaded((" + INTERNAL_E_OBJECT(sc) + ") eObject);");
		sc.add("}");
		sc.add("}");
		sc.addComment("unload all children using the super class method");
		sc.add("unload();");
		sc.addComment("now we can clear the contents");
		sc.add("contentsInternal.clear();");
		sc.add("}");
		sc.addLineBreak();
	} 

	private void addRunValidatorsMethods(JavaComposite sc) {
		boolean disableEValidators = OptionManager.INSTANCE
				.getBooleanOptionValue(concreteSyntax,
						OptionTypes.DISABLE_EVALIDATORS);
		boolean disableEMFValidationConstraints = OptionManager.INSTANCE
				.getBooleanOptionValue(concreteSyntax,
						OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS)  && !removeEclipseDependentCode;

		sc.add("protected void runValidators(" + E_OBJECT(sc) + " root) {");
		if (!disableEValidators) {
			sc.addComment("Check constraints provided by EMF Validator classes");
			// We need to use the qualified name for the Diagnostic class here,
			// because the super class of the generated TextResource class is
			// org.eclipse.emf.ecore.resource.Resource which does contain an
			// inner class Diagnostic that overrides the imports.
			sc.add(DIAGNOSTIC(null) + " diagnostics = " + DIAGNOSTICIAN(sc)
					+ ".INSTANCE.validate(root);");
			sc.add("addDiagnostics(diagnostics, root);");
		} else {
			sc.addComment("checking constraints provided by EMF validator classes was disabled by option '" + OptionTypes.DISABLE_EVALIDATORS.getLiteral() + "'.");
		}
		sc.addLineBreak();
		if (!disableEMFValidationConstraints && !removeEclipseDependentCode) {
			sc.add("if (new " + runtimeUtilClassName + "().isEclipsePlatformAvailable()) {");
			sc.add("if (loadOptions == null || !Boolean.TRUE.equals(loadOptions.get(" + iOptionsClassName + "." + IOptionsGenerator.DISABLE_EMF_VALIDATION + "))) {");
			sc.addComment(
				"We do only evaluate batch constraints when the resource is loaded for the first time. " +
				"If the resource is reloaded, only live constraints are evaluated."
			);
			sc.add("boolean includeBatchConstraints = !this.isReloading;");
			sc.add("new " + eclipseProxyClassName + "().checkEMFValidationConstraints(this, root, includeBatchConstraints);");
			sc.add("}");
			sc.add("}");
		} else {
			sc.addComment("checking EMF validation constraints was disabled either by option '" + OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS.getLiteral() + "' or '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "'.");
		}
		sc.add("}");
		sc.addLineBreak();

		if (!disableEValidators) {
			addAddDiagnosticsMethod(sc);
		}
	}

	private void addAddDiagnosticsMethod(JavaComposite sc) {
		// We need to use the qualified name for the Diagnostic class here,
		// because the super class of the generated TextResource class is
		// org.eclipse.emf.ecore.resource.Resource which does contain an
		// inner class Diagnostic that overrides the imports.
		String diagnosticsClassName = DIAGNOSTIC(null);
		sc.add("protected void addDiagnostics(" + diagnosticsClassName + " diagnostics, "
				+ E_OBJECT(sc) + " root) {");
		sc.add(E_OBJECT(sc) + " cause = root;");
		sc.add(LIST(sc) + "<?> data = diagnostics.getData();");
		sc.add("if (data != null && data.size() > 0) {");
		sc.add("Object causeObject = data.get(0);");
		sc.add("if (causeObject instanceof " + E_OBJECT(sc) + ") {");
		sc.add("cause = (" + E_OBJECT(sc) + ") causeObject;");
		sc.add("}");
		sc.add("}");
		sc.add(LIST(sc) + "<" + diagnosticsClassName
				+ "> children = diagnostics.getChildren();");
		sc.add("if (children.size() == 0) {");
		sc.add("if (diagnostics.getSeverity() == " + I_STATUS(sc) + ".ERROR) {");
		sc.add("addError(diagnostics.getMessage(), cause);");
		sc.add("}");
		sc.add("if (diagnostics.getSeverity() == " + I_STATUS(sc) + ".WARNING) {");
		sc.add("addWarning(diagnostics.getMessage(), cause);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + diagnosticsClassName + " diagnostic : children) {");
		sc.add("addDiagnostics(diagnostic, root);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPositionBasedTextDiagnosticClass(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public class PositionBasedTextDiagnostic implements " + iTextDiagnosticClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + URI(sc) + " uri;");
		sc.addLineBreak();
		sc.add("private int column;");
		sc.add("private int line;");
		sc.add("private int charStart;");
		sc.add("private int charEnd;");
		sc.add("private " + iProblemClassName + " problem;");
		sc.addLineBreak();
		sc.add("public PositionBasedTextDiagnostic("
				+ URI(sc)
				+ " uri, "
				+ iProblemClassName
				+ " problem, int column, int line, int charStart, int charEnd) {");
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
		sc.add("public String getLocation() {");
		sc.add("return uri.toString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getMessage() {");
		sc.add("return problem.getMessage();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasCausedBy(" + E_OBJECT(sc) + " element) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return getMessage() + \" at \" + getLocation() + \" line \" + getLine() + \", column \" + getColumn();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addElementBasedTextDiagnosticClass(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public class ElementBasedTextDiagnostic implements "
				+ iTextDiagnosticClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + iLocationMapClassName + " locationMap;");
		sc.add("private final " + URI(sc) + " uri;");
		sc.add("private final " + E_OBJECT(sc) + " element;");
		sc.add("private final " + iProblemClassName + " problem;");
		sc.addLineBreak();
		sc.add("public ElementBasedTextDiagnostic("
				+ iLocationMapClassName + " locationMap, " + URI(sc) + " uri, "
				+ iProblemClassName + " problem, " + E_OBJECT(sc) + " element) {");
		sc.add("super();");
		sc.add("this.uri = uri;");
		sc.add("this.locationMap = locationMap;");
		sc.add("this.element = element;");
		sc.add("this.problem = problem;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getMessage() {");
		sc.add("return problem.getMessage();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + iProblemClassName + " getProblem() {");
		sc.add("return problem;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getLocation() {");
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
		sc.add("public " + E_OBJECT(sc) + " getElement() {");
		sc.add("return element;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasCausedBy(" + E_OBJECT(sc) + " element) {");
		sc.add("if (this.element == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return this.element.equals(element);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return getMessage() + \" at \" + getLocation() + \" line \" + getLine() + \", column \" + getColumn();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddDefaultLoadOptionsMethod(JavaComposite sc) {
		sc.add("protected " + MAP(sc) + "<Object, Object> addDefaultLoadOptions("
				+ MAP(sc) + "<?, ?> loadOptions) {");
		sc.add(MAP(sc) + "<Object, Object> loadOptionsCopy = " + mapUtilClassName
				+ ".copySafelyToObjectToObjectMap(loadOptions);");
		sc.addComment("first add static option provider");
		sc.add("loadOptionsCopy.putAll(new " + optionProviderClassName + "().getOptions());");
		sc.addLineBreak();
		
		if (!removeEclipseDependentCode) {
			sc.addComment("second, add dynamic option providers that are registered via extension");
			sc.add("if (new " + runtimeUtilClassName + "().isEclipsePlatformAvailable()) {");
			sc.add("new " + eclipseProxyClassName + "().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);");
			sc.add("}");
		}
		sc.add("return loadOptionsCopy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddProblemMethod1(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void addProblem(" + iProblemClassName + " problem, "
				+ E_OBJECT(sc) + " element) {");
		sc.add("ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);");
		sc.add("getDiagnostics(problem.getSeverity()).add(diagnostic);");
		sc.add("mark(diagnostic);");
		sc.add("addQuickFixesToQuickFixMap(problem);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixMethod(StringComposite sc) {
		sc.add("public " + iQuickFixClassName
				+ " getQuickFix(String quickFixContext) {");
		sc.add("return quickFixMap.get(quickFixContext);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddQuickFixesToQuickFixMap(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected void addQuickFixesToQuickFixMap(" + iProblemClassName + " problem) {");
		sc.add(COLLECTION(sc) + "<" + iQuickFixClassName + "> quickFixes = problem.getQuickFixes();");
		sc.add("if (quickFixes != null) {");
		sc.add("for (" + iQuickFixClassName + " quickFix : quickFixes) {");
		sc.add("if (quickFix != null) {");
		sc.add("quickFixMap.put(quickFix.getContextAsString(), quickFix);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddProblemMethod2(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void addProblem("
				+ iProblemClassName
				+ " problem, int column, int line, int charStart, int charEnd) {");
		sc.add("PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);");
		sc.add("getDiagnostics(problem.getSeverity()).add(diagnostic);");
		sc.add("mark(diagnostic);");
		sc.add("addQuickFixesToQuickFixMap(problem);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddErrorMethod1(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("@Deprecated");
		sc.add("public void addError(String message, " + E_OBJECT(sc) + " cause) {");
		sc.add("addError(message, " + eProblemTypeClassName
				+ ".UNKNOWN, cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddErrorMethod2(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void addError(String message, " + eProblemTypeClassName
				+ " type, " + E_OBJECT(sc) + " cause) {");
		sc.add("addProblem(new " + problemClassName + "(message, type, "
				+ eProblemSeverityClassName + ".ERROR), cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddWarningMethod1(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("@Deprecated");
		sc.add("public void addWarning(String message, " + E_OBJECT(sc)
				+ " cause) {");
		sc.add("addWarning(message, " + eProblemTypeClassName
				+ ".UNKNOWN, cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddWarningMethod2(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void addWarning(String message, "
				+ eProblemTypeClassName + " type, " + E_OBJECT(sc) + " cause) {");
		sc.add("addProblem(new " + problemClassName + "(message, type, "
				+ eProblemSeverityClassName + ".WARNING), cause);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDiagnosticsMethod(JavaComposite sc) {
		// We do not need the get the class name for 'Diagnostic' because no
		// import is needed as Diagnostic is an inner class of the super class.
		sc.add("protected " + LIST(sc) + "<Diagnostic> getDiagnostics(" + eProblemSeverityClassName
				+ " severity) {");
		sc.add("if (severity == " + eProblemSeverityClassName + ".ERROR) {");
		sc.add("return getErrors();");
		sc.add("} else {");
		sc.add("return getWarnings();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLocationMapMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the location map that contains information about " +
			"the position of the contents of this resource in the original " +
			"textual representation."
		);
		sc.add("public " + iLocationMapClassName + " getLocationMap() {");
		sc.add("return locationMap;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetURIMethod(JavaComposite sc) {
		sc.add("public void setURI(" + URI(sc) + " uri) {");
		sc.addComment("because of the context dependent proxy resolving it is "
				+ "essential to resolve all proxies before the URI is changed "
				+ "which can cause loss of object identities");
		sc.add(ECORE_UTIL(sc) + ".resolveAll(this);");
		sc.add("super.setURI(uri);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLoadMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void load(" + MAP(sc) + "<?, ?> options) throws "
				+ IO_EXCEPTION(sc) + " {");
		sc.add(MAP(sc)
				+ "<Object, Object> loadOptions = addDefaultLoadOptions(options);");
		sc.add("super.load(loadOptions);");
		sc.add("resolveAfterParsing();");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addResolveAfterParsingMethod(JavaComposite sc) {
		boolean resolveProxies = doResolveProxiesAfterParsing();

		sc.add("protected void resolveAfterParsing() {");
		if (resolveProxies) {
			sc.add("interruptibleResolver = new " + interruptibleEcoreResolverClassName + "();");
			sc.add("interruptibleResolver.resolveAll(this);");
			sc.add("interruptibleResolver = null;");
		} else {
			sc.addComment("Automatic proxy resolving after parsing was disabled by option " + OptionTypes.RESOLVE_PROXY_ELEMENTS_AFTER_PARSING.getLiteral() + ".");
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private boolean doResolveProxiesAfterParsing() {
		boolean resolveProxies = OptionManager.INSTANCE.getBooleanOptionValue(
				getContext().getConcreteSyntax(),
				OptionTypes.RESOLVE_PROXY_ELEMENTS_AFTER_PARSING);
		return resolveProxies;
	}

	private void addRunPostProcessorsMethod(JavaComposite sc) {
		sc.addJavadoc("Runs all post processors to process this resource.");
		sc.add("protected boolean runPostProcessors(" + MAP(sc)
				+ "<?, ?> loadOptions) {");
		sc.add("unmark(" + eProblemTypeClassName + ".ANALYSIS_PROBLEM);");
		sc.add("if (processTerminationRequested()) {");
		sc.add("return false;");
		sc.add("}");
		sc.addComment("first, run the generated post processor");
		sc.add("runPostProcessor(new " + resourcePostProcessorClassName
				+ "());");
		sc.add("if (loadOptions == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.addComment("then, run post processors that are registered via the load options extension point");
		sc.add("Object resourcePostProcessorProvider = loadOptions.get("
				+ iOptionsClassName + ".RESOURCE_POSTPROCESSOR_PROVIDER);");
		sc.add("if (resourcePostProcessorProvider != null) {");
		sc.add("if (resourcePostProcessorProvider instanceof "
				+ iResourcePostProcessorProviderClassName + ") {");
		sc.add("runPostProcessor((("
				+ iResourcePostProcessorProviderClassName
				+ ") resourcePostProcessorProvider).getResourcePostProcessor());");
		sc.add("} else if (resourcePostProcessorProvider instanceof "
				+ COLLECTION(sc) + "<?>) {");
		sc.add("java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;");
		sc.add("for (Object processorProvider : resourcePostProcessorProviderCollection) {");
		sc.add("if (processTerminationRequested()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (processorProvider instanceof "
				+ iResourcePostProcessorProviderClassName + ") {");
		sc.add(iResourcePostProcessorProviderClassName
				+ " csProcessorProvider = ("
				+ iResourcePostProcessorProviderClassName
				+ ") processorProvider;");
		sc.add(iResourcePostProcessorClassName
				+ " postProcessor = csProcessorProvider.getResourcePostProcessor();");
		sc.add("runPostProcessor(postProcessor);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunPostProcessorMethod(JavaComposite sc) {
		sc.addJavadoc("Runs the given post processor to process this resource.");
		sc.add("protected void runPostProcessor("
				+ iResourcePostProcessorClassName + " postProcessor) {");
		sc.add("try {");
		sc.add("this.runningPostProcessor = postProcessor;");
		sc.add("postProcessor.process(this);");
		sc.add("} catch (Exception e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while running a post-processor.\", e);");
		sc.add("}");
		sc.add("this.runningPostProcessor = null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoUnloadMethod(JavaComposite sc) {
		sc.addJavadoc("Extends the super implementation by clearing all information about element positions.");
		sc.add("protected void doUnload() {");
		sc.add("super.doUnload();");
		sc.add("clearState();");
		sc.add("loadOptions = null;");
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
		sc.addComment("Remove temporary markers");
		sc.add("unmark(" + eProblemTypeClassName + "." + EProblemTypeGenerator.PROBLEM_TYPES.UNKNOWN.name() + ");");
		sc.add("unmark(" + eProblemTypeClassName + "." + EProblemTypeGenerator.PROBLEM_TYPES.SYNTAX_ERROR.name() + ");");
		sc.add("unmark(" + eProblemTypeClassName + "." + EProblemTypeGenerator.PROBLEM_TYPES.UNRESOLVED_REFERENCE.name() + ");");
		sc.add("unmark(" + eProblemTypeClassName + "." + EProblemTypeGenerator.PROBLEM_TYPES.LIVE_CONSTRAINT_PROBLEM.name() + ");");
		sc.addComment(
			"If the resource is reloaded, we do not remove the problems that were detected by batch constraints. " +
			"This ensures that we can see the problems while typing. The problems might get out dated because of " +
			"the ongoing modifications, but they will be updated (i.e., deleted and recreated) the next time the " +
			"resource is saved (and loaded again)."
		);
		sc.add("if (!isReloading) {");
		sc.add("unmark(" + eProblemTypeClassName + "." + EProblemTypeGenerator.PROBLEM_TYPES.BATCH_CONSTRAINT_PROBLEM.name() + ");");
		sc.add("}");
		sc.add("proxyCounter = 0;");
		sc.add(RESOLVER_SWITCH_FIELD_NAME + " = null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAttachResolveWarningsMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected void attachResolveWarnings("
				+ iReferenceResolveResultClassName + "<? extends " + E_OBJECT(sc)
				+ "> result, " + E_OBJECT(sc) + " proxy) {");
		sc.add("assert result != null;");
		sc.add("assert result.wasResolved();");
		sc.add("if (result.wasResolved()) {");
		sc.add("for (" + iReferenceMappingClassName + "<? extends " + E_OBJECT(sc)
				+ "> mapping : result.getMappings()) {");
		sc.add("final String warningMessage = mapping.getWarning();");
		sc.add("if (warningMessage == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("addProblem(new " + problemClassName + "(warningMessage, "
				+ eProblemTypeClassName + ".UNRESOLVED_REFERENCE, "
				+ eProblemSeverityClassName + ".WARNING), proxy);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAttachResolveErrorMethod(JavaComposite sc) {
		sc.add("protected void attachResolveError("
				+ iReferenceResolveResultClassName + "<?> result, " + E_OBJECT(sc)
				+ " proxy) {");
		sc.addComment("attach errors to this resource");
		sc.add("assert result != null;");
		sc.add("final String errorMessage = result.getErrorMessage();");
		sc.add("if (errorMessage == null) {");
		sc.add("assert(false);");
		sc.add("} else {");
		sc.add("addProblem(new " + problemClassName + "(errorMessage, "
				+ eProblemTypeClassName + ".UNRESOLVED_REFERENCE, "
				+ eProblemSeverityClassName
				+ ".ERROR, result.getQuickFixes()), proxy);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveDiagnosticsMethod(JavaComposite sc) {
		sc.add("protected void removeDiagnostics(" + E_OBJECT(sc) + " cause, " + LIST(sc)
				+ "<Diagnostic> diagnostics) {");
		sc.addComment("remove all errors/warnings from this resource");
		sc.add("for (Diagnostic errorCand : new "
				+ BASIC_E_LIST(sc) + "<Diagnostic>(diagnostics)) {");
		sc.add("if (errorCand instanceof " + iTextDiagnosticClassName + ") {");
		sc.add("if (((" + iTextDiagnosticClassName
				+ ") errorCand).wasCausedBy(cause)) {");
		sc.add("diagnostics.remove(errorCand);");
		sc.add("unmark(cause);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResultElementMethod(JavaComposite sc) {
		sc.add("protected " + E_OBJECT(sc) + " getResultElement("
				+ iContextDependentUriFragmentClassName + "<? extends "
				+ E_OBJECT(sc) + "> uriFragment, " + iReferenceMappingClassName
				+ "<? extends " + E_OBJECT(sc) + "> mapping, " + E_OBJECT(sc)
				+ " proxy, final String errorMessage) {");
		sc.add("if (mapping instanceof " + iUriMappingClassName + "<?>) {");
		sc.add(URI(sc) + " uri = ((" + iUriMappingClassName + "<? extends "
				+ E_OBJECT(sc) + ">)mapping).getTargetIdentifier();");
		sc.add("if (uri != null) {");
		sc.add(E_OBJECT(sc) + " result = null;");
		sc.add("try {");
		sc.add("result = this.getResourceSet().getEObject(uri, true);");
		sc.add("} catch (Exception e) {");
		sc.addComment("we can catch exceptions here, because EMF will try to resolve again and handle the exception");
		sc.add("}");
		sc.add("if (result == null || result.eIsProxy()) {");
		sc.addComment("unable to resolve: attach error");
		sc.add("if (errorMessage == null) {");
		sc.add("assert(false);");
		sc.add("} else {");
		sc.add("addProblem(new " + problemClassName + "(errorMessage, "
				+ eProblemTypeClassName + ".UNRESOLVED_REFERENCE, "
				+ eProblemSeverityClassName + ".ERROR), proxy);");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.add("return null;");
		sc.add("} else if (mapping instanceof " + iElementMappingClassName
				+ "<?>) {");
		sc.add(E_OBJECT(sc) + " element = ((" + iElementMappingClassName
				+ "<? extends " + E_OBJECT(sc) + ">)mapping).getTargetElement();");
		sc.add(E_REFERENCE(sc) + " reference = uriFragment.getReference();");
		sc.add(E_REFERENCE(sc)
				+ " oppositeReference = uriFragment.getReference().getEOpposite();");
		sc.add("if (!uriFragment.getReference().isContainment() && oppositeReference != null) {");
		sc.add("if (reference.isMany()) {");
		sc.add(MANY_INVERSE(sc) + "<" + E_OBJECT(sc) + "> list = " + castUtilClassName
				+ ".cast(element.eGet(oppositeReference, false));					");
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
		sc.add("public " + E_OBJECT(sc) + " getEObject(String id) {");
		sc.add("if (internalURIFragmentMap.containsKey(id)) {");
		sc.add(iContextDependentUriFragmentClassName + "<? extends " + E_OBJECT(sc)
				+ "> uriFragment = internalURIFragmentMap.get(id);");
		sc.add("boolean wasResolvedBefore = uriFragment.isResolved();");
		sc.add(iReferenceResolveResultClassName + "<? extends " + E_OBJECT(sc)
				+ "> result = null;");
		sc.addComment("catch and report all Exceptions that occur during proxy resolving");
		sc.add("try {");
		sc.add("result = uriFragment.resolve();");
		sc.add("} catch (Exception e) {");
		sc.add("String message = \"An expection occured while resolving the proxy for: \""
				+ "+ id + \". (\" + e.toString() + \")\";");
		sc.add("addProblem(new " + problemClassName + "("
		 		+ "message, " + eProblemTypeClassName + ".UNRESOLVED_REFERENCE"
				+ ", "
				+ eProblemSeverityClassName + ".ERROR), "
				+ "uriFragment.getProxy());");
		sc.add("new " + runtimeUtilClassName + "().logError(message, e);");
		sc.add("}");

		sc.add("if (result == null) {");
		sc.addComment("the resolving did call itself");
		sc.add("return null;");
		sc.add("}");
		sc.add("if (!wasResolvedBefore && !result.wasResolved()) {");
		sc.add("attachResolveError(result, uriFragment.getProxy());");
		sc.add("return null;");
		sc.add("} else if (!result.wasResolved()) {");
		sc.add("return null;");
		sc.add("} else {");
		sc.add(E_OBJECT(sc) + " proxy = uriFragment.getProxy();");
		sc.addComment("remove an error that might have been added by an earlier attempt");
		sc.add("removeDiagnostics(proxy, getErrors());");
		sc.addComment("remove old warnings and attach new");
		sc.add("removeDiagnostics(proxy, getWarnings());");
		sc.add("attachResolveWarnings(result, proxy);");
		sc.add(iReferenceMappingClassName + "<? extends " + E_OBJECT(sc)
				+ "> mapping = result.getMappings().iterator().next();");
		sc.add(E_OBJECT(sc)
				+ " resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());");
		sc.add(E_OBJECT(sc) + " container = uriFragment.getContainer();");
		sc.add("replaceProxyInLayoutAdapters(container, proxy, resultElement);");
		sc.add("return resultElement;");
		sc.add("}");
		sc.add("} else {");
		sc.add("return super.getEObject(id);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReplaceProxyInLayoutAdaptersMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected void replaceProxyInLayoutAdapters(" + E_OBJECT(sc)
				+ " container, " + E_OBJECT(sc) + " proxy, " + E_OBJECT(sc)
				+ " target) {");
		sc.add("for (" + ADAPTER(sc) + " adapter : container.eAdapters()) {");
		sc.add("if (adapter instanceof " + layoutInformationAdapterClassName
				+ ") {");
		sc.add(layoutInformationAdapterClassName
				+ " layoutInformationAdapter = ("
				+ layoutInformationAdapterClassName + ") adapter;");
		sc.add("layoutInformationAdapter.replaceProxy(proxy, target);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterContextDependentProxyMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public <ContainerType extends "
				+ E_OBJECT(sc)
				+ ", ReferenceType extends "
				+ E_OBJECT(sc)
				+ "> void registerContextDependentProxy("
				+ iContextDependentUriFragmentFactoryClassName
				+ "<ContainerType, ReferenceType> factory, ContainerType container, "
				+ E_REFERENCE(sc) + " reference, String id, " + E_OBJECT(sc)
				+ " proxyElement, int position) {");
		sc.add(INTERNAL_E_OBJECT(sc) + " proxy = (" + INTERNAL_E_OBJECT(sc)
				+ ") proxyElement;");
		sc.add("String internalURIFragment = "
				+ iContextDependentUriFragmentClassName
				+ ".INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + \"_\" + id;");
		sc.add(iContextDependentUriFragmentClassName
				+ "<?> uriFragment = factory.create(id, container, reference, position, proxy);");
		sc.add("proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));");
		sc.add("addURIFragment(internalURIFragment, uriFragment);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddURIFragmentMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void addURIFragment(String internalURIFragment, "
				+ iContextDependentUriFragmentClassName + "<? extends "
				+ E_OBJECT(sc) + "> uriFragment) {");
		sc.add("internalURIFragmentMap.put(internalURIFragment, uriFragment);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResetLocationMapMethod(JavaComposite sc) {
		sc.addJavadoc("Clears the location map by replacing it with a new instance.");
		sc.add("protected void resetLocationMap() {");
		sc.addComment(
			"Although, the location map is obtained from the parser after every " +
			"parse run, we initialize it here to avoid null pointer exceptions."
		);
		sc.add("locationMap = new " + locationMapClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + iReferenceResolverSwitchClassName + " "
				+ RESOLVER_SWITCH_FIELD_NAME + ";");
		sc.add("private " + iLocationMapClassName + " locationMap;");
		sc.add("private int proxyCounter = 0;");
		sc.add("private " + iTextParserClassName + " parser;");
		sc.add("private " + layoutUtilClassName + " layoutUtil = new " + layoutUtilClassName + "();");
		sc.add("private " + markerHelperClassName + " markerHelper;");
		sc.add("private " + MAP(sc) + "<String, "
				+ iContextDependentUriFragmentClassName + "<? extends "
				+ E_OBJECT(sc) + ">> internalURIFragmentMap = new "
				+ LINKED_HASH_MAP(sc) + "<String, "
				+ iContextDependentUriFragmentClassName + "<? extends "
				+ E_OBJECT(sc) + ">>();");
		sc.add("private " + MAP(sc) + "<String, " + iQuickFixClassName
				+ "> quickFixMap = new " + LINKED_HASH_MAP(sc) + "<String, "
				+ iQuickFixClassName + ">();");
		if (saveChangedResourcesOnly) {
			sc.add("private String textPrintAfterLoading = null;");
		}
		sc.add("private " + MAP(sc) + "<?, ?> loadOptions;");
		sc.addLineBreak();

		sc.addJavadoc("If a post-processor is currently running, this field holds a reference to it. "
				+ "This reference is used to terminate post-processing if needed.");
		sc.add("private " + iResourcePostProcessorClassName
				+ " runningPostProcessor;");
		sc.addLineBreak();

		sc.addJavadoc("A flag (and lock) to indicate whether reloading of the resource shall be cancelled.");
		sc.add("private Boolean terminateReload = false;");
		sc.add("private Object terminateReloadLock = new Object();");
		sc.add("private Object loadingLock = new Object();");
		sc.add("private boolean delayNotifications = false;");
		sc.add("private " + LIST(sc) + "<" + NOTIFICATION(sc) + "> delayedNotifications = new " + ARRAY_LIST(sc) + "<" + NOTIFICATION(sc) + ">();");
		sc.add("private " + INPUT_STREAM(sc) + " latestReloadInputStream = null;");
		sc.add("private " + MAP(sc) + "<?, ?> latestReloadOptions = null;");
		sc.addLineBreak();
		sc.addJavadoc(
			"This flag indicates whether this resource is currently reloaded. " +
			"The flag is set and unset in the reload() method and used to decide " +
			"what kinds of constraints (live or batch) need to be evaluated. This " +
			"decision is made in runValidators()."
		);
		sc.add("private boolean isReloading = false;");
		sc.add("private " + interruptibleEcoreResolverClassName + " interruptibleResolver;");
		sc.addLineBreak();
		
		generatorUtil.addMetaInformationField(sc, getContext());
	}

	private void addGetSyntaxNameMethod(StringComposite sc) {
		sc.add("protected String getSyntaxName() {");
		sc.add("return \"" + csSyntaxName + "\";");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetEncoding(JavaComposite sc) {
		sc.add("public String getEncoding(" + MAP(sc) + "<?, ?> options) {");
		sc.add("String encoding = null;");
		if (!removeEclipseDependentCode) {
			sc.add("if (new " + runtimeUtilClassName + "().isEclipsePlatformAvailable()) {");
			sc.add("encoding = new " + eclipseProxyClassName + "().getPlatformResourceEncoding(uri);");
			sc.add("}");
		}
		sc.add("if (options != null) {");
		sc.add("Object encodingOption = options.get(" + iOptionsClassName + "." + IOptionsGenerator.OPTION_ENCODING + ");");
		sc.add("if (encodingOption != null) {");
		sc.add("encoding = encodingOption.toString();");
		sc.add("}");
		sc.add("}");
		sc.add("return encoding;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetReferenceResolverSwitchMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + iReferenceResolverSwitchClassName
				+ " getReferenceResolverSwitch() {");
		sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
		sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new "
				+ referenceResolverSwitchClassName + "();");
		sc.add("}");
		sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoSaveMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected void doSave(" + OUTPUT_STREAM(sc) + " outputStream, " + MAP(sc) + "<?,?> options) throws " + IO_EXCEPTION(sc) + " {");
		sc.add(iTextPrinterClassName
				+ " printer = getMetaInformation().createPrinter(outputStream, this);");
		sc.add(iReferenceResolverSwitchClassName
				+ " referenceResolverSwitch = getReferenceResolverSwitch();");
		sc.add("printer.setEncoding(getEncoding(options));");
		sc.add("printer.setOptions(options);");
		sc.add("referenceResolverSwitch.setOptions(options);");
		sc.add("for (" + E_OBJECT(sc) + " root : getContentsInternal()) {");
		sc.add("if (isLayoutInformationRecordingEnabled()) {");
		sc.add("layoutUtil.transferAllLayoutInformationFromModel(root);");
		sc.add("}");
		sc.add("printer.print(root);");
		sc.add("if (isLayoutInformationRecordingEnabled()) {");
		sc.add("layoutUtil.transferAllLayoutInformationToModel(root);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSaveOnlyIfChangedWithMemoryBuffer(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected void saveOnlyIfChangedWithMemoryBuffer(" + MAP(sc)
				+ "<?, ?> options) throws " + IO_EXCEPTION(sc) + " {");
		sc.add("String currentPrint = getPrint(options);");
		sc.add("if (textPrintAfterLoading != null && textPrintAfterLoading.equals(currentPrint)) {");
		sc.add("return;");
		sc.add("} else {");
		sc.add("super.saveOnlyIfChangedWithFileBuffer(options);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrint(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected String getPrint(" + MAP(sc) + "<?, ?> options) throws "
				+ IO_EXCEPTION(sc) + " {");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM(sc) + " outputStream = new "
				+ BYTE_ARRAY_OUTPUT_STREAM(sc) + "();");
		sc.add("doSave(outputStream, options);");
		sc.add("return outputStream.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructors(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("resetLocationMap();");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + getResourceClassName() + "(" + URI(sc) + " uri) {");
		sc.add("super(uri);");
		sc.add("resetLocationMap();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoLoadMethod(JavaComposite sc) {
		sc.add("protected void doLoad(" + INPUT_STREAM(sc) + " inputStream, " + MAP(sc)
				+ "<?,?> options) throws " + IO_EXCEPTION(sc) + " {");
		sc.add("synchronized (loadingLock) {");
		sc.add("if (processTerminationRequested()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("this.loadOptions = options;");
		sc.add("delayNotifications = true;");
		sc.add("resetLocationMap();");
		sc.add("String encoding = getEncoding(options);");
		sc.add(INPUT_STREAM(sc) + " actualInputStream = inputStream;");
		sc.add("Object inputStreamPreProcessorProvider = null;");
		sc.add("if (options != null) {");
		sc.add("inputStreamPreProcessorProvider = options.get("
				+ iOptionsClassName + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		sc.add("}");
		sc.add("if (inputStreamPreProcessorProvider != null) {");
		sc.add("if (inputStreamPreProcessorProvider instanceof "
				+ iInputStreamProcessorProviderClassName + ") {");
		sc.add(iInputStreamProcessorProviderClassName + " provider = ("
				+ iInputStreamProcessorProviderClassName
				+ ") inputStreamPreProcessorProvider;");
		sc.add(inputStreamProcessorClassName
				+ " processor = provider.getInputStreamProcessor(inputStream);");
		sc.add("actualInputStream = processor;");
		//TODO #1827: do not override the encoding! Instead #1827 needs to be fixed.
		//sc.add("encoding = processor.getOutputEncoding();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();

		sc.addComment(
			"We store the parser instance in a field instead of a local variable, " +
			"because we may need to terminate the parser from another thread."
		);
		sc.add("parser = getMetaInformation().createParser(actualInputStream, encoding);");
		sc.add("parser.setOptions(options);");
		sc.add(iReferenceResolverSwitchClassName
				+ " referenceResolverSwitch = getReferenceResolverSwitch();");
		sc.add("referenceResolverSwitch.setOptions(options);");
		sc.add(iParseResultClassName + " result = parser.parse();");
		sc.addComment("dispose parser, we don't need it anymore");
		sc.add("parser = null;");
		sc.addLineBreak();
		sc.add("if (processTerminationRequested()) {");
		sc.addComment("do nothing if reload was already restarted");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("clearState();");
		sc.add("unloadAndClearContents();");
		sc.addComment("We must set the load options again since they are deleted by the unload() method.");
		sc.add("this.loadOptions = options;");
		sc.add(E_OBJECT(sc) + " root = null;");
		sc.add("if (result != null) {");
		sc.add("root = result.getRoot();");
		sc.add("if (root != null) {");
		sc.add(iLocationMapClassName + " newLocationMap = result.getLocationMap();");
		sc.add("if (newLocationMap != null) {");
		sc.add("this.locationMap = newLocationMap;");
		sc.add("}");
		sc.add("if (isLayoutInformationRecordingEnabled()) {");
		sc.add("layoutUtil.transferAllLayoutInformationToModel(root);");
		sc.add("}");
		sc.add("if (processTerminationRequested()) {");
		sc.addComment("the next reload will add new content");
		sc.add("return;");
		sc.add("}");
		sc.add("getContentsInternal().add(root);");
		sc.add("}");
		sc.add(COLLECTION(sc) + "<" + iCommandClassName + "<"
				+ iTextResourceClassName
				+ ">> commands = result.getPostParseCommands();");
		sc.add("if (commands != null) {");
		sc.add("for (" + iCommandClassName + "<" + iTextResourceClassName
				+ ">  command : commands) {");
		sc.add("command.execute(this);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("getReferenceResolverSwitch().setOptions(options);");
		sc.add("if (getErrors().isEmpty()) {");
		sc.add("if (!runPostProcessors(options)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (root != null) {");
		sc.add("runValidators(root);");
		sc.add("}");
		sc.add("}");
		sc.add("notifyDelayed();");
		if (saveChangedResourcesOnly) {
			sc.add("textPrintAfterLoading = getPrint(options);");
		}
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addProcessTerminationRequestedMethod(JavaComposite sc) {
		sc.add("protected boolean processTerminationRequested() {");
		sc.add("if (terminateReload) {");
		sc.add("delayNotifications = false;");
		sc.add("delayedNotifications.clear();");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addNotifyDelayedMethod(JavaComposite sc) {
		sc.add("protected void notifyDelayed() {");
		sc.add("delayNotifications = false;");
		sc.add("for (" + NOTIFICATION(sc) + " delayedNotification : delayedNotifications) {");
		sc.add("super.eNotify(delayedNotification);");
		sc.add("}");
		sc.add("delayedNotifications.clear();");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addENotifyMethod(JavaComposite sc) {
		sc.add("public void eNotify(" + NOTIFICATION(sc) + " notification) {");
		sc.add("if (delayNotifications) {");
		sc.add("delayedNotifications.add(notification);");
		sc.add("} else {");
		sc.add("super.eNotify(notification);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReloadMethod(JavaComposite sc) {
		sc.addJavadoc("Reloads the contents of this resource from the given stream.");
		sc.add("public void reload(" + INPUT_STREAM(sc) + " inputStream, " + MAP(sc)
				+ "<?,?> options) throws " + IO_EXCEPTION(sc) + " {");
		sc.add("synchronized (terminateReloadLock) {");
		sc.add("latestReloadInputStream = inputStream;");
		sc.add("latestReloadOptions = options;");
		sc.add("if (terminateReload == true) {");
		sc.addComment("reload already requested");
		sc.add("}");
		sc.add("terminateReload = true;");
		sc.add("}");

		sc.add("cancelReload();");
		
		sc.add("synchronized (loadingLock) {");
		sc.add("synchronized (terminateReloadLock) {");
		sc.add("terminateReload = false;");
		sc.add("}");
		sc.add("isLoaded = false;");
		sc.add(MAP(sc) + "<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);");
		sc.add("try {");
		sc.addComment("Set isReloading flag to allow other method to differentiate between loading and reloading.");
		sc.add("this.isReloading = true;");
		sc.add("doLoad(latestReloadInputStream, loadOptions);");
		sc.add("} catch (" + terminateParsingExceptionClassName + " tpe) {");
		sc.addComment("do nothing - the resource is left unchanged if this exception is thrown");
		sc.add("}");
		sc.add("this.isReloading = false;");
		sc.add("resolveAfterParsing();");
		sc.add("isLoaded = true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCancelReloadMethod(JavaComposite sc) {
		sc.addJavadoc("Cancels reloading this resource. The running parser and post processors are terminated.");
		sc.add("protected void cancelReload() {");
		sc.addComment("Cancel parser");
		sc.add(iTextParserClassName + " parserCopy = parser;");
		sc.add("if (parserCopy != null) {");
		sc.add("parserCopy.terminate();");
		sc.add("}");
		sc.addComment("Cancel post processor(s)");
		sc.add(iResourcePostProcessorClassName
				+ " runningPostProcessorCopy = runningPostProcessor;");
		sc.add("if (runningPostProcessorCopy != null) {");
		sc.add("runningPostProcessorCopy.terminate();");
		sc.add("}");
		sc.addComment("Cancel reference resolving");
		sc.add(interruptibleEcoreResolverClassName + " interruptibleResolverCopy = interruptibleResolver;");
		sc.add("if (interruptibleResolverCopy != null) {");
		sc.add("interruptibleResolverCopy.terminate();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentsMethod(JavaComposite sc) {
		sc.addJavadoc("Returns a copy of the contents of this resource wrapped in a list that "
				+ "propagates changes to the original resource list. Wrapping is required "
				+ "to make sure that clients which obtain a reference to the list of contents "
				+ "do not interfere when changing the list.");
		sc.add("public " + E_LIST(sc) + "<" + E_OBJECT(sc) + "> getContents() {");
		sc.add("if (terminateReload) {");
		sc.addComment("the contents' state is currently unclear");
		sc.add("return new " + BASIC_E_LIST(sc) + "<"+ E_OBJECT(sc) + ">();");
		sc.add("}");
		sc.add("return new " + copiedEObjectInternalEListClassName + "(("
				+ INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + ">) super.getContents());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentsInternalMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the raw contents of this resource. In contrast to getContents(), " +
				"this methods does not return a copy of the content list, but the original list.");
		sc.add("public " + E_LIST(sc) + "<" + E_OBJECT(sc)
				+ "> getContentsInternal() {");
		sc.add("if (terminateReload) {");
		sc.addComment("the contents' state is currently unclear");
		sc.add("return new " + BASIC_E_LIST(sc) + "<"+ E_OBJECT(sc) + ">();");
		sc.add("}");
		sc.add("return super.getContents();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetWarningsMethod(JavaComposite sc) {
		sc.addJavadoc("Returns all warnings that are associated with this resource.");
		sc.add("public " + E_LIST(sc) + "<Diagnostic> getWarnings() {");
		sc.add("if (terminateReload) {");
		sc.addComment("the contents' state is currently unclear");
		sc.add("return new " + BASIC_E_LIST(sc) + "<Diagnostic>();");
		sc.add("}");
		sc.add("return new " + copiedEListClassName + "<Diagnostic>(super.getWarnings());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetErrorsMethod(JavaComposite sc) {
		sc.addJavadoc("Returns all errors that are associated with this resource.");
		sc.add("public " + E_LIST(sc) + "<Diagnostic> getErrors() {");
		sc.add("if (terminateReload) {");
		sc.addComment("the contents' state is currently unclear");
		sc.add("return new " + BASIC_E_LIST(sc) + "<Diagnostic>();");
		sc.add("}");
		sc.add("return new " + copiedEListClassName + "<Diagnostic>(super.getErrors());");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addHasErrorsMethod(JavaComposite sc) {
		sc.addJavadoc("Returns true if errors are associated with this resource.");
		sc.add("public boolean hasErrors() {");
		sc.addComment(
			"We use the method of the super class to avoid copying the list " +
			"of errors which is done by getErrors() in this class. Creating a " +
			"copy is not required to check whether the list of errors is " +
			"empty and moreover it did cause race conditions in the editor " +
			"that led to ArrayIndexOutOfBoundsExceptions while copying the " +
			"error list.");
		sc.add("return !super.getErrors().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMarkMethod(JavaComposite sc) {
		sc.add("protected void mark(" + iTextDiagnosticClassName + " diagnostic) {");
		if (removeEclipseDependentCode) {
			sc.addComment("This method does nothing in an Eclipse-independent implementation.");
		} else {
			sc.add(markerHelperClassName + " markerHelper = getMarkerHelper();");
			sc.add("if (markerHelper != null) {");
			sc.add("markerHelper.mark(this, diagnostic);");
			sc.add("}");
		}
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetMarkerHelperMethod(JavaComposite sc) {
		sc.add("protected " + markerHelperClassName + " getMarkerHelper() {");
		if (removeEclipseDependentCode) {
			sc.addComment("This method does nothing in an Eclipse-independent implementation.");
		} else {
			sc.add("if (isMarkerCreationEnabled() && new " + runtimeUtilClassName + "().isEclipsePlatformAvailable()) {");
			sc.add("if (markerHelper == null) {");
			sc.add("markerHelper = new " + markerHelperClassName + "();");
			sc.add("}");
			sc.add("return markerHelper;");
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addUnmarkMethod1(JavaComposite sc) {
		sc.add("protected void unmark(" + E_OBJECT(sc) + " cause) {");
		if (removeEclipseDependentCode) {
			sc.addComment("This method does nothing in an Eclipse-independent implementation.");
		} else {
			sc.add(markerHelperClassName + " markerHelper = getMarkerHelper();");
			sc.add("if (markerHelper != null) {");
			sc.add("markerHelper.unmark(this, cause);");
			sc.add("}");
		}
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addUnmarkMethod2(JavaComposite sc) {
		sc.add("protected void unmark(" + eProblemTypeClassName + " analysisProblem) {");
		if (removeEclipseDependentCode) {
			sc.addComment("This method does nothing in an Eclipse-independent implementation.");
		} else {
			sc.add(markerHelperClassName + " markerHelper = getMarkerHelper();");
			sc.add("if (markerHelper != null) {");
			sc.add("markerHelper.unmark(this, analysisProblem);");
			sc.add("}");
		}
		sc.add("}");
		sc.addLineBreak();
	}

}

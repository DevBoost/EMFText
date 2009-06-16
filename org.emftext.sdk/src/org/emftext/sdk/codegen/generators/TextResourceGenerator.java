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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.IInputStreamProcessorProvider;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IElementMapping;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextDiagnostic;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.IURIMapping;
import org.emftext.runtime.resource.impl.AbstractTextResource;
import org.emftext.runtime.resource.impl.ElementBasedTextDiagnostic;
import org.emftext.runtime.resource.impl.LocationMap;
import org.emftext.runtime.resource.impl.PositionBasedTextDiagnostic;
import org.emftext.runtime.util.CastUtil;
import org.emftext.runtime.util.ListUtil;
import org.emftext.runtime.util.MapUtil;
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

	private static final String LOCATION_MAP = LocationMap.class.getName();

	private static final String IO_EXCEPTION = IOException.class.getName();

	private static final String CAST_UTIL = CastUtil.class.getName();

	private static final String LIST_UTIL = ListUtil.class.getName();

	private static final String CORE_EXCEPTION = CoreException.class.getName();

	private static final String I_CONFIGURATION_ELEMENT = IConfigurationElement.class.getName();

	private static final String I_EXTENSION_REGISTRY = IExtensionRegistry.class.getName();

	private static final String PLATFORM = Platform.class.getName();

	private static final String MAP_UTIL = MapUtil.class.getName();

	private static final String POSITION_BASED_TEXT_DIAGNOSTIC = PositionBasedTextDiagnostic.class.getName();

	private static final String ELEMENT_BASED_TEXT_DIAGNOSTIC = ElementBasedTextDiagnostic.class.getName();

	private static final String ECORE_UTIL = EcoreUtil.class.getName();

	private static final String EMFTEXT_RUNTIME_PLUGIN = EMFTextRuntimePlugin.class.getName();

	private static final String I_RESOURCE_POST_PROCESSOR = IResourcePostProcessor.class.getName();

	private static final String COLLECTION = Collection.class.getName();

	private static final String I_RESOURCE_POST_PROCESSOR_PROVIDER = org.emftext.runtime.IResourcePostProcessorProvider.class.getName();

	private static final String I_OPTIONS = IOptions.class.getName();

	private static final String OBJECT = Object.class.getName();

	private static final String I_TEXT_DIAGNOSTIC = ITextDiagnostic.class.getName();

	private static final String BASIC_E_LIST = BasicEList.class.getName();

	private static final String DIAGNOSTIC = Diagnostic.class.getName().replace("$", ".");

	private static final String MANY_INVERSE = EObjectWithInverseResolvingEList.ManyInverse.class.getName().replace('$', '.');

	private static final String I_ELEMENT_MAPPING = IElementMapping.class.getName();

	private static final String EXCEPTION = Exception.class.getName();

	private static final String URI = org.eclipse.emf.common.util.URI.class.getName();

	private static final String I_URI_MAPPING = IURIMapping.class.getName();

	private static final String I_REFERENCE_MAPPING = IReferenceMapping.class.getName();

	private static final String I_REFERENCE_RESOLVE_RESULT = IReferenceResolveResult.class.getName();

	private static final String E_REFERENCE = org.eclipse.emf.ecore.EReference.class.getName();

	private static final String I_CONTEXT_DEPENDANT_URI_FRAGMENT_FACTORY = org.emftext.runtime.resource.IContextDependentURIFragmentFactory.class.getName();

	private static final String E_OBJECT = EObject.class.getName();

	private static final String HASH_MAP = HashMap.class.getName();

	private static final String I_CONTEXT_DEPENDENT_URI_FRAGMENT = IContextDependentURIFragment.class.getName();

	private static final String MAP = Map.class.getName();

	private static final String I_LOCATION_MAP = ILocationMap.class.getName();

	private static final String RESOLVER_SWITCH_FIELD_NAME = "resolverSwitch";

	private static final String STRING = String.class.getName();

	private static final String LIST = List.class.getName();

	private static final String INTERNAL_E_OBJECT = InternalEObject.class.getName();

	private static final String I_OPTION_PROVIDER = IOptionProvider.class.getName();
	
	private static final String ARRAY_LIST = ArrayList.class.getName();
	
	private ConcreteSyntax concreteSyntax;
	private String csClassName;
	private String resolverSwitchClassName;
	private String printerClassName;
	private String parserClassName;
	private String csSyntaxName;
	private String qualifiedMetaInformationClassName;

	public TextResourceGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getResourceClassName());
		this.concreteSyntax = context.getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		this.csClassName = context.getCapitalizedConcreteSyntaxName();
		this.resolverSwitchClassName = context.getQualifiedReferenceResolverSwitchClassName();
		this.printerClassName = context.getQualifiedPrinterName();
		this.parserClassName = context.getQualifiedParserClassName();
		this.qualifiedMetaInformationClassName = context.getQualifiedMetaInformationClassName();
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
    	
		generateConstructors(sc);
        generateDoLoadMethod(sc);
        generateDoSaveMethod(sc);
        generateGetSyntaxNameMethod(sc);
        generateGetScannerMethod(sc);
        generateGetReferenceResolverSwitchMethod(sc);
    	generateGetMetaInformationMethod(sc);

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

    	addAddErrorMethod1(sc);
    	addAddErrorMethod2(sc);
    	addAddWarningMethod1(sc);
    	addAddWarningMethod2(sc);

    	addAddDefaultLoadOptionsMethod(sc);
    	addLoadOptionsMethod(sc);
    	sc.add("}");
    	
    	out.print(sc.toString());
    	return true;
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

	private void addAddWarningMethod2(StringComposite sc) {
		sc.add("public void addWarning(" + STRING + " message, int column, int line, int charStart,");
    	sc.add("int charEnd) {");
    	sc.add("getWarnings().add(new " + POSITION_BASED_TEXT_DIAGNOSTIC + "(getURI(), message, column, line, charStart, charEnd));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddWarningMethod1(StringComposite sc) {
		sc.add("public void addWarning(" + STRING + " message, " + E_OBJECT + " element) {");
    	sc.add("getWarnings().add(new " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(locationMap, getURI(), message, element));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddErrorMethod2(StringComposite sc) {
		sc.add("public void addError(" + STRING + " message, int column, int line, int charStart,");
    	sc.add("int charEnd) {");
    	sc.add("getErrors().add(new " + POSITION_BASED_TEXT_DIAGNOSTIC + "(getURI(), message, column, line, charStart, charEnd));");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAddErrorMethod1(StringComposite sc) {
		sc.add("public void addError(" + STRING + " message, " + E_OBJECT + " element) {");
    	sc.add("getErrors().add(new " + ELEMENT_BASED_TEXT_DIAGNOSTIC + "(locationMap, getURI(), message, element));");
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
    	sc.add(STRING + " warningMessage = mapping.getWarning();");
    	sc.add("if (warningMessage == null) {");
    	sc.add("continue;");
    	sc.add("}");
    	sc.add("addWarning(warningMessage, proxy);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addAttachErrorsMethod(StringComposite sc) {
		sc.add("private void attachErrors(" + I_REFERENCE_RESOLVE_RESULT + "<?> result, " + E_OBJECT + " proxy) {");
    	sc.add("// attach errors to resource");
    	sc.add("assert result != null;");
    	sc.add(STRING + " errorMessage = result.getErrorMessage();");
    	sc.add("if (errorMessage == null) {");
    	sc.add("assert(false);");
    	sc.add("} else {");
    	sc.add("addError(errorMessage, proxy);");
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
    	sc.add("getErrors().remove(errorCand);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addGetResultElementMethod(StringComposite sc) {
		sc.add("private " + E_OBJECT + " getResultElement(" + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + "> uriFragment, " + I_REFERENCE_MAPPING + "<? extends " + E_OBJECT + "> mapping, " + E_OBJECT + " proxy, " + STRING + " errorMessage) {");
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
    	sc.add("addError(errorMessage, proxy);");
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
		sc.add("public <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" + I_CONTEXT_DEPENDANT_URI_FRAGMENT_FACTORY + "<ContainerType, ReferenceType> factory, ContainerType container, " + E_REFERENCE + " reference, " + STRING + " id, " + E_OBJECT + " proxyElement) {");
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
    	sc.add("locationMap = new " + LOCATION_MAP + "();");
    	sc.add("}");
    	sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private static final " + STRING + " ARBITRARY_SYNTAX_NAME = \"*\";");
    	sc.add("private "+ I_LOCATION_MAP + " locationMap;");
    	sc.add("private int proxyCounter = 0;");
    	sc.add("private " + MAP + "<" + STRING + ", " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + ">> internalURIFragmentMap = new " + HASH_MAP + "<" + STRING + ", " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<? extends " + E_OBJECT + ">>();");
	}

	private void generateGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + ITextResourcePluginMetaInformation.class.getName() + " getMetaInformation() {");
		sc.add("return new " + qualifiedMetaInformationClassName + "();");
		sc.add("}");
	}

	private void generateGetSyntaxNameMethod(StringComposite sc) {
		sc.add("protected String getSyntaxName() {");
		sc.add("return \"" + csSyntaxName + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void generateGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("public " + IReferenceResolverSwitch.class.getName() + " getReferenceResolverSwitch() {");
        sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new " + resolverSwitchClassName + "();");
        sc.add("}");
        sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateGetScannerMethod(StringComposite sc) {
		sc.add("public Object getScanner() {");
        sc.add("return new " + csClassName + "Lexer();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateDoSaveMethod(StringComposite sc) {
		sc.add("protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add(printerClassName + " printer = new " + printerClassName + "(outputStream, this);");
        sc.add(IReferenceResolverSwitch.class.getName() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add("for(" + E_OBJECT + " root : getContents()) {");
        sc.add("printer.print(root);");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateConstructors(StringComposite sc) {
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

	private void generateDoLoadMethod(StringComposite sc) {
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
        
        sc.add(ITextParser.class.getName() + " parser = new " + parserClassName + "().createInstance(actualInputStream, encoding);");
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

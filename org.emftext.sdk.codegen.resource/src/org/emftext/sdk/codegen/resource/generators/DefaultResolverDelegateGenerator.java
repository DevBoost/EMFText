/*******************************************************************************
 * Copyright (c) 2006-2011
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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NOTIFICATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NOTIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RUNTIME_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SETTING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;

public class DefaultResolverDelegateGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> {");
		sc.addLineBreak();
		addInnerClassStringMatchResult(sc);
		addInnerClassReferenceCache(sc);
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addInnerClassStringMatchResult(StringComposite sc) {
		sc.add("private static class StringMatch {");
		sc.addLineBreak();
		sc.add("private String exactMatch;");
		sc.add("private String similarMatch;");
		sc.addLineBreak();
		sc.add("public StringMatch() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public StringMatch(String exactMatch) {");
		sc.add("super();");
		sc.add("this.exactMatch = exactMatch;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getExactMatch() {");
		sc.add("return exactMatch;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setSimilarMatch(String similarMatch) {");
		sc.add("this.similarMatch = similarMatch;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getSimilarMatch() {");
		sc.add("return similarMatch;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClassReferenceCache(StringComposite sc) {
		sc.add("private static class ReferenceCache implements " + iReferenceCacheClassName + ", " + ADAPTER + " {");
		sc.addLineBreak();
		sc.add("private " + MAP + "<" + E_CLASS + ", " + SET + "<" + E_OBJECT +">> cache = new " + LINKED_HASH_MAP + "<" + E_CLASS + ", " + SET + "<" + E_OBJECT +">>();");
		sc.add("private boolean isInitialized;");
		sc.add("private " + NOTIFIER + " target;");
		sc.addLineBreak();
		sc.add("public " + NOTIFIER + " getTarget() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isAdapterForType(Object arg0) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void notifyChanged(" + NOTIFICATION + " arg0) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setTarget(" + NOTIFIER + " arg0) {");
		sc.add("target = arg0;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + SET + "<" + E_OBJECT + "> getObjects(" + E_CLASS + " type) {");
		sc.add("return cache.get(type);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void initialize(" + E_OBJECT + " root) {");
		sc.add("if (isInitialized) {");
		sc.add("return;");
		sc.add("}");
		sc.add("put(root);");
		sc.add(ITERATOR + "<" + E_OBJECT + "> it = root.eAllContents();");
		sc.add("while (it.hasNext()) {");
		sc.add("put(it.next());");
		sc.add("}");
		sc.add("isInitialized = true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void put(" + E_OBJECT + " object) {");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("if (!cache.containsKey(eClass)) {");
		sc.add("cache.put(eClass, new " + LINKED_HASH_SET + "<" + E_OBJECT + ">());");
		sc.add("}");
		sc.add("cache.get(eClass).add(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void clear() {");
		sc.add("cache.clear();");
		sc.add("isInitialized = false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addResolveMethod(sc);
		addFindReferencedExternalObjectsMethod(sc);
		addGetExternalObjectsMethod(sc);
		addTryToResolveIdentifierInObjectTree(sc);
		addTryToResolveIdentifierAsURI(sc);
		addCheckElementMethod(sc);
		addCastMethod(sc);
		addProduceDeResolveErrorMessage(sc);
		addDeResolveMethod(sc);
		addMatchesMethod1(sc);
		addGetNamesMethod(sc);
		addMatchesMethod2(sc);
		addGetNameMethod(sc);
		addHasCorrectTypeMethod(sc);
		addLoadResourceMethod(sc);
		addGetUriMethod(sc);
		addGetCacheMethod(sc);
		addSetEnableScopingMethod(sc);
		addGetEnableScopingMethod(sc);
		addIsSimilarMethod(sc);
	}

	private void addGetCacheMethod(StringComposite sc) {
		sc.add("protected " + iReferenceCacheClassName + " getCache(" + E_OBJECT + " object) {");
		sc.add(E_OBJECT + " root = " + eObjectUtilClassName + ".findRootContainer(object);");
		sc.add(LIST + "<" + ADAPTER + "> eAdapters = root.eAdapters();");
		sc.add("for (" + ADAPTER + " adapter : eAdapters) {");
		sc.add("if (adapter instanceof ReferenceCache) {");
		sc.add("ReferenceCache cache = (ReferenceCache) adapter;");
		sc.add("return cache;");
		sc.add("}");
		sc.add("}");
		sc.add("ReferenceCache cache = new ReferenceCache();");
		sc.add("cache.initialize(root);");
		sc.add("root.eAdapters().add(cache);");
		sc.add("return cache;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLoadResourceMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " loadResource(" + RESOURCE_SET + " resourceSet, " + URI + " uri) {");
		sc.add("try {");
		sc.add(RESOURCE + " resource = resourceSet.getResource(uri, true);");
		sc.add(E_LIST + "<" + E_OBJECT + "> contents = resource.getContents();");
		sc.add("if (contents.size() > 0) {");
		sc.add("return contents.get(0);");
		sc.add("}");
		sc.add("} catch (" + RUNTIME_EXCEPTION + " re) {");
		sc.addComment("do nothing here. if no resource can be loaded the uriString is probably not a valid resource URI");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetUriMethod(JavaComposite sc) {
		sc.add("private " + URI + " getURI(String identifier, " + URI + " baseURI) {");
		sc.add("if (identifier == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("try {");
		sc.add(URI + " uri = " + URI + ".createURI(identifier);");
		sc.add("if (uri.isRelative()) {");
		sc.add("uri = uri.resolve(baseURI);");
		sc.add("}");
		sc.add("return uri;");
		sc.add("} catch (" + ILLEGAL_ARGUMENT_EXCEPTION + " iae) {");
		sc.addComment("the identifier string is not a valid URI");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("private String getName(ReferenceType element) {");
		// this special handling for proxy objects does not belong to the
		// DefaultResolverDelegate, because the very same behavior should be
		// present when custom reference resolvers are used. therefore, this 
		// code has been added to the Printer2Generator, but remains here for 
		// compatibility reasons.
		generatorUtil.addCodeToDeresolveProxyObject(sc, iContextDependentUriFragmentClassName, "element");
		
		sc.add("if (deresolvedReference != null) {");
		sc.add("return deresolvedReference;");
		sc.add("}");
		
		sc.addComment(
			"if the referenced element was not a proxy, we try the same magic that was " +
			"used while resolving elements to obtain names for elements"
		);
		
		/*
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add("return (String) element.eGet(nameAttr);");
		sc.add("} else {");
		sc.addComment("try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " strAttribute : element.eClass().getEAllAttributes()) {");
		sc.add("if (!strAttribute.isMany() && strAttribute.getEType().getInstanceClassName().equals(\"String\")) {");
		sc.add("return (String) element.eGet(strAttribute);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + E_OPERATION + " o : element.eClass().getEAllOperations()) {");
		sc.add("if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0) {");
		sc.add("String result = (String) " + eObjectUtilClassName + ".invokeOperation(element, o);");
		sc.add("if (result != null) {");
		sc.add("return result;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		*/
		sc.add(LIST + "<Object> names = getNames(element);");
		sc.add("for (Object name : names) {");
		sc.add("if (name != null && name instanceof String) {");
		sc.add("return (String) name;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod2(StringComposite sc) {
		sc.add("private StringMatch matches(String identifier, Object attributeValue, boolean matchFuzzy) {");
		sc.add("if (attributeValue != null && attributeValue instanceof String) {");
		sc.add("String name = (String) attributeValue;");
		sc.add("if (name.equals(identifier) || matchFuzzy) {");
		sc.add("return new StringMatch(name);");
		sc.add("}");
		sc.add("if (isSimilar(name, identifier)) {");
		sc.add("StringMatch match = new StringMatch();");
		sc.add("match.setSimilarMatch(name);");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("return new StringMatch();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSimilarMethod(StringComposite sc) {
		sc.add("private boolean isSimilar(String identifier, Object attributeValue) {");
		sc.add("if (attributeValue != null && attributeValue instanceof String) {");
		sc.add("String name = (String) attributeValue;");
		sc.add("if (" + stringUtilClassName + ".computeLevenshteinDistance(identifier, name) <= MAX_DISTANCE) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod1(JavaComposite sc) {
		sc.add("private StringMatch matches(" + E_OBJECT + " element, String identifier, boolean matchFuzzy) {");
		sc.add("for (Object name : getNames(element)) {");
		sc.add("StringMatch match = matches(identifier, name, matchFuzzy);");
		sc.add("if (match.getExactMatch() != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("return new StringMatch();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNamesMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns a list of potential identifiers that may be used to reference the " +
			"given element. This method can be overridden to customize the identification " +
			"of elements.");
		// TODO it would be better if this method returned an iterator instead of a
		//      list to avoid the creation of names that will never used, because one
		//      of the previous names matched the identifier we are searching for
		sc.add("protected " + LIST + "<Object> getNames(" + E_OBJECT + " element) {");
		sc.add(LIST + "<Object> names = new " + ARRAY_LIST + "<Object>();");
		sc.addLineBreak();
		
		sc.addComment("first check for attributes that have set the ID flag to true");
		sc.add(LIST + "<" + E_ATTRIBUTE + "> attributes = element.eClass().getEAllAttributes();");
		sc.add("for (" + E_ATTRIBUTE + " attribute : attributes) {");
		sc.add("if (attribute.isID()) {");
		sc.add("Object attributeValue = element.eGet(attribute);");
		sc.add("names.add(attributeValue);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment("then check for an attribute that is called 'name'");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add("Object attributeValue = element.eGet(nameAttr);");
		sc.add("names.add(attributeValue);");
		sc.add("} else {");

		sc.addComment("try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " attribute : attributes) {");
		sc.add("if (\"java.lang.String\".equals(attribute.getEType().getInstanceClassName())) {");
		sc.add("Object attributeValue = element.eGet(attribute);");
		sc.add("names.add(attributeValue);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();

		sc.addComment("try operations without arguments that return strings and which have a name that ends with 'name'");
		sc.add("for (" + E_OPERATION + " operation : element.eClass().getEAllOperations()) {");
		sc.add("if (operation.getName().toLowerCase().endsWith(NAME_FEATURE) && operation.getEParameters().size() == 0) {");
		// TODO this will cause a ClassCastException if the operation does not return a string
		sc.add("String result = (String) " + eObjectUtilClassName + ".invokeOperation(element, operation);");
		sc.add("names.add(result);");
		sc.add("}");
		sc.add("}");
		sc.add("}");

		sc.add("return names;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("protected String deResolve(ReferenceType element, ContainerType container, " + E_REFERENCE + " reference) {");
		sc.add("return getName(element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addProduceDeResolveErrorMessage(StringComposite sc) {
		sc.add("protected String produceDeResolveErrorMessage(" + E_OBJECT + " refObject, " + E_OBJECT + " container, " + E_REFERENCE + " reference, " + iTextResourceClassName + " resource) {");
		sc.add("String msg = getClass().getSimpleName() + \": \" + reference.getEType().getName() + \" \\\"\" + refObject.toString() + \"\\\" not de-resolveable\";");
		sc.add("return msg;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCastMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method encapsulates an unchecked cast from EObject to " +
			"ReferenceType. We cannot do this cast strictly type safe, " +
			"because type parameters are erased by compilation. Thus, an " +
			"instanceof check cannot be performed at runtime."
		);
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.addLineBreak();
		sc.add("private ReferenceType cast(" + E_OBJECT + " element) {");
		sc.add("return (ReferenceType) element;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCheckElementMethod(JavaComposite sc) {
		sc.add("private boolean checkElement(" + E_OBJECT + " container, " + E_OBJECT + " element, " + E_REFERENCE + " reference, int position, " + E_CLASS + " type, String identifier, boolean resolveFuzzy, boolean checkStringWise, " + iReferenceResolveResultClassName + "<ReferenceType> result) {");
		sc.add("if (element.eIsProxy()) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("boolean hasCorrectType = hasCorrectType(element, type.getInstanceClass());");
		sc.add("if (!hasCorrectType) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("StringMatch match;");
		sc.addComment("do not compare string-wise if identifier is a URI");
		sc.add("if (checkStringWise) {");
		sc.add("match = matches(element, identifier, resolveFuzzy);");
		sc.add("} else {");
		sc.add("match = new StringMatch(identifier);");
		sc.add("}");
		sc.add("String exactMatch = match.getExactMatch();");
		sc.add("if (exactMatch == null) {");
		sc.add("String similarMatch = match.getSimilarMatch();");
		sc.add("if (similarMatch != null) {");
		sc.add(E_OBJECT + " oldTarget;");
		sc.add("Object value = container.eGet(reference);");
		sc.add("if (value instanceof " + LIST + ") {");
		sc.add(LIST + "<?> list = (" + LIST + "<?>) container.eGet(reference);");
		sc.add("oldTarget = (" + E_OBJECT + ") list.get(position);");
		sc.add("} else {");
		sc.add("oldTarget = (" + E_OBJECT + ") container.eGet(reference, false);");
		sc.add("}");
		sc.add("result.addQuickFix(new " + changeReferenceQuickFixClassName + "(\"Replace with \" + similarMatch, \"IMG_TOOL_FORWARD\", container, reference, oldTarget, element));");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addComment(
			"we can safely cast 'element' to 'ReferenceType' here, " +
			"because we've checked the type of 'element' against " +
			"the type of the reference. unfortunately the compiler " +
			"does not know that this is sufficient, so we must call " +
			"cast(), which is not type safe by itself."
		);
		sc.add("result.addMapping(exactMatch, cast(element));");
		sc.add("if (!resolveFuzzy) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This standard implementation searches for objects in the resource, which have the " +
			"correct type and a name/id attribute matching the identifier. If no matching object is " +
			"found, the identifier is used as URI. If the resource at this URI has a root element " +
			"of the correct type, this element is returned."
		);
		sc.add("protected void resolve(String identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + iReferenceResolveResultClassName + "<ReferenceType> result) {");
		sc.add("try {");
		sc.add(E_OBJECT + " root = container;");
		sc.add("if (!enableScoping) {");
		sc.add("root = " + eObjectUtilClassName + ".findRootContainer(container);");
		sc.add("}");
		sc.add("while (root != null) {");
		sc.add("boolean continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, !enableScoping);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("root = root.eContainer();");
		sc.add("}");
		sc.add("boolean continueSearch = tryToResolveIdentifierAsURI(identifier, container, reference, position, resolveFuzzy, result);");
		sc.add("if (continueSearch) {");
		sc.add(SET + "<" + E_OBJECT + "> crossReferencedObjectsInOtherResource = findReferencedExternalObjects(container);");
		sc.add("for (" + E_OBJECT + " externalObject : crossReferencedObjectsInOtherResource) {");
		sc.add("continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, externalObject, reference, position, resolveFuzzy, result, !enableScoping);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + RUNTIME_EXCEPTION + " rte) {");
		sc.addComment("catch exception here to prevent EMF proxy resolution from swallowing it");
		sc.add("rte.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindReferencedExternalObjectsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns all EObjects that are referenced by EObjects in the resource that " +
			"contains <code>object</code>, but that are located in different resources."
		);
		sc.add("private " + SET + "<" + E_OBJECT + "> findReferencedExternalObjects(" + E_OBJECT + " object) {");
		sc.add(E_OBJECT + " root = " + eObjectUtilClassName + ".findRootContainer(object);");
		
		sc.add(MAP + "<" + E_OBJECT + ", " + COLLECTION + "<" + SETTING + ">> proxies = " + ECORE_UTIL + ".ProxyCrossReferencer.find(root);");
		sc.add("int proxyCount = 0;");
		sc.add("for (" + COLLECTION + "<" + SETTING + "> settings : proxies.values()) {");
		sc.add("proxyCount += settings.size();");
		sc.add("}");
		sc.addComment("Use the cache if it is still valid");
		sc.add("if (referencedExternalObjects != null && oldProxyCount == proxyCount) {");
		sc.add("return referencedExternalObjects;");
		sc.add("}");
		sc.add("referencedExternalObjects = new " + LINKED_HASH_SET + "<" + E_OBJECT + ">();");
		sc.add("oldProxyCount = proxyCount;");
		
		sc.add(SET + "<" + E_OBJECT + "> referencedExternalObjects = new " + LINKED_HASH_SET + "<" + E_OBJECT + ">();");
		sc.add("referencedExternalObjects.addAll(getExternalObjects(root.eCrossReferences(), object));");
		sc.add(ITERATOR + "<" + E_OBJECT + "> eAllContents = root.eAllContents();");
		sc.add("while (eAllContents.hasNext()) {");
		sc.add(E_OBJECT + " next = eAllContents.next();");
		sc.add("referencedExternalObjects.addAll(getExternalObjects(next.eCrossReferences(), object));");
		sc.add("}");
		sc.add("return referencedExternalObjects;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExternalObjectsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns all EObjects that are not contained in the same resource as the given EObject."
		);
		sc.add("private " + SET + "<" + E_OBJECT + "> getExternalObjects(" + COLLECTION + "<" + E_OBJECT + "> objects, " + E_OBJECT + " object) {");
		sc.add(SET + "<" + E_OBJECT + "> externalObjects = new " + LINKED_HASH_SET + "<" + E_OBJECT + ">();");
		sc.add("for (" + E_OBJECT + " next : objects) {");
		sc.add("if (next.eResource() != object.eResource()) {");
		sc.add("externalObjects.add(next);");
		sc.add("}");
		sc.add("}");
		sc.add("return externalObjects;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTryToResolveIdentifierInObjectTree(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for objects in the tree of EObjects that is rooted at <code>root</code>, which have the " +
			"correct type and a name/id attribute matching the identifier. This method can be used to quickly " +
			"implement custom reference resolvers which require to search in a particular scope for referenced elements, " +
			"rather than in the whole resource as done by resolve()."
		);
		sc.add("protected boolean tryToResolveIdentifierInObjectTree(String identifier, " + E_OBJECT + " container, " + E_OBJECT + " root, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + iReferenceResolveResultClassName + "<ReferenceType> result, boolean checkRootFirst) {");
		sc.add(E_CLASS + " type = reference.getEReferenceType();");
		sc.add("boolean continueSearch;");
		sc.add("if (checkRootFirst) {");
		addCheckRootElementCode(sc);
		sc.add("}");
		sc.addComment("check the contents");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> iterator = root.eAllContents(); iterator.hasNext(); ) {");
		sc.add(E_OBJECT + " element = iterator.next();");
		sc.add("continueSearch = checkElement(container, element, reference, position, type, identifier, resolveFuzzy, true, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addComment("if the root element was already checked, we can return.");
		sc.add("if (checkRootFirst) {");
		sc.add("return true;");
		sc.add("}");
		addCheckRootElementCode(sc);
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCheckRootElementCode(JavaComposite sc) {
		sc.addComment("check whether the root element matches");
		sc.add("continueSearch = checkElement(container, root, reference, position, type, identifier, resolveFuzzy, true, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return false;");
		sc.add("}");
	}

	private void addTryToResolveIdentifierAsURI(JavaComposite sc) {
		sc.add("private boolean tryToResolveIdentifierAsURI(String identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + iReferenceResolveResultClassName + "<ReferenceType> result) {");
		sc.add(E_CLASS + " type = reference.getEReferenceType();");
		sc.add(RESOURCE + " resource = container.eResource();");
		sc.add("if (resource != null) {");
		sc.add(URI + " uri = getURI(identifier, resource.getURI());");
		sc.add("if (uri != null) {");
		sc.add(E_OBJECT + " element = loadResource(container.eResource().getResourceSet(), uri);");
		sc.add("if (element == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("return checkElement(container, element, reference, position, type, identifier, resolveFuzzy, false, result);");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasCorrectTypeMethod(StringComposite sc) {
		sc.add("private boolean hasCorrectType(org.eclipse.emf.ecore.EObject element, Class<?> expectedTypeClass) {");
		sc.add("return expectedTypeClass.isInstance(element);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addSetEnableScopingMethod(StringComposite sc) {
		sc.add("public void setEnableScoping(boolean enableScoping) {");
		sc.add("this.enableScoping = enableScoping;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetEnableScopingMethod(StringComposite sc) {
		sc.add("public boolean getEnableScoping() {");
		sc.add("return enableScoping;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFields(JavaComposite sc) {
		sc.add("public final static String NAME_FEATURE = \"name\";");
		sc.addJavadoc(
			"The maximal distance between two identifiers according to the " +
			"Levenshtein distance to qualify for a quick fix."
		);
		sc.add("public int MAX_DISTANCE = 2;");
		sc.addLineBreak();
		sc.add("private boolean enableScoping = true;");
		sc.addLineBreak();
		sc.addJavadoc(
			"This is a cache for the extenal objects that are referenced by the current resource. " +
			"We must cache this set because determining this set required to resolve proxy objects, " +
			"which causes reference resolving to slow down exponentially."
		);
		sc.add("private " + SET + "<" + E_OBJECT + "> referencedExternalObjects;");
		sc.addLineBreak();
		sc.addJavadoc(
			"We store the number of proxy objects that were present when <code>referencedExternalObjects</code> was " +
			"resolved, to recompute this set when a proxy was resolved. This is required, because a resolved proxy " +
			"may point to a new extenal object."
		);
		sc.add("private int oldProxyCount = -1;");
		sc.addLineBreak();
	}
}

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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RUNTIME_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class DefaultResolverDelegateGenerator extends JavaBaseGenerator {

	public DefaultResolverDelegateGenerator() {
		super();
	}

	private DefaultResolverDelegateGenerator(GenerationContext context) {
		super(context, EArtifact.DEFAULT_RESOLVER_DELEGATE);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> {");

		addFields(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addResolveMethod(sc);
		addCheckElementMethod(sc);
		addCastMethod(sc);
		addProduceDeResolveErrorMessage(sc);
		addDeResolveMethod(sc);
		addMatchesMethod1(sc);
		addMatchesMethod2(sc);
		addGetNameMethod(sc);
		addTypeCheckMethod(sc);
		addLoadResourceMethod(sc);
		addIsUriMethod(sc);
	}

	private void addLoadResourceMethod(StringComposite sc) {
		sc.add("private " + E_OBJECT + " loadResource(" + RESOURCE_SET + " resourceSet, " + STRING + " uriString) {");
		sc.add(URI + " uri = " + URI + ".createURI(uriString);");
		sc.add(RESOURCE + " resource = resourceSet.getResource(uri, true);");
		sc.add(E_LIST + "<" + E_OBJECT + "> contents = resource.getContents();");
		sc.add("if (contents.size() > 0) {");
		sc.add("return contents.get(0);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsUriMethod(StringComposite sc) {
		sc.add("private boolean isURI(" + STRING + " identifier) {");
		sc.add("if (identifier == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("try {");
		sc.add(URI + ".createURI(identifier);");
		sc.add("} catch (" + ILLEGAL_ARGUMENT_EXCEPTION + " iae) {");
		sc.add("// the identifier string is not a valid URI");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(StringComposite sc) {
		sc.add("private " + STRING + " getName(ReferenceType element) {");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if(element.eIsProxy()) {");
		sc.add(STRING + " fragment = ((" + INTERNAL_E_OBJECT + ") element).eProxyURI().fragment();");
		sc.add("if (fragment != null && fragment.startsWith(" + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + ".INTERNAL_URI_FRAGMENT_PREFIX)) {");
		sc.add("fragment = fragment.substring(" + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + ".INTERNAL_URI_FRAGMENT_PREFIX.length());");
		sc.add("fragment = fragment.substring(fragment.indexOf(\"_\") + 1);");
		sc.add("}");
		sc.add("return fragment;");
		sc.add("}");
		sc.add("else if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add("return (" + STRING + ") element.eGet(nameAttr);");
		sc.add("} else {");
		sc.add("//try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " strAttribute : element.eClass().getEAllAttributes()) {");
		sc.add("if (!strAttribute.isMany() &&");
		sc.add("strAttribute.getEType().getInstanceClassName().equals(" + STRING + ".class.getName())) {");
		sc.add("return (" + STRING + ") element.eGet(strAttribute);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + E_OPERATION + " o : element.eClass().getEAllOperations()) {");
		sc.add("if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {");
		sc.add(STRING + " result = (" + STRING + ") " + getClassNameHelper().getE_OBJECT_UTIL() + ".invokeOperation(element, o);");
		sc.add("if (result != null) {");
		sc.add("return result;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod2(StringComposite sc) {
		sc.add("private " + STRING + " matches(" + STRING + " identifier, " + OBJECT + " attributeValue, boolean matchFuzzy) {");
		sc.add("if (attributeValue != null && attributeValue instanceof " + STRING + ") {");
		sc.add(STRING + " name = (" + STRING + ") attributeValue;");
		sc.add("if (name.equals(identifier) || matchFuzzy) {");
		sc.add("return name;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod1(StringComposite sc) {
		sc.add("private " + STRING + " matches(" + E_OBJECT + " element, " + STRING + " identifier, boolean matchFuzzy) {");

		sc.add("// first check for attributes that have set the ID flag to true");
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = element.eClass().getEStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.add("if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add(E_ATTRIBUTE + " attribute = (" + E_ATTRIBUTE + ") feature;");
		sc.add("if (attribute.isID()) {");
		sc.add(OBJECT + " attributeValue = element.eGet(attribute);");
		sc.add(STRING + " match = matches(identifier, attributeValue, matchFuzzy);");
		sc.add("if (match != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// then check for an attribute that is called 'name'");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add(OBJECT + " attributeValue = element.eGet(nameAttr);");
		sc.add("return matches(identifier, attributeValue, matchFuzzy);");
		sc.add("} else {");
		sc.add("//try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " stringAttribute : element.eClass().getEAllAttributes()) {");
		sc.add("if (stringAttribute.getEType().getInstanceClassName().equals(" + STRING + ".class.getName())) {");
		sc.add(OBJECT + " attributeValue = element.eGet(stringAttribute);");
		sc.add(STRING + " match = matches(identifier, attributeValue, matchFuzzy);");
		sc.add("if (match != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("for (" + E_OPERATION + " o : element.eClass().getEAllOperations()) {");
		sc.add("if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {");
		sc.add(STRING + " result = (" + STRING + ") " + getClassNameHelper().getE_OBJECT_UTIL() + ".invokeOperation(element, o);");
		sc.add(STRING + " match = matches(identifier, result, matchFuzzy);");
		sc.add("if (match != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("protected " + STRING + " deResolve(ReferenceType element, ContainerType container, " + E_REFERENCE + " reference) {");
		sc.add("return getName(element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addProduceDeResolveErrorMessage(StringComposite sc) {
		sc.add("protected " + STRING + " produceDeResolveErrorMessage(" + E_OBJECT + " refObject, " + E_OBJECT + " container, " + E_REFERENCE + " reference, " + getClassNameHelper().getI_TEXT_RESOURCE() + " resource) {");
		sc.add(STRING + " msg = getClass().getSimpleName() + \": \" + reference.getEType().getName() + \" \\\"\" + refObject.toString() + \"\\\" not de-resolveable\";");
		sc.add("return msg;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCastMethod(StringComposite sc) {
		sc.add("// This method encapsulates an unchecked cast from EObject to");
		sc.add("// ReferenceType. We can not do this cast strictly type safe,");
		sc.add("// because type parameters are erased by compilation. Thus, an");
		sc.add("// instanceof check can not be performed at runtime.");
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.addLineBreak();
		sc.add("private ReferenceType cast(" + E_OBJECT + " element) {");
		sc.add("return (ReferenceType) element;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCheckElementMethod(StringComposite sc) {
		sc.add("private boolean checkElement(" + E_OBJECT + " element, " + E_CLASS + " type, " + STRING + " identifier, boolean resolveFuzzy, boolean checkStringWise, " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<ReferenceType> result) {");
		sc.add("if (element.eIsProxy()) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("boolean hasCorrectType = hasCorrectType(element, type.getInstanceClass());");
		sc.add("if (!hasCorrectType) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(STRING + " match;");
		sc.add("// do not compare string-wise if identifier is a URI");
		sc.add("if (checkStringWise) {");
		sc.add("match = matches(element, identifier, resolveFuzzy);");
		sc.add("} else {");
		sc.add("match = identifier;");
		sc.add("}");
		sc.add("if (match == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("// we can safely cast 'element' to 'ReferenceType' here,");
		sc.add("// because we've checked the type of 'element' against");
		sc.add("// the type of the reference. unfortunately the compiler");
		sc.add("// does not know that this is sufficient, so we must call");
		sc.add("// cast(), which is not type safe by itself.");
		sc.add("result.addMapping(match, cast(element));");
		sc.add("if (!resolveFuzzy) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveMethod(StringComposite sc) {
		sc.add("// This standard implementation searches the tree for objects of the ");
		sc.add("// correct type with a name attribute matching the identifier.");
		sc.add("protected void resolve(" + STRING + " identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<ReferenceType> result) {");
		sc.add("try {");
		sc.add(E_CLASS + " type = reference.getEReferenceType();");
		sc.add(E_OBJECT + " root = " + getClassNameHelper().getE_OBJECT_UTIL() + ".findRootContainer(container);");
		sc.add("// first check whether the root element matches");
		sc.add("boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, true, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("// then check the contents");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> iterator = root.eAllContents(); iterator.hasNext(); ) {");
		sc.add(E_OBJECT + " element = iterator.next();");
		sc.add("continueSearch = checkElement(element, type, identifier, resolveFuzzy, true, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("if (isURI(identifier)) {");
		sc.add(E_OBJECT + " element = loadResource(container.eResource().getResourceSet(), identifier);");
		sc.add("if (element == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("checkElement(element, type, identifier, resolveFuzzy, false, result);");
		sc.add("}");
		sc.add("} catch (" + RUNTIME_EXCEPTION + " rte) {");
		sc.add("// catch exception here to prevent EMF proxy resolution from swallowing it");
		sc.add("rte.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTypeCheckMethod(StringComposite sc) {
		sc.add("private boolean hasCorrectType(org.eclipse.emf.ecore.EObject element, Class<?> expectedTypeClass) {");
		sc.add("return expectedTypeClass.isInstance(element);");
		sc.add("}");
	}
	
	private void addFields(StringComposite sc) {
		sc.add("public final static " + STRING + " NAME_FEATURE = \"name\";");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new DefaultResolverDelegateGenerator(context);
	}
}

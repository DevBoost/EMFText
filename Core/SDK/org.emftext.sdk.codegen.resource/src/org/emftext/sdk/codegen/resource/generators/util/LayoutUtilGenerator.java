/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators.util;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_FACTORY;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_PACKAGE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class LayoutUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A utility class to inject/extract layout information into/from a model."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addConstants(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.add("public final String LAYOUT_PACKAGE_NS_URI = \"http://www.emftext.org/commons/layout\";");
		sc.add("public final String LAYOUT_INFORMATION_ECLASS_NAME = \"LayoutInformation\";");
		sc.add("public final String ATTRIBUTE_LAYOUT_INFORMATION_ECLASS_NAME = \"AttributeLayoutInformation\";");
		sc.add("public final String REFERENCE_LAYOUT_INFORMATION_ECLASS_NAME = \"ReferenceLayoutInformation\";");
		sc.add("public final String KEYWORD_LAYOUT_INFORMATION_ECLASS_NAME = \"KeywordLayoutInformation\";");
		sc.addLineBreak();
		sc.add("public final String SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME = \"syntaxElementID\";");
		sc.add("public final String OBJECT_EATTRIBUTE_NAME = \"object\";");
		sc.add("public final String VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME = \"visibleTokenText\";");
		sc.add("public final String HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME = \"hiddenTokenText\";");
		sc.add("public final String START_OFFSET_EATTRIBUTE_NAME = \"startOffset\";");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addTransferAllLayoutInformationToModel(sc);
		addTransferAllLayoutInformationFromModel(sc);
		addTransferLayoutInformationToModel(sc);
		addTransferLayoutInformationFromModel(sc);
		addCreateLayoutInformationModelElement(sc);
		addCreateLayoutInformation(sc);
		addGetLayoutInformationAdapterMethod(sc);
		addRemoveLayoutInformationAdapterMethod(sc);
		addRemoveLayoutInformationAdaptersMethod(sc);
		addFindLayoutReference(sc);
	}
	
	private void addTransferAllLayoutInformationToModel(JavaComposite sc) {
		sc.add("public void transferAllLayoutInformationToModel(" + E_OBJECT(sc) + " root) {");
		sc.add("transferLayoutInformationToModel(root);");
		sc.add("for (" + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> i = root.eAllContents(); i.hasNext(); ) {");
		sc.add("transferLayoutInformationToModel(i.next());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferAllLayoutInformationFromModel(JavaComposite sc) {
		sc.add("public void transferAllLayoutInformationFromModel(" + E_OBJECT(sc) + " root) {");
		sc.add("transferLayoutInformationFromModel(root);");
		sc.add("for (" + E_OBJECT(sc) + " next : new " + ARRAY_LIST(sc) + "<" + E_OBJECT(sc) + ">(root.eContents())) {");
		sc.add("transferAllLayoutInformationFromModel(next);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferLayoutInformationToModel(JavaComposite sc) {
		sc.add("public void transferLayoutInformationToModel(" + E_OBJECT(sc) + " element) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("layoutInformationAdapter.getLayoutInformations();");
		sc.add("for (" + ITERATOR(sc) + "<" + layoutInformationClassName + "> i = layoutInformationAdapter.getLayoutInformations().iterator(); i.hasNext(); ) {");
		sc.add(layoutInformationClassName + " layoutInformation = i.next();");
		sc.add(E_REFERENCE(sc) + " layoutReference = findLayoutReference(element.eClass());");
		sc.add("if (layoutReference != null) {");
		sc.add(E_OBJECT(sc) + " layoutInformationModelElement = createLayoutInformationModelElement(layoutInformation, layoutReference.getEType().getEPackage());");
		sc.add("if (layoutInformationModelElement != null) {");
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> list = (" + LIST(sc) + "<" + E_OBJECT(sc) + ">) element.eGet(layoutReference);");
		sc.add("list.add(layoutInformationModelElement);");
		sc.add("i.remove();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferLayoutInformationFromModel(JavaComposite sc) {
		sc.add("public void transferLayoutInformationFromModel(" + E_OBJECT(sc) + " element) {");
		sc.add(E_REFERENCE(sc) + " layoutReference = findLayoutReference(element.eClass());");
		sc.add("if (layoutReference != null) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> list = (" + LIST(sc) + "<" + E_OBJECT(sc) + ">) element.eGet(layoutReference);");
		sc.add("for (" + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> i = list.iterator(); i.hasNext(); ) {");
		sc.add(E_OBJECT(sc) + " layoutModelElement = i.next();");
		sc.add(layoutInformationClassName + " layoutInformation = createLayoutInformation(layoutModelElement);");
		sc.add("if (layoutInformation != null) {");
		sc.add("layoutInformationAdapter.getLayoutInformations().add(layoutInformation);");
		sc.add("i.remove();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateLayoutInformationModelElement(JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " createLayoutInformationModelElement(" + layoutInformationClassName + " layoutInformation, " + E_PACKAGE(sc) + " layoutPackage) {");
		sc.add(E_FACTORY(sc) + " factory = layoutPackage.getEFactoryInstance();");
		sc.add("Object object = layoutInformation.getObject(null, false);");
		sc.add(syntaxElementClassName + " syntaxElement = layoutInformation.getSyntaxElement();");
		sc.add(E_CLASS(sc) + " layoutInformationEClass = null;");
		sc.add(E_OBJECT(sc) + " layoutInformationModelElement = null;");
		sc.add("if (object == null) {");
		sc.addComment("keyword");
		sc.add("layoutInformationEClass = (" + E_CLASS(sc) + ") layoutPackage.getEClassifier(KEYWORD_LAYOUT_INFORMATION_ECLASS_NAME);");
		sc.add("layoutInformationModelElement = factory.create(layoutInformationEClass);");
		sc.add("} else if (object instanceof " + E_OBJECT(sc) + ") {");
		sc.addComment("reference");
		sc.add("layoutInformationEClass = (" + E_CLASS(sc) + ") layoutPackage.getEClassifier(REFERENCE_LAYOUT_INFORMATION_ECLASS_NAME);");
		sc.add("layoutInformationModelElement = factory.create(layoutInformationEClass);");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(OBJECT_EATTRIBUTE_NAME), object);");
		sc.add("} else {");
		sc.addComment("attribute");
		sc.add("layoutInformationEClass = (" + E_CLASS(sc) + ") layoutPackage.getEClassifier(ATTRIBUTE_LAYOUT_INFORMATION_ECLASS_NAME);");
		sc.add("layoutInformationModelElement = factory.create(layoutInformationEClass);");
		sc.add("}");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(START_OFFSET_EATTRIBUTE_NAME), layoutInformation.getStartOffset());");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME), layoutInformation.getHiddenTokenText());");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME), layoutInformation.getVisibleTokenText());");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME), " + grammarInformationProviderClassName + ".getSyntaxElementID(syntaxElement));");
		sc.add("return layoutInformationModelElement;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCreateLayoutInformation(JavaComposite sc) {
		sc.add("public " + layoutInformationClassName + " createLayoutInformation(" + E_OBJECT(sc) + " layoutInformationModelElement) {");
		sc.add("Object object = null;");
		sc.add(E_STRUCTURAL_FEATURE(sc) + " objectFeature = layoutInformationModelElement.eClass().getEStructuralFeature(OBJECT_EATTRIBUTE_NAME);");
		sc.add("int startOffset = (Integer) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(START_OFFSET_EATTRIBUTE_NAME));");
		sc.add("String hiddenTokenText = (String) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME));");
		sc.add("String visibleTokenText = (String) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME));");
		sc.add(syntaxElementClassName + " syntaxElement = " + grammarInformationProviderClassName + ".getSyntaxElementByID((String) layoutInformationModelElement.eGet(" +
				"layoutInformationModelElement.eClass().getEStructuralFeature(SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME)));");
		sc.add("if (objectFeature != null) {");
		sc.add("object = layoutInformationModelElement.eGet(objectFeature);");
		sc.add("} else if (syntaxElement instanceof " + placeholderClassName + ") {");
		sc.add(placeholderClassName + " placeholder = (" + placeholderClassName + ") syntaxElement;");
		sc.add(iTokenResolverClassName + " tokenResolver = new " + tokenResolverFactoryClassName + "().createTokenResolver(placeholder.getTokenName());");
		sc.add(iTokenResolveResultClassName + " result = new " + tokenResolveResultClassName + "();");
		sc.add("tokenResolver.resolve(visibleTokenText, placeholder.getFeature(), result);");
		sc.add("object = result.getResolvedToken();");
		sc.add("}");
		sc.add("return new " + layoutInformationClassName + "(syntaxElement, object, startOffset, hiddenTokenText, visibleTokenText);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLayoutInformationAdapterMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + layoutInformationAdapterClassName + " getLayoutInformationAdapter(" + E_OBJECT(sc) + " element) {");
		sc.add("for (" + ADAPTER(sc) + " adapter : element.eAdapters()) {");
		sc.add("if (adapter instanceof " + layoutInformationAdapterClassName + ") {");
		sc.add("return (" + layoutInformationAdapterClassName + ") adapter;");
		sc.add("}");
		sc.add("}");
		sc.add(layoutInformationAdapterClassName + " newAdapter = new " + layoutInformationAdapterClassName + "();");
		sc.add("element.eAdapters().add(newAdapter);");
		sc.add("return newAdapter;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRemoveLayoutInformationAdapterMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void removeLayoutInformationAdapter(" + E_OBJECT(sc) + " element) {");
		sc.add(layoutInformationAdapterClassName + " existingAdapter = getLayoutInformationAdapter(element);");
		sc.add("if (existingAdapter != null) {");
		sc.add("element.eAdapters().remove(existingAdapter);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRemoveLayoutInformationAdaptersMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void removeLayoutInformationAdapters(" + RESOURCE(sc) + " resource) {");
		sc.add(ITERATOR(sc) + "<" + E_OBJECT(sc) + "> it = resource.getAllContents();");
		sc.add("while (it.hasNext()) {");
		sc.add(E_OBJECT(sc) + " next = it.next();");
		sc.add("removeLayoutInformationAdapter(next);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFindLayoutReference(JavaComposite sc) {
		sc.add("public " + E_REFERENCE(sc) + " findLayoutReference(" + E_CLASS(sc) + " eClass) {");
		sc.add("for (" + E_REFERENCE(sc) + " ref : eClass.getEAllReferences()) {");
		sc.add(E_CLASS(sc) + " type = ref.getEReferenceType();");
		sc.add("if (LAYOUT_PACKAGE_NS_URI.equals(type.getEPackage().getNsURI()) && ref.isMany() && " +
				"LAYOUT_INFORMATION_ECLASS_NAME.equals(type.getName())) {");
		sc.add("return ref;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}

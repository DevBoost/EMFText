/*******************************************************************************
 * Copyright (c) 2006-2012
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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_FACTORY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_PACKAGE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class LayoutUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
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
		addFindLayoutReference(sc);
	}
	
	private void addTransferAllLayoutInformationToModel(JavaComposite sc) {
		sc.add("public void transferAllLayoutInformationToModel(" + E_OBJECT + " root) {");
		sc.add("transferLayoutInformationToModel(root);");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> i = root.eAllContents(); i.hasNext(); ) {");
		sc.add("transferLayoutInformationToModel(i.next());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferAllLayoutInformationFromModel(JavaComposite sc) {
		sc.add("public void transferAllLayoutInformationFromModel(" + E_OBJECT + " root) {");
		sc.add("transferLayoutInformationFromModel(root);");
		sc.add("for (" + E_OBJECT + " next : new " + ARRAY_LIST + "<" + E_OBJECT + ">(root.eContents())) {");
		sc.add("transferAllLayoutInformationFromModel(next);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferLayoutInformationToModel(JavaComposite sc) {
		sc.add("public void transferLayoutInformationToModel(" + E_OBJECT + " element) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("layoutInformationAdapter.getLayoutInformations();");
		sc.add("for (" + ITERATOR + "<" + layoutInformationClassName + "> i = layoutInformationAdapter.getLayoutInformations().iterator(); i.hasNext(); ) {");
		sc.add(layoutInformationClassName + " layoutInformation = i.next();");
		sc.add(E_REFERENCE + " layoutReference = findLayoutReference(element.eClass());");
		sc.add("if (layoutReference != null) {");
		sc.add(E_OBJECT + " layoutInformationModelElement = createLayoutInformationModelElement(layoutInformation, layoutReference.getEType().getEPackage());");
		sc.add("if (layoutInformationModelElement != null) {");
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add(LIST + "<" + E_OBJECT + "> list = (" + LIST + "<" + E_OBJECT + ">) element.eGet(layoutReference);");
		sc.add("list.add(layoutInformationModelElement);");
		sc.add("i.remove();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addTransferLayoutInformationFromModel(JavaComposite sc) {
		sc.add("public void transferLayoutInformationFromModel(" + E_OBJECT + " element) {");
		sc.add(E_REFERENCE + " layoutReference = findLayoutReference(element.eClass());");
		sc.add("if (layoutReference != null) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add(LIST + "<" + E_OBJECT + "> list = (" + LIST + "<" + E_OBJECT + ">) element.eGet(layoutReference);");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> i = list.iterator(); i.hasNext(); ) {");
		sc.add(E_OBJECT + " layoutModelElement = i.next();");
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
		sc.add("public " + E_OBJECT + " createLayoutInformationModelElement(" + layoutInformationClassName + " layoutInformation, " + E_PACKAGE + " layoutPackage) {");
		sc.add(E_FACTORY + " factory = layoutPackage.getEFactoryInstance();");
		sc.add("Object object = layoutInformation.getObject(null, false);");
		sc.add(syntaxElementClassName + " syntaxElement = layoutInformation.getSyntaxElement();");
		sc.add(E_CLASS + " layoutInformationEClass = null;");
		sc.add(E_OBJECT + " layoutInformationModelElement = null;");
		sc.add("if (object == null) {");
		sc.addComment("keyword");
		sc.add("layoutInformationEClass = (" + E_CLASS + ") layoutPackage.getEClassifier(KEYWORD_LAYOUT_INFORMATION_ECLASS_NAME);");
		sc.add("layoutInformationModelElement = factory.create(layoutInformationEClass);");
		sc.add("} else if (object instanceof " + E_OBJECT + ") {");
		sc.addComment("reference");
		sc.add("layoutInformationEClass = (" + E_CLASS + ") layoutPackage.getEClassifier(REFERENCE_LAYOUT_INFORMATION_ECLASS_NAME);");
		sc.add("layoutInformationModelElement = factory.create(layoutInformationEClass);");
		sc.add("layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(OBJECT_EATTRIBUTE_NAME), object);");
		sc.add("} else {");
		sc.addComment("attribute");
		sc.add("layoutInformationEClass = (" + E_CLASS + ") layoutPackage.getEClassifier(ATTRIBUTE_LAYOUT_INFORMATION_ECLASS_NAME);");
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
		sc.add("public " + layoutInformationClassName + " createLayoutInformation(" + E_OBJECT + " layoutInformationModelElement) {");
		sc.add("Object object = null;");
		sc.add(E_STRUCTURAL_FEATURE + " objectFeature = layoutInformationModelElement.eClass().getEStructuralFeature(OBJECT_EATTRIBUTE_NAME);");
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



	private void addGetLayoutInformationAdapterMethod(StringComposite sc) {
		sc.add("public " + layoutInformationAdapterClassName + " getLayoutInformationAdapter(" + E_OBJECT + " element) {");
		sc.add("for (" + ADAPTER + " adapter : element.eAdapters()) {");
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
	
	private void addFindLayoutReference(JavaComposite sc) {
		sc.add("public " + E_REFERENCE + " findLayoutReference(" + E_CLASS + " eClass) {");
		sc.add("for (" + E_REFERENCE + " ref : eClass.getEAllReferences()) {");
		sc.add(E_CLASS + " type = ref.getEReferenceType();");
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

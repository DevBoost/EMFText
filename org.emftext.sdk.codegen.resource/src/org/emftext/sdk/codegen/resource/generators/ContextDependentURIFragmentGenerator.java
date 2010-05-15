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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;

public class ContextDependentURIFragmentGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ContextDependentURIFragmentGenerator());

	private ContextDependentURIFragmentGenerator() {
		super();
	}
	
	private ContextDependentURIFragmentGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"Standard implementation of <code>IContextDependentURIFragment</code>.",
			"@param <ContainerType> the type of the object that contains the reference which shall be resolved by this fragment.",
			"@param <ReferenceType> the type of the reference which shall be resolved by this fragment."
		);
		sc.add("public abstract class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> implements " + iContextDependentUriFragmentClassName + "<ReferenceType> {");
		sc.addLineBreak();
		sc.add("protected String identifier;");
		sc.add("protected ContainerType container;");
		sc.add("protected " + E_REFERENCE + " reference;");
		sc.add("protected int positionInReference;");
		sc.add("protected " + E_OBJECT + " proxy;");
		sc.add("protected " + iReferenceResolveResultClassName + "<ReferenceType> result;");
		sc.addLineBreak();
		sc.add("private boolean resolving;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy) {");
		sc.add("this.identifier = identifier;");
		sc.add("this.container = container;");
		sc.add("this.reference = reference;");
		sc.add("this.positionInReference = positionInReference;");
		sc.add("this.proxy = proxy;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isResolved() {");
		sc.add("return result != null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public synchronized " + iReferenceResolveResultClassName + "<ReferenceType> resolve() {");
		sc.add("if (resolving) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("resolving = true;");
		sc.add("if (result == null || !result.wasResolved()) {");
		sc.add("result = new " + referenceResolveResultClassName + "<ReferenceType>(false);");
		sc.addComment("set an initial default error message");
		sc.add("result.setErrorMessage(getStdErrorMessage());");
		sc.addLineBreak();
		sc.add("" + iReferenceResolverClassName + "<ContainerType, ReferenceType> resolver = getResolver();");
		sc.addComment("do the actual resolving");
		sc.add("resolver.resolve(getIdentifier(), getContainer(), getReference(), getPositionInReference(), false, result);");
		sc.addLineBreak();
		sc.addComment(
			"EMFText allows proxies to resolve to multiple objects. " +
			"The first one is returned, the others are added here to the reference."
		);
		sc.add("if(result.wasResolvedMultiple()) {");
		sc.add("handleMultipleResults();");
		sc.add("}");
		sc.add("}");
		sc.add("resolving = false;");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public abstract " + iReferenceResolverClassName + "<ContainerType, ReferenceType> getResolver();");
		sc.addLineBreak();
		sc.add("private void handleMultipleResults() {");
		sc.add(E_LIST + "<" + E_OBJECT + "> list = null;");
		sc.add(OBJECT + " temp = container.eGet(reference);");
		sc.add("if (temp instanceof " + E_LIST + "<?>) {");
		sc.add("list = " + castUtilClassName + ".cast(temp);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("boolean first = true;");
		sc.add("for(" + iReferenceMappingClassName + "<ReferenceType> mapping : result.getMappings()) {");
		sc.add("if (first) {");
		sc.add("first = false;");
		sc.add("} else if (list != null) {");
		sc.add("addResultToList(mapping, proxy, list);");
		sc.add("} else {");
		sc.add(pluginActivatorClassName + ".logError(container.eClass().getName() + \".\" + reference.getName() + \" has multiplicity 1 but was resolved to multiple elements\", null);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void addResultToList(" + iReferenceMappingClassName + "<ReferenceType> mapping, " + E_OBJECT + " proxy, " + E_LIST + "<" + E_OBJECT + "> list) {");
		sc.add("" + E_OBJECT + " target = null;");
		sc.add("int proxyPosition = list.indexOf(proxy);");
		sc.addLineBreak();
		sc.add("if (mapping instanceof " + iElementMappingClassName + "<?>) {");
		sc.add("target = ((" + iElementMappingClassName + "<ReferenceType>) mapping).getTargetElement();");
		sc.add("} else if (mapping instanceof " + iUriMappingClassName + "<?>) {");
		sc.add("target = " + ECORE_UTIL + ".copy(proxy);");
		sc.add(URI + " uri = ((" + iUriMappingClassName + "<ReferenceType>) mapping).getTargetIdentifier();");
		sc.add("((" + INTERNAL_E_OBJECT + ") target).eSetProxyURI(uri);");
		sc.add("} else {");
		sc.add("assert false;");
		sc.add("}");
		sc.add("try {");
		sc.addComment(
			"if target is an another proxy and list is \"unique\" " +
			"add() will try to resolve the new proxy to check for uniqueness. " +
			"There seems to be no way to avoid that. Until now this does not " +
			"cause any problems."
		);
		sc.add("if (proxyPosition + 1 == list.size()) {");
		sc.add("list.add(target);");
		sc.add("} else {");
		sc.add("list.add(proxyPosition + 1, target);");
		sc.add("}");
		sc.add("} catch (Exception e1) {");
		sc.add("e1.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String getStdErrorMessage() {");
		sc.add("String typeName = this.getReference().getEType().getName();");
		sc.add("String msg = typeName + \" '\" + identifier + \"' not declared\";");
		sc.add("return msg;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getIdentifier() {");
		sc.add("return identifier;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public ContainerType getContainer() {");
		sc.add("return container;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_REFERENCE + " getReference() {");
		sc.add("return reference;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getPositionInReference() {");
		sc.add("return positionInReference;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getProxy() {");
		sc.add("return proxy;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ContextDependentURIFragmentGenerator(parent, context);
	}
}

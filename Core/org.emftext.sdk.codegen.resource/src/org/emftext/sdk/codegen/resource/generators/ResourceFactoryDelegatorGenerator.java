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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_FACTORY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Generates a factory that delegates to other ResourceFactories based on secondary file 
 * extensions.
 * 
 * @see org.emftext.sdk.codegen.resource.generators.ResourceFactoryGenerator
 */
@SyntaxDependent
public class ResourceFactoryDelegatorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " implements " + RESOURCE_FACTORY + " {");
        sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
    }

	private void addMethods(JavaComposite sc) {
		addInitMethod(sc);
		addGetResourceFactoriesMapMethod(sc);
		addGetFactoryForURIMethod(sc);
		addCreateResourceMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("protected " + MAP + "<String, " + RESOURCE_FACTORY + "> factories = null;");
		sc.addLineBreak();
	}

	private void addGetResourceFactoriesMapMethod(JavaComposite sc) {
		sc.add("public " + MAP + "<String, " + RESOURCE_FACTORY + "> getResourceFactoriesMap() {");
		sc.add("return factories;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("init();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFactoryForURIMethod(JavaComposite sc) {
		sc.add("public " + RESOURCE_FACTORY + " getFactoryForURI(" + URI + " uri) {");
		sc.add(URI + " trimmedURI = uri.trimFileExtension();");
		sc.add("String secondaryFileExtension = trimmedURI.fileExtension();");
		sc.add(RESOURCE_FACTORY + " factory = factories.get(secondaryFileExtension);");
		sc.add("if (factory == null) {");
		sc.add("factory = factories.get(\"\");");
		sc.add("}");
		sc.add("return factory;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateResourceMethod(JavaComposite sc) {
		sc.add("public " + RESOURCE + " createResource(" + URI + " uri) {");
		sc.add("return getFactoryForURI(uri).createResource(uri);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addInitMethod(StringComposite sc) {
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("protected void init() {");
     	sc.add("if (factories == null) {");
    	sc.add("factories = new " + LINKED_HASH_MAP + "<String, " + RESOURCE_FACTORY + ">();");
    	sc.add("}");
    	if (!removeEclipseDependentCode) {
    		sc.add("if (new " + runtimeUtilClassName + "().isEclipsePlatformAvailable()) {");
    		sc.add("new " + eclipseProxyClassName + "().getResourceFactoryExtensions(factories);");
    		sc.add("}");
    	}
    	sc.add("if (factories.get(\"\") == null) {");
    	sc.add("factories.put(\"\", new " + resourceFactoryClassName + "());");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}
}

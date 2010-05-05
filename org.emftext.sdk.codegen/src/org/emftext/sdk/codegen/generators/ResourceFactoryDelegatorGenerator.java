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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXTENSION_REGISTRY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * Generates a factory that delegates to other ResourceFactories based on secondary file 
 * extensions.
 * 
 * @see org.emftext.sdk.codegen.generators.TextResourceFactoryGenerator
 * @see org.emftext.runtime.resource.ITextResource
 */
public class ResourceFactoryDelegatorGenerator extends JavaBaseGenerator {
	
	public ResourceFactoryDelegatorGenerator() {
		super();
	}

	/**
	 * @param context the generation context
	 */
	private ResourceFactoryDelegatorGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " implements " + RESOURCE + ".Factory {");
        sc.addLineBreak();

		sc.add("protected " + MAP + "<String, " + RESOURCE + ".Factory> factories = null;");
		sc.addLineBreak();

		sc.add("public " + MAP + "<String, " + RESOURCE + ".Factory> getResourceFactoriesMap() {");
		sc.add("return factories;");
		sc.add("}");
		sc.addLineBreak();
        
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("init();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + RESOURCE + ".Factory getFactoryForURI(" + URI + " uri) {");
		sc.add(URI + " trimmedURI = uri.trimFileExtension();");
		sc.add("String secondaryFileExtension = trimmedURI.fileExtension();");
		sc.add(RESOURCE + ".Factory factory = factories.get(secondaryFileExtension);");
		sc.add("if (factory == null) {");
		sc.add("factory = factories.get(\"\");");
		sc.add("}");
		sc.add("return factory;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + RESOURCE + " createResource(" + URI + " uri) {");
		sc.add("return getFactoryForURI(uri).createResource(uri);");
		sc.add("}");
		sc.addLineBreak();
		
		addInitMethod(sc);

		sc.add("}");
    	return true;	
    }
	
	private void addInitMethod(StringComposite sc) {
		sc.add("protected void init() {");
     	sc.add("if (factories == null) {");
    	sc.add("factories = new " + LINKED_HASH_MAP + "<String, " + RESOURCE + ".Factory>();");
    	sc.add("}");
     	sc.add("if (" + PLATFORM + ".isRunning()) {");
    	sc.add(I_EXTENSION_REGISTRY + " extensionRegistry = " + PLATFORM + ".getExtensionRegistry();");
    	sc.add(I_CONFIGURATION_ELEMENT + " configurationElements[] = extensionRegistry.getConfigurationElementsFor(" + pluginActivatorClassName + ".EP_ADDITIONAL_EXTENSION_PARSER_ID);");
    	sc.add("for (" + I_CONFIGURATION_ELEMENT + " element : configurationElements) {");
    	sc.add("try {");
    	sc.add("String type = element.getAttribute(\"type\");");
    	sc.add(RESOURCE +".Factory factory = (" + RESOURCE + ".Factory) element.createExecutableExtension(\"class\");");
    	sc.add("if (type == null) {");
    	sc.add("type = \"\";");
    	sc.add("}");
    	sc.add(RESOURCE + ".Factory otherFactory = factories.get(type);");
		sc.add("if (otherFactory != null) {");
		sc.add("Class<?> superClass = factory.getClass().getSuperclass();");
		sc.add("while(superClass != Object.class) {");
		sc.add("if (superClass.equals(otherFactory.getClass())) {");
		sc.add("factories.put(type, factory);");
		sc.add("break;");
		sc.add("}");
		sc.add("superClass = superClass.getClass();");
		sc.add("}");
		sc.add("}");
		sc.add("else {");
		sc.add("factories.put(type, factory);");
		sc.add("}");
    	sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
    	sc.add(pluginActivatorClassName + ".logError(\"Exception while getting default options.\", ce);");
    	sc.add("}");
    	sc.add("}");
    	sc.add("}");
    	sc.add("if (factories.get(\"\") == null) {");
    	sc.add("factories.put(\"\", new " + resourceFactoryClassName + "());");
    	sc.add("}");
    	sc.add("}");
    	sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ResourceFactoryDelegatorGenerator(context);
	}
}

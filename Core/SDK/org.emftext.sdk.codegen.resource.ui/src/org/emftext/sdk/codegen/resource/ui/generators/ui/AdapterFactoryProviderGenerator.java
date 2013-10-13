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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSED_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ECORE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class AdapterFactoryProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"The AdapterFactoryProvider is used by the editor and " +
			"the property sheet page to obtain an EMF AdapterFactory."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetAdapterFactory(sc);
	}

	private void addGetAdapterFactory(JavaComposite sc) {
		sc.add("public " + ADAPTER_FACTORY(sc) + " getAdapterFactory() {");
		sc.add(COMPOSED_ADAPTER_FACTORY(sc) + " adapterFactory = new " + COMPOSED_ADAPTER_FACTORY(sc) + "(" + COMPOSED_ADAPTER_FACTORY(sc) + ".Descriptor.Registry.INSTANCE);");
		sc.add("adapterFactory.addAdapterFactory(new " + RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY(sc) + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + ECORE_ITEM_PROVIDER_ADAPTER_FACTORY(sc) + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY(sc) + "());");
		sc.add("return adapterFactory;");
		sc.add("}");
		sc.addLineBreak();
	}
}

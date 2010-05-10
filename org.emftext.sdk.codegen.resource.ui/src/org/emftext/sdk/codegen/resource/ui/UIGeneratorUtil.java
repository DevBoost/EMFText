package org.emftext.sdk.codegen.resource.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSED_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY;

import org.emftext.sdk.codegen.composites.StringComposite;

public class UIGeneratorUtil {

	public void addCreateAdapterFactoryCode(StringComposite sc) {
		sc.add(COMPOSED_ADAPTER_FACTORY + " adapterFactory = new " + COMPOSED_ADAPTER_FACTORY + "(" + COMPOSED_ADAPTER_FACTORY + ".Descriptor.Registry.INSTANCE);");
		sc.add("adapterFactory.addAdapterFactory(new " + RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + ECORE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
	}

}

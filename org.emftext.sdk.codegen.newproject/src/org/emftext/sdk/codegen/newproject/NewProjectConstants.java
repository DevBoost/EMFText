package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class NewProjectConstants {
	
	public final static String META_MODEL_PACKAGE = "metamodel";

	public final static IPluginDescriptor NEW_PROJECT_PLUGIN = new IPluginDescriptor() {

		public String getName(ConcreteSyntax syntax) {
			return getBasePackage(syntax);
		}

		public String getBasePackage(ConcreteSyntax syntax) {
			return null;
		}
	};
}

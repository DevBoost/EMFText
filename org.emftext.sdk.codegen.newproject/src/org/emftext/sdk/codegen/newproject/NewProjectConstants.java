package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.newproject.creators.NewProjectGenerationContext;

public class NewProjectConstants {
	
	public final static String META_MODEL_PACKAGE = "metamodel";

	public final static IPluginDescriptor<NewProjectGenerationContext> NEW_PROJECT_PLUGIN = new IPluginDescriptor<NewProjectGenerationContext>() {

		public String getName(NewProjectGenerationContext context) {
			return context.getParameters().getProjectName();
		}
	};
}

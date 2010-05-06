package org.emftext.sdk.codegen;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TextResourcePlugins {

	public final static PluginDescriptor RESOURCE_PLUGIN = new PluginDescriptor(OptionTypes.RESOURCE_PLUGIN_ID) {

		public String getName(ConcreteSyntax syntax) {
			String pluginID = OptionManager.INSTANCE.getStringOptionValue(syntax, getOption());
			if (pluginID != null) {
				// use package plug-in from option
				return pluginID;
			} else {
				// use default plug-in name
				return getBasePackage(syntax);
			}
		}

		public String getBasePackage(ConcreteSyntax syntax) {
			String basePackage = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_PACKAGE);
			if (basePackage != null) {
				// use package name from option
				return basePackage;
			} else {
				String packageName = "";
				// use default package name
				GenPackage concreteSyntaxPackage = syntax.getPackage();
				boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
				if (hasBasePackage) {
					packageName = concreteSyntaxPackage.getBasePackage() + ".";
				}
				packageName += concreteSyntaxPackage.getEcorePackage().getName();
				packageName += ".resource." + syntax.getName();
				return packageName;
			}
		}
	};
	
	public final static PluginDescriptor ANTLR_PLUGIN = new PluginDescriptor(OptionTypes.ANTLR_PLUGIN_ID) {
		
		public String getName(ConcreteSyntax syntax) {
			return "org.emftext.commons.antlr3_2_0";
		}

		@Override
		public String getBasePackage(ConcreteSyntax syntax) {
			return null;
		}
	};
}

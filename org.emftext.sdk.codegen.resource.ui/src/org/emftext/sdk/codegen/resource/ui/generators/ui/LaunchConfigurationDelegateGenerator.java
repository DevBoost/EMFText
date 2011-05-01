package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LAUNCH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LAUNCH_CONFIGURATION_DELEGATE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LaunchConfigurationDelegateGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A class that handles launch configurations" +
			(getContext().isLaunchSupportEnabled() ? "." : " (currently disabled).")
		);
		sc.add("public class " + getResourceClassName());
		if (getContext().isLaunchSupportEnabled()) {
			sc.add(" extends " + LAUNCH_CONFIGURATION_DELEGATE);
		}
		sc.add(" {");
		sc.addLineBreak();
		if (getContext().isLaunchSupportEnabled()) {
			addConstants(sc);
			addMethods(sc);
		}
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.addJavadoc("The URI of the resource that shall be launched.");
		sc.add("public final static String ATTR_RESOURCE_URI = \"uri\";");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addLaunchMethod(sc);
		addGetURIMethod(sc);
		addGetModelRootMethod(sc);
	}

	private void addLaunchMethod(JavaComposite sc) {
		final String syntaxName = getContext().getConcreteSyntax().getName();

		sc.add("public void launch(" + I_LAUNCH_CONFIGURATION + " configuration, String mode, " + I_LAUNCH + " launch, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.addComment(
				"Set the " + OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE.getLiteral() + " option to <code>false</code> to implement this method or " +
				"disable launching support by setting " + OptionTypes.DISABLE_LAUNCH_SUPPORT.getLiteral() + " to <code>true</code>.");
		sc.add("throw new RuntimeException(\"Launching " + syntaxName + " models (\" + getModelRoot(configuration) + \") is not yet implemented.\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetModelRootMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " getModelRoot(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + resourceUtilClassName + ".getResourceContent(getURI(configuration));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetURIMethod(JavaComposite sc) {
		sc.add("private " + URI + " getURI(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + URI + ".createURI(configuration.getAttribute(ATTR_RESOURCE_URI, (String) null));");
		sc.add("}");
		sc.addLineBreak();
	}
}

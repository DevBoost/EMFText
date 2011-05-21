package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_ELEMENT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_BREAKPOINT_MANAGER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_DEBUG_TARGET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugElementGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " extends " + DEBUG_ELEMENT + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("Constructs a new debug element in the given target.");
		sc.add("public " + getResourceClassName() + "(" + I_DEBUG_TARGET + " target) {");
		sc.add("super(target);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetModelIdentifierMethod(sc);
		addGetBreakpointManagerMethod(sc);
	}

	private void addGetModelIdentifierMethod(JavaComposite sc) {
		sc.add("public String getModelIdentifier() {");
		sc.add("return " + pluginActivatorClassName + ".DEBUG_MODEL_ID;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBreakpointManagerMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the breakpoint manager.",
			"@return the breakpoint manager"
		);
		sc.add("protected " + I_BREAKPOINT_MANAGER + " getBreakpointManager() {");
		sc.add("return " + DEBUG_PLUGIN + ".getDefault().getBreakpointManager();");
		sc.add("}");
		sc.addLineBreak();
	}
}

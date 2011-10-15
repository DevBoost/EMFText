package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PLATFORM;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class RuntimeUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
		sc.addComment(
			"This utility class provides methods to obtain information about the current runtime, " + 
			"for example whether Eclipse is available or not."
		);
        sc.add("public class " + getResourceClassName() + " {");
        sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
    }

	private void addMethods(JavaComposite sc) {
		addIsEclipsePlatformAvailableMethod(sc);
		addIsEclipsePlatformRunningMethod(sc);
		addLogErrorMessageMethod(sc);
	}

	private void addIsEclipsePlatformAvailableMethod(JavaComposite sc) {
		sc.add("public boolean isEclipsePlatformAvailable() {");
		sc.add("try {");
		sc.add("Class.forName(\"" + PLATFORM + "\");");
		sc.add("return true;");
		sc.add("} catch (ClassNotFoundException cnfe) {");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsEclipsePlatformRunningMethod(JavaComposite sc) {
		sc.add("public boolean isEclipsePlatformRunning() {");
		sc.add("if (!isEclipsePlatformAvailable()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return " + PLATFORM + ".isRunning();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLogErrorMessageMethod(JavaComposite sc) {
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("public void logError(String message, Throwable exception) {");
		if (!removeEclipseDependentCode) {
			sc.add("if (isEclipsePlatformAvailable()) {");
			sc.add(pluginActivatorClassName + ".logError(message, exception);");
			sc.add("return;");
			sc.add("}");
		}
		sc.add("System.err.println(message);");
		sc.add("if (exception != null) {");
		sc.add("exception.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}

package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NOTIFICATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NOTIFIER;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class LayoutInformationAdapterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + ADAPTER + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(StringComposite sc) {
		addGetTargetMethod(sc);
		addIsAdapterForTypeMethod(sc);
		addNotifyChangedMethod(sc);
		addSetTargetMethod(sc);
		addGetLayoutInformationsMethod(sc);
		addAddLayoutInformationMethod(sc);
		addReplaceProxyMethod(sc);
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + NOTIFIER + " target;");
		sc.add("private " + LIST + "<" + layoutInformationClassName + "> layoutInformations = new " + ARRAY_LIST + "<" + layoutInformationClassName + ">();");
		sc.addLineBreak();
	}

	private void addGetTargetMethod(StringComposite sc) {
		sc.add("public " + NOTIFIER + " getTarget() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsAdapterForTypeMethod(StringComposite sc) {
		sc.add("public boolean isAdapterForType(Object type) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNotifyChangedMethod(StringComposite sc) {
		sc.add("public void notifyChanged(" + NOTIFICATION + " notification) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetTargetMethod(StringComposite sc) {
		sc.add("public void setTarget(" + NOTIFIER + " newTarget) {");
		sc.add("this.target = newTarget;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLayoutInformationsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + layoutInformationClassName + "> getLayoutInformations() {");
		sc.add("return layoutInformations;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddLayoutInformationMethod(StringComposite sc) {
		sc.add("public void addLayoutInformation(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("layoutInformations.add(layoutInformation);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReplaceProxyMethod(StringComposite sc) {
		sc.add("public void replaceProxy(" + E_OBJECT + " proxy, " + E_OBJECT + " target) {");
		sc.add("for (" + layoutInformationClassName + " layoutInformation : layoutInformations) {");
		sc.add("layoutInformation.replaceProxy(proxy, target);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}

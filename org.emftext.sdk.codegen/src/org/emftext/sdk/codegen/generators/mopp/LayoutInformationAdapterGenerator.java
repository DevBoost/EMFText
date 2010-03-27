package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class LayoutInformationAdapterGenerator extends JavaBaseGenerator {

	public LayoutInformationAdapterGenerator() {
		super();
	}

	private LayoutInformationAdapterGenerator(GenerationContext context) {
		super(context, EArtifact.LAYOUT_INFORMATION_ADAPTER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new LayoutInformationAdapterGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + ADAPTER + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetTargetMethod(sc);
		addIsAdapterForTypeMethod(sc);
		addNotifyChangedMethod(sc);
		addSetTargetMethod(sc);
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + NOTIFIER + " target;");
		sc.addLineBreak();
	}

	private void addGetTargetMethod(StringComposite sc) {
		sc.add("public " + NOTIFIER + " getTarget() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsAdapterForTypeMethod(StringComposite sc) {
		sc.add("public boolean isAdapterForType(" + OBJECT + " type) {");
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

}

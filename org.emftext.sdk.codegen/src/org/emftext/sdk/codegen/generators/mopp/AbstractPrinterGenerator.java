package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public abstract class AbstractPrinterGenerator extends JavaBaseGenerator {

	private String referenceResolverSwitchClassName;

	public AbstractPrinterGenerator() {
		super();
	}

	public AbstractPrinterGenerator(GenerationContext context, EArtifact artifact) {
		super(context, artifact);
		this.referenceResolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
	}

	protected void addGetOptionsMethod(StringComposite sc) {
		sc.add("public " + MAP + "<?,?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("protected " + referenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("return (" + referenceResolverSwitchClassName + ") new " + getClassNameHelper().getMETA_INFORMATION() + "().getReferenceResolverSwitch();");
        sc.add("}");
		sc.addLineBreak();
	}

	protected String getTabString(int count) {
		return getRepeatingString(count, '\t');
	}

	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer spaces = new StringBuffer();
		for (int i = 0; i < count; i++) {
			spaces.append(character);
		}
		return spaces.toString();
	}
}

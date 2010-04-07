package org.emftext.sdk.codegen.generators.code_completion;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPARABLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class CompletionProposalGenerator extends JavaBaseGenerator {

	public CompletionProposalGenerator() {
		super();
	}

	private CompletionProposalGenerator(GenerationContext context) {
		super(context, EArtifact.COMPLETION_PROPOSAL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new CompletionProposalGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A proposal for completing an incomplete document.");
		sc.add("public class " + getResourceClassName() + " implements " + COMPARABLE + "<" + getResourceClassName() + "> {");
		addFields(sc);
		addConstructor1(sc);
		addConstructor2(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetInsertStringMethod(sc);
		addGetPrefixMethod(sc);
		addGetStartsWithPrefixMethod(sc);
		addImageMethod(sc);
		addIsStructuralFeaturemethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
	}

	private void addHashCodeMethod(StringComposite sc) {
		sc.add("public int hashCode() {");
		sc.add("return getInsertString().hashCode();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int compareTo(" + getResourceClassName() + " object) {");
		sc.add("if (object instanceof " + getResourceClassName() + ") {");
		sc.add(getResourceClassName() + " other = (" + getResourceClassName() + ") object;");
		sc.add("// proposals that start with the prefix are preferred over the ones that do not");
		sc.add("int startCompare = (startsWithPrefix ? 1 : 0) - (other.getStartsWithPrefix() ? 1 : 0);");
		sc.add("// if both proposals start with the prefix of both do not the insert string is compared");
		sc.add("return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;");
		sc.add("}");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object object) {");
		sc.add("if (object instanceof " + getResourceClassName() + ") {");
		sc.add(getResourceClassName() + " other = (" + getResourceClassName() + ") object;");
		sc.add("return other.getInsertString().equals(getInsertString());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsStructuralFeaturemethod(StringComposite sc) {
		sc.add("public boolean isStructuralFeature() {");
		sc.add("return structuralFeature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStartsWithPrefixMethod(StringComposite sc) {
		sc.add("public boolean getStartsWithPrefix() {");
		sc.add("return startsWithPrefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInsertStringMethod(StringComposite sc) {
		sc.add("public " + STRING + " getInsertString() {");
		sc.add("return insertString;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrefixMethod(StringComposite sc) {
		sc.add("public " + STRING + " getPrefix() {");
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addImageMethod(StringComposite sc) {
		sc.add("public " + IMAGE + " getImage() {");
		sc.add("return image;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + STRING + " insertString, " + STRING + " prefix, boolean startsWithPrefix, boolean structuralFeature, " + IMAGE + " image) {");
		sc.add("this(insertString, prefix, startsWithPrefix, structuralFeature);");
		sc.add("this.image = image;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + STRING + " insertString, " + STRING + " prefix, boolean startsWithPrefix, boolean structuralFeature) {");
		sc.add("super();");
		sc.add("this.insertString = insertString;");
		sc.add("this.prefix = prefix;");
		sc.add("this.startsWithPrefix = startsWithPrefix;");
		sc.add("this.structuralFeature = structuralFeature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + STRING + " insertString;");
		sc.add("private " + STRING + " prefix;");
		sc.add("private boolean startsWithPrefix;");
		sc.add("private boolean structuralFeature;");
		sc.add("private " + IMAGE + " image;");
		sc.addLineBreak();
	}
}

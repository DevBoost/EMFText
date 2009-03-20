package org.emftext.sdk.concretesyntax.resource.cs;
public class CsNewFileWizard extends org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard {
	public String getFileExtension() {
		return "cs";
	}
	public String getExampleContent() {
		return " SYNTAXDEF someConcreteSyntaxNameFOR <identifier>RULES{}";
	}
}

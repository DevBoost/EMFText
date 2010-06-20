/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTENT_ASSIST_PROCESSOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTEXT_INFORMATION_VALIDATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRING;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class CompletionProcessorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_CONTENT_ASSIST_PROCESSOR + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + editorClassName + " editor;");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addComputeCompletionProposalsMethod(sc);
		addComputeContextInformationMethod(sc);
		addGetCompletionProposalAutoActivationCharactersMethod(sc);
		addGetContextInformationAutoActivationCharactersMethod(sc);
		addGetContextInformationValidatorMethod(sc);
		addGetErrorMessageMethod(sc);
	}

	private void addGetErrorMessageMethod(StringComposite sc) {
		sc.add("public String getErrorMessage() {");
		sc.add("return null;");
		sc.add("}");
	}

	private void addGetContextInformationValidatorMethod(StringComposite sc) {
		sc.add("public " + I_CONTEXT_INFORMATION_VALIDATOR + " getContextInformationValidator() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContextInformationAutoActivationCharactersMethod(StringComposite sc) {
		sc.add("public char[] getContextInformationAutoActivationCharacters() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCompletionProposalAutoActivationCharactersMethod(StringComposite sc) {
		sc.add("public char[] getCompletionProposalAutoActivationCharacters() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeContextInformationMethod(StringComposite sc) {
		sc.add("public " + I_CONTEXT_INFORMATION + "[] computeContextInformation(" + I_TEXT_VIEWER + " viewer, int offset) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeCompletionProposalsMethod(JavaComposite sc) {
		sc.add("public " + I_COMPLETION_PROPOSAL + "[] computeCompletionProposals(" + I_TEXT_VIEWER + " viewer, int offset) {");
		sc.addLineBreak();
		sc.add(RESOURCE + " resource = editor.getResource();");
		sc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") resource;");
		sc.add(STRING + " content = viewer.getDocument().get();");
		sc.add(codeCompletionHelperClassName + " helper = new " + codeCompletionHelperClassName + "();");
		sc.add(completionProposalClassName + "[] proposals = helper.computeCompletionProposals(textResource, content, offset);");
		sc.addLineBreak();
		sc.add(I_COMPLETION_PROPOSAL + "[] result = new " + I_COMPLETION_PROPOSAL + "[proposals.length];");
		sc.add("int i = 0;");
		sc.add("for (" + completionProposalClassName + " proposal : proposals) {");
		sc.add(STRING + " proposalString = proposal.getInsertString();");
		sc.add(STRING + " prefix = proposal.getPrefix();");
		sc.add(IMAGE + " image = proposal.getImage();");
		sc.add(I_CONTEXT_INFORMATION + " info;");
		sc.add("info = new " + CONTEXT_INFORMATION + "(image, proposalString, proposalString);");
		sc.add("int begin = offset - prefix.length();");
		sc.add("int replacementLength = prefix.length();");
		sc.addComment(
			"if a closing bracket was automatically inserted right before, " +
			"we enlarge the replacement length in order to overwrite the bracket."
		);
		sc.add(iBracketHandlerClassName + " bracketHandler = editor.getBracketHandler();");
		sc.add(STRING + " closingBracket = bracketHandler.getClosingBracket();");
		sc.add("if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {");
		sc.add("replacementLength += closingBracket.length();");
		sc.add("}");
		sc.add("result[i++] = new " + COMPLETION_PROPOSAL + "(proposalString, begin, replacementLength, proposalString.length(), image, proposalString, info, proposalString);");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor) {");
		sc.add("this.editor = editor;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}

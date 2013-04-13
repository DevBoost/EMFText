/*******************************************************************************
 * Copyright (c) 2006-2013
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTENT_ASSIST_PROCESSOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTEXT_INFORMATION_VALIDATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LIST;

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
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.add("private " + iBracketHandlerProviderClassName + " bracketHandlerProvider;");
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
		sc.add(iTextResourceClassName + " textResource = resourceProvider.getResource();");
		sc.add("if (textResource == null) {");
		sc.add("return new " + I_COMPLETION_PROPOSAL + "[0];");
		sc.add("}");
		sc.add("String content = viewer.getDocument().get();");
		sc.add(codeCompletionHelperClassName + " helper = new " + codeCompletionHelperClassName + "();");
		sc.add(completionProposalClassName + "[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);");
		sc.addLineBreak();
		sc.addComment("call completion proposal post processor to allow for customizing the proposals");
		sc.add(proposalPostProcessorClassName + " proposalPostProcessor = new " + proposalPostProcessorClassName + "();");
		sc.add(LIST + "<" + completionProposalClassName + "> computedProposalList = " + ARRAYS + ".asList(computedProposals);");
		sc.add(LIST + "<" + completionProposalClassName + "> extendedProposalList = proposalPostProcessor.process(computedProposalList);");
		sc.add("if (extendedProposalList == null) {");
		sc.add("extendedProposalList = " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.add(LIST + "<" + completionProposalClassName + "> finalProposalList = new " + ARRAY_LIST + "<" + completionProposalClassName + ">();");
		sc.add("for (" + completionProposalClassName + " proposal : extendedProposalList) {");
		sc.add("if (proposal.isMatchesPrefix()) {");
		sc.add("finalProposalList.add(proposal);");
		sc.add("}");
		sc.add("}");
		
		sc.add(I_COMPLETION_PROPOSAL + "[] result = new " + I_COMPLETION_PROPOSAL + "[finalProposalList.size()];");
		sc.add("int i = 0;");
		sc.add("for (" + completionProposalClassName + " proposal : finalProposalList) {");
		sc.add("String proposalString = proposal.getInsertString();");
		sc.add("String displayString = proposal.getDisplayString();");
		sc.add("String prefix = proposal.getPrefix();");
		sc.add(IMAGE + " image = proposal.getImage();");
		sc.add(I_CONTEXT_INFORMATION + " info;");
		sc.add("info = new " + CONTEXT_INFORMATION + "(image, proposalString, proposalString);");
		sc.add("int begin = offset - prefix.length();");
		sc.add("int replacementLength = prefix.length();");
		// TODO mseifert: There has been code here that enlarged the replacement 
		//      length if a closing bracket was automatically inserted right 
		//      before (in order to overwrite the bracket). This code has been
		//      removed when the bracket handling was moved from key listeners
		//      to AutoEditStrategies. We must check whether this particular
		//      behavior is still required.
		sc.add("result[i++] = new " + COMPLETION_PROPOSAL + "(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider, " + iBracketHandlerProviderClassName + " bracketHandlerProvider) {");
		sc.add("this.resourceProvider = resourceProvider;");
		sc.add("this.bracketHandlerProvider = bracketHandlerProvider;");
		sc.add("}");
		sc.addLineBreak();
	}
}

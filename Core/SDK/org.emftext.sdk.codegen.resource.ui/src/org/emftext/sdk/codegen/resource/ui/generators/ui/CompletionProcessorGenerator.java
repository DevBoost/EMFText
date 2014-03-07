/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTENT_ASSIST_PROCESSOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTEXT_INFORMATION_VALIDATOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_VIEWER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class CompletionProcessorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_CONTENT_ASSIST_PROCESSOR(sc) + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider) {");
		sc.add("super();");
		sc.add("this.resourceProvider = resourceProvider;");
		sc.add("}");
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

	private void addGetContextInformationValidatorMethod(JavaComposite sc) {
		sc.add("public " + I_CONTEXT_INFORMATION_VALIDATOR(sc) + " getContextInformationValidator() {");
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

	private void addComputeContextInformationMethod(JavaComposite sc) {
		sc.add("public " + I_CONTEXT_INFORMATION(sc) + "[] computeContextInformation(" + I_TEXT_VIEWER(sc) + " viewer, int offset) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeCompletionProposalsMethod(JavaComposite sc) {
		sc.add("public " + I_COMPLETION_PROPOSAL(sc) + "[] computeCompletionProposals(" + I_TEXT_VIEWER(sc) + " viewer, int offset) {");
		sc.add(iTextResourceClassName + " textResource = resourceProvider.getResource();");
		sc.add("if (textResource == null) {");
		sc.add("return new " + I_COMPLETION_PROPOSAL(sc) + "[0];");
		sc.add("}");
		sc.add("String content = viewer.getDocument().get();");
		sc.add(codeCompletionHelperClassName + " helper = new " + codeCompletionHelperClassName + "();");
		sc.add(completionProposalClassName + "[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);");
		sc.addLineBreak();
		sc.addComment("call completion proposal post processor to allow for customizing the proposals");
		sc.add(proposalPostProcessorClassName + " proposalPostProcessor = new " + proposalPostProcessorClassName + "();");
		sc.add(LIST(sc) + "<" + completionProposalClassName + "> computedProposalList = " + ARRAYS(sc) + ".asList(computedProposals);");
		sc.add(LIST(sc) + "<" + completionProposalClassName + "> extendedProposalList = proposalPostProcessor.process(computedProposalList);");
		sc.add("if (extendedProposalList == null) {");
		sc.add("extendedProposalList = " + COLLECTIONS(sc) + ".emptyList();");
		sc.add("}");
		sc.add(LIST(sc) + "<" + completionProposalClassName + "> finalProposalList = new " + ARRAY_LIST(sc) + "<" + completionProposalClassName + ">();");
		sc.add("for (" + completionProposalClassName + " proposal : extendedProposalList) {");
		sc.add("if (proposal.isMatchesPrefix()) {");
		sc.add("finalProposalList.add(proposal);");
		sc.add("}");
		sc.add("}");
		
		sc.add(I_COMPLETION_PROPOSAL(sc) + "[] result = new " + I_COMPLETION_PROPOSAL(sc) + "[finalProposalList.size()];");
		sc.add("int i = 0;");
		sc.add("for (" + completionProposalClassName + " proposal : finalProposalList) {");
		sc.add("String proposalString = proposal.getInsertString();");
		sc.add("String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();");
		sc.add("String prefix = proposal.getPrefix();");
		sc.add(IMAGE(sc) + " image = proposal.getImage();");
		sc.add(I_CONTEXT_INFORMATION(sc) + " info;");
		sc.add("info = new " + CONTEXT_INFORMATION(sc) + "(image, displayString, proposalString);");
		sc.add("int begin = offset - prefix.length();");
		sc.add("int replacementLength = prefix.length();");
		// TODO mseifert: There has been code here that enlarged the replacement 
		//      length if a closing bracket was automatically inserted right 
		//      before (in order to overwrite the bracket). This code has been
		//      removed when the bracket handling was moved from key listeners
		//      to AutoEditStrategies. We must check whether this particular
		//      behavior is still required.
		sc.add("result[i++] = new " + COMPLETION_PROPOSAL(sc) + "(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}
}

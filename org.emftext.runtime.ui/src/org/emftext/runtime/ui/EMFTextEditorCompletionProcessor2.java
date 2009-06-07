package org.emftext.runtime.ui;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.impl.ExpectedCsString;
import org.emftext.runtime.resource.impl.ExpectedStructuralFeature;
import org.emftext.runtime.resource.impl.IExpectedElement;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.util.EClassUtil;
import org.emftext.runtime.util.StringUtil;

public class EMFTextEditorCompletionProcessor2 implements
	IContentAssistProcessor {

	private static final EClassUtil eClassUtil = new EClassUtil();
	private static final ICompletionProposal[] EMPTY_PROPOSAL_ARRAY = new ICompletionProposal[0];
	
	private EMFTextEditor editor;

	public EMFTextEditorCompletionProcessor2(EMFTextEditor editor) {
		this.editor = editor;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		Resource resource = editor.getResource();
		ITextResource textResource = (ITextResource) resource;
		ITextResourcePluginMetaInformation metaInformation = textResource.getMetaInformation();
		String content = viewer.getDocument().get();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
		ITextParser parser = metaInformation.createParser(inputStream, null);
		final IExpectedElement expectedElement = parser.parseToIndex(offset, null);
		if (expectedElement == null) {
			return EMPTY_PROPOSAL_ARRAY;
		}
		System.out.println("computeCompletionProposals() " + expectedElement + " for offset " + offset);
		return deriveProposals(expectedElement, content, textResource.getMetaInformation(), offset);
	}

	private ICompletionProposal[] deriveProposals(
			IExpectedElement expectedElement, String content, ITextResourcePluginMetaInformation metaInformation, int offset) {
		if (expectedElement instanceof ExpectedCsString) {
			ExpectedCsString csString = (ExpectedCsString) expectedElement;
			return deriveProposal(csString, content, offset);
		}
		if (expectedElement instanceof ExpectedStructuralFeature) {
			ExpectedStructuralFeature expectedFeature = (ExpectedStructuralFeature) expectedElement;
			EStructuralFeature feature = expectedFeature.getFeature();
			EClassifier featureType = feature.getEType();
			if (featureType instanceof EEnum) {
				EEnum enumType = (EEnum) featureType;
				return deriveProposals(enumType, content, offset);
			}
			if (feature instanceof EReference) {
				EReference refernce = (EReference) feature;
				if (featureType instanceof EClass) {
					if (refernce.isContainment()) {
						EClass classType = (EClass) featureType;
						return deriveProposals(classType, metaInformation, content, offset);
					} else {
						// TODO handle NC references
					}
				}
			} else {
				// TODO handle EAttributes
			}
		}
		return null;
	}

	private ICompletionProposal[] deriveProposals(
			EClass type,
			ITextResourcePluginMetaInformation metaInformation, 
			String content, int offset) {
		Collection<ICompletionProposal> allProposals = new ArrayList<ICompletionProposal>();
		// find all subtypes and call parseToIndex
		EClass[] availableClasses = metaInformation.getClassesWithSyntax();
		Collection<EClass> allSubClasses = eClassUtil.getSubClasses(type, availableClasses);
		for (EClass subClass : allSubClasses) {
			ITextParser parser = metaInformation.createParser(new ByteArrayInputStream(new byte[0]), null);
			final IExpectedElement expectedElement = parser.parseToIndex(0, subClass);
			if (expectedElement == null) {
				continue;
			}
			System.out.println("computeCompletionProposals() " + expectedElement + " for offset " + offset);
			ICompletionProposal[] proposals = deriveProposals(expectedElement, content, metaInformation, offset);
			for (ICompletionProposal nextProposal : proposals) {
				allProposals.add(nextProposal);
			}
		}
		return allProposals.toArray(new ICompletionProposal[allProposals.size()]);
	}

	private ICompletionProposal[] deriveProposals(EEnum enumType, String content, int offset) {
		List<EEnumLiteral> enumLiterals = enumType.getELiterals();
		ICompletionProposal[] result = new ICompletionProposal[enumLiterals.size()];
		int i = 0;
		for (EEnumLiteral literal : enumLiterals) {
			String proposal = literal.getLiteral();
			IContextInformation info = new ContextInformation(proposal,
					proposal);
			String contentBefore = content.substring(0, offset);
			String insertString = StringUtil.getMissingTail(contentBefore, proposal);
			result[i++] = new CompletionProposal(insertString, offset,
					0, insertString.length(), null, proposal, info,
					proposal);
		}
		return result;
	}

	private ICompletionProposal[] deriveProposal(ExpectedCsString csString,
			String content, int offset) {
		String proposal = csString.getValue();
		IContextInformation info = new ContextInformation(proposal,
				proposal);
		String contentBefore = content.substring(0, offset);
		String insertString = StringUtil.getMissingTail(contentBefore, proposal);
		ICompletionProposal result = new CompletionProposal(insertString, offset,
				0, insertString.length(), null, proposal, info,
				proposal);
		return new ICompletionProposal[] {result};
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}
}

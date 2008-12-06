package org.emftext.runtime.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.emftext.runtime.resource.EMFTextTreeAnalyser;
import org.emftext.runtime.resource.LocationMap;
import org.emftext.runtime.resource.ReferenceMapping;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.impl.ResolveResultImpl;
import org.emftext.runtime.ui.editor.EMFTextEditor;

public class EMFTextEditorCompletionProcessor implements
		IContentAssistProcessor {

	private static final ICompletionProposal[] EMPTY_PROPOSAL_ARRAY = new ICompletionProposal[0];
	
	private EMFTextEditor editor;

	public EMFTextEditorCompletionProcessor(EMFTextEditor editor) {
		this.editor = editor;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset) {
		long startTime = System.currentTimeMillis();
		Resource resource = editor.getResource();
		TextResource textResource = (TextResource) resource;
		LocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtChar = locationMap.getElementsAt(documentOffset);
		sortElements(elementsAtChar);
		if (elementsAtChar.size() < 2) {
			return EMPTY_PROPOSAL_ARRAY;
		}
		EObject elementAtChar = elementsAtChar.get(0);
		EObject containerAtChar = elementsAtChar.get(1);
		int start = locationMap.getCharStart(elementAtChar);
		
		// figure out prefix (is between start and documentOffset)
		String prefix;
		try {
			prefix = viewer.getDocument().get(start, documentOffset - start);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return EMPTY_PROPOSAL_ARRAY;
		}

		//TODO @mseifert: the prefix somehow has to go through the appropriate token resolver,
	    // otherwise we have different kind of identifiers in the reference resolvers
		
		EMFTextTreeAnalyser analyser = textResource.getTreeAnalyser();
		ResolveResult resolved = new ResolveResultImpl(); 
		analyser.resolve(prefix, containerAtChar, null, 0, true, resolved);
		if (!resolved.wasResolvedMultiple()) {
			return EMPTY_PROPOSAL_ARRAY;
		}
		
		List<ReferenceMapping> mappings = new ArrayList<ReferenceMapping>(resolved.getMappings());
		// sort identifiers alphabetically
		sortAlphabetically(mappings);
		ICompletionProposal[] proposals = createProposals(documentOffset, prefix,
				mappings);
		System.out.println("computeCompletionProposals() took " + (System.currentTimeMillis() - startTime) + "ms");
		return proposals;
	}

	private ICompletionProposal[] createProposals(int documentOffset,
			String prefix, Collection<ReferenceMapping> mappings) {
		ICompletionProposal[] result = new ICompletionProposal[mappings.size()];
		int i = 0;
		for (ReferenceMapping next : mappings) {
			String proposal = next.getIdentifier();
			assert proposal != null;
			IContextInformation info = new ContextInformation(proposal,
					proposal);
			String insertString = proposal.substring(prefix.length());
			result[i++] = new CompletionProposal(insertString, documentOffset,
					0, insertString.length(), null, proposal, info,
					proposal);
		}
		return result;
	}

	private void sortAlphabetically(List<ReferenceMapping> mappings) {
		Collections.sort(mappings, new Comparator<ReferenceMapping>() {
			public int compare(ReferenceMapping o1, ReferenceMapping o2) {
				return o1.getIdentifier().compareTo(o2.getIdentifier());
			}
		});
	}

	private void sortElements(List<EObject> elementsAtChar) {
		shiftProxiesToHead(elementsAtChar);
		shiftContainersToEnd(elementsAtChar);
	}

	private void shiftProxiesToHead(List<EObject> elementsAtChar) {
		// shift the proxy elements to the head of the list
		Collections.sort(elementsAtChar, new Comparator<EObject>() {
			public int compare(EObject objectA, EObject objectB) {
				boolean aIsProxy = objectA.eIsProxy();
				boolean bIsProxy = objectB.eIsProxy();
				return aIsProxy == bIsProxy ? 0 : (aIsProxy ? -1 : 1);
			}
		});
	}

	private void shiftContainersToEnd(List<EObject> elementsAtChar) {
		// shift the containers to the end of the list
		Collections.sort(elementsAtChar, new Comparator<EObject>() {
			public int compare(EObject objectA, EObject objectB) {
				boolean aContainsB = contains(objectA, objectB);
				boolean bContainsA = contains(objectB, objectA);
				if (!aContainsB && !bContainsA) {
					return 0;
				}
				if (aContainsB) {
					return 1;
				}
				if (bContainsA) {
					return -1;
				}
				return 0;
			}

			private boolean contains(EObject objectA, EObject objectB) {
				TreeIterator<EObject> it = objectA.eAllContents();
				while (it.hasNext()) {
					if (it.next() == objectB) {
						return true;
					}
				}
				return false;
			}
		});
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int documentOffset) {
		return new IContextInformation[0];
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

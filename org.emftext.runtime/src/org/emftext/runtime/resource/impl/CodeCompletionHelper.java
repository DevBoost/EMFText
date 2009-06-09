package org.emftext.runtime.resource.impl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.util.EClassUtil;

public class CodeCompletionHelper {

	private final static EClassUtil eClassUtil = new EClassUtil();

	public Collection<String> computeCompletionProposals(ITextResourcePluginMetaInformation metaInformation, String document, int offset) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(document.getBytes());
		ITextParser parser = metaInformation.createParser(inputStream, null);
		final IExpectedElement expectedElement = parser.parseToIndex(offset, null);
		if (expectedElement == null) {
			return Collections.emptyList();
		}
		System.out.println("computeCompletionProposals() " + expectedElement + " for offset " + offset);
		final Collection<String> result = deriveProposals(expectedElement, document, metaInformation, offset);
		final List<String> sortedResult = new ArrayList<String>(result);
		Collections.sort(sortedResult);
		return sortedResult;
	}

	private Collection<String> deriveProposals(
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
				EReference reference = (EReference) feature;
				if (featureType instanceof EClass) {
					if (reference.isContainment()) {
						EClass classType = (EClass) featureType;
						return deriveProposals(classType, metaInformation, content, offset);
					} else {
						// handle non-containment references
						IReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
						EObject container = expectedFeature.getContainer();
						IReferenceResolveResult<EObject> result = new ReferenceResolveResult<EObject>(true);
						// TODO mseifert: this is a hack. we must rather use token information from
						// the parser to figure out the prefix
						String prefix = findPrefix(content, offset);
						System.out.println("deriveProposals() NON-CONTAINMENT prefix = \"" + prefix + "\"");
						resolverSwitch.resolveFuzzy(prefix, container, 0, result);
						Collection<IReferenceMapping<EObject>> mappings = result.getMappings();
						if (mappings != null) {
							Collection<String> resultSet = new HashSet<String>();
							for (IReferenceMapping<EObject> mapping : mappings) {
								final String identifier = mapping.getIdentifier();
								System.out.println("deriveProposals() " + identifier);
								resultSet.add(identifier);
							}
							return resultSet;
						}
					}
				}
			} else {
				// TODO handle EAttributes
			}
		}
		return Collections.emptyList();
	}

	private String findPrefix(String content, int offset) {
		int lastSpace = content.substring(0, offset).lastIndexOf(" ");
		return content.substring(lastSpace + 1, offset);
	}

	private Collection<String> deriveProposals(
			EClass type,
			ITextResourcePluginMetaInformation metaInformation, 
			String content, int offset) {
		Collection<String> allProposals = new HashSet<String>();
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
			Collection<String> proposals = deriveProposals(expectedElement, content, metaInformation, offset);
			allProposals.addAll(proposals);
		}
		return allProposals;
	}

	private Collection<String> deriveProposals(EEnum enumType, String content, int offset) {
		Collection<EEnumLiteral> enumLiterals = enumType.getELiterals();
		Collection<String> result = new HashSet<String>();
		for (EEnumLiteral literal : enumLiterals) {
			String proposal = literal.getLiteral();
			result.add(proposal);
		}
		return result;
	}

	private Collection<String> deriveProposal(ExpectedCsString csString,
			String content, int offset) {
		String proposal = csString.getValue();
		
		Collection<String> result = new HashSet<String>(1);
		result.add(proposal);
		return result;
	}
}

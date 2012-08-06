/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.codegen.resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ContainmentLink;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * A ConstantsPool holds sets of constants that are required by generated code.
 * Since constants are not defined in the classes that use them, but in 
 * different ones, we must keep track of all required constants in order to
 * generate the classes that define the constants.
 */
public class ConstantsPool {

	/**
	 * A counter that is used to indicate the next free id in 'idMap'.
	 */
	private int idCounter = 0;
	
	/**
	 * A map that contains the terminal elements of the syntax specification
	 * (keywords and placeholders) to the name of the field that represents
	 * them.
	 */
	private Map<EObject, Integer> idMap = new LinkedHashMap<EObject, Integer>();
	
	/**
	 * A map that contains names of fields representing terminals and their
	 * follow set. This map is used to create the code that links terminals
	 * and the potential next elements (i.e., their follow set).
	 */
	private Map<String, Set<Expectation>> followSetMap = new LinkedHashMap<String, Set<Expectation>>();

	private int featureCounter = 0;
	private Map<GenFeature, String> eFeatureToConstantNameMap = new LinkedHashMap<GenFeature, String>();
	private int linkCounter = 0;
	private Map<ContainmentLink, Integer> containmentLinkToConstantNameMap = new LinkedHashMap<ContainmentLink, Integer>();

	private List<Integer[]> expectationCalls = new ArrayList<Integer[]>();
	
	public String getTerminalFieldAccessor(EObject expectedElement) {
		return "TERMINALS[" + getTerminalID(expectedElement) + "]";
	}

	public int getTerminalID(EObject expectedElement) {
		if (!idMap.containsKey(expectedElement)) {
			idMap.put(expectedElement, idCounter);
			idCounter++;
		}
		return idMap.get(expectedElement);
	}

	public void addToFollowSetMap(Definition definition, Set<Expectation> expectations) {
		// only terminals are important here
		if (definition instanceof Placeholder) {
			GenFeature feature = ((Placeholder) definition).getFeature();
			if (feature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				return;
			}
			followSetMap.put(getTerminalFieldAccessor(definition), expectations);
		} else if (definition instanceof CsString) {
			followSetMap.put(getTerminalFieldAccessor(definition), expectations);
		} else if (definition instanceof BooleanTerminal) {
			followSetMap.put(getTerminalFieldAccessor(definition), expectations);
		}
	}

	public Map<EObject, Integer> getTerminalIdMap() {
		return idMap;
	}

	public Map<String, Set<Expectation>> getFollowSetMap() {
		return followSetMap;
	}

	public String getFeatureConstantFieldName(GenFeature genFeature) {
		if (!eFeatureToConstantNameMap.keySet().contains(genFeature)) {
			String featureConstantName = "FEATURES[" + featureCounter + "]";
			featureCounter++;
			eFeatureToConstantNameMap.put(genFeature, featureConstantName);
		}
		return eFeatureToConstantNameMap.get(genFeature);
	}

	public String getContainmentLinkConstantName(ContainmentLink link) {
		return "LINKS[" + getContainmentLinkID(link) + "]";
	}
	
	public int getContainmentLinkID(ContainmentLink link) {
		if (!containmentLinkToConstantNameMap.keySet().contains(link)) {
			int linkID = linkCounter;
			linkCounter++;
			containmentLinkToConstantNameMap.put(link, linkID);
		}
		return containmentLinkToConstantNameMap.get(link);
	}
	
	public Map<GenFeature, String> getFeatureToConstantNameMap() {
		return eFeatureToConstantNameMap;
	}

	public Map<ContainmentLink, Integer> getContainmentLinkToConstantIdMap() {
		return containmentLinkToConstantNameMap;
	}

	public List<Integer[]> getExpectationCalls() {
		return expectationCalls;
	}

}

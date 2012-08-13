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
package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.ConstantsPool;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ContainmentLink;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.Pair;

public class FollowSetProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private NameUtil nameUtil = new NameUtil();
	private GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This class provides the follow sets for all terminals of " +
			"the grammar. These sets are used during code completion."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addTerminalConstants(sc);
		sc.add("}");
	}

	private void addTerminalConstants(JavaComposite sc) {
		touchAllFieldsAndLinks();

		List<String> initializeTerminalConstantsCode = addTerminalConstantFields(sc);
		List<String> initializeFeatureConstantsCode = addFeatureFields(sc);
		List<String> initializeLinkConstantsCode = addContainmentLinkFields(sc);
		
		sc.add("public final static " + containedFeatureClassName + "[] EMPTY_LINK_ARRAY = new " + containedFeatureClassName + "[0];");
		sc.addLineBreak();
		
		addLargeMethod(sc, "initializeTerminals", initializeTerminalConstantsCode, 22);
		addLargeMethod(sc, "initializeFeatures", initializeFeatureConstantsCode, 31);
		addLargeMethod(sc, "initializeLinks", initializeLinkConstantsCode, 37);
		addWireTerminalsCode(sc);

		sc.add("static {");
		sc.addComment("initialize the arrays");
		sc.add("initializeTerminals();");
		sc.add("initializeFeatures();");
		sc.add("initializeLinks();");
		sc.addComment("wire the terminals");
		sc.add("wire();");
		sc.add("}");
	}

	private void addLargeMethod(JavaComposite sc, String name, List<String> plainStatements, int bytesPerStatement) {
		List<Pair<String, Integer>> statements = new ArrayList<Pair<String,Integer>>(plainStatements.size());
		int tempCount = 0;
		for (String plainStatement : plainStatements) {
			statements.add(new Pair<String, Integer>(plainStatement, bytesPerStatement));
			tempCount++;
			if (tempCount > 200) {
				//break;
			}
		}
		sc.addLargeMethod(name, statements);
	}

	/** 
	 * Asks for all features to make sure respective fields are generated.
	 */
	private void touchAllFieldsAndLinks() {
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();
		Map<String, Set<Expectation>> followSetMap = constantsPool.getFollowSetMap();
		
		for (String firstID : followSetMap.keySet()) {
			for (Expectation expectation : followSetMap.get(firstID)) {
				List<ContainmentLink> containmentTrace = expectation.getContainmentTrace();
				for (ContainmentLink link : containmentTrace) {
					constantsPool.getFeatureConstantFieldName(link.getFeature());
				}
			}
		}
		Map<ContainmentLink, Integer> containmentLinkToConstantNameMap = constantsPool.getContainmentLinkToConstantIdMap();
		for (ContainmentLink link : containmentLinkToConstantNameMap.keySet()) {
			constantsPool.getFeatureConstantFieldName(link.getFeature());
		}
	}

	private List<String> addContainmentLinkFields(JavaComposite sc) {
		List<String> initializationCode = new ArrayList<String>();
		
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();
		Map<ContainmentLink, Integer> containmentLinkToIdMap = constantsPool.getContainmentLinkToConstantIdMap();

		int linkCount = containmentLinkToIdMap.keySet().size();
		sc.add("public final static " + containedFeatureClassName + "[] LINKS = new " + containedFeatureClassName + "[" + linkCount + "];");
		
		// generate fields for all containment links
		for (ContainmentLink link : containmentLinkToIdMap.keySet()) {
			String fieldName = constantsPool.getContainmentLinkConstantName(link);
			String classConstant = generatorUtil.getClassifierAccessor(link.getContainerClass());
			String featureConstant = constantsPool.getFeatureConstantFieldName(link.getFeature());
			//sc.add("public static " + containedFeatureClassName + " " + fieldName + ";");
			initializationCode.add(fieldName + " = new " + containedFeatureClassName + "(" + classConstant + ", " + featureConstant + ");");
		}
		sc.addLineBreak();
		return initializationCode;
	}

	private List<String> addFeatureFields(JavaComposite sc) {
		List<String> initializationCode = new ArrayList<String>();
		
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();

		Map<GenFeature, String> eFeatureToConstantNameMap = constantsPool.getFeatureToConstantNameMap();

		int featureCount = eFeatureToConstantNameMap.keySet().size();
		sc.add("public final static " + E_STRUCTURAL_FEATURE + "[] FEATURES = new " + E_STRUCTURAL_FEATURE + "[" + featureCount + "];");
		
		// generate fields for all used features
		for (GenFeature genFeature : eFeatureToConstantNameMap.keySet()) {
			String fieldName = constantsPool.getFeatureConstantFieldName(genFeature);
			
			String featureAccessor = generatorUtil.getFeatureAccessor(genFeature.getGenClass(), genFeature);
			initializationCode.add(fieldName + " = " + featureAccessor + ";");
		}
		sc.addLineBreak();
		return initializationCode;
	}

	private List<String> addTerminalConstantFields(JavaComposite sc) {
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();

		List<String> createTerminalObjectsCode = new ArrayList<String>();
		Map<EObject, Integer> idMap = constantsPool.getTerminalIdMap();
		
		int terminalCount = idMap.keySet().size();
		sc.add("public final static " + iExpectedElementClassName + " TERMINALS[] = new " + iExpectedElementClassName + "[" + terminalCount + "];");
		
		for (EObject expectedElement : idMap.keySet()) {
			int terminalID = idMap.get(expectedElement);
			
			if (expectedElement instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) expectedElement;
				GenFeature genFeature = placeholder.getFeature();
				// ignore the anonymous features
				if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
					continue;
				}

				createTerminalObjectsCode.add(addTerminalConstant(sc, terminalID, placeholder, expectedStructuralFeatureClassName));
			} else if (expectedElement instanceof CsString) {
				createTerminalObjectsCode.add(addTerminalConstant(sc, terminalID, (CsString) expectedElement, expectedCsStringClassName));
			} else if (expectedElement instanceof BooleanTerminal) {
				createTerminalObjectsCode.add(addTerminalConstant(sc, terminalID, (BooleanTerminal) expectedElement, expectedBooleanTerminalClassName));
			} else if (expectedElement instanceof EnumTerminal) {
				createTerminalObjectsCode.add(addTerminalConstant(sc, terminalID, (EnumTerminal) expectedElement, expectedEnumerationTerminalClassName));
			} else {
				throw new RuntimeException("Unknown expected element type: " + expectedElement);
			}
		}
		sc.addLineBreak();
		return createTerminalObjectsCode;
	}

	private void addWireTerminalsCode(JavaComposite sc) {
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();
		Map<String, Set<Expectation>> followSetMap = constantsPool.getFollowSetMap();

		int tempCount = 0;
		// create multiple wireX() methods
		List<Pair<String, Integer>> statements = new ArrayList<Pair<String, Integer>>();
		for (String firstID : followSetMap.keySet()) {
			for (Expectation expectation : followSetMap.get(firstID)) {
				EObject follower = expectation.getExpectedElement();
				List<ContainmentLink> containmentTrace = expectation.getContainmentTrace();
				// the method call takes 6 bytes
				int bytesUsed = 6;
				StringBuilder trace = new StringBuilder();
				if (containmentTrace.isEmpty()) {
					trace.append(", EMPTY_LINK_ARRAY");
				} else {
					trace.append(", new " + containedFeatureClassName + "[] {");
					for (ContainmentLink link : containmentTrace) {
						GenFeature genFeature = link.getFeature();
						trace.append("new ");
						trace.append(containedFeatureClassName);
						trace.append("(");
						trace.append(generatorUtil.getClassifierAccessor(link.getContainerClass()));
						trace.append(", ");
						trace.append(constantsPool.getFeatureConstantFieldName(genFeature));
						trace.append("), ");
						// another 10 bytes for each access to a constant
						bytesUsed += 10;
						tempCount++;
					}
					trace.append("}");
				}
				String methodCall = firstID + ".addFollower(" + constantsPool.getTerminalFieldAccessor(follower) + trace + ");";
				statements.add(new Pair<String, Integer>(methodCall, bytesUsed));
			}
			if (tempCount > 200) {
				break;
			}
		}
		
		sc.addLargeMethod("wire", statements);
	}

	private String addTerminalConstant(
			JavaComposite sc, 
			int terminalID,
			SyntaxElement syntaxElement,
			String className) {
		return "TERMINALS[" + terminalID + "] = new " + className + 
				"(" + grammarInformationProviderClassName + "." + nameUtil.getFieldName(syntaxElement) + ");";
	}
}

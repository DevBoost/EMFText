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
package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;

/**
 * The OperatorAnnotationsValidator inspects all rules that are annotated with
 * the 'operator' annotation. It checks whether the arguments of the annotation
 * have the correct type and whether the right sides of the annotated rule match
 * the annotation.
 */
public class OperatorAnnotationsValidator extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		if (syntax.getOperatorRules() != null
				&& !syntax.getOperatorRules().isEmpty()) {
			checkRulesWithOperatorAnnotation(resource, syntax);
			checkOperatorTypes(resource, syntax);
			checkContainmentsAndStartSymbols(resource, syntax);
		}
	}

	/**
	 * Checks if all grammar rules with operator annotations are conform to the
	 * syntactic operator constraints.
	 */
	private void checkRulesWithOperatorAnnotation(CsResource resource,
			ConcreteSyntax syntax) {

		for (Rule operatorRule : syntax.getOperatorRules()) {
			Annotation annotation = operatorRule.getOperatorAnnotation();
			String weight = annotation
					.getValue(OperatorAnnotationProperty.WEIGHT.toString());
			String identifier = annotation
					.getValue(OperatorAnnotationProperty.IDENTIFIER.toString());
			if (weight == null || identifier == null) {
				resource
						.addError(
								"Operator annotations require values for weigth and identifier.",
								annotation);
				return;
			}
			checkWeightParameter(resource, annotation, weight);
			if (annotation.getType() != AnnotationType.OP_PRIMITIVE) {
				List<Sequence> options = operatorRule.getDefinition()
						.getOptions();
				if (options.size() == 1) {
					List<Definition> definitions = options.get(0).getParts();
					if (annotation.getType() == AnnotationType.OP_LEFTASSOC
							|| annotation.getType() == AnnotationType.OP_RIGHTASSOC) {
						checkBinaryOperatorRule(resource, annotation,
								definitions);
					} else {
						checkUnaryOperatorRule(resource, annotation,
								definitions);
					}
				} else {
					resource
							.addError(
									"Non primitive operator annotations require exactly one Choice in rule.",
									operatorRule);
				}
			}
		}
	}

	/**
	 * Checks whether all operator rules with the same weight do have the same
	 * type.
	 * 
	 * @param resource
	 * @param syntax
	 */
	private void checkOperatorTypes(CsResource resource, ConcreteSyntax syntax) {
		for (String subsetIdent : syntax.getOperatorRuleSubsets()) {
			List<Rule> subset = syntax.getOperatorRuleSubset(subsetIdent);
			for (int i = 0; i < subset.size(); i++) {
				Rule firstRule = subset.get(i);
				Annotation firstAnnotation = firstRule.getOperatorAnnotation();
				String firstWeight = firstAnnotation
						.getValue(OperatorAnnotationProperty.WEIGHT.toString());
				firstWeight = firstWeight == null ? "" : firstWeight;
				for (int j = i + 1; j < subset.size(); j++) {
					Rule rule = subset.get(j);
					Annotation annotation = rule.getOperatorAnnotation();
					String weight = annotation
							.getValue(OperatorAnnotationProperty.WEIGHT
									.toString());
					if (!firstWeight.equals(weight)) {
						i = j - 1;
						break;
					} else if (firstAnnotation.getType() != annotation
							.getType()) {
						resource
								.addError(
										"All equal weight operators must be of the same operator type.",
										annotation);
					}
				}
			}
		}
	}

	/**
	 * Checks all containments to not to refer to Operator metaclasses directly
	 * since only references to the common expression metaclass (currently
	 * specified by the identifier parameter) are allowed.
	 * 
	 * @param resource
	 * @param syntax
	 */
	private void checkContainmentsAndStartSymbols(CsResource resource,
			ConcreteSyntax syntax) {
		Set<GenClass> operatorGenClasses = new HashSet<GenClass>(syntax
				.getOperatorRules().size());
		for (Rule operatorRule : syntax.getOperatorRules()) {
			operatorGenClasses.add(operatorRule.getMetaclass());
		}

		for (GenClass startSymbol : syntax.getAllStartSymbols()) {
			if (operatorGenClasses.contains(startSymbol))
				resource
						.addError(
								"Operator metaclasses cannot be used as startsymbol directly, use common expression metaclass instead.",
								startSymbol);
		}

		Collection<Rule> nonOperatorRules = new LinkedList<Rule>(syntax
				.getAllRules());
		nonOperatorRules.removeAll(syntax.getOperatorRules());
		for (Rule rule : nonOperatorRules) {
			Iterator<EObject> it = rule.eAllContents();
			while (it.hasNext()) {
				EObject eo = it.next();
				if (eo instanceof Containment) {
					Containment containment = (Containment) eo;
					if (containment.getTypes() != null
							&& containment.getTypes().isEmpty()) {
						// no explicit types given
						GenClass genClass = containment.getFeature()
								.getTypeGenClass();
						if (genClass.isAbstract() || genClass.isInterface()) {
							//check if genclass is common operator metaclass, if so skip since EMFText 
							//will generate an appropriate production (in the case ANTLR is used)  
							List<Rule> opSubset = syntax.getOperatorRuleSubset(genClass.getName());
							if(opSubset!=null&&!opSubset.isEmpty())
								continue;
							// if abstract and no common operator metaclass, check subclasses with syntax for
							// operator annotations
							ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
							Collection<GenClass> subClasses = csUtil
									.getSubClassesWithSyntax(genClass, syntax);
							for (GenClass subClass : subClasses) {
								if (operatorGenClasses.contains(subClass)) {
									resource
											.addError(
													"Implicit choice derived by EMFText refers to annotated operator rules. Please declare explicit allowed subclasses explicitely.",
													containment);
								}
							}
						} else if (operatorGenClasses.contains(genClass)) {
							resource
									.addError(
											"Operator metaclasses cannot be used directly. Common expression metaclass in Ecore model or explicit subtype required.",
											containment);
						}
					} else {
						for (GenClass genClass : containment.getTypes()) {
							if (operatorGenClasses.contains(genClass)) {
								resource
										.addError(
												"Operator metaclasses cannot be used directly. Use the expressions common metaclass instead.",
												containment);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Checks whether the parameter 'weight' is an integer.
	 * 
	 * @param resource
	 * @param annotation
	 * @param weight
	 */
	private void checkWeightParameter(CsResource resource,
			Annotation annotation, String weight) {
		try {
			Integer.parseInt(weight);
		} catch (NumberFormatException nfe) {
			resource.addError("Weight parameter must be Integer.", annotation);
		}
	}

	/**
	 * Checks the right side of a binary operator rule for correctness.
	 * 
	 * @param resource
	 * @param annotation
	 * @param definitions
	 */
	private void checkBinaryOperatorRule(CsResource resource,
			Annotation annotation, List<Definition> definitions) {
		if (definitions.size() != 3
				|| !(definitions.get(0) instanceof Containment)
				|| !isKeywordOrTerminal(definitions.get(1))
				|| !(definitions.get(2) instanceof Containment)) {
			resource
					.addError(
							"Binary operators require exactly three arguments (containment terminal containment).",
							annotation);
		}
	}

	/**
	 * Checks the right side of a unary operator rule for correctness.
	 * 
	 * @param resource
	 * @param annotation
	 * @param definitions
	 */
	private void checkUnaryOperatorRule(CsResource resource,
			Annotation annotation, List<Definition> definitions) {
		assert annotation.getType() == AnnotationType.OP_UNARY;
		if (definitions.size() != 2
				|| !(isKeywordOrTerminal(definitions.get(0)) && definitions
						.get(1) instanceof Containment)
				&& !(definitions.get(0) instanceof Containment && isKeywordOrTerminal(definitions
						.get(1)))) {
			resource
					.addError(
							"Unary operators require exactly two arguments (terminal containment, or containment terminal).",
							annotation);
		}
	}

	private boolean isKeywordOrTerminal(Definition definition) {
		return definition instanceof CsString
				|| definition instanceof Placeholder;
	}
}

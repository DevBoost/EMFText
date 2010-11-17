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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * The OperatorAnnotationsValidator inspects all rules that are annotated with
 * the 'operator' annotation. It checks whether the arguments of the annotation
 * have the correct type and whether the right sides of the annotated rule match
 * the annotation.
 */
public class OperatorAnnotationsValidator extends AbstractPostProcessor {

	private static final String OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY = "Operator classes cannot be used directly. Use the abstract expression superclass instead.";

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		List<Rule> operatorRules = syntax.getOperatorRules();
		if (operatorRules != null && !operatorRules.isEmpty()) {
			checkRulesWithOperatorAnnotation(syntax);
			checkOperatorTypes(syntax);

			Set<GenClass> operatorGenClasses = getOperatorClasses(syntax);
			checkStartSymbols(syntax, operatorGenClasses);
			checkContainmentsInOperatorRules(syntax, operatorGenClasses);
			checkContainmentsInNormalRules(syntax, operatorGenClasses);
		}
	}

	/**
	 * Checks if all grammar rules with operator annotations are conform to the
	 * syntactic operator constraints.
	 */
	private void checkRulesWithOperatorAnnotation(ConcreteSyntax syntax) {

		for (Rule operatorRule : syntax.getOperatorRules()) {
			Annotation annotation = operatorRule.getOperatorAnnotation();
			
			String weightKey = OperatorAnnotationProperty.WEIGHT.toString();
			String weightValue = annotation.getValue(weightKey);
			String superclassKey = OperatorAnnotationProperty.SUPERCLASS.toString();
			String superclassValue = annotation.getValue(superclassKey);
			String typeKey = OperatorAnnotationProperty.TYPE.toString();
			String typeValue = annotation.getValue(typeKey);
			
			if (weightValue == null || superclassValue == null || typeValue == null) {
				addProblem(
					CsAnalysisProblemType.OPERATOR_ANNOTATION_IS_MISSING_PROPERTY,
					"Operator annotations require values for properties " + weightKey + ", " + typeKey + " and " + superclassKey + ".",
					annotation
				);
				continue;
			}
			
			checkWeightParameter(annotation, weightValue);
			
			GenClass expressionMetaClass = mapIdentifierToGenClass(syntax, superclassValue);
			if (expressionMetaClass==null ||
				(!expressionMetaClass.isAbstract() && !expressionMetaClass.isInterface())){
				addProblem(
					CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY,
					"Expression superclass must be a common abstract metaclass or interface.", 
					annotation
				);
			} else {
				EClassUtil eUtil = syntax.getEClassUtil();
				if (!eUtil.isSubClass(operatorRule.getMetaclass().getEcoreClass(), expressionMetaClass.getEcoreClass())){
					addProblem(
						CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY,
						"Operator rule must be associated with a subclass of " + superclassValue,
						operatorRule
					);
				}
			}
			
			OperatorAnnotationType type = csUtil.getOperatorAnnotationType(annotation);
			if(type==null){
				String possibleValues = "Should be one of: ";
				OperatorAnnotationType[] values = OperatorAnnotationType.values();
				for (OperatorAnnotationType operatorAnnotationType : values) {
					possibleValues += operatorAnnotationType.getLiteral() + ", " ;
				}
				possibleValues = possibleValues.substring(0, possibleValues.length() - 2);
				addProblem(
					CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY,
					"Invalid operator type. " + possibleValues, 
					annotation
				);
				continue;
			}
				
			if (type != OperatorAnnotationType.PRIMITIVE) {
				List<Sequence> options = operatorRule.getDefinition()
						.getOptions();
				if (options.size() == 1) {
					List<Definition> definitions = options.get(0).getParts();
					if (type == OperatorAnnotationType.BINARY_LEFT_ASSOCIATIVE || 
						type == OperatorAnnotationType.BINARY_RIGHT_ASSOCIATIVE) {
						checkBinaryOperatorRule(syntax, annotation,
								definitions,expressionMetaClass);
					} else {
						checkUnaryOperatorRule(syntax, annotation,
								definitions, expressionMetaClass);
					}
				} else {
					addProblem(
						CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
						"Non primitive operator annotations require exactly one Choice in rule.",
						operatorRule
					);
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
	private void checkOperatorTypes(ConcreteSyntax syntax) {
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
						addProblem(
								CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY,
								"All equal weight operators must be of the same operator type.",
								annotation
						);
					}
				}
			}
			//We need at least one primitive operator rule with highest priority
			Rule lastRule = subset.get(subset.size()-1);
			Annotation annotation = lastRule.getOperatorAnnotation();
			OperatorAnnotationType annotationType = csUtil.getOperatorAnnotationType(annotation);
			if(annotationType != OperatorAnnotationType.PRIMITIVE){
				addProblem(
						CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY,
						"Each expression subset needs at least 1 primitive operator declaration with the greatest weight value of the subset.",
						annotation
				);
			}
		}
	}

	private void checkStartSymbols(ConcreteSyntax syntax,
			Set<GenClass> operatorGenClasses) {
		for (GenClass startSymbol : syntax.getActiveStartSymbols()) {
			if (operatorGenClasses.contains(startSymbol)) {
				addProblem(
						CsAnalysisProblemType.INVALID_START_SYMBOL,
						"Operator metaclasses cannot be used as startsymbol directly, use common expression metaclass instead.",
						startSymbol
				);
			}
		}
	}

	private Set<GenClass> getOperatorClasses(ConcreteSyntax syntax) {
		Set<GenClass> operatorClasses = new LinkedHashSet<GenClass>(syntax.getOperatorRules().size());
		for (Rule operatorRule : syntax.getOperatorRules()) {
			operatorClasses.add(operatorRule.getMetaclass());
		}
		return operatorClasses;
	}

	/**
	 * Checks that all containments do not have subclass restrictions.
	 * 
	 * @param resource
	 * @param syntax
	 */
	private void checkContainmentsInOperatorRules(ConcreteSyntax syntax, Set<GenClass> operatorGenClasses) {
		List<Rule> operatorRules = syntax.getOperatorRules();
		for (Rule operatorRule : operatorRules) {
			Collection<Containment> containments = CsEObjectUtil.getObjectsByType(operatorRule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
			for (Containment containment : containments) {
				List<GenClass> allowedTypes = containment.getTypes();
				if (allowedTypes.size() > 0) {
					addProblem(
						CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE, 
						"Subclass restrictions are not allowed in operator rules.", 
						containment
					);
				}
			}
		}
	}

	/**
	 * Checks that all containments do not to refer to operator classes directly.
	 * Only references to the common expression superclass (currently specified 
	 * by the parameter 'identifier') are allowed.
	 * 
	 * @param resource
	 * @param syntax
	 */
	private void checkContainmentsInNormalRules(
			ConcreteSyntax syntax, Set<GenClass> operatorGenClasses) {
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
							Collection<GenClass> subClasses = syntax
									.getSubClassesWithSyntax(genClass, false);
							for (GenClass subClass : subClasses) {
								if (operatorGenClasses.contains(subClass)) {
									addProblem(
										CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
										"Implicit choice derived by EMFText refers to annotated operator rules. Please declare explicit allowed subclasses explicitly.",
										containment
									);
								}
							}
						} else if (operatorGenClasses.contains(genClass)) {
							addProblem(
									CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
									OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY,
									containment
							);
						}
					} else {
						for (GenClass genClass : containment.getTypes()) {
							if (operatorGenClasses.contains(genClass)) {
								addProblem(
										CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
										OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY,
										containment
								);
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
	private void checkWeightParameter(Annotation annotation, String weight) {
		try {
			Integer.parseInt(weight);
		} catch (NumberFormatException nfe) {
			addProblem(CsAnalysisProblemType.OPERATOR_ANNOTATION_INVALID_PROPERTY, "Weight parameter must be Integer.", annotation);
		}
	}
	
	/**
	 * Looking up GenClass for identifier
	 * 
	 * @param syntax
	 * @param identifier
	 */
	private GenClass mapIdentifierToGenClass(ConcreteSyntax syntax, String identifier) {
		// TODO use MetaclassReferenceResolver here, look for other code
		// that resolves meta class identifiers in operation rules and
		// replace it with a call to this method
		GenClassFinder finder = new GenClassFinder();
		Set<GenClass> genClasses = finder.findAllGenClasses(syntax,true,true);
		for (GenClass genClass : genClasses) {
			if (genClass.getName().equals(identifier)) {
				return genClass;
			}
		}
		return null;
	}

	/**
	 * Checks the right side of a binary operator rule for correctness.
	 * 
	 * @param resource
	 * @param annotation
	 * @param definitions
	 */
	private void checkBinaryOperatorRule(ConcreteSyntax syntax,
			Annotation annotation, List<Definition> definitions, GenClass commonMetaClass) {
		if (definitions.size() < 2 
				|| !(definitions.get(0) instanceof Containment)
				|| !(definitions.get(definitions.size()-1) instanceof Containment)) {
			addProblem(
				CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
				"Rules for binary operators must be structured as follows : containment [arbitrary sequence] containment.",
				annotation
			);
			return;
		}
		if (commonMetaClass != null) {
			checkContainment(syntax, commonMetaClass,(Containment)definitions.get(0));
			checkContainment(syntax, commonMetaClass,(Containment)definitions.get(definitions.size()-1));
		}
	}

	/**
	 * Checks the right side of a unary operator rule for syntactical correctness.
	 * 
	 * @param resource
	 * @param annotation
	 * @param definitions
	 */
	private void checkUnaryOperatorRule(ConcreteSyntax syntax,
			Annotation annotation, List<Definition> definitions, GenClass commonMetaClass) {
		OperatorAnnotationType annotationType = csUtil.getOperatorAnnotationType(annotation);
		
		int containmentIndex = -1;
		if(annotationType == OperatorAnnotationType.UNARY_PREFIX){
			containmentIndex = definitions.size()-1;
		}
		else{
			assert annotationType == OperatorAnnotationType.UNARY_POSTFIX;
			containmentIndex = 0;
		}
		
		if (definitions.size() < 2
				|| !(definitions.get(containmentIndex) instanceof Containment)) {
			addProblem(
				CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE,
				"Rules for unary operators require no less than two arguments: " +
				"[arbitrary sequence] containment for prefix " +
				"or containment [arbitrary sequence] " +
				"for postfix (left recursive) operators.",
				annotation
			);
			return;
		}
		if (commonMetaClass != null) {
			checkContainment(syntax, commonMetaClass,(Containment)definitions.get(containmentIndex));
		}
	}

	/**
	 * Checks if the containment does not have explicit metaclass choices since these are ignored and
	 * checks if the containments GenFeature typeGenClass is equal to the common expression meta class
	 * or if it is a super type.
	 * 
	 * @param resource
	 * @param commonMetaClass
	 * @param containment
	 */
	private void checkContainment(ConcreteSyntax syntax, GenClass commonMetaClass, Containment containment){
		if (containment.getTypes() != null && !containment.getTypes().isEmpty()) {
			addProblem(
					CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE, 
					"Subclass restrictions are not allowed in operator rules.",
					containment
			);
		}
		GenClass containmentClass = containment.getFeature().getTypeGenClass();
		if (!containmentClass.equals(commonMetaClass)){
			EClassUtil eUtil = syntax.getEClassUtil();

			if(!eUtil.isSubClass(commonMetaClass.getEcoreClass(),containmentClass.getEcoreClass())){
				addProblem(
						CsAnalysisProblemType.OPERATOR_ANNOTATION_MALFORMED_RULE, 
						"Argument types must be equal or a super type of the common metaclass.",
						containment
				);
			}
		}
	}
	
}

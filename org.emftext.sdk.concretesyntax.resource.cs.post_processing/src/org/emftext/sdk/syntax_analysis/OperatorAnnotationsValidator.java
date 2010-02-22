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
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.EClassUtil;

/**
 * The OperatorAnnotationsValidator inspects all rules that are annotated with
 * the 'operator' annotation. It checks whether the arguments of the annotation
 * have the correct type and whether the right sides of the annotated rule match
 * the annotation.
 */
public class OperatorAnnotationsValidator extends AbstractPostProcessor {

	private static final String OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY = "Operator classes cannot be used directly. Use the abstract expression superclass instead.";

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
			
			GenClass expressionMetaClass = mapIdentifierToGenClass(syntax, identifier);
			//TODO: sven: we should also check for genclass prefixes or use full qualified names
			if(expressionMetaClass==null||(!expressionMetaClass.isAbstract()&&!expressionMetaClass.isInterface())){
				resource.addError("Expression idenfitier must map to a common abstract metaclass or interface.",annotation);
			}
			else{
				EClassUtil eUtil = new EClassUtil();
				if(!eUtil.isSubClass(operatorRule.getMetaclass().getEcoreClass(), expressionMetaClass.getEcoreClass())){
					resource.addError("Operator rule must be associated with a subclass of "+identifier,operatorRule);
				}		
			}
			
			if (annotation.getType() != AnnotationType.OP_PRIMITIVE) {
				List<Sequence> options = operatorRule.getDefinition()
						.getOptions();
				if (options.size() == 1) {
					List<Definition> definitions = options.get(0).getParts();
					if (annotation.getType() == AnnotationType.OP_LEFTASSOC
							|| annotation.getType() == AnnotationType.OP_RIGHTASSOC) {
						checkBinaryOperatorRule(resource, annotation,
								definitions,expressionMetaClass);
					} else {
						checkUnaryOperatorRule(resource, annotation,
								definitions,expressionMetaClass);
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
									.getSubClassesWithSyntax(genClass, syntax, false);
							for (GenClass subClass : subClasses) {
								if (operatorGenClasses.contains(subClass)) {
									resource
											.addError(
													"Implicit choice derived by EMFText refers to annotated operator rules. Please declare explicit allowed subclasses explicitly.",
													containment);
								}
							}
						} else if (operatorGenClasses.contains(genClass)) {
							resource
									.addError(
											OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY,
											containment);
						}
					} else {
						for (GenClass genClass : containment.getTypes()) {
							if (operatorGenClasses.contains(genClass)) {
								resource
										.addError(
												OPERATOR_CLASSES_CANNOT_BE_USED_DIRECTLY,
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
	 * Looking up GenClass for identifier
	 * 
	 * @param syntax
	 * @param identifier
	 */
	private GenClass mapIdentifierToGenClass(ConcreteSyntax syntax, String identifier){
		//This is stupid because a resolver should do it
		GenClassFinder finder = new GenClassFinder();
		Set<GenClass> genClasses = finder.findAllGenClasses(syntax,false,true);
		for(GenClass genClass:genClasses){
			if(genClass.getName().equals(identifier)){
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
	private void checkBinaryOperatorRule(CsResource resource,
			Annotation annotation, List<Definition> definitions, GenClass commonMetaClass) {
		if (definitions.size() != 3
				|| !(definitions.get(0) instanceof Containment)
				|| !isKeywordOrTerminal(definitions.get(1))
				|| !(definitions.get(2) instanceof Containment)) {
			resource
					.addError(
							"Rules for binary operators require exactly three arguments (containment terminal containment).",
							annotation);
			return;
		}
		if(commonMetaClass!=null){
			checkContainment(resource,commonMetaClass,(Containment)definitions.get(0));
			checkContainment(resource,commonMetaClass,(Containment)definitions.get(2));
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
			Annotation annotation, List<Definition> definitions, GenClass commonMetaClass) {
		assert annotation.getType() == AnnotationType.OP_UNARY;
		if (definitions.size() != 2
				|| !(isKeywordOrTerminal(definitions.get(0)) && definitions
						.get(1) instanceof Containment)
				&& !(definitions.get(0) instanceof Containment && isKeywordOrTerminal(definitions
						.get(1)))) {
			resource
					.addError(
							"Rules for unary operators require exactly two arguments (terminal containment, or containment terminal).",
							annotation);
			return;
		}
		if(commonMetaClass!=null){
			if(definitions.get(0) instanceof Containment){
				checkContainment(resource,commonMetaClass,(Containment)definitions.get(0));
			}
			else{
				checkContainment(resource,commonMetaClass,(Containment)definitions.get(1));
			}
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
	private void checkContainment(CsResource resource,GenClass commonMetaClass, Containment containment){
		if(containment.getTypes()!=null&&!containment.getTypes().isEmpty()){
			resource.addError("Subclass restrictions are not allowed in operator rules.",containment);
		}
		GenClass containmentClass = containment.getFeature().getTypeGenClass();
		if(!containmentClass.equals(commonMetaClass)){
			EClassUtil eUtil = new EClassUtil();
			if(!eUtil.isSubClass(commonMetaClass.getEcoreClass(),containmentClass.getEcoreClass())){
				resource.addError("Argument types must be equal or a super type of the common metaclass.",containment);
			}
		}
	}
	
	private boolean isKeywordOrTerminal(Definition definition) {
		return definition instanceof CsString
				|| definition instanceof Placeholder;
	}
}

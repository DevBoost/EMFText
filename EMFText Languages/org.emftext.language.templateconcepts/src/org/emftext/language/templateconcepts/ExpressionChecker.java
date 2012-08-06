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
package org.emftext.language.templateconcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.emftext.language.primitivetypes.helper.PrimitiveTypesHelper;
import org.emftext.language.templateconcepts.ForEach;
import org.emftext.language.templateconcepts.Placeholder;
import org.emftext.language.templateconcepts.Template;
import org.emftext.language.templateconcepts.TemplateConcept;
import org.emftext.language.templateconcepts.TemplateconceptsPackage;


/**
 * An ExpressionChecker can be used to check and evaluate OCL queries
 * in templates. Examples for such queries are conditions (in IF elements),
 * collectionSelectors (in FOR loops) and the expressions in placeholders.
 *
 * TODO when checking (and evaluating) OCL queries inside of (potentially
 * nested) loops, the context class is different. Instead of using the meta
 * class of the input model root element, we must use the type returned by
 * the collection that contains the expression.
 *
 * TODO adjust this checking to the one done in the interpreter
 *
 * TODO clean this mess up
 */
public class ExpressionChecker  {

	public static interface ErrorReporter {
		void report(EObject element, String message);
	}

	public void process(Resource resource, ErrorReporter errorReporter) {
		List<EObject> templates = getObjectsByType(resource, TemplateconceptsPackage.eINSTANCE.getTemplate());
		if (templates.size() < 1) {
			return;
		}
		Template template = (Template) templates.get(0);
		EObject inputMetaClass = template.getInputMetaClass();
		EClass metaClass = (EClass) inputMetaClass;
		if (metaClass == null) {
			return;
		}

		Map<String, EObject> variables = new HashMap<String, EObject>();
		List<EObject> contents = template.eContents();
		check(errorReporter, metaClass, contents, variables);
	}

	private void check(ErrorReporter errorReporter,  EClass metaClass,
			List<EObject> contents, Map<String, EObject> variables) {
		for (EObject next : contents) {
			if (next instanceof TemplateConcept) {
				check(errorReporter, metaClass, (TemplateConcept) next, variables);
			} else {
				check(errorReporter, metaClass, next.eContents(), variables);
			}
		}
	}

	private void check(ErrorReporter errorReporter, EClass metaClass,
			TemplateConcept concept, Map<String, EObject> variables) {
		final String expression = concept.getExpression();
		final Object errorOrQuery = createQuery(metaClass, variables, expression);
		if (errorOrQuery instanceof String) {
			final String error = (String) errorOrQuery;
			errorReporter.report(concept, "The expression \"" + expression + "\" is invalid (" + error + ").");
		} else {
			if (concept instanceof ForEach) {
				ForEach forEach = (ForEach) concept;
				@SuppressWarnings("unchecked")
				Query<EClassifier, EClass, EObject> query = (Query<EClassifier, EClass, EObject>) errorOrQuery;

				EClassifier resultType = query.getExpression().getType();
				System.out.println("result type of (" + concept.getExpression() + ") is " + resultType);
				if (resultType instanceof OrderedSetType) {
					OrderedSetType setType = (OrderedSetType) resultType;
					EClassifier elementType = setType.getElementType();
					assert elementType instanceof EClass;
					// change the meta class
					metaClass = (EClass) elementType;
					String variable = forEach.getVariable();
					if (variable != null) {
						variables.put(variable, metaClass.getEPackage().getEFactoryInstance().create(metaClass));
					}
					System.out.println("element type of (" + concept.getExpression() + ") is " + elementType);
				}
			}
			// for placeholders we must check the type
			if (concept instanceof Placeholder) {
				checkPlaceholderExpressionType(errorReporter, metaClass,
						concept, expression);
			}
			check(errorReporter, metaClass, concept.eContents(), variables);
			// TODO remove variables
		}
	}

	private void checkPlaceholderExpressionType(ErrorReporter errorReporter,
			EClass metaClass, TemplateConcept concept, String expression) {
		Object queryOrError = createQuery(metaClass, null, expression);
		if (queryOrError instanceof Query) {
			Query<?,?,?> query = (Query<?,?,?>) queryOrError;

			// first, we need the type of the expression in the placeholder
			Object expressionType = query.getExpression().getType();
			//System.out.println("placeholder expression type = " + expressionType);

			// then, we must figure out, from which primitive type the expression
			// type inherits
			final Object placeHolderExpressionPrimitiveType = PrimitiveTypesHelper.getPrimitiveType(expressionType);
			//System.out.println("placeholder expression primitive type = " + placeHolderExpressionPrimitiveType);

			// now that we know about the primitive type of the expression, we
			// must obtain the type of the target of the placeholder. therefore,
			// we take the type of the reference that holds the placeholder
			EClassifier placeholderReferenceType = concept.eContainingFeature().getEType();
			//System.out.println("placeholder reference type = " + placeholderReferenceType);

			// since the type of the reference is always abstract, we must search for
			// the one subclass that is used in the object language to hold attribute
			// values
			EClass boxedAttributeType = getBoxedAttributeType(placeholderReferenceType);
			//System.out.println("placeholder boxed attribute type = " + boxedAttributeType);

			// once we have the concrete class that holds the attribute we must figure out
			// the primitive type, i.e., the superclass from the primitive types package
			final Object placeHolderTargetPrimitiveType = PrimitiveTypesHelper.getPrimitiveType(boxedAttributeType);
			//System.out.println("placeholder target has primitive type = " + placeHolderTargetPrimitiveType);

			// now we have both the primitive type of the expression and the target of the
			// placeholder. lets compare them...
			if (placeHolderExpressionPrimitiveType == null || !placeHolderExpressionPrimitiveType.equals(placeHolderTargetPrimitiveType)) {
				errorReporter.report(concept,
						"The expression in the placeholder has wrong type (was " + placeHolderExpressionPrimitiveType + ", expected " + placeHolderTargetPrimitiveType + ")");
			}
		} else {
			System.out.println("Error while checking placeholder - error: " + queryOrError);
		}
	}

	private EClass getBoxedAttributeType(EClassifier abstractReferenceType) {
		if (!(abstractReferenceType instanceof EClass)) {
			return null;
		}
		EClass typeClass = (EClass) abstractReferenceType;
		List<EClassifier> allTypesInPackage = typeClass.getEPackage().getEClassifiers();
		for (EClassifier subTypeCandidate : allTypesInPackage) {
			if (subTypeCandidate instanceof EClass) {
				EClass subClassCandidate = (EClass) subTypeCandidate;
				if (subClassCandidate.getEAllSuperTypes().contains(abstractReferenceType)) {
					return subClassCandidate;
				}
			}
		}
		return null;
	}

	private List<EObject> getObjectsByType(Resource resource, EClass metaClass) {
		List<EObject> foundObjects = new ArrayList<EObject>();

		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (metaClass.isInstance(next)) {
				foundObjects.add(next);
			}
		}
		return foundObjects;
	}

	// return the error if one was found
	/*
	private String parseExpression(EClass inputMetaClass, Map<String, EObject> variables, String expressionString) {
		Object query = createQuery(inputMetaClass, variables, expressionString);
		if (query instanceof String) {
			return (String) query;
		} else {
			return null;
		}
	}
	*/

	@SuppressWarnings("unchecked")
	public Object evaluateExpression(EClass inputMetaClass, EObject contextObject, Map<String, EObject> variables, String expressionString) {
		if (inputMetaClass == null) {
			System.out.println("evaluateExpression(" + expressionString + "," + contextObject + ") inputMetaClass is null");
			return null;
		}

		Object query = createQuery(inputMetaClass, variables, expressionString);
		if (query instanceof Query) {
			return ((Query<EClassifier, EClass, EObject>) query).evaluate(contextObject);
		} else {
			return null;
		}
	}

	// TODO find a better solution to indicate errors instead of returning the error message
	private Object createQuery(EClass inputMetaClass, Map<String, EObject> variables, String expressionString) {
		OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
			ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		OCLExpression<EClassifier> expression;
		try {
			addVariables(variables, ocl);

			OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = ocl.createOCLHelper();
			helper.setContext(inputMetaClass);

			expression = helper.createQuery(expressionString);
			Query<EClassifier, EClass, EObject> query = ocl.createQuery(expression);

			addVariableValues(variables, query);

			return query;
		} catch (ParserException e) {
			return e.getMessage();
		}
	}

	private void addVariables(
			Map<String, EObject> variables,
			OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> ocl) {
		if (variables == null) {
			return;
		}
		for (String variableName : variables.keySet()) {
			Variable<EClassifier, EParameter> v =
				ocl.getEnvironment().getOCLFactory().createVariable();
			v.setName(variableName);
			v.setType(variables.get(variableName).eClass());
			ocl.getEnvironment().addElement(v.getName(), v, true);
		}
	}

	private void addVariableValues(Map<String, EObject> variables, Query<EClassifier, EClass, EObject> query) {
		if (variables == null) {
			return;
		}
		for (String variableName : variables.keySet()) {
			query.getEvaluationEnvironment().add(variableName, variables.get(variableName));
		}
	}
}

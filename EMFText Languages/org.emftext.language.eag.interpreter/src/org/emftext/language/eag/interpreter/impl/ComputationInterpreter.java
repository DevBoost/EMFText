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
package org.emftext.language.eag.interpreter.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.eag.Assignment;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeValue;
import org.emftext.language.eag.BinaryExpression;
import org.emftext.language.eag.BooleanExpression;
import org.emftext.language.eag.Computation;
import org.emftext.language.eag.Expression;
import org.emftext.language.eag.ExpressionChain;
import org.emftext.language.eag.ForLoop;
import org.emftext.language.eag.IfElse;
import org.emftext.language.eag.IntegerLiteral;
import org.emftext.language.eag.Reference;
import org.emftext.language.eag.Statement;
import org.emftext.language.eag.StringLiteral;
import org.emftext.language.eag.ThisReference;
import org.emftext.language.eag.Value;
import org.emftext.language.eag.Variable;
import org.emftext.language.eag.interpreter.impl.providers.AssignmentInterpreterProvider;
import org.emftext.language.eag.interpreter.impl.providers.BinaryExpressionInterpreterProvider;
import org.emftext.language.eag.interpreter.impl.providers.BooleanExpressionInterpreterProvider;
import org.emftext.language.eag.interpreter.impl.references.EObjectReference;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.impl.references.ReferenceFactory;
import org.emftext.language.eag.interpreter.impl.references.ValueReference;
import org.emftext.language.eag.resource.eag.util.AbstractEagInterpreter;

public class ComputationInterpreter extends AbstractEagInterpreter<IReference, ComputationContext> {

	private IReference lastResultInReferenceChain;

	private void log(String string) {
	}

	@Override
	public IReference interprete_org_emftext_language_eag_Computation(
			Computation computation, 
			ComputationContext context) {
		log("==> Computation(" + computation.getTargetAttribute().getName() + "::" + computation.getContext().getName() + ")");
		IReference result = interprete(computation.getBody(), context);
		log("<== Computation(" + computation.getTargetAttribute().getName() + "::" + computation.getContext().getName() + ")");
		return result;
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_IfElse(
			IfElse ifElse,
			ComputationContext context) {
		
		IReference conditionResult = interprete(ifElse.getCondition(), context);
		if (conditionResult.getTarget() == Boolean.TRUE) {
			return interprete(ifElse.getIfBody(), context);
		} else {
			Statement elseBody = ifElse.getElseBody();
			if (elseBody == null) {
				return null;
			} else {
				return interprete(elseBody, context);
			}
		}
	}

	@Override
	public IReference interprete_org_emftext_language_eag_ForLoop(
			ForLoop forLoop, 
			ComputationContext context) {

		Statement body = forLoop.getBody();
		Variable variable = forLoop.getVariable();

		IReference collectionRef = interprete(forLoop.getCollection(), context);
		Object target = collectionRef.getTarget();
		assert target != null;
		assert target instanceof Collection;
		Collection<?> collection = (Collection<?>) target;
		Iterator<?> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object next = (Object) iterator.next();
			context.addVariable(variable, next);
			interprete(body, context);
			context.removeVariable(variable);
		}
		return null;
	}

	@Override
	public IReference interprete_org_emftext_language_eag_Assignment(
			Assignment assignment, 
			ComputationContext context) {
		log("Assignment()");
		Object rightValue = interprete(assignment.getRight(), context);
		Object leftValue = interprete(assignment.getLeft(), context);
		log("Assignment() left = " + leftValue);
		log("Assignment() right = " + rightValue);
		assert rightValue instanceof IReference;
		assert leftValue instanceof IReference;
		IReference right = (IReference) rightValue;
		IReference left = (IReference) leftValue;
		AssignmentInterpreterProvider.INSTANCE.interpret(assignment.getOperator(), left, right);
		return null;
	}

	@Override
	public IReference interprete_org_emftext_language_eag_BinaryExpression(
			BinaryExpression expression, 
			ComputationContext context) {
		log("BinaryExpression()");
		// first do the left and the the right
		Object left = interprete(expression.getLeft(), context);
		Object right = interprete(expression.getRight(), context);
		log("BinaryExpression() left = " + left);
		log("BinaryExpression() right = " + right);
		assert left instanceof IReference;
		assert right instanceof IReference;
		IReference leftRef = (IReference) left;
		IReference rightRef = (IReference) right;
		log("BinaryExpression() leftRef = " + leftRef.getTarget());
		log("BinaryExpression() rightRef = " + rightRef.getTarget());
		return BinaryExpressionInterpreterProvider.INSTANCE.interpret(expression.getOperator(), leftRef, rightRef);
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_BooleanExpression(
			BooleanExpression expression, ComputationContext context) {
		Object left = interprete(expression.getLeft(), context);
		Object right = interprete(expression.getRight(), context);
		assert left instanceof IReference;
		assert right instanceof IReference;
		IReference leftRef = (IReference) left;
		IReference rightRef = (IReference) right;
		return BooleanExpressionInterpreterProvider.INSTANCE.interpret(expression, leftRef, rightRef);
	}

	@Override
	public IReference interprete_org_emftext_language_eag_AttributeValue(
			AttributeValue attributeValue, 
			ComputationContext context) {
		
		Attribute attribute = attributeValue.getTargetAttribute();
		log("AttributeValue() " + attribute.getName());
		IReference expressionResult = interprete(attributeValue.getExpression(), context);
		log("AttributeValue() " + expressionResult);
		assert expressionResult instanceof IReference;
		
		//Object expressionValue = expressionResult.getValue();
		//assert expressionValue instanceof ObjectReference;
		
		IReference expressionReference = (IReference) expressionResult;
		// evaluate attribute on the result of interpreting object.getExpression()
		Object result = new EAGInterpreter().interpret((EObject) expressionReference.getTarget(), context.getGrammar(), attribute);
		return ReferenceFactory.INSTANCE.createReference(result);
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_ExpressionChain(
			ExpressionChain chain, 
			ComputationContext context) {
		Expression previous = chain.getPrevious();
		log("ExpressionChain() " + previous);
		lastResultInReferenceChain = null;
		lastResultInReferenceChain = interprete(previous, context);
		return interprete(chain.getNext(), context);
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_Reference(
			Reference object, ComputationContext context) {
		IReference previous = lastResultInReferenceChain;
		log("Reference() previous = " + previous);
		EObject target = object.getTarget();
		log("Reference() target = " + target);
		if (target instanceof EStructuralFeature) {
			assert previous instanceof IReference;
			IReference reference = (IReference) previous;
			assert reference != null;
			EStructuralFeature feature = (EStructuralFeature) target;
			assert feature != null;
			log("FeatureReference() feature = " + feature);
			String featureName = feature.getName();
			assert featureName != null;
			log("FeatureReference() getting '" + featureName + "' from " + reference);
			IReference featureReference = reference.getReference(feature);
			return featureReference;
		} else if (target instanceof Variable) {
			Variable variable = (Variable) target;
			Object value = context.getVariableValue(variable);
			return ReferenceFactory.INSTANCE.createReference(value);
		} else {
			throw new RuntimeException("Unknown reference target " + target);
		}
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_Value(
			Value value,
			ComputationContext context) {
		return new ValueReference(context);
	}

	@Override
	public IReference interprete_org_emftext_language_eag_ThisReference(
			ThisReference thisRef,
			ComputationContext context) {
		EObject thisObject = context.getObject();
		IReference referenceToThisObject = new EObjectReference(thisObject);
		lastResultInReferenceChain = referenceToThisObject;
		return referenceToThisObject;
	}

	@Override
	public IReference interprete_org_emftext_language_eag_StringLiteral(
			StringLiteral object, ComputationContext context) {
		return ReferenceFactory.INSTANCE.createReference(object.getValue());
	}

	@Override
	public IReference interprete_org_emftext_language_eag_IntegerLiteral(
			IntegerLiteral object, ComputationContext context) {
		return ReferenceFactory.INSTANCE.createReference(object.getValue());
	}
}

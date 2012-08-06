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
package org.emftext.tools.restricted;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

public class Evaluator {
	
	private IEvaluationResultHandler resultHandler;
	
	public Evaluator(IEvaluationResultHandler resultHandler) {
		this.resultHandler = resultHandler;
	}
	
	public void evaluateOCLQueries(EObject context, List<RestrictedExpression> constraints) {

		for (RestrictedExpression nextConstraint : constraints) {
			if (nextConstraint.isInvariant()) {
				evaluateInvariant(context, nextConstraint);
			} else {
				evaluateQuery(context, nextConstraint);
			}
		}
	}

	private void evaluateInvariant(
			EObject context,
			RestrictedExpression restrictedExpression) {

		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = ocl.createOCLHelper();
		String invariantContext = restrictedExpression.getInvariantContext();
		
		TreeIterator<EObject> it = context.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			helper.setContext(next.eClass());
			if (hasContextType(next, invariantContext)) {
				final String message = restrictedExpression.getViolationMessage();
				final String oclQueryString = restrictedExpression.getOclExpression();

				OCLExpression<EClassifier> expression;
				try {
					expression = helper.createQuery(oclQueryString);
					Query query = ocl.createQuery(expression);
					Object result = query.evaluate(next);
					resultHandler.handleResult(next, result, message);
				} catch (ParserException e) {
					resultHandler.handleException(next, e);
				}
			}
		}
	}

	private boolean hasContextType(EObject object, 
			String invariantContext) {

		EClass container = object.eClass();
		EPackage ePackage = (EPackage) container.eContainer();

		String eClassName = invariantContext;

		if (eClassName.contains("::")) {
		    //class resides in another package
		    String ePackagePrefix = eClassName.split("::")[0];
		    eClassName = eClassName.split("::")[1];
		    for(Object ePackageCand : EPackage.Registry.INSTANCE.values()) {
		        if (ePackageCand instanceof EPackage) {
		            if(((EPackage)ePackageCand).getNsPrefix().equals(ePackagePrefix)) {
		                ePackage = (EPackage) ePackageCand;
		                break;
		            }
		        }
		    }
		}
		
		for (EClassifier eClass : ePackage.getEClassifiers()) {
			if (eClass.equals(object.eClass())) {
				if (eClass.getName().equals(eClassName)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private void evaluateQuery(
			EObject context,
			RestrictedExpression nextConstraint) {
		
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = ocl.createOCLHelper();
		helper.setContext(context.eClass());

		try {
			final String message = nextConstraint.getViolationMessage();
			final String oclQueryString = nextConstraint.getOclExpression();

			OCLExpression<EClassifier> expression = helper.createQuery(oclQueryString);
			Query query = ocl.createQuery(expression);
			Object result = query.evaluate(context);
			resultHandler.handleResult(context, result, message);
		} catch (ParserException e) {
			resultHandler.handleException(context, e);
		}
	}
}

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
package org.emftext.language.usecaseinvariant.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.util.Tuple;

/**
 * A post-processor that retrieves OCL constraints from the meta model of a text
 * resource and evaluates them.
 */
public class OCLModelValidator {

	private Collection<EClass> getAllMetaclasses(EObject object) {
		Set<EClass> metaclasses = new HashSet<EClass>();
		EClass metaclass = object.eClass();
		metaclasses.add(metaclass);
		EList<EClass> superTypes = metaclass.getESuperTypes();
		metaclasses.addAll(superTypes);
		for (EClass supertype : superTypes) {
			metaclasses.addAll(collectSupertypes(supertype));
		}
		return metaclasses;
	}

	private Collection<EClass> collectSupertypes(EClass type) {
		Set<EClass> metaclasses = new HashSet<EClass>();
		EList<EClass> superTypes = type.getESuperTypes();
		metaclasses.addAll(superTypes);
		for (EClass supertype : superTypes) {
			metaclasses.addAll(collectSupertypes(supertype));
		}
		return metaclasses;
	}

	private Object evaluateOCL(Object context, String oclQuery) throws ParserException {
		Object eval = null;
		OCL ocl = OCL
				.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
		OCL.Helper helper = ocl.createOCLHelper();

		helper.setInstanceContext(context);
		OCLExpression exp = helper.createQuery(oclQuery);
		Query<?, ?, ?> query = OCL.newInstance().createQuery(exp);

		eval = query.evaluate(context);

		return eval;
	}

	private void evaluate(EObject targetObject, IProblemHandler problemHandler) {
		List<EAnnotation> annotations = new ArrayList<EAnnotation>();
		Collection<EClass> metaclasses = getAllMetaclasses(targetObject);

		for (EClass metaclass : metaclasses) {
			annotations.addAll(metaclass.getEAnnotations());
		}

		for (EAnnotation annotation : annotations) {

			if (annotation.getSource().equals("OCL")) {
				for (String key : annotation.getDetails().keySet()) {
					String value = annotation.getDetails().get(key);
					Object result;
					String errorMsg = "";
					try {
						result = evaluateOCL(targetObject, value);

						if ((result instanceof Boolean)
								&& ((Boolean) result).booleanValue() == false) {
							errorMsg = key.toString();
						} else {
							errorMsg = constructErrorMsg(result);
							if (errorMsg.length() > 0) {
								errorMsg = key + ": " + errorMsg;
							}
						}
					} catch (ParserException e) {
						errorMsg += "Parse Error for OCL Expression (" + e.getMessage() + "): " + value;
					}


					if (errorMsg.length() > 0) {
						addErrorMessage(problemHandler, targetObject, errorMsg);
					}
				}
			} else if (annotation.getSource().equals("OCL_Derivation")) {
				for (String key : annotation.getDetails().keySet()) {
					String value = annotation.getDetails().get(key);
					Object result;
					String errorMsg = "";
					try {
						result = evaluateOCL(targetObject, value);
						EStructuralFeature structuralFeature = targetObject
								.eClass().getEStructuralFeature(key);
						if (structuralFeature != null && result != null) {
							targetObject.eSet(structuralFeature, result);
						}
					} catch (ParserException e) {
						errorMsg += "Parse Error for OCL Expression: " + value;
					}
					if (errorMsg.length() > 0) {
						addErrorMessage(problemHandler, targetObject, errorMsg);
					}
				}

			}
		}
	}


	/**
	 * @param targetObject
	 * @param resourceFile
	 * @param errorMesssage
	 */
	private void addErrorMessage(IProblemHandler problemHandler, EObject targetObject, String errorMesssage) {
		problemHandler.addProblem(errorMesssage, targetObject, true);
	}


	private String constructErrorMsg(Object result) {
		String error = "";
		OCL ocl = OCL
				.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
		if (result instanceof Boolean && ((Boolean) result).booleanValue() == true) {
			return "";
		}
		else if (ocl.isInvalid(result)) {
			error += "Evaluation of OCL expression failed: OclInvalid";
		}
		else if (result instanceof String) {
			if (((String) result).length() > 0) {
				error = "'" + result + "'";
			}
		}
		else if (result instanceof Tuple<?, ?>) {
			Object[] array = ((Tuple<?,?>) result).getTupleType().oclProperties().toArray(new Object[]{});
			if (array.length > 0) {
				error += constructErrorMsg(array[0]);
			}
			for (int i = 1; i < array.length; i++) {
				error += ", " + constructErrorMsg(array[i]);
			}
		}
		else if (result instanceof Collection<?>) {
			Object[] array = ((Collection<?>) result).toArray(new Object[]{});
			if (array.length > 0) {
				error += constructErrorMsg(array[0]);
			}
			for (int i = 1; i < array.length; i++) {
				error += ", " + constructErrorMsg(array[i]);
			}

		}
		else if (result instanceof EObject) {
			EObject eObject = (EObject) result;

			error = eObject.toString();
		}

		return error.trim();
	}

	public void process(Resource resource, IProblemHandler problemHandler) {
		EList<EObject> contents = resource.getContents();

		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			analyse(eobject, problemHandler);
		}
	}

	public void analyse(EObject rootObject, IProblemHandler problemHandler) {

		Resource resource = rootObject.eResource();

		// Since the resource is loaded with ETE
		// it is necessarily a TextResource
		TreeIterator<EObject> allContents = resource.getAllContents();

		while (allContents.hasNext()) {
			evaluate(allContents.next(), problemHandler);
		}
	}
}

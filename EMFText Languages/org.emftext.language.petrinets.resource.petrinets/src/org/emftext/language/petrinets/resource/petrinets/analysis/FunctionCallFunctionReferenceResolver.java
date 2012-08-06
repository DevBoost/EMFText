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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.emftext.language.petrinets.Expression;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.PGenericType;
import org.emftext.language.petrinets.PList;
import org.emftext.language.petrinets.Parameter;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult;

public class FunctionCallFunctionReferenceResolver
		implements
		org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolver<org.emftext.language.petrinets.FunctionCall, org.emftext.language.petrinets.Function> {

	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.FunctionCall, org.emftext.language.petrinets.Function> delegate = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.FunctionCall, org.emftext.language.petrinets.Function>();

	public void resolve(
			String identifier,
			org.emftext.language.petrinets.FunctionCall container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.emftext.language.petrinets.Function> result) {

		List<Function> candidates = FunctionCallAnalysisHelper.getInstance()
				.getDeclaredFunctions(container);
		if (!resolveFuzzy) {
			setHelpingErrorMessage(identifier, container, result);
		}
		filterFunctions(candidates, container, identifier, resolveFuzzy, result);
	}

	private void setHelpingErrorMessage(
			String identifier,
			org.emftext.language.petrinets.FunctionCall container,
			final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.emftext.language.petrinets.Function> result) {
		EClassifier contextType = FunctionCallAnalysisHelper.getInstance().getContextType(
				container);
		String typeNote = "";
		if (contextType != null) {
			typeNote = " for '" + contextType.getName() + "'";
		}
		if (contextType instanceof PList
				&& ((PList) contextType).getType() != null) {
			typeNote = " for 'List<"
					+ ((PList) contextType).getType().getName() + ">" + "'";
		}
		String message = "The function '" + identifier + "' is not defined"
				+ typeNote;
		EList<Expression> parameters = container.getParameters();
		if (!parameters.isEmpty()) {
			message += " with argument(s) ";
			for (Expression expression : parameters) {
				EClassifier type = FunctionCallAnalysisHelper.getInstance().getType(
						expression);
				String name = "Type";
				if (type != null) {
					name = type.getName();
				}
				type = FunctionCallAnalysisHelper.getInstance().getType(expression);
				message += name + ", ";

			}
			message = message.substring(0, message.length() - 2);
		}
		message += ".";
		result.setErrorMessage(message);
	}

	private void filterFunctions(List<Function> candidates,
			FunctionCall container, String identifier, boolean resolveFuzzy,
			IPetrinetsReferenceResolveResult<Function> result) {
		for (Function function : candidates) {
			if (resolveFuzzy) {
				result.addMapping(function.getName(), function);
			} else {
				EClassifier contextType = FunctionCallAnalysisHelper.getInstance()
						.getContextType(container);
				if (function.getName().equals(identifier)) {
					if (parametersMatch(function.getParameters(),
							container.getParameters(), contextType)) {
						result.addMapping(identifier, function);
						container.setType(FunctionCallAnalysisHelper.getInstance()
								.getFunctionReturnType(null, function));
						return;
					}
				}
			}
		}

	}

	private boolean parametersMatch(EList<Parameter> expected,
			EList<Expression> found, EClassifier contextType) {
		if (expected.size() != found.size()) {
			return false;
		}
		parameterloop: for (int i = 0; i < expected.size(); i++) {
			EClassifier parameterType = expected.get(i).getType();
			Expression parameterExpression = found.get(i);

			EClassifier argumentType = FunctionCallAnalysisHelper.getInstance().getType(
					parameterExpression);
			if (argumentType == null)
				return false;
			if (parameterType instanceof PGenericType) {
				if (contextType instanceof PList) {
					if (FunctionCallAnalysisHelper.getInstance().isSubtype(argumentType, ((PList) contextType).getType())) {
						continue; // check next parameter

					}
				}
			}
			if (parameterType instanceof EClassifier
					&& argumentType instanceof EClassifier) {
				if (FunctionCallAnalysisHelper.getInstance().isSubtype(argumentType, parameterType)) {
					continue; // check next parameter
				}
			}

			return false;
		}
		return true;
	}

	

	public String deResolve(org.emftext.language.petrinets.Function element,
			org.emftext.language.petrinets.FunctionCall container,
			org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend
		// on any option
	}

}

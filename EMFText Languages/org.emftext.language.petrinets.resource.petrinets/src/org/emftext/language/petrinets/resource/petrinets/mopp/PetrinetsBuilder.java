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
package org.emftext.language.petrinets.resource.petrinets.mopp;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.petrinets.BooleanExpression;
import org.emftext.language.petrinets.Cast;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.FunctionType;
import org.emftext.language.petrinets.Setting;
import org.emftext.language.petrinets.SettingOperator;
import org.emftext.language.petrinets.UnaryMinus;
import org.emftext.language.petrinets.resource.petrinets.PetrinetsEProblemType;
import org.emftext.language.petrinets.resource.petrinets.analysis.FunctionCallAnalysisHelper;

public class PetrinetsBuilder implements
		org.emftext.language.petrinets.resource.petrinets.IPetrinetsBuilder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}

	public org.eclipse.core.runtime.IStatus build(
			org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsResource resource,
			org.eclipse.core.runtime.IProgressMonitor monitor) {
		process(resource);
		if (resource.getErrors().isEmpty()) {
			PetriNetsCodeGenerator pcg = new PetriNetsCodeGenerator();
			pcg.generateJavaCode(resource);
		} else {
			resource.addWarning(
					"The petrinet may not be build correctly due to errors in the resource",
					PetrinetsEProblemType.BUILDER_ERROR, resource.getContents()
							.get(0));
			PetriNetsCodeGenerator pcg = new PetriNetsCodeGenerator();
			pcg.generateJavaCode(resource);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	
	public void process(PetrinetsResource resource) {
		EcoreUtil.resolveAll(resource);
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();
			if (eObject instanceof FunctionCall) {
				FunctionCall fc = (FunctionCall) eObject;
				Function function = fc.getFunction();
				if (!function.eIsProxy()
						&& function.getFunctionType()
								.equals(FunctionType.WRITE)) {
					resource.addError(
							"The invocation of functions that write data is not allowed.",
							PetrinetsEProblemType.BUILDER_ERROR, fc);
				}
			} else if (eObject instanceof BooleanExpression) {
				BooleanExpression be = (BooleanExpression) eObject;
				EClassifier leftType = FunctionCallAnalysisHelper.getInstance()
						.getType(be.getLeft());
				if (leftType == null || leftType.getInstanceTypeName() == null
						|| !leftType.getInstanceClassName().equals("boolean")) {
					String type;
					if (leftType == null)
						type = "null";
					else
						type = leftType.getName();
					resource.addError(
							"Arguments to boolean expressions need to have a boolean return type. (found: "
									+ type + ")",
							PetrinetsEProblemType.BUILDER_ERROR,
							be.getLeft());
				}
				EClassifier rightType = FunctionCallAnalysisHelper
						.getInstance().getType(be.getRight());
				if (rightType == null
						|| rightType.getInstanceTypeName() == null
						|| !rightType.getInstanceTypeName().equals("boolean")) {
					String type;
					if (rightType == null)
						type = "null";
					else
						type = rightType.getName();
					resource.addError(
							"Arguments to boolean expressions need to have a boolean return type. (found: "
									+ type + ")",
							PetrinetsEProblemType.BUILDER_ERROR,
							be.getRight());
				}
			} else if (eObject instanceof Setting) {
				Setting setting = (Setting) eObject;
				EClassifier expectedType = setting.getFeature().getEType();
				EClassifier foundType = FunctionCallAnalysisHelper
						.getInstance().getType(setting.getValue());
				if (!FunctionCallAnalysisHelper.getInstance().isSubtype(
						foundType, expectedType)) {
					String found;
					if (foundType == null)
						found = "null";
					else
						found = foundType.getName();
					String expected;
					if (expectedType == null)
						expected = "null";
					else
						expected = expectedType.getName();

					resource.addError(
							"Type of assigned variable is not compatible with type expected for (found: "
									+ found + " " + ", expected: " + expected
									+ ")",
							PetrinetsEProblemType.BUILDER_ERROR, setting);
				}
				if (setting.getSettingOperator().equals(SettingOperator.ADD)) {
					if (setting.getFeature() != null
							&& !setting.getFeature().eIsProxy()
							&& !setting.getFeature().isMany()) {
						resource.addError(
								"You can only add to features of type List.",
								PetrinetsEProblemType.BUILDER_ERROR, setting);
					}
				} else if (setting.getSettingOperator().equals(
						SettingOperator.ASSIGN)) {
					if (setting.getFeature() != null
							&& !setting.getFeature().eIsProxy()
							&& setting.getFeature().isMany()) {
						resource.addError(
								"You can assign values to features of non-List type.",
								PetrinetsEProblemType.BUILDER_ERROR, setting);
					}
				}

			} else if (eObject instanceof UnaryMinus) {
				UnaryMinus um = (UnaryMinus) eObject;
				if (um.isMinus()) {
					EClassifier type = FunctionCallAnalysisHelper.getInstance()
							.getType(um.getExpression());

					if (!(EcorePackage.eINSTANCE.getEShort().equals(type)
							|| EcorePackage.eINSTANCE.getEInt().equals(type)
							|| EcorePackage.eINSTANCE.getEFloat().equals(type) || EcorePackage.eINSTANCE
							.getEDouble().equals(type))) {
						String typename;
						if (type == null)
							typename = "null";
						else
							typename = type.getName();

						resource.addError(
								"The minus operator is not defined for "
										+ typename,
								PetrinetsEProblemType.BUILDER_ERROR, um);
					}
				}
			} else if (eObject instanceof Cast) {
				Cast c = (Cast) eObject;
				EClassifier castTarget = c.getType();
				EClassifier foundType = FunctionCallAnalysisHelper
						.getInstance().getType(c.getExpression());
				boolean isSubtype = FunctionCallAnalysisHelper.getInstance()
						.isSubtype(castTarget, foundType);
				if (!isSubtype) {
					String target;
					if (castTarget == null)
						target = "null";
					else
						target = castTarget.getName();
					String found;
					if (foundType == null)
						found = "null";
					else
						found = foundType.getName();

					resource.addWarning(
							"Casting to a non-subtype is not allowed. (cast target: "
									+ target + ", found: " + found + ")",
							PetrinetsEProblemType.BUILDER_ERROR, c);
				}
			}

		}

	}
	
}

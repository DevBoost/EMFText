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
package org.emftext.language.rolecore.dependencies.interpreter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.RightTerm;
import org.emftext.language.rolecore.dependencies.SimpleTerm;

public class ChangingHelpClass {

	private InterpretationContext context;

	public ChangingHelpClass(InterpretationContext interpretationContext) {
		context = interpretationContext;
	}

	public void applyChange(ChangeDescription changeDescription) {
		EObject roleEObject = changeDescription.getObjectChanges().get(0).getKey();
		DomainRoot traceLinksDomainRoot = context.findOrCreateTraceLinksDomainRoot();
		changeDescription.apply();
		for (EObject eObject : traceLinksDomainRoot.getEObjects()) {
			if (eObject instanceof AssignmentTraceLink) {
				AssignmentTraceLink assignmentTraceLink = (AssignmentTraceLink) eObject;
				for (String coreClassName : assignmentTraceLink.getCoreNameToRolesMap().keySet()) {
					if (assignmentTraceLink.getCoreNameToRolesMap().get(coreClassName).contains(roleEObject)) {
						Edge edge = (Edge) assignmentTraceLink.getEdge();
						if (coreClassName.equals(edge.getSimpleTerm().getCoreClass().getName())
								&& roleEObject.eClass().equals(edge.getSimpleTerm().getRole())) {
							setRoleInRightTerm(roleEObject, edge.getRightTerm(), assignmentTraceLink
									.getCoreNameToRolesMap(), false);
						}else{
							setRoleInSimpleTerm(edge, assignmentTraceLink.getCoreNameToRolesMap());
						}
						break;
					}
				}
			}
		}
	}

	private void setRoleInSimpleTerm(Edge edge, EMap<String, EList<EObject>> rolesMap) {
		EList<EObject> roles = rolesMap.get(edge.getSimpleTerm().getCoreClass().getName());
		EObject leftRole = null;
		for (EObject eObject : roles) {
			if (eObject.eClass().equals(edge.getSimpleTerm().getRole())){
				leftRole = eObject;
				break;
			}
		}
		EAttribute leftAttribute = leftRole.eClass().getEAttributes().get(0);
		leftRole.eSet(leftAttribute, evaluateRightTerm(edge.getRightTerm(), rolesMap));
	}

	private Object evaluateRightTerm(RightTerm rightTerm, EMap<String, EList<EObject>> rolesMap) {
		if (rightTerm.getValue() != null) {
			return rightTerm.getValue();
		}
		if (rightTerm.getOperation() != null && rightTerm.getOperation().getOperationType().equals("+")) {
			String result = "";
			for (RightTerm rightTermInList : rightTerm.getOperation().getRightTerms()) {
				Object rightTermResult = evaluateRightTerm(rightTermInList, rolesMap);
				if (rightTermResult instanceof String) {
					result += rightTermResult.toString();
				}
			}
			return result;
		}
		EList<SimpleTerm> simpleTerms = rightTerm.getSimpleTerms();
		if (simpleTerms != null && simpleTerms.size() > 0) {
			String result = "";
			for (SimpleTerm simpleTerm : simpleTerms) {
				EList<EObject> roleEObjects = rolesMap.get(simpleTerm.getCoreClass().getName());
				if (roleEObjects != null & roleEObjects.size() == 1) {
					EObject roleEObject = roleEObjects.get(0);
					EAttribute roleAttribute = roleEObject.eClass().getEAttributes().get(0);
					Object data = roleEObject.eGet(roleAttribute);
					if (data instanceof String) {
						result += data.toString();
					}
				}
			}
			return result;
		}
		return null;
	}
	private void setRoleInRightTerm(EObject roleEObject, RightTerm rightTerm, EMap<String, EList<EObject>> rolesMap,
			boolean isSet) {
		if (rightTerm.getSimpleTerms() != null) {
			for (SimpleTerm simpleTerm : rightTerm.getSimpleTerms()) {
				EObject roleInRightTerm = null;
				EList<EObject> rolesInRightTerm = rolesMap.get(simpleTerm.getCoreClass().getName());
				for (EObject eObject : rolesInRightTerm) {
					if (eObject.eClass().equals(simpleTerm.getRole())) {
						roleInRightTerm = eObject;
						break;
					}
				}
				EAttribute roleAttribute = roleEObject.eClass().getEAttributes().get(0);
				EAttribute rightTermAttribute = roleInRightTerm.eClass().getEAttributes().get(0);
				if (!isSet && roleAttribute.getEAttributeType().equals(rightTermAttribute.getEAttributeType())) {
					roleInRightTerm.eSet(rightTermAttribute, roleEObject.eGet(roleAttribute));
					isSet = true;
				}else{
					roleInRightTerm.eSet(rightTermAttribute, null);
				}
			}
		}
		if (rightTerm.getOperation() != null){
			for (RightTerm rightTermInOp : rightTerm.getOperation().getRightTerms()) {
				setRoleInRightTerm(roleEObject, rightTermInOp, rolesMap, isSet);
			}
		}
	}
}

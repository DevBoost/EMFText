/*******************************************************************************
 * Copyright (c) 2006-2011
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
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import sg.edu.nus.comp.simTL.language.java.simTL4J.commons.NamedElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.MethodCall;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.Reference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReflectiveClassReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.SelfReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.ForLoop;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.LocalVariableStatement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.StatementsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Switch;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.SwitchCase;
import sg.edu.nus.comp.simTL.language.java.simTL4J.variables.AdditionalLocalVariable;
import sg.edu.nus.comp.simTL.language.java.simTL4J.variables.LocalVariable;
import sg.edu.nus.comp.simTL.language.java.simTL4J.variables.VariablesPackage;

/**
 * A decider that looks for local variable declarations.
 */
public class LocalVariableDecider extends AbstractDecider {

	public boolean continueAfterReference() {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof LocalVariable || element instanceof AdditionalLocalVariable) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT__VARIABLE.equals(containingReference)) {
			return true;
		}
		if (VariablesPackage.Literals.LOCAL_VARIABLE__ADDITIONAL_LOCAL_VARIABLES.equals(containingReference)) {
			return true;
		}
		if (StatementsPackage.Literals.FOR_LOOP__INIT.equals(containingReference)) {
			return true;
		}
		return false;
	}

	public boolean walkInto(EObject element) {
		if (element instanceof LocalVariableStatement) {
			if (StatementsPackage.Literals.STATEMENT_CONTAINER__STATEMENT.equals(element.eContainmentFeature())) {
				return true;
			}
			if (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS.equals(element.eContainmentFeature())) {
				return true;
			}
		}
		if (element instanceof LocalVariable) {
			if (StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT__VARIABLE.equals(element.eContainmentFeature())
					|| StatementsPackage.Literals.FOR_LOOP__INIT.equals(element.eContainmentFeature())) {
				return true;
			}
		}
		if (element instanceof ForLoop) {
			return true;
		}
		if (element instanceof Switch) {
			return true;
		}
		if (element instanceof SwitchCase) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof MethodCall) {
			return false;
		}
		if (!(referenceContainer instanceof Reference)) {
			return false;
		}
		Reference reference = (Reference) referenceContainer;
		if (reference.getNext() instanceof ReflectiveClassReference) {
			return false;
		}
		if (reference.getNext() instanceof SelfReference) {
			return false;
		}
		return true;
	}

}

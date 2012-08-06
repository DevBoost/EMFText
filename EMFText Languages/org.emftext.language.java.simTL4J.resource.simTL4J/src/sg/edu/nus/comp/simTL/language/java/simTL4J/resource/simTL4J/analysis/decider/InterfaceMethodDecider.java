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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationAttributeSetting;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Classifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.commons.NamedElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.InterfaceMethod;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.MemberContainer;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.MembersPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.Method;


/**
 * To resolve annotation attributes.
 */
public class InterfaceMethodDecider extends AbstractDecider {


	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof AnnotationAttributeSetting) {
			return true;
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Classifier) {
			return ((Classifier)container).getAllMembers((Classifier)container);
		}
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof InterfaceMethod) {
			Method method = (Method) element;
			if (id.equals(method.getName())) {
				NamedElement ne = (NamedElement) element;
				return id.equals(ne.getName());
			}
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (container instanceof MemberContainer) {
			if (MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS.equals(containingReference)) {
				return  true;
			}
		}
		return false;
	}


}

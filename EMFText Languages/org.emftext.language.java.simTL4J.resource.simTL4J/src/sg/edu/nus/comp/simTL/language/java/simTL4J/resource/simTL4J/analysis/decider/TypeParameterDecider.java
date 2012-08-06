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
import sg.edu.nus.comp.simTL.language.java.simTL4J.generics.GenericsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.generics.TypeParameter;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.MethodCall;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.Reference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.types.ClassifierReference;

/**
 * A decider that looks for type parameters.
 */
public class TypeParameterDecider extends AbstractDecider {

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof TypeParameter) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (GenericsPackage.Literals.TYPE_PARAMETRIZABLE__TYPE_PARAMETERS.equals(containingReference)) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return ((referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall)) ||
				referenceContainer instanceof ClassifierReference);
	}
}

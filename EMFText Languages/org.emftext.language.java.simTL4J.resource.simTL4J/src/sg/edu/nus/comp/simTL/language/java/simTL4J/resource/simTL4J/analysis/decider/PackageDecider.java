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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import sg.edu.nus.comp.simTL.language.java.simTL4J.commons.NamedElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.containers.ContainersFactory;
import sg.edu.nus.comp.simTL.language.java.simTL4J.containers.JavaRoot;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.IdentifierReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.MethodCall;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferencesPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.containers.Package;

/**
 * A decider that assumes that a package is referenced if the context of the reference
 * allows for a package reference at that position. The decider creates a package
 * element as additional candidate in that case.
 */
public class PackageDecider extends AbstractDecider {

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference crossReference) {

		if (referenceContainer instanceof IdentifierReference) {
			IdentifierReference idReference = (IdentifierReference) referenceContainer;
			 //a classifier must follow
			if(idReference.getNext() == null || idReference.getNext() instanceof MethodCall) {
				return false;
			}
			if (!referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				//maybe the root package
				return true;
			}
			if (referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT) &&
					idReference.eContainer() instanceof IdentifierReference &&
					((IdentifierReference)idReference.eContainer()).getTarget() instanceof Package) {
				//maybe the next sub package
				return true;
			}

		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container)  {
		if (container instanceof JavaRoot && container.eResource() != null) {
			EList<EObject> resultList = new BasicEList<EObject>();

			Package p = ContainersFactory.eINSTANCE.createPackage();
			p.setName(identifier);
			resultList.add(p);

			return resultList;
		}
		if (container instanceof Package) {
			EList<EObject> resultList = new BasicEList<EObject>();
			Package parentPackage = (Package) container;

			Package p = ContainersFactory.eINSTANCE.createPackage();
			p.setName(identifier);
			parentPackage.getSubpackages().add(p);
			p.getNamespaces().addAll(parentPackage.getNamespaces());
			p.getNamespaces().add(parentPackage.getName());
			resultList.add(p);

			return resultList;
		}
		return null;
	}

	public boolean containsCandidates(EObject container,
			EReference containingReference) {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Package) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}


}

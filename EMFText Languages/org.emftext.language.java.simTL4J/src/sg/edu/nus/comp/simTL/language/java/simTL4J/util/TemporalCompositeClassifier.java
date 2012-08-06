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
package sg.edu.nus.comp.simTL.language.java.simTL4J.util;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Classifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.impl.ClassifierImpl;

/**
 * A temporal create classifier that combines all type restrictions
 * of one type parameter.
 */
public class TemporalCompositeClassifier extends ClassifierImpl {

	private EObject creator;

	private EList<EObject> superTypes = new UniqueEList<EObject>();

	public TemporalCompositeClassifier(EObject creator) {
		this.creator = creator;
	}

	public Resource eResource() {
		return creator.eResource();
	}

	public EList<EObject> getSuperTypes() {
		return superTypes;
	}

	public EList<ConcreteClassifier> getAllSuperClassifiers() {
		EList<ConcreteClassifier> result = new UniqueEList<ConcreteClassifier>();
		for(EObject superType : getSuperTypes()) {
			result.addAll(((Classifier) superType).getAllSuperClassifiers());
		}
		return result;
	}

}

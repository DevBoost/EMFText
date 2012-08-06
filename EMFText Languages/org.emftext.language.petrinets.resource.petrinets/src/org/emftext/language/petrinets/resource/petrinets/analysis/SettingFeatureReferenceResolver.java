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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.petrinets.ConstructorCall;
import org.emftext.language.petrinets.ProducingArc;

public class SettingFeatureReferenceResolver
		implements
		org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolver<org.emftext.language.petrinets.Setting, org.eclipse.emf.ecore.EStructuralFeature> {

	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.Setting, org.eclipse.emf.ecore.EStructuralFeature> delegate = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.Setting, org.eclipse.emf.ecore.EStructuralFeature>();

	public void resolve(
			String identifier,
			org.emftext.language.petrinets.Setting container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.eclipse.emf.ecore.EStructuralFeature> result) {
		EClassifier type;
		if (container.eContainer() instanceof ProducingArc) {
			ProducingArc arc = (ProducingArc) container.eContainer();
			type = FunctionCallAnalysisHelper.getInstance().getType(arc.getOutput());
		} else {
			ConstructorCall cc = (ConstructorCall) container.eContainer();
			type = cc.getType();
 		}
			
		List<EStructuralFeature> candidates = new ArrayList<EStructuralFeature>();
		if (type != null && type instanceof EClass) {
			EClass c = (EClass) type;
			candidates.addAll(c.getEAllStructuralFeatures());
		} else if (type instanceof EDataType) {
			EAttribute dummy = EcoreFactory.eINSTANCE.createEAttribute();
			dummy.setName(type.getName());
			dummy.setEType(type);
			dummy.setUpperBound(1);
			dummy.setLowerBound(1);
			candidates.add(dummy);
		}
		for (EStructuralFeature eStructuralFeature : candidates) {
			if (resolveFuzzy) {
				result.addMapping(eStructuralFeature.getName(),
						eStructuralFeature);
			} else if (identifier.equals(eStructuralFeature.getName())) {
				result.addMapping(eStructuralFeature.getName(),
						eStructuralFeature);
			}
		}
	}

	public String deResolve(org.eclipse.emf.ecore.EStructuralFeature element,
			org.emftext.language.petrinets.Setting container,
			org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend
		// on any option
	}

}

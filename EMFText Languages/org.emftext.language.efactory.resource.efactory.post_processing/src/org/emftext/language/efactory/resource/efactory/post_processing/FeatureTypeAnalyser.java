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
package org.emftext.language.efactory.resource.efactory.post_processing;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.EfactoryPackage;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.resource.efactory.EfactoryEProblemType;
import org.emftext.language.efactory.resource.efactory.IEfactoryResourcePostProcessor;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResource;
import org.emftext.language.efactory.resource.efactory.util.EfactoryEObjectUtil;

public class FeatureTypeAnalyser implements IEfactoryResourcePostProcessor {

	public void process(EfactoryResource resource) {
		Collection<Feature> features = EfactoryEObjectUtil.getObjectsByType(resource.getAllContents(), EfactoryPackage.eINSTANCE.getFeature());
		for (Feature feature : features) {
			EStructuralFeature eFeature = feature.getEFeature();
			String errorMessage = null;
			if (eFeature != null) {
				if (eFeature.isDerived()) {
					errorMessage = "Feature " + eFeature.getName() + " is derived and can not be set.";
				}
				if (!eFeature.isChangeable()) {
					errorMessage = "Feature " + eFeature.getName() + " is unchangeable and can not be set.";
				}
			}
			if (errorMessage != null) {
				resource.addError(errorMessage, EfactoryEProblemType.ANALYSIS_PROBLEM, feature);
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}

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
package org.emftext.sdk.ui.jobs;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Sequence;

public class JavaStyleGenerationProcess extends AbstractSyntaxGenerationProcess {

	public JavaStyleGenerationProcess(IFile file) {
		super(file);
	}

	@Override
	public void addOpening(GenClass genClass, Sequence sequence) {
		if (hasContainmentFeatures(genClass)) {
			addOpeningBracket(sequence);
		}
	}

	@Override
	public void addClosing(GenClass genClass, Sequence sequence) {
		if (hasContainmentFeatures(genClass)) {
			addClosingBracket(sequence);
		} else {
			addSemicolon(sequence);
		}
	}

	@Override
	protected void addEnumModifiers(Sequence sequence, List<GenFeature> allGenFeatures) {
		// do nothing
	}
	
	@Override
	public void generateFeatureSyntax(ConcreteSyntax cSyntax, Choice featureSyntaxChoice,
			GenFeature genFeature) {
		if (!isBooleanModifierFeature(genFeature)) {
			super.generateFeatureSyntax(cSyntax, featureSyntaxChoice, genFeature);
		}
	}

	@Override
	public void createFeaturePrefix(GenFeature genFeature, Sequence sequence) {
		if (hasTypeConflict(genFeature)) {
			addFeatureNameColon(genFeature, sequence);
		}
	}

	/**
	 * Checks whether the given feature has a type which is also referenced by
	 * another feature in the same GenClass. If the feature's type is a sub type
	 * of another feature's type this is also considered problematic.
	 * 
	 * @param genFeature
	 */
	private boolean hasTypeConflict(GenFeature genFeature) {
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		EClassifier eType = ecoreFeature.getEType();
		GenClass genClass = genFeature.getGenClass();
		List<GenFeature> allGenFeatures = genClass.getAllGenFeatures();
		for (GenFeature nextGenFeature : allGenFeatures) {
			EStructuralFeature nextEcoreFeature = nextGenFeature.getEcoreFeature();
			EClassifier nextEType = nextEcoreFeature.getEType();
			if (!(nextEType instanceof EClass)) {
				continue;
			}
			EClass nextEClass = (EClass) nextEType;
			EList<EClass> allSuperTypes = nextEClass.getEAllSuperTypes();
			if (nextEType == eType || allSuperTypes.contains(eType)) {
				return true;
			}
		}
		return false;
	}

	private void addSemicolon(Sequence sequence) {
		CsString closeBracket = CS_FACTORY.createCsString();
		closeBracket.setValue(";");
		sequence.getChildren().add(closeBracket);
	}
}

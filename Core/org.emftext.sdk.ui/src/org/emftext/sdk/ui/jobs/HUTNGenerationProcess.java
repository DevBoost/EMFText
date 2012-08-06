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
 * 
 */
package org.emftext.sdk.ui.jobs;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * Implements the generation process to derive a HUTN-based syntax for a given metamodel.
 * 
 * @author Christian Wende
 */
public class HUTNGenerationProcess extends AbstractSyntaxGenerationProcess {

	public HUTNGenerationProcess(IFile file) {
		super(file);
	}

	@Override
	public void addOpening(GenClass genClass, Sequence sequence) {
		addOpeningBracket(sequence);
	}

	@Override
	public void addClosing(GenClass genClass, Sequence sequence) {
		addClosingBracket(sequence);
	}

	@Override
	public void createFeaturePrefix(GenFeature genFeature, Sequence sequence) {
		addFeatureNameColon(genFeature, sequence);
	}

	@Override
	protected void addEnumModifiers(Sequence sequence, List<GenFeature> allGenFeatures) {
		// do nothing
	}
	
	@Override
	protected void generateFeatureSyntax(ConcreteSyntax syntax,
			Choice choice, GenFeature genFeature) {
		if (!isBooleanModifierFeature(genFeature)) {
			super.generateFeatureSyntax(syntax, choice, genFeature);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2006-2010 
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
/**
 * 
 */
package org.emftext.sdk.ui.jobs;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
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

	public void addOpening(GenClass genClass, Sequence sequence) {
		addOpeningBracket(sequence);
	}

	public void addClosing(GenClass genClass, Sequence sequence) {
		addClosingBracket(sequence);
	}

	public void createFeaturePrefix(GenFeature genFeature, Sequence sequence) {
		addFeatureNameColon(genFeature, sequence);
	}
}
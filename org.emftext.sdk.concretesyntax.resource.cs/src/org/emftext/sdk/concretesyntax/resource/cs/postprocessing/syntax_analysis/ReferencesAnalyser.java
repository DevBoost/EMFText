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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.GenClassUtil;

/**
 * An analyser that checks that whether there is syntax for all the types 
 * referenced in the syntax. If a containment reference has an abstract type, 
 * which in turn has no concrete sub classes, there is no way to parse correctly.
 * 
 * Furthermore, the analyser checks whether the types of references that are 
 * concrete have syntax defined.
 * 
 * These two checks apply to containment references only.
 * 
 * For non-containment reference there does not need to be syntax defined, because
 * these references can refer to external resources, which may also contain
 * instances of (other) extended meta models.
 */
public class ReferencesAnalyser extends AbstractPostProcessor {

	private final static GenClassUtil genClassUtil = new GenClassUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<Containment> cReferencesToAbstractClassesWithoutConcreteSubtypes = new ArrayList<Containment>();
		Collection<Containment> cReferencesToClassesWithoutSyntax = new ArrayList<Containment>();
		
		getReferencesToAbstractClassesWithConcreteSubtypes(
				syntax,
				cReferencesToAbstractClassesWithoutConcreteSubtypes,
				cReferencesToClassesWithoutSyntax
		);
		
		addDiagnostics(
				syntax, 
				cReferencesToAbstractClassesWithoutConcreteSubtypes,
				"The type (%s) of containment reference '%s' is abstract and has no concrete sub classes with defined syntax."
		);
		addDiagnostics(
				syntax, 
				cReferencesToClassesWithoutSyntax,
				"There is no syntax for the type (%s) of reference '%s'."
		);
		
		Collection<Terminal> unchangeableReferences = findUnchangeableReferences(syntax);
		addDiagnostics(
				syntax, 
				unchangeableReferences,
				"Reference '%2$s' is not changeable."
		);
	}
	
	@Override
	protected boolean doAnalysisAfterPreviousErrors() {
		return false;
	}

	private Collection<Terminal> findUnchangeableReferences(
			ConcreteSyntax syntax) {
		Collection<Terminal> unchangeableReferences = new ArrayList<Terminal>(); 
		Collection<Terminal> teminals = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		for (Terminal terminal : teminals) {
			if (!terminal.getFeature().isChangeable()) {
				unchangeableReferences.add(terminal);
			}
		}
		return unchangeableReferences;
	}

	private void addDiagnostics(
			ConcreteSyntax syntax,
			Collection<? extends Terminal> cReferencesToAbstractClassesWithoutConcreteSubtypes,
			String message) {
		for (Terminal next : cReferencesToAbstractClassesWithoutConcreteSubtypes) {
			GenFeature genFeature = next.getFeature();
			if (genFeature == null) {
				continue;
			}
			GenClass typeGenClass = genFeature.getTypeGenClass();
			if (typeGenClass == null) {
				continue;
			}
			String formattedMessage = String.format(message, typeGenClass.getName(), genFeature.getName());
			if (syntax.isAbstract()) {
				// for abstract syntaxes a warning is sufficient
				addProblem(CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX, formattedMessage, next);
			} else {
				addProblem(CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX, formattedMessage, next);
			}
		}
	}

	private void getReferencesToAbstractClassesWithConcreteSubtypes(
			ConcreteSyntax syntax,
			Collection<Containment> cReferencesToAbstractClassesWithConcreteSubtypes,
			Collection<Containment> cReferencesToClassesWithoutSyntax) {
		
		Collection<Terminal> terminals = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		for (Terminal terminal : terminals) {
			GenClass genFeatureType = getGenFeatureType(terminal);
			if (genFeatureType == null) {
				continue;
			}
			boolean isAbstractGenFeatureType = genClassUtil.isNotConcrete(genFeatureType);
			
			// handle containments
			if (terminal instanceof Containment) {
				Containment containment = (Containment) terminal;
				
				if (isAbstractGenFeatureType) {
					Collection<GenClass> subClassesWithSyntax = syntax.getSubClassesWithSyntax(genFeatureType, false);
            		if (subClassesWithSyntax.isEmpty()) {
            			cReferencesToAbstractClassesWithConcreteSubtypes.add(containment);
            		}
            	} else {
            		// type is concrete -> check whether it has syntax
            		boolean hasNoSyntax = csUtil.getRules(syntax, genFeatureType).isEmpty();
            		if (hasNoSyntax) {
            			cReferencesToClassesWithoutSyntax.add(containment);
            		}
            	}
			}
		}
	}
	
	private GenClass getGenFeatureType(Terminal terminal) {
		GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if (!(ecoreFeature instanceof EReference)) {
			return null;
		}
		EReference ecoreReference = (EReference) ecoreFeature;
		if (ecoreReference.isContainer()) {
			return null;
		}
    	GenClass genFeatureType = genFeature.getTypeGenClass();
    	return genFeatureType;
	}
}

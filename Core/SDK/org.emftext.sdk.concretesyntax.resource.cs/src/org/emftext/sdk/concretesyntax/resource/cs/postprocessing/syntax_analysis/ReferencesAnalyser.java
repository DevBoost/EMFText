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
import org.emftext.sdk.IFunction1;
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
		checkReferencedTypes(syntax);
		checkReferenceProperties(syntax);
	}

	/**
	 * Checks whether the is syntax defined for referenced types.
	 */
	private void checkReferencedTypes(ConcreteSyntax syntax) {
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
				"The type (%s) of containment reference '%s' is abstract and has no concrete sub classes with defined syntax.",
				CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX,
				CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX
		);
		addDiagnostics(
				syntax, 
				cReferencesToClassesWithoutSyntax,
				"There is no syntax for the type (%s) of reference '%s'.",
				CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX,
				CsAnalysisProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX
		);
	}

	/**
	 * Checks whether the used references have the correct properties (
	 * changeable, not derived, not volatile).
	 */
	private void checkReferenceProperties(ConcreteSyntax syntax) {
		// there must not be syntax for unchangeable references
		Collection<Terminal> unchangeableReferences = findUnchangeableReferences(syntax);
		addDiagnostics(
				syntax, 
				unchangeableReferences,
				"Reference '%2$s' is not changeable.",
				CsAnalysisProblemType.UNCHANGABLE_REFERENCE,
				CsAnalysisProblemType.UNCHANGABLE_REFERENCE
		);
		
		// there must not be syntax for derived references
		Collection<Terminal> derivedReferences = findDerivedReferences(syntax);
		addDiagnostics(
				syntax, 
				derivedReferences,
				"Reference '%2$s' is derived.",
				CsAnalysisProblemType.DERIVED_REFERENCE,
				CsAnalysisProblemType.DERIVED_REFERENCE
		);
		
		// there must not be syntax for volatile references
		Collection<Terminal> volatileReferences = findVolatileReferences(syntax);
		addDiagnostics(
				syntax, 
				volatileReferences,
				"Reference '%2$s' is volatile.",
				CsAnalysisProblemType.VOLATILE_REFERENCE,
				CsAnalysisProblemType.VOLATILE_REFERENCE
		);
	}
	
	@Override
	protected boolean doAnalysisAfterPreviousErrors() {
		return false;
	}

	private Collection<Terminal> findUnchangeableReferences(ConcreteSyntax syntax) {
		return findDerivedReferences(syntax, new IFunction1<Boolean, GenFeature>() {

			@Override
			public Boolean call(GenFeature genFeature) {
				return !genFeature.isChangeable();
			}
		});
	}

	private Collection<Terminal> findDerivedReferences(ConcreteSyntax syntax) {
		return findDerivedReferences(syntax, new IFunction1<Boolean, GenFeature>() {

			@Override
			public Boolean call(GenFeature genFeature) {
				return genFeature.isDerived();
			}
		});
	}

	private Collection<Terminal> findVolatileReferences(ConcreteSyntax syntax) {
		return findDerivedReferences(syntax, new IFunction1<Boolean, GenFeature>() {

			@Override
			public Boolean call(GenFeature genFeature) {
				return genFeature.isVolatile();
			}
		});
	}

	private Collection<Terminal> findDerivedReferences(ConcreteSyntax syntax, IFunction1<Boolean, GenFeature> filter) {
		Collection<Terminal> references = new ArrayList<Terminal>(); 
		Collection<Terminal> terminals = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		for (Terminal terminal : terminals) {
			if (filter.call(terminal.getFeature())) {
				references.add(terminal);
			}
		}
		return references;
	}

	private void addDiagnostics(
			ConcreteSyntax syntax,
			Collection<? extends Terminal> cReferencesToAbstractClassesWithoutConcreteSubtypes,
			String message, 
			CsAnalysisProblemType problemTypeForAbstractSyntax, 
			CsAnalysisProblemType problemTypeForConcreteSyntax) {
		
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
				addProblem(problemTypeForAbstractSyntax, formattedMessage, next);
			} else {
				addProblem(problemTypeForConcreteSyntax, formattedMessage, next);
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

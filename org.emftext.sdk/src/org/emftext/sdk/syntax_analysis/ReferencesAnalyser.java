/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An analyser that checks that whether there are concrete sub classes for
 * types of all used references. If a reference has an abstract type, which
 * in turn has no concrete sub classes, there is no way to parse correctly.
 * 
 * Furthermore, the analyser checks whether the types of references that are 
 * concrete have syntax defined.
 * 
 * These two checks apply to containment references only.
 */
public class ReferencesAnalyser extends AbstractPostProcessor {

	private final static GenClassUtil genClassUtil = new GenClassUtil();
	private GeneratorUtil generatorUtil = new GeneratorUtil();
	private GenClassFinder genClassFinder = new GenClassFinder();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		Collection<Containment> cReferencesToAbstractClassesWithoutConcreteSubtypes = new ArrayList<Containment>();
		Collection<Containment> cReferencesToClassesWithoutSyntax = new ArrayList<Containment>();
		Collection<Placeholder> ncReferencesToAbstractClassesWithoutConcreteSubtypes = new ArrayList<Placeholder>();
		
		getReferencesToAbstractClassesWithConcreteSubtypes(
				syntax,
				cReferencesToAbstractClassesWithoutConcreteSubtypes,
				cReferencesToClassesWithoutSyntax,
				ncReferencesToAbstractClassesWithoutConcreteSubtypes
		);
		
		addDiagnostics(
				resource, 
				syntax, 
				cReferencesToAbstractClassesWithoutConcreteSubtypes,
				"The type (%s) of containment reference '%s' is abstract and has no concrete sub classes with defined syntax."
		);
		addDiagnostics(
				resource, 
				syntax, 
				cReferencesToClassesWithoutSyntax,
				"There is no syntax for the type (%s) of reference '%s'."
		);
		addDiagnostics(
				resource, 
				syntax, 
				ncReferencesToAbstractClassesWithoutConcreteSubtypes,
				"The type (%s) of non-containment reference '%s' is abstract and has no concrete sub classes."
		);
		
		Collection<Terminal> unchangeableReferences = findUnchangeableReferences(syntax);
		addDiagnostics(
				resource, 
				syntax, 
				unchangeableReferences,
				"Reference '%2$s' is not changeable."
		);
	}

	private Collection<Terminal> findUnchangeableReferences(
			ConcreteSyntax syntax) {
		Collection<Terminal> unchangeableReferences = new ArrayList<Terminal>(); 
		Collection<Terminal> teminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		for (Terminal terminal : teminals) {
			if (!terminal.getFeature().isChangeable()) {
				unchangeableReferences.add(terminal);
			}
		}
		return unchangeableReferences;
	}

	private void addDiagnostics(
			ITextResource resource,
			ConcreteSyntax syntax,
			Collection<? extends Terminal> cReferencesToAbstractClassesWithoutConcreteSubtypes,
			String message) {
		for (Terminal next : cReferencesToAbstractClassesWithoutConcreteSubtypes) {
			GenFeature genFeature = next.getFeature();
			String formattedMessage = String.format(message, genFeature.getTypeGenClass().getName(), genFeature.getName());
			if (syntax.getModifier() != null) {
				// for abstract syntaxes a warning is sufficient
				addProblem(resource, ECsProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX, formattedMessage, next);
			} else {
				addProblem(resource, ECsProblemType.REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX, formattedMessage, next);
			}
		}
	}

	private void getReferencesToAbstractClassesWithConcreteSubtypes(
			ConcreteSyntax syntax,
			Collection<Containment> cReferencesToAbstractClassesWithConcreteSubtypes,
			Collection<Containment> cReferencesToClassesWithoutSyntax,
			Collection<Placeholder> ncReferencesToAbstractClassesWithoutConcreteSubtypes) {
		
		Collection<Terminal> terminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
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
					Collection<GenClass> subClassesWithSyntax = generatorUtil.getSubClassesWithSyntax(genFeatureType, syntax);
            		if (subClassesWithSyntax.isEmpty()) {
            			cReferencesToAbstractClassesWithConcreteSubtypes.add(containment);
            		}
            	} else {
            		// type is concrete -> check whether it has syntax
            		Rule rule = generatorUtil.getRule(syntax, genFeatureType);
            		if (rule == null) {
            			cReferencesToClassesWithoutSyntax.add(containment);
            		}
            	}
			}
			// handle placeholders
			if (terminal instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) terminal;
				if (isAbstractGenFeatureType) {
					Collection<GenClass> subClasses = genClassFinder.findAllSubclasses(syntax, genFeatureType);
					Collection<GenClass> concreteSubClasses = filterConcrete(subClasses);
					if (concreteSubClasses.isEmpty()) {
						ncReferencesToAbstractClassesWithoutConcreteSubtypes.add(placeholder);
					}
				}
			}
		}
	}
	
	private Collection<GenClass> filterConcrete(Collection<GenClass> genClasses) {
		Collection<GenClass> concreteClasses = new ArrayList<GenClass>();
		for (GenClass genClass : genClasses) {
			if (genClassUtil.isConcrete(genClass)) {
				concreteClasses.add(genClass);
			}
		}
		return concreteClasses;
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

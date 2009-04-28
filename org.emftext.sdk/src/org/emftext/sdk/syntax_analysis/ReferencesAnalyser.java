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
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Rule;

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

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<Containment> referencesToAbstractClassesWithConcreteSubtypes = new ArrayList<Containment>();
		List<Containment> referencesToClassesWithoutSyntax = new ArrayList<Containment>();
		
		getReferencesToAbstractClassesWithConcreteSubtypes(
				syntax,
				referencesToAbstractClassesWithConcreteSubtypes,
				referencesToClassesWithoutSyntax
		);
		for (Containment next : referencesToAbstractClassesWithConcreteSubtypes) {
			GenFeature genFeature = next.getFeature();
			String message = "The type of containment reference '" + genFeature.getName() + "' is abstract and has no concrete sub classes with defined syntax.";
			if (syntax.getModifier() != null) {
				// for abstract syntaxes a warning is sufficient
				resource.addWarning(message, next);
			} else {
				resource.addError(message, next);
			}
		}
		for (Containment next : referencesToClassesWithoutSyntax) {
			GenFeature genFeature = next.getFeature();
			String message = "There is no syntax for the type (" + genFeature.getTypeGenClass().getName() + ") of reference '" + genFeature.getName() + "'.";
			if (syntax.getModifier() != null) {
				// for abstract syntaxes a warning is sufficient
				resource.addWarning(message, next);
			} else {
				resource.addError(message, next);
			}
		}
	}

	private void getReferencesToAbstractClassesWithConcreteSubtypes(
			ConcreteSyntax syntax,
			List<Containment> referencesToAbstractClassesWithConcreteSubtypes,
			List<Containment> referencesToClassesWithoutSyntax) {
		
		final TreeIterator<EObject> allContents = syntax.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Containment) {
				Containment placeholder = (Containment) next;
				GenFeature genFeature = placeholder.getFeature();
				final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
				if (!(ecoreFeature instanceof EReference)) {
					continue;
				}
				EReference ecoreReference = (EReference) ecoreFeature;
				if (ecoreReference.isContainer()) {
					continue;
				}
            	GenClass genFeatureType = genFeature.getTypeGenClass();
				
				if (isNotConcrete(genFeatureType)) {
					Collection<GenClass> subClassesWithSyntax = generatorUtil.getSubClassesWithSyntax(genFeatureType, syntax);
            		if (subClassesWithSyntax.isEmpty()) {
            			referencesToAbstractClassesWithConcreteSubtypes.add(placeholder);
            		}
            	} else {
            		// type is concrete -> check whether it has syntax
            		Rule rule = generatorUtil.getRule(syntax, genFeatureType);
            		if (rule == null) {
            			referencesToClassesWithoutSyntax.add(placeholder);
            		}
            	}
			}
		}
	}

	private boolean isNotConcrete(GenClass genFeatureType) {
		return genFeatureType.isAbstract() || genFeatureType.isInterface();
	}
}

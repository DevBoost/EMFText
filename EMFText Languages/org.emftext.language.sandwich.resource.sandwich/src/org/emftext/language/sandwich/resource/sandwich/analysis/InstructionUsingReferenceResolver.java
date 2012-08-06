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
package org.emftext.language.sandwich.resource.sandwich.analysis;

import org.emftext.language.sandwich.FeatureIngredientName;
import org.emftext.language.sandwich.FeatureRecipeIngredients;
import org.emftext.language.sandwich.Ingredient;
import org.emftext.language.sandwich.IngredientName;
import org.emftext.language.sandwich.Recipe;

public class InstructionUsingReferenceResolver implements org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceResolver<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.FeatureInstructionUsing> {

	public void resolve(java.lang.String identifier, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceResolveResult<org.emftext.language.sandwich.FeatureInstructionUsing> result) {
		Recipe recipe = (Recipe) container.eContainer();
		for(FeatureRecipeIngredients ingredient : recipe.getIngredients()) {
			if (ingredient instanceof Ingredient) {
				FeatureIngredientName name = ((Ingredient)ingredient).getName();
				if (name instanceof IngredientName) {
					if (((IngredientName)name).getValue().equals(identifier)) {
						result.addMapping(identifier, (Ingredient)ingredient);
						return;
					}
				}
			}
		}
	}

	public java.lang.String deResolve(org.emftext.language.sandwich.FeatureInstructionUsing element, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof Ingredient) {
			FeatureIngredientName name = ((Ingredient)element).getName();
			if (name instanceof IngredientName) {
				return ((IngredientName)name).getValue();
			}
		}
		return "";
	}

	public void setOptions(java.util.Map<?,?> options) {
	}

}

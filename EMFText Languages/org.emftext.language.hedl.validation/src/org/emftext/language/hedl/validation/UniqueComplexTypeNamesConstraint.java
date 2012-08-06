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
package org.emftext.language.hedl.validation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;

/**
 * Checks that there are no two complex types (entities or enumerations) that 
 * have the same name. 
 */
public class UniqueComplexTypeNamesConstraint extends AbstractHedlConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
		Set<EClass> types = new LinkedHashSet<EClass>();
		types.add(HEDL_PACKAGE.getEntity());
		types.add(HEDL_PACKAGE.getEnum());

		EObject target = context.getTarget();
		Set<EObject> entitiesAndEnumsWithDuplicateName = checkUniqueNames(target, HEDL_PACKAGE.getEntityModel(), types);
		
		if (entitiesAndEnumsWithDuplicateName.size() > 0) {
			return new ConstraintStatus(this, target, "Duplicate name for enum or entity.", entitiesAndEnumsWithDuplicateName);
		} else {
			return Status.OK_STATUS;
		}
	}
}

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
package org.emftext.language.efactory.resource.efactory.analysis.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate;


public class CustomEfactoryDefaultResolverDelegate<ContainerType extends EObject, ReferenceType extends EObject> extends
		EfactoryDefaultResolverDelegate<ContainerType, ReferenceType> {

	@Override
	protected boolean hasCorrectEType(EObject element, EClass expectedTypeEClass) {
		EClass targetType = null;
		if (element instanceof NewObject) {
			targetType = ((NewObject) element).getEClass();
		} else {
			targetType = element.eClass();
		}
		
		if (targetType.equals(expectedTypeEClass)) {
			return true;
		}
		
		for (EClass superEClass : targetType.getEAllSuperTypes()) {
			if (superEClass.equals(expectedTypeEClass)) {
				return true;
			}
		}
		
		return false;
	}
}

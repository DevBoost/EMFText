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
package org.emftext.language.primitivetypes.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.emftext.language.primitivetypes.PrimitivetypesPackage;

public class PrimitiveTypesHelper {

	public static Object getPrimitiveType(Object type) {
		if (!(type instanceof EClass)) {
			if (!(type instanceof EDataType)) {
				return type;
			}

			//EData types
			EDataType dataType = (EDataType) type;
			if (dataType.getInstanceClassName().equals("java.lang.String")) {
				return PrimitivetypesPackage.Literals.ESTRING_ELEMENT;
			}
			if (dataType.getInstanceClassName().equals("java.lang.Integer")) {
				return PrimitivetypesPackage.Literals.EINT_ELEMENT;
			}
			if (dataType.getInstanceClassName().equals("java.lang.Boolean")) {
				return PrimitivetypesPackage.Literals.EBOOLEAN_ELEMENT;
			}
			//TODO add more
			return dataType;
		}
		EClass typeClass = (EClass) type;
		List<EClass> superTypes = typeClass.getEAllSuperTypes();
		for (EClass superType : superTypes) {
			if (PrimitivetypesPackage.eINSTANCE.getNsURI().equals(superType.getEPackage().getNsURI())) {
				return superType;
			}
		}



		return null;
	}
}

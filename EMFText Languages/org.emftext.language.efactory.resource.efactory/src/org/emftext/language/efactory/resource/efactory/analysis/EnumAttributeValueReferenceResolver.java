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
package org.emftext.language.efactory.resource.efactory.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.PackageImport;

public class EnumAttributeValueReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.EnumAttribute, org.eclipse.emf.ecore.EEnumLiteral> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.EnumAttribute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EEnumLiteral> result) {
		String[] parts = identifier.split("\\.");
		if (parts.length != 2) {
			result.setErrorMessage("Use EnumName.literalName to reference enum literals.");
			return;
		}
		String enumName = parts[0];
		String literalName = parts[1];
		Factory factory = findFactory(container);
		if (factory == null) {
			return;
		}
		List<PackageImport> ePackages = factory.getEpackages();
		for (PackageImport packageImport : ePackages) {
			EPackage ePackage = packageImport.getEPackage();
			List<EClassifier> eClassifiers = ePackage.getEClassifiers();
			for (EClassifier eClassifier : eClassifiers) {
				if (eClassifier instanceof EEnum) {
					EEnum enumType = (EEnum) eClassifier;
					if (enumType.getName().equals(enumName) || resolveFuzzy) {
						List<EEnumLiteral> eLiterals = enumType.getELiterals();
						for (EEnumLiteral eEnumLiteral : eLiterals) {
							if (eEnumLiteral.getName().equals(literalName) || resolveFuzzy) {
								result.addMapping(enumType.getName() + "." + eEnumLiteral.getName(), eEnumLiteral);
								if (!resolveFuzzy) {
									return;
								}
							}
						}
					}
				}
			}
		}
	}
	
	private Factory findFactory(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Factory) {
			return (Factory) object;
		}
		return findFactory(object.eContainer());
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EEnumLiteral element, org.emftext.language.efactory.EnumAttribute container, org.eclipse.emf.ecore.EReference reference) {
		return element.getEEnum().getName() + "." + element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}

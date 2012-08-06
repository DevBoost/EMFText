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
package org.emftext.language.mecore.resource.mecore.analysis.types;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MEcoreType;
import org.emftext.language.mecore.MEnum;
import org.emftext.language.mecore.MImport;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.MType;
import org.emftext.language.mecore.MecoreFactory;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolveResult;

public class TypeResolver {

	private Map<EClassifier, MDataType> dataTypeMap = new LinkedHashMap<EClassifier, MDataType>();

	public void resolve(String identifier, EObject container, boolean resolveFuzzy, final IMecoreReferenceResolveResult<MType> result) {
		EObject root = EcoreUtil.getRootContainer(container);
		for (EClassifier eClassifier : EcorePackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EDataType) {
				if (checkClassifier(identifier, resolveFuzzy, result, eClassifier, "")) {
					return;
				}
			}
		}
		
		if (!result.wasResolved() || resolveFuzzy) {
			if (root instanceof MPackage) {
				MPackage mPackage = (MPackage) root;
				for (MImport mImport : mPackage.getImports()) {
					EPackage ePackage = mImport.getImportedPackage();
					String prefix = mImport.getPrefix() + ".";
					for (EClassifier eClassifier : ePackage.getEClassifiers()) {
						if (checkClassifier(identifier, resolveFuzzy, result, eClassifier, prefix)) {
							return;
						}
					}
					// TODO handle nested packages
				}
			}
		}
	}

	private boolean checkClassifier(String identifier, boolean resolveFuzzy,
			final IMecoreReferenceResolveResult<MType> result,
			EClassifier eClassifier, String prefix) {
		String name = prefix + eClassifier.getName();
		if (identifier.equals(name) || resolveFuzzy) {
			if (eClassifier instanceof EDataType) {
				result.addMapping(name, getMDataType((EDataType) eClassifier));
			} else if (eClassifier instanceof EClassifier) {
				result.addMapping(name, createMEcoreType((EClassifier) eClassifier));
			}
			if (!resolveFuzzy) {
				return true;
			}
		}
		return false;
	}
	
	private MType getMDataType(EDataType eDataType) {
		if (!dataTypeMap.containsKey(eDataType)) {
			MDataType mDataType = MecoreFactory.eINSTANCE.createMDataType();
			mDataType.setEDataType(eDataType);
			dataTypeMap.put(eDataType, mDataType);
		}
		return dataTypeMap.get(eDataType);
	}

	private MEcoreType createMEcoreType(EClassifier eClassifier) {
		MEcoreType mEcoreType = MecoreFactory.eINSTANCE.createMEcoreType();
		mEcoreType.setEcoreType(eClassifier);
		return mEcoreType;
	}

	public String deResolve(MType element) {
		if (element instanceof MClass) {
			return ((MClass) element).getName();
		} else if (element instanceof MEnum) {
			return ((MEnum) element).getName();
		} else if (element instanceof MDataType) {
			MDataType mDataType = (MDataType) element;
			return mDataType.getEDataType().getName();
		}
		return null;
	}
}

/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * The DummyEObject is used to build a stack of dummy objects when descending by
 * tail recursion into left recursive rules. They cache the setting information
 * for initializing concrete EObject instances.
 * When the tail descent is finished this stack is reduced in reverse order. The
 * EObjects are created using the setting informations and a containment hierarchy
 * is build using the left recursive EStructuralFeature.
 */
public class CsDummyEObject extends EObjectImpl  {
	
	private Map<EStructuralFeature, Object> keyValueMap;
	private String recurseFeatureName;
	private EClass type;
	
	public CsDummyEObject(EClass type, String recurseFeatureName) {
		this.recurseFeatureName = recurseFeatureName;
		this.type = type;
		keyValueMap = new LinkedHashMap<EStructuralFeature, Object>();
	}
	
	public EObject applyTo(EObject currentTarget) {
		EStructuralFeature recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);
		EObject newObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);
		for (EStructuralFeature f : keyValueMap.keySet()) {
			EStructuralFeature structuralFeature = newObject.eClass().getEStructuralFeature(f.getName());
			newObject.eSet(structuralFeature, keyValueMap.get(f));
		}
		
		newObject.eSet(recurseFeature, currentTarget);
		return newObject;
	}
	
	public Object getValueByName(String name) {
		for (EStructuralFeature f : this.keyValueMap.keySet()) {
			if (f.getName().equals(name)) return this.keyValueMap.get(f);
		}
		return null;
	}
	
	/**
	 * proxy method
	 */
	public EClass eClass() {
		return type;
	}
	
	public void eSet(EStructuralFeature structuralFeature, Object a0) {
		this.keyValueMap.put(structuralFeature, a0);
	}
	
	public String toString() {
		String keyValuePairs = recurseFeatureName + ": ";
		for (EStructuralFeature f : keyValueMap.keySet()) {
			keyValuePairs += f.getName() + " = " + keyValueMap.get(f) + "\n";
		}
		return keyValuePairs;
	}
}

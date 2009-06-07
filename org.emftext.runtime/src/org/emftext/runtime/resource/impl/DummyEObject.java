package org.emftext.runtime.resource.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * The DummyEObject is used to build a stack of dummy objects when descending 
 * by tail recursion into left recursive rules. They cache the setting 
 * information for initializing concrete EObject instances.
 *
 * When the tail descent is finished this stack is reduced in reverse order. The
 * EObjects are created using the setting informations and a containment hierarchy 
 * is build using the left recursive EStructuralFeature.
 */
public class DummyEObject extends EObjectImpl  {
	private Map<EStructuralFeature, Object> keyValueMap;
	private String recurseFeatureName;
	private EClass type;

	public DummyEObject(EClass type, String recurseFeatureName) {
		this.recurseFeatureName = recurseFeatureName;
		this.type = type;
		keyValueMap = new HashMap<EStructuralFeature, Object>();
	}

	public EObject applyTo(EObject currentTarget) {
		EStructuralFeature recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);
		EObject newEObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);
		for (EStructuralFeature f : keyValueMap.keySet()) {
			EStructuralFeature structuralFeature = newEObject.eClass().getEStructuralFeature(f.getName());
			newEObject.eSet(structuralFeature, keyValueMap.get(f));
		}
		
		newEObject.eSet(recurseFeature, currentTarget);
		return newEObject;
	}

	public Object getValueByName(String name) {
		for(EStructuralFeature f : this.keyValueMap.keySet()) {
			if (f.getName().equals(name)) return this.keyValueMap.get(f);
		}
		return null;
	}
	
	// proxy method
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
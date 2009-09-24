package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// The DummyEObject is used to build a stack of dummy objects when descending
// by tail recursion into left recursive rules. They cache the setting
// information for initializing concrete EObject instances.
//
// When the tail descent is finished this stack is reduced in reverse order. The
// EObjects are created using the setting informations and a containment hierarchy
// is build using the left recursive EStructuralFeature.
//
public class CsDummyEObject extends org.eclipse.emf.ecore.impl.EObjectImpl  {
	
	private java.util.Map<org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object> keyValueMap;
	private String recurseFeatureName;
	private org.eclipse.emf.ecore.EClass type;
	
	public CsDummyEObject(org.eclipse.emf.ecore.EClass type, String recurseFeatureName) {
		this.recurseFeatureName = recurseFeatureName;
		this.type = type;
		keyValueMap = new java.util.HashMap<org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object>();
	}
	
	public org.eclipse.emf.ecore.EObject applyTo(org.eclipse.emf.ecore.EObject currentTarget) {
		org.eclipse.emf.ecore.EStructuralFeature recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);
		org.eclipse.emf.ecore.EObject newObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);
		for (org.eclipse.emf.ecore.EStructuralFeature f : keyValueMap.keySet()) {
			org.eclipse.emf.ecore.EStructuralFeature structuralFeature = newObject.eClass().getEStructuralFeature(f.getName());
			newObject.eSet(structuralFeature, keyValueMap.get(f));
		}
		
		newObject.eSet(recurseFeature, currentTarget);
		return newObject;
	}
	
	public java.lang.Object getValueByName(String name) {
		for (org.eclipse.emf.ecore.EStructuralFeature f : this.keyValueMap.keySet()) {
			if (f.getName().equals(name)) return this.keyValueMap.get(f);
		}
		return null;
	}
	
	// proxy method
	public org.eclipse.emf.ecore.EClass eClass() {
		return type;
	}
	
	public void eSet(org.eclipse.emf.ecore.EStructuralFeature structuralFeature, java.lang.Object a0) {
		this.keyValueMap.put(structuralFeature, a0);
	}
	
	public String toString() {
		String keyValuePairs = recurseFeatureName + ": ";
		for (org.eclipse.emf.ecore.EStructuralFeature f : keyValueMap.keySet()) {
			keyValuePairs += f.getName() + " = " + keyValueMap.get(f) + "\n";
		}
		return keyValuePairs;
	}
}

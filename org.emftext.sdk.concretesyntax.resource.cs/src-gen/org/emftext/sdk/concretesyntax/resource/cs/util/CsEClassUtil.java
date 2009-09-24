package org.emftext.sdk.concretesyntax.resource.cs.util;

// A utility class that provides methods to handle EClasses.
public class CsEClassUtil {
	
	public boolean isSubClass(org.eclipse.emf.ecore.EClass subClassCandidate, org.eclipse.emf.ecore.EClass superClass) {
		for (org.eclipse.emf.ecore.EClass superClassCandidate : subClassCandidate.getEAllSuperTypes()) {
			// There seem to be multiple instances of meta classes when accessed
			// through the generator model. Therefore, we compare by name.
			if (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {
				return true;
			}
		}
		return false;
	}
	
	// Returns all subclasses of 'superClass' that are contained
	// in 'availableClasses'.
	//
	// @param superClass the superclass
	// @param availableClasses the set of classes to search in
	// @return a list of all subclasses of 'superClass'
	public java.util.List<org.eclipse.emf.ecore.EClass> getSubClasses(org.eclipse.emf.ecore.EClass superClass,
	org.eclipse.emf.ecore.EClass[] availableClasses) {
		
		java.util.List<org.eclipse.emf.ecore.EClass> result = new java.util.ArrayList<org.eclipse.emf.ecore.EClass>();
		for (org.eclipse.emf.ecore.EClass next : availableClasses) {
			if (isSubClass(next, superClass) &&			isConcrete(next)) {
				result.add(next);
			}
		}
		return result;
	}
	
	public boolean namesAndPackageURIsAreEqual(org.eclipse.emf.ecore.EClass classA,
	org.eclipse.emf.ecore.EClass classB) {
		return namesAreEqual(classA, classB) &&		packageURIsAreEqual(classA, classB);
	}
	
	public boolean packageURIsAreEqual(org.eclipse.emf.ecore.EClass classA,
	org.eclipse.emf.ecore.EClass classB) {
		String nsURI_A = classA.getEPackage().getNsURI();
		String nsURI_B = classB.getEPackage().getNsURI();
		return (nsURI_A == null && nsURI_B == null) || nsURI_A.equals(nsURI_B);
	}
	
	public boolean namesAreEqual(org.eclipse.emf.ecore.EClass classA, org.eclipse.emf.ecore.EClass classB) {
		return classA.getName().equals(classB.getName());
	}
	
	public boolean isConcrete(org.eclipse.emf.ecore.EClass eClass) {
		return !eClass.isAbstract() && !eClass.isInterface();
	}
	
	public boolean isNotConcrete(org.eclipse.emf.ecore.EClass eClass) {
		return !isConcrete(eClass);
	}
}

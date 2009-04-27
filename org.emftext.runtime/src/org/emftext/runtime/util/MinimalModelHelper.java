package org.emftext.runtime.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A helper class that is able to create minimal model instances for Ecore
 * models.
 */
public class MinimalModelHelper {

	private final static EClassUtil eClassUtil = new EClassUtil();

	public EObject getMinimalModel(EClass eClass, EClass[] allAvailableClasses) {
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == null) {
			return null;
		}
		EObject root = ePackage.getEFactoryInstance().create(eClass);
		List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					// TODO handle opposite containments properly
					EClassifier type = reference.getEType();
					if (type instanceof EClass) {
						EClass typeClass = (EClass) type;
						if (typeClass.isAbstract()) {
							// find subclasses
							List<EClass> subClasses = findSubClasses(typeClass, allAvailableClasses);
							if (subClasses.size() == 0) {
								continue;
							} else {
								// pick the first subclass
								typeClass = subClasses.get(0);
							}
						}
						int lowerBound = reference.getLowerBound();
						for (int i = 0; i < lowerBound; i++) {
							EObject subModel = getMinimalModel(typeClass, allAvailableClasses);
							if (subModel == null) {
								continue;
							}

							Object value = root.eGet(reference);
							if (value instanceof List) {
								List<EObject> list = (List<EObject>) value;
								list.add(subModel);
							} else {
								root.eSet(reference, subModel);
							}
						}
					}
				}
			} else if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if ("EString".equals(attribute.getEType().getName())) {
					root.eSet(attribute, "some" + StringUtil.capitalize(attribute.getName()));
				}
			}
		}
		return root;
	}

	private List<EClass> findSubClasses(EClass eClass,
			EClass[] allAvailableClasses) {
		
		ArrayList<EClass> result = new ArrayList<EClass>();
		for (EClass next : allAvailableClasses) {
			if (eClassUtil.isSubClass(next, eClass) &&
				!next.isAbstract() && 
				!next.isInterface()) {
				result.add(next);
			}
		}
		return result;
	}
}

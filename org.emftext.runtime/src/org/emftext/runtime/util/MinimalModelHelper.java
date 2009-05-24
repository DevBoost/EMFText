package org.emftext.runtime.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * A helper class that is able to create minimal model instances for Ecore
 * models.
 * 
 * TODO mseifert: add cross references where possible
 *                Proxies are now added with a pointer to nowhere. This way we have 
 *                at least something that can be printed even if it results in an error.
 */
public class MinimalModelHelper {

	private final static EClassUtil eClassUtil = new EClassUtil();

	public EObject getMinimalModel(EClass eClass, Collection<EClass> allAvailableClasses) {
		return getMinimalModel(eClass, allAvailableClasses.toArray(new EClass[allAvailableClasses.size()]), null);
	}
	
	public EObject getMinimalModel(EClass eClass, EClass[] allAvailableClasses) {
		return getMinimalModel(eClass, allAvailableClasses, null);
	}
	
	public EObject getMinimalModel(EClass eClass, EClass[] allAvailableClasses, String name) {
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == null) {
			return null;
		}
		EObject root = ePackage.getEFactoryInstance().create(eClass);
		List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isUnsettable()) {
					continue;
				}
				if (!reference.isChangeable()) {
					continue;
				}

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
						EObject subModel = null;
						if (reference.isContainment()) {
							subModel = getMinimalModel(typeClass, allAvailableClasses);
						}
						else {
							subModel = typeClass.getEPackage().getEFactoryInstance().create(typeClass);
							//set some proxy URI to make this object a proxy
							String initialValue = "#some" + StringUtil.capitalize(typeClass.getName());
							URI proxyURI = URI.createURI(initialValue);
							((InternalEObject)subModel).eSetProxyURI(proxyURI);
						}
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
			} else if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if ("EString".equals(attribute.getEType().getName())) {
					String initialValue;
					if(attribute.getName().equals("name") && name != null) {
						initialValue = name;
					}
					else {
						initialValue = "some" + StringUtil.capitalize(attribute.getName());
					}
					Object value = root.eGet(attribute);
					if (value instanceof List) {
						List<String> list = (List<String>) value;
						list.add(initialValue);
					} else {
						root.eSet(attribute, initialValue);
					}
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

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
package org.emftext.language.efactory.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.Attribute;
import org.emftext.language.efactory.BooleanAttribute;
import org.emftext.language.efactory.Containment;
import org.emftext.language.efactory.DateAttribute;
import org.emftext.language.efactory.DoubleAttribute;
import org.emftext.language.efactory.EnumAttribute;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.IntegerAttribute;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.NullAttribute;
import org.emftext.language.efactory.Reference;
import org.emftext.language.efactory.StringAttribute;
import org.emftext.language.efactory.Value;

/**
 * A Builder can be used to obtain a model instance from the
 * EFactory model.
 */
public class Builder {

	public List<EObject> build(Factory eFactory, Map<EObject, String> problems) {
		List<EObject> result = new ArrayList<EObject>();
		// stores the commands that set references after creating all objects
		List<Runnable> commands = new ArrayList<Runnable>();
		// stores the created objects
		Map<NewObject, EObject> createdObjectsMap = new LinkedHashMap<NewObject, EObject>();
		
		for (NewObject root : eFactory.getRoots()) {
			// create the model tree
			EObject rootEObject = createEObject(root, createdObjectsMap, commands, problems);
			// set the cross references
			for (Runnable runnable : commands) {
				runnable.run();
			}
			result.add(rootEObject);
		}

		return result;
	}

	private EObject createEObject(
			NewObject newObject, 
			Map<NewObject, EObject> createdObjectsMap, 
			List<Runnable> commands,
			Map<EObject, String> problems) {
		EClass eClass = newObject.getEClass();
		EPackage ePackage = eClass.getEPackage();
		EFactory eFactoryInstance = ePackage.getEFactoryInstance();
		EObject eObject = eFactoryInstance.create(eClass);
		createdObjectsMap.put(newObject, eObject);
		EList<Feature> features = newObject.getFeatures();
		for (Feature feature : features) {
			boolean isMany = feature.isIsMany();
			EStructuralFeature eFeature = feature.getEFeature();
			Value value = feature.getValue();
			setFeature(eObject, eFeature, value, isMany, createdObjectsMap, commands, problems);
		}
		return eObject;
	}

	private void setFeature(
			final EObject object, 
			final EStructuralFeature eFeature,
			final Value value, 
			final boolean isMany, 
			final Map<NewObject, EObject> createdObjectsMap,
			final List<Runnable> commands,
			final Map<EObject, String> problems) {
		if (value instanceof Reference) {
			// references need to be set at the end, because
			// the referenced object may not exist yet
			commands.add(new Runnable() {
				
				public void run() {
					setFeatureBasic(object, eFeature, value, isMany, createdObjectsMap, commands, problems);
				}
			});
		} else {
			setFeatureBasic(object, eFeature, value, isMany, createdObjectsMap, commands, problems);
		}
	}

	@SuppressWarnings("unchecked")
	private void setFeatureBasic(EObject object, EStructuralFeature eFeature,
			Value value, boolean isMany, Map<NewObject, EObject> createdObjectsMap,
			List<Runnable> commands, Map<EObject, String> problems) {
		Object newValue = getValue(eFeature, value, createdObjectsMap, commands, problems);
		try {
			if (!eFeature.getEType().isInstance(newValue)) {
				throw new IllegalArgumentException();
			}
			int upperBound = eFeature.getUpperBound();
			if (upperBound > 1 || upperBound < 0) {
				Object oldValue = object.eGet(eFeature);
				if (oldValue instanceof List<?>) {
					List<Object> list = (List<Object>) oldValue;
					if (!isMany) {
						list.clear();
					}
					list.add(newValue);
				} else {
					assert false;
				}
			} else {
				object.eSet(eFeature, newValue);
			}
		} catch (IllegalArgumentException e) {
			String msg = "Can't set value of type '" + newValue.getClass().getSimpleName() 
					+ "' to feature '" + eFeature.getName() + "'.";
			problems.put(value, msg);
		}
	}

	private Object getValue(EStructuralFeature eFeature, Value value, Map<NewObject, EObject> createdObjectsMap, List<Runnable> commands, Map<EObject, String> problems) {
		if (value instanceof Reference) {
			Reference reference = (Reference) value;
			EObject referencedNewObject = reference.getValue();
			if (!(referencedNewObject instanceof NewObject)) {
				// this is a 'native' reference to an existing model not wrapped in a NewObject
				return referencedNewObject;
			}
			EObject referencedEObject = createdObjectsMap.get(referencedNewObject);
			return referencedEObject;
		} else if (value instanceof Containment) {
			Containment containment = (Containment) value;
			return createEObject(containment.getValue(), createdObjectsMap, commands, problems);
		} else if (value instanceof Attribute) {
			return createAttributeValue(eFeature, (Attribute) value);
		} else {
			// unknown sub-type of Value
			assert false;
			return null;
		}
	}

	private Object createAttributeValue(EStructuralFeature eFeature, Attribute value) {
		if (value instanceof EnumAttribute) {
			EnumAttribute enumAttribute = (EnumAttribute) value;
			EEnumLiteral literal = enumAttribute.getValue();
			return literal.getInstance();
		} else if (value instanceof StringAttribute) {
			StringAttribute stringAttribute = (StringAttribute) value;
			String string = stringAttribute.getValue();
			return string;
		} else if (value instanceof IntegerAttribute) {
			IntegerAttribute integerAttribute = (IntegerAttribute) value;
			if (eFeature.getEType().getInstanceClassName().equals(Long.class.getName())) {
				Long longValue = integerAttribute.getValue();
				return longValue;
			} else {
				Integer integerValue = (int) integerAttribute.getValue();
				return integerValue;
			}
		} else if (value instanceof DoubleAttribute) {
			DoubleAttribute doubleAttribute = (DoubleAttribute) value;
			if (eFeature.getEType().getInstanceClassName().equals(Double.class.getName())) {
				Double doubleValue = doubleAttribute.getValue();
				return doubleValue;
			} else {
				Float floatValue = (float) doubleAttribute.getValue();
				return floatValue;
			}
		} else if (value instanceof DateAttribute) {
			DateAttribute dateAttribute = (DateAttribute) value;
			Date date = dateAttribute.getValue();
			return date;
		} else if (value instanceof NullAttribute) {
			return null;
		} else if (value instanceof BooleanAttribute) {
			return Boolean.TRUE;
		} else {
			// unknown sub-type of Attribute
			assert false;
			return null;
		}
	}
}

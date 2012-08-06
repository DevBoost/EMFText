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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.Attribute;
import org.emftext.language.efactory.BooleanAttribute;
import org.emftext.language.efactory.Containment;
import org.emftext.language.efactory.DateAttribute;
import org.emftext.language.efactory.DoubleAttribute;
import org.emftext.language.efactory.EfactoryFactory;
import org.emftext.language.efactory.EnumAttribute;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.IntegerAttribute;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.PackageImport;
import org.emftext.language.efactory.Reference;
import org.emftext.language.efactory.StringAttribute;
import org.emftext.language.efactory.Value;

public class Unbuilder {
    private int uniqueNr;


    public Factory unbuild(List<EObject> eObjectList) {
        // Start with unique number zero.
        uniqueNr = 0;

        // Stores the commands that set references after creating all objects.
        List<Runnable> commands = new ArrayList<Runnable>();

        // Stores the packages that need to be imported.
        Set<EPackage> packages = new HashSet<EPackage>();

        // Stores the created objects.
        Map<EObject, NewObject> createdObjectsMap =
                                    new LinkedHashMap<EObject, NewObject>();

        // Create factory (result).
        Factory factory = EfactoryFactory.eINSTANCE.createFactory();
        
        for(EObject eObject : eObjectList) {
            // Create the model tree.
            NewObject rootEObject = createNewObject(eObject, createdObjectsMap,
                                                    commands, packages); 
            // Set the cross references.
            for (Runnable runnable : commands) {
                runnable.run();
            }
            factory.getRoots().add(rootEObject);
        }

        // Add package imports.
        List<EPackage> sortedPackages = new ArrayList<EPackage>(packages);
        Collections.sort(sortedPackages, new Comparator<EPackage>() {
            public int compare(EPackage arg0, EPackage arg1) {
                return String.CASE_INSENSITIVE_ORDER.compare(arg0.getNsURI(),
                                                             arg1.getNsURI());
            }
            
        });
        List<PackageImport> packageImports = factory.getEpackages();
        for (EPackage ePackage: sortedPackages)
        {
            PackageImport pkgImport =
                            EfactoryFactory.eINSTANCE.createPackageImport();
            pkgImport.setEPackage(ePackage);
            packageImports.add(pkgImport);
        }

        // Return the unbuilt factory.
        return factory;
    }


    private NewObject createNewObject(
                            EObject eObject, 
                            Map<EObject, NewObject> createdObjectsMap,
                            List<Runnable> commands,
                            Set<EPackage> packages)
    {
        EClass eClass = eObject.eClass();
        EPackage ePackage = eClass.getEPackage();
        packages.add(ePackage);
        NewObject newObject = EfactoryFactory.eINSTANCE.createNewObject();
        createdObjectsMap.put(eObject, newObject);
        newObject.setEClass(eClass);
        newObject.setName("id" + uniqueNr);
        uniqueNr++;
        List<EStructuralFeature> eFeatures =
                                        eClass.getEAllStructuralFeatures();
        for (EStructuralFeature eFeature: eFeatures)
        {
            boolean isMany = eFeature.isMany();
            Object value = eObject.eGet(eFeature);
            setFeature(newObject, eFeature, value, isMany,
                       createdObjectsMap, commands, packages);
        }
        return newObject;
    }


    private void setFeature(final NewObject newObject, 
                            final EStructuralFeature eFeature,
                            final Object value, 
                            final boolean isMany, 
                            final Map<EObject, NewObject> createdObjectsMap,
                            final List<Runnable> commands,
                            final Set<EPackage> packages)
    {
        if (eFeature instanceof EReference &&
                        !((EReference)eFeature).isContainment())
        {
            // References need to be set at the end, because the referenced
            // object may not exist yet.
            commands.add(new Runnable() {
                public void run() {
                    setFeatureBasic(newObject, eFeature, value, isMany,
                                    createdObjectsMap, commands, packages);
                }
            });
            return;
        }
        setFeatureBasic(newObject, eFeature, value, isMany, createdObjectsMap,
                        commands, packages);
    }


    private void setFeatureBasic(NewObject newObject,
                                 EStructuralFeature eFeature,
                                 Object value,
                                 boolean isMany,
                                 Map<EObject, NewObject> createdObjectsMap,
                                 List<Runnable> commands,
                                 Set<EPackage> packages)
    {
        List<Feature> features = newObject.getFeatures();

        if (isMany)
        {
            assert value instanceof List;
            @SuppressWarnings("unchecked")
            List<EObject> valueList = (List<EObject>)value;
            for(EObject valueItem: valueList)
            {
                Value newValue = getValue(eFeature, valueItem,
                                          createdObjectsMap, commands,
                                          packages);
                Feature feature = EfactoryFactory.eINSTANCE.createFeature();
                feature.setIsMany(isMany);
                feature.setEFeature(eFeature);
                feature.setValue(newValue);
                features.add(feature);
            }
        } else
        {
            Value newValue = getValue(eFeature, value, createdObjectsMap,
                                      commands, packages);
            if (newValue != null) {
                Feature feature = EfactoryFactory.eINSTANCE.createFeature();
                feature.setIsMany(isMany);
                feature.setEFeature(eFeature);
                feature.setValue(newValue);
                features.add(feature);
            }
        }
    }


    private Value getValue(EStructuralFeature eFeature,
                           Object value,
                           Map<EObject, NewObject> createdObjectsMap,
                           List<Runnable> commands,
                           Set<EPackage> packages)
    {
        if (eFeature instanceof EReference)
        {
            if (value == null) return null;
            EReference eReference = (EReference)eFeature;
            if (eReference.isContainment()) {
                Containment containment =
                                EfactoryFactory.eINSTANCE.createContainment();
                assert value instanceof EObject;
                NewObject newObject = createNewObject((EObject)value,
                                                      createdObjectsMap,
                                                      commands, packages);
                containment.setValue(newObject);
                return containment;
            } else {
                Reference reference =
                                EfactoryFactory.eINSTANCE.createReference();
                assert value instanceof EObject;
                NewObject referencedNewObject = createdObjectsMap.get(value);
                reference.setValue(referencedNewObject);
                return reference;
            }
        } else if (eFeature instanceof EAttribute)
        {
            Attribute attribute = createAttribute(eFeature, value);
            return attribute;
        } else {
            // Unknown sub-type of EStructuralFeature.
            assert false;
            return null;
        }
    }

    private Attribute createAttribute(EStructuralFeature eFeature,
                                      Object value)
    {
        if (value == null) {
            return null;
        }
        if (value instanceof EEnumLiteral) {
            EnumAttribute attr = EfactoryFactory.eINSTANCE.createEnumAttribute();
            attr.setValue((EEnumLiteral)value);
            return attr;
        }
        if (value instanceof Boolean) {
            BooleanAttribute attr = EfactoryFactory.eINSTANCE.createBooleanAttribute();
            attr.setValue((Boolean)value);
            return attr;
        }
        if (value instanceof String) {
            StringAttribute attr = EfactoryFactory.eINSTANCE.createStringAttribute();
            attr.setValue((String)value);
            return attr;
        }
        if (value instanceof Integer) {
            IntegerAttribute attr = EfactoryFactory.eINSTANCE.createIntegerAttribute();
            attr.setValue((Integer)value);
            return attr;
        }
        if (value instanceof Long) {
            IntegerAttribute attr = EfactoryFactory.eINSTANCE.createIntegerAttribute();
            attr.setValue((Long)value);
            return attr;
        }
        if (value instanceof Float) {
            DoubleAttribute attr = EfactoryFactory.eINSTANCE.createDoubleAttribute();
            attr.setValue((Float)value);
            return attr;
        }
        if (value instanceof Double) {
            DoubleAttribute attr = EfactoryFactory.eINSTANCE.createDoubleAttribute();
            attr.setValue((Double)value);
            return attr;
        }
        if (value instanceof Date) {
            DateAttribute attr = EfactoryFactory.eINSTANCE.createDateAttribute();
            attr.setValue((Date)value);
            return attr;
        }

        // Unknown sub-type of attribute value type.
        assert false;
        return null;
    }
}

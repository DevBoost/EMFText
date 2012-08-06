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
package org.emftext.tools.templifier;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.templateconcepts.TemplateMetamodelConstants;

/**
 * The Templifier takes a meta model and creates a templified version
 * of the contained language.
 * 
 * TODO create CS model-based and complete
 */
public class Templifier {
	
	private static final EcoreFactory ECORE_FACTORY = EcoreFactory.eINSTANCE;

	private EPackage templateLanguageEPackage;
	private List<String> createdConceptNames;
	private EPackage conceptsPackage;
	private StringBuffer generatedCS;
	private Map<EClass, List<EReference>> typesToReferences;
	
	// Execute this in metamodel folder!
	public static void main(String[] args) {
		Templifier templifier = new Templifier();
		templifier.templifyBool();
	}

	private void templifyBool() {
		// object language
		String pathToObjectLanguage = "../../org.emftext.language.bool/metamodel/bool.ecore";
		String objectLanguageRootClass = "Class";

		// template language (to be generated)
		String templateLanguageName = "tbool";
		templify(pathToObjectLanguage, objectLanguageRootClass, templateLanguageName);
	}
	
	private void templify(String pathToObjectLanguage, String objectLanguageRootClass, String templateLanguageName) {
		// template concepts
		String pathToTemplateConcepts = "../../org.emftext.language.template_concepts/metamodel/template_concepts.ecore";

		registerResourceFactories();

		templateLanguageEPackage = ECORE_FACTORY.createEPackage();
		templateLanguageEPackage.setName(templateLanguageName);
		templateLanguageEPackage.setNsPrefix(templateLanguageName);
		templateLanguageEPackage.setNsURI("http://www.emftext.org/language/" + templateLanguageName);
		
		createdConceptNames = new ArrayList<String>();
		generatedCS = new StringBuffer();
		typesToReferences = new HashMap<EClass, List<EReference>>();
		
		List<EPackage> packages = getPackages(pathToObjectLanguage);
		List<EPackage> concepts = getPackages(pathToTemplateConcepts);
		conceptsPackage = concepts.get(0);
		
		addTemplateClass(objectLanguageRootClass, findClassByName(packages, objectLanguageRootClass));
		
		for (EPackage ePackage : packages) {
			handle(ePackage);
		}
		
		for (EClass referencedType : typesToReferences.keySet()) {
			List<EReference> references = typesToReferences.get(referencedType);
			System.out.println("EClass " + referencedType.getName() + " is referenced by:");
			for (EReference reference : references) {
				// check feature cardinality
				int lower = reference.getLowerBound();
				int upper = reference.getUpperBound();
				System.out.println("--> " + reference.getEContainingClass().getName() + "." + reference.getName() + " " + lower + ".." + upper);
			}
			
			boolean cardinalitiesAreAllEqual = true;
			EReference firstReference = references.get(0);
			int lastLower = firstReference.getLowerBound();
			int lastUpper = firstReference.getUpperBound();
			for (int r = 1; r < references.size(); r++) {
				EReference reference2 = references.get(r);
				// check feature cardinality
				int nextLower = reference2.getLowerBound();
				int nextUpper = reference2.getUpperBound();
				boolean lowerEqual = lastLower == nextLower;
				boolean upperEqual = lastUpper == nextUpper;
				cardinalitiesAreAllEqual &= lowerEqual && upperEqual;
				lastLower = nextLower;
				lastUpper = nextUpper;
			}
			
			if (cardinalitiesAreAllEqual) {
				System.out.println("Cardinalities match --> Create template concepts.\n");
				String typeName = firstReference.getEContainingClass().getName();
				if (compatibleWithPlaceholder(lastLower, lastUpper)) {
					addPlaceholder(referencedType, typeName);
				}
				if (compatibleWithIf(lastLower, lastUpper)) {
					addIf(referencedType, typeName);
				}
				if (compatibleWithIfElse(lastLower, lastUpper)) {
					addIfElse(referencedType, typeName);
				}
				if (compatibleWithFor(lastLower, lastUpper)) {
					addFor(referencedType, typeName);
				}
			}
		}
		saveMetamodel(templateLanguageName);
		saveCS(templateLanguageName);
	}

	private void saveCS(String templateLanguageName) {
		try {
			FileWriter writer = new FileWriter(templateLanguageName + ".cs");
			writer.write(generatedCS.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EClass findClassByName(List<EPackage> packages, String name) {
		for (EPackage ePackage : packages) {
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier.getName().equals(name)) {
					if (classifier instanceof EClass) {
						return (EClass) classifier;
					}
				}
			}
		}
		return null;
	}

	private void addTemplateClass(String name, EClass originalRoot) {

		EClass templateClass = (EClass) conceptsPackage.getEClassifier("Template");

		// create template concepts (inherit from the type and the concept)
		EClass concreteTemplate = ECORE_FACTORY.createEClass();
		concreteTemplate.setName(name + "Template");
		concreteTemplate.getESuperTypes().add(templateClass);
		
		EReference referenceToOriginalType = ECORE_FACTORY.createEReference();
		referenceToOriginalType.setName(TemplateMetamodelConstants.REFERENCE_TEMPLATE_BODY);
		referenceToOriginalType.setEType(originalRoot);
		referenceToOriginalType.setContainment(true);
		referenceToOriginalType.setLowerBound(1);
		referenceToOriginalType.setUpperBound(1);
		// add reference to original (abstract type)
		concreteTemplate.getEStructuralFeatures().add(referenceToOriginalType);
		
		templateLanguageEPackage.getEClassifiers().add(concreteTemplate);
		
	}

	private static List<EPackage> getPackages(String filename) {
		List<EPackage> packages = new ArrayList<EPackage>();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(filename));
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
			return packages;
		}
		TreeIterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof EPackage) {
				packages.add((EPackage) next);
			}
		}
		return packages;
	}

	private void saveMetamodel(String templateLanguageName) {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource extendedMetamodel = resourceSet.createResource(URI.createFileURI(templateLanguageName + ".ecore"));
		extendedMetamodel.getContents().add(templateLanguageEPackage);
		try {
			extendedMetamodel.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handle(EPackage ePackage) {
		List<EClassifier> classifiers = ePackage.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			handle(classifier);
		}
	}

	private void handle(EClassifier classifier) {
		if (classifier instanceof EClass) {
			handle((EClass) classifier);
		}
	}

	private void handle(EClass classifier) {
		List<EStructuralFeature> features = classifier.getEStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature instanceof EReference) {
				handle((EReference) feature);
			}
		}
	}
	
	private void handle(EReference feature) {
		EClassifier featureType = feature.getEType();
		if (featureType instanceof EClass) {
			EClass typeClass = (EClass) featureType;
			
			// check if type is abstract check cardinality
			if (!typeClass.isAbstract() && !typeClass.isInterface()) {
				return;
			}
			// check feature cardinality
			int lower = feature.getLowerBound();
			int upper = feature.getUpperBound();
			
			addToTypeReferences(typeClass, feature);
			System.out.println("Templifier.handle() " + feature.getEContainingClass().getName() + "." + feature.getName() + " " + lower + ".." + upper);
		}
	}

	private void addToTypeReferences(EClass typeClass, EReference feature) {
		if (!typesToReferences.containsKey(typeClass)) {
			typesToReferences.put(typeClass, new ArrayList<EReference>());
		}
		typesToReferences.get(typeClass).add(feature);
	}

	private boolean compatibleWithPlaceholder(int lower, int upper) {
		boolean lowerIsCompatible = lower == 0 || lower == 1;
		boolean upperIsCompatible = upper >= 1;
		return lowerIsCompatible && upperIsCompatible;
	}

	private boolean compatibleWithFor(int lower, int upper) {
		return lower == 0 && upper < 0;
	}

	private boolean compatibleWithIf(int lower, int upper) {
		return lower == 0;
	}

	private boolean compatibleWithIfElse(int lower, int upper) {
		return lower == 1 && upper == 1;
	}

	private void addPlaceholder(EClass featureType, String typeName) {
		String newName = "Ph" + typeName;
		boolean wasCreated = addConcept(featureType, (EClass) conceptsPackage.getEClassifier("Placeholder"), newName, null, null, 1);
		if (wasCreated) {
			generatedCS.append("\t" + newName + " ::= \"<%=\" expression['\"','\"'] \"%>\";\n");
		}
	}

	private void addIf(EClass featureType, String typeName) {
		String newName = "If" + typeName;
		boolean wasCreated = addConcept(featureType, (EClass) conceptsPackage.getEClassifier("If"), newName, TemplateMetamodelConstants.REFERENCE_IF_BODY, null, 1);
		if (wasCreated) {
			generatedCS.append("\t" + newName + " ::= \"<%IF\" expression['\"','\"'] \"%>\" " + TemplateMetamodelConstants.REFERENCE_IF_BODY + " \"<%ENDIF%>\";\n");
		}
	}

	private void addIfElse(EClass featureType, String typeName) {
		String newName = "IfElse" + typeName;
		boolean wasCreated = addConcept(featureType, (EClass) conceptsPackage.getEClassifier("IfElse"), newName, TemplateMetamodelConstants.REFERENCE_IF_BODY, TemplateMetamodelConstants.REFERENCE_ELSE_BODY, 1);
		if (wasCreated) {
			generatedCS.append("\t" + newName + " ::= \"<%IF\" expression['\"','\"'] \"%>\" " + TemplateMetamodelConstants.REFERENCE_IF_BODY + " \"<%ELSE%>\" " + TemplateMetamodelConstants.REFERENCE_ELSE_BODY + " \"<%ENDIF%>\";\n");
		}
	}

	private void addFor(EClass featureType, String typeName) {
		String newName = "For" + typeName;
		boolean wasCreated = addConcept(featureType, (EClass) conceptsPackage.getEClassifier("ForEach"), newName, TemplateMetamodelConstants.REFERENCE_FOR_BODY, null, -1);
		if (wasCreated) {
			generatedCS.append("\t" + newName + " ::= \"<%FOR\" expression['\"','\"'] \"%>\" " + TemplateMetamodelConstants.REFERENCE_FOR_BODY + " \"<%ENDFOR%>\";\n");
		}
	}

	private boolean addConcept(EClass featureType, EClass concept, String name, String body, String elseBody, int upperBound) {
		// create template concepts (inherit from the type and the concept)
		EClass concreteConcept = ECORE_FACTORY.createEClass();
		concreteConcept.setName(name);

		if (createdConceptNames.contains(concreteConcept.getName())) {
			return false;
		}
		createdConceptNames.add(concreteConcept.getName());
		
		concreteConcept.getESuperTypes().add(featureType);
		concreteConcept.getESuperTypes().add(concept);
		
		if (body != null) {
			addReferenceToOriginalType(featureType, concreteConcept, body, upperBound);
		}
		
		if (elseBody != null) {
			addReferenceToOriginalType(featureType, concreteConcept, elseBody, upperBound);
		}
		
		templateLanguageEPackage.getEClassifiers().add(concreteConcept);
		return true;
	}

	private void addReferenceToOriginalType(EClass featureType,
			EClass concreteConcept, String referenceName, int upperBound) {
		EReference referenceToOriginalType = ECORE_FACTORY.createEReference();
		referenceToOriginalType.setName(referenceName);
		referenceToOriginalType.setEType(featureType);
		referenceToOriginalType.setContainment(true);
		referenceToOriginalType.setLowerBound(1);
		referenceToOriginalType.setUpperBound(upperBound);

		// add reference to original (abstract type)
		concreteConcept.getEStructuralFeatures().add(referenceToOriginalType);
	}

	private void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
	}
}

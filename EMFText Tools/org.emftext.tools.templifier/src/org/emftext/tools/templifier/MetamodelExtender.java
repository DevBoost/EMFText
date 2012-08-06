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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;

/**
 * TODO This can be turned into a pre-processor for arbitrary ecore/gemnmodel/cs(optional) combinations
 *      such that people can modify their original metamodel without bothering about the extensibility.
 *      The following should be added then:
 *      - provide a copy of the templates currently located in org.emftext.language.java
 *      - modify the extensible version genmodel to use the dynamic templates
 *
 * TODO open issues
 *      - How to handle opposites?
 *
 */
public class MetamodelExtender {
	
	//TODO currently fixed for the java metamodel
	public static final String CORE_METAMODEL = "../org.emftext.language.java/metamodel/plain_java.ecore";
	public static final String CORE_METAMODEL_EXTENSIBLE = "../org.emftext.language.java/metamodel/java.ecore";
	public static final String CORE_GENMODEL = "../org.emftext.language.java/metamodel/plain_java.genmodel";
	public static final String CORE_GENMODEL_EXTENSIBLE = "../org.emftext.language.java/metamodel/java.genmodel";
	public static final String CORE_CS = "../org.emftext.language.java/metamodel/plain_java.cs";
	public static final String CORE_CS_EXTENSIBLE = "../org.emftext.language.java/metamodel/java.cs";	
	
	public static final String sfTypePackageName = "sftypes";
	public static final String wrappedPrimitivesPackageName = "ptypes";
	public static final String ncReferencesPackageName = "rtypes";
	
	static protected ResourceSet rs = null;
	static protected Resource coreMMResource = null;
	static protected Resource coreGenModelResource = null;
	static protected Resource coreCSResource = null;
	
	static protected EPackage getPTPackage() throws IOException {
		File f = new File("../org.emftext.language.primitive_types/metamodel/primitive_types.ecore");	
		Resource r = rs.getResource(URI.createFileURI(f.getCanonicalPath().toString()), true);
		return (EPackage) r.getContents().get(0);
	}

	static protected EPackage getMMPackage() throws IOException {
		if (coreMMResource == null) {
			getPTPackage(); //ensure pt package loaded
			File f = new File(CORE_METAMODEL);	
			coreMMResource = rs.getResource(URI.createFileURI(f.getCanonicalPath().toString()), true);
		}
		return (EPackage) coreMMResource.getContents().get(0);
	}
	
	static protected GenModel getGenModel() throws IOException {
		if (coreGenModelResource == null) {
			File f = new File(CORE_GENMODEL);	
			coreGenModelResource = rs.getResource(URI.createFileURI(f.getCanonicalPath().toString()), true);
		}
		return (GenModel) coreGenModelResource.getContents().get(0);
	}
	
	static protected ConcreteSyntax getCS() throws IOException {
		if (coreCSResource == null) {
			File f = new File(CORE_CS);	
			coreCSResource = rs.getResource(URI.createFileURI(f.getCanonicalPath().toString()), true);
			EcoreUtil.resolveAll(coreCSResource);
		}
		return (ConcreteSyntax) coreCSResource.getContents().get(0);
	}
	
	static protected EPackage getSFTypesSubPackage(EPackage parentPackage) {
		for(EPackage subPackage : parentPackage.getESubpackages()) {
			if (subPackage.getName().equals(sfTypePackageName)) {
				return subPackage;
			}
		}
		EPackage sftPackage = EcoreFactory.eINSTANCE.createEPackage();
		sftPackage.setName(sfTypePackageName);
		sftPackage.setNsPrefix(sfTypePackageName);
		sftPackage.setNsURI(parentPackage.getNsURI() + "/" + sfTypePackageName);
		parentPackage.getESubpackages().add(sftPackage);
		return sftPackage;
	}
	
	static protected EPackage getNCRTypesSubPackage(EPackage parentPackage) {
		for(EPackage subPackage : parentPackage.getESubpackages()) {
			if (subPackage.getName().equals(ncReferencesPackageName)) {
				return subPackage;
			}
		}
		EPackage ncrPackage = EcoreFactory.eINSTANCE.createEPackage();
		ncrPackage.setName(ncReferencesPackageName);
		ncrPackage.setNsPrefix(ncReferencesPackageName);
		ncrPackage.setNsURI(parentPackage.getNsURI() + "/" + ncReferencesPackageName);
		parentPackage.getESubpackages().add(ncrPackage);
		return ncrPackage;
	}
	
	static protected EPackage getWPTypesSubPackage(EPackage parentPackage) {
		for(EPackage subPackage : parentPackage.getESubpackages()) {
			if (subPackage.getName().equals(wrappedPrimitivesPackageName)) {
				return subPackage;
			}
		}
		EPackage wptPackage = EcoreFactory.eINSTANCE.createEPackage();
		wptPackage.setName(wrappedPrimitivesPackageName);
		wptPackage.setNsPrefix(wrappedPrimitivesPackageName);
		wptPackage.setNsURI(parentPackage.getNsURI() + "/" + wrappedPrimitivesPackageName);
		parentPackage.getESubpackages().add(wptPackage);
		return wptPackage;
	}
	
	static protected EClass getWPType(EDataType eType) throws IOException {
		EPackage ptPackage = getPTPackage();
		String wpTypeName = eType.getName() + "Element";
		EClass wpType = (EClass) ptPackage.getEClassifier(wpTypeName);
		if (wpType == null) {
			wpType = EcoreFactory.eINSTANCE.createEClass();
			wpType.setName(wpTypeName);
			wpType.setAbstract(true);
			EAttribute valueAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			valueAttribute.setName("value");
			valueAttribute.setEType(eType);
			valueAttribute.setLowerBound(1);
			valueAttribute.setUpperBound(1);
			wpType.getEStructuralFeatures().add(valueAttribute);
			ptPackage.getEClassifiers().add(wpType);
		}
		return wpType;
	}
	
	static protected void introduceSFType(EStructuralFeature originalSF, 
			Map<EStructuralFeature, EStructuralFeature>	extensibleFeaturesMap,
			Map<EStructuralFeature, EClass> wrapperMap) throws IOException {
		
		String sfName = "extensible" + originalSF.getName().substring(0,1).toUpperCase() + originalSF.getName().substring(1);
		EReference oppositeRef = null;
		if (originalSF.getEContainingClass().getEStructuralFeature(sfName) != null) {
			//already processed
			return;
		}
		if (originalSF instanceof EReference) {
			EReference ref = (EReference) originalSF;
			oppositeRef = ref.getEOpposite();
			if (!ref.isContainment() && oppositeRef != null) {
				return;
			}
		}
		EPackage sfTypesPackage = getSFTypesSubPackage(originalSF.getEContainingClass().getEPackage());
		//create new extendable feature
		EStructuralFeature sf = EcoreFactory.eINSTANCE.createEReference();
		sf.setEType(originalSF.getEType());
		sf.setLowerBound(originalSF.getLowerBound());
		sf.setUpperBound(originalSF.getUpperBound());
		sf.setName(originalSF.getName());

		((EReference)sf).setContainment(true);
		
		originalSF.getEContainingClass().getEStructuralFeatures().add(sf);
		
		EClassifier originalType = originalSF.getEType();
		EClass sfType = EcoreFactory.eINSTANCE.createEClass();
		sfType.setName(getSFTypeName(sf));
		sfType.setAbstract(true);
		if (originalType instanceof EDataType) {
			originalType = wrapPrimitiveType(sf, wrapperMap);
		}
		else {
			EReference ref = (EReference) sf;
			if (!((EReference)originalSF).isContainment()) {
				originalType = wrapNCReference(ref, wrapperMap);
			}
		}
		((EClass)originalType).getESuperTypes().add(sfType);
		sf.setName(sfName);
		sf.setEType(sfType);
		sfTypesPackage.getEClassifiers().add(sfType);
		
		//set original to derived
		originalSF.setDerived(true);
		originalSF.setTransient(true);
		originalSF.setVolatile(true);
		if (originalSF instanceof EReference) {
			((EReference)originalSF).setContainment(false);
		}
		if (oppositeRef != null) {
			oppositeRef.setTransient(true);
			originalSF.setVolatile(true);
		}
		
		addDeriveAnnotation(originalSF, sf);
		
		extensibleFeaturesMap.put(originalSF, sf);
	}
	
	protected static void addDeriveAnnotation(EStructuralFeature originalSF, EStructuralFeature sf) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("http://www.eclipse.org/emf/2002/GenModel");
		
		annotation.getDetails().put("derivedFromExtensibleFeature", sf.getName());
		
		originalSF.getEAnnotations().add(annotation);
	}

	static protected EClass wrapPrimitiveType(EStructuralFeature sf, 
			Map<EStructuralFeature, EClass> wrapperMap) throws IOException {
		EPackage wptPackage = getWPTypesSubPackage(sf.getEContainingClass().getEPackage());
		EClass ptClass = EcoreFactory.eINSTANCE.createEClass();
		ptClass.setName(getPTypeName(sf));
		EClass ptSuperClass = getWPType((EDataType) sf.getEType());
		ptClass.getESuperTypes().add(ptSuperClass);
		wptPackage.getEClassifiers().add(ptClass);
		
		wrapperMap.put(sf, ptClass);
		return ptClass;
	}
	
	static protected EClass wrapNCReference(EReference sf,
			Map<EStructuralFeature, EClass> wrapperMap) throws IOException {
		EPackage ncrPackage = getNCRTypesSubPackage(sf.getEContainingClass().getEPackage());
		EClass ncrClass = EcoreFactory.eINSTANCE.createEClass();
		ncrClass.setName(getNCRTypeName(sf));
		
		EReference valueNCReference = EcoreFactory.eINSTANCE.createEReference();
		valueNCReference.setContainment(false);
		valueNCReference.setName("value");
		valueNCReference.setEType(sf.getEType());
		valueNCReference.setLowerBound(1);
		valueNCReference.setUpperBound(1);
		ncrClass.getEStructuralFeatures().add(valueNCReference);
		
		ncrPackage.getEClassifiers().add(ncrClass);
		sf.setContainment(true);
		
		wrapperMap.put(sf, ncrClass);
		return ncrClass;
	}

	static protected String getSFTypeName(EStructuralFeature sf) {
		return "Feature" + sf.getEContainingClass().getName() + sf.getName().substring(0,1).toUpperCase() + sf.getName().substring(1);
	}
	
	static protected String getPTypeName(EStructuralFeature sf) {
		return sf.getEContainingClass().getName() + sf.getName().substring(0,1).toUpperCase() + sf.getName().substring(1);
	}

	static protected String getNCRTypeName(EStructuralFeature sf) {
		return sf.getEContainingClass().getName() + sf.getName().substring(0,1).toUpperCase() + sf.getName().substring(1);
	}
	
	static protected void addSFTypes() throws IOException {
		Map<EStructuralFeature, EStructuralFeature>	extensibleFeaturesMap = new HashMap<EStructuralFeature, EStructuralFeature>();
		Map<EStructuralFeature, EClass> wrapperMap = new HashMap<EStructuralFeature, EClass>();
	
		EPackage mmPackage = getMMPackage();
		for(EPackage subPackage : mmPackage.getESubpackages()) {
			for(EClassifier eClassifier : subPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					for(EStructuralFeature sf : new BasicEList<EStructuralFeature>(eClass.getEStructuralFeatures())) {
						introduceSFType(sf, extensibleFeaturesMap, wrapperMap);
					}
				}
			}	
		}
		
		GenModel genModel = getGenModel();
		File f = new File("../org.emftext.language.primitive_types/metamodel/primitive_types.genmodel");	
		Resource r = rs.getResource(URI.createFileURI(f.getCanonicalPath().toString()), true);
		genModel.getUsedGenPackages().addAll(((GenModel) r.getContents().get(0)).getGenPackages());
		getGenModel().reconcile();
		
		adjustCS(genModel, extensibleFeaturesMap, wrapperMap);
	}

	protected static void adjustCS(GenModel genModel,
			Map<EStructuralFeature, EStructuralFeature> extensibleFeaturesMap,
			Map<EStructuralFeature, EClass> wrapperMap) throws IOException {
		ConcreteSyntax cs = getCS();
		List<Rule> newRules = new ArrayList<Rule>();
		List<Import> newImports = new ArrayList<Import>();
		List<GenClass> coveredBoxRules = new ArrayList<GenClass>();
		
		for(Iterator<EObject> i = cs.eAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof Terminal) {
				Terminal terminal = (Terminal) next;
				EStructuralFeature extensibleFeature = extensibleFeaturesMap.get(terminal.getFeature().getEcoreFeature());
				if (extensibleFeature != null) {
					for(GenFeature cand : ((GenClass)genModel.findGenClassifier(extensibleFeature.getEContainingClass())).getAllGenFeatures()) {
						if (cand.getEcoreFeature().equals(extensibleFeature)) {
							EClass box = wrapperMap.get(extensibleFeature);

							if (box != null && terminal instanceof Placeholder) {
								Placeholder p = (Placeholder) terminal;
								terminal = ConcretesyntaxFactory.eINSTANCE.createContainment();
								EcoreUtil.replace(p, terminal);
								terminal.setCardinality(p.getCardinality());
								
								GenClass boxGenClass = (GenClass) genModel.findGenClassifier(box);
								if(!coveredBoxRules.contains(boxGenClass)) {
									p.setCardinality(null);
									Rule boxRule = ConcretesyntaxFactory.eINSTANCE.createRule();
									boxRule.setMetaclass(boxGenClass);
									Choice c = ConcretesyntaxFactory.eINSTANCE.createChoice();
									boxRule.getChildren().add(c);
									Sequence s = ConcretesyntaxFactory.eINSTANCE.createSequence();
									c.getOptions().add(s);
									p.setFeature(boxGenClass.getAllGenFeatures().get(0));
									s.getParts().add(p);
									
									newRules.add(boxRule);
									coveredBoxRules.add(boxGenClass);
								}
								
								addImport(cs, newImports, boxGenClass);
							}
							
							terminal.setFeature(cand);
						}
					}
				}
			}
		}
		
		cs.getRules().addAll(newRules);
		cs.getImports().addAll(newImports);
	}
	
	protected static void addImport(ConcreteSyntax cs, List<Import> imports, GenClass genClass) {
		for(Import anImport : imports) {
			if(anImport.getPackage().equals(genClass.getGenPackage())) {
				return;
			}
		}
		for(Import anImport : cs.getImports()) {
			if(anImport.getPackage().equals(genClass.getGenPackage())) {
				return;
			}
		}
		Import newImport = ConcretesyntaxFactory.eINSTANCE.createImport();
		newImport.setPackage(genClass.getGenPackage());
		newImport.setPrefix(
				genClass.getGenPackage().getEcorePackage().getESuperPackage().getName() + "_" +
				genClass.getGenPackage().getEcorePackage().getName());
		imports.add(newImport);
	}
	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ConcretesyntaxPackage.eNS_URI, ConcretesyntaxPackage.eINSTANCE);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"cs", new CsResourceFactory());
		
		rs = new ResourceSetImpl();
		File f;
		getMMPackage();
		getGenModel();
		getCS();
		
		addSFTypes();
		
		f= new File(CORE_METAMODEL_EXTENSIBLE);	
		getMMPackage().eResource().setURI(URI.createFileURI(f.getCanonicalPath().toString()));
		System.out.println(getMMPackage().eResource().getURI());

		f= new File(CORE_GENMODEL_EXTENSIBLE);	
		getGenModel().eResource().setURI(URI.createFileURI(f.getCanonicalPath().toString()));
		System.out.println(getGenModel().eResource().getURI());
		
		f = new File(CORE_CS_EXTENSIBLE);	
		getCS().setPackageLocationHint(getGenModel().eResource().getURI().lastSegment());
		getCS().eResource().setURI(URI.createFileURI(f.getCanonicalPath().toString()));
		System.out.println(getCS().eResource().getURI());
		
		getPTPackage().eResource().save(rs.getLoadOptions());
		getMMPackage().eResource().save(rs.getLoadOptions());
		getGenModel().eResource().save(rs.getLoadOptions());
		getCS().eResource().save(rs.getLoadOptions());
	}

}

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
package org.emftext.language.rolecore.dependencies.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.rolecore.RCPackage;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.SimpleTerm;
import org.emftext.language.rolecore.dependencies.interpreter.DomainRoot;
import org.emftext.language.rolecore.interfaces.InterfacesPackage;
import org.emftext.language.rolecore.interfaces.RCCore;

/**
 * @author BluAngel
 * 
 */
public class InterpretationContext {

	private RCPackage createdConstraintsModelPackage;
	private RCPackage creatingConstraintsModelPackage;
	// private Domain createdDomain;
	// private Domain creatingDomain;
	private List<Graph> dependencies;
	private Stack<Object> stack = new Stack<Object>();
	private int changeKind = -1;
	// TODO set resources according to the domain name, this may change in the
	// future.
	private List<DomainRoot> domainRoots = new ArrayList<DomainRoot>();
	private boolean isResourceChanged = false;
	// TODO is needed?
	private boolean isCreated;

	private static final String ABSTRACT_ROLE_CLASS_SUFFIX = "Role";
	private static final String CORE_CLASS_SUFFIX = "Core";
	private static final String TRACE_LINK_DOMAIN_ROOT_NAME = "TraceLinks";
	private CreatingHelpClass creatingHelpClass;
	private ChangingHelpClass changingHelpClass;
	private ResourceSet resourceSet;

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public void addResource(Resource resource) {
		EList<EObject> contents = resource.getContents();
		if (contents != null && contents.size() == 1 && contents.get(0) instanceof DomainRoot)
			domainRoots.add((DomainRoot) contents.get(0));
	}

	public InterpretationContext() {
		resourceSet = new ResourceSetImpl();
	}

	public Object pop() {
		return stack.pop();
	}

	public void push(Object object) {
		stack.push(object);
	}

	public List<Graph> getDependencies() {
		return dependencies;
	}

	/**
	 * TODO needed?
	 * 
	 * @return
	 */
	public RCPackage getConstraintsModelPackage(boolean isCreated) {
		if (isCreated)
			return createdConstraintsModelPackage;
		else
			return creatingConstraintsModelPackage;
	}

	public void setDependencies(List<Graph> dependencies) {
		this.dependencies = dependencies;
		for (Graph graph : dependencies) {
			EList<Domain> domains = graph.getModelDomains();
			for (Domain domain : domains) {
				findOrCreateDomainRoot(domain.getName());
				// TODO find a better way to load the RCPackage
				if (domain.getRcPackage().eIsProxy()) {
					String fragmentURI = EcoreUtil.getURI(domain.getRcPackage()).fragment();
					fragmentURI = fragmentURI.substring(fragmentURI.lastIndexOf("_") + 1);
					Resource resource = loadResource("../" + fragmentURI);
					if (resource != null && resource.getContents().get(0) instanceof RCPackage) {
						domain.setRcPackage((RCPackage) resource.getContents().get(0));
					}
				}
			}
		}

	}

	public DomainRoot findOrCreateDomainRoot(String domainName) {
		for (DomainRoot domainRoot : domainRoots) {
			if (domainName.equals(domainRoot.getName())) {
				return domainRoot;
			}
		}
		DomainRoot domainRoot = InterpreterPackage.eINSTANCE.getInterpreterFactory().createDomainRoot();
		// TODO remove
		System.out.println("Add domain root " + domainName);
		domainRoot.setName(domainName);
		domainRoots.add(domainRoot);
		return domainRoot;
	}

	public List<DomainRoot> getDomainRoots() {
		return domainRoots;
	}

	public DomainRoot findOrCreateTraceLinksDomainRoot() {
		return findOrCreateDomainRoot(TRACE_LINK_DOMAIN_ROOT_NAME);
	}

	/**
	 * Find the core class to synchronized. A base core class can be founded
	 * during synchronization
	 * 
	 * @param coreEClass
	 *            the core class to be created.
	 * @return the created EObject
	 */
	public EObject createCoreClass(EClass coreEClass) {
		return createSynchronizationCoreClass(coreEClass, null);
	}

	public EObject createSynchronizationCoreClass(CoreClass coreClass) {
		CreatingHelpClass creatingHelpClass = getCreatingHelpClass();
		EObject baseCore = null;
		if (creatingHelpClass != null) {
			baseCore = creatingHelpClass.getSharedBaseCore(coreClass);
		}
		// TODO remove
		if (baseCore != null) {
			System.out.println("Create " + coreClass.getName() + " with base core " + baseCore.eClass().getName());
		} else {
			System.out.println("Create " + coreClass.getName());
		}
		EObject coreEObject = createSynchronizationCoreClass(coreClass.getType(), baseCore);
		creatingHelpClass.addCoreEObjectToMap(coreClass.getName(), coreEObject);
		return coreEObject;
	}

	@SuppressWarnings("unchecked")
	private EObject createSynchronizationCoreClass(EClass coreEClass, EObject baseCore) {
		EFactory eFactory = coreEClass.getEPackage().getEFactoryInstance();
		if (!coreEClass.getName().endsWith(CORE_CLASS_SUFFIX))
			return null;
		// Create the core class
		EObject coreClass = eFactory.create(coreEClass);
		if (coreClass == null)
			return null;

		// determine the super core class and add itself to it as role
		EList<EClass> superEClasses = coreEClass.getESuperTypes();
		EClass superCoreEClass = null;
		for (EClass eClass : superEClasses) {
			if (eClass.getName().endsWith(CORE_CLASS_SUFFIX)) {
				superCoreEClass = eClass;
			}
		}
		if (!superCoreEClass.equals(InterfacesPackage.eINSTANCE.getRCCore())) {
			EObject superCoreClass = null;
			if (baseCore != null && baseCore.eClass().equals(superCoreEClass)) {
				superCoreClass = baseCore;
			} else {
				superCoreClass = createSynchronizationCoreClass(superCoreEClass, baseCore);
			}
			// set the core to the super core as role
			EStructuralFeature rolesStructuralFeature = getRolesStructuralFeature();
			EList<EObject> roles = (EList<EObject>) superCoreClass.eGet(rolesStructuralFeature);
			roles.add(coreClass);
			// set the super core class to the core class as core
			EStructuralFeature coreStructuralFeature = getCoreStructuralFeature();
			try {
				coreClass.eSet(coreStructuralFeature, superCoreClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return coreClass;
	}

	public EStructuralFeature getStructuralFeature(EClass eClass, String featureName) {
		if (eClass != null) {
			EList<EStructuralFeature> structuralFeatures = eClass.getEAllStructuralFeatures();
			for (EStructuralFeature structuralFeature : structuralFeatures) {
				if (structuralFeature.getName().equals(featureName))
					return structuralFeature;
			}
		}
		return null;
	}

	/**
	 * Get the structural feature of a role which points to its core.
	 * 
	 * @param roleEClass
	 * @return
	 */
	public EStructuralFeature getCoreStructuralFeature() {
		return InterfacesPackage.eINSTANCE.getRCRole_Core();
	}

	/**
	 * Get the structural feature of a core which points of its roles.
	 * 
	 * @param coreEClass
	 * @return
	 */
	public EStructuralFeature getRolesStructuralFeature() {
		return InterfacesPackage.eINSTANCE.getRCCore_Roles();
	}

	/**
	 * In a domain one core class can have only one root core class and one leaf
	 * core class. The root is needed to be added in a container, the leaf
	 * represent this object and is needed to be used.
	 * 
	 * @param coreClass
	 * @return the root core class
	 */
	public EObject getRootCore(EObject coreClass) {
		Object superCoreEObject = coreClass.eGet(getCoreStructuralFeature());
		if (superCoreEObject == null || !(superCoreEObject instanceof RCCore))
			return coreClass;
		return getRootCore((EObject) superCoreEObject);
	}

	/**
	 * In a domain one core class can have only one root core class and one leaf
	 * core class. The root is needed to be added in a container, the leaf
	 * represent this object and is needed to be used.
	 * 
	 * @param coreClass
	 * @return the leaf core class
	 */
	@SuppressWarnings("unchecked")
	public EObject getLeafCore(EObject coreClass) {
		EStructuralFeature rolesStructuralFeature = getRolesStructuralFeature();
		Object object = coreClass.eGet(rolesStructuralFeature);
		if (object instanceof EList<?>) {
			EList<EObject> roles = (EList<EObject>) object;
			for (EObject role : roles) {
				if (role instanceof RCCore) {
					return getLeafCore(role);
				}
			}
		}
		return coreClass;
	}

	public List<EObject> getSuperCores(EObject coreClass) {
		List<EObject> superCores = new ArrayList<EObject>();
		EStructuralFeature coreReference = getCoreStructuralFeature();
		Object superCore = coreClass;
		do {
			superCore = ((EObject) superCore).eGet(coreReference);
			if (superCore != null && superCore instanceof RCCore) {
				superCores.add((EObject) superCore);
			} else {
				superCore = null;
			}
		} while (superCore != null);
		return superCores;
	}

	@SuppressWarnings("unchecked")
	public boolean addRoleToCore(EObject coreEObject, EClass roleEClass, Object object, String featureName) {
		EFactory eFactory = roleEClass.getEPackage().getEFactoryInstance();
		EClass coreOfRoleEClass = (EClass) getCoreEClassOf(roleEClass);
		if (coreEObject.eClass().equals(coreOfRoleEClass)) {
			EObject roleClass = eFactory.create(roleEClass);
			EList<EObject> rolesList = (EList<EObject>) coreEObject.eGet(getRolesStructuralFeature());
			rolesList.add(roleClass);
			// add the core to its role
			try {
				roleClass.eSet(getCoreStructuralFeature(), coreEObject);
				if (featureName != null) {
					EStructuralFeature feature = getStructuralFeature(roleEClass, featureName);
					if (feature != null) {
						roleClass.eSet(feature, object);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} else {
			EObject superCore = getCoreEObjectOf(coreEObject);
			if (superCore == null) {
				return false;
			}
			return addRoleToCore(superCore, roleEClass, object, featureName);
		}
	}

	public boolean addRoleToCore(EObject coreEObject, EClass roleEClass, Object object) {
		String featureName = roleEClass.getEStructuralFeatures().get(0).getName();
		if (object instanceof EObject) {
			// TODO remove
			System.out.println("Added role " + roleEClass.getName() + " to the core "
					+ creatingHelpClass.getSynchronizationName(coreEObject) + " with the referred core "
					+ creatingHelpClass.getSynchronizationName((EObject) object));
		} else {
			// TODO remove
			System.out.println("Added role " + roleEClass.getName() + " to the core "
					+ creatingHelpClass.getSynchronizationName(coreEObject) + " with the value " + object.toString());
		}
		return addRoleToCore(coreEObject, roleEClass, object, featureName);
	}

	public EClass getCoreEClassOf(EClass role) {
		EList<EClass> superTypes = role.getESuperTypes();
		EClass abstractRole = null;
		for (EClass eClass : superTypes) {
			if (eClass.getName().endsWith(ABSTRACT_ROLE_CLASS_SUFFIX)) {
				abstractRole = eClass;
				break;
			}
		}
		if (abstractRole != null) {
			String interfaceName = abstractRole.getName().substring(0,
					abstractRole.getName().lastIndexOf(ABSTRACT_ROLE_CLASS_SUFFIX));
			EClass core = (EClass) role.getEPackage().getEClassifier(interfaceName + CORE_CLASS_SUFFIX);
			if (core != null)
				return core;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Resource saveResource(Object object, String fileURI) {
		// Resource resource =
		Resource resource = resourceSet.createResource(URI.createFileURI(fileURI));
		// add the root object to the resource
		if (object instanceof List<?>)
			for (EObject element : (List<EObject>) object) {
				resource.getContents().add(element);
			}
		else if (object != null)
			resource.getContents().add((EObject) object);
		// serialize resource – you can specify also serialization
		// options which defined on org.eclipse.emf.ecore.xmi.XMIResource
		try {
			resource.save(null);
			return resource;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void saveResource(Resource resource, String fileURI) {
		if (fileURI != null)
			resource.setURI(URI.createURI(fileURI));
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO remove because there is no resource!!
	public Resource loadResource(String fileURI) {
		System.out.print(URI.createURI(fileURI).toFileString() + ": ");
		try {
			Resource resource = resourceSet.getResource(URI.createURI(fileURI), true);
			System.out.println(resource);
			return resource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param changeKind
	 *            the changeKind to set ADD=0; REMOVE=1; CHANGE=2; else=-1
	 */
	public void setChangeKind(int changeKind) {
		this.changeKind = changeKind;
	}

	/**
	 * @return the changeKind
	 */
	public boolean isChangeKind(int kind) {
		return changeKind == kind;
	}

	/**
	 * @param isResourceChanged
	 *            the isResourceChanged to set
	 */
	public void setResourceChanged(boolean isResourceChanged) {
		this.isResourceChanged = isResourceChanged;
	}

	/**
	 * @return the isResourceChanged
	 */
	public boolean isResourceChanged() {
		return isResourceChanged;
	}

	/**
	 * @param creatingHelpClass
	 *            the creatingDependencies to set
	 */
	public void resetCreatingHelpClass(Graph dependencies) {
		this.creatingHelpClass = new CreatingHelpClass(dependencies, this);
	}

	/**
	 * @return the creatingDependencies
	 */
	public CreatingHelpClass getCreatingHelpClass() {
		return creatingHelpClass;
	}

	/**
	 * @param isCreated
	 *            the isCreated to set
	 */
	public void setCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}

	/**
	 * @return the isCreated
	 */
	public boolean isCreated() {
		return isCreated;
	}

	@SuppressWarnings("unchecked")
	public List<EObject> getRoleEObjects(EObject coreEObject, EClass role) {
		List<EObject> roleEObjects = new ArrayList<EObject>();
		EList<EObject> rolesOfCore = (EList<EObject>) coreEObject.eGet(getRolesStructuralFeature());
		for (EObject eObject : rolesOfCore) {
			if (eObject.eClass().equals(role))
				roleEObjects.add(eObject);
		}
		if (roleEObjects.size() == 0) {
			Object superCoreObject = coreEObject.eGet(getCoreStructuralFeature());
			if (superCoreObject != null && superCoreObject instanceof RCCore) {
				return getRoleEObjects((EObject) superCoreObject, role);
			} else
				return null;
		}
		return roleEObjects;
	}

	/**
	 * If the description has only one kind, the kind is set accordingly and
	 * return true, else return false.
	 * 
	 * @param changeDescription
	 * @return
	 */
	public boolean setChangeKind(ChangeDescription changeDescription) {
		int isCHANGE = 1;
		int isADD = 0;
		int isREMOVE = 0;
		for (EObject eObject : changeDescription.getObjectChanges().keySet()) {
			EList<FeatureChange> featureChanges = changeDescription.getObjectChanges().get(eObject);
			for (FeatureChange featureChange : featureChanges) {
				EList<ListChange> listChanges = featureChange.getListChanges();
				if (listChanges != null && listChanges.size() > 0) {
					isCHANGE = 0;
					for (ListChange listChange : listChanges) {
						if (listChange.getKind().equals(ChangeKind.ADD_LITERAL)) {
							isADD = 2;
							isCHANGE = 0;
						} else if (listChange.getKind().equals(ChangeKind.REMOVE_LITERAL))
							isREMOVE = 4;
						if (isADD + isREMOVE == 6)
							break;
					}
					if (isADD + isREMOVE == 6)
						break;
				}
				if (isADD + isREMOVE == 6)
					break;
			}
		}
		switch (isCHANGE + isADD + isREMOVE) {
		case 1:
			setChangeKind(ChangeKind.MOVE);
			return true;
		case 2:
			setChangeKind(ChangeKind.ADD);
			return true;
		case 4:
			setChangeKind(ChangeKind.REMOVE);
			return true;
		default:
			return false;
		}
	}

	public boolean isAssignment(Edge edge) {
		if (edge.getRightTerm().getOperation() != null) {
			return true;
		}
		EList<SimpleTerm> simpleTerms = edge.getRightTerm().getSimpleTerms();
		EClass rightRole = edge.getSimpleTerm().getRole();
		if (rightRole != null && simpleTerms.size() == 1) {
			EClass leftRole = simpleTerms.get(0).getRole();
			if (leftRole != null && !rightRole.equals(leftRole)) {
				return true;
			}
		}
		return false;
	}

	public EObject getCoreEObjectOf(EObject role) {
		Object coreObject = role.eGet(getCoreStructuralFeature());
		if (coreObject != null && coreObject instanceof RCCore) {
			return (EObject) coreObject;
		}
		return null;
	}

	public void addEqualTraceLink(EObject sourceEObject, EObject targetEObject) {
		DomainRoot traceLinksDR = findOrCreateTraceLinksDomainRoot();
		for (EObject eObject : traceLinksDR.getEObjects()) {
			if (eObject instanceof EqualTraceLink) {
				EqualTraceLink equalTraceLink = (EqualTraceLink) eObject;
				if ((equalTraceLink.getSource().equals(sourceEObject) && equalTraceLink.getTarget().equals(
						targetEObject))
						|| (equalTraceLink.getSource().equals(targetEObject) && equalTraceLink.getTarget().equals(
								sourceEObject))) {
					return;
				}
			}
		}
		EqualTraceLink traceLink = InterpreterFactory.eINSTANCE.createEqualTraceLink();
		traceLink.setSource(sourceEObject);
		traceLink.setTarget(targetEObject);
		traceLinksDR.getEObjects().add(traceLink);
		// TODO remove
		System.out.println("Set trace link with source " + sourceEObject.eClass().getName() + " and target "
				+ targetEObject.eClass().getName());

	}
	
	public void addAssignmentTraceLink(AssignmentTraceLink assignmentTraceLink){
		DomainRoot traceLinksDR = findOrCreateTraceLinksDomainRoot();
		traceLinksDR.getEObjects().add(assignmentTraceLink);
		// TODO remove
		Edge edge = (Edge)assignmentTraceLink.getEdge();
		System.out.println("Set assignment trace link for core class " + edge.getSimpleTerm().getCoreClass().getName() + " and role "
				+ edge.getSimpleTerm().getRole().getName());
	}

	@SuppressWarnings("unchecked")
	public void addEObjectsWithoutContainer(EObject coreEObject, Set<EObject> eObjects) {
		if (coreEObject == null || !(coreEObject instanceof RCCore)) {
			return;
		}
		if (coreEObject.eContainer() == null) {
			eObjects.add(coreEObject);
		}
		EList<EObject> roleEObjects = (EList<EObject>) coreEObject.eGet(getRolesStructuralFeature());
		for (EObject roleEObject : roleEObjects) {
			if (roleEObject.eContainer() == null && !(roleEObject instanceof RCCore)) {
				eObjects.add(roleEObject);
			}
		}
		Object superCoreEObject = coreEObject.eGet(getCoreStructuralFeature());
		if (superCoreEObject != null && superCoreEObject instanceof RCCore) {
			addEObjectsWithoutContainer((EObject) superCoreEObject, eObjects);
		}
	}

	public void resetChangingHelpClass() {
		changingHelpClass = new ChangingHelpClass(this);
	}
	
	public ChangingHelpClass getChangingHelpClass(){
		return changingHelpClass;
	}

}

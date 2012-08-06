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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.emftext.language.rolecore.dependencies.Block;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Create;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Required;
import org.emftext.language.rolecore.dependencies.RightTerm;
import org.emftext.language.rolecore.dependencies.SimpleTerm;
import org.emftext.language.rolecore.interfaces.RCCore;

public class CreatingHelpClass {

	private HashMap<String, EObject> coreClassesMap;
	private Graph dependencies;
	private List<CoreClass> listOfCoreClassesToInterpret;
	private EMap<EObject, CoreClass> mapOfNextElements;
	private Map<EObject, List<FeatureChange>> mapOfObjectsToChange;
	private InterpretationContext context;

	public CreatingHelpClass(Graph dependencies, InterpretationContext context) {
		this.dependencies = dependencies;
		coreClassesMap = new HashMap<String, EObject>();
		mapOfNextElements = new BasicEMap<EObject, CoreClass>(10);
		listOfCoreClassesToInterpret = new ArrayList<CoreClass>();
		this.context = context;
	}

	public List<CoreClass> getListOfCoreClassesToInterpret() {
		return listOfCoreClassesToInterpret;
	}

	private void addCoreClassesToList(Block block, List<CoreClass> coreClassList) {
		if (block != null && block.getCoreClasses() != null)
			for (CoreClass coreClass : block.getCoreClasses()) {
				coreClassList.add(coreClass);
			}
	}

	public void addCoreEObjectToMap(String coreClassName, EObject coreEObject) {
		// TODO remove
		System.out.println("Add the core class " + coreClassName + " to core classes map");
		coreClassesMap.put(coreClassName, context.getLeafCore(coreEObject));
	}

	public boolean addNextElementsFromRequired(Domain domain, Entry<EObject, EList<FeatureChange>> entry) {
		if (mapOfObjectsToChange.size() == 0)
			return false;
		CoreClass coreClass = getCoreClassFromBlock(entry.getKey().eClass(), domain.getRequired());
		if (coreClass != null) {
			mapOfNextElements.put(entry.getKey(), coreClass);
			addCoreEObjectToMap(coreClass.getName(), entry.getKey());
			return true;
		}
		return false;
	}

	/**
	 * The first element is in Create or SemiCreate because of domain root. If
	 * it is a containment reference then it is in Create. Now assume it is in
	 * Create first.
	 * 
	 * @param featureChanges
	 */
	public boolean addNextElementsFromRoot(List<FeatureChange> featureChanges, Domain domain) {
		// TODO should be applied these feature changes here?
		if (featureChanges == null)
			return false;
		for (FeatureChange featureChange : featureChanges) {
			EList<ListChange> listChanges = featureChange.getListChanges();
			for (ListChange listChange : listChanges) {
				if (listChange.getKind().equals(ChangeKind.ADD_LITERAL)) {
					EList<EObject> coreClassEObjects = listChange.getReferenceValues();
					for (EObject eObject : coreClassEObjects) {
						CoreClass coreClass = getCoreClassFromBlock(eObject.eClass(), domain.getCreate());
						if (coreClass == null) {
							coreClass = getCoreClassFromBlock(eObject.eClass(), domain.getSemiRequired());
						}
						if (coreClass != null) {
							mapOfNextElements.put(eObject, coreClass);
							// TODO map to the coreClassesMap too, but this map
							// should contains only correct mappings
							addCoreEObjectToMap(coreClass.getName(), eObject);
						} else
							return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Create the synchronized core classes of the given core class if they are
	 * not existed yet. This method will not do yet!
	 * 
	 * @param coreClass
	 *            with the created core class EObject
	 * @param context
	 */
	public void createSynchronizationCoreClasses(CoreClass coreClass) {
		Set<CoreClass> synchCoreClasses = getSynchronizedCoreClasses(coreClass);
		if (synchCoreClasses != null && synchCoreClasses.size() > 0) {
			for (CoreClass synchCoreClass : synchCoreClasses) {
				EObject synchCoreClassEObject = getCoreEObjectFromMap(synchCoreClass.getName());
				if (synchCoreClassEObject == null) {
					// TODO this create have to create the super cores, too
					synchCoreClassEObject = synchCoreClass.getType().getEPackage().getEFactoryInstance().create(
							synchCoreClass.getType());
					addCoreEObjectToMap(synchCoreClass.getName(), synchCoreClassEObject);
				}
			}
		}
	}

	private CoreClass getCoreClassFromBlock(EClass eClass, Block block) {
		if (block != null && block.getCoreClasses() != null && block.getCoreClasses().size() > 0)
			for (CoreClass coreClass : block.getCoreClasses()) {
				if (eClass.equals(coreClass.getType()) || eClass.getEAllSuperTypes().contains(coreClass.getType()))
					return coreClass;
			}
		return null;
	}

	public Graph getDependencies() {
		return dependencies;
	}

	public CoreClass getDependenciesCoreClass(String synchronizationName) {
		CoreClass coreClass = null;
		for (Domain domain : dependencies.getModelDomains()) {
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getRequired());
			if (coreClass != null)
				return coreClass;
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getSemiRequired());
			if (coreClass != null)
				return coreClass;
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getCreate());
			if (coreClass != null)
				return coreClass;
		}

		return null;
	}

	public CoreClass getDependenciesCoreClassFromBlock(String synchronizationName, Block block) {
		for (CoreClass coreClass : block.getCoreClasses()) {
			if (coreClass.getName().equals(synchronizationName))
				return coreClass;
		}
		return null;
	}

	public EObject getCoreEObjectFromMap(String coreClassName) {
		return coreClassesMap.get(coreClassName);
	}

	public Map<EObject, List<FeatureChange>> getListOfObjectsToChange() {
		return mapOfObjectsToChange;
	}

	public EMap<EObject, CoreClass> getMapOfNextElements() {
		return mapOfNextElements;
	}

	/**
	 * Assume there is only one core class synchronization.
	 * 
	 * @param coreClass
	 * @param context
	 * @return
	 */
	private Set<CoreClass> getSynchronizedCoreClasses(CoreClass coreClass) {
		EList<Edge> edges = dependencies.getModelEquivalence().getEdges();
		Set<CoreClass> synchCoreClasses = new HashSet<CoreClass>();
		for (Edge edge : edges) {
			SimpleTerm simpleTerm = edge.getSimpleTerm();
			RightTerm rightTerm = edge.getRightTerm();
			// if the core class in left term and there is no role, so it is a
			// synchronization,
			// else look the right term
			if (coreClass.getName().equals(simpleTerm.getCoreClass().getName()) && simpleTerm.getRole() == null) {
				for (SimpleTerm rightSimpleTerm : edge.getRightTerm().getSimpleTerms()) {
					synchCoreClasses.add(rightSimpleTerm.getCoreClass());
				}
				return synchCoreClasses;
			} else {
				for (SimpleTerm rightSimpleTerm : rightTerm.getSimpleTerms()) {
					if (coreClass.getName().equals(rightSimpleTerm.getCoreClass().getName())
							&& rightSimpleTerm.getRole() == null) {
						synchCoreClasses.add(simpleTerm.getCoreClass());
						return synchCoreClasses;
					}
				}
			}
		}
		return synchCoreClasses;
	}

	public String getSynchronizationName(EObject eObject) {
		for (Iterator<String> synchronizationNames = coreClassesMap.keySet().iterator(); synchronizationNames.hasNext();) {
			String synchronizationName = synchronizationNames.next();
			if (coreClassesMap.get(synchronizationName).equals(eObject))
				return synchronizationName;
		}
		return null;
	}

	/**
	 * Is this EObject in contained in the list already?
	 * 
	 * @param eObject
	 * @return
	 */
	public boolean hasEObjectCoreClass(EObject eObject) {
		for (Iterator<String> synchronizationNames = coreClassesMap.keySet().iterator(); synchronizationNames.hasNext();) {
			if (coreClassesMap.get(synchronizationNames).equals(eObject))
				return true;
		}
		return false;
	}

	// public List<CoreClass> getListOfCoreClassesToInterpret(){
	// return listOfCoreClassesToInterpret;
	// }
	/**
	 * 
	 */
	public Entry<EObject, CoreClass> popNextElement() {
		if (mapOfNextElements.size() == 0)
			return null;
		return mapOfNextElements.remove(0);
	}

	public boolean pushNextElement(EObject key, CoreClass value) {
		if (coreClassesMap.containsValue(key))
			return false;
		mapOfNextElements.put(key, value);
		return true;
	}

	public void removeFeatureChangesOf(EObject eObject, List<FeatureChange> newFeatureChanges, Boolean isCore) {
		List<FeatureChange> featureChanges = mapOfObjectsToChange.remove(eObject);
		if (featureChanges != null) {
			for (FeatureChange featureChange : featureChanges) {
				newFeatureChanges.add(featureChange);
			}
		}
		if (isCore) {
			// if eObject is a core class there more feature changes of the
			// super core class
			// TODO catch the exception
			Object superCoreClass = null;
			try {
				superCoreClass = eObject.eGet(context.getCoreStructuralFeature());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(eObject);
				System.out.println(superCoreClass);
				return;
			}
			if (superCoreClass != null && superCoreClass instanceof RCCore) {
				removeFeatureChangesOf((EObject) superCoreClass, newFeatureChanges, isCore);
			}
		}
	}

	public void setListsAndMaps(EMap<EObject, EList<FeatureChange>> objectChanges, Domain domain) {
		// objectChanges.getKey() is not enough, because the same key can exist
		// more than once and only the first is returned
		mapOfObjectsToChange = new HashMap<EObject, List<FeatureChange>>();
		for (Entry<EObject, EList<FeatureChange>> entry : objectChanges) {
			List<FeatureChange> fcList = mapOfObjectsToChange.get(entry.getKey());
			if (fcList == null) {
				fcList = new ArrayList<FeatureChange>();
				mapOfObjectsToChange.put(entry.getKey(), fcList);
			}
			for (FeatureChange featureChange : entry.getValue()) {
				fcList.add(featureChange);
			}
		}
		listOfCoreClassesToInterpret = getAllCoreClasses(domain);
	}

	private List<CoreClass> getAllCoreClasses(Domain domain) {
		List<CoreClass> coreClassList = new ArrayList<CoreClass>();
		addCoreClassesToList(domain.getRequired(), coreClassList);
		addCoreClassesToList(domain.getCreate(), coreClassList);
		addCoreClassesToList(domain.getSemiRequired(), coreClassList);
		return coreClassList;
	}

	/**
	 * The next element can be added if the
	 * <code>listOfCoreClassesToInterpret</code> contains it. Interpreted
	 * elements can not be interpret again.
	 * 
	 * @param coreClass
	 * @param nextEObject
	 */
	public void addNextElement(CoreClass coreClass, EObject nextEObject) {
		if (listOfCoreClassesToInterpret.contains(coreClass)) {
			mapOfNextElements.put(nextEObject, coreClass);
			addCoreEObjectToMap(coreClass.getName(), nextEObject);
		}
	}

	public void showInfo() {
		System.out.println("\nMapping in the dependencies");
		for (Iterator<String> it = coreClassesMap.keySet().iterator(); it.hasNext();) {
			String coreClassName = it.next();
			System.out.println(coreClassName + " is mapped to " + coreClassesMap.get(coreClassName).eClass().getName());
		}

	}

	public EObject getSharedBaseCore(CoreClass coreClass) {
		Set<CoreClass> coreClasses = getSynchronizedCoreClassesWithSharedRole(coreClass);
		if (coreClasses == null) {
			return null;
		}
		// find the first core class with the common base core
		EList<EClass> superTypes = coreClass.getType().getEAllSuperTypes();
		for (CoreClass synchCoreClass : coreClasses) {
			EObject synchCoreEObject = coreClassesMap.get(synchCoreClass.getName());
			if (synchCoreEObject != null) {
				List<EObject> superCores = context.getSuperCores(coreClassesMap.get(synchCoreClass.getName()));
				for (EObject superCore : superCores) {
					for (EClass superType : superTypes) {
						if (superCore.eClass().equals(superType)) {
							return superCore;
						}
					}
				}
			}
		}
		return null;
	}

	private Set<CoreClass> getSynchronizedCoreClassesWithSharedRole(CoreClass coreClass) {
		if (dependencies.getModelEquivalence() == null) {
			return null;
		}
		Set<CoreClass> coreClasses = new HashSet<CoreClass>();
		EList<Edge> edges = dependencies.getModelEquivalence().getEdges();
		for (Edge edge : edges) {
			if (edge.getSimpleTerm().getRole() != null) {
				EList<SimpleTerm> simpleTerms = edge.getRightTerm().getSimpleTerms();
				if (simpleTerms != null && simpleTerms.size() == 1) {
					SimpleTerm simpleTerm = simpleTerms.get(0);
					if (simpleTerm.getRole().equals(edge.getSimpleTerm().getRole())) {
						if (edge.getSimpleTerm().getCoreClass().equals(coreClass)) {
							coreClasses.add(simpleTerm.getCoreClass());
						} else if (simpleTerm.getCoreClass().equals(coreClass)) {
							coreClasses.add(edge.getSimpleTerm().getCoreClass());
						}
					}
				}
			}
		}
		return coreClasses;
	}

	public boolean handleRequiredCoreClass(CoreClass coreClass, Domain domain) {
		Set<CoreClass> synchCoreClasses = getSynchronizedCoreClasses(coreClass);
		EObject coreEObject = null;
		if (synchCoreClasses.size() > 0) {
			// search for existed core class
			for (CoreClass synchCoreClass : synchCoreClasses) {
				// search in the trace links, if it is available it is already
				// in the domain root
				coreEObject = searchInTheTraceLinks(coreClass, coreClassesMap.get(synchCoreClass.getName()));
				if (coreEObject != null) {
					break;
				}
			}
			if (coreEObject == null) {
				// it is not available in the trace links, search in the domain
				// root with the single valued conditions
				coreEObject = findOrCreateCoreClass(coreClass, domain);
				for (CoreClass synchCoreClass : synchCoreClasses) {
					context.addEqualTraceLink(coreEObject, coreClassesMap.get(synchCoreClass.getName()));
				}
			}
		} else {
			coreEObject = findOrCreateCoreClass(coreClass, domain);
		}
		if (coreEObject != null) {
			addCoreEObjectToMap(coreClass.getName(), coreEObject);
			return true;
		}
		return false;
	}

	private EObject searchInTheTraceLinks(CoreClass coreClass, EObject synchEObject) {
		DomainRoot traceLinksDR = context.findOrCreateTraceLinksDomainRoot();
		if (traceLinksDR.getEObjects() != null) {
			for (EObject link : traceLinksDR.getEObjects()) {
				if (link instanceof EqualTraceLink) {
					EqualTraceLink equalTL = (EqualTraceLink) link;
					EObject coreEObject = null;
					EObject sourceEObject = equalTL.getSource();
					EObject targetEOject = equalTL.getTarget();
					if (sourceEObject.equals(synchEObject) && targetEOject.eClass().equals(coreClass.getType())) {
						coreEObject = targetEOject;
					}
					if (targetEOject.equals(synchEObject) && sourceEObject.eClass().equals(coreClass.getType())) {
						coreEObject = sourceEObject;
					}
					// validate the constraints
					if (coreEObject != null && isValid(coreEObject, coreClass)) {
						// TODO remove
						System.out.println("Found " + coreClass.getName() + " in the trace links");
						return coreEObject;
					}
				}
			}
		}
		return null;
	}

	private boolean isValid(EObject coreEObject, CoreClass coreClass) {
		// check only single valued attribute
		EList<Edge> edges = coreClass.getEdges();
		for (Edge edge : edges) {
			if (edge.getRightTerm().getValue() != null) {
				boolean validEdge = false;
				EClass role = edge.getSimpleTerm().getRole();
				if (role.getEAttributes().size() == 1) {
					List<EObject> roleList = context.getRoleEObjects(coreEObject, role);
					// TODO extend the rolecore model the cardinality for roles
					if (roleList.size() == 1) {
						EObject roleEObject = roleList.get(0);
						EAttribute attrib = role.getEAttributes().get(0);
						Object data = roleEObject.eGet(attrib);
						// TODO check only on String for now
						if (data instanceof String && data.equals(edge.getRightTerm().getValue())) {
							validEdge = true;
							break;
						}
					}
				}
				if (!validEdge) {
					return false;
				}
			}
		}
		return true;
	}

	// TODO fit the sub types, too
	private EObject findOrCreateCoreClass(CoreClass coreClass, Domain domain) {
		DomainRoot domainRoot = context.findOrCreateDomainRoot(domain.getName());
		if (domainRoot.getEObjects() != null) {
			for (EObject eObject : domainRoot.getEObjects()) {
				if (coreClass.getType().equals(eObject.eClass()) && isValid(eObject, coreClass)) {
					System.out.println("Found " + eObject.eClass().getName() + " in domain root "
							+ domainRoot.getName());
					return eObject;
				}
			}
		}
		if (coreClass.eContainer() instanceof Required) {
			return null;
		}
		// TODO is it possible to add this class to the domain root right here?
		EObject coreEObject = context.createCoreClass(coreClass.getType());
		System.out.println("Create " + coreEObject.eClass().getName());
		// after creating the single valued attributes have to be set. Only data
		// attribute for now
		for (Edge edge : coreClass.getEdges()) {
			if (edge.isEqual()) {
				EClass roleEClass = edge.getSimpleTerm().getRole();
				String featureName = roleEClass.getEAttributes().get(0).getName();
				context.addRoleToCore(coreEObject, roleEClass, edge.getRightTerm().getValue(), featureName);
				// TODO remove
				System.out.println("The role " + roleEClass.getName() + " is added to the semi required core class "
						+ coreClass.getName() + " with the value \"" + edge.getRightTerm().getValue() + "\"");
			}
		}
		return coreEObject;
	}

	public void setAttributesAndCreateReferences(Domain domain) {
		List<CoreClass> coreClassList = new ArrayList<CoreClass>();
		addCoreClassesToList(domain.getRequired(), coreClassList);
		addCoreClassesToList(domain.getSemiRequired(), coreClassList);
		addCoreClassesToList(domain.getCreate(), coreClassList);
		for (CoreClass coreClass : coreClassList) {
			EObject coreEObject = coreClassesMap.get(coreClass.getName());
			List<Edge> edges = new ArrayList<Edge>();
			if (coreClass.eContainer() instanceof Create) {
				addImplicitEdges(coreClass, edges);
			}
			for (Edge edge : coreClass.getEdges()) {
				edges.add(edge);
			}
			for (Edge edge : edges) {
				EClass roleEClass = edge.getSimpleTerm().getRole();
				if (isMany(coreEObject.eClass(), roleEClass, domain)) {
					addDataToRole(coreEObject, roleEClass, edge);
				} else if (coreClass.eContainer() instanceof Create) {
					if (!isAssignmentTraceLink(coreClass, roleEClass)) {
						addDataToRole(coreEObject, roleEClass, edge);
					} else {
						setAttributeInTraceLink(coreClass, edge);
					}
				}
			}
			// add roles of indirect trace links
		}
	}

	private void setAttributeInTraceLink(CoreClass coreClass, Edge edge) {
		EClass roleEClass = edge.getSimpleTerm().getRole();
		if (coreClass.equals(edge.getSimpleTerm().getCoreClass()) && roleEClass.equals(edge.getSimpleTerm().getRole())) {
			EObject coreEObject = coreClassesMap.get(coreClass.getName());
			if (!existRoleEObject(coreEObject, roleEClass)) {
				context.addRoleToCore(coreEObject, roleEClass, evaluateRightTerm(edge.getRightTerm()));
				return;
			}
		}
		for (Edge traceLinkEdge : dependencies.getModelEquivalence().getEdges()) {
			if (traceLinkEdge.getSimpleTerm().getRole() != null) {
				EObject leftCoreEObject = coreClassesMap.get(traceLinkEdge.getSimpleTerm().getCoreClass().getName());
				EObject leftRoleEObject = context.getRoleEObjects(leftCoreEObject,
						traceLinkEdge.getSimpleTerm().getRole()).get(0);
				EObject rightCoreEObject = coreClassesMap.get(coreClass.getName());
				// not the same base
				List<EObject> rightRoleEObjects = context.getRoleEObjects(rightCoreEObject, traceLinkEdge
						.getSimpleTerm().getRole());
				if (rightRoleEObjects == null || rightRoleEObjects.size() == 1
						&& !rightRoleEObjects.get(0).equals(leftRoleEObject)) {
					addDataToCoreClassInRightTerm(leftRoleEObject, coreClass, roleEClass, traceLinkEdge.getRightTerm());
				}
			}
		}
	}

	public void addRoleToAssignmentTraceLink(String coreClassName, EObject roleEObject,
			AssignmentTraceLink assignmentTraceLink) {
		EList<EObject> roles = assignmentTraceLink.getCoreNameToRolesMap().get(coreClassName);
		if (roles == null) {
			Entry<String, EList<EObject>> entry = InterpreterFactory.eINSTANCE
					.createEObjectToChangesMapEntry(coreClassName);
			roles = entry.getValue();
			assignmentTraceLink.getCoreNameToRolesMap().add(entry);
		}
		if (!roles.contains(roleEObject)) {
			roles.add(roleEObject);
		}
	}

	private boolean existRoleEObject(EObject coreEObject, EClass role) {
		List<EObject> roleEObjects = context.getRoleEObjects(coreEObject, role);
		if (roleEObjects != null && roleEObjects.size() > 0) {
			return true;
		}
		return false;
	}

	private boolean addDataToCoreClassInRightTerm(EObject leftRoleEObject, CoreClass rightCoreClass,
			EClass rightRoleEClass, RightTerm rightTerm) {
		EList<SimpleTerm> simpleTerms = rightTerm.getSimpleTerms();
		if (simpleTerms != null && simpleTerms.size() == 1 && rightCoreClass.equals(simpleTerms.get(0).getCoreClass())
				&& rightRoleEClass.equals(simpleTerms.get(0).getRole())) {
			EList<EAttribute> attributes = leftRoleEObject.eClass().getEAttributes();
			if (attributes != null && attributes.size() > 0) {
				EClassifier attributeType = attributes.get(0).getEAttributeType();
				EList<EAttribute> rightRoleAttributes = rightRoleEClass.getEAttributes();
				if (rightRoleAttributes != null && rightRoleAttributes.size() > 0
						&& attributeType.equals(rightRoleAttributes.get(0).getEAttributeType())) {
					context.addRoleToCore(coreClassesMap.get(rightCoreClass.getName()), rightRoleEClass, getRoleData(
							leftRoleEObject, null));
					return true;
				}
			}
		}
		if (rightTerm.getOperation() != null) {
			for (RightTerm rightTermInOperation : rightTerm.getOperation().getRightTerms()) {
				if (addDataToCoreClassInRightTerm(leftRoleEObject, rightCoreClass, rightRoleEClass,
						rightTermInOperation)) {
					return true;
				}
			}
		}
		return false;
	}

	private Object evaluateRightTerm(RightTerm rightTerm) {
		if (rightTerm.getValue() != null) {
			return rightTerm.getValue();
		}
		if (rightTerm.getOperation() != null && rightTerm.getOperation().getOperationType().equals("+")) {
			String result = "";
			for (RightTerm rightTermInList : rightTerm.getOperation().getRightTerms()) {
				Object rightTermResult = evaluateRightTerm(rightTermInList);
				if (rightTermResult instanceof String) {
					result += rightTermResult.toString();
				}
			}
			return result;
		}
		EList<SimpleTerm> simpleTerms = rightTerm.getSimpleTerms();
		if (simpleTerms != null && simpleTerms.size() > 0) {
			String result = "";
			for (SimpleTerm simpleTerm : simpleTerms) {
				EObject coreEObject = coreClassesMap.get(simpleTerm.getCoreClass().getName());
				List<EObject> roleEObjects = context.getRoleEObjects(coreEObject, simpleTerm.getRole());
				if (roleEObjects != null & roleEObjects.size() == 1) {
					Object data = getRoleData(roleEObjects.get(0), null);
					if (data instanceof String) {
						result += data.toString();
					}
				}
			}
			return result;
		}
		return null;
	}

	private void addDataToRole(EObject coreEObject, EClass roleEClass, Edge edge) {
		if (edge.isReferredTo()) {
			String referredCoreName = edge.getRightTerm().getSimpleTerms().get(0).getCoreClass().getName();
			EObject referredCore = coreClassesMap.get(referredCoreName);
			context.addRoleToCore(coreEObject, roleEClass, referredCore);
		}
		if (edge.isEqual()) {
			context.addRoleToCore(coreEObject, roleEClass, edge.getRightTerm().getValue());
		}
	}

	private boolean isAssignmentTraceLink(CoreClass coreClass, EClass roleEClass) {
		if (dependencies.getModelEquivalence() == null || dependencies.getModelEquivalence().getEdges().size() == 0) {
			return false;
		}
		for (Edge edge : dependencies.getModelEquivalence().getEdges()) {
			if (edge.isEqual()) {
				if (edge.getSimpleTerm().getRole() != null && edge.getSimpleTerm().getRole().equals(roleEClass)
						&& edge.getSimpleTerm().getCoreClass().equals(coreClass)) {
					return true;
				}
				if (isInRightTerm(coreClass, roleEClass, edge.getRightTerm())) {
					return true;
				}

			}
		}
		return false;
	}

	private boolean isInRightTerm(CoreClass coreClass, EClass roleEClass, RightTerm rightTerm) {
		if (rightTerm.getSimpleTerms() != null) {
			for (SimpleTerm simpleTerm : rightTerm.getSimpleTerms()) {
				if (simpleTerm.getRole() != null && (simpleTerm.getRole().equals(roleEClass) || roleEClass == null)
						&& simpleTerm.getCoreClass().equals(coreClass)) {
					return true;
				}
			}
		}
		if (rightTerm.getOperation() != null) {
			for (RightTerm rightTermInOperation : rightTerm.getOperation().getRightTerms()) {
				if (isInRightTerm(coreClass, roleEClass, rightTermInOperation)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isMany(EClass coreEClass, EClass roleEClass, Domain domain) {
		// assumed every role has only one direct structural feature
		String featureName = roleEClass.getEStructuralFeatures().get(0).getName();
		String interfaceName = coreEClass.getName().substring(0, coreEClass.getName().lastIndexOf("Core"));
		EClass rcCore = null;
		for (EClass core : domain.getRcPackage().getCoreClasses()) {
			if (core.getName().equals(interfaceName)) {
				rcCore = core;
				break;
			}
		}
		if (rcCore == null) {
			return false;
		}
		EStructuralFeature feature = rcCore.getEStructuralFeature(featureName);
		if (feature == null) {
			// TODO this role is not a reference role, therefore look up the
			// cardinality of the role, which is not supported right now
			return false;
		}
		return feature.isMany();
	}

	/**
	 * Get data of the role. If referenceType is <code>null</code> the role will
	 * return its attribute.
	 * 
	 * @param roleEObject
	 * @param referencedType
	 * @return
	 */
	private Object getRoleData(EObject roleEObject, EClass referencedType) {
		if (referencedType != null) {
			EList<EReference> references = roleEObject.eClass().getEReferences();
			for (EReference eReference : references) {
				if (!eReference.equals(context.getCoreStructuralFeature())
						&& eReference.getEType().equals(referencedType)) {
					return roleEObject.eGet(eReference);
				}
			}
		} else {
			EAttribute attrib = roleEObject.eClass().getEAttributes().get(0);
			return roleEObject.eGet(attrib);
		}
		return null;
	}

	public void addObjectsToRootDomain(Domain domain) {
		Set<EObject> eObjectSet = new HashSet<EObject>();
		DomainRoot domainRoot = context.findOrCreateDomainRoot(domain.getName());
		String modelPrefix = domain.getModelPackage().getNsPrefix();
		List<CoreClass> coreClassList = getAllCoreClasses(domain);
		for (CoreClass coreClass : coreClassList) {
			context.addEObjectsWithoutContainer(coreClassesMap.get(coreClass.getName()), eObjectSet);
		}
		for (EObject eObject : eObjectSet) {
			String nsPrefix = eObject.eClass().getEPackage().getNsPrefix();
			if (modelPrefix.equals(nsPrefix)) {
				domainRoot.getEObjects().add(eObject);
				// TODO remove
				// System.out.println("Add " + eObject.eClass().getName() +
				// " to domain root " + domain.getName());
			} else {
				context.findOrCreateDomainRoot(nsPrefix).getEObjects().add(eObject);
				// TODO remove
				// System.out.println("Add " + eObject.eClass().getName() +
				// " to domain root " + nsPrefix);
			}
		}
	}

	public void addImplicitEdges(CoreClass coreClass, List<Edge> edgesToInterpret) {
		if (dependencies.getModelEquivalence() != null && dependencies.getModelEquivalence().getEdges().size() > 0) {
			for (Edge edge : dependencies.getModelEquivalence().getEdges()) {
				SimpleTerm simpleTerm = edge.getSimpleTerm();
				if (simpleTerm.getCoreClass().equals(coreClass) && simpleTerm.getRole() != null) {
					edgesToInterpret.add(edge);
				}
			}
		}
	}

	public void addRoleToAssignmentTraceLinkInRightTerm(RightTerm rightTerm, AssignmentTraceLink assignmentTraceLink) {
		if (rightTerm.getSimpleTerms() != null) {
			for (SimpleTerm simpleTerm : rightTerm.getSimpleTerms()) {
				EObject coreEObject = coreClassesMap.get(simpleTerm.getCoreClass().getName());
				EObject roleEObject = context.getRoleEObjects(coreEObject, simpleTerm.getRole()).get(0);
				addRoleToAssignmentTraceLink(simpleTerm.getCoreClass().getName(), roleEObject, assignmentTraceLink);
			}
		}
		if (rightTerm.getOperation() != null){
			for (RightTerm rightTermInOperation : rightTerm.getOperation().getRightTerms()) {
				addRoleToAssignmentTraceLinkInRightTerm(rightTermInOperation, assignmentTraceLink);
			}
		}
	}
}

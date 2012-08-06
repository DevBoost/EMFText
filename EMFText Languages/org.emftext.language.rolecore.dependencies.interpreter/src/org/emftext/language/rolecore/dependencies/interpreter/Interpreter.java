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
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.rolecore.dependencies.Block;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Equivalence;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.RightTerm;
import org.emftext.language.rolecore.dependencies.SimpleTerm;
import org.emftext.language.rolecore.dependencies.resource.dependencies.util.AbstractDependenciesInterpreter;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.util.*;
import org.eclipse.emf.ecore.resource.Resource;

public class Interpreter extends AbstractDependenciesInterpreter<Boolean, InterpretationContext> {

	private ChangeRecorder changeRecorder;

	/**
	 * This method gets a change description about an applied feature change. A
	 * resource change is not considered yet. There are three kinds of object
	 * changes:
	 * <ul>
	 * <li><b>Add</b>: A core class gets a new role class. Because it is
	 * multiple valued there are two list changes in the feature change. One for
	 * attach the role to core and one for core to role.</li>
	 * <li><b>Remove</b>: A core class loses a role class.</li>
	 * <li><b>Change</b>: It is only for an attribute. The changed value is
	 * either the referenceValue or the value in feature change.</li>
	 * </ul>
	 * This method determines the kind of change, records all changes and resets
	 * them if the further interpretation was not successful. Next step is to
	 * see which dependencies fits the added EObject. ADD requires dependencies.
	 * REMOVE and CHANGE need it?
	 */
	@Override
	public Boolean interprete(EObject eObject, InterpretationContext context) {
		System.out.println("Enter interprete");
		if (context.getDependencies() == null || !(eObject instanceof ChangeDescription))
			return false;
		ChangeDescription changeDescription = (ChangeDescription) eObject;
		if (!context.setChangeKind(changeDescription)) {
			System.out.println("Too many ChangeKinds in this description!");
			return false;
		}
		boolean success = false;
		if (context.isChangeKind(ChangeKind.ADD)) {
			for (Graph dependencies : context.getDependencies()) {
				// TODO record the changes differently if there are more
				// dependencies for one object
				// TODO handle REMOVE with dependencies (maybe no need)
				context.push(eObject);
				// TODO determine which dependencies is the right one
				success = interprete_org_emftext_language_rolecore_dependencies_Graph(dependencies, context);
				if (success) {
					break;
				}
			}
		}
		if (context.isChangeKind(ChangeKind.MOVE)){
			context.resetChangingHelpClass();
			context.getChangingHelpClass().applyChange(changeDescription);
			success = true;
		}
		resetChangeKind(context);
		return success;
	}

	/**
	 * Interpret each domain, if it returns true apply the others (if there are
	 * more)
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Graph(Graph object,
			InterpretationContext context) {
		System.out.println("\nEnter interprete Graph " + object.getName());
		ChangeDescription cd = (ChangeDescription) context.pop();

		for (Domain domain : object.getModelDomains()) {
			context.push(cd);
			changeRecorder = new ChangeRecorder(context.getResourceSet());
			context.resetCreatingHelpClass(object);
			if (interprete_org_emftext_language_rolecore_dependencies_Domain(domain, context)) {
				// TODO to remove
				System.out.println("Interpret successfully!");

				// apply changes
				cd.applyAndReverse();

				List<Domain> otherDomains = getOtherDomains(object, domain);
				// create correspondences
				if (otherDomains != null) {
					for (Domain otherDomain : otherDomains) {
						if (!createCoreClassesInDomain(otherDomain, context)) {
							System.out.println("Invalid Dependencies!");
							cd.apply();
							changeRecorder.endRecording().apply();
							return false;
						}
					}
					// create trace links (only for creates? trace links for
					// semi requires are created)
					createTraceLinks(object, context);
				}
				// add objects of this domain without container to domain root
				context.getCreatingHelpClass().addObjectsToRootDomain(domain);
				return true;
			} else {
				changeRecorder.endRecording().apply();
			}
		}
		return false;
	}

	private boolean createTraceLinks(Graph graph, InterpretationContext context) {
		Equivalence equivalence = graph.getModelEquivalence();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		if (equivalence != null) {
			EList<Edge> edges = equivalence.getEdges();
			if (edges != null && edges.size() > 0) {
				for (Edge edge : edges) {
					if (edge.isEqual()) {
						if (context.isAssignment(edge)) {
							String coreClassName = edge.getSimpleTerm().getCoreClass().getName();
							AssignmentTraceLink assignmentTraceLink = InterpreterFactory.eINSTANCE
									.createAssignmentTraceLink();
							assignmentTraceLink.setEdge(edge);
							EObject roleEObject = context.getRoleEObjects(creatingHelpClass.getCoreEObjectFromMap(coreClassName), edge.getSimpleTerm().getRole()).get(0);
							creatingHelpClass.addRoleToAssignmentTraceLink(coreClassName, roleEObject, assignmentTraceLink);
							creatingHelpClass.addRoleToAssignmentTraceLinkInRightTerm(edge.getRightTerm(), assignmentTraceLink);
							context.addAssignmentTraceLink(assignmentTraceLink);
						}
					}
				}
			}
		}
		EList<CoreClass> sourceCoreClasses = graph.getModelDomains().get(0).getCreate().getCoreClasses();
		if (graph.getModelDomains().get(1) != null) {
			EList<CoreClass> targetCoreClasses = graph.getModelDomains().get(1).getCreate().getCoreClasses();
			for (CoreClass sourceCoreClass : sourceCoreClasses) {
				for (CoreClass targetCoreClass : targetCoreClasses) {
					context.addEqualTraceLink(creatingHelpClass.getCoreEObjectFromMap(sourceCoreClass.getName()),
							creatingHelpClass.getCoreEObjectFromMap(targetCoreClass.getName()));
				}
			}
		}
		return true;
	}


	private boolean createCoreClassesInDomain(Domain domain, InterpretationContext context) {
		// TODO remove
		System.out.println("\nCreating the domain " + domain.getName());
		if (!handleRequiredBlock(domain.getRequired(), context)) {
			return false;
		}
		if (!handleRequiredBlock(domain.getSemiRequired(), context)) {
			return false;
		}

		// create and map Create
		EList<CoreClass> createCoreClasses = domain.getCreate().getCoreClasses();
		for (CoreClass coreClassToCreate : createCoreClasses) {
			context.createSynchronizationCoreClass(coreClassToCreate);
		}

		// create links
		context.getCreatingHelpClass().setAttributesAndCreateReferences(domain);

		// add core classes with no container to the root
		context.getCreatingHelpClass().addObjectsToRootDomain(domain);
		return true;
	}

	private boolean handleRequiredBlock(Block block, InterpretationContext context) {
		if (block != null) {
			EList<CoreClass> requiredCoreClasses = block.getCoreClasses();
			if (requiredCoreClasses != null && requiredCoreClasses.size() > 0) {
				for (CoreClass coreClass : requiredCoreClasses) {
					if (!context.getCreatingHelpClass().handleRequiredCoreClass(coreClass, (Domain) block.eContainer())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private List<Domain> getOtherDomains(Graph object, Domain domain) {
		if (object == null || domain == null)
			return null;
		List<Domain> domains = new ArrayList<Domain>();
		for (Domain otherDomain : object.getModelDomains()) {
			if (!domain.equals(otherDomain))
				domains.add(otherDomain);
		}
		return (domains.size() == 0) ? null : domains;
	}

	/**
	 * TODO Resource changes must be applied here.
	 */
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Domain(Domain object,
			InterpretationContext context) {
		System.out.println("Enter interprete Domain " + object.getName());
		ChangeDescription cd = (ChangeDescription) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		creatingHelpClass.setListsAndMaps(cd.getObjectChanges(), object);
		// maybe just start with the 1st element in mapOfObjectsToChange
		DomainRoot domainRoot = context.findOrCreateDomainRoot(object.getName());
		List<FeatureChange> featureChanges = creatingHelpClass.getListOfObjectsToChange().remove(domainRoot);
		if (featureChanges != null) {// root change, its feature changes do not
			// need to interpret
			System.out.println("root change");
			if (!creatingHelpClass.addNextElementsFromRoot(featureChanges, object)) {
				return false;
			}
		} else {// normal feature change, which starts in Required
			System.out.println("feature change");
			if (!creatingHelpClass.addNextElementsFromRequired(object, cd.getObjectChanges().get(0)))
				return false;
		}
		// interpret the root, the others have to interpret automatically
		Entry<EObject, CoreClass> entry = creatingHelpClass.popNextElement();
		context.push(entry.getKey());
		return interprete_org_emftext_language_rolecore_dependencies_CoreClass(entry.getValue(), context);

	}

	/**
	 * Recursive interpretation of CoreClass. Remove from mapOfObjectsToChange.
	 * If successful add next elements, apply (add corresponding objects and add
	 * to coreClassesMap), add to coreClassesMap, remove from
	 * listOfCoreClassesToInterpret. Interpret the next in mapOfNextElements.
	 * Else return false. In case of not determinable in further interpretation.
	 * All changes must be reset and return false in order to try next object.
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_CoreClass(CoreClass object,
			InterpretationContext context) {
		// assume type of CoreClass and eObject are the same.
		System.out.println("Enter interprete CoreClass " + object.getName());
		EObject eObject = (EObject) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		// feature changes from core class to roles
		// remove from listOfObjectsToChange
		// the leaf core is not always the core of this role, the feature
		// changes have to be of all the cores
		List<FeatureChange> coreToRolesFC = new ArrayList<FeatureChange>();
		creatingHelpClass.removeFeatureChangesOf(eObject, coreToRolesFC, true);
		List<Edge> edgesToInterpret = new ArrayList<Edge>();
		EList<Edge> edges = object.getEdges();
		// maximal satisfy - for each the feature change, minimal satisfy - for
		// each the edges
		if (edges != null && edges.size() > 0) {
			// TODO if there is no edges but there are feature change for this
			// object, it should return false
			// TODO add more edges which are required not only by the domain,
			// but
			// implicitly by equivalences
			for (Edge edge : edges) {
				edgesToInterpret.add(edge);
			}
			creatingHelpClass.addImplicitEdges(object, edgesToInterpret);
			for (FeatureChange featureChange : coreToRolesFC) {
				// TODO validated edges have to take out of the list to prevent
				// further validation
				// TODO a core has only a roles feature, but changes for this
				// feature can be in different feature changes or list changes,
				// have
				// to cover all this
				EList<ListChange> listChanges = featureChange.getListChanges();
				for (ListChange listChange : listChanges) {
					for (EObject role : listChange.getReferenceValues()) {
						boolean hasRole = false;
						for (Edge edge : edgesToInterpret) {
							context.push(role);
							if (interprete_org_emftext_language_rolecore_dependencies_Edge(edge, context)) {
								edgesToInterpret.remove(edge);
								hasRole = true;
								System.out.println(" and is from " + eObject.eClass().getName());
								break;
							}
						}
						if (!hasRole) {
							return false;
						}
					}
				}
			}
		}
		// successful if all edges are used
		if (edgesToInterpret.size() != 0) {
			return false;
		}
		Entry<EObject, CoreClass> entry = creatingHelpClass.popNextElement();
		if (entry != null) {
			context.push(entry.getKey());
			creatingHelpClass.getListOfCoreClassesToInterpret().remove(object);
			return interprete_org_emftext_language_rolecore_dependencies_CoreClass(entry.getValue(), context);
		}
		return true;
	}

	/**
	 * This method interpret the direct and indirect edges of a core class only.
	 * Edges of Equivalences cannot be interpret.
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Edge(Edge object, InterpretationContext context) {
		System.out.println("Enter interprete Edge");
		EObject role = (EObject) context.pop();
		if (object.getSimpleTerm().getRole().equals(role.eClass())) {
			List<FeatureChange> featureChanges = new ArrayList<FeatureChange>();
			context.getCreatingHelpClass().removeFeatureChangesOf(role, featureChanges, false);
			for (FeatureChange featureChange : featureChanges) {
				// there is one attribute to each role, no list change
				if (object.isEqual() && featureChange.getDataValue() != null) {
					// TODO remove
					System.out.print("\tRole " + role.eClass().getName() + " gets the value "
							+ featureChange.getDataValue());
					return true;
				}
				if (object.isReferredTo() && featureChange.getFeature() != context.getCoreStructuralFeature()
						&& featureChange.getReferenceValue() != null) {
					EObject nextEObject = featureChange.getReferenceValue();
					EList<SimpleTerm> simpleTerms = object.getRightTerm().getSimpleTerms();
					if (simpleTerms != null && simpleTerms.size() > 0) {
						SimpleTerm simpleTerm = simpleTerms.get(0);
						if (simpleTerm.getRole() == null && simpleTerm.getCoreClass() != null) {
							EClass coreEClass = simpleTerm.getCoreClass().getType();
							List<EObject> superCores = context.getSuperCores(nextEObject);
							superCores.add(0, nextEObject);
							for (EObject eObject : superCores) {
								if (coreEClass.equals(eObject.eClass())) {
									// add to the next element if it was not
									// interpreted
									CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
									creatingHelpClass.addNextElement(simpleTerm.getCoreClass(), nextEObject);
									// TODO remove
									System.out.print("\tRole " + role.eClass().getName() + " refers to "
											+ nextEObject.eClass().getName());
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private void resetChangeKind(InterpretationContext context) {
		context.setChangeKind(-1);
		context.setResourceChanged(false);
	}
}

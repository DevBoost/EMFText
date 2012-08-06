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
package org.emftext.language.hedl.validation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.emftext.language.hedl.HedlPackage;
import org.emftext.language.hedl.NamedElement;

/**
 * A simple constraint that checks that there are no duplicate names for
 * Entities and Enumerations.
 */
public abstract class AbstractHedlConstraint extends AbstractModelConstraint implements IModelConstraint {
	
	public final static HedlPackage HEDL_PACKAGE = HedlPackage.eINSTANCE;

	private static String[] RESERVED_WORDS = new String[] {
		"abstract", 
		"assert", 
		"boolean", 
		"break", 
		"byte", 
		"case", 
		"catch", 
		"char", 
		"class", 
		"const", 
		"continue",  
		"default", 
		"do", 
		"double", 
		"else", 
		"enum", 
		"extends",
		"false", 
		"final", 
		"finally", 
		"float", 
		"for", 
		"goto", 
		"if", 
		"implements", 
		"import", 
		"instanceof", 
		"int", 
		"interface", 
		"long", 
		"native", 
		"new", 
		"null",
		"package", 
		"private", 
		"protected", 
		"public", 
		"return", 
		"short", 
		"static", 
		"strictfp", 
		"super", 
		"switch", 
		"synchronized", 
		"this", 
		"throw", 
		"throws", 
		"transient",
		"true",
		"try", 
		"void", 
		"volatile", 
		"while", 
	};

	public AbstractHedlConstraint() {
		super();
	}

	protected Set<EObject> checkUniqueNames(EObject object, EClass rootType, Set<EClass> types) {
		if (rootType.isInstance(object)) {
			return checkUniqueNamesInternal(object, types);
		} else {
			return Collections.emptySet();
		}
	}
	
	private Set<EObject> checkUniqueNamesInternal(EObject target, Set<EClass> types) {
		Map<String, Set<NamedElement>> nameToNewObjectsMap = new LinkedHashMap<String, Set<NamedElement>>();
		fillNameMap(nameToNewObjectsMap, target, types);
		
		Set<EObject> entitiesAndEnumsWithDuplicateName = new LinkedHashSet<EObject>();
		for (String name : nameToNewObjectsMap.keySet()) {
			Set<NamedElement> entitiesAndEnums = nameToNewObjectsMap.get(name);
			if (entitiesAndEnums.size() > 1) {
				entitiesAndEnumsWithDuplicateName.addAll(entitiesAndEnums);
			}
		}
		return entitiesAndEnumsWithDuplicateName;
	}

	private void fillNameMap(Map<String, Set<NamedElement>> nameToNewObjectsMap, EObject eObject, Set<EClass> types) {
		boolean hasType = false;
		for (EClass type : types) {
			hasType |= type.isInstance(eObject);
		}
		if (hasType) {
			NamedElement namedElement = (NamedElement) eObject;
			String name = namedElement.getName();
			if (name != null) {
				Set<NamedElement> newObjects = nameToNewObjectsMap.get(name);
				if (newObjects == null) {
					newObjects = new LinkedHashSet<NamedElement>();
					nameToNewObjectsMap.put(name, newObjects);
				}
				newObjects.add(namedElement);
			}
		}

		for (EObject child : eObject.eContents()) {
			fillNameMap(nameToNewObjectsMap, child, types);
		}
	}

	protected IStatus checkForbiddenNames(EObject target, EClass type, Set<String> additionalForbiddenNames) {
		if (type.isInstance(target)) {
			NamedElement namedElement = (NamedElement) target;
			String name = namedElement.getName();
			Set<String> forbiddenNames = getForbiddenNames();
			forbiddenNames.addAll(additionalForbiddenNames);
			String errorMessage = "Invalid name for " + namedElement.eClass().getName() + ".";
			if (forbiddenNames.contains(name)) {
				return new ConstraintStatus(this, target, errorMessage, Collections.singleton(namedElement));
			}
			// dots are not allowed in names, but the token UPPER allows dots
			// to be able to reference Java interfaces by their fully qualified
			// name
			if (name.contains(".")) {
				return new ConstraintStatus(this, target, errorMessage, Collections.singleton(namedElement));
			}
		}
		return Status.OK_STATUS;
	}

	private Set<String> getForbiddenNames() {
		Set<String> forbiddenNames = new LinkedHashSet<String>();
		
		for (String reservedWord : RESERVED_WORDS) {
			forbiddenNames.add(reservedWord);
		}
		// TODO add names of Hibernate classes
		return forbiddenNames;
	}

	public IConstraintDescriptor getDescriptor() {
		return new AbstractConstraintDescriptor() {
			
			public boolean targetsTypeOf(EObject eObject) {
				return true;
			}
			
			public boolean targetsEvent(Notification notification) {
				return false;
			}
			
			public void removeCategory(Category category) {
			}
			
			public boolean isLive() {
				return false;
			}
			
			public boolean isBatch() {
				return true;
			}
			
			public int getStatusCode() {
				return 0;
			}
			
			public ConstraintSeverity getSeverity() {
				return ConstraintSeverity.ERROR;
			}
			
			public String getPluginId() {
				return AbstractHedlConstraint.class.getPackage().getName();
			}
			
			public String getName() {
				return "name";
			}
			
			public String getMessagePattern() {
				return "message";
			}
			
			public String getId() {
				return null;
			}
			
			public EvaluationMode<?> getEvaluationMode() {
				return EvaluationMode.BATCH;
			}
			
			public String getDescription() {
				return "description";
			}
			
			public Set<Category> getCategories() {
				return null;
			}
			
			public String getBody() {
				return null;
			}
			
			public void addCategory(Category category) {
			}
		};
	}
}

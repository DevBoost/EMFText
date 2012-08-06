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
package org.emftext.language.efactory.validation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.NewObject;

/**
 * A simple constraint that checks that there are no duplicate names for
 * NewObjects.
 */
public class UniqueNamesConstraint extends AbstractModelConstraint implements IModelConstraint {
	
	public UniqueNamesConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext context) {
		EObject target = context.getTarget();
		if (target instanceof Factory) {
			Map<String, Set<NewObject>> nameToNewObjectsMap = new LinkedHashMap<String, Set<NewObject>>();
			fillNameMap(nameToNewObjectsMap, target);
			
			Set<EObject> newObjectsWithDuplicateName = new LinkedHashSet<EObject>();
			for (String name : nameToNewObjectsMap.keySet()) {
				Set<NewObject> newObjects = nameToNewObjectsMap.get(name);
				if (newObjects.size() > 1) {
					newObjectsWithDuplicateName.addAll(newObjects);
				}
			}
			if (newObjectsWithDuplicateName.size() > 0) {
				return new ConstraintStatus(this, target, "Duplicate name for new object.", newObjectsWithDuplicateName);
			}
		}
		return Status.OK_STATUS;
	}

	private void fillNameMap(Map<String, Set<NewObject>> nameToNewObjectsMap, EObject eObject) {
		if (eObject instanceof NewObject) {
			NewObject newObject = (NewObject) eObject;
			String name = newObject.getName();
			if (name != null) {
				Set<NewObject> newObjects = nameToNewObjectsMap.get(name);
				if (newObjects == null) {
					newObjects = new LinkedHashSet<NewObject>();
					nameToNewObjectsMap.put(name, newObjects);
				}
				newObjects.add(newObject);
			}
		}
		for (EObject child : eObject.eContents()) {
			fillNameMap(nameToNewObjectsMap, child);
		}
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
				return UniqueNamesConstraint.class.getPackage().getName();
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

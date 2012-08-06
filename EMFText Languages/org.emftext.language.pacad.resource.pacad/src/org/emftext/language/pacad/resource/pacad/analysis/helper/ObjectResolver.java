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
package org.emftext.language.pacad.resource.pacad.analysis.helper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.pacad.Object;
import org.emftext.language.pacad.PacadPackage;
import org.emftext.language.pacad.PointAndClickAdventure;
import org.emftext.language.pacad.Room;
import org.emftext.language.pacad.resource.pacad.IPacadReferenceResolveResult;

public class ObjectResolver {

	public void resolveRoom(String identifier, PointAndClickAdventure container,
			EReference reference, int position, boolean resolveFuzzy,
			IPacadReferenceResolveResult<Room> result) {
		Map<String, Object> mapping = resolve(identifier, container, reference, position, resolveFuzzy, PacadPackage.eINSTANCE.getRoom());
		for (String ident : mapping.keySet()) {
			Object object = mapping.get(ident);
			if (object instanceof Room) {
				result.addMapping(ident, (Room) object);
			}
		}
	}
	
	public void resolveObject(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy,
			IPacadReferenceResolveResult<Object> result) {
		Map<String, Object> mapping = resolve(identifier, container, reference, position, resolveFuzzy, PacadPackage.eINSTANCE.getObject());
		for (String ident : mapping.keySet()) {
			result.addMapping(ident, mapping.get(ident));
		}
	}

	private Map<String, Object> resolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, EClass targetType) {
		
		Map<String, Object> mapping = new LinkedHashMap<String, Object>();
		EObject rootObject = EcoreUtil.getRootContainer(container);
		if (rootObject instanceof PointAndClickAdventure) {
			PointAndClickAdventure adventure = (PointAndClickAdventure) rootObject;
			// find main script
			PointAndClickAdventure mainScript = adventure.getMainScript();
			if (mainScript != null) {
				adventure = mainScript;
			}
			// find objects with matching IDs
			EList<Object> allObjects = adventure.getAllObjects();
			//print(container.eResource(), allObjects);
			for (Object next : allObjects) {
				if (!targetType.isInstance(next)) {
					continue;
				}
				String nextID = next.getId();
				if (identifier.equals(nextID) || resolveFuzzy) {
					mapping.put(nextID, next);
					if (!resolveFuzzy) {
						return mapping;
					}
				}
			}
		}
		return mapping;
	}

	/*
	private void print(Resource eResource, EList<Object> allObjects) {
		String objects = "";
		for (Object object : allObjects) {
			objects += object.getId() + ", ";
		}
		System.out.println(eResource.getURI().path() + " : " + objects);
	}
	*/

	public String deResolve(Object element, EObject container,
			EReference reference) {
		return element.getId();
	}
}

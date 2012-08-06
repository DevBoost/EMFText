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
package org.emftext.language.pacad.resource.pacad;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.pacad.Command;
import org.emftext.language.pacad.CommandType;
import org.emftext.language.pacad.InternalObject;
import org.emftext.language.pacad.NamedElement;
import org.emftext.language.pacad.Object;
import org.emftext.language.pacad.PacadPackage;
import org.emftext.language.pacad.PlaySound;
import org.emftext.language.pacad.PointAndClickAdventure;
import org.emftext.language.pacad.Room;
import org.emftext.language.pacad.resource.pacad.mopp.PacadResource;
import org.emftext.language.pacad.resource.pacad.util.PacadEObjectUtil;
import org.emftext.language.pacad.util.ImageType;
import org.emftext.language.pacad.util.PathUtil;

public class PacadConstraintChecker {

	private static final PacadEProblemType PROBLEM_TYPE = PacadEProblemType.BUILDER_ERROR;
	private PathUtil pathUtil = new PathUtil();

	public void check(PacadResource resource) {
		if (resource.getContents().size() == 1) {
			IFile file = WorkspaceSynchronizer.getFile(resource);
			IProject project = file.getProject();
			File root = project.getLocation().toFile();
			PointAndClickAdventure adventure = (PointAndClickAdventure) resource
					.getContents().get(0);

			if (adventure.getMainScript() != null) {
				checkThingObjectExists(adventure, resource);
				checkNamesAreNotNull(adventure.eAllContents(), resource);
				checkFilesExist(adventure.eAllContents(), resource, root);
				checkForDuplicateIDs(adventure, resource);
				checkCommandArguments(adventure, resource);
				checkUseCommands(adventure, resource);
			}
		}
	}

	private void checkCommandArguments(PointAndClickAdventure adventure,
			PacadResource resource) {
		EList<Command> allCommands = adventure.getAllCommands();
		for (Command command : allCommands) {
			if (command.getType() != CommandType.USE) {
				if (command.getSubjects().size() != 1) {
					resource.addError(
						"All commands expect USE take one argument only", 
						PROBLEM_TYPE, 
						command);
				} else {
					// number of subject is 1, which is ok
				}
			} else {
				if (command.getSubjects().size() < 1 ||
					command.getSubjects().size() > 2) {
					resource.addError(
						"The commmand USE takes one or two arguments", 
						PROBLEM_TYPE, 
						command);
				} else {
					// use command with one or two arguments, which is ok
				}
			}
		}
	}

	private void checkUseCommands(PointAndClickAdventure adventure,
			PacadResource resource) {
		
		// the set of objects that can be used without another object
		Set<Object> selfUsableObjects = new LinkedHashSet<Object>();
		// the set of objects that must be used together with other object
		Set<Object> notSelfUsableObjects = new LinkedHashSet<Object>();
		
		EList<Command> useCommands = adventure.getAvailableCommands(CommandType.USE);
		for (Command command : useCommands) {
			assert command.getType() == CommandType.USE;
			EList<Object> subjects = command.getSubjects();
			if (subjects.size() == 1) {
				selfUsableObjects.add(subjects.get(0));
			} else if (subjects.size() == 2) {
				notSelfUsableObjects.add(subjects.get(0));
			}
		}
		
		for (Object selfUsable : selfUsableObjects) {
			if (notSelfUsableObjects.contains(selfUsable)) {
				resource.addError(
					"Objects must be either usable without another object, or together with other objects only. " +
					"Please check the 'on use' actions defined for this object.",
					PROBLEM_TYPE,
					selfUsable);
			}
		}
	}

	private void checkForDuplicateIDs(PointAndClickAdventure adventure,
			PacadResource resource) {
		Map<String, Set<Object>> idToObjectMap = new LinkedHashMap<String, Set<Object>>();
		// collect objects for each ID
		for (Object object : adventure.getAllObjects()) {
			String id = object.getId();
			if (!idToObjectMap.containsKey(id)) {
				idToObjectMap.put(id, new LinkedHashSet<Object>());
			}
			Set<Object> set = idToObjectMap.get(id);
			set.add(object);
		}
		
		// check for duplicates
		for (String id : idToObjectMap.keySet()) {
			Set<Object> objects = idToObjectMap.get(id);
			if (objects.size() > 1) {
				for (Object object : objects) {
					resource.addError(
							"There is already an object with id: " + id, 
							PROBLEM_TYPE,
							object
					);
				}
			}
		}
	}

	private void checkThingObjectExists(PointAndClickAdventure adventure,
			PacadResource resource) {
		if (adventure.isMain() && adventure.getThingObject() == null) {
			resource.addError(
					"Main adventures must have a super object with the id 'thingy'.", 
					PROBLEM_TYPE, 
					adventure
			);
		}
	}

	private void checkNamesAreNotNull(TreeIterator<EObject> eAllContents,
			PacadResource resource) {
		Collection<NamedElement> elements = PacadEObjectUtil.getObjectsByType(eAllContents, PacadPackage.eINSTANCE.getNamedElement());
		for (NamedElement namedElement : elements) {
			if (namedElement instanceof Object) {
				Object o = (Object) namedElement;
				if ("disabled_door".equals(o.getId())) {
					System.out.println("PacadOptionProvider.checkNamesAreNotNull() " + o.getName());
				}
			}
			String name = namedElement.getName();
			if (name == null) {
				resource.addError(
						"Objects must have a label (either inherited or declared).", 
						PROBLEM_TYPE, 
						namedElement
				);
			}
		}
	}

	private void checkFilesExist(TreeIterator<EObject> allContents,
			PacadResource resource, File root) {

		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();

			if (eObject instanceof Object && 
				!(eObject instanceof InternalObject)) {
				Object o = (Object) eObject;
				checkObjectResources(resource, o, root);
			} 
				
			if (eObject instanceof PlaySound) {
				PlaySound sound = (PlaySound) eObject;
				String id = sound.getSoundfile();
				checkSoundFile(resource, eObject, id, root);
			}
		}
	}

	private void checkObjectResources(PacadResource resource, Object obj, File root) {
		if (obj instanceof Room) {
			Room room = (Room) obj;
			checkSoundFile(resource, room, room.getBackgroundSound(), root);
		}
		ImageType type = ImageType.OBJECT;
		if (obj instanceof Room) {
			type = ImageType.ROOM;
		}
		File imageFile = pathUtil.getImageFile(root, obj, false);
		String path = pathUtil.getImagePath(root, type);
		if (imageFile == null) {
			resource.addError(
					"Image '" + obj.getId()
							+ "' could not be found at "
							+ path
							+ pathUtil.getImageExtensionsString(),
							PROBLEM_TYPE, obj);
		}
	}

	private void checkSoundFile(PacadResource resource, EObject eObject,
			String id, File root) {
		if (id == null) {
			resource.addWarning(
					"Rooms should have a background sound.",
					PROBLEM_TYPE, 
					eObject);
			return;
		}
		File soundFile = pathUtil.getSoundFile(root, id);
		String path = pathUtil.getSoundPath(root);
		if (soundFile == null) {
			resource.addError(
					"Sound file '" + id
							+ "' could not be found at "
							+ path
							+ pathUtil.getSoundExtensionsString(),
							PROBLEM_TYPE, eObject);
		}
	}

	public void terminate() {
		// do nothing
	}
}

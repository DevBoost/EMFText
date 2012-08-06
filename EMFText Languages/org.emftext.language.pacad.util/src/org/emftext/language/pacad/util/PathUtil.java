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
package org.emftext.language.pacad.util;

import java.io.File;

import org.emftext.language.pacad.Object;
import org.emftext.language.pacad.Room;

public class PathUtil {

	/** Allowed endings of images to be displayed. */
	private final static String[] IMAGE_FILE_EXTENSIONS = new String[] { "gif",
			"GIF", "jpg", "JPG", "png", "PNG" };

	private final static String[] SOUND_FILE_EXTENSIONS = new String[] {
		"wav", "mid" };

	private static final String SOUND_FOLDER = "sounds";
	
	public String getImageExtensionsString() {
		String[] extensions = IMAGE_FILE_EXTENSIONS;
		return getExtensionsString(extensions);
	}

	public String getSoundExtensionsString() {
		String[] extensions = SOUND_FILE_EXTENSIONS;
		return getExtensionsString(extensions);
	}

	private String getExtensionsString(String[] extensions) {
		String s = "(";
		for (String ext : extensions) {
			s += ext + "|";
		}
		s = s.substring(0, s.length() - 1);
		return s + ")";
	}

	public String getImagePath(File root, ImageType type) {
		String path = root.getPath() + File.separator + "artwork" + File.separator;

		if (type == ImageType.ROOM)
			path += "backgrounds" + File.separator;
		else if (type == ImageType.OBJECT)
			path += "objects" + File.separator;
		else if (type == ImageType.SYSTEM)
			path += "system" + File.separator;

		return path;
	}

	public String getSoundPath(File root) {
		String path = root.getPath() + File.separator + SOUND_FOLDER + File.separator;
		return path;
	}
	
	/**
	 * Tries to find the image with all expected endings.
	 */
	public File getImageFile(File root, Object object, boolean acceptThingImage) {
		if (object == null) {
			return null;
		}
		ImageType type = ImageType.OBJECT;
		if (object instanceof Room) {
			type = ImageType.ROOM;
		}
		Object current = object;
		File file = null;
		Object thingObject = object.getAdventure().getThingObject();
		do {
			String img = current.getId();
			file = getImageFile(root, img, type);
			if (file != null) {
				// found file
				break;
			}
			current = current.getParent();
		} while (current != null && current != thingObject);
		if (!acceptThingImage && current == thingObject && object != thingObject) {
			return null;
		}
		return file;
	}

	public File getImageFile(File root, String img, ImageType type) {
		File file;
		String path = getImagePath(root, type) + img;
		file = getFile(path, IMAGE_FILE_EXTENSIONS);
		return file;
	}

	/**
	 * Tries to find the sound with all expected endings.
	 */
	public File getSoundFile(File root, String soundFileID) {
		String path = getSoundPath(root) + soundFileID ;
		return getFile(path, SOUND_FILE_EXTENSIONS);
	}

	private File getFile(String path, String[] extensions) {
		for (String extension : extensions) {
			File file = new File(path + "." + extension);
			if (file.exists()) {
				return file;
			}
			// no else.
		}
		return null;
	}
}

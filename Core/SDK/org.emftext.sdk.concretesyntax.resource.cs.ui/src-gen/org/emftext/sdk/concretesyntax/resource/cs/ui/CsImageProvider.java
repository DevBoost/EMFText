/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A provider class for all images that are required by the generated UI plug-in.
 * The default implementation load images from the bundle and caches them to make
 * sure each image is loaded at most once.
 */
public class CsImageProvider {
	
	public final static CsImageProvider INSTANCE = new CsImageProvider();
	
	private Map<String, Image> imageCache = new LinkedHashMap<String, Image>();
	
	/**
	 * Returns the image associated with the given key. The key can be either a path
	 * to an image file in the resource bundle or a shared image from
	 * org.eclipse.ui.ISharedImages.
	 */
	public Image getImage(String key) {
		if (key == null) {
			return null;
		}
		Image image = null;
		// try shared images
		try {
			Field declaredField = ISharedImages.class.getDeclaredField(key);
			Object valueObject = declaredField.get(null);
			if (valueObject instanceof String) {
				String value = (String) valueObject;
				image = PlatformUI.getWorkbench().getSharedImages().getImage(value);
			}
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		if (image != null) {
			return image;
		}
		
		// try cache
		if (imageCache.containsKey(key)) {
			return imageCache.get(key);
		}
		
		// try loading image from UI bundle
		ImageDescriptor descriptor = getImageDescriptor(key);
		if (descriptor == null) {
			return null;
		}
		image = descriptor.createImage();
		if (image == null) {
			return null;
		}
		imageCache.put(key, image);
		return image;
	}
	
	/**
	 * <p>
	 * Returns the image for the given key. Possible keys are:
	 * </p>
	 * <p>
	 * <ul>
	 * </p>
	 * <p>
	 * <li>platform:/plugin/your.plugin/icons/yourIcon.png</li>
	 * </p>
	 * <p>
	 * <li>bundleentry://557.fwk3560063/icons/yourIcon.png</li>
	 * </p>
	 * <p>
	 * </ul>
	 * </p>
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		IPath path = new Path(key);
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin plugin = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault();
		if (plugin == null) {
			return null;
		}
		
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(FileLocator.find(plugin.getBundle(), path, null));
		if (ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
			// try loading image from any bundle
			try {
				URL pluginUrl = new URL(key);
				descriptor = ImageDescriptor.createFromURL(pluginUrl);
				if (ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
					return null;
				}
			} catch (MalformedURLException mue) {
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.logError("IconProvider can't load image (URL is malformed).", mue);
			}
		}
		return descriptor;
	}
	
}

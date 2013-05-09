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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A provider class for all images that are required by the generated UI plug-in.
 * The default implementation load images from the bundle and caches them to make
 * sure each image is loaded at most once.
 */
public class CsImageProvider {
	
	public final static CsImageProvider INSTANCE = new CsImageProvider();
	
	private java.util.Map<String, org.eclipse.swt.graphics.Image> imageCache = new java.util.LinkedHashMap<String, org.eclipse.swt.graphics.Image>();
	
	/**
	 * Returns the image associated with the given key. The key can be either a path
	 * to an image file in the resource bundle or a shared image from
	 * org.eclipse.ui.ISharedImages.
	 */
	public org.eclipse.swt.graphics.Image getImage(String key) {
		if (key == null) {
			return null;
		}
		org.eclipse.swt.graphics.Image image = null;
		// try shared images
		try {
			java.lang.reflect.Field declaredField = org.eclipse.ui.ISharedImages.class.getDeclaredField(key);
			Object valueObject = declaredField.get(null);
			if (valueObject instanceof String) {
				String value = (String) valueObject;
				image = org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages().getImage(value);
			}
		} catch (java.lang.SecurityException e) {
		} catch (java.lang.NoSuchFieldException e) {
		} catch (java.lang.IllegalArgumentException e) {
		} catch (java.lang.IllegalAccessException e) {
		}
		if (image != null) {
			return image;
		}
		
		// try cache
		if (imageCache.containsKey(key)) {
			return imageCache.get(key);
		}
		
		// try loading image from UI bundle
		org.eclipse.jface.resource.ImageDescriptor descriptor = getImageDescriptor(key);
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
	 * Returns the image for the given key. Possible keys are:
	 * <ul>
	 * <li>platform:/plugin/your.plugin/icons/yourIcon.png</li>
	 * <li>bundleentry://557.fwk3560063/icons/yourIcon.png</li>
	 * </ul>
	 */
	public org.eclipse.jface.resource.ImageDescriptor getImageDescriptor(String key) {
		org.eclipse.core.runtime.IPath path = new org.eclipse.core.runtime.Path(key);
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin plugin = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault();
		if (plugin == null) {
			return null;
		}
		
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.eclipse.jface.resource.ImageDescriptor.createFromURL(org.eclipse.core.runtime.FileLocator.find(plugin.getBundle(), path, null));
		if (org.eclipse.jface.resource.ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
			// try loading image from any bundle
			try {
				java.net.URL pluginUrl = new java.net.URL(key);
				descriptor = org.eclipse.jface.resource.ImageDescriptor.createFromURL(pluginUrl);
				if (org.eclipse.jface.resource.ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
					return null;
				}
			} catch (java.net.MalformedURLException mue) {
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.logError("IconProvider can't load image (URL is malformed).", mue);
			}
		}
		return descriptor;
	}
	
}

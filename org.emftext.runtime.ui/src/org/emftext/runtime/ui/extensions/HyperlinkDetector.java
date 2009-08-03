/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.extensions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

/**
 * A hyperlink detector returns hyperlink if the token, where the mouse cursor hovers, is a proxy. 
 * @author Tan-Ky Hoang-Kim
 *
 */
public class HyperlinkDetector implements IHyperlinkDetector {

	private ITextResource textResource;

	/**
	 * Creates a hyperlink detector.
	 * @param resource the resource for calculating the locations.
	 */
	public HyperlinkDetector(Resource resource) {
		textResource = (ITextResource) resource;
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
			IRegion region, boolean canShowMultipleHyperlinks) {
		ILocationMap lm = textResource.getLocationMap();
		String resourceFileExtension = textResource.getURI().fileExtension();
		List<EObject> elementsAtOffset = lm.getElementsAt(region.getOffset());
		EObject resolvedEObject = null;
		for (EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = EcoreUtil.resolve(eObject, textResource);
				if (resolvedEObject == eObject
						|| (resolvedEObject.eResource() != null
						&& !resourceFileExtension.equals(
								resolvedEObject.eResource().getURI()
										.fileExtension()))) {
					continue;
				}
				int offset = lm.getCharStart(eObject);
				int length = lm.getCharEnd(eObject) - offset + 1;
				Hyperlink hyperlink = new Hyperlink(resourceFileExtension, new Region(offset, length));
				try {
					hyperlink.setHyperlinkText(textViewer.getDocument().get(offset, length));
				} catch (BadLocationException e) {
				}
				hyperlink.setLinkTarget(resolvedEObject);
				return new IHyperlink[] { hyperlink };
			}
		}
		return null;
	}

}

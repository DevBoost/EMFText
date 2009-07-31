package org.emftext.runtime.ui.extensions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

public class HyperlinkDetector implements IHyperlinkDetector {

	private ITextResource textResource;

	public HyperlinkDetector(Resource resource) {
		textResource = (ITextResource) resource;
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
			IRegion region, boolean canShowMultipleHyperlinks) {
		ILocationMap lm = textResource.getLocationMap();
		List<EObject> elementsAtOffset = lm.getElementsAt(region.getOffset());
		EObject resolvedEObject = null;
		for (EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = EcoreUtil.resolve(eObject, eObject
						.eResource());
				if (resolvedEObject == eObject
						|| (resolvedEObject.eResource() != null
						&& !textResource.getURI().fileExtension().equals(
								resolvedEObject.eResource().getURI()
										.fileExtension())))
					continue;
				int offset = lm.getCharStart(eObject);
				int length = lm.getCharEnd(eObject) - offset + 1;
				Hyperlink hyperlink = new Hyperlink(textResource.getURI()
						.fileExtension(), new Region(offset, length));
				hyperlink.setEObject(resolvedEObject);
				return new IHyperlink[] { hyperlink };
			}
		}
		return null;
	}

}

package org.emftext.sdk.finders;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that searches in the current project in the Eclipse workspace
 * for files that contain generator packages.
 */
public class GenPackageByHintFinder extends GenPackageInFileFinder {
	
	private Set<String> faultyHints = new HashSet<String>();
	
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		if (locationHint == null) {
			return null;
		}
		if (faultyHints.contains(locationHint)) {
			return null;
		}
		return findGenPackageUsingHint(nsURI, locationHint, container, resource);
	}

	/**
	 * Search the current project generator models.
	 * 
	 * @param nsURI
	 * @param rs
	 * @param platformString
	 * @return
	 */
	private IGenPackageFinderResult findGenPackageUsingHint(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		final ResourceSet rs = new ResourceSetImpl();
		try {
			URI hintURI = new LocationHintResolver().getLocationHintURI(locationHint, container);
			if ("genmodel".equals(hintURI.fileExtension())) {
				return findGenPackage(getSyntax(container), nsURI, rs, hintURI);
			}
		} catch (Exception e) {
			e.printStackTrace();
			EMFTextRuntimePlugin.logError("Exception while looking for generator package.", e);
		}
		
		return null;
	}
}

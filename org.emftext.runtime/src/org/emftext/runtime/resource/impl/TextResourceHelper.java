package org.emftext.runtime.resource.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.resource.ITextResource;

/**
 * A TextResourceHelper can be used to perform common task on text resource,
 * such as loading and saving resources, as well as, checking them for errors.
 */
public class TextResourceHelper {

	public ITextResource getResource(IFile file) {
		ResourceSet rs = new ResourceSetImpl();
		Resource csResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
		return (ITextResource) csResource;
	}

	public ITextResource getResource(File file) {
		return getResource(file, null);
	}

	public ITextResource getResource(File file, Map<?,?> options) {
		ResourceSet rs = new ResourceSetImpl();
		if (options != null) {
			rs.getLoadOptions().putAll(options);
		}
		Resource csResource = rs.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		return (ITextResource) csResource;
	}

	public void saveResource(File file, Resource resource) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(file);
		resource.save(outputStream, options);
		outputStream.close();
	}

	public boolean containsErrors(Resource resource) {
		return !resource.getErrors().isEmpty();
	}
	
	protected boolean containsWarnings(Resource resource) {
		return !resource.getWarnings().isEmpty();
	}
	
	public boolean containsProblems(Resource resource) {
		return containsErrors(resource) || containsWarnings(resource);
	}

	/**
	 * Searches for all unresolved proxy object in the given resource.
	 * 
	 * @param resource
	 * @return all proxy object that are not resolvable
	 */
	public List<EObject> findUnresolvedProxies(Resource resource) {
		List<EObject> unresolveProxies = new ArrayList<EObject>();
		
		for(Iterator<EObject> elementIt = EcoreUtil.getAllContents(resource, true); elementIt.hasNext(); ) {
			InternalEObject nextElement = (InternalEObject) elementIt.next();
			if (nextElement.eIsProxy()) {
				unresolveProxies.add(nextElement);
			}
			for (EObject crElement : nextElement.eCrossReferences()) {
				crElement = EcoreUtil.resolve(crElement, resource);
				if (crElement.eIsProxy()) {
					unresolveProxies.add(nextElement);
				}
			}
		}
		return unresolveProxies;
	}
}

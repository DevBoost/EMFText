package org.emftext.runtime.resource.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.resource.ITextResource;

/**
 * A TextResourceHelper can be used to perform common task on text resource,
 * such as loading and saving resources, as well as, checking them for errors.
 */
public class TextResourceHelper {

	protected void saveResource(File file, Resource resource) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(file);
		resource.save(outputStream, options);
		outputStream.close();
	}

	public ITextResource getResource(IFile file) {
		ResourceSet rs = new ResourceSetImpl();
		Resource csResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
		return (ITextResource) csResource;
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
}

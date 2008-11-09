package org.reuseware.emftextedit.sdk.ui.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public abstract class AbstractConcreteSyntaxAction {

	protected Resource getResource(final IFile file) {
		ResourceSet rs = new ResourceSetImpl();
		Resource csResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
		return csResource;
	}

	protected void saveGenModel(File javaFile, GenModel model) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("blah"));
		
		resource.getContents().add(model);
		
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(javaFile);
		resource.save(outputStream, options);
		outputStream.close();
	}

	protected void saveResource(File javaFile, Resource resource) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(javaFile);
		resource.save(outputStream, options);
		outputStream.close();
	}

	protected boolean containsProblems(Resource csResource) {
		return !csResource.getErrors().isEmpty()
				|| !csResource.getWarnings().isEmpty();
	}
}

package org.emftext.sdk.ui.jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * An abstract base class for all actions that generate something from
 * a CS specification.
 */
public abstract class AbstractConcreteSyntaxJob extends org.eclipse.core.runtime.jobs.Job {

	public AbstractConcreteSyntaxJob(String name) {
		super(name);
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
}

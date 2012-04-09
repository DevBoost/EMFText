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
package org.emftext.sdk.ui.jobs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.ui.AbstractSyntaxGenerator;

public abstract class AbstractSyntaxGenerationProcess extends AbstractSyntaxGenerator implements IRunnableWithProgress {
	
	private final IFile file;

	public AbstractSyntaxGenerationProcess(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		ResourceSet rs = new ResourceSetImpl();
		Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
		final GenModel genModel = (GenModel) genResource.getContents().get(0);
		
		URI uri = URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("cs").toString(), true);
		Resource csResource = null;
		if (uri != null && uri.isPlatform()) {
			IResource workspaceMember = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
			if (workspaceMember != null) {
				csResource = rs.getResource(uri, true);
			}
			else {
				csResource = rs.createResource(uri);
			}
		}
		if (csResource == null) {
			EMFTextSDKPlugin.logError("Can't create or get resource.", null);
			return;
		}
		
		EObject currentSyntax = null;
		if (csResource != null && csResource.getContents().size() > 0) {
			currentSyntax = csResource.getContents().get(0);
		}
		
		ConcreteSyntax cSyntax;
		if (currentSyntax instanceof ConcreteSyntax) {
			cSyntax = (ConcreteSyntax) currentSyntax;
		} else {
			cSyntax = CS_FACTORY.createConcreteSyntax();	
			csResource.getContents().add(cSyntax);
		}
		fillSyntax(cSyntax, genModel);
		
		try {
			csResource.save(null);
		} catch (IOException e) {
        	// TODO cwende: this exception should be shown to the user
			EMFTextSDKPlugin.logError("Exception while saving resource.", e);
		}
	}
}

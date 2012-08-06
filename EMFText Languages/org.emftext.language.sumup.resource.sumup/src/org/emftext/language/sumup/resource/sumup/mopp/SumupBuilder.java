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
package org.emftext.language.sumup.resource.sumup.mopp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.sumup.Sheet;
import org.emftext.language.sumup.codegen.Main;
import org.emftext.language.sumup.resource.sumup.ISumupBuilder;

public class SumupBuilder implements ISumupBuilder {

	public boolean isBuildingNeeded(URI uri) {
		if (uri.toString().endsWith("evaluated.sumup") || isBinaryResource(uri)) {
			return false;
		}
		return true;
	}

	private boolean isBinaryResource(URI uri) {
		for (String segment : uri.segments()) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}

	public IStatus build(SumupResource resource, IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		if (resource.getErrors().isEmpty()
				&& resource.getContents().size() == 1
				&& resource.getContents().get(0) instanceof Sheet) {
			Sheet sheet = (Sheet) resource.getContents().get(0);
			generateJavaCode(sheet);
			/*
			boolean changes = evaluateSheet(sheet);
			if (changes && resource.getErrors().isEmpty()) {
 				URI outUri = resource.getURI().trimFileExtension();
				outUri = outUri.appendFileExtension("evaluated.sumup");
				SumupResource out = (SumupResource) resource.getResourceSet()
						.createResource(outUri);
				out.getContents().add(resource.getContents().get(0));
				try {
					out.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private void generateJavaCode(Sheet sheet) {
		try {
			generate(sheet.eResource().getURI(), "src", new Main());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void generate(URI model, String folder, AbstractAcceleoGenerator generator) throws IOException, CoreException {
		IResource member = getResourceInWorkspace(model);
		if (member == null) {
			return;
		}
		File targetFolder = getTargetFolder(member.getParent());
		List<String> arguments = new ArrayList<String>();
		arguments.add(model.trimFileExtension().lastSegment());
		arguments.add(getTargetPackage(model));
		generator.initialize(model, targetFolder, arguments);
		generator.doGenerate(null);
		member.getParent().refreshLocal(2, null);
	}

	private File getTargetFolder(IResource member) {
		File targetFolder =  new File(member.getRawLocation().toOSString());
		return targetFolder;
	}

	private IResource getResourceInWorkspace(URI model) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String platformString = model.toPlatformString(true);
		IResource member = root.findMember(platformString);
		return member;
	}

	private String getTargetPackage(URI model) {
		URI folderURI = model.trimSegments(1);
		String[] segments = folderURI.segments();
		String targetPackage = segments[segments.length - 1];
		for (int i = segments.length - 2; i >= 0; i--) {
			String segment = segments[i];
			if ("src".equals(segment)) {
				break;
			}
			targetPackage = segment + "." + targetPackage;
		}
		return targetPackage;
	}

	private boolean evaluateSheet(Sheet sheet) {
		if (sheet.getComputations().size() > 0) {
			// TODO invoke petrinets evaluation
			return true;
		}
		return false;
	}
}

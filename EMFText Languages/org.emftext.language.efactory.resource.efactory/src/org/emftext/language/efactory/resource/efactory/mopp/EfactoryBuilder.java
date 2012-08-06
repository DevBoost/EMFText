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
package org.emftext.language.efactory.resource.efactory.mopp;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.EfactoryEProblemType;

public class EfactoryBuilder implements org.emftext.language.efactory.resource.efactory.IEfactoryBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.efactory.resource.efactory.mopp.EfactoryResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getErrors().size() == 0) {
			EList<EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				EObject rootObject = contents.get(0);
				if (rootObject instanceof Factory) {
					Factory factory = (Factory) rootObject;
					Builder builder = new Builder();
					Map<EObject, String> problems = new LinkedHashMap<EObject, String>();
					List<EObject> roots = builder.build(factory, problems );
					URI xmiURI = resource.getURI().trimFileExtension().appendFileExtension("xmi");
					Resource xmiResource = new ResourceSetImpl().createResource(xmiURI);
					xmiResource.getContents().addAll(roots);
					try {
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
						xmiResource.save(options);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					for (Entry<EObject, String> problem : problems.entrySet()) {
						resource.addError(problem.getValue(), EfactoryEProblemType.BUILDER_ERROR, problem.getKey());
					}
				}
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}

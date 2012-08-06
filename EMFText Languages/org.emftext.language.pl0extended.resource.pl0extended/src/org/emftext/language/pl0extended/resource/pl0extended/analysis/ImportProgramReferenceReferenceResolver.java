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
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0extended.Import;
import org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult;

public class ImportProgramReferenceReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.Import, org.emftext.language.pl0.Program> {

	private Pl0extendedDefaultResolverDelegate<Import, Program> delegate = new Pl0extendedDefaultResolverDelegate<Import, Program>();
	
	
	public void resolve(String identifier, Import container, EReference reference, int position, boolean resolveFuzzy, final IPl0extendedReferenceResolveResult<Program> result) {
		try{
			ResourceSet rs = container.eResource().getResourceSet();
			URI uri = URI.createURI(identifier);
			Resource importResource = rs.getResource(uri, true);
			EObject root = importResource.getContents().get(0);
			if(root instanceof Program || resolveFuzzy){
				result.addMapping(identifier, (Program) root);
			}
		} catch (Exception e) {
			result.setErrorMessage("Import '" + identifier + "' doesn't reference a valid PL/0 file.");
		}
	}

	public String deResolve(Program element, Import container, EReference reference) {
		Resource resource = element.eResource();
		if(resource != null){
			URI uri = resource.getURI();
			return uri.toString();
		}
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}

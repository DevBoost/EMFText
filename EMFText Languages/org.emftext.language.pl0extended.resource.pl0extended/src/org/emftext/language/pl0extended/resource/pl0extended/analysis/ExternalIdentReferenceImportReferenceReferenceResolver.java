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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0extended.Import;
import org.emftext.language.pl0extended.ProgramWithImports;

public class ExternalIdentReferenceImportReferenceReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0extended.Import> {

	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0extended.Import> result) {
		try{
			EObject root = EcoreUtil.getRootContainer(container);
			if(root instanceof ProgramWithImports){
				ProgramWithImports program = (ProgramWithImports) root;
				List<Import> imports = program.getImports();
				for (Import import1 : imports) {
					Program referencedProgram = import1.getProgramReference();
					if(referencedProgram.getName().equals(identifier) || resolveFuzzy){
						result.addMapping(identifier, import1);
					}
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("'" + identifier + "' doesn't reference an imported PL/0 file.");
		}
	}

	public java.lang.String deResolve(org.emftext.language.pl0extended.Import element, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getProgramReference().getName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}

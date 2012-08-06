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

import java.util.LinkedList;
import java.util.List;

import org.emftext.language.pl0.ConstDeclaration;

public class ExternalIdentReferenceReferencedDeclarationReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.ConstDeclaration> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0.ConstDeclaration> result) {
		try {
			List<ConstDeclaration> declarations = new LinkedList<ConstDeclaration>();
			declarations.addAll(container.getImportReference().getProgramReference().getBlock().getConstants());
			for (ConstDeclaration declaration : declarations) {
				if(declaration.getName().equals(identifier) || resolveFuzzy){
					container.setIdent(declaration);
					result.addMapping(identifier, declaration);
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("Import '" + container.getImportReference().getProgramReference().getName() + "' doesn't contain a declaration with identifier '" + identifier + "'");
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.pl0.ConstDeclaration element, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}

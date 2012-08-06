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
package org.emftext.language.formsextension.resource.formsextension.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.formsextension.ExtendedForm;
import org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolveResult;
import org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolver;
import org.emftext.language.formsextension.resource.formsextension.util.FormsextensionEObjectUtil;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersPackage;

public class ExtendedFormJavaMethodReferenceResolver
		implements IFormsextensionReferenceResolver<ExtendedForm, ClassMethod> {

	public void resolve(
			String identifier,
			ExtendedForm container,
			EReference reference,
			int position,
			boolean resolveFuzzy,
			IFormsextensionReferenceResolveResult<ClassMethod> result) {
		
		CompilationUnit cUnit = container.getCompilationUnit();
		
		Collection<ClassMethod> allMethods = FormsextensionEObjectUtil.getObjectsByType(
				cUnit.eAllContents(), 
				MembersPackage.eINSTANCE.getClassMethod());
		
		for (ClassMethod method : allMethods) {
			if (resolveFuzzy) {
				result.addMapping(method.getName(), method);
			} else if (identifier.equals(method.getName())) {
				result.addMapping(identifier, method);
				return;
			}
		}
	}

	public String deResolve(ClassMethod method, ExtendedForm container, EReference reference) {
		return method.getName();
	}

	public void setOptions(java.util.Map<?, ?> options) {
	}
}

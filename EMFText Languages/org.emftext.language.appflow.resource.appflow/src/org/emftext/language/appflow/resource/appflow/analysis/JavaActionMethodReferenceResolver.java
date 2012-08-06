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
package org.emftext.language.appflow.resource.appflow.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;

public class JavaActionMethodReferenceResolver implements org.emftext.language.appflow.resource.appflow.IAppflowReferenceResolver<org.emftext.language.appflow.actions.JavaAction, org.emftext.language.java.members.Method> {
	
	public void resolve(String identifier, org.emftext.language.appflow.actions.JavaAction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.appflow.resource.appflow.IAppflowReferenceResolveResult<org.emftext.language.java.members.Method> result) {
		
		int lastDot = identifier.lastIndexOf(".");
		if (lastDot < 0) {
			return;
		}
		String className = identifier.substring(resolveFuzzy ? 1 : 0, lastDot);
		String methodName = identifier.substring(lastDot + 1, identifier.length());
		
		ResourceSet resourceSet = container.eResource().getResourceSet();
		JavaClasspath classpath = JavaClasspath.get(container);
		EObject classifier = classpath.getClassifier(className);
		//System.out.println("JavaActionMethodReferenceResolver.resolve()" + classpath.getURIMap());
		if (classifier.eIsProxy()) {
			classifier = EcoreUtil.resolve(classifier, container);
		}
		if (classifier.eIsProxy()) {
			return;
		}
		if (classifier instanceof org.emftext.language.java.classifiers.Class) {
			org.emftext.language.java.classifiers.Class foundClass = (org.emftext.language.java.classifiers.Class) classifier;
			for (Member member : foundClass.getMembers()) {
				if (member instanceof Method) {
					Method method = (Method) member;
					if (methodName.equals(method.getName()) || resolveFuzzy) {
						result.addMapping(className + "." + method.getName(), method);
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
		}
	}
	
	public String deResolve(org.emftext.language.java.members.Method element, org.emftext.language.appflow.actions.JavaAction container, org.eclipse.emf.ecore.EReference reference) {
		String methodName = element.getName();
		String className = element.getContainingConcreteClassifier().getName();
		String packageName = element.getContainingCompilationUnit().getNamespacesAsString();
		return packageName + className + "." + methodName;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

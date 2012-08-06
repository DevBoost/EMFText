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
package org.emftext.language.java.ejava.resource.ejava.mopp;

import java.io.OutputStream;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EObjectInstantiation;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.resource.ejava.IEjavaTextResource;
import org.emftext.language.java.ejava.resource.ejava.grammar.EjavaFormattingElement;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;

/**
 * A printer that prints EJava specific elements to corresponding
 * Java code by using information from the GenModel.
 *
 */
public class PlainJavaEjavaPrinter extends EjavaPrinter2 {

	public PlainJavaEjavaPrinter(OutputStream o, IEjavaTextResource resource) {
		super(o, resource);
	}

	@Override
	protected void doPrint(EObject element,
			List<EjavaFormattingElement> foundFormattingElements) {

		if (element instanceof EObjectInstantiation) {
			printEObjectInstantiation((EObjectInstantiation) element, foundFormattingElements);
			return;
		}
		super.doPrint(element, foundFormattingElements);
	}

	public void printEObjectInstantiation(EObjectInstantiation element, List<EjavaFormattingElement> foundFormattingElements) {
		StringBuilder out = new StringBuilder();
		TypeReference typeReference = element.getTypeReference();
		if(typeReference == null) {
			return;
		}
		Type type = typeReference.getTarget();

		if(!(type instanceof EClassifierWrapper)) {
			out.append("/* Can only instantiate EObjects */");
			return;
		}

		EClassifierWrapper classifierWrapper = (EClassifierWrapper) type;
		EPackageWrapper packageWrapper = (EPackageWrapper) classifierWrapper.eContainer();

		out.append(packageWrapper.getGenPackage().getBasePackage());
		out.append(".");
		out.append(packageWrapper.getEPackage().getName());
		out.append(".");
		out.append(packageWrapper.getGenPackage().getFactoryName());
		out.append(".eINSTANCE.create");
		out.append(classifierWrapper.getEClassifier().getName());
		out.append("()");
		tokenOutputStream.add(new PrintToken(out.toString(), "<UNKNOWN>", element));
	}
}

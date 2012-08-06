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
package org.emftext.language.eocl.staticsemantics.provider;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessor;
import org.emftext.language.eocl.resource.eocl.mopp.EoclResource;

import tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl;
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemanticsException;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.postporcessor.OclStaticSemanticsProvider;
import tudresden.ocl20.pivot.pivotmodel.Constraint;

public class EOclStaticSemanticsPostProcessor implements
		IEoclResourcePostProcessor {

	public void process(EoclResource resource) {
		EList<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			EObject root = contents.get(0);

			try {

				tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemantics oclStaticSemantics = OclStaticSemanticsProvider
						.getStaticSemantics(resource);

				List<Constraint> result = oclStaticSemantics.cs2EssentialOcl(root);

				printResult(result);

			} catch (OclStaticSemanticsException e) {
				e.printStackTrace();
			}
		}

	}

	private void printResult(List<Constraint> result) {
		System.out.println();
		for (Constraint constraint : result) {
			printConstraint(constraint);
		}
	}

	private void printConstraint(Constraint constraint) {
		System.out.print(constraint.getConstrainedElement() + "   ");
		System.out.print(constraint.getName());
		System.out.println("(" + constraint.getKind() + ")");
		printExpression((ExpressionInOcl) constraint.getSpecification());
	}

	private void printExpression(ExpressionInOcl specification) {
		printBodyExpression(specification.getBodyExpression());
	}

	private void printBodyExpression(OclExpression bodyExpression) {
		System.out.println(bodyExpression);
	}
}

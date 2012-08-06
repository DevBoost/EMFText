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
package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.eag.interpreter.impl.ComputationContext;

public class ValueReference implements IReference {
	
	private ComputationContext context;

	public ValueReference(ComputationContext context) {
		super();
		this.context = context;
	}

	public void setTarget(Object newValue) {
		context.setResult(newValue);
	}

	public Object getTarget() {
		return context.getResult();
	}

	public IReference getReference(EStructuralFeature feature) {
		Object result = context.getResult();
		assert result != null;
		assert result instanceof EObject;
		EObject eResult = (EObject) result;
		return ReferenceFactory.INSTANCE.createReference(eResult.eGet(feature));
	}
}

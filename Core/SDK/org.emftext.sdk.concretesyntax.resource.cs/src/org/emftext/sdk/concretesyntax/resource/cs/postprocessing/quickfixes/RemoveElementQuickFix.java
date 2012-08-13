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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.quickfixes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix;

/**
 * A quick fix that removes an option form a concrete syntax specification.
 * This fix can be used for duplicate options.
 */
public class RemoveElementQuickFix extends CsQuickFix implements ICsQuickFix {

	private EObject objectToRemove;

	public RemoveElementQuickFix(String message, EObject objectToRemove) {
		super(message, "IMG_ETOOL_DELETE", objectToRemove);
		this.objectToRemove = objectToRemove;
	}

	@Override
	public void applyChanges() {
		EcoreUtil.delete(objectToRemove);
	}
}

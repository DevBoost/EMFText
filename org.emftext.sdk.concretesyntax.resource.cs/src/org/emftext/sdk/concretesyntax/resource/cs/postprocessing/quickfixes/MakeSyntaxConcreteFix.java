/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.quickfixes;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix;

public class MakeSyntaxConcreteFix extends CsQuickFix {

	private ConcreteSyntax syntax;

	public MakeSyntaxConcreteFix(ConcreteSyntax syntax) {
		super("Remove modifier ABSTRACT", "IMG_ETOOL_DELETE", syntax);
		this.syntax = syntax;
	}

	public void applyChanges() {
		syntax.setAbstract(false);
	}
}
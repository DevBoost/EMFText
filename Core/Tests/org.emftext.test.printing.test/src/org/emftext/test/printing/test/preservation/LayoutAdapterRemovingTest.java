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
package org.emftext.test.printing.test.preservation;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.test.printing.resource.printing.mopp.PrintingResourceFactory;

public class LayoutAdapterRemovingTest extends
		AbstractLayoutPreservationTestCase {

	@Override
	protected Resource.Factory selectResourceFactory() {
		return new PrintingResourceFactory();
	}
	
	@Override
	protected void doAfterParsing(EObject root) {
		//manually remove all adapters
		root.eAdapters().clear();
		for (Iterator<EObject> i = root.eAllContents(); i.hasNext();) {
			i.next().eAdapters().clear();
		}
	}

	@Override
	protected boolean noLayoutExpected() {
		return true;
	}

}

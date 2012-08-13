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
import org.emftext.test.printing.modellayout.ElementWithModelLayout;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutResourceFactory;
import org.emftext.test.printing.modellayout.resource.modellayout.util.ModellayoutLayoutUtil;

public class ModelLayoutPreservationTest extends
		AbstractLayoutPreservationTestCase {

	@Override
	protected Resource.Factory selectResourceFactory() {
		return new ModellayoutResourceFactory();
	}
	@Override
	protected void doAfterParsing(EObject root) { 
		//no layout information from adapters are expected after loading, but in the model
		assertTrue("Did not expect any layout information in adapters.", 
				new ModellayoutLayoutUtil().getLayoutInformationAdapter(root).getLayoutInformations().isEmpty());
		assertTrue(root instanceof ElementWithModelLayout);
		assertFalse(((ElementWithModelLayout) root).getLayout().isEmpty());
		
		for (Iterator<EObject> i = root.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			assertTrue("Did not expect any layout information in adapters.", 
					new ModellayoutLayoutUtil().getLayoutInformationAdapter(next).getLayoutInformations().isEmpty());
			assertTrue(next instanceof ElementWithModelLayout);
			assertFalse(((ElementWithModelLayout) next).getLayout().isEmpty());
		}
	}

	@Override
	protected boolean noLayoutExpected() {
		return false;
	}

}

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
package org.emftext.test.printing.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.test.printing.modellayout.M1;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutResourceFactoryDelegator;
import org.emftext.test.printing.resource.printing.mopp.PrintingMetaInformation;

public class ModelLayoutModificationTest extends AbstractPrintingTestCase {

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new PrintingMetaInformation().getSyntaxName(),
				new ModellayoutResourceFactoryDelegator());
	}
	
	public void testT1() {
		M1 m1 = (M1) parse("m1");

		assertEquals("", m1.getLayout().get(0).getHiddenTokenText());
		
		assertPrinting(m1, 
				"m1", 
				"m1", 
				false
			);
		
		assertEquals("", m1.getLayout().get(0).getHiddenTokenText());
		m1.getLayout().get(0).setHiddenTokenText("   ");
		
		assertPrinting(m1, 
				"   m1", 
				"   m1", 
				false
			);
		
		//layout information should be copied
		M1 m1Copy = EcoreUtil.copy(m1); 
		
		assertPrinting(m1Copy, 
				"   m1", 
				"   m1", 
				false
			);
		
		
	}
}

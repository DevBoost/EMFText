/*******************************************************************************
 * Copyright (c) 2006-2013
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

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.test.printing.resource.printing.IPrintingOptions;
import org.emftext.test.printing.resource.printing.mopp.PrintingResourceFactory;

public class LayoutRecordingOption1Test extends
		AbstractLayoutPreservationTestCase {
	
	@Override
	protected Resource.Factory selectResourceFactory() {
		return new PrintingResourceFactory();
	}
	
	@Override
	protected void doAfterParsing(EObject root) {
	}

	@Override
	protected boolean noLayoutExpected() {
		//layout recording is turned of by the option
		return true;
	}

	@Override
	protected Map<?, ?> getOptions() {
		return Collections.singletonMap(IPrintingOptions.DISABLE_LAYOUT_INFORMATION_RECORDING, true);
	}
}

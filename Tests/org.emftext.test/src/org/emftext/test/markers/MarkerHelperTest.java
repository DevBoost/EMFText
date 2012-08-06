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
package org.emftext.test.markers;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper;

/**
 * A test that was originally designed to test whether performance improvements
 * to the MarkerHelper class work as expected. However, we discovered that we
 * must create Annotations instead of Markers for temporary problems that are
 * detected while editing text resources. Markers must only be created when a
 * resource is saved.
 */
public class MarkerHelperTest extends TestCase {

	public void testMarkerCompaction() {
		final FileMock fileMock = new FileMock();
		
		CsMarkerHelper helper = new CsMarkerHelper() {
			
			@Override
			protected IFile getFile(Resource resource) {
				return fileMock;
			}
		};
		
		// start marker update transaction
		helper.beginDeferMarkerUpdates();
		// add same marker twice
		addMarker(helper);
		addMarker(helper);
		// end marker update transaction
		helper.endDeferMarkerUpdates();
		// run commands (usually this is done asynchronously)
		helper.runCommands();
		
		List<MarkerMock> markers = fileMock.getMarkers();
		assertEquals(2, markers.size());
	}

	private void addMarker(CsMarkerHelper helper) {
		ICsTextDiagnostic diagnostic = new DiagnosticMock("message", 1, 2, 3, 4);
		helper.mark(null, diagnostic);
	}
}

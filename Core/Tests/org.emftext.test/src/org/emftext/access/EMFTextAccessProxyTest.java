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
package org.emftext.access;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.access.resource.IColorManager;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.access.resource.INewFileContentProvider;
import org.emftext.access.resource.IParseResult;
import org.emftext.access.resource.IParser;
import org.emftext.access.resource.IPrinter;
import org.emftext.access.resource.IResource;
import org.emftext.access.resource.IScanner;
import org.emftext.access.resource.IToken;
import org.emftext.access.resource.IUIMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAntlrScanner;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocationMap;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsNewFileContentProvider;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParser;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPrinter;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTextToken;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIMetaInformation;
import org.junit.Test;

/**
 * Tests the EMFTextAccessProxy class.
 */
public class EMFTextAccessProxyTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testInvokeDeprecatedMethod() {
		Resource resource = new CsResourceFactory().createResource(null);
		IResource genericResource = EMFTextAccessProxy.get(resource, IResource.class);
		// invoke deprecated method
		genericResource.cancelReload();
	}
	
	@Test
	public void testIsAccessibleWith() {
		assertIsAccessible(CsColorManager.class, IColorManager.class);
		assertIsAccessible(CsResource.class, IResource.class);
		assertIsAccessible(CsEditor.class, IEditor.class);
		assertIsAccessible(CsLocationMap.class, ILocationMap.class);
		assertIsAccessible(CsMetaInformation.class, IMetaInformation.class);
		assertIsAccessible(CsUIMetaInformation.class, IUIMetaInformation.class);
		assertIsAccessible(CsNewFileContentProvider.class, INewFileContentProvider.class);
		assertIsAccessible(CsParser.class, IParser.class);
		assertIsAccessible(CsParseResult.class, IParseResult.class);
		assertIsAccessible(CsPrinter.class, IPrinter.class);
		assertIsAccessible(CsAntlrScanner.class, IScanner.class);
		assertIsAccessible(CsTextToken.class, IToken.class);
	}

	private void assertIsAccessible(Class<?> clazz, Class<?> interfaze) {
		assertTrue("Class " + clazz.getSimpleName() + " must be accessible via interface " + interfaze.getSimpleName(), EMFTextAccessProxy.isAccessibleWith(clazz, interfaze));
	}
}

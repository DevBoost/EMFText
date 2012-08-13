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
package org.emftext.test.tokenaccess;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.resource.IColorManager;
import org.emftext.access.resource.IUIMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;

// Run me as JUnit-Plugin Test
public class GetHighlighting extends TestCase {

	public void testReadTokens() {
		EMFTextAccessPlugin.registerConcreteSyntax(new CsMetaInformation());

		List<IUIMetaInformation> concreteSyntaxRegistry = EMFTextAccessPlugin.getUIPluginRegistry();

		boolean foundCsLanguage = false;
		for (IUIMetaInformation metaInformation : concreteSyntaxRegistry) {
			if (metaInformation.getSyntaxName().equals("cs")) {
				IColorManager colorManager = metaInformation.createColorManager();
				ITokenScanner scanner = metaInformation.createTokenScanner(null, colorManager);
				String text = "SYNTAXDEF as FOR <http:://example> START A RULES { A ::= \"a\"; }";
				Document document = new Document();
				document.set(text);
				scanner.setRange(document, 0, text.length());

				IToken nextToken = scanner.nextToken();
				while (nextToken != null && !nextToken.isEOF()) {
					System.out.println("TOKEN " + nextToken.getData());
					nextToken = scanner.nextToken();
				}
				colorManager.dispose();
				foundCsLanguage = true;
			}
		}
		assertTrue("CS language was not found.", foundCsLanguage);
	}
}

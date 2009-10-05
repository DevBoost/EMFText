package org.emftext.test.tokenaccess;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.resource.IColorManager;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;

// Run me as JUnit-Plugin Test
public class GetHighlighting extends TestCase {

	public void testReadTokens() {
		EMFTextAccessPlugin.registerConcreteSyntax(new CsMetaInformation());

		List<IMetaInformation> concreteSyntaxRegistry = EMFTextAccessPlugin.getConcreteSyntaxRegistry();
		
		for (IMetaInformation metaInformation : concreteSyntaxRegistry) {
			if (metaInformation.getSyntaxName().equals("cs")) {
				IColorManager colorManager = metaInformation.createColorManager();
				ITokenScanner scanner = metaInformation.createTokenScanner(colorManager);
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
			}
		}
	}
}

package org.emftext.sdk.codegen.generators;

import java.io.File;

import junit.framework.TestCase;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for class NewFileContentGenerator.
 */
public class NewFileContentGeneratorTest extends TestCase {

	@Before
	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
	}
	
	@Test
	public void testContentGenerator() {
		assertContent(
			"content.cs",
			"ROOT {" + NewFileWizardGenerator.LINE_BREAK + "CHILD (0, someChildAString, A) identifier" + NewFileWizardGenerator.LINE_BREAK + "}"
		);
		assertContent(
			"content2.cs",
			"ROOT \"someRootQuotedAttribute\""
		);
	}

	private void assertContent(String filename, String expectedContent) {
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "sdk" + File.separator + "codegen" + File.separator + "generators" + File.separator;
		File file = new File(path + filename);
		
		// load syntax
		ITextResource resource = new TextResourceHelper().getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		ConcreteSyntax syntax = (ConcreteSyntax) resource.getContents().get(0);
		NewFileWizardGenerator nfcg = new NewFileWizardGenerator(new GenerationContext(syntax, null) {

			@Override
			public File getPluginProjectFolder() {
				return null;
			}

			@Override
			public String getProjectRelativePathToSyntaxFile() {
				return null;
			}

			@Override
			public String getSyntaxProjectName() {
				return null;
			}
		});
		String result = nfcg.getExampleDocument();
		System.out.println("testContentGenerator() => \"" + result + "\"");
		assertEquals(expectedContent, result);
	}
}

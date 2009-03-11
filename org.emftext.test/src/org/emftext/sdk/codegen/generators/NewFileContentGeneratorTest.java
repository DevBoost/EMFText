package org.emftext.sdk.codegen.generators;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

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
		// load syntax
		String filename = "content.cs";
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "sdk" + File.separator + "codegen" + File.separator + "generators" + File.separator;
		File file = new File(path + filename);
		
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
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(buffer);
		boolean success = nfcg.generate(out);
		assertTrue(success);
		String result = buffer.toString();
		System.out.println("testContentGenerator() => \"" + result + "\"");
		assertEquals("ROOT {" + NewFileWizardGenerator.LINE_BREAK + "CHILD (0, value, A) identifier" + NewFileWizardGenerator.LINE_BREAK + "}", result);
	}
}

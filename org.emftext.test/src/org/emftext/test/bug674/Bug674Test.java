package org.emftext.test.bug674;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;

import junit.framework.TestCase;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.analysis.GenModelAnalyser;
import org.junit.Before;
import org.junit.Test;

public class Bug674Test extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testBug674() {
		final String filename = "YggdrasilComponents.cs";
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "bug674" + File.separator;
		File file = new File(path + filename);
		
		ITextResource resource = new TextResourceHelper().getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		assertEquals(1, resource.getErrors().size());
		String errorMessage = resource.getErrors().get(0).getMessage();
		assertEquals(GenModelAnalyser.INVALID_GENMODEL_MESSAGE, errorMessage);
	}
}

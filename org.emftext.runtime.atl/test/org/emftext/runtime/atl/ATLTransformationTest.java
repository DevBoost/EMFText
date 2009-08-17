package org.emftext.runtime.atl;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.ecore.resource.text.TextEcoreResourceFactory;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory;
import org.junit.Before;

public class ATLTransformationTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new TextEcoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cs",
				new CsResourceFactory());

	}

	public void testTransformationResult() throws Exception {

		String testfile = "platform:/resource/org.emftext.runtime.atl/model/example.cs";
		loadResourceWithProcessor(testfile);
		
		String outfile = "platform:/resource/org.emftext.runtime.atl/model/example.out.cs";
		Resource outResource = loadResource(outfile);
		assertEquals(1, outResource.getContents().size());
		assertEquals("wasHere", ((ConcreteSyntax) outResource.getContents().get(0) ).getName());
		
	}
	
	private Resource loadResource(String grammar) throws IOException {
		URI fileUri = URI.createURI(grammar);

		ResourceSet rs = new ResourceSetImpl();
		Resource csResource = rs.getResource(fileUri, true);
		return csResource;
	}

	private Resource loadResourceWithProcessor(String grammar) throws IOException {
		URI fileUri = URI.createURI(grammar);

		ResourceSet rs = new ResourceSetImpl();

		ATLTransformationPostProcessor transformationPostProcessor = new TestTransformationPostProcessor();
		rs.getLoadOptions().putAll(transformationPostProcessor.getOptions());
		Resource csResource = rs.getResource(fileUri, true);
		return csResource;
	}
}

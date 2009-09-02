package org.emftext.test.bug856;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This is a test case for bug 856 (Syntaxes that import theirself 
 * cause a StackOverflowError when opened in the editor). It loads 
 * a .cs file containing a self import and checks the result.
 */
public class Bug856Test extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}
	
	public void testPrefixReprinting() {
		String path = "./src/org/emftext/test/bug856/main.cs";
		File file = new File(path);
		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
			EcoreUtil.resolveAll(resource);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}

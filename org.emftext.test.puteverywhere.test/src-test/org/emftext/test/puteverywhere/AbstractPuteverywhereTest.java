package org.emftext.test.puteverywhere;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.test.puteverywhere.Root;

public class AbstractPuteverywhereTest extends TestCase {
	
	protected Root loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		Root cUnit = tryToLoadResource(inputStream, fileIdentifier);
		assertNotNull(cUnit);
		assertSuccessfulParsing(cUnit.eResource());
		return cUnit;
	}

	protected Root tryToLoadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		PuteverywhereResourceImplTestWrapper resource = new PuteverywhereResourceImplTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to Root.",
				content instanceof Root);
		Root cUnit = (Root) content;
		return cUnit;
	}

	private void assertSuccessfulParsing(Resource resource) {
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage());
		}
	}
}

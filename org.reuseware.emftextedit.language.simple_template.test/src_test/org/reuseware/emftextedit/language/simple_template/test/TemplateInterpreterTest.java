package org.reuseware.emftextedit.language.simple_template.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.reuseware.emftextedit.language.simple_template.Template;
import org.reuseware.emftextedit.language.simple_template.interpreter.SimpleTemplateInterpreter;
import org.reuseware.emftextedit.language.simple_template.interpreter.SimpleTemplateInterpreterImpl;
import org.reuseware.emftextedit.language.simple_template.resource.simpletemplate.SimpletemplateResourceImpl;

public class TemplateInterpreterTest {
	
	@Test
	public void testInterpreter() {
		String templateFile = "example.simpletemplate";
		Resource resource = null;
		try {
			resource = load(templateFile);
		} catch (IOException e) {
			// if the file can not be found, the working directory of
			// the test is probably wrong
			fail(e.getMessage());
		}
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertNotNull(content);
		assertTrue("File '" + templateFile + "' was parsed to Template.",
				content instanceof Template);
		Template template = (Template) content;
		assertNotNull(template);
		// pass template to interpreter
		SimpleTemplateInterpreter interpreter = new SimpleTemplateInterpreterImpl();
		EObject result = interpreter.interprete(template, null);
		// TODO mboehme: check whether the template was instantiated correctly
	}

	private Resource load(String templateFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		InputStream inputStream = new FileInputStream(templateFile);
		SimpletemplateResourceImpl resource = new SimpletemplateResourceImpl();
		resource.doLoad(inputStream, options);
		inputStream.close();
		return resource;
	}
}

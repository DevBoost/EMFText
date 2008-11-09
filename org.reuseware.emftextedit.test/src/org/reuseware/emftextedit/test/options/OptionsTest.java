package org.reuseware.emftextedit.test.options;

import static org.junit.Assert.assertNotNull;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;
import org.reuseware.emftextedit.runtime.MetamodelManager;
import org.reuseware.emftextedit.sdk.GenPackageByNameFinder;

public class OptionsTest {
	@Before
	public void setUp() {
		MetamodelManager.INSTANCE
				.addGenPackageFinder(new GenPackageByNameFinder());
		registerResourceFactories();
	}

	@Test
	public void testOptions() throws FileNotFoundException, IOException {
		String path = "src\\org\\reuseware\\emftextedit\\test\\options\\options.cs";
		String absolutePath = new File(path).getAbsolutePath();
		URI fileURI = URI.createFileURI(absolutePath);
		File result = generateANTLRGrammarToTempFile(fileURI, true);
		assertNotNull(result);
	}
}

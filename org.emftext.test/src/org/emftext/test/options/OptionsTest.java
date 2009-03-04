/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.test.options;

import static org.emftext.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.finders.GenPackageByNameFinder;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for using the various code generation options provided
 * by EMFText.
 */
public class OptionsTest {
	
	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testOptions() throws FileNotFoundException, IOException {
		String path = "src\\org\\emftext\\test\\options\\options.cs";
		String absolutePath = new File(path).getAbsolutePath();
		URI fileURI = URI.createFileURI(absolutePath);
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, new GenPackageByNameFinder());

		File result = generateANTLRGrammarToTempFile(fileURI, options);
		assertNotNull(result);
	}
}

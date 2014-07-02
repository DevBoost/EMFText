/*******************************************************************************
 * Copyright (c) 2006-2014
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.code_completion.test.util;

import java.io.File;
import java.io.FileFilter;

public class TestFileFilter implements FileFilter {
	
	private final String[] validExtensions;

	public TestFileFilter(String... validExtensions) {
		super();
		this.validExtensions = validExtensions;
	}

	public boolean accept(File file) {
		boolean hasValidExtension = false;
		for (String validExtension : validExtensions) {
			hasValidExtension |= file.getName().endsWith(validExtension);
		}
		return file.isDirectory() || hasValidExtension;
	}
}

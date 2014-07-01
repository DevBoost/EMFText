package org.emftext.test.code_completion.test;

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

/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil;

/**
 * Checks whether all files have a valid license header.
 */
public class LicenseHeaderTest extends TestCase {
	
	public final static String[] EXTENSIONS = new String[] {"java"};
	public final static String[] EXCLUSION_PATTERNS_FOR_FILES = new String[] {
		"org.emftext.runtime/src",
		"org.emftext.runtime.ui/src",
		"org.emftext.sdk.antlr3_3_0/src-runtime",
		"org.emftext.commons.antlr3_1_1/src",
		"org.emftext.commons.antlr3_2_0/src",
		"org.emftext.commons.antlr3_3_0/src",
		"org.emftext.commons.antlr3_4_0/src",
		"org.emftext.language.java.resource.bcel/src-bcel/",
		"org.emftext.sdk.antlr/src-activator",
		"org.emftext.sdk.antlr/src-runtime", 
		"org.emftext.sdk.antlr/src-sdk", 
		"org.emftext.sdk.antlr3_2_0/src-activator",
		"org.emftext.sdk.antlr3_2_0/src-sdk", 
		"org.emftext.sdk.antlr3_2_0/src-runtime", 
		"org.emftext.sdk.antlr3_3_0/src-activator",
		"org.emftext.sdk.antlr3_3_0/src-sdk", 
		"org.emftext.sdk.antlr3_3_0/src-runtime", 
		"org.emftext.sdk.antlr3_4_0/src-sdk", 
		"org.emftext.sdk.antlr3_4_0/src-runtime", 
		"org.emftext.sdk.automaton",
		"org.emftext.runtime.antlr/src",
		"/EMFText Deprecated/",
		"/fujaba/",
		"org/emftext/antlr/Bug1492", "org/emftext/antlr/Bug1499",
		"org/emftext/antlr/Keywords", "mopp/.*Lexer.java",
		"mopp/.*Parser.java",
		"/org.eclipse.e4.tm/",
		"/org.eclipse.pde.visualization.dependency/",
		"/Misc/GrammarBasedReuseware/",
		"/Misc/JaMoPP GMF Editor/",
		"/Misc/Tornado/",
		"/Reuseware/Experimental/",
		"EMFText Incubation",
		"org.emftext.language.java.simTL4J",
		"Refactoring/CBR",
		"org.reuseware.air.*/src",
		"es.tid.cim.*/src",
		"/org.emftext.language.java/metamodel/java.newfile.java",
		"/org.emftext.language.java.test/output/",
		"/EMFTextTest/",
		"/org.reuseware.application.ticketshop.test/out.*",
		"/org.reuseware.application.reusejava/out/",
		"/org.reuseware.application.classweaving/out/",
		"/org.reuseware.application.uml2java/out/",
		"/org.emftext.language.formular.generator/src-gen/generator/",
		"/org.emftext.language.forms.generator/src-gen/generator/",
		"/EclipseDemoCamp/src/",
		"/org.emftext.language.lwc11.doc/listings/"
	};
	public final static String[] EXCLUDED_DIRECTORIES = new String[] {
		"bin"
	};

	private List<File> invalidFiles = new ArrayList<File>();
	private List<File> validFiles = new ArrayList<File>();

	public void testHeaders() {
		File rootDir = new File("..");
		List<String> validHeaders = readValidHeaders();
		assertTrue("There must be at least one valid header.", validHeaders.size() > 0);
		checkDirectory(rootDir, validHeaders);
		
		for (File file : invalidFiles) {
			System.out.println("Can't find valid license header in file " + file.getAbsolutePath());
		}

		int validCount = validFiles.size();
		assertTrue("There must be at least 100 valid files, but there were " + validCount + ".", validCount > 100);
		assertTrue("There must not be files without valid license header.", invalidFiles.isEmpty());
	}

	private List<String> readValidHeaders() {
		List<String> validHeaders = new ArrayList<String>();
		File headerDir = new File("validHeaders");
		File[] headerFiles = headerDir.listFiles();
		for (File headerFile : headerFiles) {
			if (headerFile.isDirectory()) {
				continue;
			}
			String content = getContent(headerFile);
			validHeaders.add(content);
		}
		return validHeaders;
	}

	private String normalize(String content) {
		content = content.replace("\r\n", "\n");
		content = content.replace("\r", "\n");
		content = content.replace(" ", "");
		return content;
	}

	private void checkDirectory(File dir, List<String> validHeaders) {
		File[] validFiles = getValidFiles(dir);
		for (File validFile : validFiles) {
			assertHasValidHeader(validFile, validHeaders);
		}
		File[] subDirs = getSubDirectories(dir);
		for (File subDir : subDirs) {
			checkDirectory(subDir, validHeaders);
		}
	}

	private void assertHasValidHeader(File file, List<String> validHeaders) {
		String content = getContent(file);
		for (String validHeader : validHeaders) {
			if (content.startsWith(validHeader)) {
				validFiles.add(file);
				return;
			}
		}
		invalidFiles.add(file);
	}

	private String getContent(File file) {
		String content = null;
		try {
			content = CsStreamUtil.getContent(new FileInputStream(file));
			content = normalize(content);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return content;
	}

	private File[] getSubDirectories(File dir) {
		FileFilter filter = new FileFilter() {
			
			public boolean accept(File file) {
				if (!file.isDirectory()) {
					return false;
				}
				for (String excludedDir : EXCLUDED_DIRECTORIES) {
					if (excludedDir.equals(file.getName())) {
						return false;
					}
				}
				return true;
			}
		};
		File[] foundFiles = dir.listFiles(filter);
		if (foundFiles == null) {
			return new File[0];
		}
		return foundFiles;
	}

	private File[] getValidFiles(File dir) {
		// find valid files in 'dir'
		FileFilter filter = new FileFilter() {
			
			public boolean accept(File file) {
				if (file.isFile()) {
					for (String exclusion : EXCLUSION_PATTERNS_FOR_FILES) {
						if (file.getAbsolutePath().replace(File.separator, "/").matches(".*" + exclusion + ".*")) {
							return false;
						}
					}
					String name = file.getName();
					for (String extension : EXTENSIONS) {
						if (name.endsWith("." + extension)) {
							return true;
						}
					}
				}
				return false;
			}
		};
		File[] foundFiles = dir.listFiles(filter);
		if (foundFiles == null) {
			return new File[0];
		}
		return foundFiles;
	}
}

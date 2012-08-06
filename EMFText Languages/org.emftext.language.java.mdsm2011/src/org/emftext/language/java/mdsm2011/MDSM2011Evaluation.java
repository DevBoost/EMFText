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
package org.emftext.language.java.mdsm2011;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.mdsm2011.qvto.FileFinder;
import org.emftext.language.java.mdsm2011.qvto.QVTOTransformationWrapper;
import org.emftext.language.java.mdsm2011.statistics.StatisticsCollector;
import org.emftext.language.java.resource.java.util.JavaStreamUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Evaluates the execution of some QVTO scripts.
 */
public class MDSM2011Evaluation {

	private static final String REMOVE_ELVIS_QVTO = "remove_elvis.qvto";
	private static final String JUNIT32JUNIT4_QVTO = "junit32junit4.qvto";
	private static final String JAVA2CLOSURE_QVTO = "java2closure.qvto";
	private static final String FOR2FOREACH_QVTO = "for2foreach.qvto";
	
	private static final String CURRENT_DIR = new File(System.getProperty("user.dir"))
			.getAbsolutePath();
	private static final String INPUT_PATH = CURRENT_DIR + File.separator + "input";
	private static final String OUTPUT_PATH = CURRENT_DIR + File.separator
			+ "output_qvto";
	private static final String QVT_SCRIPT_PATH = CURRENT_DIR + File.separator
			+ "scripts" + File.separator;

	// initializes the static collector of transformation statistics
	// as transformations are executed statically during test case
	// initialization
	// this controller needs to be static to.
	private static StatisticsCollector collector = new StatisticsCollector();

	@BeforeClass
	public static void copyInputFiles() {
		try {
			List<File> originalFiles = new FileFinder().findAllFilesInFolder(new File(INPUT_PATH), new String[] {".orig.java", ".orig.closure"}, new String[0]);
			for (File originalFile : originalFiles) {
				InputStream in = new FileInputStream(originalFile);
				File copy = new File(originalFile.getAbsolutePath().replace(".orig.", "."));
				OutputStream out = new FileOutputStream(copy);
				JavaStreamUtil.copy(in, out);
			}
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@AfterClass
	public static void testStatistics() {
		Map<String, Integer> operationCallCounts = collector
				.getOperationCalls();
		Integer loopsTotal = operationCallCounts.get("countForLoops");
		assertEquals("Loops counted do not match loops expected.", new Integer(
				6), loopsTotal);

		Integer loopReplacements = operationCallCounts
				.get("countForLoopReplacements");
		assertEquals(
				"Loops replaced do not match loops expected to be replaced.",
				new Integer(2), loopReplacements);
	}

	@Test
	public void FTest1wasTransformed() {
		assertIsTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest1", "java");
	}

	@Test
	public void FTest2wasNotTransformed() {
		assertIsNotTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest2", "java");
	}

	@Test
	public void FTest3wasNotTransformed() {
		assertIsNotTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest3", "java");
	}

	@Test
	public void FTest4wasNotTransformed() {
		assertIsNotTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest4", "java");
	}

	@Test
	public void FTest5wasTransformed() {
		assertIsTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest5", "java");
	}

	@Test
	public void FTest6wasTransformed() {
		assertIsNotTransformed(FOR2FOREACH_QVTO, "for-test1", "FTest6", "java");
	}

	@Test
	public void CTest1wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest1", "closure");
	}

	@Test
	public void CTest2wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest2", "closure");
	}

	@Test
	public void CTest3wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest3", "closure");
	}

	@Test
	public void CTest4wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest4", "closure");
	}

	@Test
	public void CTest5wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest5", "closure");
	}

	@Test
	public void CTest6wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest6", "closure");
	}

	@Test
	public void CTest7wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest7", "closure");
	}

	@Test
	public void CTest8wasNOTTransformed() {
		assertIsNotTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest8", "closure");
	}

	@Test
	public void CTest9wasTransformed() {
		assertIsTransformed(JAVA2CLOSURE_QVTO, "closure-test1", "CTest9", "closure");
	}

	@Test
	public void JUnitTest1wasTransformed() {
		assertIsTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest1", "java");
	}

	@Test
	public void JUnitTest2wasTransformed() {
		assertIsTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest2", "java");
	}

	@Test
	public void JUnitTest3wasTransformed() {
		assertIsTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest3", "java");
	}

	@Test
	public void JUnitTest4wasTransformed() {
		assertIsTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest4", "java");
	}

	@Test
	public void JUnitTest5wasNOTTransformed() {
		assertIsNotTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest5", "java");
	}

	@Test
	public void JUnitTest6wasNOTTransformed() {
		assertIsNotTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest6", "java");
	}

	@Test
	public void JUnitTest8wasNOTTransformed() {
		assertIsNotTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest8", "java");
	}

	@Test
	public void JUnitTest10wasNOTTransformed() {
		assertIsNotTransformed(JUNIT32JUNIT4_QVTO, "junit-test1", "JUnitTest10", "java");
	}

	@Test
	public void Elvis1wasTransformed() {
		assertIsTransformed(REMOVE_ELVIS_QVTO, "elvis-test", "ElvisTest1", "java");
	}

	@Test
	public void Elvis2wasTransformed() {
		assertIsTransformed(REMOVE_ELVIS_QVTO, "elvis-test", "/ElvisTest2", "java");
	}

	/**
	 * Applies a QVTO transformation to a single file in a given input 
	 * directory.
	 * 
	 * @param framework
	 *            a directory inside the input directory
	 * @throws Exception if transformation fails
	 */
	public void run(String qvtScript, String inputDir, String framework,
			File inputFile) throws Exception {
		// configure QVTO starter
		String inputFolderPath = inputDir + File.separator + framework;
		File inputFolder = new File(inputFolderPath);
		if (!inputFolder.exists()) {
			throw new RuntimeException("Path " + inputFolderPath
					+ " does not exist!");
		}
		URI inputURI = URI.createFileURI(inputFolder.getAbsoluteFile()
				.getCanonicalPath());

		String outputFolderPath = OUTPUT_PATH + File.separator + framework;
		File outputFolder = new File(outputFolderPath);
		outputFolder.mkdirs();
		URI outputURI = URI.createFileURI(outputFolder.getAbsolutePath());

		File qvtoFile = new File(QVT_SCRIPT_PATH + qvtScript);
		URI transformationFileURI = URI.createFileURI(qvtoFile
				.getCanonicalPath());

		boolean isInPlace = true;
		boolean debug = true;
		
		
		QVTOTransformationWrapper starter = new QVTOTransformationWrapper(
				inputURI, outputURI, transformationFileURI,
				isInPlace, debug, collector);

		registerLibraries(inputFolderPath, starter);
		// TODO start timer
		starter.launch(inputFile);
		// TODO end timer
	}

	private void registerLibraries(String inputFolderPath,
			QVTOTransformationWrapper starter) throws IOException {
		JavaClasspath javaClasspath = JavaClasspath.get(starter
				.getResourceSet());
		String libFolderPath = inputFolderPath + File.separator + "lib";
		File libFolder = new File(libFolderPath);
		if (!libFolder.exists()) {
			return;
		}
		for (File nextLib : libFolder.listFiles()) {
			// skip directories inside of lib directory
			if (nextLib.isDirectory()) {
				continue;
			}
			if (nextLib.getName().endsWith(".jar")) {
				URI libURI = URI.createFileURI(nextLib.getAbsolutePath());
				javaClasspath.registerClassifierJar(libURI);
			}
		}
	}

	public StatisticsCollector getStatistics() {
		return collector;
	}

	private boolean wasTransformed(String framework, String file, String extension)
			throws IOException, FileNotFoundException {
		String frameworkPath = INPUT_PATH + File.separator + framework + File.separator;
		File originalFile = new File(frameworkPath + file + ".orig." + extension);
		File transformedFile = new File(frameworkPath + file + "." + extension);
		String originalContent = JavaStreamUtil.getContent(new FileInputStream(
				originalFile));
		String transformedContent = JavaStreamUtil
				.getContent(new FileInputStream(transformedFile));

		return !(originalContent.equals(transformedContent));
	}

	private void assertIsTransformed(
			String qvtScript,
			String framework, 
			String inputFileWithoutExtension, 
			String extension) {
		assertTransformed(qvtScript, framework, inputFileWithoutExtension, extension, true);
	}

	private void assertIsNotTransformed(
			String qvtScript,
			String framework, 
			String inputFileWithoutExtension, 
			String extension) {
		assertTransformed(qvtScript, framework, inputFileWithoutExtension, extension, false);
	}

	private void assertTransformed(
			String qvtScript,
			String framework, 
			String inputFileWithoutExtension, 
			String extension, 
			boolean expected) {
		try {
			// delete output
			File inputFile = new File(INPUT_PATH + File.separator + framework + File.separator + inputFileWithoutExtension + "." + extension);
			// run transformation
			run(qvtScript, INPUT_PATH, framework, inputFile);
			// check result
			String message = inputFileWithoutExtension + " should " + (expected ? "" : "not") + " be transformed.";
			boolean wasTransformed = wasTransformed(framework, inputFileWithoutExtension, extension);
			assertEquals(message, expected, wasTransformed);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

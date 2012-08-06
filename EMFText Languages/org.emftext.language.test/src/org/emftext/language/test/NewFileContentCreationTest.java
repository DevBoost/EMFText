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
package org.emftext.language.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.access.resource.IPrinter;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper;
import org.emftext.test.ConcreteSyntaxTestHelper;

/**
 * A test that checks whether the creation of minimal models
 * that is used by the NewFileWizards is working correctly.
 */
public class NewFileContentCreationTest extends TestCase {

	public static final class MinimalModelTestCase extends TestCase {
		private final IMetaInformation metaInformation;

		private MinimalModelTestCase(IMetaInformation metaInformation) {
			super("Test " + metaInformation.getSyntaxName());
			this.metaInformation = metaInformation;
		}

		public void runTest() {
			test(new TestItem() {

				public EPackage[] getAdditionalPackages() {
					return new EPackage[0];
				}

				public IPrinter getPrinter(OutputStream stream) {
					return metaInformation.createPrinter(stream, null);
				}

				public EClass[] getStartClasses() {
					return metaInformation.getStartSymbols();
				}
			});
		}

		private void test(TestItem item) {
			testMinimalModelCreation(item);
			testNewFileContent();
		}

		private void testNewFileContent() {
			// the following code checks whether the content that is actually used for
			// new file is valid. this content may differ from the content created by
			// the minimal model helper if users provide template files containing
			// example code for new documents.
			String newFileContent = metaInformation.getNewFileContentProvider().getNewFileContent("new_file");
			String syntaxName = metaInformation.getSyntaxName();
			assertNotNull("Content for new file (." + syntaxName + ") must not be null.", newFileContent);
			Resource.Factory factory = metaInformation.createResourceFactory();
			if (!isOnUpdateSite(syntaxName)) {
				return;
			}
			Resource resource = factory.createResource(URI.createURI("temp." + syntaxName));
			try {
				resource.load(new ByteArrayInputStream(newFileContent.getBytes()), null);
			} catch (IOException e) {
				fail(e.getMessage());
			}
			EList<Diagnostic> errors = resource.getErrors();
			if (!errors.isEmpty()) {
				System.out.println("NewFileContent(" + syntaxName + ") = \"" + newFileContent + "\"");
			}
			for (Diagnostic diagnostic : errors) {
				System.out.println("Error: " + diagnostic.getMessage() + " (" + diagnostic.getLine() + "," + diagnostic.getColumn() + ")");
			}
			assertTrue("New file content contains errors.", errors.isEmpty());
		}

		private void testMinimalModelCreation(TestItem item) {
			Collection<EClass> availableClasses = getContainedClasses(item.getAdditionalPackages());

			CsMinimalModelHelper mmh = new CsMinimalModelHelper();
			Set<EClass> startClasses = new LinkedHashSet<EClass>();
			for (EClass eClass : item.getStartClasses()) {
				if (eClass.isAbstract()) {
					// find and add subclasses
					for (EClass next : availableClasses) {
						if (next.getEAllSuperTypes().contains(eClass) && !next.isAbstract()) {
							startClasses.add(next);
						}
					}
				} else {
					startClasses.add(eClass);
				}
			}
			for (EClass nextStart : startClasses) {
				availableClasses.addAll(getContainedClasses(nextStart));

				EObject result = mmh.getMinimalModel(nextStart, availableClasses);
				assertNotNull(result);

				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				IPrinter printer = item.getPrinter(buffer);
				assertNotNull(printer);
				try {
					printer.print(result);
				} catch (IOException e) {
					fail(e.getMessage());
				}
			}
		}

		private boolean isOnUpdateSite(String syntaxName) {
			Set<Object> metaInformationsForLanguageOnUpdateSite = new TestLanguageRegistry().getMetaInformationsForLanguageOnUpdateSite();
			for (Object metaInformationObject : metaInformationsForLanguageOnUpdateSite) {
				IMetaInformation metaInformation = (IMetaInformation) EMFTextAccessProxy.get(metaInformationObject, IMetaInformation.class);
				String language = metaInformation.getSyntaxName();
				if (language.equals(syntaxName)) {
					return true;
				}
			}
			return false;
		}

		private Collection<EClass> getContainedClasses(EClass... classes) {
			Set<EClass> result = new LinkedHashSet<EClass>();
			for (EClass nextClass : classes) {
				result.addAll(getContainedClasses(nextClass.getEPackage()));
			}
			return result;
		}

		private Collection<EClass> getContainedClasses(EPackage... ePackages) {
			Set<EClass> result = new LinkedHashSet<EClass>();
			for (EPackage nextPackage : ePackages) {
				// recursively add EClasses in subpackages
				for (EPackage nextSubpackage : nextPackage.getESubpackages()) {
					result.addAll(getContainedClasses(nextSubpackage));
				}
				// add EClasses in the package itself
				for (EClassifier nextClassifier : nextPackage.getEClassifiers()) {
					if (nextClassifier instanceof EClass) {
						result.add((EClass) nextClassifier);
					}
				}
			}
			return result;
		}
	}

	private interface TestItem {
		public EPackage[] getAdditionalPackages();
		public EClass[] getStartClasses();
		public IPrinter getPrinter(OutputStream stream);
	}

	public static class MetaTest extends TestCase {

		private List<IMetaInformation> metaInformations;

		public MetaTest(List<IMetaInformation> metaInformations) {
			super("Check that all .cs files are tested.");
			this.metaInformations = metaInformations;
		}

		public void runTest() {
			String[] excludes = new String[] {
					".*/org.emftext.language.company/metamodel/company.text.cs",
					".*/text.text.cs",
					".*/org/emftext/test/.*",
					".*/org/emftext/sdk/concretesyntax/tokenhandling/.*",
					".*/sandwich_simple.cs",
					".*/org.emftext.refactoring.tests.properties/metamodel/Properties.cs",
					".*/formsembedded.cs",
					".*/formsextension.cs",
					".*/formsfamily.cs",
					".*/owlTextTestLanguage.text.cs",
					".*/javaforms.cs",
					".*/sqljava.cs",
					".*/org.emftext.test/testInput/CSAbstractSyntax.cs",
					".*/org.reuseware.air.language.abstractsyntax/metamodel/as.cs",
					".*/org.emftext.language.bibtex/metamodel/bibtex.cs",
					".*/org.emftext.language.pacad/metamodel/pacad.cs",
					".*/org.emftext.language.lwc11.doc/.*",
					".*/org.emftext.language.office2/demo/.*",
					".*/org.reuseware.air.language.cmsl/model/cmsl.cs",
					".*/org.emftext.refactoring.examples.screencast/.*",
					".*/org.emftext.language.n3_turtle/.*"
			};
			Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(excludes);
			for (String grammar : grammars) {
				boolean foundTest = false;
				for (IMetaInformation metaInformation : metaInformations) {
					String pathToCSDefinition = metaInformation.getPathToCSDefinition();
					grammar = grammar.replace(File.separator, "/");
					if (grammar.endsWith(pathToCSDefinition)) {
						// found test
						foundTest = true;
					}
				}
				assertTrue("Can't find test for " + grammar, foundTest);
			}
		}
	}

	public static Test suite() {
		new TestLanguageRegistry().registerAllLanguages();
		TestSuite suite = new TestSuite("All tests");
		List<IMetaInformation> metaInformations = EMFTextAccessPlugin.getConcreteSyntaxRegistry();
		for (final IMetaInformation metaInformation : metaInformations) {
			suite.addTest(new MinimalModelTestCase(metaInformation));
		}
		suite.addTest(new MetaTest(metaInformations));
		return suite;
	}
}

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
package org.emftext.test.newprojectwizard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.codegen.newproject.generators.GenModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.MetaModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.SyntaxGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;

/**
 * A test for bug 1761 (EMFText New Project Wizard generates defect .cs file).
 */
public class NewProjectSyntaxGeneratorTest extends TestCase {
	
	private final String EXPECTED = 
			"SYNTAXDEF test" +
			"FOR <http://www.emftext.org/test>" +
			"START EntityModel" +
			"OPTIONS {" +
			"reloadGeneratorModel = \"true\";" +
			"}" +
			"RULES {" +
			"EntityModel ::= \"model\" types*;" +
			"Entity ::= abstract[\"abstract\" : \"\"] \"entity\" name[] \"{\" features* \"}\";" +
			"DataType ::= \"datatype\" name[] \";\";" +
			"Feature ::= kind[attribute:\"att\", reference:\"ref\", containment:\"cont\"] type[] name[] \";\";" +
			"}";

	public void testDefaultSyntaxPrinting() {
		String metamodelName = "test";
		String namespaceUri = "http://www.emftext.org/test";
		String namespacePrefix = "test";
		String projectName = "org.emftext.language.test.defaultSyntax";
		String basePackage = projectName;
		String ecoreFile = "test.ecore";
		String syntaxFile = "test.cs";
		String genmodelFile = "test.genmodel";
		String metamodelFolder = "metamodel";
		String syntaxName = "test";
		String srcFolder = "src";
		NewProjectParameters parameters = new NewProjectParameters(metamodelName, namespaceUri, namespacePrefix, projectName, basePackage, ecoreFile, syntaxFile, genmodelFile, metamodelFolder, syntaxName, srcFolder);
		
		MetaModelGenerator metaModelGenerator = new MetaModelGenerator();
		
		EPackage metaModel = metaModelGenerator.generateEPackage(parameters);
		CsMetaInformation metaInformation = new CsMetaInformation();
		metaInformation.registerResourceFactory();
		SyntaxGenerator generator = new SyntaxGenerator();
		GenModelGenerator genModelGenerator = new GenModelGenerator();
		GenModel genModel = genModelGenerator.generateGenModel(projectName, srcFolder, syntaxName, basePackage, genmodelFile, metaModel);
		GenPackage genPackage = genModel.getGenPackages().get(0);
		ConcreteSyntax syntaxModel = (ConcreteSyntax) generator.generateModel("test", genPackage);
		String uriString = "temp." + metaInformation.getSyntaxName();
		ICsTextResource resource = (ICsTextResource) new ResourceSetImpl().createResource(URI.createURI(uriString));
		resource.getContents().add(syntaxModel);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			resource.save(stream, null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String actual = stream.toString();
		System.out.println("Print result is: " + actual);
		actual = actual.replace("\n", "").replace("\r", "").replace("\t", "");
		assertEquals(EXPECTED, actual);
	}
}

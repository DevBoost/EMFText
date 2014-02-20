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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class CsNewFileContentProvider {
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation getMetaInformation() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(EClass[] startClasses, EClass[] allClassesWithSyntax, String newFileName) {
		String content = "SYNTAXDEF myFileExtension\nFOR <http://www.some-domain.org/myLanguage> <optional/path/to/myLanguage.genmodel>\nSTART StartMetaClass\n\nOPTIONS {\n\treloadGeneratorModel = \"true\";\n}\n\nRULES {\n\t// syntax definition for class 'StartMetaClass'\n\tStartMetaClass   ::= \"myKeyword\" attributeOfStartMetaClass[] aContainmentReference* ;\n\t\n\t// syntax definition for class 'AnotherMetaClass'\n\tAnotherMetaClass ::= \"otherKeyword\" aNonContainmentReference[];\n}".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	protected String getExampleContent(EClass eClass, EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		EObject root = new org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (IOException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter getPrinter(OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource());
	}
	
}

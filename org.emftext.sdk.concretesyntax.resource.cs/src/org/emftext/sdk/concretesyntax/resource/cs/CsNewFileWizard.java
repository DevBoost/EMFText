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
package org.emftext.sdk.concretesyntax.resource.cs;
public class CsNewFileWizard extends org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard {
	
	public String getFileExtension() {
		return "cs";
	}
	
	public String getExampleContent() {
		return "SYNTAXDEF myFileExtension\n" +
		"FOR <http://www.some-domain.org/myLanguage> <optional/path/to/myLanguage.genmodel>\n" +
		"START StartMetaClass\n" +
		"\n" +
		"OPTIONS {\n" +
		"\treloadGeneratorModel = \"true\";\n" +
		"}\n" +
		"\n" +
		"RULES {\n" +
		"\t// syntax definition for class 'StartMetaClass'\n" +
		"\tStartMetaClass   ::= \"myKeyword\" attributeOfStartMetaClass[] aContainmentReference* ;\n" +
		"\t\n" +
		"\t// syntax definition for class 'AnotherMetaClass'\n" +
		"\tAnotherMetaClass ::= \"otherKeyword\" aNonContainmentReference[];\n" +
		"}";
	}
	
	public org.emftext.runtime.resource.ITextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsPrinter(outputStream, new CsResource());
	}
}

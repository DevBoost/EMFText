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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.csv.resource.csv.mopp;

import java.util.Iterator;
import java.util.Map;

import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvPackage;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.ICsvTokenResolver;
import org.emftext.language.csv.resource.csv.analysis.CsvQUOTED_34_34_929292TokenResolver;
import org.emftext.language.csv.resource.csv.analysis.CsvUNQUOTED_VALUETokenResolver;

public class CsvPrinter2 implements org.emftext.language.csv.resource.csv.ICsvTextPrinter {

	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	private java.io.OutputStream outputStream;

	private String encoding = System.getProperty("file.encoding");

	public CsvPrinter2(java.io.OutputStream outputStream, org.emftext.language.csv.resource.csv.ICsvTextResource resource) {
		super();
		this.outputStream = outputStream;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		if (element instanceof CSVDocument) {
			ICsvTokenResolver tokenResolverQuoted   = new CsvQUOTED_34_34_929292TokenResolver();
			ICsvTokenResolver tokenResolverUnquoted = new CsvUNQUOTED_VALUETokenResolver();
			CSVDocument csvDoc = (CSVDocument) element;
			java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
			for (Row row : csvDoc.getRows()) {
				for (Iterator<Value> i = row.getValues().iterator(); i.hasNext();) {
					Value value = i.next();
					String resolvedString = null;
					if (value.getText().contains(";") || value.getText().contains(",")) {
						resolvedString = tokenResolverQuoted.deResolve(
								value.getText(), CsvPackage.Literals.VALUE__TEXT, value);
					} else {
						resolvedString = tokenResolverUnquoted.deResolve(
								value.getText(), CsvPackage.Literals.VALUE__TEXT, value);
					}
					writer.append(resolvedString);
					if (i.hasNext()) {
						writer.append(";");
					}
				}
				writer.append(NEW_LINE);
			}
			writer.flush();
		}	
	}

	@Override
	public void setOptions(Map<?, ?> options) { }
}

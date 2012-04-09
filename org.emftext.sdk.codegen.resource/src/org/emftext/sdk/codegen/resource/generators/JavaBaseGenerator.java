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
package org.emftext.sdk.codegen.resource.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.util.LicenceHeaderUtil;

public abstract class JavaBaseGenerator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends ResourceBaseGenerator<ParameterType> {

	public static final String DEFAULT_LICENCE_HEADER_TEXT = "/**\n" + " * <copyright>\n" + " * </copyright>\n"
	+ " *\n" + " * \n" + " */";

	private LicenceHeaderUtil licenceHeaderUtil = new LicenceHeaderUtil();

	@Override
	public final void doGenerate(PrintWriter out) {
		super.doGenerate(out);
		JavaComposite sc = new JavaComposite();
		addLicenceHeader(sc);
		generateJavaContents(sc);
		out.write(sc.toString());
	}

	private void addLicenceHeader(StringComposite sc) {
		String licenceText = getLicenceText();
		if (licenceText != null) {
			sc.add(licenceText);
		}
	}

	private String getLicenceText() {
		// check whether the licence header was loaded before and 
		// stored in the context
		if (getContext().getLicenceText() == null) {
			// the licence header was not loaded before
			ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
			String licenceHeaderText = licenceHeaderUtil.loadLicenceHeaderText(concreteSyntax);
			if (licenceHeaderText == null) {
				// file was not found - use default text
				licenceHeaderText = DEFAULT_LICENCE_HEADER_TEXT;
			}
			// store text in context to avoid unnecessary loading
			getContext().setLicenceText(licenceHeaderText);
		}
		return getContext().getLicenceText();
	}

	public abstract void generateJavaContents(JavaComposite sc);
}

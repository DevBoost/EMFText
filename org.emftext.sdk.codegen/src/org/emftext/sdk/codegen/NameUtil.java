/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;

import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A utility class that can be used to derive names for different artifacts
 * created by EMFText.
 */
public class NameUtil {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GeneratorUtil genUtil = new GeneratorUtil();

	public String getQualifiedTokenResolverClassName(ConcreteSyntax syntax, CompleteTokenDefinition definition, boolean inImportedSyntax) {
		if (inImportedSyntax) {
			syntax = csUtil.getContainingSyntax(syntax, definition);
		}
		return genUtil.getResolverPackageName(syntax) + "." + csUtil.getTokenResolverClassName(syntax, definition);
	}
}

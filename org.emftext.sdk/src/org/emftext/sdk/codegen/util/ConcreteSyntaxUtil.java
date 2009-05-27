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
package org.emftext.sdk.codegen.util;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A utility class that provides methods used by the code generators
 * to analyse CS specifications.
 */
public class ConcreteSyntaxUtil {

	public boolean isImportedToken(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {
		return !syntax.equals(getContainingSyntax(syntax, tokenDefinition));
	}

	public ConcreteSyntax getContainingSyntax(ConcreteSyntax syntax, TokenDefinition baseDefinition) {
		EObject container = baseDefinition.eContainer();
		if (container instanceof ConcreteSyntax) {
			return (ConcreteSyntax) container;
		}
		return syntax;
	}

	/**
	 * Returns true if the given rule was defined in the given syntax.
	 * If the rule is defined in an imported syntax, this method returns
	 * false.
	 * 
	 * @param syntax the syntax that refers to the rule
	 * @param rule the rule to check
	 * @return true if the rule is contained, false if it is imported
	 */
	public boolean isImportedRule(ConcreteSyntax syntax, Rule rule) {
		return rule.getSyntax() != syntax;
	}
}

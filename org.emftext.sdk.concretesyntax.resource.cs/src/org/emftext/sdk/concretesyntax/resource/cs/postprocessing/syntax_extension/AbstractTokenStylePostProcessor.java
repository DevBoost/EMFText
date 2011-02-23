/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_extension;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;

public abstract class AbstractTokenStylePostProcessor extends AbstractPostProcessor {

	protected void addStyle(EList<TokenStyle> allStyles, TokenStyle style) {
		for (String tokenName : style.getTokenNames()) {
			boolean exists = containsStyle(allStyles, tokenName);
			if (!exists) {
				TokenStyle newTokenStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				newTokenStyle.getTokenNames().add(tokenName);
				newTokenStyle.setRgb(style.getRgb());
				newTokenStyle.getFontStyles().addAll(style.getFontStyles());
				allStyles.add(newTokenStyle);
			}
		}
	}

	protected boolean containsStyle(Collection<TokenStyle> styles, String tokenName) {
		for (TokenStyle existingStyle : styles) {
			for (String existingName : existingStyle.getTokenNames()) {
				if (existingName.equals(tokenName)) {
					return true;
				}
			}
		}
		return false;
	}
}

package org.emftext.sdk.syntax_extension;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.TokenStyle;

public abstract class TokenStylePostProcessor extends AbstractPostProcessor {

	protected void addStyle(EList<TokenStyle> allStyles, TokenStyle style) {
		boolean exists = containsStyle(allStyles, style);
		if (!exists){
			allStyles.add(style);
		}
	}

	protected boolean containsStyle(Collection<TokenStyle> styles, TokenStyle style) {
		for (TokenStyle existingStyle : styles) {
			if (existingStyle.getTokenName().equals(style.getTokenName())) {
				return true;
			}
		}
		return false;
	}
}

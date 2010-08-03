package org.emftext.sdk.syntax_extension;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.TokenStyle;

public abstract class AbstractTokenStylePostProcessor extends AbstractPostProcessor {

	protected void addStyle(EList<TokenStyle> allStyles, TokenStyle style) {
		for (String tokenName : style.getTokenNames()) {
			boolean exists = containsStyle(allStyles, tokenName);
			if (!exists){
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

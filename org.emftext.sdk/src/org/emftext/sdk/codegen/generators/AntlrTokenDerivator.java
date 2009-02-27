package org.emftext.sdk.codegen.generators;

import static org.emftext.runtime.IStandardTokenDefinitions.STD_TOKEN_DEF;
import static org.emftext.runtime.IStandardTokenDefinitions.STD_TOKEN_NAME;

import java.util.Collection;

import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.ANTLRGrammarGenerator.TokenDefinitionAdapter;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * The AntlrTokenDerivator is used to derive implicit Antrl Tokens for
 * prefixed and/or suffixed derived placeholders
 * 
 * @author Christian Wende
 *
 */
public class AntlrTokenDerivator {

	private ConcreteSyntax conreteSyntax;
	private String standardTextTokenName;

	public AntlrTokenDerivator(ConcreteSyntax conreteSyntax) {
		this.conreteSyntax = conreteSyntax;
	
		standardTextTokenName = OptionManager.INSTANCE.getStringOptionValue(conreteSyntax, ICodeGenOptions.CS_OPTION_STD_TOKEN_NAME);
		if (standardTextTokenName == null) {
			standardTextTokenName = STD_TOKEN_NAME;
		}
	
	}
	
	private String escapeLiteralChar(char candidate) {
		String result = "";
		switch (candidate) {
		case '\'':
		case '\\':
			result += "\\";
		default:
			result += candidate;
		}
		return result;
	}

	/**
	 * Used to escape prefix/suffix strings (surrounded by "'" in ANTLR).
	 * 
	 */
	public String escapeLiteralChars(String candidate) {
		StringBuffer escaped = new StringBuffer();
		char[] chars = candidate.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			escaped.append(escapeLiteralChar(chars[i]));
		}

		return escaped.toString();
	}

	/**
     * <p>Derives a Tokendefinition from the given prefix and suffix char. If the suffix is valued -1,
     * a standard Definition using the static values STD_TOKEN_NAME and STD_TOKEN_DEF will be created and registered 
     * (if not yet been done) and returned. If additionally a prefix is given, the tokens name will be the conjunction
     * of the value STD_TOKEN_NAME, "_", "prefix", "_". The resulting regular expression is constructed by prepending
     * the prefix to the value STD_TOKEN_DEF.  </p>
     * <p>
     * If suffix is given a Tokendefinition, matching the given prefix (if there) first and than matching all characters,
     * excepting the suffix, is created and returned. The name of this definition is the conjunction of the value 
     * in DERIVED_TOKEN_NAME, "_", prefix, "_" and suffix. </p>
     * 
     * @param prefix
     * @param suffix
     * @return
     */
	public String deriveTokenDefinition(String prefix, String suffix) {
		// Attention: suffix and prefix can be null, because they are defined in
		// meta class DerivedPlaceholder, which is used both for featureName[]
		// and featureName['prefix', 'suffix']. However, if one is not null,
		// the other should not be null too.
		// A clean solution would be to introduce separate meta classes for
		// features the use the default token and features the use prefix and
		// suffix
		boolean suffixIsSet = suffix != null && suffix.length() > 0;
		boolean prefixIsSet = prefix != null && prefix.length() > 0;

		String derivedExpression = null;

		if (suffixIsSet) {
			if (prefixIsSet) {
				derivedExpression = "(~('" + escapeLiteralChars(suffix)
						+ "')|('\\\\''" + escapeLiteralChars(suffix) + "'))*";
			} else {
				derivedExpression = "(~('" + escapeLiteralChars(suffix)
						+ "')|( '\\\\' '" + escapeLiteralChars(suffix)
						+ "' ))* '";
			}
		} else {
			if (prefixIsSet) {
				derivedExpression = getStandardTokenExpression();
			} else {
				derivedExpression = getStandardTokenExpression();
			}
		}
		return derivedExpression;
	}
	
	private String getStandardTokenExpression() {
		if (!STD_TOKEN_NAME.equals(standardTextTokenName)) {
			Collection<TokenDefinition> tokens = conreteSyntax.getTokens();
			for (TokenDefinition token : tokens) {
				String tokenName = token.getName();
				if (tokenName.equals(standardTextTokenName)) {
					if (token instanceof NewDefinedToken) {
						return new TokenDefinitionAdapter((NewDefinedToken) token).getExpression();
					}
				}
			}
		}
		return STD_TOKEN_DEF;
	}
}

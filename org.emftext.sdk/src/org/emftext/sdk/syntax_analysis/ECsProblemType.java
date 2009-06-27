package org.emftext.sdk.syntax_analysis;

import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.util.StringUtil;

public enum ECsProblemType {
	INVALID_GEN_MODEL(EProblemType.ERROR),
	TOKEN_MUST_BE_OVERRIDDEN(EProblemType.ERROR),
	ABSTRACT_SYNTAX_HAS_START_SYMBOLS(EProblemType.ERROR),
	CONCRETE_SYNTAX_HAS_NO_START_SYMBOLS(EProblemType.ERROR),
	START_SYMBOL_WITHOUT_SYNTAX(EProblemType.ERROR),
	UNKNOWN_OPTION(EProblemType.ERROR), 
	INVALID_DEFAULT_TOKEN_NAME(EProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_POSITIVE_INTEGER(EProblemType.ERROR),
	OPTION_VALUE_MUST_BE_INTEGER(EProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_BOOLEAN(EProblemType.ERROR), 
	INVALID_REGULAR_EXPRESSION(EProblemType.ERROR), 
	DEFAULT_TOKEN_NOT_DEFINED(EProblemType.ERROR), 
	
	DUPLICATE_RULE(EProblemType.ERROR), 
	DUPLICATE_TOKEN_NAME(EProblemType.ERROR), 
	DUPLICATE_TOKEN_STYLE(EProblemType.WARNING),
	
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX(EProblemType.WARNING),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX(EProblemType.ERROR), 
	INVALID_TOKEN_NAME(EProblemType.ERROR), 
	EXPLICIT_SYNTAX_CHOICE(EProblemType.WARNING), 
	OPTIONAL_KEYWORD(EProblemType.WARNING), 
	NON_CONTAINMENT_OPPOSITE(EProblemType.WARNING), 
	NO_RULE_FOR_META_CLASS(EProblemType.WARNING), 
	UNUSED_RESOLVER_CLASS(EProblemType.WARNING), 
	MAX_OCCURENCE_MISMATCH(EProblemType.WARNING),
	MIN_OCCURENCE_MISMATCH(EProblemType.WARNING), 
	LEFT_RECURSIVE_RULE(EProblemType.WARNING), 
	FEATURE_WITHOUT_SYNTAX(EProblemType.WARNING),
	OPPOSITE_FEATURE_WITHOUT_SYNTAX(EProblemType.WARNING), 
	MULTIPLE_FEATURE_USE(EProblemType.WARNING), 
	STYLE_REFERENCE_TO_NON_EXISTING_TOKEN(EProblemType.WARNING), 
	UNUSED_TOKEN(EProblemType.WARNING), 
	GENERATION_WARNING(EProblemType.WARNING),
	GENERATION_ERROR(EProblemType.ERROR), 
	INVALID_WARNING_TYPE(EProblemType.ERROR),
	;

	private EProblemType problemType;
	
	private ECsProblemType(EProblemType problemType) {
		this.problemType = problemType;
	}
	
	public EProblemType getProblemType() {
		return problemType;
	}

	public String getName() {
		// convert all uppercase to camelcase
		return StringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}

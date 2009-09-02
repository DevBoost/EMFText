package org.emftext.sdk.syntax_analysis;

import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.util.StringUtil;

/**
 * An enumeration of all problems that may occur in concrete
 * syntax definitions.
 */
public enum ECsProblemType {
	ABSTRACT_SYNTAX_HAS_START_SYMBOLS(EProblemType.WARNING),
	COLLECT_IN_TOKEN_USED_IN_RULE(EProblemType.WARNING),
	CONCRETE_SYNTAX_HAS_NO_START_SYMBOLS(EProblemType.ERROR),
	DEFAULT_TOKEN_NOT_DEFINED(EProblemType.ERROR), 
	DUPLICATE_RULE(EProblemType.ERROR), 
	DUPLICATE_TOKEN_NAME(EProblemType.ERROR), 
	DUPLICATE_TOKEN_STYLE(EProblemType.WARNING),
	EXPLICIT_SYNTAX_CHOICE(EProblemType.WARNING), 
	FEATURE_WITHOUT_SYNTAX(EProblemType.WARNING),
	GENERATION_ERROR(EProblemType.ERROR), 
	GENERATION_WARNING(EProblemType.WARNING),
	INVALID_DEFAULT_TOKEN_NAME(EProblemType.ERROR), 
	INVALID_GEN_MODEL(EProblemType.ERROR),
	INVALID_PARSER_GENERATOR(EProblemType.ERROR), 
	INVALID_REGULAR_EXPRESSION(EProblemType.ERROR), 
	INVALID_TOKEN_NAME(EProblemType.ERROR), 
	INVALID_WARNING_TYPE(EProblemType.ERROR), 
	LEFT_RECURSIVE_RULE(EProblemType.WARNING), 
	MAX_OCCURENCE_MISMATCH(EProblemType.WARNING),
	MIN_OCCURENCE_MISMATCH(EProblemType.WARNING), 
	MULTIPLE_FEATURE_USE(EProblemType.WARNING), 
	NON_CONTAINMENT_OPPOSITE(EProblemType.WARNING), 
	NO_RULE_FOR_META_CLASS(EProblemType.WARNING), 
	OPPOSITE_FEATURE_WITHOUT_SYNTAX(EProblemType.WARNING), 
	OPTIONAL_KEYWORD(EProblemType.WARNING), 
	OPTION_VALUE_MUST_BE_BOOLEAN(EProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_INTEGER(EProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_POSITIVE_INTEGER(EProblemType.ERROR),
	QUOTED_TOKEN_CONFLICT(EProblemType.ERROR),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX(EProblemType.WARNING),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX(EProblemType.ERROR), 
	START_SYMBOL_WITHOUT_SYNTAX(EProblemType.ERROR),
	STYLE_REFERENCE_TO_NON_EXISTING_TOKEN(EProblemType.WARNING), 
	TOKEN_CONFLICT(EProblemType.ERROR), 
	TOKEN_MATCHES_EMPTY_STRING(EProblemType.ERROR),
	TOKEN_MUST_BE_OVERRIDDEN(EProblemType.ERROR),
	UNKNOWN_OPTION(EProblemType.ERROR), 
	UNUSED_RESOLVER_CLASS(EProblemType.WARNING), 
	UNUSED_TOKEN(EProblemType.WARNING), 
	TOKEN_UNREACHABLE(EProblemType.ERROR), 
	TOKEN_OVERLAPPING(EProblemType.WARNING), 
	

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

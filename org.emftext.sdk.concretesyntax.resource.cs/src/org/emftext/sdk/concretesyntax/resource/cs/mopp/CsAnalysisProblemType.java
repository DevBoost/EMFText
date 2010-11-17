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
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil;

/**
 * An enumeration of all problems that may occur during the analysis of 
 * concrete syntax definitions.
 */
public enum CsAnalysisProblemType {
	ABSTRACT_SYNTAX_HAS_START_SYMBOLS(CsEProblemSeverity.WARNING),
	COLLECT_IN_TOKEN_USED_IN_RULE(CsEProblemSeverity.WARNING),
	CONCRETE_SYNTAX_HAS_NO_START_SYMBOLS(CsEProblemSeverity.ERROR),
	CYCLIC_SYNTAX_IMPORT(CsEProblemSeverity.ERROR), 
	CYCLIC_TOKEN_DEFINITION(CsEProblemSeverity.ERROR), 
	DEFAULT_TOKEN_NOT_DEFINED(CsEProblemSeverity.ERROR), 
	DUPLICATE_RULE(CsEProblemSeverity.ERROR), 
	DUPLICATE_TOKEN_NAME(CsEProblemSeverity.ERROR), 
	DUPLICATE_TOKEN_STYLE(CsEProblemSeverity.WARNING),
	EMPTY_CS_STRING(CsEProblemSeverity.ERROR), 
	EXPLICIT_SYNTAX_CHOICE(CsEProblemSeverity.WARNING), 
	FEATURE_WITHOUT_SYNTAX(CsEProblemSeverity.WARNING),
	GENERATION_ERROR(CsEProblemSeverity.ERROR), 
	GENERATION_WARNING(CsEProblemSeverity.WARNING),
	INVALID_DEFAULT_TOKEN_NAME(CsEProblemSeverity.ERROR), 
	INVALID_ESCAPE_IN_CS_STRING(CsEProblemSeverity.ERROR),
	INVALID_GEN_MODEL(CsEProblemSeverity.ERROR),
	INVALID_OPERATOR_ANNOTATION(CsEProblemSeverity.ERROR),
	INVALID_PARSER_GENERATOR(CsEProblemSeverity.ERROR), 
	INVALID_REGULAR_EXPRESSION(CsEProblemSeverity.ERROR), 
	INVALID_TOKEN_NAME(CsEProblemSeverity.ERROR), 
	INVALID_WARNING_TYPE(CsEProblemSeverity.ERROR), 
	LEFT_RECURSIVE_RULE(CsEProblemSeverity.WARNING), 
	LICENCE_HEADER_NOT_FOUND(CsEProblemSeverity.WARNING), 
	MAX_OCCURENCE_MISMATCH(CsEProblemSeverity.WARNING),
	MIN_OCCURENCE_MISMATCH(CsEProblemSeverity.WARNING), 
	MULTIPLE_FEATURE_USE(CsEProblemSeverity.WARNING), 
	NON_CONTAINMENT_OPPOSITE(CsEProblemSeverity.WARNING), 
	NON_STANDARD_OPTION(CsEProblemSeverity.WARNING), 
	NO_RULE_FOR_META_CLASS(CsEProblemSeverity.WARNING), 
	OPPOSITE_FEATURE_WITHOUT_SYNTAX(CsEProblemSeverity.WARNING), 
	OPTIONAL_KEYWORD(CsEProblemSeverity.WARNING), 
	OPTION_VALUE_MUST_BE_BOOLEAN(CsEProblemSeverity.ERROR), 
	TOKEN_SPACE_VALUE_MUST_BE_INTEGER(CsEProblemSeverity.ERROR), 
	TOKEN_SPACE_VALUE_MUST_BE_POSITIVE_INTEGER(CsEProblemSeverity.ERROR),
	PLACEHOLDER_IN_QUOTES_WITH_EMPTY_PREFIX(CsEProblemSeverity.ERROR), 
	PLACEHOLDER_IN_QUOTES_WITH_EMPTY_SUFFIX(CsEProblemSeverity.ERROR), 
	QUOTED_TOKEN_CONFLICT(CsEProblemSeverity.ERROR),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX(CsEProblemSeverity.WARNING),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX(CsEProblemSeverity.ERROR), 
	START_SYMBOL_WITHOUT_SYNTAX(CsEProblemSeverity.ERROR),
	STYLE_REFERENCE_TO_NON_EXISTING_TOKEN(CsEProblemSeverity.WARNING), 
	SYNTAX_NAME_CONTAINS_DOTS(CsEProblemSeverity.ERROR),
	TOKEN_CONFLICT(CsEProblemSeverity.ERROR), 
	TOKEN_MATCHES_EMPTY_STRING(CsEProblemSeverity.ERROR),
	TOKEN_MUST_BE_OVERRIDDEN(CsEProblemSeverity.ERROR),
	TOKEN_OVERLAPPING(CsEProblemSeverity.WARNING), 
	TOKEN_UNREACHABLE(CsEProblemSeverity.ERROR), 
	UNKNOWN_OPTION(CsEProblemSeverity.ERROR), 
	UNUSED_RESOLVER_CLASS(CsEProblemSeverity.WARNING), 
	UNUSED_TOKEN(CsEProblemSeverity.WARNING), 
	AUTOMATIC_TOKEN_SPACE_CONFLICT_WITH_CLASSIC_PRINTER(CsEProblemSeverity.ERROR),
	EMPTY_COMPOUND(CsEProblemSeverity.ERROR), 
	TOKEN_PRIORIZATION_USELESS_WHEN_TOKEN_SORTING_ENABLED(CsEProblemSeverity.WARNING), 
	TOKEN_SORTING_FAILED(CsEProblemSeverity.ERROR), 
	DUPLICATE_OPTION_WITH_DIFFERENT_VALUE(CsEProblemSeverity.ERROR), 
	DUPLICATE_OPTION_WITH_SAME_VALUE(CsEProblemSeverity.WARNING), 
	PLUGIN_ID_CONFLICT(CsEProblemSeverity.ERROR), 
	BOOLEAN_TERMINAL_FEATURE_NOT_ATTRIBUTE(CsEProblemSeverity.ERROR), 
	BOOLEAN_TERMINAL_FEATURE_NOT_BOOLEAN(CsEProblemSeverity.ERROR),
	BOOLEAN_TERMINAL_WRONG_FEATURE_UPPER_BOUND(CsEProblemSeverity.ERROR),
	BOOLEAN_TERMINAL_BOTH_LITERALS_EMPTY(CsEProblemSeverity.ERROR),
	BOOLEAN_TERMINAL_EQUAL_LITERALS(CsEProblemSeverity.ERROR),
	BOOLEAN_TERMINAL_ANONYMOUS_FEATURE(CsEProblemSeverity.ERROR), 
	OPERATOR_ANNOTATION_IS_MISSING_PROPERTY(CsEProblemSeverity.ERROR), 
	OPERATOR_ANNOTATION_INVALID_PROPERTY(CsEProblemSeverity.ERROR), 
	OPERATOR_ANNOTATION_MALFORMED_RULE(CsEProblemSeverity.ERROR), 
	INVALID_START_SYMBOL(CsEProblemSeverity.ERROR),
	NO_SYNTAX_FOR_CONTAINMENT_REFERENCE(CsEProblemSeverity.ERROR),
	;

	private CsEProblemSeverity severity;
	
	private CsAnalysisProblemType(CsEProblemSeverity severity) {
		this.severity = severity;
	}
	
	public CsEProblemSeverity getProblemSeverity() {
		return severity;
	}

	public String getName() {
		// convert all uppercase to camelcase
		return CsStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}

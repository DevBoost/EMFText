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

import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil;

/**
 * An enumeration of all problems that may occur in concrete
 * syntax definitions.
 */
public enum ECsProblemType {
	ABSTRACT_SYNTAX_HAS_START_SYMBOLS(CsEProblemType.WARNING),
	COLLECT_IN_TOKEN_USED_IN_RULE(CsEProblemType.WARNING),
	CONCRETE_SYNTAX_HAS_NO_START_SYMBOLS(CsEProblemType.ERROR),
	DEFAULT_TOKEN_NOT_DEFINED(CsEProblemType.ERROR), 
	DUPLICATE_RULE(CsEProblemType.ERROR), 
	DUPLICATE_TOKEN_NAME(CsEProblemType.ERROR), 
	DUPLICATE_TOKEN_STYLE(CsEProblemType.WARNING),
	EXPLICIT_SYNTAX_CHOICE(CsEProblemType.WARNING), 
	FEATURE_WITHOUT_SYNTAX(CsEProblemType.WARNING),
	GENERATION_ERROR(CsEProblemType.ERROR), 
	GENERATION_WARNING(CsEProblemType.WARNING),
	INVALID_DEFAULT_TOKEN_NAME(CsEProblemType.ERROR), 
	INVALID_GEN_MODEL(CsEProblemType.ERROR),
	INVALID_PARSER_GENERATOR(CsEProblemType.ERROR), 
	INVALID_REGULAR_EXPRESSION(CsEProblemType.ERROR), 
	INVALID_TOKEN_NAME(CsEProblemType.ERROR), 
	INVALID_WARNING_TYPE(CsEProblemType.ERROR), 
	LEFT_RECURSIVE_RULE(CsEProblemType.WARNING), 
	MAX_OCCURENCE_MISMATCH(CsEProblemType.WARNING),
	MIN_OCCURENCE_MISMATCH(CsEProblemType.WARNING), 
	MULTIPLE_FEATURE_USE(CsEProblemType.WARNING), 
	NON_CONTAINMENT_OPPOSITE(CsEProblemType.WARNING), 
	NO_RULE_FOR_META_CLASS(CsEProblemType.WARNING), 
	OPPOSITE_FEATURE_WITHOUT_SYNTAX(CsEProblemType.WARNING), 
	OPTIONAL_KEYWORD(CsEProblemType.WARNING), 
	OPTION_VALUE_MUST_BE_BOOLEAN(CsEProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_INTEGER(CsEProblemType.ERROR), 
	OPTION_VALUE_MUST_BE_POSITIVE_INTEGER(CsEProblemType.ERROR),
	QUOTED_TOKEN_CONFLICT(CsEProblemType.ERROR),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_ABSTRACT_SYNTAX(CsEProblemType.WARNING),
	REFERENCE_TO_ABSTRACT_CLASS_WITHOUT_CONCRETE_SUBTYPES_IN_CONCRETE_SYNTAX(CsEProblemType.ERROR), 
	START_SYMBOL_WITHOUT_SYNTAX(CsEProblemType.ERROR),
	STYLE_REFERENCE_TO_NON_EXISTING_TOKEN(CsEProblemType.WARNING), 
	TOKEN_CONFLICT(CsEProblemType.ERROR), 
	TOKEN_MATCHES_EMPTY_STRING(CsEProblemType.ERROR),
	TOKEN_MUST_BE_OVERRIDDEN(CsEProblemType.ERROR),
	UNKNOWN_OPTION(CsEProblemType.ERROR), 
	UNUSED_RESOLVER_CLASS(CsEProblemType.WARNING), 
	UNUSED_TOKEN(CsEProblemType.WARNING), 
	TOKEN_UNREACHABLE(CsEProblemType.ERROR), 
	TOKEN_OVERLAPPING(CsEProblemType.WARNING), 
	CYCLIC_SYNTAX_IMPORT(CsEProblemType.ERROR), 
	EMPTY_CS_STRING(CsEProblemType.ERROR), 
	NON_STANDARD_OPTION(CsEProblemType.WARNING), 
	LICENCE_HEADER_NOT_FOUND(CsEProblemType.WARNING), 
	CYCLIC_TOKEN_DEFINITION(CsEProblemType.ERROR), 
	PLACEHOLDER_IN_QUOTES_WITH_EMPTY_SUFFIX(CsEProblemType.ERROR), 
	PLACEHOLDER_IN_QUOTES_WITH_EMPTY_PREFIX(CsEProblemType.ERROR), 
	;

	private CsEProblemType problemType;
	
	private ECsProblemType(CsEProblemType problemType) {
		this.problemType = problemType;
	}
	
	public CsEProblemType getProblemType() {
		return problemType;
	}

	public String getName() {
		// convert all uppercase to camelcase
		return CsStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}

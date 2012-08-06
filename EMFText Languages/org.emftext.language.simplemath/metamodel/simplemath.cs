//*******************************************************************************
// Copyright (c) 2006-2011
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF sm
FOR       <http://www.emftext.org/language/simplemath>
START     Expression

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	forceEOF = "true";
	tokenspace = "1";
	usePredefinedTokens = "false";
	overrideLaunchConfigurationDelegate = "false";
	additionalDependencies = "org.eclipse.swt";
}

TOKENS {
	DEFINE ADDITIVE_OPERATOR $ '+' | '-' $;
	DEFINE MULTIPLICATIVE_OPERATOR $ '*' | '/' $;
	DEFINE INTEGER_LITERAL $('1'..'9') ('0'..'9')* | '0'$;
	DEFINE REAL_LITERAL $ (('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')*)?$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {

	@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	Additive ::= left (operator[ADDITIVE_OPERATOR]) right;

	@Operator(type="binary_left_associative", weight="2", superclass="Expression")
	Multiplicative ::= left operator[MULTIPLICATIVE_OPERATOR] right;
	
	@Operator(type="binary_right_associative", weight="3", superclass="Expression")
	Potence ::= base "^" exponent;
	
 	@Operator(type="unary_prefix", weight="4", superclass="Expression")	
	Negation ::= operator[ADDITIVE_OPERATOR] body;
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	BracketExp ::= "(" body ")";

	@Operator(type="primitive", weight="5", superclass="Expression")
	IntegerLiteralExp ::= intValue[INTEGER_LITERAL];

	@Operator(type="primitive", weight="5", superclass="Expression")
	RealLiteralExp ::= floatValue[REAL_LITERAL];
}

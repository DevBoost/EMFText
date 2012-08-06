//*******************************************************************************
// Copyright (c) 2006-2010 
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

SYNTAXDEF regexp_antlr
FOR <http://www.emftext.org/language/regexp> <./regular_expressions.genmodel>
START RegularExpression

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	tokenspace = "0";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE CHAR_LITERAL	$'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))*'\''$;
	DEFINE MULTIPLICITY $'?'|'*'|'+'$;

	DEFINE WHITESPACE $(' '|'\t'|'\r'?'\n')+$;
}

RULES {
	RegularExpression ::= alternatives ( "|" alternatives )*;
	
	Block ::= "(" alternatives ( "|" alternatives )* ")";
	
	ComplexRange ::= ranges : IntervalRange;
	
	IntervalRange ::= from[CHAR_LITERAL] ".." to[CHAR_LITERAL];
	
	CharTerminal ::= value[CHAR_LITERAL];
	
	StringTerminal ::= value[STRING_LITERAL];
	
	Dot ::= ".";
	
	Alternative ::= elements*;
	
	Element ::= atom (suffix[MULTIPLICITY])?;
	
	Not ::= "~" body : Block;
}
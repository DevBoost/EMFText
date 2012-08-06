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

SYNTAXDEF pl0
FOR <http://www.emftext.org/language/pl0>
START Program

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	
	DEFINE PL0ID $(('a'..'z')|('A'..'Z'))((('a'..'z')|('A'..'Z'))|'0'..'9')*$;
	DEFINE NUMBER $('0')|(('1'..'9')('0'..'9')*)$;
	
	DEFINE REL_OP $('<'|'<='|'='|'#'|'>'|'>=')$;
	DEFINE PLUS_MINUS $('+'|'-')$;
	DEFINE MUL_DIV $('*'|'/')$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	
}

TOKENSTYLES {
	"SL_COMMENT" COLOR #3a732e;
	"ML_COMMENT" COLOR #3a732e;
	//"QUOTED_34_34" COLOR #FF0000, BOLD;
	"PL0ID" COLOR #0000FF;
	"NUMBER" COLOR #00FF00, ITALIC;
	//"program" COLOR #7F0085, BOLD;
	//"const" COLOR #7F0085, BOLD;
	//"var" COLOR #7F0085, BOLD;
	//"odd" COLOR #7F0085, BOLD;
	//"begin" COLOR #7F0085, BOLD;
	//"end" COLOR #7F0085, BOLD;
	//"while" COLOR #7F0085, BOLD;
	//"do" COLOR #7F0085, BOLD;
	//"then" COLOR #7F0085, BOLD;
	//"else" COLOR #7F0085, BOLD;
	":=" COLOR #000000, BOLD;
}

RULES {
	@Foldable
	Program   ::= ("PROGRAM"|"program") name[PL0ID] !0!0 block ".";
	
	Block ::= 	(("CONST"|"const") !1 constants ("," !0 constants)* ";"!0!0)?
				(("VAR"|"var") !1 variables (#0"," #1 variables)* ";"!0!0)?
				procedures*
				body;
	
	ConstDeclaration ::= name[PL0ID] #1 "=" #1 number[NUMBER];
	
	VarDeclaration ::= name[PL0ID];
	
	@Foldable
	ProcedureDeclaration ::= 	("PROCEDURE"|"procedure") name[PL0ID] ";"!0!0 
								block ";"!0!0;
	@Foldable
	Body ::= 	("BEGIN"|"begin")!1 
				(statements (";" !0 statements)*)?!0
				("END"|"end");
	
	CallStatement ::= ("CALL"|"call") procedure[PL0ID];
	
	WhileStatement ::= ("WHILE"|"while") condition ("DO"|"do") do;
	
	IfStatement ::= ("IF"|"if") condition ("THEN"|"then") then (("ELSE"|"else") else )?;
	
	OddCondition ::= ("ODD"|"odd") expression;
	
	RelationalCondition ::= left op[REL_OP] right;
	
	Assignment ::= left[PL0ID] #1 ":=" #1 right;
	
	TermExpression ::= (op[PLUS_MINUS])? obligatory optional*;
	
	OptionalTerm ::= op[PLUS_MINUS] term;
	
	Term ::= obligatory optional*;
	
	OptionalFactor ::= op[MUL_DIV] factor;
	
	IdentReference ::= ident[PL0ID];
	
	Number ::= number[NUMBER];
	
	ExpressionFactor ::= "(" expression ")";
}
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

SYNTAXDEF cg
FOR <http://www.emftext.org/language/chess>
START ChessGame

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	tokenspace = "0";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COUNTER $('1'..'9')('0'..'9')*'.'$;
	DEFINE DIGIT $'1'..'8'$;
	DEFINE MOVETYPE $('-'|'x')$;
	DEFINE EVENTTYPE $('...'|'+'|'#')$;
	
	DEFINE CHAR  $('a'..'z')|('A'..'Z')$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"DIGIT" COLOR #000000, BOLD;
	"CHAR" COLOR #000000, BOLD;
	"COMMENT" COLOR #00bb00, BOLD;
	"-----------------------------" COLOR #808080;
	"|a |b |c |d |e |f |g |h |" COLOR #808080;
	"#1" COLOR #808080;
	"#2" COLOR #808080;
	"#3" COLOR #808080;
	"#4" COLOR #808080;
	"#5" COLOR #808080;
	"#6" COLOR #808080;
	"#7" COLOR #808080;
	"#8" COLOR #808080;
	"|" COLOR #808080;
	
	"-" COLOR #00bbff, BOLD;
	"x" COLOR #00bbff, BOLD;

}

RULES {
	ChessGame ::= board rounds*; 
	Board ::= 
		#2 "|a |b |c |d |e |f |g |h |" !0
		"-----------------------------" !0
		"#1" "|" rows "#1" !0
		"-----------------------------" !0
		"#2" "|" rows "#2" !0
		"-----------------------------" !0
		"#3" "|" rows "#3" !0
		"-----------------------------" !0
		"#4" "|" rows "#4" !0
		"-----------------------------" !0
		"#5" "|" rows "#5" !0
		"-----------------------------" !0
		"#6" "|" rows "#6" !0
		"-----------------------------" !0
		"#7" "|" rows "#7" !0
		"-----------------------------" !0
		"#8" "|" rows "#8" !0
		"-----------------------------" !0 
		#2 "|a |b |c |d |e |f |g |h |" !0
		;
	Row ::= 
		squares squares squares squares squares squares squares squares
		;
	EmptySquare ::= #2 "|";
	NonEmptySquare ::= player[CHAR] piece[CHAR] "|";
	
	Round ::= number[COUNTER] moves moves? ;
	Move ::= piece[CHAR]? fromColumn[CHAR] fromRow[DIGIT] moveType[MOVETYPE] toColumn[CHAR] toRow[DIGIT] event[EVENTTYPE]?;
}
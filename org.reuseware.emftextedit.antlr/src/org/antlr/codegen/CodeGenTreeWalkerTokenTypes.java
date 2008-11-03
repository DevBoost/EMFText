// $ANTLR 2.7.7 (2006-01-29): "codegen.g" -> "CodeGenTreeWalker.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
	package org.antlr.codegen;
    import org.antlr.tool.*;
    import org.antlr.analysis.*;
    import org.antlr.misc.*;
	import java.util.*;
	import org.antlr.stringtemplate.*;
    import antlr.TokenWithIndex;
    import antlr.CommonToken;

public interface CodeGenTreeWalkerTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int OPTIONS = 4;
	int TOKENS = 5;
	int PARSER = 6;
	int LEXER = 7;
	int RULE = 8;
	int BLOCK = 9;
	int OPTIONAL = 10;
	int CLOSURE = 11;
	int POSITIVE_CLOSURE = 12;
	int SYNPRED = 13;
	int RANGE = 14;
	int CHAR_RANGE = 15;
	int EPSILON = 16;
	int ALT = 17;
	int EOR = 18;
	int EOB = 19;
	int EOA = 20;
	int ID = 21;
	int ARG = 22;
	int ARGLIST = 23;
	int RET = 24;
	int LEXER_GRAMMAR = 25;
	int PARSER_GRAMMAR = 26;
	int TREE_GRAMMAR = 27;
	int COMBINED_GRAMMAR = 28;
	int INITACTION = 29;
	int LABEL = 30;
	int TEMPLATE = 31;
	int SCOPE = 32;
	int GATED_SEMPRED = 33;
	int SYN_SEMPRED = 34;
	int BACKTRACK_SEMPRED = 35;
	int FRAGMENT = 36;
	int ACTION = 37;
	int DOC_COMMENT = 38;
	int SEMI = 39;
	int LITERAL_lexer = 40;
	int LITERAL_tree = 41;
	int LITERAL_grammar = 42;
	int AMPERSAND = 43;
	int COLON = 44;
	int RCURLY = 45;
	int ASSIGN = 46;
	int STRING_LITERAL = 47;
	int CHAR_LITERAL = 48;
	int INT = 49;
	int STAR = 50;
	int TOKEN_REF = 51;
	int LITERAL_protected = 52;
	int LITERAL_public = 53;
	int LITERAL_private = 54;
	int BANG = 55;
	int ARG_ACTION = 56;
	int LITERAL_returns = 57;
	int LITERAL_throws = 58;
	int COMMA = 59;
	int LPAREN = 60;
	int OR = 61;
	int RPAREN = 62;
	int LITERAL_catch = 63;
	int LITERAL_finally = 64;
	int PLUS_ASSIGN = 65;
	int SEMPRED = 66;
	int IMPLIES = 67;
	int ROOT = 68;
	int RULE_REF = 69;
	int NOT = 70;
	int TREE_BEGIN = 71;
	int QUESTION = 72;
	int PLUS = 73;
	int WILDCARD = 74;
	int REWRITE = 75;
	int DOLLAR = 76;
	int DOUBLE_QUOTE_STRING_LITERAL = 77;
	int DOUBLE_ANGLE_STRING_LITERAL = 78;
	int WS = 79;
	int COMMENT = 80;
	int SL_COMMENT = 81;
	int ML_COMMENT = 82;
	int OPEN_ELEMENT_OPTION = 83;
	int CLOSE_ELEMENT_OPTION = 84;
	int ESC = 85;
	int DIGIT = 86;
	int XDIGIT = 87;
	int NESTED_ARG_ACTION = 88;
	int NESTED_ACTION = 89;
	int ACTION_CHAR_LITERAL = 90;
	int ACTION_STRING_LITERAL = 91;
	int ACTION_ESC = 92;
	int WS_LOOP = 93;
	int INTERNAL_RULE_REF = 94;
	int WS_OPT = 95;
	int SRC = 96;
}

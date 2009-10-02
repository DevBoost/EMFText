// $ANTLR 2.7.7 (2006-01-29): "eval.g" -> "ActionEvaluator.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2003-2004 Terence Parr
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
package org.antlr.stringtemplate.language;
import org.antlr.stringtemplate.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public interface ActionEvaluatorTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int APPLY = 4;
	int MULTI_APPLY = 5;
	int ARGS = 6;
	int INCLUDE = 7;
	int CONDITIONAL = 8;
	int VALUE = 9;
	int TEMPLATE = 10;
	int FUNCTION = 11;
	int SINGLEVALUEARG = 12;
	int LIST = 13;
	int NOTHING = 14;
	int SEMI = 15;
	int LPAREN = 16;
	int RPAREN = 17;
	int LITERAL_elseif = 18;
	int COMMA = 19;
	int ID = 20;
	int ASSIGN = 21;
	int COLON = 22;
	int NOT = 23;
	int PLUS = 24;
	int DOT = 25;
	int LITERAL_first = 26;
	int LITERAL_rest = 27;
	int LITERAL_last = 28;
	int LITERAL_length = 29;
	int LITERAL_strip = 30;
	int LITERAL_trunc = 31;
	int LITERAL_super = 32;
	int ANONYMOUS_TEMPLATE = 33;
	int STRING = 34;
	int INT = 35;
	int LBRACK = 36;
	int RBRACK = 37;
	int DOTDOTDOT = 38;
	int TEMPLATE_ARGS = 39;
	int NESTED_ANONYMOUS_TEMPLATE = 40;
	int ESC_CHAR = 41;
	int WS = 42;
	int WS_CHAR = 43;
}

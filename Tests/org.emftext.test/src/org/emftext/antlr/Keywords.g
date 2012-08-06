grammar Keywords;

options {
	superClass = AbstractParser;
}

@lexer::header{
	package org.emftext.antlr;
}

@lexer::members{
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
	}
} 

@header{
	package org.emftext.antlr; 
}

@members{
	public java.util.List<RecognitionException> getErrors() {
		java.util.List<RecognitionException> allErrors = new java.util.ArrayList<RecognitionException>();
		allErrors.addAll(errors);
		allErrors.addAll(((KeywordsLexer) getTokenStream().getTokenSource()).lexerExceptions);
		return allErrors;
	}
}

// Rules
root returns [String s] 
@init{s = "";} : 
	r1 = rule1 
{
	s += (r1 == null ? "" : r1);
}	
	| r2 = rule2
{
	s += (r2 == null ? "" : r2);
};

rule1 returns [String s]
@init{s = "r1";} : '[';

rule2 returns [String s]
@init{s = "r2";} : 'keyword';

// Token Definitions

T_BRACKETS	: '[' ']';
T_IDENTIFIER: 'a'..'z'+;

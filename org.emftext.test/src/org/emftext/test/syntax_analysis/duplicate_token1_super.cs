SYNTAXDEF duplicate_token1_super
FOR <http://www.emftext.org/test/duplicate_token1_super> <duplicate_token1_super.genmodel>
START ClassInSuperModel

RULES {
	ClassInSuperModel ::= "CISM" name[] whitespace[WHITESPACE] linebreak[LINEBREAK];
}
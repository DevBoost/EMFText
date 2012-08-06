SYNTAXDEF booleanterminal
FOR <http://www.emftext.org/test/booleanterminal>
START ClassA, ClassB, ClassC, ClassD, ClassE

OPTIONS {
	usePredefinedTokens = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
}

TOKENSTYLES {
	"yes", "no" COLOR #404040;
}

RULES {
	ClassA ::= "a" attribute["yes" : "no"] ";";
	ClassB ::= "b" attribute["" : "no"] ";";
	ClassC ::= "c" attribute["yes" : ""] ";";
	
	ClassD ::= "d" attribute[red : "r", green : "g", blue : "b"];
	ClassE ::= "e" attribute[red : "r", green : "g", blue : ""]; // blue is default
}
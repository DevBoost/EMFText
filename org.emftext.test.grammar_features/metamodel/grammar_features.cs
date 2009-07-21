SYNTAXDEF grammar_features
FOR <http://www.emftext.org/test/grammar_features>
START Root, SecondRoot

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
	parserGenerator = "scales";
}

TOKENS {
	//DEFINE NUMBER $('0'..'9')*$;
}

TOKENSTYLES {
	"mc" COLOR #FF0000, BOLD;
	"x" COLOR #FF0000, BOLD;
}

RULES {
	Root ::= children*;
	
	AlternativeSyntax ::= "alternativeA" | "alternativeB";
	
	ConcreteSubclassA ::= "concreteA";
	ConcreteSubclassB ::= "concreteB";
	
	MandatoryContainment ::= "mc" reference;
	OptionalContainment  ::= "oc" reference?;
	PlusContainment      ::= "pc" reference+;
	StarContainment      ::= "sc" reference*;
	
	MandatoryNonContainment ::= "mnc" reference[];
	OptionalNonContainment  ::= "onc" reference[]?;
	PlusNonContainment      ::= "pnc" reference[]+;
	StarNonContainment      ::= "snc" reference[]*;
	
	CompoundOptional ::= "co" ("a" "b")?;
	CompoundStar     ::= "cs" ("a" "b")*;
	CompoundPlus     ::= "cp" ("a" "b")+;
	
	OptionalPrefix ::= "op" ("a")? "a" "b";
	
	X ::= "x" (":" name[])?;
	
	ClassWithAttributes ::= "cwa" a1[] a2[];
	
	SecondRoot ::= "SecondRoot";
}
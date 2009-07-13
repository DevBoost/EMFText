SYNTAXDEF grammar_features
FOR <http://www.emftext.org/test/grammar_features>
START Root

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE NUMBER $('0'..'9')*$;
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
	
	MandatoryNonContainment ::= "mnc" reference[NUMBER];
	OptionalNonContainment  ::= "onc" reference[NUMBER]?;
	PlusNonContainment      ::= "pnc" reference[NUMBER]+;
	StarNonContainment      ::= "snc" reference[NUMBER]*;
	
	CompoundOptional ::= "co" ("a" "b")?;
	CompoundStar     ::= "cs" ("a" "b")*;
	CompoundPlus     ::= "cp" ("a" "b")+;
	
	X ::= "x";
}
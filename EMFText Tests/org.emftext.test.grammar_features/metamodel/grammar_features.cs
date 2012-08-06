SYNTAXDEF grammar_features
FOR <http://www.emftext.org/test/grammar_features>
START Root, SecondRoot

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
	parserGenerator = "scales";
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
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
	StarPrefix     ::= "sp" ("a")* "a" "b";
	PlusPrefix     ::= "pp" ("a")+ "a" "b";
	
	X ::= "x" (":" name[])?;
	
	ClassWithAttributes ::= "cwa" a1[] a2[];
	
	SecondRoot ::= "SecondRoot";
}
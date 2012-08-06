SYNTAXDEF cct3
FOR <http://www.emftext.org/test/cct3>
START M1, M12, M15


OPTIONS {
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	// choice
	M1 ::= ("a" | "b");
	// nested choice
	M2 ::= ("c" | ("d" | "e"));
	// nested optional element 1
	M3 ::= (("f")?) "g";
	// nested optional element 2
	M4 ::= (("h")*) "i";
	M5 ::= children* "j";
	M5Sub ::= "k";
	M6 ::= "l" ("m")? self* "n";
	M7 ::= "o" #1 "p";
	
	M8 ::= "q" m9 "r";
	// to determine the follow set for 's' the rule M8 needs to be considered!
	M9 ::= "s" ("t")?;
	
	M10 ::= "u" m11*;
	M11 ::= "v" m10*;
	
	M12 ::= "w" name['"','"'];
	
	M13 ::= "x" m14* "y";
	M14 ::= "z";
	
	// this is a test for the creation of the dummy containers
	M15 ::= "m15" m16;
	M16 ::= m17;
	M17 ::= m18['"','"'];
	M18 ::= name['"','"'];
}
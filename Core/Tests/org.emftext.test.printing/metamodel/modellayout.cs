SYNTAXDEF modellayout
FOR <http://www.emftext.org/test/printing/modellayout>
START M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25,M26,M27,M28,M29,M30,M31,M32,M33,M39,M42

OPTIONS {
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	M1 ::= "m1";
	M2 ::= "m2a" "m2b";
	M3 ::= "m3" name[];
	M4 ::= "m4" names[]*;
	M5 ::= "m5" (names[] ",")*;
	M6 ::= "m6" names[] ("," names[])*;
	M19 ::= "m19" (names[] ("," names[])*)?;

	M7 ::= "m7a" ("m7b")?;
	M8 ::= "m8a" ("m8b")*;
	M9 ::= "m9a" ("m9b")+;
	
	// nc-references
	M10 ::= "m10" name[] "->" reference[];
	
	// containment references
	M11 ::= "m11" containment;
	M12 ::= "m12" containments*;
	M13 ::= "m13" (containments ",")*;
	M14 ::= "m14" containments ("," containments)*;
	
	// whitespace declarations
	M15 ::= "m15a" #2 "m15b";
	M16 ::= "m16" (names[] #3)*;
	M20 ::= "m20a" (#0 names[])* "m20b"; // if the list 'names' is empty the default space must be printed between m20a and m20b
	
	// linebreak declarations
	M17 ::= "m17" (!1 names[])*;
	M17a ::= "m17a" "{" (!1 containments)* "}";
	M17b ::= "m17b";
	
	// choices
	M18 ::= "m18a" | "m18b";
	
	M21 ::= (names[] ".")* names[];
	M22 ::= ( "[" names[] "]" )+;
	
	// ambiguous attribute values
	M23 ::= "m23" ambigousAttribute[];
	
	// multiple occurrences of the same value in list-type attribute
	M24 ::= "m24" (names[])*;
	M25 ::= "m25" (numbers[])*;
	M26 ::= "m26" (booleans[])*;
	
	// multiple occurrences of the same object in 0..* reference
	M27 ::= "m27" (m3s)+ (references[])+;
	
	// choice where one alternative prints attribute values and the other not
	M28 ::= "m28" ("a" | names[]*);
	
	// choice where one alternative prints attribute values and the other not (nested)
	M29 ::= "m29" ("a" | ("b" | names[]*));

	// choice where each alternative prints values of one attribute (repeatedly)
	M30 ::= "m30" (("a" a[]) | ("b" b[]) | ("c" c[]))*;
	
	// nested tabs
	M31 ::= 
		"m31" "{" !1 name[] 
			(!1 containments)* !0
		"}";
		
	// multiple linebreaks
	M32 ::= "m32a" !0 !0 "m32b";

	// linebreaks before containments
	M33 ::= "m33" !0 containment;
	
	// multiple containments
	M34 ::= "m34" containments "," containments;
	
	// multiple containments with subclass restrictions
	M35 ::= "m35" containments : M35SubConcreteA* "," containments : M35SubConcreteB*;
	
	M35SubConcreteA ::= "m35a";
	M35SubConcreteB ::= "m35b";
	
	M36 ::= "m36" (!1 m37 ",")*;
	
	M37 ::= "m37" m38;
	
	M38 ::= "m38";

	M39 ::= "m39" #1 attribute['"','"'];
	
	M40 ::= "m40" "{" (!1 containment)* !0 "}";
	M41 ::= "m41" "{" !0 "}";
	
	M42 ::= "m42" "{" (m43s : M43SubA)* "," (m43s : M43SubB)* "}";
	M43SubA ::= "m43a";
	M43SubB ::= "m43b";
	
	// a choice with type restrictions
	T1M1 ::= "t1m1" "{" (
		("a" m2s : T1M2SubA) | 
		("b" m2s : T1M2SubB) |
		("c" m2s : T1M2SubC) 
		)* "}";
	T1M2SubA ::= "t1m2a";
	T1M2SubB ::= "t1m2b";
	T1M2SubC ::= "t1m2c";
}
SYNTAXDEF xmas
FOR <http://www.emftext.org/xmas>
START PresentList

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE ATTRIBUTES $'nice'|'new'|'fancy'|'complete'|'convenient'|'lightweight'|'large'|'advanced'|'seamless'$;
}

TOKENSTYLES {
	"Christmas Presents" COLOR #7F0055, BOLD;
	"for" COLOR #7F0055, BOLD;
	"ATTRIBUTES" COLOR #7F0055, BOLD;
}

RULES {
	
	PresentList::= "Christmas Presents"  "{" ( presents "." )* "}"  ;
	
	Present::= "*" ("a"|"the"|"some")?  (attributes[ATTRIBUTES])* name[]  "for" for ;
	
	Person::= name[]  ;
	
}
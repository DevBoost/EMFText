SYNTAXDEF dependencies
FOR <http://www.emftext.org/language/rolecore/dependencies>
START Graph

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE EQUAL$':''='$;
	DEFINE REFERREDTO$'=''>'$;
}

TOKENSTYLES{
	"Equivalences" COLOR #7F0055, BOLD;
	"ModelPackage" COLOR #7F0055, BOLD;
	"RCPackage" COLOR #7F0055, BOLD;
	"Domain" COLOR #7F0055, BOLD;
}

RULES{
	
	Graph::= "Graph" name[] ("priority" priority[])? !0 
		modelDomains !0
		(modelDomains !0)?
		("Equivalences" modelEquivalence)? ;
	
	Domain::= "Domain" name[] "ModelPackage" modelPackage['"','"'] "RCPackage" rcPackage['"','"'] "{" !0 
		("Required" required )? ("SemiRequired" semiRequired )? ("Create" create )? !0 "}"  ;
	
	Equivalence::= "{" edges+ "}";
	
	Required::= "{" !0 coreClasses+ !0 "}" ;
	
	SemiRequired::= "{" !0 coreClasses+ !0 "}" ;
	
	Create::= "{" !0 coreClasses+ !0 "}" ;
	
	CoreClass::= type[] name[] ("(" edges+ ")")?;
	
	Edge::= simpleTerm (referredTo[REFERREDTO] | equal[EQUAL]) rightTerm ";" ; 
	
		
	SimpleTerm::= (coreClass[])? ("role" role[])?  ;
	
	RightTerm::= (value ['"','"'] | simpleTerms ("," simpleTerms)* | operation) ;
	
	Operation::= operationType['"','"'] "(" rightTerms ("/" rightTerms)? ")" ;
}
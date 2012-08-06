SYNTAXDEF company
FOR <http://org.emftext/company.ecore> <company.genmodel>
START Company

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	overrideBuilder = "false";
	additionalDependencies = "org.emftext.language.dot";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE DECIMAL_DOUBLE_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('d'|'D')? | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('d'|'D')? | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('d'|'D')? | ('0'..'9')+ ('d'|'D'))$;
}


TOKENSTYLES {
	"company" COLOR #7F0055, BOLD;
	"department" COLOR #7F0055, BOLD;
	"employee" COLOR #7F0055, BOLD;
	"address" COLOR #7F0055, BOLD;
	"salary" COLOR #7F0055, BOLD;
	"mentor" COLOR #7F0055, BOLD;
	"manager"  COLOR #7F0055, BOLD;
}


RULES {
	Company ::= "company" #1  name['"','"'] #1  "{" ( departments)* "}";
	Department ::= !1 "department" #1  name['"','"'] #1   "{" !1
				"manager"  #1 manager !0
				( subDepartments !0 | (!1 "employee" #1  employees !0))*
				!0 "}" !0;
	Employee ::=  name['"','"'] #1  "{" !1 "address" #1  address['"','"'] !0
	 								"salary" #1  salary[DECIMAL_DOUBLE_LITERAL] !0
	 								("mentor" #1  mentor['"','"'])? 
	 							!0 "}";
}
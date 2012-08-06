SYNTAXDEF sqljava  
FOR <http://www.emftext.org/language/sqljava> 
START java.Containers.CompilationUnit

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
	sql : <http://www.emftext.org/language/sql> WITH SYNTAX sql <../../org.emftext.language.sql/metamodel/sql.cs>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "false"; 
	defaultTokenName = "IDENTIFIER";
	tokenspace = "1";
	overrideBuilder = "false" ; 
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}
	
			
	TOKENSTYLES { 
		"register" COLOR #7F0055, BOLD;
		"driver" COLOR #7F0055, BOLD;
		"connection" COLOR #7F0055, BOLD;
		"import" COLOR #7F0055, BOLD;
		"table" COLOR #7F0055, BOLD;
		"using" COLOR #7F0055, BOLD;
		"query" COLOR #7F0055, BOLD;
		"sqlExpr" COLOR #7F0055, BOLD;

		
	}

RULES { 
	RegisterDriver ::= "register" "driver" driver[STRING_LITERAL] ";" ; 
	
	Connection ::= "connection" name[] "=" connectionString[STRING_LITERAL] ";" ; 
	
	ImportTable ::= "import" "table" name[] "[" dataTypes parameters ("," dataTypes parameters )* "]" ";" ;
	
	EmbeddedExpression ::= "$" "(" expression ")" ;
	
	Query ::= "using" connection[] "query" "{" sqlString "}" ;
	
	SqlExpression ::= "sqlExpr" name[] "=" "sqlExpr" "{" expression "}" ";" ;

}
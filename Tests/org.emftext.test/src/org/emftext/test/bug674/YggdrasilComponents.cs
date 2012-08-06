 SYNTAXDEF ygg
FOR <http://yggdrasilcomponents/1.0>

START YggdrasilConfiguration

OPTIONS {
	generateCodeFromGeneratorModel = "true";
}

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


RULES{
		
		Role::= "Role"  name[] ;
		
		Component::= "Component"  "{" 
						"name"  ":" name[]
						"implements"  ":" implements[]
						("has"  ":" has[] )* 
					"}"  ;
		
		ComposedComponent::= "ComposedComponent"  "{" 
						"name"  ":" name['"','"']
						"implements"  ":" implements[]
						("has"  ":" has[])*
						("uses"  ":" uses[] )* 
						"}"  ;
		
		Parameter::= "Parameter"  ":"  name[];
		
		YggdrasilConfiguration::= "YggdrasilConfiguration"  "{" elements* "}"  ;
		
}
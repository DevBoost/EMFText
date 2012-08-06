SYNTAXDEF functions
FOR <http://www.emftext.org/functions>
START FunctionSet

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	usePredefinedTokens = "false";
	additionalDependencies = "org.eclipse.emf.workspace,org.eclipse.ui.console,org.eclipse.jface,org.emftext.language.functions.generators";
	
	overrideBuilder = "false";
}

TOKENS {
	DEFINE COMMENT $'//'.*('\r'|'\n')$;
	DEFINE LINEBREAK $('\r'|'\n')$;
	DEFINE WHITESPACE $' '|'\t'|'\f'$;
	// the unicode sequences represent ÄÖÜäöüß
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'\u00C4'|'\u00D6'|'\u00DC'|'\u00E4'|'\u00F6'|'\u00FC'|'\u00df')+$ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #404040;
}

RULES {
	FunctionSet ::= name[] ("{" elements* "}" | subsets*);
	Function ::= 
		ignored["ignored" : ""] 
		"function" name[] (":" parent[])? (costs[])?
		("->" relatedTo[]*)?
		("@" targetVersion[])?
		(description['"','"'])?;
		
	TargetVersion ::= ignored["ignored" : ""] "version" name[];
		
	Property ::= "property" name[] multiple["*" : ""] (":" datatype[])? (description['"','"'])?;
	Datatype ::= 
		ignored["ignored" : ""] 
		"datatype" name[] (description['"','"'])?  properties*;
}
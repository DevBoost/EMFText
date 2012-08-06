@SuppressWarnings(noRuleForMetaClass)
SYNTAXDEF pacad
FOR <http://www.emftext.org/language/pacad>
START PointAndClickAdventure

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	additionalDependencies = "org.eclipse.emf.workspace,org.emftext.language.pacad.util";
	overrideDefaultResolverDelegate = "false";
	overrideBuilder = "false";
	// TODO enable launch support and run interpreter
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE INTEGER $('0'..'9')+$;
	DEFINE HEX $'0x'('A'..'Z'|'a'..'z'|'0'..'9')+$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'0'..'9'|'-')+$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')+$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
}

TOKENSTYLES {
	"COMMENT" COLOR #008000;
}

RULES {
	
	PointAndClickAdventure ::= main["main" : ""] "adventure" ("initialRoom" initialRoom[] | "extends" mainScript['<','>']) colorMappings* elements*;
	
	ColorMapping ::= person[] "(" red[HEX] "," green[HEX] "," blue[HEX] ")" ;
	
	Import ::= "import" importedAdventure['<','>'];
	
	Object ::= visible["" : "invisible"] "object" id[] (declaredName['"','"'])?
				( ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" )| 
				("extends" parent[] ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")")?) );
	
	InternalObject ::= visible["" : "invisible"] "internal" "object" id[] (declaredName['"','"'])?
			(("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" 
			"(" definedWidth[INTEGER] "," definedHeight[INTEGER] ")") |
			("extends" parent[]
			("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" 
			"(" definedWidth[INTEGER] "," definedHeight[INTEGER] ")")?)) ;

	InventoryObject ::= visible["" : "invisible"] "inventory" "object" id[] (declaredName['"','"'])?
				( ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" )| 
				("extends" parent[] ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")")?) );
	
	Room ::= "room" id[] (declaredName['"','"'])? ("extends" parent[])? ("backgroundsound" declaredBackgroundSound['<','>'])? "{" containedObjects* "}";
	
	Command ::= "on" 
	            type[Use : "use", LookAt : "lookat", TalkTo : "talkto", Take : "take"]
	            subjects[]+
	            "do" "{" actions+ "}"
	            ;

	Hide ::= "hide" subject[];
	Show ::= "show" subject[];
	
	MoveAbsolute ::= "set" subject[] "to" newPositionX[INTEGER] "," newPositionY[INTEGER];
	MoveRelative ::= "move" subject[] deltaX[INTEGER] "," deltaY[INTEGER];
	PlaySound ::= "play" soundfile[];
	ShowText ::= speaker[]? "says" text['"','"']+; 
	
	// Inventory operations
	Store ::= "store" subject[];	
	Remove ::= "remove" subject[];	
}
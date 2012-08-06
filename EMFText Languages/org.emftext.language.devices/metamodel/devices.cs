SYNTAXDEF devices
FOR <http://www.emftext.org/language/devices>
START CommunicationSpec

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $'0x'('0'..'9'|'a'..'f'|'A'..'F')+$;
}

TOKENSTYLES {
	"spec" COLOR #000000, BOLD;
	"device" COLOR #000000, BOLD;
	"message" COLOR #000000, BOLD;
	"protocol" COLOR #000000, BOLD;
	
	"data" COLOR #00A000, BOLD;
	"INTEGER" COLOR #A00000, BOLD;
}

RULES {
	
	Device::= "device" name[] ("supports" supportedProtocols[] ("," supportedProtocols[])*)? ;
	
	Protocol::= "protocol" name[] "{" messages* "}" ;
	
	Message::= "message" name[] "(" parts* ")" ;
	
	Byte::= value[];
	
	UserData::= "data";
	
	CommunicationSpec::= "spec" ( devices | protocols )*;
}
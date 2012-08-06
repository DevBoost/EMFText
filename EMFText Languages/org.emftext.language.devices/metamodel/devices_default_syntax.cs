SYNTAXDEF devices
FOR <http://www.emftext.org/language/devices>
START Message,Byte,UserData,CommunicationSpec

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES{
	"Device" COLOR #7F0055, BOLD;
	"supportedProtocols" COLOR #7F0055, BOLD;
	"name" COLOR #7F0055, BOLD;
	"Protocol" COLOR #7F0055, BOLD;
	"messages" COLOR #7F0055, BOLD;
	"Message" COLOR #7F0055, BOLD;
	"parts" COLOR #7F0055, BOLD;
	"Byte" COLOR #7F0055, BOLD;
	"value" COLOR #7F0055, BOLD;
	"UserData" COLOR #7F0055, BOLD;
	"CommunicationSpec" COLOR #7F0055, BOLD;
	"devices" COLOR #7F0055, BOLD;
	"protocols" COLOR #7F0055, BOLD;
}

RULES{
	
	Device::= "Device"  "{" ( "supportedProtocols"  ":" supportedProtocols[]| "name"  ":" name['"','"']  )* "}"  ;
	
	Protocol::= "Protocol"  "{" ( "messages"  ":" messages | "name"  ":" name['"','"']  )* "}"  ;
	
	Message::= "Message"  "{" ( "parts"  ":" parts | "name"  ":" name['"','"']  )* "}"  ;
	
	Byte::= "Byte"  "{" ( "value"  ":" value[] )* "}"  ;
	
	UserData::= "UserData"  "{"  "}"  ;
	
	CommunicationSpec::= "CommunicationSpec"  "{" ( "devices"  ":" devices | "protocols"  ":" protocols  )* "}"  ;
	
}
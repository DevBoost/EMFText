SYNTAXDEF appflow
FOR <http://www.emftext.org/language/appflow>
START Application
// == IMPORT ==
, screenimport.ScreenTemplate
// ============
  
IMPORTS { 
	action : <http://www.emftext.org/language/appflow/actions>
	sm : <http://www.emftext.org/language/appflow/statemodel>
	screen : <http://www.emftext.org/language/appflow/screenmodel>
	widget : <http://www.emftext.org/language/appflow/widgets>
	screenimport : <http://www.emftext.org/language/appflow/screenimport>
	
	java : <http://www.emftext.org/java/members>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	additionalDependencies="org.emftext.language.java.resource";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"COMMENT" COLOR #00A000;
}

RULES {
	Application ::= "application" name[] !0 !0 statemodel (!0 !0 screens)*;
	
	// the state model
	sm.StateModel ::= "statemodel" #1 "{" (!1 states)* (!1 events)* (!1 transitions)* !0 "}";
	sm.State      ::= "state" name[] (action)? ";";
	sm.Event      ::= "event" name[] ";";
	sm.Transition ::= source[] "-" ("(" event[] ")-")? ">" #1 target[] ";";
	
	// the screen model
	screen.Screen ::= "screen" name[] #1 "{" (!1 compounds)* !0 "}";

	// the widgets
	widget.Panel     ::= "panel" name[] #1 "{" (!1 compounds)* !0 "}";
	widget.Button    ::= "button" name[] #1 label['"','"'] #1 ("triggers" event[] )? ";";
	widget.UIList    ::= "list" name[] ";";
	widget.TextField ::= "textfield" name[] ";";
	widget.Text      ::= "text" name[] #1 text['"','"'] ";";
	
	// actions
	action.ShowScreenAction ::= "show" screen[];
	action.JavaAction       ::= "call" #1 method['<','>'];
	
	//IMPORT MECHANISM
	screenimport.ScreenTemplate ::= "template" screen;
	screenimport.ScreenImport ::= "import" id['<','>'] "as" name[] (#1 "(" settings ("," #1 settings)* ")")? ";" !0;
	screenimport.ParameterSetting ::= parameter[] "=" value['"','"'];
	//======
}
SYNTAXDEF ta
FOR <http://www.emftext.org/language/timedAutomata/core>
START Project

OPTIONS {
	reloadGeneratorModel = "true";
	resourcePluginID = "org.emftext.language.timedautomata.resource.ta";
	basePackage = "org.emftext.language.timedautomata.resource.ta";
	resourceUIPluginID = "org.emftext.language.timedautomata.resource.ta.ui";
	uiBasePackage = "org.emftext.language.timedautomata.resource.ta.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

RULES {
	Project ::= "project" id[] templates*;
	Template ::= "template" id[] locations* edges*;
	Location ::= "location" id[];
	Edge ::= "edge" id[] "from" source[] "to" target[];
}
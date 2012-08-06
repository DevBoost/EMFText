SYNTAXDEF dynamicui
FOR <http://www.dynamicui.org/>
START UIElement

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
}

RULES {
	UIElement ::= name[] properties* "{" children* "}";
	Property ::= name[] "=" value['"','"'];
}
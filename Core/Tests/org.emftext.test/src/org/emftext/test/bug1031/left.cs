SYNTAXDEF left
FOR <http://www.emftext.org/language/left>
START Entity

OPTIONS {
	reloadGeneratorModel = "true";
}

RULES {
	Entity ::= feature;
	Feature ::= entity;
}
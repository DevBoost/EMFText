SYNTAXDEF content2
FOR <http://www.emftext.org/test/content2>
START Root

RULES {
	Root   ::= "ROOT" #1 quotedAttribute['"', '"'];
}
SYNTAXDEF bug1300
FOR <http://www.emftext.org/test/bug1300> <bug1300.genmodel>
START A,B

RULES {
	A    ::= "a" att['"','"'];
	B    ::= "b" att['"_','"'];
}
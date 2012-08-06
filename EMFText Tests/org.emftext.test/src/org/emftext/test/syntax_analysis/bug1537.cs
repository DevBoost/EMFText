// we should not get any warnings, because this annotation covers
// the whole syntax
@SuppressWarnings
SYNTAXDEF bug1537
FOR <http://www.emftext.org/test/bug1537> <bug1537.genmodel>
START ClassA

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ClassA ::= "a";
}
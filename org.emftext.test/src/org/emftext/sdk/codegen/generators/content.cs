SYNTAXDEF content
FOR <http://www.emftext.org/test/content>
START Root

RULES {
	Root   ::= "ROOT" #1 "{" !1 children ("," children)* "}";
	ChildA ::= "CHILD" #1 "(" integer[] "," #1 string[] "," #1 literal[] ")" #1 nonContained[] !1;
}
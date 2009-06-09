SYNTAXDEF bug790
FOR <http://www.emftext.org/test/bug790> <bug790.genmodel>
START NormalClass

IMPORTS {
	bug790_import : <http://www.emftext.org/test/bug790_import> <bug790_import.genmodel> WITH SYNTAX bug790_import <bug790_import.cs>
}

RULES {
	NormalClass ::= "NC";
	// here we should get an error because the prefix 'bug790_import' must be used to reference
	// class 'ImportedClass'
	ImportedClass ::= "IC";
}
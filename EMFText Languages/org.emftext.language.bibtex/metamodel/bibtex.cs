//*******************************************************************************
// Copyright (c) 2011 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/
SYNTAXDEF bib
FOR <http://www.emftext.org/language/bibtex>
START Bibliography

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	overridePluginXML = "false";
	reloadGeneratorModel = "true";
	//disableTokenSorting = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	additionalDependencies = "org.eclipse.emf.workspace";
}

TOKENS {
	DEFINE COMMENT $'%'(~('\n'|'\r'))*$;
	DEFINE YEAR $('1' |'2')('0'..'9')('0'..'9')('0'..'9')$;
	DEFINE INTEGER $('0'..'9')+$;
	DEFINE ID $('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'.'| '/' |':'|'_')+$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'.')+$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')+$;
}

TOKENSTYLES {
	"COMMENT" COLOR #008000;
	"@INPROCEEDINGS" COLOR #000080;
	"@ARTICLE" COLOR #000080;
}

RULES {
	// syntax definition for class 'Bibliography'
	Bibliography ::= entries*;
	
	@SuppressWarnings(explicitSyntaxChoice)
	BibtexKeyField ::= (value[ID]|value[TEXT]);
	
	@SuppressWarnings(explicitSyntaxChoice)
	AuthorField ::= "author" "=" #1 (("\"" authors ("and" authors)* "\"") | ("{" authors ("and" authors)* "}") ) ;
	Author ::= ((firstName[TEXT] (secondName[TEXT] )? lastName[TEXT]) | ((lastName[TEXT] "," firstName[TEXT] (secondName[TEXT] )?))) ;

	@SuppressWarnings(explicitSyntaxChoice)
	EditorField ::= "editor" "=" #1 ( ("{" editors ("and" editors)* "}") | ("\"" editors ("and" editors)* "\"")) ;
	Editor ::= ((firstName[TEXT] (secondName[TEXT] )? lastName[TEXT]) | (lastName[TEXT] "," firstName[TEXT] (secondName[TEXT] )?)) ;

	@SuppressWarnings(explicitSyntaxChoice)
	KeywordField ::= "keywords" "="  #1 ("{" keywords ("," keywords)* "}" | "\"" keywords ("," keywords)* "\"") ;
	Keyword ::= (value[TEXT] | value[]);

	@SuppressWarnings(explicitSyntaxChoice)
	TitleField ::= "title" "=" #1 (value['"','"'] | ("{" value[] "}")) ;
	@SuppressWarnings(explicitSyntaxChoice)
	BookTitleField ::= "booktitle" "=" #1 (value['"','"'] | "{" value[] "}");
	@SuppressWarnings(explicitSyntaxChoice)
	SeriesField ::= "series" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	AddressField ::= "address" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	MonthField ::= "month" "=" #1  (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	OrganizationField ::= "organization" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	PublisherField ::= "publisher" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	JournalField ::= "journal" "=" #1  (value['"','"'] | "{" value[] "}");
	@SuppressWarnings(explicitSyntaxChoice)
	NoteField ::= "note" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	EidField ::= "eid" "=" #1  (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	AbstractField ::= "abstract" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	ReviewField ::= "review" "=" #1 (value['"','"'] | "{" value[] "}") ;
	@SuppressWarnings(explicitSyntaxChoice)
	UrlField ::= "url" "=" #1 (value['"','"'] | "{" value[] "}") ;
	
	@SuppressWarnings(explicitSyntaxChoice)
	YearField ::= "year" "=" #1 ("{" value[YEAR] "}" | "\"" value[YEAR] "\"");

	@SuppressWarnings(explicitSyntaxChoice)
	VolumeField ::= "volume" "=" #1 ("\"" (value[INTEGER]) "\"" | "{" (value[INTEGER]) "}");
	@SuppressWarnings(explicitSyntaxChoice)
	PartField ::= "part" "=" #1  ("{" value[INTEGER] "}"| "\"" value[INTEGER] "\"");
	@SuppressWarnings(explicitSyntaxChoice)
	NumberField ::= "number" "=" #1 ("{" value[INTEGER] "}"| "\"" value[INTEGER] "\"");

	@SuppressWarnings(explicitSyntaxChoice)
	PageField ::= "pages" "=" #1 ("{" fromPage (("--" | "-") toPage)? "}" | "\"" fromPage (("--" | "-") toPage)? "\"");
	Page ::= value[INTEGER];

	InProceedingsEntry ::= ("@INPROCEEDINGS"|"@inproceedings") "{" !1 
		bibtexKey #1
		("," (
			(url)? | (abstract)? | (keyword)? | (review)? |
			// title, bookTitle, year, author are required 
			(title) | (bookTitle) | (year) | (author) |
			// editor, volume, number, series, pages, address, month, 
			// organization, publisher, note are optional
			(editor)? | (volume)? | (number)? | (series)? | (pages)? | 
			(address)? | (month)? | (organization)? | (publisher)? | (note)? 
		) #1)*
		!1 "}";	

	ArticleEntry ::= ("@ARTICLE"|"@article") "{" !1 
		bibtexKey #1
		("," (
			(url)? | (abstract)? | (keyword)? | (review)? |
			// title, journal, volume, year, author, pages are required 
			(title) | (journal) | (volume) | (year) | (author) | (pages) |
			// number, month, part, eid, note are optional
			(number)? | (month)? | (part)? | (eid)? | (note)?
		) #1)*
		!1 "}";	
		

}
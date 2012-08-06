// this syntax definition was provided by Neelima Gumpena <maitreya.chinnu@gmail.com>
SYNTAXDEF tex
FOR <http://www.emftext.org/language/latex>
START Document

OPTIONS {
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	//DEFINE TEXT$('a'..'z')+$;
	DEFINE NUMBER $('0'..'9')+$;
	DEFINE CHC$(('A'..'Z')('a'..'z'))|('a'..'z')|('A'..'Z')+$;
	DEFINE SYMBOL$'\\'$;
	DEFINE DOCCLS$('article'|'report'|'book'|'letter'|'slides'|'amsart'|'amsbook'|'amsproc')$;
	DEFINE PCKGS$('times'|'amsmath'|'amsthm'|'amscd'|'amssymb'|'latexsym'|'fancyheadings'|'alltt'|'makeidx'|'showidx'|'graphics'|'graphicx'|'enumerate'|'layout'|'multicol'|'showkeys'|'verbatim'|'url'|'graphpap')$;
	DEFINE FNTSZS$('8pt'|'9pt'|'10pt'|'11pt'|'12pt')$;
	DEFINE PPRSZS$('a4paper'|'a5paperb'|'5paper'|'legalpaper'|'letterpaper'|'a4')$;
	DEFINE STYLES$('style'|'plain'|'empty'|'headings'|'myheadings'|'definition'|'remark')$;
	DEFINE COMTXT$('cm'|'in'|'pt')$;
	//DEFINE SPLSYMBLS$(','|'.'|' '|':'|';'|'-'|'_'|'?'|'"'|'<'|'>'|'['|']'|'*'|'@'|'#'|'^'|'&'|'('|')'|'{'|'}')$;	
}

TOKENSTYLES {
	"Begin" COLOR #330000, BOLD;
	"QUOTED_34_34" COLOR #09096b, BOLD;
}

RULES {
	
	Document::= prefix[SYMBOL]"documentclass" ( "[" (fontsize[FNTSZS])? ("," papertype[PPRSZS])"]")? ( "{" documenttype[DOCCLS] "}" )? (containspackages)* (begindoc)? (containstitle)? (containsabstract)? (containsbody)? (containsbib)? (enddoc);

	Packages::= packageprefix[SYMBOL]"usepackage" "{" packagetype[PCKGS] "}";
	
	Begin::= beginprefix[SYMBOL]"begin{document}";

	Title::= (titleprefix[SYMBOL]"title" "{" (titletext['#','#']) "}" )? (titleprefix[SYMBOL]"author" "{" authortext['#','#'] "}") (titleprefix[SYMBOL] "maketitle"); //| (titlecontainsgen)*;
	
	Abstracte::= abstractprefix[SYMBOL]"begin{abstract}" abstracttext['#','#'] abstractprefix[SYMBOL]"end{abstract}";
	
	Body::= (containssections | containsenumerate |containsfigures)*;
	
	Section::= (sectionprefix[SYMBOL] "section" "{" sectionname['#','#'] "}" sectiontext['#','#']) | (containsubsections) ;
	
	Subsection::= subsectionprefix[SYMBOL] "subsection" "{" subsectionname['#','#'] "}" subsectiontext['#','#'] ;
	
	Enumerate::= enumprefix[SYMBOL]"begin{enumerate}" (enumprefix[SYMBOL]"item" enumtext['#','#'])* enumprefix[SYMBOL]"end{enumerate}";
	
	Figures::= figprefix[SYMBOL]"begin{figure}" (figprefix[SYMBOL] "caption" "{" figname['#','#'] "}") figprefix[SYMBOL]"end{figure}";
	
	Bibliography::= (bibstyle[SYMBOL]"bibliographystyle" "{" bibstyle[STYLES] "}") (containbeginbib) (containsbibitems)* (containendbib);
	
	Beginbib::= Beginbibprefix[SYMBOL]"begin{thebibliography}";
	
	bibitem::= bibprefix[SYMBOL]"bibitem" "{" bibtext['#','#'] "}" bibtext['#','#'];
	
	Endbib::= Endbibprefix[SYMBOL]"end{thebibliography}";
	
	//General::= "{" genprefix[SYMBOL] genname[] gentext['#','#'] "}";
	
	End::= endprefix[SYMBOL]"end{document}";
}
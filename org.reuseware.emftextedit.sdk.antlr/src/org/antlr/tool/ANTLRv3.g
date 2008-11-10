/** ANTLR v3 grammar written in ANTLR v3 */
grammar ANTLRv3;

options {
	output=AST;
}

tokens {
	DOC_COMMENT;
	PARSER;	
    LEXER;
    RULE;
    BLOCK;
    OPTIONAL;
    CLOSURE;
    POSITIVE_CLOSURE;
    SYNPRED;
    RANGE;
    CHAR_RANGE;
    EPSILON;
    ALT;
    EOR;
    EOB;
    EOA; // end of alt
    ID;
    ARG;
    ARGLIST;
    RET;
    LEXER_GRAMMAR;
    PARSER_GRAMMAR;
    TREE_GRAMMAR;
    COMBINED_GRAMMAR;
    INITACTION;
    LABEL; // $x used in rewrite rules
    TEMPLATE;
    SCOPE='scope';
    SEMPRED;
    GATED_SEMPRED; // {p}? =>
    SYN_SEMPRED; // (...) =>   it's a manually-specified synpred converted to sempred
    BACKTRACK_SEMPRED; // auto backtracking mode syn pred converted to sempred
    FRAGMENT='fragment';
}

@header {
package org.antlr.tool;
import java.util.Map;
import java.util.HashMap;
}

@members {
	Grammar grammar = null;
	protected int gtype = 0;
	protected String currentRuleName = null;
	protected GrammarAST currentBlockAST = null;
}

grammarDef
@init {
		for (int i=0; i<input.size(); i++) {
			System.out.println(input.get(i));
		}
}
    :   DOC_COMMENT?
    	(	'lexer'  {gtype=LEXER_GRAMMAR;}    // pure lexer
    	|   'parser' {gtype=PARSER_GRAMMAR;}   // pure parser
    	|   'tree'   {gtype=TREE_GRAMMAR;}     // a tree parser
    	|		     {gtype=COMBINED_GRAMMAR;} // merged parser/lexer
    	)
    	'grammar' id ';' optionsSpec? tokensSpec? attrScope* action*
    	rule+
    	EOF
    	-> ^('grammar' id DOC_COMMENT? optionsSpec? tokensSpec? attrScope* action*)
    ;

tokensSpec
	:	TOKENS tokenSpec+ '}' -> ^(TOKENS tokenSpec+)
	;

tokenSpec
	:	TOKEN_REF
		(	'=' (lit=STRING_LITERAL|lit=CHAR_LITERAL)	-> ^('=' TOKEN_REF $lit)
		|												-> TOKEN_REF
		)
		';'
	;

attrScope
	:	'scope' id ACTION -> ^('scope' id ACTION)
	;

/** Match stuff like @parser::members {int i;} */
action
	:	'@' (actionScopeName '::')? id ACTION
		-> ^('@' actionScopeName? id ACTION)
	;

/** Sometimes the scope names will collide with keywords; allow them as
 *  ids for action scopes.
 */
actionScopeName
	:	id
	|	l='lexer'	-> ID[$l]
    |   p='parser'	-> ID[$p]
	;

optionsSpec returns [Map opts]
@init {
	$opts=new HashMap();
}
	:	OPTIONS (option[$opts] ';')+ '}'
		-> ^(OPTIONS option+)
	;

option[Map opts]
    :   id '=' v=optionValue {$opts.put($id.text, $v.value);}
    	-> ^('=' id optionValue)
 	;
 	
optionValue returns [Object value]
@init {$value=null;}
    :   id			 	{$value = $id.text;}
    |   STRING_LITERAL	{String vs = $STRING_LITERAL.text;
                         $value=vs.substring(1,vs.length()-1);}
    |   CHAR_LITERAL	{String vs = $CHAR_LITERAL.text;
                         $value=vs.substring(1,vs.length()-1);}
    |   INT				{$value = new Integer($INT.text);}
    |	s='*'			{$value = '*';} -> STRING_LITERAL[$s]  // used for k=*
    ;

rule
@init {
GrammarAST modifier=null, blk=null, blkRoot=null, eob=null;
int start = ((TokenWithIndex)LT(1)).getIndex();
int startLine = LT(1).getLine();
GrammarAST opt = null;
Map opts = null;
}
	:	DOC_COMMENT?
		{modifier=input.LT(1);}
		(	'protected'
		|	'public'
		|	'private'
		|	frag='fragment'
		)?
		ruleName=id
		{
		currentRuleName=$ruleName.text;
	    if ( gtype==LEXER_GRAMMAR && $frag==null ) {
	        lexerRuleNames.add(currentRuleName);
		}
		}
		'!'?
		( arg=ARG_ACTION )?
		( 'returns' rt=ARG_ACTION  )?
		throwsSpec?
	    optionsSpec?
		ruleScopeSpec
		ruleAction+
		':'
		b=altList[opts]
		semi=';'
		exceptionGroup?
	    {
	    /*
	    int stop = ((TokenWithIndex)LT(1)).getIndex()-1; // point at the semi or exception thingie
		eob.setLine(semi.getLine());
		eob.setColumn(semi.getColumn());
	    GrammarAST eor = #[EOR,'<end-of-rule>'];
	   	eor.setEnclosingRule($ruleName.text);
		eor.setLine(semi.getLine());
		eor.setColumn(semi.getColumn());
		GrammarAST root = #[RULE,'rule'];
		root.ruleStartTokenIndex = start;
		root.ruleStopTokenIndex = stop;
		root.setLine(startLine);
		root.options = opts;
	    #rule = #(root,
	              #ruleName,modifier,#(#[ARG,'ARG'],#aa),#(#[RET,'RET'],#rt),
	              opt,#scopes,#a,blk,ex,eor);
	              */
		currentRuleName=null;
	    }
	    -> ^( RULE $ruleName {modifier} ^(ARG $arg)? ^(RET $rt)?
	    	  optionsSpec? ruleScopeSpec? ruleAction+
	    	  altList
	    	  exceptionGroup?
	    	  EOR["<end-of-rule>"]
	    	)	    	  
	;

/** Match stuff like @init {int i;} */
ruleAction
	:	'@' id ACTION -> ^('@' id ACTION)
	;

throwsSpec
	:	'throws' id ( ',' id )* -> ^('throws' id+)
	;

ruleScopeSpec
@init {
}
	:	( 'scope' ACTION )?
		( 'scope' id+ ';' )*
		-> ^('scope' ACTION? id+)
	;

/** Build #(BLOCK ( #(ALT ...) EOB )+ ) */
block
@init {
GrammarAST save = currentBlockAST;
Map opts=null;
}
@after {
$block.tree.setOptions(grammar,opts);
}
    :   lp='('
		( (opts=optionsSpec)? ':' )?
		{currentBlockAST = lp;}
		a1=alternative rewrite
		{if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a1);}
		( '|' a2=alternative rewrite
		  {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a2);}
		)*
        rp=')'
        {
		currentBlockAST = save;
		}
        -> ^( BLOCK[$lp] optionsSpec? alternative+ EOB[$rp] )
    ;

altList[Map opts]
@init {
	GrammarAST blkRoot = #[BLOCK,'BLOCK'];
	blkRoot.setLine(LT(1).getLine());
	blkRoot.setColumn(LT(1).getColumn());
	GrammarAST save = currentBlockAST;
	currentBlockAST = #blkRoot;
}
    :   a1=alternative rewrite
		{if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred($a1.tree);}
    	( '|' a2=alternative rewrite
    	  {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred($a2.tree);}
    	)*
        {
        currentBlockAST = save;
        }
		-> ^( {blkRoot} (alternative rewrite)+ EOB["<end-of-block>"] )
    ;

alternative
@init {
	Token firstToken = input.LT(1);
}
    :   ( el=element )+ -> ^(ALT[firstToken] element+ EOA["<end-of-alt>"])
    |   -> ^(ALT[input.LT(1)] EPSILON[input.LT(-1)] EOA["<end-of-alt>"])
    ;

exceptionGroup
	:	( exceptionHandler )+ ( finallyClause )?
	|	finallyClause
    ;

exceptionHandler
    :    'catch'^ ARG_ACTION ACTION
    ;

finallyClause
    :    'finally'^ ACTION
    ;

element
	:	elementNoOptionSpec
	;

elementNoOptionSpec
@init {
    IntSet elements=null;
    GrammarAST sub, sub2;
}
	:	id ('='^|'+='^) (atom|block)
        ( sub=ebnfSuffix[(GrammarAST)currentAST.root,false]! {#elementNoOptionSpec=sub;} )?
    |   atom
        ( sub2=ebnfSuffix[(GrammarAST)currentAST.root,false]! {#elementNoOptionSpec=sub2;} )?
    |	ebnf
	|   ACTION
	|   p=SEMPRED ( '=>' ! {#p.setType(GATED_SEMPRED);} )?
		{
		#p.setEnclosingRule(currentRuleName);
		grammar.blocksWithSemPreds.add(currentBlockAST);
		}
	|   t3=treeSpec
	;

atom:   range ('^'^|'!'^)?
    |   terminal
    |	notSet ('^'^|'!'^)?
    |   rr=RULE_REF^
		( ARG_ACTION )?
		('^'^|'!'^)?
    ;

notSet
@init {
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
    GrammarAST subrule=null;
}
	:	n='~'^
		(	notTerminal
        |   block
		)
        {#notSet.setLine(line); #notSet.setColumn(col);}
	;

treeSpec :
	'^('^
        element ( element )+
    ')'!
	;

/** matches ENBF blocks (and sets via block rule) */
ebnf
@init {
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
}
	:	b=block
		(	'?'    {#ebnf=#([OPTIONAL,'?'],#b);}
		|	'*'	    {#ebnf=#([CLOSURE,'*'],#b);}
		|	'+'	    {#ebnf=#([POSITIVE_CLOSURE,'+'],#b);}
		|   '=>'! // syntactic predicate
			{
			if ( gtype==COMBINED_GRAMMAR &&
			     Character.isUpperCase(currentRuleName.charAt(0)) )
		    {
                // ignore for lexer rules in combined
		    	#ebnf = #(#[SYNPRED,'=>'],#b); 
		    }
		    else {
		    	// create manually specified (...)=> predicate;
                // convert to sempred
		    	#ebnf = createSynSemPredFromBlock(#b, SYN_SEMPRED);
			}
			}
		|   '^' {#ebnf = #(#ROOT, #b);}
		|   '!' {#ebnf = #(#BANG, #b);}
        |   {#ebnf = #b;}
		)
		{#ebnf.setLine(line); #ebnf.setColumn(col);}
	;

range!
@init {
GrammarAST subrule=null, root=null;
}
	:	c1=CHAR_LITERAL RANGE c2=CHAR_LITERAL
		{
		GrammarAST r = #[CHAR_RANGE,".."];
		r.setLine(c1.getLine());
		r.setColumn(c1.getColumn());
		#range = #(r, #c1, #c2);
		root = #range;
		}
//    	(subrule=ebnfSuffix[root,false] {#range=subrule;})?
	;

terminal
@init {
GrammarAST ebnfRoot=null, subrule=null;
}
    :   CHAR_LITERAL^ ('^'^|'!'^)?

	|   TOKEN_REF^
			( ARG_ACTION )? // Args are only valid for lexer rules
            ('^'^|'!'^)?

	|   STRING_LITERAL ('^'^|'!'^)?

	|   '.' ('^'^|'!'^)?
	;

ebnfSuffix[GrammarAST elemAST, boolean inRewrite] returns [GrammarAST subrule=null]
@init {
GrammarAST ebnfRoot=null;
// bang on alt
}
	:	(	'?'	{ebnfRoot = #[OPTIONAL,'?'];}
   		|	'*' {ebnfRoot = #[CLOSURE,'*'];}
   		|	'+' {ebnfRoot = #[POSITIVE_CLOSURE,'+'];}
   		)
    	{
		GrammarAST save = currentBlockAST;
       	ebnfRoot.setLine(elemAST.getLine());
       	ebnfRoot.setColumn(elemAST.getColumn());
    	GrammarAST blkRoot = #[BLOCK,"BLOCK"];
    	currentBlockAST = blkRoot;
       	GrammarAST eob = #[EOB,'<end-of-block>'];
		eob.setLine(elemAST.getLine());
		eob.setColumn(elemAST.getColumn());
		GrammarAST alt = #(#[ALT,'ALT'],elemAST,#[EOA,"<end-of-alt>"]);
    	if ( !inRewrite ) {
    		prefixWithSynPred(alt);
    	}
  		subrule =
  		     #(ebnfRoot,
  		       #(blkRoot,alt,eob)
  		      );
  		currentBlockAST = save;
   		}
    ;

notTerminal
	:   CHAR_LITERAL
	|	TOKEN_REF
	|	STRING_LITERAL
	;


// R E W R I T E  S Y N T A X

rewrite
@init {
    GrammarAST root = new GrammarAST();
    // bang on alt
}
	:
		( rew='->' pred=SEMPRED alt=rewrite_alternative
	      {root.addChild( #(#rew, #pred, #alt) );}
		  {
          #pred.setEnclosingRule(currentRuleName);
          #rew.setEnclosingRule(currentRuleName);
          }
	    )*
		rew2='->' alt2=rewrite_alternative
        {
        root.addChild( #(#rew2, #alt2) );
        #rewrite = (GrammarAST)root.getFirstChild();
        }
	|
	;

rewrite_block
    :   lp='('^ {#lp.setType(BLOCK); #lp.setText('BLOCK');}
		rewrite_alternative
        ')'!
        {
        GrammarAST eob = #[EOB,"<end-of-block>"];
        eob.setLine(lp.getLine());
        eob.setColumn(lp.getColumn());
        #rewrite_block.addChild(eob);
        }
    ;

rewrite_alternative
@init {
    GrammarAST eoa = #[EOA, "<end-of-alt>"];
    GrammarAST altRoot = #[ALT,"ALT"];
    altRoot.setLine(LT(1).getLine());
    altRoot.setColumn(LT(1).getColumn());
}
    :	{grammar.buildTemplate()}? rewrite_template

    |	{grammar.buildAST()}? ( rewrite_element )+
        {
            if ( #rewrite_alternative==null ) {
                #rewrite_alternative = #(altRoot,#[EPSILON,"epsilon"],eoa);
            }
            else {
                #rewrite_alternative = #(altRoot, #rewrite_alternative,eoa);
            }
        }

   	|   {#rewrite_alternative = #(altRoot,#[EPSILON,"epsilon"],eoa);}
    ;

rewrite_element
@init {
GrammarAST subrule=null;
}
	:	t=rewrite_atom
    	( subrule=ebnfSuffix[#t,true] {#rewrite_element=subrule;} )?
	|   rewrite_ebnf
	|   tr=rewrite_tree
    	( subrule=ebnfSuffix[#tr,true] {#rewrite_element=subrule;} )?
	;

rewrite_atom
@init {
GrammarAST subrule=null;
}
    :   CHAR_LITERAL
	|   TOKEN_REF^ (ARG_ACTION)? // for imaginary nodes
    |   RULE_REF
	|   STRING_LITERAL
	|   // bang on this alt
		d='$' i=id // reference to a label in a rewrite rule
		{
		#rewrite_atom = #[LABEL,i_AST.getText()];
		#rewrite_atom.setLine(#d.getLine());
		#rewrite_atom.setColumn(#d.getColumn());
        #rewrite_atom.setEnclosingRule(currentRuleName);
		}
	|	ACTION
	;

rewrite_ebnf!
@init {
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
}
	:	b=rewrite_block
		(	'?'   {#rewrite_ebnf=#([OPTIONAL,'?'],#b);}
		|	'*'	  {#rewrite_ebnf=#([CLOSURE,'*'],#b);}
		|	'+'	  {#rewrite_ebnf=#([POSITIVE_CLOSURE,'+'],#b);}
		)
		{#rewrite_ebnf.setLine(line); #rewrite_ebnf.setColumn(col);}
	;

rewrite_tree :
	'^(' rewrite_atom rewrite_element* ')' -> ^('^(' rewrite_atom rewrite_element* )
	;

/** Build a tree for a template rewrite:
      ^(TEMPLATE (ID|ACTION) ^(ARGLIST ^(ARG ID ACTION) ...) )
    where ARGLIST is always there even if no args exist.
    ID can be "template" keyword.  If first child is ACTION then it's
    an indirect template ref

    -> foo(a={...}, b={...})
    -> ({string-e})(a={...}, b={...})  // e evaluates to template name
    -> {%{$ID.text}} // create literal template from string (done in ActionTranslator)
	-> {st-expr} // st-expr evaluates to ST
 */
rewrite_template
@init {Token st=null;}
	:   // -> template(a={...},...) "..."
		{LT(1).getText().equals('template')}? // inline
		rewrite_template_head {st=LT(1);}
		( DOUBLE_QUOTE_STRING_LITERAL! | DOUBLE_ANGLE_STRING_LITERAL! )
		{#rewrite_template.addChild(#[st]);}

	|	// -> foo(a={...}, ...)
		rewrite_template_head

	|	// -> ({expr})(a={...}, ...)
		rewrite_indirect_template_head

	|	// -> {...}
		ACTION
	;

/** -> foo(a={...}, ...) */
rewrite_template_head
	:	id lp='('^ {#lp.setType(TEMPLATE); #lp.setText('TEMPLATE');}
		rewrite_template_args
		')'!
	;

/** -> ({expr})(a={...}, ...) */
rewrite_indirect_template_head
	:	lp='('^ {#lp.setType(TEMPLATE); #lp.setText('TEMPLATE');}
		ACTION
		')'!
		'('! rewrite_template_args ')'!
	;

rewrite_template_args
	:	rewrite_template_arg (','! rewrite_template_arg)*
		{#rewrite_template_args = #(#[ARGLIST,"ARGLIST"], rewrite_template_args);}
	|	{#rewrite_template_args = #[ARGLIST,"ARGLIST"];}
	;

rewrite_template_arg
	:   id a='=' ACTION -> ^(ARG[$a] id ACTION)
	;

idList
	:	id+
	;

id	:	TOKEN_REF -> ID[$TOKEN_REF]
	|	RULE_REF  -> ID[$RULE_REF]
	;

// L E X I C A L   R U L E S

SL_COMMENT
 	:	'//'
 	 	(	' $ANTLR ' SRC // src directive
 		|	.*
		)
		'\r'? '\n'
		{$channel=HIDDEN;}
	;

ML_COMMENT
	:	'/*' {if (input.LA(1)=='*') $type=DOC_COMMENT; else $channel=HIDDEN;} .* '*/'
	;

CHAR_LITERAL
	:	'\'' LITERAL_CHAR '\''
	;

STRING_LITERAL
	:	'\'' LITERAL_CHAR LITERAL_CHAR* '\''
	;

fragment
LITERAL_CHAR
	:	ESC
	|	~('\''|'\\')
	;

DOUBLE_QUOTE_STRING_LITERAL
	:	'"' LITERAL_CHAR* '"'
	;

DOUBLE_ANGLE_STRING_LITERAL
	:	'<<' .* '>>'
	;

fragment
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'>'
		|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
		|	. // unknown, leave as it is
		)
	;

fragment
XDIGIT :
		'0' .. '9'
	|	'a' .. 'f'
	|	'A' .. 'F'
	;

INT	:	'0'..'9'+
	;

ARG_ACTION
	:	NESTED_ARG_ACTION
	;

fragment
NESTED_ARG_ACTION :
	'['!
	(	options {greedy=false; k=1;}
	:	NESTED_ARG_ACTION
	|	ACTION_STRING_LITERAL
	|	ACTION_CHAR_LITERAL
	|	.
	)*
	']'!
	;

ACTION
	:	NESTED_ACTION ( '?' {$type = SEMPRED;} )?
	;

fragment
NESTED_ACTION :
	'{'
	(	options {greedy=false; k=3;}
	:	NESTED_ACTION
//	|	DOC_COMMENT
	|	SL_COMMENT
	|	ML_COMMENT
	|	ACTION_STRING_LITERAL
	|	ACTION_CHAR_LITERAL
	|	.
	)*
	'}'
   ;

fragment
ACTION_CHAR_LITERAL
	:	'\'' (ACTION_ESC|.) '\''
	;

fragment
ACTION_STRING_LITERAL
	:	'"' (ACTION_ESC|.) (ACTION_ESC|.)* '"'
	;

fragment
ACTION_ESC
	:	'\\\''
	|	'\\"'
	|	'\\' ~('\''|'"')
	;

TOKEN_REF
	:	'A'..'Z' ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	;

RULE_REF
	:	'a'..'z' ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	;
	
OPTIONS
	:	'options' WS_LOOP '{' {$channel=0;} // reset after WS call
	;
	
TOKENS
	:	'tokens' WS_LOOP '{' {$channel=0;} // reset after WS call
	;

/** Reset the file and line information; useful when the grammar
 *  has been generated so that errors are shown relative to the
 *  original file like the old C preprocessor used to do.
 */
protected
SRC	:	'src' ' ' file=ACTION_STRING_LITERAL ' ' line=INT
		{
		//setFilename($file.text.substring(1,$file.text.length()-1));
		//setLine(Integer.parseInt($line.text)-1);  // -1 because SL_COMMENT will increment the line no. KR
		$channel=HIDDEN;
		}
	;

WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;

fragment
WS_LOOP
	:	(	WS
		|	SL_COMMENT
		|	ML_COMMENT
		)*
		{$channel=HIDDEN;}
	;


// $ANTLR 3.1.1 ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g 2009-09-10 15:01:22

package org.emftext.sdk.codegen.regex; 


import org.antlr.runtime.*;

/** ANTLR pure ebnf/regex grammar extracted from ANTLRv3 grammar.
Needs to be further testing since antlr uses the same sublanguage for ebnf and regex!*/
public class ANTLRexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR_LITERAL", "STRING_LITERAL", "LITERAL_CHAR", "ESC", "XDIGIT", "WS", "'|'", "'?'", "'*'", "'+'", "'^'", "'!'", "'..'", "'.'", "'('", "')'", "'~'"
    };
    public static final int T__12=12;
    public static final int T__20=20;
    public static final int WS=9;
    public static final int T__13=13;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int ESC=7;
    public static final int XDIGIT=8;
    public static final int T__17=17;
    public static final int CHAR_LITERAL=4;
    public static final int EOF=-1;
    public static final int STRING_LITERAL=5;
    public static final int T__16=16;
    public static final int T__10=10;
    public static final int LITERAL_CHAR=6;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public ANTLRexpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRexpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ANTLRexpParser.tokenNames; }
    public String getGrammarFileName() { return "./src/org/emftext/sdk/codegen/regex/ANTLRexp.g"; }


     private StringBuffer regExpression = new StringBuffer();
     
     public String getRegExpressionString() {
     		return regExpression.toString();
     }
     
     private String transformIntoRegExpQuotes(String st) {
     		String test = st;
    		String subString = test.substring(1, test.length()-1);
    		
    	
    		String resultString = subString;
    		resultString = resultString.replace("^", "\\^");
    		resultString = resultString.replace("+", "\\+");
    		resultString = resultString.replace("?", "\\?");
    		resultString = resultString.replace("*", "\\*");
    		resultString = resultString.replace("-", "\\-");
    		resultString = resultString.replace("$", "\\$");
    		resultString = resultString.replace(".", "\\.");
    		resultString = resultString.replace("~", "^");
    		resultString = resultString.replace("(", "\\(");
    		resultString = resultString.replace(")", "\\)");
    		resultString = resultString.replace("{", "\\{");
    		resultString = resultString.replace("}", "\\}");
    		resultString = resultString.replace("[", "\\[");
    		resultString = resultString.replace("]", "\\]");
    		
    		
    		return resultString;
     }
     
     private String removeTicks(String st) {
     		String test = st;
    		String subString = test.substring(1, test.length()-1);
    		return subString;
     }
     
     public java.util.List<RecognitionException> recExceptions = ((ANTLRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;






    // $ANTLR start "root"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:99:1: root returns [StringBuffer buf] : alternative1= alternative ( '|' alternative2= alternative )* ;
    public final StringBuffer root() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer alternative1 = null;

        StringBuffer alternative2 = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:105:1: (alternative1= alternative ( '|' alternative2= alternative )* )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:105:3: alternative1= alternative ( '|' alternative2= alternative )*
            {
            pushFollow(FOLLOW_alternative_in_root67);
            alternative1=alternative();

            state._fsp--;

            buf.append(alternative1);
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:105:63: ( '|' alternative2= alternative )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:105:65: '|' alternative2= alternative
            	    {
            	    match(input,10,FOLLOW_10_in_root73); 
            	    pushFollow(FOLLOW_alternative_in_root79);
            	    alternative2=alternative();

            	    state._fsp--;

            	    buf.append("|" + alternative2);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "root"


    // $ANTLR start "ebnf"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:108:1: ebnf returns [StringBuffer buf] : bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )? ;
    public final StringBuffer ebnf() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;
        StringBuffer bl = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:1: (bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )? )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:3: bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )?
            {
            pushFollow(FOLLOW_block_in_ebnf108);
            bl=block();

            state._fsp--;

            buf.append(bl);
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:38: (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )?
            int alt2=6;
            switch ( input.LA(1) ) {
                case 11:
                    {
                    alt2=1;
                    }
                    break;
                case 12:
                    {
                    alt2=2;
                    }
                    break;
                case 13:
                    {
                    alt2=3;
                    }
                    break;
                case 14:
                    {
                    alt2=4;
                    }
                    break;
                case 15:
                    {
                    alt2=5;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:40: sign= '?'
                    {
                    sign=(Token)match(input,11,FOLLOW_11_in_ebnf117); 

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:53: sign= '*'
                    {
                    sign=(Token)match(input,12,FOLLOW_12_in_ebnf125); 

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:64: sign= '+'
                    {
                    sign=(Token)match(input,13,FOLLOW_13_in_ebnf131); 

                    }
                    break;
                case 4 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:78: sign= '^'
                    {
                    sign=(Token)match(input,14,FOLLOW_14_in_ebnf140); 

                    }
                    break;
                case 5 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:113:91: sign= '!'
                    {
                    sign=(Token)match(input,15,FOLLOW_15_in_ebnf148); 

                    }
                    break;

            }


            if (sign != null) {
            	buf.append((sign!=null?sign.getText():null));
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "ebnf"


    // $ANTLR start "range"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:121:1: range returns [StringBuffer buf] : first= CHAR_LITERAL '..' second= CHAR_LITERAL ;
    public final StringBuffer range() throws RecognitionException {
        StringBuffer buf = null;

        Token first=null;
        Token second=null;


        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:127:2: (first= CHAR_LITERAL '..' second= CHAR_LITERAL )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:127:4: first= CHAR_LITERAL '..' second= CHAR_LITERAL
            {
            first=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range176); 
            match(input,16,FOLLOW_16_in_range178); 
            second=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range182); 

            	buf.append("["); buf.append(removeTicks((first!=null?first.getText():null))); buf.append("-"); buf.append(removeTicks((second!=null?second.getText():null))); buf.append("]");


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "range"


    // $ANTLR start "terminal"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:135:1: terminal returns [StringBuffer buf] : (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' ) ;
    public final StringBuffer terminal() throws RecognitionException {
        StringBuffer buf = null;

        Token signTerminal=null;
        Token signTerminalDot=null;


        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:1: ( (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' ) )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:5: (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' )
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:5: (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt3=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:7: signTerminal= CHAR_LITERAL
                    {
                    signTerminal=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal218); 

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:39: signTerminal= STRING_LITERAL
                    {
                    signTerminal=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal228); 

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:141:73: signTerminalDot= '.'
                    {
                    signTerminalDot=(Token)match(input,17,FOLLOW_17_in_terminal238); 

                    }
                    break;

            }


            	if (signTerminal != null) {
            		String resultString = transformIntoRegExpQuotes((signTerminal!=null?signTerminal.getText():null));
            		buf.append(resultString);
            	} else if (signTerminalDot != null) {
            		buf.append((signTerminalDot!=null?signTerminalDot.getText():null));
            	}


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "terminal"


    // $ANTLR start "ebnfSuffix"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:152:1: ebnfSuffix returns [StringBuffer buf] : (sign= '?' | sign= '*' | sign= '+' ) ;
    public final StringBuffer ebnfSuffix() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;


        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:1: ( (sign= '?' | sign= '*' | sign= '+' ) )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:3: (sign= '?' | sign= '*' | sign= '+' )
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:3: (sign= '?' | sign= '*' | sign= '+' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:4: sign= '?'
                    {
                    sign=(Token)match(input,11,FOLLOW_11_in_ebnfSuffix273); 

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:15: sign= '*'
                    {
                    sign=(Token)match(input,12,FOLLOW_12_in_ebnfSuffix279); 

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:161:25: sign= '+'
                    {
                    sign=(Token)match(input,13,FOLLOW_13_in_ebnfSuffix284); 

                    }
                    break;

            }


            buf.append((sign!=null?sign.getText():null));


            }


            	return buf;

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "ebnfSuffix"


    // $ANTLR start "block"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:167:1: block returns [StringBuffer buf] : '(' alternative1= alternative ( '|' alternative2= alternative )* ')' ;
    public final StringBuffer block() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer alternative1 = null;

        StringBuffer alternative2 = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:173:1: ( '(' alternative1= alternative ( '|' alternative2= alternative )* ')' )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:173:5: '(' alternative1= alternative ( '|' alternative2= alternative )* ')'
            {
            match(input,18,FOLLOW_18_in_block311); 
            pushFollow(FOLLOW_alternative_in_block315);
            alternative1=alternative();

            state._fsp--;

            buf.append("(" + alternative1);
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:173:75: ( '|' alternative2= alternative )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==10) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:173:77: '|' alternative2= alternative
            	    {
            	    match(input,10,FOLLOW_10_in_block323); 
            	    pushFollow(FOLLOW_alternative_in_block328);
            	    alternative2=alternative();

            	    state._fsp--;

            	    buf.append("|" + alternative2);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_block336); 
            buf.append(")");

            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "block"


    // $ANTLR start "alternative"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:175:1: alternative returns [StringBuffer buf] : (ele= element )* ;
    public final StringBuffer alternative() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer ele = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:180:1: ( (ele= element )* )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:180:3: (ele= element )*
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:180:3: (ele= element )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=CHAR_LITERAL && LA6_0<=STRING_LITERAL)||(LA6_0>=17 && LA6_0<=18)||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:180:5: ele= element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative364);
            	    ele=element();

            	    state._fsp--;

            	    buf.append(ele);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "alternative"


    // $ANTLR start "element"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:183:1: element returns [StringBuffer buf] : ele= elementNoOptionSpec ;
    public final StringBuffer element() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer ele = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:188:2: (ele= elementNoOptionSpec )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:188:4: ele= elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element394);
            ele=elementNoOptionSpec();

            state._fsp--;


            buf.append(ele);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "element"


    // $ANTLR start "elementNoOptionSpec"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:194:1: elementNoOptionSpec returns [StringBuffer buf] : (at= atom (suf= ebnfSuffix )? | eb= ebnf );
    public final StringBuffer elementNoOptionSpec() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer at = null;

        StringBuffer suf = null;

        StringBuffer eb = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:198:1: (at= atom (suf= ebnfSuffix )? | eb= ebnf )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=CHAR_LITERAL && LA8_0<=STRING_LITERAL)||LA8_0==17||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:198:3: at= atom (suf= ebnfSuffix )?
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec419);
                    at=atom();

                    state._fsp--;

                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:198:14: (suf= ebnfSuffix )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=11 && LA7_0<=13)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:198:16: suf= ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec428);
                            suf=ebnfSuffix();

                            state._fsp--;


                            }
                            break;

                    }


                    buf.append(at);
                    if (suf != null) {
                    buf.append(suf);
                    }


                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:205:3: eb= ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec443);
                    eb=ebnf();

                    state._fsp--;


                    buf.append(eb);


                    }
                    break;

            }
        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "elementNoOptionSpec"


    // $ANTLR start "atom"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:211:1: atom returns [StringBuffer buf] : (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )? ;
    public final StringBuffer atom() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;
        StringBuffer exp = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:1: ( (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )? )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:3: (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )?
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:3: (exp= range | exp= terminal | exp= notSet )
            int alt9=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==16) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||(LA9_1>=CHAR_LITERAL && LA9_1<=STRING_LITERAL)||(LA9_1>=10 && LA9_1<=15)||(LA9_1>=17 && LA9_1<=20)) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
            case 17:
                {
                alt9=2;
                }
                break;
            case 20:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:5: exp= range
                    {
                    pushFollow(FOLLOW_range_in_atom471);
                    exp=range();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:23: exp= terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom482);
                    exp=terminal();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:42: exp= notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom492);
                    exp=notSet();

                    state._fsp--;


                    }
                    break;

            }

            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:59: (sign= '^' | sign= '!' )?
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==15) ) {
                alt10=2;
            }
            switch (alt10) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:60: sign= '^'
                    {
                    sign=(Token)match(input,14,FOLLOW_14_in_atom502); 

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:216:72: sign= '!'
                    {
                    sign=(Token)match(input,15,FOLLOW_15_in_atom511); 

                    }
                    break;

            }


            buf.append(exp);
            if (sign != null) {
            	buf.append((sign!=null?sign.getText():null));
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "atom"


    // $ANTLR start "notSet"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:225:1: notSet returns [StringBuffer buf] : sign= '~' (bl= block ) ;
    public final StringBuffer notSet() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer bl = null;



        	buf = new StringBuffer();

        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:230:1: (sign= '~' (bl= block ) )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:230:3: sign= '~' (bl= block )
            {
            match(input,20,FOLLOW_20_in_notSet543); 
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:230:15: (bl= block )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:230:17: bl= block
            {
            pushFollow(FOLLOW_block_in_notSet552);
            bl=block();

            state._fsp--;


            }


            buf.append("[");
            buf.append("^");
            buf.append(bl);
            buf.append("]");
            return buf;


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "notSet"

    // Delegated rules


 

    public static final BitSet FOLLOW_alternative_in_root67 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_root73 = new BitSet(new long[]{0x0000000000160430L});
    public static final BitSet FOLLOW_alternative_in_root79 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_block_in_ebnf108 = new BitSet(new long[]{0x000000000000F802L});
    public static final BitSet FOLLOW_11_in_ebnf117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ebnf125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ebnf131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ebnf140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ebnf148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range176 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_range178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_terminal238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ebnfSuffix273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ebnfSuffix279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ebnfSuffix284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_block311 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block315 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_10_in_block323 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block328 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_19_in_block336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_alternative364 = new BitSet(new long[]{0x0000000000160032L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec419 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom471 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_terminal_in_atom482 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_notSet_in_atom492 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_atom502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_atom511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_notSet543 = new BitSet(new long[]{0x0000000000160030L});
    public static final BitSet FOLLOW_block_in_notSet552 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g 2011-08-25 17:56:52

/*
 * [The "BSD license"]
 *  Copyright (c) 2011 Terence Parr
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.stringtemplate.v4.compiler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.Misc;

public class GroupParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TRUE", "FALSE", "STRING", "ID", "BIGSTRING", "BIGSTRING_NO_NL", "ANONYMOUS_TEMPLATE", "COMMENT", "LINE_COMMENT", "WS", "'import'", "'.'", "'group'", "':'", "'implements'", "','", "';'", "'delimiters'", "'@'", "'('", "')'", "'::='", "'='", "'['", "']'", "'default'"
    };
    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int TRUE=4;
    public static final int FALSE=5;
    public static final int STRING=6;
    public static final int ID=7;
    public static final int BIGSTRING=8;
    public static final int BIGSTRING_NO_NL=9;
    public static final int ANONYMOUS_TEMPLATE=10;
    public static final int COMMENT=11;
    public static final int LINE_COMMENT=12;
    public static final int WS=13;

    // delegates
    // delegators


        public GroupParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GroupParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GroupParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g"; }


    public STGroup group;

    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e)
    {
        String msg = getErrorMessage(e, tokenNames);
        group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
    }
    public String getSourceName() {
        String fullFileName = super.getSourceName();
        File f = new File(fullFileName); // strip to simple name
        return f.getName();
    }
    public void error(String msg) {
        NoViableAltException e = new NoViableAltException("", 0, 0, input);
        group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
        recover(input, null);
    }



    // $ANTLR start "group"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:150:1: group[STGroup group, String prefix] : ( oldStyleHeader )? ( delimiters )? ( 'import' STRING | 'import' ID ( '.' ID )* )* ( def[prefix] )+ ;
    public final void group(STGroup group, String prefix) throws RecognitionException {
        Token STRING1=null;


        GroupLexer lexer = (GroupLexer)input.getTokenSource();
        this.group = lexer.group = group;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:155:2: ( ( oldStyleHeader )? ( delimiters )? ( 'import' STRING | 'import' ID ( '.' ID )* )* ( def[prefix] )+ )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:155:4: ( oldStyleHeader )? ( delimiters )? ( 'import' STRING | 'import' ID ( '.' ID )* )* ( def[prefix] )+
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:155:4: ( oldStyleHeader )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:155:4: oldStyleHeader
                    {
                    pushFollow(FOLLOW_oldStyleHeader_in_group65);
                    oldStyleHeader();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:156:3: ( delimiters )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==21) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:156:3: delimiters
                    {
                    pushFollow(FOLLOW_delimiters_in_group70);
                    delimiters();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:157:6: ( 'import' STRING | 'import' ID ( '.' ID )* )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==STRING) ) {
                        alt4=1;
                    }
                    else if ( (LA4_2==ID) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:157:8: 'import' STRING
            	    {
            	    match(input,14,FOLLOW_14_in_group80); 
            	    STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_group82); 
            	    group.importTemplates(STRING1);

            	    }
            	    break;
            	case 2 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:158:5: 'import' ID ( '.' ID )*
            	    {
            	    match(input,14,FOLLOW_14_in_group90); 

            	    			MismatchedTokenException e = new MismatchedTokenException(STRING, input);
            	    			reportError(e);
            	    			
            	    match(input,ID,FOLLOW_ID_in_group101); 
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:163:7: ( '.' ID )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==15) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:163:8: '.' ID
            	    	    {
            	    	    match(input,15,FOLLOW_15_in_group104); 
            	    	    match(input,ID,FOLLOW_ID_in_group106); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:165:9: ( def[prefix] )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:165:9: def[prefix]
            	    {
            	    pushFollow(FOLLOW_def_in_group124);
            	    def(prefix);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "group"


    // $ANTLR start "oldStyleHeader"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:168:1: oldStyleHeader : 'group' ID ( ':' ID )? ( 'implements' ID ( ',' ID )* )? ';' ;
    public final void oldStyleHeader() throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:169:5: ( 'group' ID ( ':' ID )? ( 'implements' ID ( ',' ID )* )? ';' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:169:9: 'group' ID ( ':' ID )? ( 'implements' ID ( ',' ID )* )? ';'
            {
            match(input,16,FOLLOW_16_in_oldStyleHeader146); 
            match(input,ID,FOLLOW_ID_in_oldStyleHeader148); 
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:169:20: ( ':' ID )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:169:22: ':' ID
                    {
                    match(input,17,FOLLOW_17_in_oldStyleHeader152); 
                    match(input,ID,FOLLOW_ID_in_oldStyleHeader154); 

                    }
                    break;

            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:170:6: ( 'implements' ID ( ',' ID )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:170:8: 'implements' ID ( ',' ID )*
                    {
                    match(input,18,FOLLOW_18_in_oldStyleHeader166); 
                    match(input,ID,FOLLOW_ID_in_oldStyleHeader168); 
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:170:24: ( ',' ID )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:170:25: ',' ID
                    	    {
                    	    match(input,19,FOLLOW_19_in_oldStyleHeader171); 
                    	    match(input,ID,FOLLOW_ID_in_oldStyleHeader173); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,20,FOLLOW_20_in_oldStyleHeader185); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "oldStyleHeader"


    // $ANTLR start "groupName"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:174:1: groupName returns [String name] : a= ID ( '.' a= ID )* ;
    public final String groupName() throws RecognitionException {
        String name = null;

        Token a=null;

        StringBuilder buf = new StringBuilder();
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:176:2: (a= ID ( '.' a= ID )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:176:4: a= ID ( '.' a= ID )*
            {
            a=(Token)match(input,ID,FOLLOW_ID_in_groupName207); 
            buf.append((a!=null?a.getText():null));
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:176:32: ( '.' a= ID )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:176:33: '.' a= ID
            	    {
            	    match(input,15,FOLLOW_15_in_groupName212); 
            	    a=(Token)match(input,ID,FOLLOW_ID_in_groupName216); 
            	    buf.append((a!=null?a.getText():null));

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "groupName"


    // $ANTLR start "delimiters"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:179:1: delimiters : 'delimiters' a= STRING ',' b= STRING ;
    public final void delimiters() throws RecognitionException {
        Token a=null;
        Token b=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:180:5: ( 'delimiters' a= STRING ',' b= STRING )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:180:7: 'delimiters' a= STRING ',' b= STRING
            {
            match(input,21,FOLLOW_21_in_delimiters234); 
            a=(Token)match(input,STRING,FOLLOW_STRING_in_delimiters238); 
            match(input,19,FOLLOW_19_in_delimiters240); 
            b=(Token)match(input,STRING,FOLLOW_STRING_in_delimiters244); 

                 	group.delimiterStartChar=a.getText().charAt(1);
                    group.delimiterStopChar=b.getText().charAt(1);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delimiters"


    // $ANTLR start "def"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:187:1: def[String prefix] : ( templateDef[prefix] | dictDef );
    public final void def(String prefix) throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:191:20: ( templateDef[prefix] | dictDef )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            else if ( (LA10_0==ID) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==23) ) {
                    alt10=1;
                }
                else if ( (LA10_2==25) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==ID) ) {
                        alt10=1;
                    }
                    else if ( (LA10_3==27) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:191:22: templateDef[prefix]
                    {
                    pushFollow(FOLLOW_templateDef_in_def268);
                    templateDef(prefix);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:191:44: dictDef
                    {
                    pushFollow(FOLLOW_dictDef_in_def273);
                    dictDef();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {

            		// pretend we already saw an error here
            		state.lastErrorIndex = input.index();
            		error("garbled template definition starting at '"+input.LT(1).getText()+"'");
            	
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "def"


    // $ANTLR start "templateDef"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:198:1: templateDef[String prefix] : ( ( '@' enclosing= ID '.' name= ID '(' ')' | name= ID '(' formalArgs ')' ) '::=' ( STRING | BIGSTRING | BIGSTRING_NO_NL | ) | alias= ID '::=' target= ID );
    public final void templateDef(String prefix) throws RecognitionException {
        Token enclosing=null;
        Token name=null;
        Token alias=null;
        Token target=null;
        Token STRING2=null;
        Token BIGSTRING3=null;
        Token BIGSTRING_NO_NL4=null;
        List<FormalArgument> formalArgs5 = null;



            String template=null;
            int n=0; // num char to strip from left, right of template def

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:203:2: ( ( '@' enclosing= ID '.' name= ID '(' ')' | name= ID '(' formalArgs ')' ) '::=' ( STRING | BIGSTRING | BIGSTRING_NO_NL | ) | alias= ID '::=' target= ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==ID) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==23) ) {
                    alt13=1;
                }
                else if ( (LA13_2==25) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:203:4: ( '@' enclosing= ID '.' name= ID '(' ')' | name= ID '(' formalArgs ')' ) '::=' ( STRING | BIGSTRING | BIGSTRING_NO_NL | )
                    {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:203:4: ( '@' enclosing= ID '.' name= ID '(' ')' | name= ID '(' formalArgs ')' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==ID) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:203:6: '@' enclosing= ID '.' name= ID '(' ')'
                            {
                            match(input,22,FOLLOW_22_in_templateDef297); 
                            enclosing=(Token)match(input,ID,FOLLOW_ID_in_templateDef301); 
                            match(input,15,FOLLOW_15_in_templateDef303); 
                            name=(Token)match(input,ID,FOLLOW_ID_in_templateDef307); 
                            match(input,23,FOLLOW_23_in_templateDef309); 
                            match(input,24,FOLLOW_24_in_templateDef311); 

                            }
                            break;
                        case 2 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:204:5: name= ID '(' formalArgs ')'
                            {
                            name=(Token)match(input,ID,FOLLOW_ID_in_templateDef319); 
                            match(input,23,FOLLOW_23_in_templateDef321); 
                            pushFollow(FOLLOW_formalArgs_in_templateDef323);
                            formalArgs5=formalArgs();

                            state._fsp--;

                            match(input,24,FOLLOW_24_in_templateDef325); 

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_templateDef336); 
                    Token templateToken = input.LT(1);
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:208:6: ( STRING | BIGSTRING | BIGSTRING_NO_NL | )
                    int alt12=4;
                    switch ( input.LA(1) ) {
                    case STRING:
                        {
                        alt12=1;
                        }
                        break;
                    case BIGSTRING:
                        {
                        alt12=2;
                        }
                        break;
                    case BIGSTRING_NO_NL:
                        {
                        alt12=3;
                        }
                        break;
                    case EOF:
                    case ID:
                    case 22:
                        {
                        alt12=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }

                    switch (alt12) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:208:8: STRING
                            {
                            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_templateDef352); 
                            template=(STRING2!=null?STRING2.getText():null); n=1;

                            }
                            break;
                        case 2 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:209:8: BIGSTRING
                            {
                            BIGSTRING3=(Token)match(input,BIGSTRING,FOLLOW_BIGSTRING_in_templateDef367); 
                            template=(BIGSTRING3!=null?BIGSTRING3.getText():null); n=2;

                            }
                            break;
                        case 3 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:210:8: BIGSTRING_NO_NL
                            {
                            BIGSTRING_NO_NL4=(Token)match(input,BIGSTRING_NO_NL,FOLLOW_BIGSTRING_NO_NL_in_templateDef379); 
                            template=(BIGSTRING_NO_NL4!=null?BIGSTRING_NO_NL4.getText():null); n=2;

                            }
                            break;
                        case 4 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:211:8: 
                            {

                            	    	template = "";
                            	    	String msg = "missing template at '"+input.LT(1).getText()+"'";
                                        NoViableAltException e = new NoViableAltException("", 0, 0, input);
                                	    group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
                                	    

                            }
                            break;

                    }


                    	    if ( (name!=null?name.getTokenIndex():0) >= 0 ) { // if ID missing
                    			template = Misc.strip(template, n);
                    			String templateName = (name!=null?name.getText():null);
                    			if ( prefix.length()>0 ) templateName = prefix+(name!=null?name.getText():null);
                    			group.defineTemplateOrRegion(templateName, (enclosing!=null?enclosing.getText():null), templateToken,
                    										 template, name, formalArgs5);
                    		}
                    	    

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:227:6: alias= ID '::=' target= ID
                    {
                    alias=(Token)match(input,ID,FOLLOW_ID_in_templateDef414); 
                    match(input,25,FOLLOW_25_in_templateDef416); 
                    target=(Token)match(input,ID,FOLLOW_ID_in_templateDef420); 
                    group.defineTemplateAlias(alias, target);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "templateDef"

    protected static class formalArgs_scope {
        boolean hasOptionalParameter;
    }
    protected Stack formalArgs_stack = new Stack();


    // $ANTLR start "formalArgs"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:230:1: formalArgs returns [List<FormalArgument> args = new ArrayList<FormalArgument>()] : ( formalArg[$args] ( ',' formalArg[$args] )* | );
    public final List<FormalArgument> formalArgs() throws RecognitionException {
        formalArgs_stack.push(new formalArgs_scope());
        List<FormalArgument> args =  new ArrayList<FormalArgument>();

         ((formalArgs_scope)formalArgs_stack.peek()).hasOptionalParameter = false; 
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:235:2: ( formalArg[$args] ( ',' formalArg[$args] )* | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID) ) {
                alt15=1;
            }
            else if ( (LA15_0==24) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:235:4: formalArg[$args] ( ',' formalArg[$args] )*
                    {
                    pushFollow(FOLLOW_formalArg_in_formalArgs446);
                    formalArg(args);

                    state._fsp--;

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:235:21: ( ',' formalArg[$args] )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==19) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:235:22: ',' formalArg[$args]
                    	    {
                    	    match(input,19,FOLLOW_19_in_formalArgs450); 
                    	    pushFollow(FOLLOW_formalArg_in_formalArgs452);
                    	    formalArg(args);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:237:2: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            formalArgs_stack.pop();
        }
        return args;
    }
    // $ANTLR end "formalArgs"


    // $ANTLR start "formalArg"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:239:1: formalArg[List<FormalArgument> args] : ID ( '=' a= ( STRING | ANONYMOUS_TEMPLATE | 'true' | 'false' ) | ) ;
    public final void formalArg(List<FormalArgument> args) throws RecognitionException {
        Token a=null;
        Token ID6=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:240:2: ( ID ( '=' a= ( STRING | ANONYMOUS_TEMPLATE | 'true' | 'false' ) | ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:240:4: ID ( '=' a= ( STRING | ANONYMOUS_TEMPLATE | 'true' | 'false' ) | )
            {
            ID6=(Token)match(input,ID,FOLLOW_ID_in_formalArg470); 
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:241:3: ( '=' a= ( STRING | ANONYMOUS_TEMPLATE | 'true' | 'false' ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            else if ( (LA16_0==19||LA16_0==24) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:241:5: '=' a= ( STRING | ANONYMOUS_TEMPLATE | 'true' | 'false' )
                    {
                    match(input,26,FOLLOW_26_in_formalArg476); 
                    a=(Token)input.LT(1);
                    if ( (input.LA(1)>=TRUE && input.LA(1)<=STRING)||input.LA(1)==ANONYMOUS_TEMPLATE ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    ((formalArgs_scope)formalArgs_stack.peek()).hasOptionalParameter = true;

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:242:5: 
                    {

                    			if (((formalArgs_scope)formalArgs_stack.peek()).hasOptionalParameter) {
                    				group.errMgr.compileTimeError(ErrorType.REQUIRED_PARAMETER_AFTER_OPTIONAL,
                    				 							  null, ID6);
                    			}
                    			

                    }
                    break;

            }

            args.add(new FormalArgument((ID6!=null?ID6.getText():null), a));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "formalArg"


    // $ANTLR start "dictDef"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:261:1: dictDef : ID '::=' dict ;
    public final void dictDef() throws RecognitionException {
        Token ID7=null;
        Map<String,Object> dict8 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:262:2: ( ID '::=' dict )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:262:4: ID '::=' dict
            {
            ID7=(Token)match(input,ID,FOLLOW_ID_in_dictDef521); 
            match(input,25,FOLLOW_25_in_dictDef523); 
            pushFollow(FOLLOW_dict_in_dictDef525);
            dict8=dict();

            state._fsp--;


                    if ( group.rawGetDictionary((ID7!=null?ID7.getText():null))!=null ) {
            			group.errMgr.compileTimeError(ErrorType.MAP_REDEFINITION, null, ID7);
                    }
                    else if ( group.rawGetTemplate((ID7!=null?ID7.getText():null))!=null ) {
            			group.errMgr.compileTimeError(ErrorType.TEMPLATE_REDEFINITION_AS_MAP, null, ID7);
                    }
                    else {
                        group.defineDictionary((ID7!=null?ID7.getText():null), dict8);
                    }
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dictDef"


    // $ANTLR start "dict"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:276:1: dict returns [Map<String,Object> mapping] : '[' dictPairs[mapping] ']' ;
    public final Map<String,Object> dict() throws RecognitionException {
        Map<String,Object> mapping = null;

        mapping=new HashMap<String,Object>();
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:278:2: ( '[' dictPairs[mapping] ']' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:278:6: '[' dictPairs[mapping] ']'
            {
            match(input,27,FOLLOW_27_in_dict557); 
            pushFollow(FOLLOW_dictPairs_in_dict559);
            dictPairs(mapping);

            state._fsp--;

            match(input,28,FOLLOW_28_in_dict562); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return mapping;
    }
    // $ANTLR end "dict"


    // $ANTLR start "dictPairs"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:281:1: dictPairs[Map<String,Object> mapping] : ( keyValuePair[mapping] ( ',' keyValuePair[mapping] )* ( ',' defaultValuePair[mapping] )? | defaultValuePair[mapping] );
    public final void dictPairs(Map<String,Object> mapping) throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:282:5: ( keyValuePair[mapping] ( ',' keyValuePair[mapping] )* ( ',' defaultValuePair[mapping] )? | defaultValuePair[mapping] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==29) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:282:7: keyValuePair[mapping] ( ',' keyValuePair[mapping] )* ( ',' defaultValuePair[mapping] )?
                    {
                    pushFollow(FOLLOW_keyValuePair_in_dictPairs577);
                    keyValuePair(mapping);

                    state._fsp--;

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:283:6: ( ',' keyValuePair[mapping] )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==19) ) {
                            int LA17_1 = input.LA(2);

                            if ( (LA17_1==STRING) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:283:7: ',' keyValuePair[mapping]
                    	    {
                    	    match(input,19,FOLLOW_19_in_dictPairs586); 
                    	    pushFollow(FOLLOW_keyValuePair_in_dictPairs588);
                    	    keyValuePair(mapping);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:283:35: ( ',' defaultValuePair[mapping] )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==19) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:283:36: ',' defaultValuePair[mapping]
                            {
                            match(input,19,FOLLOW_19_in_dictPairs594); 
                            pushFollow(FOLLOW_defaultValuePair_in_dictPairs596);
                            defaultValuePair(mapping);

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:284:7: defaultValuePair[mapping]
                    {
                    pushFollow(FOLLOW_defaultValuePair_in_dictPairs607);
                    defaultValuePair(mapping);

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {

            		error("missing dictionary entry at '"+input.LT(1).getText()+"'");
            	
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dictPairs"


    // $ANTLR start "defaultValuePair"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:290:1: defaultValuePair[Map<String,Object> mapping] : 'default' ':' keyValue ;
    public final void defaultValuePair(Map<String,Object> mapping) throws RecognitionException {
        Object keyValue9 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:291:2: ( 'default' ':' keyValue )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:291:4: 'default' ':' keyValue
            {
            match(input,29,FOLLOW_29_in_defaultValuePair630); 
            match(input,17,FOLLOW_17_in_defaultValuePair632); 
            pushFollow(FOLLOW_keyValue_in_defaultValuePair634);
            keyValue9=keyValue();

            state._fsp--;

            mapping.put(STGroup.DEFAULT_KEY, keyValue9);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "defaultValuePair"


    // $ANTLR start "keyValuePair"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:294:1: keyValuePair[Map<String,Object> mapping] : STRING ':' keyValue ;
    public final void keyValuePair(Map<String,Object> mapping) throws RecognitionException {
        Token STRING10=null;
        Object keyValue11 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:295:2: ( STRING ':' keyValue )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:295:4: STRING ':' keyValue
            {
            STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_keyValuePair648); 
            match(input,17,FOLLOW_17_in_keyValuePair650); 
            pushFollow(FOLLOW_keyValue_in_keyValuePair652);
            keyValue11=keyValue();

            state._fsp--;

            mapping.put(Misc.replaceEscapes(Misc.strip((STRING10!=null?STRING10.getText():null), 1)), keyValue11);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "keyValuePair"


    // $ANTLR start "keyValue"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:298:1: keyValue returns [Object value] : ( BIGSTRING | BIGSTRING_NO_NL | ANONYMOUS_TEMPLATE | STRING | TRUE | FALSE | {...}? => ID );
    public final Object keyValue() throws RecognitionException {
        Object value = null;

        Token BIGSTRING12=null;
        Token BIGSTRING_NO_NL13=null;
        Token ANONYMOUS_TEMPLATE14=null;
        Token STRING15=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:299:2: ( BIGSTRING | BIGSTRING_NO_NL | ANONYMOUS_TEMPLATE | STRING | TRUE | FALSE | {...}? => ID )
            int alt20=7;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==BIGSTRING) ) {
                alt20=1;
            }
            else if ( (LA20_0==BIGSTRING_NO_NL) ) {
                alt20=2;
            }
            else if ( (LA20_0==ANONYMOUS_TEMPLATE) ) {
                alt20=3;
            }
            else if ( (LA20_0==STRING) ) {
                alt20=4;
            }
            else if ( (LA20_0==TRUE) ) {
                alt20=5;
            }
            else if ( (LA20_0==FALSE) ) {
                alt20=6;
            }
            else if ( (LA20_0==ID) && ((input.LT(1).getText().equals("key")))) {
                alt20=7;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:299:4: BIGSTRING
                    {
                    BIGSTRING12=(Token)match(input,BIGSTRING,FOLLOW_BIGSTRING_in_keyValue669); 
                    value = group.createSingleton(BIGSTRING12);

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:300:4: BIGSTRING_NO_NL
                    {
                    BIGSTRING_NO_NL13=(Token)match(input,BIGSTRING_NO_NL,FOLLOW_BIGSTRING_NO_NL_in_keyValue678); 
                    value = group.createSingleton(BIGSTRING_NO_NL13);

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:301:4: ANONYMOUS_TEMPLATE
                    {
                    ANONYMOUS_TEMPLATE14=(Token)match(input,ANONYMOUS_TEMPLATE,FOLLOW_ANONYMOUS_TEMPLATE_in_keyValue686); 
                    value = group.createSingleton(ANONYMOUS_TEMPLATE14);

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:302:4: STRING
                    {
                    STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_keyValue693); 
                    value = Misc.replaceEscapes(Misc.strip((STRING15!=null?STRING15.getText():null), 1));

                    }
                    break;
                case 5 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:303:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_keyValue703); 
                    value = true;

                    }
                    break;
                case 6 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:304:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_keyValue713); 
                    value = false;

                    }
                    break;
                case 7 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:305:4: {...}? => ID
                    {
                    if ( !((input.LT(1).getText().equals("key"))) ) {
                        throw new FailedPredicateException(input, "keyValue", "input.LT(1).getText().equals(\"key\")");
                    }
                    match(input,ID,FOLLOW_ID_in_keyValue726); 
                    value = STGroup.DICT_KEY;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {

            		error("missing value for key at '"+input.LT(1).getText()+"'");
            	
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "keyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_oldStyleHeader_in_group65 = new BitSet(new long[]{0x0000000000604080L});
    public static final BitSet FOLLOW_delimiters_in_group70 = new BitSet(new long[]{0x0000000000604080L});
    public static final BitSet FOLLOW_14_in_group80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_group82 = new BitSet(new long[]{0x0000000000604080L});
    public static final BitSet FOLLOW_14_in_group90 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_group101 = new BitSet(new long[]{0x000000000060C080L});
    public static final BitSet FOLLOW_15_in_group104 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_group106 = new BitSet(new long[]{0x000000000060C080L});
    public static final BitSet FOLLOW_def_in_group124 = new BitSet(new long[]{0x0000000000604082L});
    public static final BitSet FOLLOW_16_in_oldStyleHeader146 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_oldStyleHeader148 = new BitSet(new long[]{0x0000000000160000L});
    public static final BitSet FOLLOW_17_in_oldStyleHeader152 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_oldStyleHeader154 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_oldStyleHeader166 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_oldStyleHeader168 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_oldStyleHeader171 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_oldStyleHeader173 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_oldStyleHeader185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_groupName207 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_groupName212 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_groupName216 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_21_in_delimiters234 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_delimiters238 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_delimiters240 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_delimiters244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateDef_in_def268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dictDef_in_def273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_templateDef297 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_templateDef301 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_templateDef303 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_templateDef307 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_templateDef309 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_templateDef311 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_templateDef319 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_templateDef321 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_formalArgs_in_templateDef323 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_templateDef325 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_templateDef336 = new BitSet(new long[]{0x0000000000000342L});
    public static final BitSet FOLLOW_STRING_in_templateDef352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGSTRING_in_templateDef367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGSTRING_NO_NL_in_templateDef379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_templateDef414 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_templateDef416 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_templateDef420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalArg_in_formalArgs446 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_formalArgs450 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_formalArg_in_formalArgs452 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ID_in_formalArg470 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_formalArg476 = new BitSet(new long[]{0x0000000000000470L});
    public static final BitSet FOLLOW_set_in_formalArg480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dictDef521 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_dictDef523 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_dict_in_dictDef525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_dict557 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_dictPairs_in_dict559 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_dict562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyValuePair_in_dictPairs577 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_dictPairs586 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_keyValuePair_in_dictPairs588 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_dictPairs594 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_defaultValuePair_in_dictPairs596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defaultValuePair_in_dictPairs607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_defaultValuePair630 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_defaultValuePair632 = new BitSet(new long[]{0x00000000000007F0L});
    public static final BitSet FOLLOW_keyValue_in_defaultValuePair634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_keyValuePair648 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_keyValuePair650 = new BitSet(new long[]{0x00000000000007F0L});
    public static final BitSet FOLLOW_keyValue_in_keyValuePair652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGSTRING_in_keyValue669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGSTRING_NO_NL_in_keyValue678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANONYMOUS_TEMPLATE_in_keyValue686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_keyValue693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_keyValue703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_keyValue713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_keyValue726 = new BitSet(new long[]{0x0000000000000002L});

}
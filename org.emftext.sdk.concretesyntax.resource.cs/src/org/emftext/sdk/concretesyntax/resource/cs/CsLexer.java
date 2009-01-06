// $ANTLR 3.0.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-01-06 15:31:02

package org.emftext.sdk.concretesyntax.resource.cs;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CsLexer extends Lexer {
    public static final int QUOTED_39_39=8;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int EOF=-1;
    public static final int T24=24;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int COMMENTS=12;
    public static final int QUOTED_36_36=11;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int TEXT_35_=9;
    public static final int TEXT=4;
    public static final int T42=42;
    public static final int Tokens=43;
    public static final int T41=41;
    public static final int T40=40;
    public static final int TEXT_33_=10;
    public static final int WS=14;
    public static final int QNAME=6;
    public static final int LB=13;
    public static final int QUOTED_60_62=5;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int QUOTED_34_34=7;
    public static final int T19=19;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public CsLexer() {;} 
    public CsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:17:5: ( 'SYNTAXDEF' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:17:7: 'SYNTAXDEF'
            {
            match("SYNTAXDEF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:18:5: ( 'FOR' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:18:7: 'FOR'
            {
            match("FOR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:19:5: ( 'START' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:19:7: 'START'
            {
            match("START"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:20:5: ( ',' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:20:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:21:5: ( 'IMPORTS' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:21:7: 'IMPORTS'
            {
            match("IMPORTS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:22:5: ( '{' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:22:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:23:5: ( '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:23:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:24:5: ( 'OPTIONS' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:24:7: 'OPTIONS'
            {
            match("OPTIONS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:25:5: ( ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:25:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:26:5: ( 'TOKENS' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:26:7: 'TOKENS'
            {
            match("TOKENS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:27:5: ( 'RULES' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:27:7: 'RULES'
            {
            match("RULES"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:28:5: ( ':' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:28:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:29:5: ( 'WITH' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:29:7: 'WITH'
            {
            match("WITH"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:30:5: ( 'SYNTAX' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:30:7: 'SYNTAX'
            {
            match("SYNTAX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:31:5: ( '=' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:31:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:32:5: ( '::=' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:32:7: '::='
            {
            match("::="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:33:5: ( '|' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:33:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:34:5: ( '[' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:34:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:35:5: ( ']' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:35:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:36:5: ( '(' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:36:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:37:5: ( ')' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:37:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:38:5: ( '+' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:38:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:39:5: ( '*' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:39:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:40:5: ( '?' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:40:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:41:5: ( 'DEFINE' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:41:7: 'DEFINE'
            {
            match("DEFINE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:42:5: ( 'COLLECT' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:42:7: 'COLLECT'
            {
            match("COLLECT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:43:5: ( 'IN' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:43:7: 'IN'
            {
            match("IN"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:44:5: ( 'PREDEFINED' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:44:7: 'PREDEFINED'
            {
            match("PREDEFINED"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start COMMENTS
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:390:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:391:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:391:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:391:7: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENTS

    // $ANTLR start TEXT
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:394:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:395:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:395:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT

    // $ANTLR start QNAME
    public final void mQNAME() throws RecognitionException {
        try {
            int _type = QNAME;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:398:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+ ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+ ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:26: ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='.') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:27: '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    	    {
            	    	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse =
            	    	            new MismatchedSetException(null,input);
            	    	        recover(mse);    throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QNAME

    // $ANTLR start TEXT_33_
    public final void mTEXT_33_() throws RecognitionException {
        try {
            int _type = TEXT_33_;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:402:1: ( ( '!' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:403:2: ( '!' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:403:2: ( '!' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:403:3: '!'
            {
            match('!'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:403:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='-'||(LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT_33_

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='\n') ) {
                    alt7=1;
                }
                else {
                    alt7=2;}
            }
            else if ( (LA7_0=='\n') ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("407:2: ( '\\r\\n' | '\\r' | '\\n' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LB

    // $ANTLR start TEXT_35_
    public final void mTEXT_35_() throws RecognitionException {
        try {
            int _type = TEXT_35_;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:410:1: ( ( '#' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:411:2: ( '#' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:411:2: ( '#' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:411:3: '#'
            {
            match('#'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:411:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='-'||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT_35_

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:1: ( ( ' ' | '\\t' | '\\f' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:415:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start QUOTED_60_62
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:418:1: ( ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:2: ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:2: ( '<' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:3: '<'
            {
            match('<'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:7: (~ ( '>' ) | ( '\\\\' '>' ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2=='>') ) {
                        int LA9_4 = input.LA(3);

                        if ( ((LA9_4>='\u0000' && LA9_4<='\uFFFE')) ) {
                            alt9=2;
                        }

                        else {
                            alt9=1;
                        }

                    }
                    else if ( ((LA9_2>='\u0000' && LA9_2<='=')||(LA9_2>='?' && LA9_2<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='=')||(LA9_0>='?' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:8: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:15: ( '\\\\' '>' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:15: ( '\\\\' '>' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:16: '\\\\' '>'
            	    {
            	    match('\\'); 
            	    match('>'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:26: ( '>' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:27: '>'
            {
            match('>'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_60_62

    // $ANTLR start QUOTED_39_39
    public final void mQUOTED_39_39() throws RecognitionException {
        try {
            int _type = QUOTED_39_39;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:1: ( ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:2: ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:2: ( '\\'' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:3: '\\''
            {
            match('\''); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:8: (~ ( '\\'' ) | ( '\\\\' '\\'' ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\\') ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2=='\'') ) {
                        int LA10_4 = input.LA(3);

                        if ( ((LA10_4>='\u0000' && LA10_4<='\uFFFE')) ) {
                            alt10=2;
                        }

                        else {
                            alt10=1;
                        }

                    }
                    else if ( ((LA10_2>='\u0000' && LA10_2<='&')||(LA10_2>='(' && LA10_2<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:9: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:17: ( '\\\\' '\\'' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:17: ( '\\\\' '\\'' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:18: '\\\\' '\\''
            	    {
            	    match('\\'); 
            	    match('\''); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:29: ( '\\'' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:423:30: '\\''
            {
            match('\''); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_39_39

    // $ANTLR start QUOTED_36_36
    public final void mQUOTED_36_36() throws RecognitionException {
        try {
            int _type = QUOTED_36_36;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:426:1: ( ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:2: ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:2: ( '$' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:3: '$'
            {
            match('$'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:7: (~ ( '$' ) | ( '\\\\' '$' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='$') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='\uFFFE')) ) {
                            alt11=2;
                        }

                        else {
                            alt11=1;
                        }

                    }
                    else if ( ((LA11_2>='\u0000' && LA11_2<='#')||(LA11_2>='%' && LA11_2<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='#')||(LA11_0>='%' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:8: ~ ( '$' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='%' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:15: ( '\\\\' '$' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:15: ( '\\\\' '$' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:16: '\\\\' '$'
            	    {
            	    match('\\'); 
            	    match('$'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:26: ( '$' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:427:27: '$'
            {
            match('$'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_36_36

    // $ANTLR start QUOTED_34_34
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:430:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:2: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:3: '\"'
            {
            match('\"'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2=='\"') ) {
                        int LA12_4 = input.LA(3);

                        if ( ((LA12_4>='\u0000' && LA12_4<='\uFFFE')) ) {
                            alt12=2;
                        }

                        else {
                            alt12=1;
                        }

                    }
                    else if ( ((LA12_2>='\u0000' && LA12_2<='!')||(LA12_2>='#' && LA12_2<='\uFFFE')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFE')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:15: ( '\\\\' '\"' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:15: ( '\\\\' '\"' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:26: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:431:27: '\"'
            {
            match('\"'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_34_34

    public void mTokens() throws RecognitionException {
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:8: ( T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | COMMENTS | TEXT | QNAME | TEXT_33_ | LB | TEXT_35_ | WS | QUOTED_60_62 | QUOTED_39_39 | QUOTED_36_36 | QUOTED_34_34 )
        int alt13=39;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:10: T15
                {
                mT15(); 

                }
                break;
            case 2 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:14: T16
                {
                mT16(); 

                }
                break;
            case 3 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:18: T17
                {
                mT17(); 

                }
                break;
            case 4 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:22: T18
                {
                mT18(); 

                }
                break;
            case 5 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:26: T19
                {
                mT19(); 

                }
                break;
            case 6 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:30: T20
                {
                mT20(); 

                }
                break;
            case 7 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:34: T21
                {
                mT21(); 

                }
                break;
            case 8 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:38: T22
                {
                mT22(); 

                }
                break;
            case 9 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:42: T23
                {
                mT23(); 

                }
                break;
            case 10 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:46: T24
                {
                mT24(); 

                }
                break;
            case 11 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:50: T25
                {
                mT25(); 

                }
                break;
            case 12 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:54: T26
                {
                mT26(); 

                }
                break;
            case 13 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:58: T27
                {
                mT27(); 

                }
                break;
            case 14 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:62: T28
                {
                mT28(); 

                }
                break;
            case 15 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:66: T29
                {
                mT29(); 

                }
                break;
            case 16 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:70: T30
                {
                mT30(); 

                }
                break;
            case 17 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:74: T31
                {
                mT31(); 

                }
                break;
            case 18 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:78: T32
                {
                mT32(); 

                }
                break;
            case 19 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:82: T33
                {
                mT33(); 

                }
                break;
            case 20 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:86: T34
                {
                mT34(); 

                }
                break;
            case 21 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:90: T35
                {
                mT35(); 

                }
                break;
            case 22 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:94: T36
                {
                mT36(); 

                }
                break;
            case 23 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:98: T37
                {
                mT37(); 

                }
                break;
            case 24 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:102: T38
                {
                mT38(); 

                }
                break;
            case 25 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:106: T39
                {
                mT39(); 

                }
                break;
            case 26 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:110: T40
                {
                mT40(); 

                }
                break;
            case 27 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:114: T41
                {
                mT41(); 

                }
                break;
            case 28 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:118: T42
                {
                mT42(); 

                }
                break;
            case 29 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:122: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 30 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:131: TEXT
                {
                mTEXT(); 

                }
                break;
            case 31 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:136: QNAME
                {
                mQNAME(); 

                }
                break;
            case 32 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:142: TEXT_33_
                {
                mTEXT_33_(); 

                }
                break;
            case 33 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:151: LB
                {
                mLB(); 

                }
                break;
            case 34 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:154: TEXT_35_
                {
                mTEXT_35_(); 

                }
                break;
            case 35 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:163: WS
                {
                mWS(); 

                }
                break;
            case 36 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:166: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;
            case 37 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:179: QUOTED_39_39
                {
                mQUOTED_39_39(); 

                }
                break;
            case 38 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:192: QUOTED_36_36
                {
                mQUOTED_36_36(); 

                }
                break;
            case 39 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:205: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\2\33\1\uffff\1\33\2\uffff\1\33\1\uffff\2\33\1\56\1\33"+
        "\11\uffff\3\33\1\uffff\1\33\11\uffff\2\33\1\uffff\1\33\1\66\4\33"+
        "\2\uffff\6\33\1\101\1\uffff\12\33\1\uffff\4\33\1\120\4\33\1\125"+
        "\3\33\1\131\1\uffff\3\33\1\136\1\uffff\2\33\1\141\1\uffff\1\142"+
        "\3\33\1\uffff\1\146\1\147\2\uffff\1\150\2\33\3\uffff\1\33\1\154"+
        "\1\33\1\uffff\1\156\1\uffff";
    static final String DFA13_eofS =
        "\157\uffff";
    static final String DFA13_minS =
        "\1\11\2\56\1\uffff\1\56\2\uffff\1\56\1\uffff\2\56\1\72\1\56\11"+
        "\uffff\3\56\1\uffff\1\56\11\uffff\2\56\1\uffff\1\56\1\55\4\56\2"+
        "\uffff\6\56\1\55\1\uffff\12\56\1\uffff\4\56\1\55\4\56\1\55\3\56"+
        "\1\55\1\uffff\3\56\1\55\1\uffff\2\56\1\55\1\uffff\1\55\3\56\1\uffff"+
        "\2\55\2\uffff\1\55\2\56\3\uffff\1\56\1\55\1\56\1\uffff\1\55\1\uffff";
    static final String DFA13_maxS =
        "\1\175\2\172\1\uffff\1\172\2\uffff\1\172\1\uffff\2\172\1\72\1\172"+
        "\11\uffff\3\172\1\uffff\1\172\11\uffff\2\172\1\uffff\6\172\2\uffff"+
        "\7\172\1\uffff\12\172\1\uffff\16\172\1\uffff\4\172\1\uffff\3\172"+
        "\1\uffff\4\172\1\uffff\2\172\2\uffff\3\172\3\uffff\3\172\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\3\uffff\1\4\1\uffff\1\6\1\7\1\uffff\1\11\4\uffff\1\17\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\1\27\1\30\3\uffff\1\35\1\uffff\1\36\1\40\1"+
        "\41\1\42\1\43\1\44\1\45\1\46\1\47\2\uffff\1\37\6\uffff\1\20\1\14"+
        "\7\uffff\1\33\12\uffff\1\2\16\uffff\1\15\4\uffff\1\3\3\uffff\1\13"+
        "\4\uffff\1\16\2\uffff\1\12\1\31\3\uffff\1\5\1\10\1\32\3\uffff\1"+
        "\1\1\uffff\1\34";
    static final String DFA13_specialS =
        "\157\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\37\1\35\1\uffff\1\37\1\35\22\uffff\1\37\1\34\1\43\1\36\1"+
            "\42\2\uffff\1\41\1\21\1\22\1\24\1\23\1\3\1\33\1\uffff\1\31\12"+
            "\33\1\13\1\10\1\40\1\15\1\uffff\1\25\1\uffff\2\32\1\27\1\26"+
            "\1\32\1\2\2\32\1\4\5\32\1\7\1\30\1\32\1\12\1\1\1\11\2\32\1\14"+
            "\3\32\1\17\1\uffff\1\20\1\uffff\1\32\1\uffff\32\32\1\5\1\16"+
            "\1\6",
            "\1\46\22\uffff\23\32\1\45\4\32\1\44\1\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\16\32\1\47\13\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\14\32\1\51\1\50\14\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "\1\46\22\uffff\17\32\1\52\12\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\16\32\1\53\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\24\32\1\54\5\32\4\uffff\1\32\1\uffff\32\32",
            "\1\55",
            "\1\46\22\uffff\10\32\1\57\21\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46\22\uffff\4\32\1\60\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\16\32\1\61\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\21\32\1\62\10\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46\22\uffff\15\32\1\63\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\1\64\31\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\21\32\1\65\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\17\32\1\67\12\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\23\32\1\70\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\12\32\1\71\17\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\72\16\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\46\22\uffff\23\32\1\73\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\74\24\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\75\16\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\76\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\23\32\1\77\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\21\32\1\100\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "\1\46\22\uffff\16\32\1\102\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\10\32\1\103\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\104\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\105\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\7\32\1\106\22\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\10\32\1\107\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\110\16\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\3\32\1\111\26\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\1\112\31\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\23\32\1\113\6\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\21\32\1\114\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\16\32\1\115\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\15\32\1\116\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\117\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\15\32\1\121\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\122\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\123\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\27\32\1\124\2\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\23\32\1\126\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\15\32\1\127\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\130\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "\1\46\22\uffff\4\32\1\132\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\2\32\1\133\27\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\134\24\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\3\32\1\135\26\32\4\uffff"+
            "\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\22\32\1\137\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\140\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\23\32\1\143\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\10\32\1\144\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\145\25\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\15\32\1\151\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\152\24\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "\1\46\22\uffff\4\32\1\153\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\3\32\1\155\26\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | COMMENTS | TEXT | QNAME | TEXT_33_ | LB | TEXT_35_ | WS | QUOTED_60_62 | QUOTED_39_39 | QUOTED_36_36 | QUOTED_34_34 );";
        }
    }
 

}
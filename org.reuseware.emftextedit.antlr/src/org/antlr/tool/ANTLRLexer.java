// $ANTLR 2.7.7 (2006-01-29): "antlr.g" -> "ANTLRLexer.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.tool;
import java.util.*;
import java.io.*;
import org.antlr.analysis.*;
import org.antlr.misc.*;
import antlr.*;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class ANTLRLexer extends antlr.CharScanner implements ANTLRTokenTypes, TokenStream
 {

    /** advance the current column number by one; don't do tabs.
     *  we want char position in line to be sent to AntlrWorks.
     */
    public void tab() {
		setColumn( getColumn()+1 );
    }
public ANTLRLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public ANTLRLexer(Reader in) {
	this(new CharBuffer(in));
}
public ANTLRLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public ANTLRLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("lexer", this), new Integer(40));
	literals.put(new ANTLRHashString("scope", this), new Integer(32));
	literals.put(new ANTLRHashString("finally", this), new Integer(64));
	literals.put(new ANTLRHashString("throws", this), new Integer(58));
	literals.put(new ANTLRHashString("fragment", this), new Integer(36));
	literals.put(new ANTLRHashString("private", this), new Integer(54));
	literals.put(new ANTLRHashString("grammar", this), new Integer(42));
	literals.put(new ANTLRHashString("tokens", this), new Integer(5));
	literals.put(new ANTLRHashString("options", this), new Integer(4));
	literals.put(new ANTLRHashString("parser", this), new Integer(6));
	literals.put(new ANTLRHashString("tree", this), new Integer(41));
	literals.put(new ANTLRHashString("protected", this), new Integer(52));
	literals.put(new ANTLRHashString("returns", this), new Integer(57));
	literals.put(new ANTLRHashString("public", this), new Integer(53));
	literals.put(new ANTLRHashString("catch", this), new Integer(63));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				case '/':
				{
					mCOMMENT(true);
					theRetToken=_returnToken;
					break;
				}
				case '>':
				{
					mCLOSE_ELEMENT_OPTION(true);
					theRetToken=_returnToken;
					break;
				}
				case '@':
				{
					mAMPERSAND(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '?':
				{
					mQUESTION(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mLPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mRPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ':':
				{
					mCOLON(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mSTAR(true);
					theRetToken=_returnToken;
					break;
				}
				case '-':
				{
					mREWRITE(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case '!':
				{
					mBANG(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mOR(true);
					theRetToken=_returnToken;
					break;
				}
				case '~':
				{
					mNOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mRCURLY(true);
					theRetToken=_returnToken;
					break;
				}
				case '$':
				{
					mDOLLAR(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mCHAR_LITERAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mDOUBLE_QUOTE_STRING_LITERAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mINT(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mARG_ACTION(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mACTION(true);
					theRetToken=_returnToken;
					break;
				}
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':
				{
					mTOKEN_REF(true);
					theRetToken=_returnToken;
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					mRULE_REF(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='^') && (LA(2)=='(')) {
						mTREE_BEGIN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (LA(2)=='=')) {
						mPLUS_ASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (LA(2)=='>')) {
						mIMPLIES(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='.') && (LA(2)=='.')) {
						mRANGE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='<')) {
						mDOUBLE_ANGLE_STRING_LITERAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mOPEN_ELEMENT_OPTION(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (true)) {
						mPLUS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (true)) {
						mASSIGN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='^') && (true)) {
						mROOT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='.') && (true)) {
						mWILDCARD(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\n':  case '\r':
		{
			{
			switch ( LA(1)) {
			case '\r':
			{
				match('\r');
				break;
			}
			case '\n':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			match('\n');
			if ( inputState.guessing==0 ) {
				newline();
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		Token t=null;
		
		{
		if ((LA(1)=='/') && (LA(2)=='/')) {
			mSL_COMMENT(false);
		}
		else if ((LA(1)=='/') && (LA(2)=='*')) {
			mML_COMMENT(true);
			t=_returnToken;
			if ( inputState.guessing==0 ) {
				_ttype = t.getType();
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;
		
		match("//");
		{
		boolean synPredMatched139 = false;
		if (((LA(1)==' ') && (LA(2)=='$'))) {
			int _m139 = mark();
			synPredMatched139 = true;
			inputState.guessing++;
			try {
				{
				match(" $ANTLR");
				}
			}
			catch (RecognitionException pe) {
				synPredMatched139 = false;
			}
			rewind(_m139);
inputState.guessing--;
		}
		if ( synPredMatched139 ) {
			match(" $ANTLR ");
			mSRC(false);
			{
			switch ( LA(1)) {
			case '\r':
			{
				match('\r');
				break;
			}
			case '\n':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			match('\n');
		}
		else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
			{
			_loop142:
			do {
				// nongreedy exit test
				if ((LA(1)=='\n'||LA(1)=='\r') && (true)) break _loop142;
				if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
					matchNot(EOF_CHAR);
				}
				else {
					break _loop142;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case '\r':
			{
				match('\r');
				break;
			}
			case '\n':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			match('\n');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( inputState.guessing==0 ) {
			newline();
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;
		
		match("/*");
		{
		if (((LA(1)=='*') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')))&&( LA(2)!='/' )) {
			match('*');
			if ( inputState.guessing==0 ) {
				_ttype = DOC_COMMENT;
			}
		}
		else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		_loop148:
		do {
			// nongreedy exit test
			if ((LA(1)=='*') && (LA(2)=='/')) break _loop148;
			switch ( LA(1)) {
			case '\r':
			{
				match('\r');
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
				if ((_tokenSet_0.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
					{
					match(_tokenSet_0);
					}
				}
			else {
				break _loop148;
			}
			}
		} while (true);
		}
		match("*/");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
/** Reset the file and line information; useful when the grammar
 *  has been generated so that errors are shown relative to the
 *  original file like the old C preprocessor used to do.
 */
	protected final void mSRC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SRC;
		int _saveIndex;
		Token file=null;
		Token line=null;
		
		match("src");
		match(' ');
		mACTION_STRING_LITERAL(true);
		file=_returnToken;
		match(' ');
		mINT(true);
		line=_returnToken;
		if ( inputState.guessing==0 ) {
			
					newline();
					setFilename(file.getText().substring(1,file.getText().length()-1));
					setLine(Integer.parseInt(line.getText())-1);  // -1 because SL_COMMENT will increment the line no. KR
					_ttype = Token.SKIP; // don't let this go to the parser
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOPEN_ELEMENT_OPTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPEN_ELEMENT_OPTION;
		int _saveIndex;
		
		match('<');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCLOSE_ELEMENT_OPTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CLOSE_ELEMENT_OPTION;
		int _saveIndex;
		
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAMPERSAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMPERSAND;
		int _saveIndex;
		
		match('@');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mQUESTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUESTION;
		int _saveIndex;
		
		match('?');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mTREE_BEGIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TREE_BEGIN;
		int _saveIndex;
		
		match("^(");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		int _saveIndex;
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASSIGN;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS_ASSIGN;
		int _saveIndex;
		
		match("+=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIMPLIES(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IMPLIES;
		int _saveIndex;
		
		match("=>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mREWRITE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REWRITE;
		int _saveIndex;
		
		match("->");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mROOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ROOT;
		int _saveIndex;
		
		match('^');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBANG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BANG;
		int _saveIndex;
		
		match('!');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OR;
		int _saveIndex;
		
		match('|');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWILDCARD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WILDCARD;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRANGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RANGE;
		int _saveIndex;
		
		match("..");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT;
		int _saveIndex;
		
		match('~');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RCURLY;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOLLAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOLLAR;
		int _saveIndex;
		
		match('$');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHAR_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHAR_LITERAL;
		int _saveIndex;
		
		match('\'');
		{
		_loop175:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mESC(false);
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
				if ((_tokenSet_1.member(LA(1)))) {
					matchNot('\'');
				}
			else {
				break _loop175;
			}
			}
		} while (true);
		}
		match('\'');
		if ( inputState.guessing==0 ) {
			
					StringBuffer s = Grammar.getUnescapedStringFromGrammarStringLiteral(new String(text.getBuffer(),_begin,text.length()-_begin));
					if ( s.length()>1 ) {
						_ttype = STRING_LITERAL;
					}
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESC;
		int _saveIndex;
		
		match('\\');
		{
		if ((LA(1)=='n') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('n');
		}
		else if ((LA(1)=='r') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('r');
		}
		else if ((LA(1)=='t') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('t');
		}
		else if ((LA(1)=='b') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('b');
		}
		else if ((LA(1)=='f') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('f');
		}
		else if ((LA(1)=='"') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('"');
		}
		else if ((LA(1)=='\'') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('\'');
		}
		else if ((LA(1)=='\\') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('\\');
		}
		else if ((LA(1)=='>') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('>');
		}
		else if (((LA(1) >= '0' && LA(1) <= '3')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			{
			matchRange('0','3');
			}
			{
			if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				{
				matchRange('0','9');
				}
				{
				if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
					matchRange('0','9');
				}
				else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
		}
		else if (((LA(1) >= '4' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			{
			matchRange('4','7');
			}
			{
			if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				{
				matchRange('0','9');
				}
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
		}
		else if ((LA(1)=='u') && (_tokenSet_2.member(LA(2)))) {
			match('u');
			mXDIGIT(false);
			mXDIGIT(false);
			mXDIGIT(false);
			mXDIGIT(false);
		}
		else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			matchNot(EOF_CHAR);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOUBLE_QUOTE_STRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOUBLE_QUOTE_STRING_LITERAL;
		int _saveIndex;
		
		match('"');
		{
		_loop178:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				_saveIndex=text.length();
				match('\\');
				text.setLength(_saveIndex);
				match('"');
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
				if ((_tokenSet_3.member(LA(1)))) {
					matchNot('"');
				}
			else {
				break _loop178;
			}
			}
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOUBLE_ANGLE_STRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOUBLE_ANGLE_STRING_LITERAL;
		int _saveIndex;
		
		match("<<");
		{
		_loop181:
		do {
			// nongreedy exit test
			if ((LA(1)=='>') && (LA(2)=='>')) break _loop181;
			if ((LA(1)=='\n') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				matchNot(EOF_CHAR);
			}
			else {
				break _loop181;
			}
			
		} while (true);
		}
		match(">>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mXDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = XDIGIT;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			matchRange('0','9');
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':
		{
			matchRange('a','f');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':
		{
			matchRange('A','F');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGIT;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT;
		int _saveIndex;
		
		{
		int _cnt195=0;
		_loop195:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt195>=1 ) { break _loop195; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt195++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mARG_ACTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ARG_ACTION;
		int _saveIndex;
		
		mNESTED_ARG_ACTION(false);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNESTED_ARG_ACTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NESTED_ARG_ACTION;
		int _saveIndex;
		
		_saveIndex=text.length();
		match('[');
		text.setLength(_saveIndex);
		{
		_loop199:
		do {
			switch ( LA(1)) {
			case '[':
			{
				mNESTED_ARG_ACTION(false);
				break;
			}
			case '\r':
			{
				match('\r');
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			case '"':
			{
				mACTION_STRING_LITERAL(false);
				break;
			}
			default:
				if ((_tokenSet_4.member(LA(1)))) {
					matchNot(']');
				}
			else {
				break _loop199;
			}
			}
		} while (true);
		}
		_saveIndex=text.length();
		match(']');
		text.setLength(_saveIndex);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mACTION_STRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ACTION_STRING_LITERAL;
		int _saveIndex;
		
		match('"');
		{
		_loop211:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mACTION_ESC(false);
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
				if ((_tokenSet_3.member(LA(1)))) {
					matchNot('"');
				}
			else {
				break _loop211;
			}
			}
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mACTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ACTION;
		int _saveIndex;
		int actionLine=getLine(); int actionColumn = getColumn();
		
		mNESTED_ACTION(false);
		{
		if ((LA(1)=='?')) {
			_saveIndex=text.length();
			match('?');
			text.setLength(_saveIndex);
			if ( inputState.guessing==0 ) {
				_ttype = SEMPRED;
			}
		}
		else {
		}
		
		}
		if ( inputState.guessing==0 ) {
			
						Token t = makeToken(_ttype);
						String action = new String(text.getBuffer(),_begin,text.length()-_begin);
						action = action.substring(1,action.length()-1);
						t.setText(action);
						t.setLine(actionLine);			// set action line to start
						t.setColumn(actionColumn);
						_token = t;
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNESTED_ACTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NESTED_ACTION;
		int _saveIndex;
		
		match('{');
		{
		_loop205:
		do {
			// nongreedy exit test
			if ((LA(1)=='}') && (true)) break _loop205;
			if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				{
				switch ( LA(1)) {
				case '\r':
				{
					match('\r');
					match('\n');
					if ( inputState.guessing==0 ) {
						newline();
					}
					break;
				}
				case '\n':
				{
					match('\n');
					if ( inputState.guessing==0 ) {
						newline();
					}
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
			}
			else if ((LA(1)=='{') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				mNESTED_ACTION(false);
			}
			else if ((LA(1)=='\'') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				mACTION_CHAR_LITERAL(false);
			}
			else if ((LA(1)=='/') && (LA(2)=='*'||LA(2)=='/')) {
				mCOMMENT(false);
			}
			else if ((LA(1)=='"') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				mACTION_STRING_LITERAL(false);
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				matchNot(EOF_CHAR);
			}
			else {
				break _loop205;
			}
			
		} while (true);
		}
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mACTION_CHAR_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ACTION_CHAR_LITERAL;
		int _saveIndex;
		
		match('\'');
		{
		_loop208:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mACTION_ESC(false);
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
				if ((_tokenSet_1.member(LA(1)))) {
					matchNot('\'');
				}
			else {
				break _loop208;
			}
			}
		} while (true);
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mACTION_ESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ACTION_ESC;
		int _saveIndex;
		
		if ((LA(1)=='\\') && (LA(2)=='\'')) {
			match("\\'");
		}
		else if ((LA(1)=='\\') && (LA(2)=='"')) {
			match("\\\"");
		}
		else if ((LA(1)=='\\') && (_tokenSet_5.member(LA(2)))) {
			match('\\');
			{
			match(_tokenSet_5);
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mTOKEN_REF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TOKEN_REF;
		int _saveIndex;
		
		matchRange('A','Z');
		{
		_loop216:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			default:
			{
				break _loop216;
			}
			}
		} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRULE_REF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RULE_REF;
		int _saveIndex;
		
			int t=0;
		
		
		t=mINTERNAL_RULE_REF(false);
		if ( inputState.guessing==0 ) {
			_ttype=t;
		}
		{
		if (( true )&&(t==OPTIONS)) {
			mWS_LOOP(false);
			{
			if ((LA(1)=='{')) {
				match('{');
				if ( inputState.guessing==0 ) {
					_ttype = OPTIONS;
				}
			}
			else {
			}
			
			}
		}
		else if (( true )&&(t==TOKENS)) {
			mWS_LOOP(false);
			{
			if ((LA(1)=='{')) {
				match('{');
				if ( inputState.guessing==0 ) {
					_ttype = TOKENS;
				}
			}
			else {
			}
			
			}
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final int  mINTERNAL_RULE_REF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int t;
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INTERNAL_RULE_REF;
		int _saveIndex;
		
			t = RULE_REF;
		
		
		matchRange('a','z');
		{
		_loop226:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			default:
			{
				break _loop226;
			}
			}
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			t = testLiteralsTable(t);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
		return t;
	}
	
	protected final void mWS_LOOP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS_LOOP;
		int _saveIndex;
		
		{
		_loop223:
		do {
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				break;
			}
			case '/':
			{
				mCOMMENT(false);
				break;
			}
			default:
			{
				break _loop223;
			}
			}
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mWS_OPT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS_OPT;
		int _saveIndex;
		
		{
		if ((_tokenSet_6.member(LA(1)))) {
			mWS(false);
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[8];
		data[0]=-9224L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-549755814920L;
		data[1]=-268435457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 287948901175001088L, 541165879422L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-17179870216L;
		data[1]=-268435457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=-17179878408L;
		data[1]=-671088641L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[8];
		data[0]=-566935683080L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 4294977024L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	
	}

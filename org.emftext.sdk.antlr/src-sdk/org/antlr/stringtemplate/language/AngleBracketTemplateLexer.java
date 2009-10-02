// $ANTLR 2.7.7 (2006-01-29): "angle.bracket.template.g" -> "AngleBracketTemplateLexer.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2003-2004 Terence Parr
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
    package org.antlr.stringtemplate.language;
    import org.antlr.stringtemplate.*;
    import java.io.*;

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

/** Break up an input text stream into chunks of either plain text
 *  or template actions in "<...>".  Treat IF and ENDIF tokens
 *  specially.
 */
public class AngleBracketTemplateLexer extends antlr.CharScanner implements AngleBracketTemplateLexerTokenTypes, TokenStream
 {

protected String currentIndent = null;
protected StringTemplate self;

public AngleBracketTemplateLexer(StringTemplate self, Reader r) {
	this(r);
	this.self = self;
}

public void reportError(RecognitionException e) {
	self.error("<...> chunk lexer error", e);
}

protected boolean upcomingELSE(int i) throws CharStreamException {
 	return LA(i)=='<'&&LA(i+1)=='e'&&LA(i+2)=='l'&&LA(i+3)=='s'&&LA(i+4)=='e'&&
 	       LA(i+5)=='>';
}

protected boolean upcomingENDIF(int i) throws CharStreamException {
	return LA(i)=='<'&&LA(i+1)=='e'&&LA(i+2)=='n'&&LA(i+3)=='d'&&LA(i+4)=='i'&&
	       LA(i+5)=='f'&&LA(i+6)=='>';
}

protected boolean upcomingAtEND(int i) throws CharStreamException {
	return LA(i)=='<'&&LA(i+1)=='@'&&LA(i+2)=='e'&&LA(i+3)=='n'&&LA(i+4)=='d'&&LA(i+5)=='>';
}

protected boolean upcomingNewline(int i) throws CharStreamException {
	return (LA(i)=='\r'&&LA(i+1)=='\n')||LA(i)=='\n';
}
public AngleBracketTemplateLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public AngleBracketTemplateLexer(Reader in) {
	this(new CharBuffer(in));
}
public AngleBracketTemplateLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public AngleBracketTemplateLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
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
				case '\n':  case '\r':
				{
					mNEWLINE(true);
					theRetToken=_returnToken;
					break;
				}
				case '<':
				{
					mACTION(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if (((_tokenSet_0.member(LA(1))))&&(LA(1)!='\r'&&LA(1)!='\n')) {
						mLITERAL(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
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

	public final void mLITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LITERAL;
		int _saveIndex;
		Token ind=null;
		
		if (!(LA(1)!='\r'&&LA(1)!='\n'))
		  throw new SemanticException("LA(1)!='\\r'&&LA(1)!='\\n'");
		{
		int _cnt5=0;
		_loop5:
		do {
			
			int loopStartIndex=text.length();
			int col=getColumn();
			
			if ((LA(1)=='\\') && (LA(2)=='<')) {
				_saveIndex=text.length();
				match('\\');
				text.setLength(_saveIndex);
				match('<');
			}
			else if ((LA(1)=='\\') && (LA(2)=='>') && (true) && (true) && (true) && (true) && (true)) {
				_saveIndex=text.length();
				match('\\');
				text.setLength(_saveIndex);
				match('>');
			}
			else if ((LA(1)=='\\') && (LA(2)=='\\') && (true) && (true) && (true) && (true) && (true)) {
				_saveIndex=text.length();
				match('\\');
				text.setLength(_saveIndex);
				match('\\');
			}
			else if ((LA(1)=='\\') && (_tokenSet_1.member(LA(2))) && (true) && (true) && (true) && (true) && (true)) {
				match('\\');
				{
				match(_tokenSet_1);
				}
			}
			else if ((LA(1)=='\t'||LA(1)==' ') && (true) && (true) && (true) && (true) && (true) && (true)) {
				mINDENT(true);
				ind=_returnToken;
				
				if ( col==1 && LA(1)=='<' ) {
				// store indent in ASTExpr not in a literal
				currentIndent=ind.getText();
							  text.setLength(loopStartIndex); // reset length to wack text
				}
				else currentIndent=null;
				
			}
			else if ((_tokenSet_0.member(LA(1))) && (true) && (true) && (true) && (true) && (true) && (true)) {
				{
				match(_tokenSet_0);
				}
			}
			else {
				if ( _cnt5>=1 ) { break _loop5; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt5++;
		} while (true);
		}
		if ((new String(text.getBuffer(),_begin,text.length()-_begin)).length()==0) {_ttype = Token.SKIP;}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mINDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INDENT;
		int _saveIndex;
		
		{
		int _cnt8=0;
		_loop8:
		do {
			if ((LA(1)==' ') && (true) && (true) && (true) && (true) && (true) && (true)) {
				match(' ');
			}
			else if ((LA(1)=='\t') && (true) && (true) && (true) && (true) && (true) && (true)) {
				match('\t');
			}
			else {
				if ( _cnt8>=1 ) { break _loop8; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt8++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNEWLINE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NEWLINE;
		int _saveIndex;
		
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
		newline(); currentIndent=null;
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
		
		int startCol = getColumn();
		
		
		if ((LA(1)=='<') && (LA(2)=='\\') && (_tokenSet_2.member(LA(3))) && (_tokenSet_3.member(LA(4))) && (true) && (true) && (true)) {
			StringBuffer buf = new StringBuffer(); char uc = '\u0000';
			_saveIndex=text.length();
			match('<');
			text.setLength(_saveIndex);
			{
			int _cnt13=0;
			_loop13:
			do {
				if ((LA(1)=='\\')) {
					uc=mESC_CHAR(false);
					buf.append(uc);
				}
				else {
					if ( _cnt13>=1 ) { break _loop13; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt13++;
			} while (true);
			}
			_saveIndex=text.length();
			match('>');
			text.setLength(_saveIndex);
			text.setLength(_begin); text.append(buf.toString()); _ttype = LITERAL;
		}
		else if ((LA(1)=='<') && (LA(2)=='!') && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && (true) && (true) && (true)) {
			mCOMMENT(false);
			_ttype = Token.SKIP;
		}
		else if ((LA(1)=='<') && (_tokenSet_4.member(LA(2))) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
			{
			if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='f') && (LA(4)==' '||LA(4)=='(') && (_tokenSet_5.member(LA(5))) && ((LA(6) >= '\u0001' && LA(6) <= '\ufffe')) && ((LA(7) >= '\u0001' && LA(7) <= '\ufffe'))) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				match("if");
				{
				_loop16:
				do {
					if ((LA(1)==' ')) {
						_saveIndex=text.length();
						match(' ');
						text.setLength(_saveIndex);
					}
					else {
						break _loop16;
					}
					
				} while (true);
				}
				match("(");
				mIF_EXPR(false);
				match(")");
				_saveIndex=text.length();
				match('>');
				text.setLength(_saveIndex);
				_ttype = TemplateParser.IF;
				{
				if ((LA(1)=='\n'||LA(1)=='\r')) {
					{
					switch ( LA(1)) {
					case '\r':
					{
						_saveIndex=text.length();
						match('\r');
						text.setLength(_saveIndex);
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
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else {
				}
				
				}
			}
			else if ((LA(1)=='<') && (LA(2)=='e') && (LA(3)=='l') && (LA(4)=='s') && (LA(5)=='e') && (LA(6)=='i') && (LA(7)=='f')) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				match("elseif");
				{
				_loop20:
				do {
					if ((LA(1)==' ')) {
						_saveIndex=text.length();
						match(' ');
						text.setLength(_saveIndex);
					}
					else {
						break _loop20;
					}
					
				} while (true);
				}
				match("(");
				mIF_EXPR(false);
				match(")");
				_saveIndex=text.length();
				match('>');
				text.setLength(_saveIndex);
				_ttype = TemplateParser.ELSEIF;
				{
				if ((LA(1)=='\n'||LA(1)=='\r')) {
					{
					switch ( LA(1)) {
					case '\r':
					{
						_saveIndex=text.length();
						match('\r');
						text.setLength(_saveIndex);
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
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else {
				}
				
				}
			}
			else if ((LA(1)=='<') && (LA(2)=='e') && (LA(3)=='n') && (LA(4)=='d') && (LA(5)=='i') && (LA(6)=='f') && (LA(7)=='>')) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				match("endif");
				_saveIndex=text.length();
				match('>');
				text.setLength(_saveIndex);
				_ttype = TemplateParser.ENDIF;
				{
				if (((LA(1)=='\n'||LA(1)=='\r'))&&(startCol==1)) {
					{
					switch ( LA(1)) {
					case '\r':
					{
						_saveIndex=text.length();
						match('\r');
						text.setLength(_saveIndex);
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
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else {
				}
				
				}
			}
			else if ((LA(1)=='<') && (LA(2)=='e') && (LA(3)=='l') && (LA(4)=='s') && (LA(5)=='e') && (LA(6)=='>') && (true)) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				match("else");
				_saveIndex=text.length();
				match('>');
				text.setLength(_saveIndex);
				_ttype = TemplateParser.ELSE;
				{
				if ((LA(1)=='\n'||LA(1)=='\r')) {
					{
					switch ( LA(1)) {
					case '\r':
					{
						_saveIndex=text.length();
						match('\r');
						text.setLength(_saveIndex);
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
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else {
				}
				
				}
			}
			else if ((LA(1)=='<') && (LA(2)=='@') && (_tokenSet_6.member(LA(3))) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && ((LA(5) >= '\u0001' && LA(5) <= '\ufffe')) && ((LA(6) >= '\u0001' && LA(6) <= '\ufffe')) && (true)) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				_saveIndex=text.length();
				match('@');
				text.setLength(_saveIndex);
				{
				int _cnt29=0;
				_loop29:
				do {
					if ((_tokenSet_6.member(LA(1)))) {
						{
						match(_tokenSet_6);
						}
					}
					else {
						if ( _cnt29>=1 ) { break _loop29; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt29++;
				} while (true);
				}
				{
				switch ( LA(1)) {
				case '(':
				{
					_saveIndex=text.length();
					match("()");
					text.setLength(_saveIndex);
					_saveIndex=text.length();
					match('>');
					text.setLength(_saveIndex);
					_ttype = TemplateParser.REGION_REF;
					break;
				}
				case '>':
				{
					_saveIndex=text.length();
					match('>');
					text.setLength(_saveIndex);
					
							_ttype = TemplateParser.REGION_DEF;
							String t=new String(text.getBuffer(),_begin,text.length()-_begin);
							text.setLength(_begin); text.append(t+"::=");
							
					{
					if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
						{
						switch ( LA(1)) {
						case '\r':
						{
							_saveIndex=text.length();
							match('\r');
							text.setLength(_saveIndex);
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
						_saveIndex=text.length();
						match('\n');
						text.setLength(_saveIndex);
						newline();
					}
					else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true)) {
					}
					else {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
					}
					boolean atLeft = false;
					{
					int _cnt36=0;
					_loop36:
					do {
						if ((((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true))&&(!(upcomingAtEND(1)||(upcomingNewline(1)&&upcomingAtEND(2))))) {
							{
							if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true)) {
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
								newline(); atLeft = true;
							}
							else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true)) {
								matchNot(EOF_CHAR);
								atLeft = false;
							}
							else {
								throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
							}
							
							}
						}
						else {
							if ( _cnt36>=1 ) { break _loop36; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
						_cnt36++;
					} while (true);
					}
					{
					if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true)) {
						{
						switch ( LA(1)) {
						case '\r':
						{
							_saveIndex=text.length();
							match('\r');
							text.setLength(_saveIndex);
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
						_saveIndex=text.length();
						match('\n');
						text.setLength(_saveIndex);
						newline(); atLeft = true;
					}
					else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && (true) && (true) && (true) && (true) && (true) && (true)) {
					}
					else {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
					}
					{
					if ((LA(1)=='<') && (LA(2)=='@')) {
						_saveIndex=text.length();
						match("<@end>");
						text.setLength(_saveIndex);
					}
					else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && (true)) {
						matchNot(EOF_CHAR);
						self.error("missing region "+t+" <@end> tag");
					}
					else {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
					}
					{
					if (((LA(1)=='\n'||LA(1)=='\r'))&&(atLeft)) {
						{
						switch ( LA(1)) {
						case '\r':
						{
							_saveIndex=text.length();
							match('\r');
							text.setLength(_saveIndex);
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
						_saveIndex=text.length();
						match('\n');
						text.setLength(_saveIndex);
						newline();
					}
					else {
					}
					
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
			else if ((LA(1)=='<') && (_tokenSet_4.member(LA(2))) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
				_saveIndex=text.length();
				match('<');
				text.setLength(_saveIndex);
				mEXPR(false);
				_saveIndex=text.length();
				match('>');
				text.setLength(_saveIndex);
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			
			ChunkToken t = new ChunkToken(_ttype, new String(text.getBuffer(),_begin,text.length()-_begin), currentIndent);
			_token = t;
				
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
	
	protected final char  mESC_CHAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		char uc='\u0000';
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESC_CHAR;
		int _saveIndex;
		Token a=null;
		Token b=null;
		Token c=null;
		Token d=null;
		
		if ((LA(1)=='\\') && (LA(2)=='n')) {
			_saveIndex=text.length();
			match("\\n");
			text.setLength(_saveIndex);
			uc = '\n';
		}
		else if ((LA(1)=='\\') && (LA(2)=='r')) {
			_saveIndex=text.length();
			match("\\r");
			text.setLength(_saveIndex);
			uc = '\r';
		}
		else if ((LA(1)=='\\') && (LA(2)=='t')) {
			_saveIndex=text.length();
			match("\\t");
			text.setLength(_saveIndex);
			uc = '\t';
		}
		else if ((LA(1)=='\\') && (LA(2)==' ')) {
			_saveIndex=text.length();
			match("\\ ");
			text.setLength(_saveIndex);
			uc = ' ';
		}
		else if ((LA(1)=='\\') && (LA(2)=='u')) {
			_saveIndex=text.length();
			match("\\u");
			text.setLength(_saveIndex);
			_saveIndex=text.length();
			mHEX(true);
			text.setLength(_saveIndex);
			a=_returnToken;
			_saveIndex=text.length();
			mHEX(true);
			text.setLength(_saveIndex);
			b=_returnToken;
			_saveIndex=text.length();
			mHEX(true);
			text.setLength(_saveIndex);
			c=_returnToken;
			_saveIndex=text.length();
			mHEX(true);
			text.setLength(_saveIndex);
			d=_returnToken;
			uc = (char)Integer.parseInt(a.getText()+b.getText()+c.getText()+d.getText(), 16);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
		return uc;
	}
	
	protected final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		
		int startCol = getColumn();
		
		
		match("<!");
		{
		_loop74:
		do {
			// nongreedy exit test
			if ((LA(1)=='!') && (LA(2)=='>') && (true) && (true) && (true) && (true) && (true)) break _loop74;
			if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
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
				newline();
			}
			else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
				matchNot(EOF_CHAR);
			}
			else {
				break _loop74;
			}
			
		} while (true);
		}
		match("!>");
		{
		if (((LA(1)=='\n'||LA(1)=='\r'))&&(startCol==1)) {
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
			newline();
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
	
	protected final void mIF_EXPR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IF_EXPR;
		int _saveIndex;
		
		{
		int _cnt61=0;
		_loop61:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mESC(false);
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
				newline();
				break;
			}
			case '{':
			{
				mSUBTEMPLATE(false);
				break;
			}
			case '(':
			{
				mNESTED_PARENS(false);
				break;
			}
			default:
				if ((_tokenSet_7.member(LA(1)))) {
					matchNot(')');
				}
			else {
				if ( _cnt61>=1 ) { break _loop61; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt61++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXPR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXPR;
		int _saveIndex;
		
		{
		int _cnt49=0;
		_loop49:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mESC(false);
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
				newline();
				break;
			}
			case '{':
			{
				mSUBTEMPLATE(false);
				break;
			}
			default:
				if ((LA(1)=='+'||LA(1)=='=') && (LA(2)=='"'||LA(2)=='<')) {
					{
					switch ( LA(1)) {
					case '=':
					{
						match('=');
						break;
					}
					case '+':
					{
						match('+');
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					}
					}
					mTEMPLATE(false);
				}
				else if ((LA(1)=='+'||LA(1)=='=') && (LA(2)=='{')) {
					{
					switch ( LA(1)) {
					case '=':
					{
						match('=');
						break;
					}
					case '+':
					{
						match('+');
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					}
					}
					mSUBTEMPLATE(false);
				}
				else if ((LA(1)=='+'||LA(1)=='=') && (_tokenSet_8.member(LA(2)))) {
					{
					switch ( LA(1)) {
					case '=':
					{
						match('=');
						break;
					}
					case '+':
					{
						match('+');
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					}
					}
					{
					match(_tokenSet_8);
					}
				}
				else if ((_tokenSet_9.member(LA(1)))) {
					matchNot('>');
				}
			else {
				if ( _cnt49>=1 ) { break _loop49; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt49++;
		} while (true);
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
		matchNot(EOF_CHAR);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSUBTEMPLATE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SUBTEMPLATE;
		int _saveIndex;
		
		match('{');
		{
		_loop67:
		do {
			switch ( LA(1)) {
			case '{':
			{
				mSUBTEMPLATE(false);
				break;
			}
			case '\\':
			{
				mESC(false);
				break;
			}
			default:
				if ((_tokenSet_10.member(LA(1)))) {
					matchNot('}');
				}
			else {
				break _loop67;
			}
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
	
	protected final void mTEMPLATE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEMPLATE;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '"':
		{
			match('"');
			{
			_loop52:
			do {
				if ((LA(1)=='\\')) {
					mESC(false);
				}
				else if ((_tokenSet_11.member(LA(1)))) {
					matchNot('"');
				}
				else {
					break _loop52;
				}
				
			} while (true);
			}
			match('"');
			break;
		}
		case '<':
		{
			match("<<");
			{
			if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && (true) && (true) && (true)) {
				{
				switch ( LA(1)) {
				case '\r':
				{
					_saveIndex=text.length();
					match('\r');
					text.setLength(_saveIndex);
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
				_saveIndex=text.length();
				match('\n');
				text.setLength(_saveIndex);
				newline();
			}
			else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			{
			_loop57:
			do {
				// nongreedy exit test
				if ((LA(1)=='>') && (LA(2)=='>') && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && (true) && (true) && (true) && (true)) break _loop57;
				if (((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && ((LA(5) >= '\u0001' && LA(5) <= '\ufffe')) && (true) && (true))&&(LA(3)=='>'&&LA(4)=='>')) {
					_saveIndex=text.length();
					match('\r');
					text.setLength(_saveIndex);
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else if (((LA(1)=='\n') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && (true) && (true) && (true))&&(LA(2)=='>'&&LA(3)=='>')) {
					_saveIndex=text.length();
					match('\n');
					text.setLength(_saveIndex);
					newline();
				}
				else if ((LA(1)=='\n'||LA(1)=='\r') && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && (true) && (true) && (true)) {
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
					newline();
				}
				else if (((LA(1) >= '\u0001' && LA(1) <= '\ufffe')) && ((LA(2) >= '\u0001' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0001' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0001' && LA(4) <= '\ufffe')) && (true) && (true) && (true)) {
					matchNot(EOF_CHAR);
				}
				else {
					break _loop57;
				}
				
			} while (true);
			}
			match(">>");
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
	
	protected final void mNESTED_PARENS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NESTED_PARENS;
		int _saveIndex;
		
		match('(');
		{
		int _cnt70=0;
		_loop70:
		do {
			switch ( LA(1)) {
			case '(':
			{
				mNESTED_PARENS(false);
				break;
			}
			case '\\':
			{
				mESC(false);
				break;
			}
			default:
				if ((_tokenSet_12.member(LA(1)))) {
					matchNot(')');
				}
			else {
				if ( _cnt70>=1 ) { break _loop70; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt70++;
		} while (true);
		}
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEX;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			matchRange('0','9');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':
		{
			matchRange('A','F');
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':
		{
			matchRange('a','f');
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
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[2048];
		data[0]=-1152921504606856194L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[2048];
		data[0]=-5764607523034234882L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[1025];
		data[0]=4294967296L;
		data[1]=14707067533131776L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[1025];
		data[0]=4899634919602388992L;
		data[1]=541434314878L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[2048];
		data[0]=-4611686018427387906L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[2048];
		data[0]=-2199023255554L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[2048];
		data[0]=-4611687117939015682L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[2048];
		data[0]=-3298534892546L;
		data[1]=-576460752571858945L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[2048];
		data[0]=-1152921521786716162L;
		data[1]=-576460752303423489L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[2048];
		data[0]=-6917537823734113282L;
		data[1]=-576460752571858945L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = new long[2048];
		data[0]=-2L;
		data[1]=-2882303761785552897L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[2048];
		data[0]=-17179869186L;
		data[1]=-268435457L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[2048];
		data[0]=-3298534883330L;
		data[1]=-268435457L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}

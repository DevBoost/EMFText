package org.strategoxt.imp.runtime.parser.tokens;

import static org.strategoxt.imp.runtime.parser.tokens.TokenKind.*;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;
import lpg.runtime.LexStream;
import lpg.runtime.PrsStream;
import lpg.runtime.Token;

/**
 * Wrapper class to add tokens to an LPG PrsStream.
 * 
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */
public class SGLRTokenizer {
	private final LexStream lexStream = new LexStream();
	
	private final PrsStream parseStream = new PrsStream(lexStream);
	
	/** Start of the last token */
	private int startOffset;
	
	public SGLRTokenizer(char[] input, String filename) {
		lexStream.initialize(input, filename);
		parseStream.resetTokenStream();
		startOffset = 0;
		
		// Token list must start with a bad token
		makeToken(0, TK_RESERVED, true);
	}
	
	public IToken currentToken() {
		if (parseStream.getSize() == 0) return null;
		
		return parseStream.getTokenAt(parseStream.getSize() - 1);
	}
	
	public PrsStream getParseStream() {
		return parseStream;
	}
	
	public LexStream getLexStream() {
		return lexStream;
	}
	
	public int getStartOffset() {
		return startOffset;
	}
	
	public void setStartOffset(int beginOffset) {
		this.startOffset = beginOffset;
	}
	
	public void endStream() {
		makeToken(startOffset + 1, TK_EOF, true);
	}
	
	public SGLRToken makeToken(int endOffset, TokenKind kind, boolean allowEmptyToken) {
		if (!allowEmptyToken && startOffset == endOffset) // empty token
			return null;
		
		//if (Debug.ENABLED) {
			assert endOffset >= startOffset || (kind == TK_RESERVED && startOffset == 0);
		//	if (parseStream.getTokens().size() > 0) {
		//		IToken lastToken = (IToken) parseStream.getTokens().get(parseStream.getTokens().size() - 1); 
		//		assert lastToken.getKind() == TK_RESERVED.ordinal()
		//			|| (lastToken.getStartOffset() + lastToken.getEndOffset()) == startOffset;
		//	}
		//}
		
		SGLRToken token = new SGLRToken(parseStream, startOffset, endOffset - 1, kind.ordinal());
		token.setTokenIndex(parseStream.getSize());
		
		// Add token and increment the stream size(!)
		parseStream.addToken(token);
		parseStream.setStreamLength(parseStream.getSize());
		
		startOffset = endOffset;
		
		return token;
	}
	
	// Bridge method
	public final SGLRToken makeToken(int endOffset, TokenKind kind) {
		return makeToken(endOffset, kind, false);
	}
	
	/**
	 * Creates an error token from existing tokens.
	 */
	public IToken makeErrorToken(IToken left, IToken right) {
		return new Token(parseStream, left.getStartOffset(), right.getEndOffset(), TK_ERROR.ordinal());
	}
	
	/**
	 * Creates an error token up to the next whitespace character.
	 */
	public IToken makeErrorToken(int offset) {		
		if (offset == lexStream.getStreamLength())
		    return makeErrorTokenBackwards(offset - 1);
		if (offset > lexStream.getStreamLength())
			return makeErrorTokenBackwards(lexStream.getStreamLength() - 1);

		int endOffset = offset;
		boolean onlySeenWhitespace = Character.isWhitespace(lexStream.getCharValue(endOffset));
		
		while (endOffset + 1 < lexStream.getStreamLength()) {
			boolean isWhitespace = isWhitespaceChar(endOffset+1);
			
			if (onlySeenWhitespace) {
				onlySeenWhitespace = isWhitespace;
				offset++;
			} else if (isWhitespace) {
				break;
			}
			
			endOffset++;
		}
		
		return new Token(parseStream, offset, endOffset, TK_ERROR.ordinal());
	}

	private boolean isWhitespaceChar(int streamPos) {
		char c = lexStream.getCharValue(streamPos);
		boolean isWhitespace = Character.isWhitespace(c);
		return isWhitespace;
	}
	
	/**
	 * Creates an error token on stream part
	 */
	public IToken makeErrorToken(int beginOffset, int endOffset) {		
		if (endOffset >= lexStream.getStreamLength()) {
			endOffset = lexStream.getStreamLength() - 1;
			beginOffset = Math.min(beginOffset, endOffset);
		}

		return new Token(parseStream, beginOffset, endOffset, TK_ERROR.ordinal());
	}
	
	public void changeTokenKinds(int beginOffset, int endOffset, TokenKind fromKind, TokenKind toKind) {
		int fromOrdinal = fromKind.ordinal();
		IPrsStream tokens = lexStream.getIPrsStream();
		for (int i = 0, end = tokens.getSize(); i < end; i++) {
			IToken token = tokens.getIToken(i);
			if (token.getEndOffset() >= beginOffset && token.getKind() == fromOrdinal)
				token.setKind(toKind.ordinal());
			if (token.getEndOffset() > endOffset)
				return;
		}
	}
	
	/**
	 * Creates an error token on stream part, backwards skipping whitespace
	 * 
	 * @param beginOffset       The begin offset of the erroneous location.
     * @param endOffset         The end offset of the erroneous location.
     * @param outerBeginOffset  The begin offset of the enclosing construct.
	 */
	public IToken makeErrorTokenSkipLayout(int beginOffset, int endOffset, int outerBeginOffset) {	    
		if (endOffset >= lexStream.getStreamLength()) {
			endOffset = lexStream.getStreamLength() - 1;
			beginOffset = Math.min(beginOffset, endOffset);
		}

		int skipLength;
		int newlineSkipLength = -1;
		
		for (skipLength = 0; beginOffset - skipLength > 0; skipLength++) {
			int offset = beginOffset - skipLength - 1;
			char c = lexStream.getCharValue(offset);
			if (!Character.isWhitespace(c)) {
			    if (newlineSkipLength != -1) {
			        if (lexStream.getLine(offset) != lexStream.getLine(outerBeginOffset)) {
	                    // Report the error at the next newline
			        	// if the outer construct started on a different line
			            skipLength = newlineSkipLength;
			        } else {
			        	// Skip to the previous token at the end of this line
			        	// if the outer construct started on the same line
			        	return makeErrorTokenBackwards(beginOffset - skipLength);
			        }
			    }
				break;
			}
			if (c == '\n')
			    newlineSkipLength = skipLength;
			    
		}
		
		return makeErrorToken(beginOffset - skipLength, endOffset - skipLength);
	}
	
	/**
	 * Creates an error token from the last whitespace character.
	 */
	public IToken makeErrorTokenBackwards(int offset) {
		int beginOffset = offset;
		boolean onlySeenWhitespace = true;
		
		while (beginOffset > 0) {
			char c = lexStream.getCharValue(beginOffset - 1);
			boolean isWhitespace = Character.isWhitespace(c);
			
			if (onlySeenWhitespace) {
				onlySeenWhitespace = isWhitespace;
			} else if (isWhitespace) {
				break;
			}
			
			beginOffset--;
		}
		
		return new Token(parseStream, beginOffset, offset, TK_ERROR.ordinal());
	}
	
	public static String dumpToString(IToken left, IToken right) {
		StringBuilder result = new StringBuilder();
		int last = right.getTokenIndex();
		
		for (int i = left.getTokenIndex(); i <= last; i++) {
			IToken token = left.getIPrsStream().getTokenAt(i);
			result.append(valueOf(token.getKind()));
			result.append(":");
			result.append(token.toString().replace("\n","\\n").replace("\r","\\r"));
			if (i < last) result.append(", ");
		}
		
		return result.toString();
	}
	
	public static final String dumpToString(IToken token) {
		return dumpToString(token, token);
	}
}

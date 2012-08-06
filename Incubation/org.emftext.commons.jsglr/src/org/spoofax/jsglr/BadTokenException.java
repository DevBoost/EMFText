package org.spoofax.jsglr;

import aterm.ATerm;
import aterm.ATermFactory;

/**
 * Exception thrown when a specific token was unexpected by the parser.
 * 
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */
public class BadTokenException extends SGLRException {
    private static final long serialVersionUID = -2050581505177108272L;

    private final int token, offset, lineNumber, columnNumber;

    public int getOffset() {
        return offset;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getToken() {
        return token;
    }
    
    public boolean isEOFToken() {
        return token == SGLR.EOF;
    }
    
    @Override
    public String getMessage() {
        return getShortMessage() + " at line " + lineNumber + ", column " + columnNumber;
    }
    
    @Override
    public String getShortMessage() {
        if (isEOFToken())
            return "Unexpected end of file";
        else
            return "Syntax error near unexpected character '" + (char) token + "'";
    }

    public BadTokenException(SGLR parser, int token, int offset, int lineNumber, int columnNumber) {
        super(parser);
        this.token = token;
        this.offset = offset;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
    

    @Override
    protected ATerm toLocationATerm() {
        ATermFactory factory = getParser().getFactory();
        return factory.makeAppl(
            factory.makeAFun("area", 6, false),
            factory.makeInt(getLineNumber()),
            factory.makeInt(getColumnNumber()),
            factory.makeInt(getLineNumber()),
            factory.makeInt(getColumnNumber()),
            factory.makeInt(getOffset() + 1),
            factory.makeInt(0)
        );
    }
}

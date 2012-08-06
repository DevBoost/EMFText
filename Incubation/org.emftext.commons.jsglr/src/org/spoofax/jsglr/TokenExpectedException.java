package org.spoofax.jsglr;

/**
 * Exception thrown when a specific token was expected by the parser.
 * 
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */
public class TokenExpectedException extends BadTokenException {
    private static final long serialVersionUID = -6612112750347760692L;
    
    private final String expected;

    public String getExpected() {
        return expected;
    }
    
    @Override
    public String getShortMessage() {
        return "Syntax error near expected token '" + expected + "'";
    }

    public TokenExpectedException(SGLR parser, String expected, int token, int offset, int lineNumber, int columnNumber) {
        super(parser, token, offset, lineNumber, columnNumber);
        this.expected = expected;
    }
}

package org.spoofax.jsglr;

/**
 * Exception thrown when the parser times out.
 * 
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */
public class ParseTimeoutException extends BadTokenException {
    private static final long serialVersionUID = -8773024983956495431L;

    @Override
    public String getShortMessage() {
        return "Parser time out";
    }
    
    public ParseTimeoutException(SGLR parser, int token, int offset, int lineNumber, int columnNumber) {
        super(parser, token, offset, lineNumber, columnNumber);
    }
}
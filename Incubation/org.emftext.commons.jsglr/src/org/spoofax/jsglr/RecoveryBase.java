package org.spoofax.jsglr;

import java.io.IOException;

public abstract class RecoveryBase {

    protected char[] recoverTokenStream;
    protected int recoverTokenCount;
    protected int tokenIndex;
    protected SGLR myParser;
    protected long recoverTime;
    protected boolean isDebugMode;

    public void setDebugMode(boolean isDebugMode) {
        this.isDebugMode = isDebugMode;
    }

    public RecoveryBase() {
        super();
        recoverTokenStream = new char[200];
        isDebugMode = false;
    }
    
    /*
     * keeps information and reset algorithm variables
     */
    public void initialize(SGLR parser) {
        myParser = parser;
        recoverTokenCount = 0;
        tokenIndex=-1;
        recoverTime = 0;
    }

    protected void afterParseStep() {}

    /**
     * @see org.spoofax.jsglr.RecoverAlgorithm#afterStreamRead(int)
     */
    public void afterStreamRead(int currToken) {
        recoverTokenStream[recoverTokenCount++] = (char) currToken;         
        if (recoverTokenCount == recoverTokenStream.length) {
            char[] copy = recoverTokenStream;
            recoverTokenStream = new char[recoverTokenStream.length * 2];
            System.arraycopy(copy, 0, recoverTokenStream, 0, copy.length);
        }
    }
    /*
     * Sets current token for the parser based on recover tokens.
     * Returns false if last token is read or index <0.
     */
    protected boolean tryReadRecoverToken() {
        if(tokenIndex >= recoverTokenStream.length || tokenIndex<0)
            return false;
        myParser.currentToken = recoverTokenStream[tokenIndex];
        tokenIndex++; 
        return true;
    }
    
    protected void setParserFields(ParserPosition rn) {
        myParser.tokensSeen = rn.tokensSeen;
        myParser.columnNumber = rn.columnNumber;
        myParser.lineNumber = rn.lineNumber;
    }   

    protected abstract boolean meetsRecoverCriteria();
    public abstract void recover() throws IOException;
    
    protected long getRecoverTime() {
        return recoverTime;
    }   
}
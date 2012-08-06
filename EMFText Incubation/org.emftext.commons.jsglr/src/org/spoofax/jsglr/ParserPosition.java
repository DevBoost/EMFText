package org.spoofax.jsglr;

public class ParserPosition {

    public final int tokensSeen;
    public final int lineNumber;
    public final int columnNumber;

    public ParserPosition(int tokSeen, int line, int col)
    {
        this.tokensSeen = tokSeen;
        lineNumber = line;
        columnNumber = col;
    }
    
   
}
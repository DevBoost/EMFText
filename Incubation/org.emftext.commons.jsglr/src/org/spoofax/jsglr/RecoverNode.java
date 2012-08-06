package org.spoofax.jsglr;

public class RecoverNode extends ParserPosition {
    public Frame recoverStack;    
    public Frame parentStack;
    
    public RecoverNode(Frame st, int tokSeen, int line, int col, Frame parent)
    {
        super(tokSeen, line, col);
        recoverStack =st;        
        parentStack=parent;
    }

}

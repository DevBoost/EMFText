package org.spoofax.jsglr;

import java.util.ArrayList;

import org.spoofax.ArrayDeque;

public class BacktrackPosition extends ParserPosition {
    public final ArrayDeque<Frame> recoverStacks;
    public final ArrayList<RecoverNode> recoverNodes; 
    public boolean isVisited;    
    
    public BacktrackPosition( ArrayDeque<Frame> activeStacks, int tokSeen, int line, int col)
    {
        super(tokSeen, line, col);
        recoverStacks = new ArrayDeque<Frame>(activeStacks);        
        recoverNodes=new ArrayList<RecoverNode>();        
    }

}

package org.spoofax.jsglr;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Assumption: a coarse-grained recover syntax is defined as grammar
 * Example: ~[\ \t\12\r\n]+ -> WATER  {avoid}, WATER    ClassBodyDecStar -> ClassBodyDecStar, ...
 * Algorithm: 
 * - During parsing: keep a set with parser states for recovering created by recover productions
 * - Recovering: Reset parser on last inserted recover candidate, continue parsing
 * @author maartje
 *
 */
public class CoarseGrainedRecovery extends RecoverAlgorithm {

    private final static int MAX_RECOVER_NODES = 160; //performance + protection against infinity    
    
    protected ArrayList<RecoverNode> recoverNodes; //candidates for recovery, accessed by backtracking
        
    /*
     * Looks for recoveries, every attempt starts with the last inserted candidate
     */
    public CoarseGrainedRecovery()
    {
        super();
        recoverNodes = new ArrayList<RecoverNode>();        
    }
    
    //Set initial values
    public void initialize(SGLR parser) {
        super.initialize(parser);
        recoverNodes.clear();
    }

    //Says wether the reovery nodes have to be parsed during normal parsing
    public boolean haltsOnRecoverProduction(Frame st0) {
        return true;
    }

    public void handleRecoverProduction(Frame st0, State s, int length,
            int numberOfAvoids, IParseNode t) {
        Frame st1 = createRecoverNode(st0, s, length, numberOfAvoids, t);
        addRecoverNode(st1, st0);        
    }    
    
    private void addRecoverNode(Frame st, Frame parent)
    {
        RecoverNode rn = new RecoverNode(st, myParser.tokensSeen, myParser.lineNumber, myParser.columnNumber, parent);
        recoverNodes.add(rn);   
        if(recoverNodes.size()>MAX_RECOVER_NODES) //removing early inserted positions improves non-error parsing performance
        { 
            final int halfMax = MAX_RECOVER_NODES/2;
            ArrayList<RecoverNode> cleanedPositions = new ArrayList<RecoverNode>();
            cleanedPositions.addAll(recoverNodes.subList(halfMax, recoverNodes.size()-1));                
            recoverNodes=cleanedPositions;                
        }
    }   
   
    public boolean meetsRecoverCriteria() {
        return myParser.acceptingStack == null && this.recoverNodes.size()>0;
    }    
    
    
    /*
     * Sets parser on last inserted recovery node
     * (non-Javadoc)
     * @see org.spoofax.jsglr.IRecoverAlgorithm#prepareForRecovery()
     */
    protected void prepareForRecovery() throws IOException {
        RecoverNode rn = recoverNodes.remove(recoverNodes.size()-1);        
        tokenIndex = rn.tokensSeen-1;
        tryReadRecoverToken();
        setParserFields(rn);        
        myParser.activeStacks.add(rn.recoverStack);        
        while(recoverNodes.size()>0 && recoverNodes.get(recoverNodes.size()-1).tokensSeen==rn.tokensSeen)
        {
            RecoverNode rnLast = recoverNodes.remove(recoverNodes.size()-1); 
            myParser.activeStacks.add(rnLast.recoverStack); 
        }        
        myParser.doParseStep(); //first recover step
        Tools.debug("Recover Start: "+(char)myParser.currentToken);
    }

    /*
     * Parses the recovery token list starting from a recovery node
     * (non-Javadoc)
     * @see org.spoofax.jsglr.IRecoverAlgorithm#doRecoverLoops()
     */
    protected void doRecoverLoops() throws IOException {
        //do recovering till original position is reached
        while(tokenIndex < recoverTokenCount && myParser.activeStacks.size()> 0) 
        {            
            tryReadRecoverToken();
            myParser.updateParserFields(myParser.currentToken);            
            myParser.doParseStep();                    
            Tools.debug("Recover: "+(char)myParser.currentToken);
        }        
        if(myParser.activeStacks.size()==0 && meetsRecoverCriteria()){
            prepareForRecovery(); //backtracks to unexplored recover node
            doRecoverLoops();
        }
        
    }        
    
}

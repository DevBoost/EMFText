package org.spoofax.jsglr;

public class RecoverDisambiguator {
    
    private ParseTable parseTable;
    static int testCount=0;
    
    public RecoverDisambiguator(ParseTable pt){
        parseTable=pt;        
    }
    
    public void handleAmbiguity(int recoverCount_t, IParseNode t, Link nl){  
        testCount++;
        /*
        if(nl.isRejected()){
            setLabel(recoverCount_t, t, nl);            
            return;
        } */ 
        boolean hasCountDiff = trySelectOnRecoverCount(recoverCount_t, t, nl);
        //if(hasCountDiff==false)
          //  trySelectByIndentation(recoverCount_t, t, nl);
    }
    
    private boolean trySelectOnRecoverCount(int recoverCount_t, IParseNode t, Link nl) {
        if(recoverCount_t == nl.recoverCount){
            setLabel(recoverCount_t, t, nl);
            return false;
        }
        if(recoverCount_t < nl.recoverCount)
            setLabel(recoverCount_t, t, nl);
        return true;
    }
    
    private boolean trySelectNoRecoveries(int avoidCount_t, IParseNode t, Link nl){     
        if(nl.recoverCount==0)
            return true;
        if(avoidCount_t==0){
            setLabel(0, t, nl);
            return true;
        }
        return false;
    }
    
    private boolean trySelectByIndentation(int avoidCount_t, IParseNode t, Link nl) {
        IndentationDisambiguator indentFilter=new IndentationDisambiguator();
        indentFilter.evaluateIndentation(nl.label.toParseTree(parseTable));
        int nlScore=indentFilter.getIndentDeviationListElements();
        indentFilter.evaluateIndentation(t.toParseTree(parseTable));
        int tScore=indentFilter.getIndentDeviationListElements();
        if(tScore == nlScore)
            return false;
        if(tScore < nlScore){
            setLabel(avoidCount_t, t, nl);
        }
        return true;
    }
    
    private void setLabel(int recoverCount_t, IParseNode t, Link nl) {
        nl.label=t;
        nl.recoverCount=recoverCount_t;
    }
}

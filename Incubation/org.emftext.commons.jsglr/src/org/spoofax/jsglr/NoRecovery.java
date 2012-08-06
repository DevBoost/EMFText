package org.spoofax.jsglr;

import java.io.IOException;

/*
 * TODO: 1. use "recover" attribute 2. distinct between no-recovery and simple recovery
 */
public class NoRecovery extends RecoverAlgorithm {
    
    private boolean useEagernessHeuristic;

    public void setUseEagernessHeuristic(boolean useEagernessHeuristic) {
        this.useEagernessHeuristic = useEagernessHeuristic;
    }
    
    public NoRecovery() {
        this(false);
    }

    public NoRecovery(boolean useEagernessHeuristic) {
        super();
        this.useEagernessHeuristic = useEagernessHeuristic;        
    }
    
    public void handleAmbiguity(int avoidCount_t, IParseNode t, Link nl){
        if (useEagernessHeuristic) {        
            super.handleAmbiguity(avoidCount_t, t, nl);
        } else {
            myParser.createAmbNode(t, nl);
        }
        
    }

    public void handleRecoverProduction(Frame st0, State s, int length,
            int numberOfAvoids, IParseNode t) {       
        
    }

    public void afterStreamRead(int currToken) {
        
    }

    public void afterParseStep() {
       
    }

    public void initialize() {
        
    }

    public void recover() throws IOException {
        
    }
    
    public long getRecoverTime() {
        return 0;
    }

    public boolean meetsRecoverCriteria() {        
        return false;
    }
    
    public boolean haltsOnRecoverProduction(Frame st0) {
        return false;
    }

    @Override
    void doRecoverLoops() throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    void prepareForRecovery() throws IOException {
        // TODO Auto-generated method stub
        
    }    

}

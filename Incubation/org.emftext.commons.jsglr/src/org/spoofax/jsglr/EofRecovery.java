package org.spoofax.jsglr;

import java.io.IOException;
import org.spoofax.ArrayDeque;

public class EofRecovery {
    
    private static final int MAX_PARSE_STEPS=20;
    private SGLR myParser;
    
    public EofRecovery(SGLR sglr){
        myParser=sglr;
    }
    
    public void enforceAccept(ArrayDeque<Frame> stackNodes) throws IOException { 
        myParser.setEnforcePrefixAccept(true);
        myParser.activeStacks.clear();
        myParser.activeStacks.addAll(stackNodes);
        myParser.currentToken = -1;
        ArrayDeque<Frame> oldStacks=new ArrayDeque<Frame>();
        oldStacks.addAll(myParser.activeStacks);
        int nrOfSteps=0;
        while (myParser.activeStacks.size()>0 && nrOfSteps<MAX_PARSE_STEPS) {
            //logStackNodes();
            myParser.doParseStep(); 
            nrOfSteps++;
            if(myParser.acceptingStack!=null)
               break;            
        }
        myParser.setEnforcePrefixAccept(false); 
    }
    
    private void logStackNodes() {
        Tools.debug("------- Stack nodes:  ------");
        for (Frame frame : myParser.activeStacks) {               
            Tools.debug(frame.state.stateNumber);
        }
        Tools.debug("---------------------");
    }
}

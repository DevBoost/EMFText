package org.spoofax.jsglr;

import java.io.IOException;

/*
 * Interface for recovery algorithms. 
 * Allows for preserving parse information relevant for recovering (characters, stacks as start point for recovering), 
 * contains method for handling recover productions, method for a recover algorithm
 */
public abstract class RecoverAlgorithm extends RecoveryBase {
    
    protected boolean inRecoverMode; //Recover mode means that recover productions are processed and the resulting stacknodes are preserved in recoverNodes  
    protected int nrOfLoops; //number of unsuccessful recover-loops during the current recovery
    protected boolean exceededMax;//recovery is stopped because of too many loops    
        
    
    public RecoverAlgorithm()
    {
        super();         
    }    
    
    /*
     * keeps information and reset algorithm variables
     */
    public void initialize(SGLR parser) {
        super.initialize(parser);
        inRecoverMode=false;
        nrOfLoops=0;
        exceededMax=false;
    }
    
    public void handleAmbiguity(int recovercount_t, IParseNode t, Link nl){
        assert !(nl.recoverCount == 0 && recovercount_t == 0)
                : "ambiguity without recover productions should not be handled by RecoverAlgorithm";
        
        //A. Choose branch without recover productions
        boolean hasRecoverFreeBranch = trySelectNoRecoveries(recovercount_t, t, nl);
        if(hasRecoverFreeBranch)
            return;
        //B. Disambiguate by indentation
        boolean hasIndentPreference = trySelectByIndentation(recovercount_t, t, nl);
        if(hasIndentPreference){
            return;
        }
        //C. choose branche with smallest number of avoids
        trySelectOnRecoverCount(recovercount_t, t, nl);
    }

    private boolean trySelectOnRecoverCount(int avoidCount_t, IParseNode t, Link nl) {
        if(avoidCount_t == nl.recoverCount)
            return false;
        if(avoidCount_t < nl.recoverCount)
            setLabel(0, t, nl);
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
        indentFilter.evaluateIndentation(nl.label.toParseTree(myParser.getParseTable()));
        int nlScore=indentFilter.getIndentDeviationListElements();
        indentFilter.evaluateIndentation(t.toParseTree(myParser.getParseTable()));
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
    
    /*
     * If true, then recover productions are not reduced,
     * if false then they are handled like normal productions.
     */
    abstract boolean haltsOnRecoverProduction(Frame st0);
    
    /*
     * Allows to handle a recover production
     */
    abstract void handleRecoverProduction(Frame st0, State s, int length,
            int numberOfAvoids, IParseNode t);
    
    /*
     * Tries to find a recovering.
     * After the recovery has succeeded, normal parsing continues on current parse position  
     */
     public void recover() throws IOException {
        
        long startTime = System.currentTimeMillis();
        
        /*
        Tools.debug("----------------");
        Tools.debug("Recovery: line = " + myParser.lineNumber);
        int startFrameCount = Frame.framesCreated;
        int startLinkCount = Link.linksCreated;
        long startRecover=System.currentTimeMillis();
        */
        prepareForRecovery();
        doRecoverLoops();
        inRecoverMode=false;
        //nrOfLoops=0;
        /*
        long endRecover=System.currentTimeMillis();
        Tools.debug("Recovery: time =" + (endRecover - startRecover));        
        Tools.debug("Recovery: nodes =" + (Frame.framesCreated - startFrameCount));
        Tools.debug("Recovery: links =" + (Link.linksCreated - startLinkCount));
        Tools.debug("Recovery: loops =" + nrOfLoops);
        Tools.debug("Recovery: active-stacks =" + myParser.activeStacks.size());
        Tools.debug("----------------");
        */
        nrOfLoops=0;
        recoverTime += System.currentTimeMillis() - startTime;
    }
    
     abstract void doRecoverLoops() throws IOException;
     abstract void prepareForRecovery() throws IOException;      
    
        
    protected Frame createRecoverNode(Frame parentFrame, State s, int length,
            int numberOfAvoids, IParseNode t) {
        Frame st1;
        Link nl;
        st1 = myParser.newStack(s);            
        nl = st1.addLink(parentFrame, t, length);
        nl.recoverCount = numberOfAvoids;
        return st1;
    }
    
  ///*
    //Debug help
      private String logRecoverTokens()
      {
          String result = "LINE "+myParser.lineNumber +": ";
          for (int i = 0; i < 50; i++) {
              if (recoverTokenCount - 50 + i > 0) {
                  int tok = recoverTokenStream[recoverTokenCount - 50 + i];               
                  char tokChar = (char)tok;
                  result += tokChar;
              }
          }       
          return result;
      } 
      
      //Debug help
      private String logRecoverInfo()
      {
        
          String result = ""; //todo: info uit current recoverpos
          for (int i = 0; i < 50; i++) {
              if (tokenIndex - 50 + i>0) {
                  int tok = recoverTokenStream[tokenIndex - 50 + i];
                  char tokChar = (char) tok;
                  result += tokChar;
              }
          }        
          return result;
      } //*/
}

package org.spoofax.jsglr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TODO: keep recovered lines (Testcase: two separated errors)
public class RecoveryConnector {
    private SGLR mySGLR;
    private IRecoveryParser recoveryParser;
    private RegionRecovery skipRecovery;
    private boolean active;
    private boolean useBridgeParser;
    private IRecoveryResult bpResult;
    
    
    public void setUseBridgeParser(boolean useBridgeParser) {
        this.useBridgeParser = useBridgeParser;
    }

    public RecoveryConnector(SGLR parser, IRecoveryParser recoveryParser){
        active=false;
        mySGLR=parser;        
        skipRecovery = new RegionRecovery(mySGLR); 
        if(recoveryParser!=null){
            this.recoveryParser = recoveryParser;
            useBridgeParser=true;
        }
        else
            useBridgeParser=false;
        
    }    
    
    
    private Map<Integer, char[]> getBPSuggestions(){
        Map<Integer, char[]> bpSuggestions = getBridges();
        int startPos = skipRecovery.getErrorFragmentStartPosition();
        
        Map<Integer, char[]> bpSuggestAbsolute = new HashMap<Integer, char[]>();
        for (Integer aKey : bpSuggestions.keySet()) {
            Integer newKey=new Integer(startPos+aKey.intValue());
            char[] newValue=bpSuggestions.get(aKey);
            bpSuggestAbsolute.put(newKey, newValue);
        }
        return bpSuggestAbsolute;
    }

    private Map<Integer, char[]> getBridges() {
        if (bpResult != null) {
            return bpResult.getSuggestions();
        }
        return new HashMap<Integer, char[]>();
    }
    
    
    
    private ParserHistory getHistory() {
        return mySGLR.getHistory();
    }
    
    public void recover() throws IOException{
        long startSkip=System.currentTimeMillis();
        //System.err.print("***************** Recover");
        doRecoverSteps();
        long durationSkip=System.currentTimeMillis()-startSkip;
        //System.err.print(" Recovertime: "+durationSkip);
    }

    private void doRecoverSteps() throws IOException {
        active=true;
        boolean skipSucceeded = skipRecovery.selectErroneousFragment(); //decides whether whitespace parse makes sense
        mySGLR.acceptingStack=null;
        long startSkip=System.currentTimeMillis();
        String errorFragment = skipRecovery.getErrorFragment();
        long durationSkip=System.currentTimeMillis()-startSkip;
        Tools.debug("Skip time: "+ durationSkip);
        //System.err.print("Skip time: "+ durationSkip+ "  ");
        Tools.debug(errorFragment);
        //System.err.print(errorFragment);
        mySGLR.activeStacks.clear();
        //BRIDGE REPAIR
        if(useBridgeParser){            
            tryBridgeRepair(errorFragment);
            if(recoverySucceeded()){
                Tools.debug("Bridge Repair Succeeded");
                //System.err.print("************** BP-Succeeded");
                return;
            }
            Tools.debug("Bridge Repair Failed");
        }
        //FINEGRAINED REPAIR 
        long startFineGrained=System.currentTimeMillis();
        tryFineGrainedRepair();       
        long durationFG=System.currentTimeMillis()-startFineGrained;
        Tools.debug("Fine-Grained time: "+ durationFG);
        //System.err.print("Fine-Grained time: "+ durationFG);
        //Tools.debug("Disambiguations: " +  RecoverDisambiguator.testCount);
        if(recoverySucceeded()){
            Tools.debug("Fine-Grained Repair Succeeded");
            //System.err.print("**************** FG-succeeded");
            return;
        }
        Tools.debug("FineGrained Repair Failed");
        //WHITESPACE REPAIR
        if (skipSucceeded) {            
            whiteSpaceParse(errorFragment); 
            if(recoverySucceeded()){
                Tools.debug("WhiteSpace Repair Succeeded");
                //System.err.print("************* WS-succeeded");
            }
            else{
                Tools.debug("WhiteSpace Repair unexpectly fails");
                //System.err.print("*************** WS-Fails unexpected");
            }
        }
        //FORCE PREFIX ACCEPT
        else {            
            EofRecovery eofR = new EofRecovery(mySGLR);
            eofR.enforceAccept(getHistory().getBigReducePoint().getStackNodes());
            if(recoverySucceeded()){
                Tools.debug("Enforcing Accepting Stack - Succeeded");
                //System.err.print("******************* AS-succeeded");
            }
            else{
                Tools.debug("Enforcing Accepting Stack - Failed"); 
              //System.err.print("******************* AS-Failed");
            }
        }
        active = false;
    }
    
    private boolean recoverySucceeded() {
        boolean hasSucceeded = (mySGLR.activeStacks.size()>0 || mySGLR.acceptingStack!=null);
        /*
        if(hasSucceeded){           
            ArrayList<IndentInfo> recoverNewLinePoints = new ArrayList<IndentInfo>();            
            IndentInfo currentStatus = new IndentInfo(mySGLR.lineNumber, getHistory().getTokenIndex(), mySGLR.getIndentHandler().getIndentValue());
            recoverNewLinePoints.add(currentStatus);
            getHistory().addRecoverLines(recoverNewLinePoints);
        }
        */
        return hasSucceeded;
    }

    private void whiteSpaceParse(String errorFragment) throws IOException {
        mySGLR.activeStacks.addAll(skipRecovery.getStartSkipPosition().getStackNodes());            
        tryParsing(errorFragment, true);
        parseRemainingTokens();
    }

    private void tryFineGrainedRepair() throws IOException {
        FineGrainedRepair fineGrained=new FineGrainedRepair(mySGLR);   
        fineGrained.setBpSuggestions(getBPSuggestions());
        fineGrained.findRecoverBranch(skipRecovery.getSkippedLines(), skipRecovery.getEndSkipPosition());        
    }

    private void tryBridgeRepair(String errorFragment) throws IOException {
        String repairedFragment = repairBridges(errorFragment);
        mySGLR.activeStacks.addAll(skipRecovery.getStartSkipPosition().getStackNodes());   
        tryParsing(repairedFragment, false);      
        parseRemainingTokens();
    }

    private String repairBridges(String errorFragment) {
        try {            
            bpResult = null;
            bpResult = recoveryParser.recover(errorFragment);
            return bpResult.getResult();
        } catch (TokenExpectedException e) {
            e.printStackTrace();
        } catch (BadTokenException e) {
            e.printStackTrace();
        } catch (SGLRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/*" + errorFragment + "*/";
    }
    
    private void tryParsing(String fragment, boolean asLayout) throws IOException{
        // Skip any leading whitespace, since we already parsed up to that point
        int indexFragment = findFirstNonLayoutToken(fragment);        
        while(indexFragment<fragment.length() && mySGLR.activeStacks.size()>0) {                        
            mySGLR.currentToken=fragment.charAt(indexFragment);
            //Tools.debug((char)mySGLR.currentToken);
            indexFragment++;
            if(!asLayout)
                mySGLR.doParseStep();
            else
                parseAsLayout();
        }       
    }
    
    public void parseRemainingTokens() throws IOException{
        //Tools.debug("REMAINING: ");
        getHistory().setTokenIndex(skipRecovery.getEndSkipPosition());
        while(!getHistory().hasFinishedRecoverTokens() && mySGLR.activeStacks.size()>0){        
            getHistory().readRecoverToken(mySGLR);
            //Tools.debug("***"+(char)mySGLR.currentToken);
            mySGLR.doParseStep();            
        }        
    }

    
    
    private void parseAsLayout() throws IOException {
        if(isLayoutCharacter((char)mySGLR.currentToken) || mySGLR.currentToken==SGLR.EOF)
            mySGLR.doParseStep();
        else{
            mySGLR.currentToken=' ';
            mySGLR.doParseStep();            
        }
    }
    
    public static boolean isLayoutCharacter(char aChar) {
        // TODO: Move this to the parse table class; only it truly can now layout characters
        return aChar==' ' || aChar == '\t' || aChar=='\n';
    }

    private int findFirstNonLayoutToken(String repairedFragment) {
        int indexFragment=0;
        while(indexFragment<repairedFragment.length()-1 && isLayoutCharacter(repairedFragment.charAt(indexFragment)))
            indexFragment++;
        return indexFragment;
    }

    public boolean isActive() {        
        return active;
    }

}

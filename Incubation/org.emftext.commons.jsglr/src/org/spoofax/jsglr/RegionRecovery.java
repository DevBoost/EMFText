package org.spoofax.jsglr;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Supports error recovery by selecting the region containing the error.
 * This region can be discarded (parsed as layout) or can be inspected by a refined recover method
 */
public class RegionRecovery {

    private SGLR myParser;
    StructureSkipper regionSelector;
    private StructureSkipSuggestion erroneousRegion;
    private boolean hasFoundErroneousRegion;
    private int errorDetectionLocation;
    private static int NR_OF_LINES_TILL_SUCCESS=2;
    private boolean useDebugMode;
    
    /**
     * Says whether an erroneous region is found
     * @return
     */
    public boolean hasFoundErroneousRegion() {
        return hasFoundErroneousRegion;
    }
    
    /**
     * Prints information about the selected regions to the console
     */
    public void setUseDebugMode(boolean useDebugMode) {
        this.useDebugMode = useDebugMode;
    }

    /**
     * Used for testing, accepts a recovery only after end of file is reached
     */
    public void setEndOfFileSuccessMode(){
        NR_OF_LINES_TILL_SUCCESS=Integer.MAX_VALUE;
    }
    
    /**
     * Supports error recovery by selecting the region containing the error
     */
    public RegionRecovery(SGLR sglr){
        myParser=sglr;
        regionSelector = new StructureSkipper(sglr);
    }
    
    private ParserHistory getHistory() {
        return myParser.getHistory();
    }
    
    /** *
     *  Returns info about the parser configuration at the start of the erroneous region 
     */
    public IndentInfo getStartSkipPosition() {
        return erroneousRegion.getStartSkip();
    }
    
    /**
     * returns the location of the first non-erroneous character
     */
    public int getEndSkipPosition() {
        return erroneousRegion.getEndSkip().getTokensSeen();
    }

    /**
     *  Returns error fragment including the left margin (needed for bridge-parsing)
     */
    public String getErrorFragment() {
        int tokIndexLine=getHistory().getTokensSeenStartLine(getStartSkipPosition().getTokensSeen());
        return getHistory().getFragment(tokIndexLine, getEndSkipPosition()-1);
    }

    /**
     * Returns location where erroneous region starts, including left margin
     */
    public int getErrorFragmentStartPosition() {
        int tokIndexLine=getHistory().getTokensSeenStartLine(getStartSkipPosition().getTokensSeen());
        return tokIndexLine;
    }

    public ArrayList<IndentInfo> getSkippedLines() {        
        return getHistory().getLinesFromTo(erroneousRegion.getIndexHistoryStart(), getEndSkipPosition());
    }      

    /**
     * Selects erroneous region based on layout 
     */
    public boolean selectErroneousFragment() throws IOException { 
        regionSelector.clear();
        regionSelector.setFailureIndex(getHistory().getIndexLastLine());
        errorDetectionLocation=getHistory().getIndexLastToken();
        hasFoundErroneousRegion=false;         
        ArrayList<StructureSkipSuggestion> prevRegions=regionSelector.getPreviousSkipSuggestions();
        logRecoverInfo("PREVIOUS REGION");        
        if(trySetErroneousRegion(prevRegions)){
            ArrayList<StructureSkipSuggestion> decomposedRegions=regionSelector.getZoomOnPreviousSuggestions(erroneousRegion);
            boolean findSmallerPart= trySetErroneousRegion(decomposedRegions);
            if(findSmallerPart){
                ArrayList<StructureSkipSuggestion> childRegions=regionSelector.getPickErroneousChild(erroneousRegion);
                trySetErroneousRegion(childRegions);
            }
            return true;
        }
        ArrayList<StructureSkipSuggestion> currentRegions=regionSelector.getCurrentSkipSuggestions();
        logRecoverInfo("CURRENT REGION");
        if(trySetErroneousRegion(currentRegions)){            
            return true;
        }
        logRecoverInfo("PRIOR REGIONS");
        ArrayList<StructureSkipSuggestion> priorRegions=regionSelector.getPriorSkipSuggestions();
        if(trySetErroneousRegion(priorRegions)){
            ArrayList<StructureSkipSuggestion> decomposedRegions=regionSelector.getZoomOnPreviousSuggestions(erroneousRegion);
            boolean findSmallerPart=trySetErroneousRegion(decomposedRegions);
            if(findSmallerPart){
                ArrayList<StructureSkipSuggestion> childRegions=regionSelector.getPickErroneousChild(erroneousRegion);
                trySetErroneousRegion(childRegions);
            }
            return true;
        }
        logRecoverInfo("FW-SIB REGIONS");
        ArrayList<StructureSkipSuggestion> siblingForWardRegions=regionSelector.getSibblingForwardSuggestions();
        if(trySetErroneousRegion(siblingForWardRegions)){            
            return true;
        }
        logRecoverInfo("BW-SIB REGIONS");
        ArrayList<StructureSkipSuggestion> siblingBackWardRegions=regionSelector.getSibblingBackwardSuggestions();
        if(trySetErroneousRegion(siblingBackWardRegions)){            
            return true;
        }
        logRecoverInfo("SURROUNDING-SIB REGIONS");
        ArrayList<StructureSkipSuggestion> siblingSurroundingRegions=regionSelector.getSibblingSurroundingSuggestions();
        if(trySetErroneousRegion(siblingSurroundingRegions)){            
            return true;
        }
        logRecoverInfo("PARENT REGION");
        ArrayList<StructureSkipSuggestion> parentRegion=regionSelector.getParentSkipSuggestions();
        if(trySetErroneousRegion(parentRegion)){            
            return true;
        }        
        else {
            logRecoverInfo("PREFIX");
            erroneousRegion=regionSelector.getErroneousPrefix();
            logRecoverInfo(getHistory().getFragment(erroneousRegion));
            ArrayList<StructureSkipSuggestion> decomposedRegions=regionSelector.getZoomOnPreviousSuggestions(erroneousRegion);
            boolean findSmallerPart=trySetErroneousRegion(decomposedRegions);
            if(findSmallerPart){
                ArrayList<StructureSkipSuggestion> childRegions=regionSelector.getPickErroneousChild(erroneousRegion);
                trySetErroneousRegion(childRegions);
            }
            return findSmallerPart; //false;
        }
    }

    private boolean trySetErroneousRegion(ArrayList<StructureSkipSuggestion> regions) throws IOException {
        StructureSkipSuggestion aSkip=new StructureSkipSuggestion();
        int indexSkips=0;
        myParser.acceptingStack=null; 
        myParser.activeStacks.clear(); //undo success
        while (indexSkips < regions.size() && !successCriterion()) {
            aSkip = regions.get(indexSkips);            
            testRegion(aSkip);
            indexSkips++;            
        }
        hasFoundErroneousRegion=successCriterion();
        if(hasFoundErroneousRegion){
            erroneousRegion=aSkip;   
            logRecoverInfo("Erroneous region set ");
        }
        return hasFoundErroneousRegion;
    }

    private void testRegion(StructureSkipSuggestion aSkip) throws IOException {
        logRecoverInfoBlock(getInputFragment(aSkip));           
        IndentInfo endPos=aSkip.getEndSkip();
        getHistory().setTokenIndex(endPos.getTokensSeen());
        myParser.activeStacks.clear();
        myParser.acceptingStack=null;
        myParser.activeStacks.addAll(endPos.getStackNodes());
        int nrOfParsedLines=0;
        logRecoverInfo("CONTINUE PARSING: ");
        while((myParser.activeStacks.size() > 0 && nrOfParsedLines<NR_OF_LINES_TILL_SUCCESS) || !getHistory().hasFinishedRecoverTokens()) {                       
            getHistory().readRecoverToken(myParser); 
            logRecoverInfo((char)myParser.currentToken);            
            myParser.doParseStep();
            if(getHistory().getTokenIndex()>errorDetectionLocation && myParser.currentToken=='\n')
                nrOfParsedLines++;
        }
    }

    public String getInputFragment(StructureSkipSuggestion aSkip) {
        return getHistory().getFragment(aSkip.getStartSkip().getTokensSeen(), aSkip.getEndSkip().getTokensSeen()-1);
    }

    private boolean successCriterion() {
        return myParser.activeStacks.size() > 0 || myParser.acceptingStack!=null;
    }
    
    private void logRecoverInfo(Object s) {
        if(useDebugMode){
            System.err.println(s);
        }
    } 
    
    private void logRecoverInfoBlock(Object s) {
        if(useDebugMode){
            System.err.println("------------------------");
            System.err.println("");
            System.err.println(s);            
            System.err.println("");
            System.err.println("------------------------");
        }
    } 

}

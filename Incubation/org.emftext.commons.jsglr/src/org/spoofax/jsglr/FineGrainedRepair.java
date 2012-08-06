package org.spoofax.jsglr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.spoofax.ArrayDeque;

import aterm.ATerm;

public class FineGrainedRepair {
    
    private static final int MAX_RECOVERIES_PER_REGION = 3;
    
    private static final int RECOVERY_COUNT_REGION_SIZE = 25;

    private SGLR myParser;
    private ArrayList<IndentInfo> newLinePoints; 
    private int indexLineRecovery;
    private IndentationDisambiguator indentComparer;
    private int endRecovery;
    
    private ParserHistory getHistory() {
        return myParser.getHistory();        
    }
    
    public FineGrainedRepair(SGLR sglr){
        myParser=sglr;  
        myParser.setMaxNrOfRecoveries(MAX_RECOVERIES_PER_REGION);
        myParser.setLengthAvoidCheck(RECOVERY_COUNT_REGION_SIZE);
        newLinePoints=new ArrayList<IndentInfo>();
        indexLineRecovery=-1;
        indentComparer=new IndentationDisambiguator();
        bpSuggestions=new HashMap<Integer, char[]>();
    }
    
    public void findRecoverBranch(ArrayList<IndentInfo> lines, int endTokenIndex) throws IOException{
        endRecovery=endTokenIndex;
        indexLineRecovery=-1;
        newLinePoints=lines;       
        if(newLinePoints.size()==0)
            return;         
        myParser.setFineGrainedMode(true);       
        myParser.activeStacks.clear();
        if(getFirstBPSuggestPosition() > 0){
            applyBridgeSuggestions(); 
        }
        //else if(searchIndentDeviation()){
          //  recoverOnDeviatingLine();                
        //}
        if (recoveryNotSucceeded()) {
            forwardRecovery();
        }
        myParser.setFineGrainedMode(false);
    }

    private void recoverOnDeviatingLine() throws IOException {
        IndentInfo recoverLine = newLinePoints.get(indexLineRecovery); 
        setParserForRecovery(recoverLine);            
        myParser.setFineGrainedMode(false);
        getHistory().readRecoverToken(myParser);            
        myParser.doParseStep();            
        myParser.setFineGrainedMode(true);
        if(indexLineRecovery<newLinePoints.size()-1){
            IndentInfo nextLine = newLinePoints.get(indexLineRecovery+1); 
            recoverLineAndContinueParse(false, nextLine.getTokensSeen()+1);
        }
        else
            recoverLineAndContinueParse(true, endRecovery);
    }

    private void applyBridgeSuggestions() throws IOException {
        removeLinesAfterFirstBP();
        IndentInfo recoverLine = newLinePoints.get(newLinePoints.size()-1); 
        setParserForRecovery(recoverLine);  
        myParser.setFineGrainedMode(false);
        handleBPPriorSuggestions();
        recoverLineAndContinueParse(true, endRecovery);
    }

    private void forwardRecovery() throws IOException {
        if(lastLineRecovered())
            return;    
        setIndexOnLastLine();
        IndentInfo recoverLine = newLinePoints.get(indexLineRecovery);         
        setParserForRecovery(recoverLine);  
        myParser.setFineGrainedMode(true);
        recoverLineAndContinueParse(true, endRecovery);                
        if(recoveryNotSucceeded())
            forwardRecovery();        
    }

    private boolean recoveryNotSucceeded() {
        // TODO Auto-generated method stub
        return myParser.activeStacks.size()==0;
    }

    private void setIndexOnLastLine() {             
        if(newLinePoints.size()>1 && indexLineRecovery < newLinePoints.size()-2)
            indexLineRecovery= newLinePoints.size()-2;
        else
            indexLineRecovery = newLinePoints.size()-1;
    }
    
    private void recoverLineAndContinueParse(boolean recoverEndOnNewLine, int lastRecoverToken) throws IOException{
        //Tools.debug("Enter recoverLineAndContinueParse");
        while (myParser.activeStacks.size() > 0 && !getHistory().hasFinishedRecoverTokens()){
            handleBPSuggestions();
            getHistory().readRecoverToken(myParser);            
            Tools.debug((char)myParser.currentToken + "  ("+getHistory().getTokenIndex()+")");  
            //myParser.logRecoverSituation();
            myParser.doParseStep();            
            if(myParser.currentToken=='\n'){
                if(recoverEndOnNewLine){                   
                    myParser.setFineGrainedMode(false);
                }
                if(getHistory().getTokenIndex() > getLastNewLinePoint().getTokensSeen() && (getHistory().getTokenIndex() <= endRecovery)){
                    AddNewLinePoint();
                }                
            }
            if(getHistory().getTokenIndex() > lastRecoverToken+1){                 
                myParser.setFineGrainedMode(false);
            }                 
        }
        myParser.setFineGrainedMode(false);
    }
    
    private void AddNewLinePoint() {
        // TODO Auto-generated method stub
        IndentInfo newLinePoint = new IndentInfo(-1, getHistory().getTokenIndex(), -1);
        newLinePoint.fillStackNodes(myParser.activeStacks);
        newLinePoints.add(newLinePoint);        
    }
    
    private IndentInfo getLastNewLinePoint() {
        IndentInfo recoverStart;
        recoverStart= newLinePoints.get(newLinePoints.size()-1);
        return recoverStart;
    }
    
    private void setParserForRecovery(IndentInfo recoverStart) {        
        myParser.activeStacks.addAll(recoverStart.getStackNodes());
        //myParser.setRecoverStartPos(recoverStart.getTokensSeen());
        getHistory().setTokenIndex(recoverStart.getTokensSeen());
    }

    private boolean searchIndentDeviation() {
        if (newLinePoints.size()<2)
            return false;        
        int startTok=newLinePoints.get(0).getTokensSeen();
        for (int i = 1; i < newLinePoints.size(); i++) {
            IndentInfo line =newLinePoints.get(i);            
            if(line.structureStartPosition()>startTok){            
                Link lnk = line.getReductionLink();
                if(lnk!=null){                    
                    IParseNode pNode =lnk.label;
                    if(pNode!=null){
                        ATerm t = pNode.toParseTree(myParser.getParseTable());                    
                        int beginIndent = findBeginIndent(line);                    
                        indentComparer.evaluateIndentation(t, beginIndent);
                        int devValue=indentComparer.getIndentDeviationListElements();
                        if(devValue>0){
                            int errorLineIndex=findIndexLine(line.structureStartPosition() + indentComparer.getPosFirstErrorListElement());
                            //debugErrorLine(line, beginIndent, devValue, errorLineIndex);
                            indexLineRecovery=errorLineIndex;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void debugErrorLine(IndentInfo line, int beginIndent, int devValue,
            int errorLineIndex) {
        IndentInfo errorLine = newLinePoints.get(errorLineIndex);
        Tools.debug("Start-Indent: "+ beginIndent);
        Tools.debug("Indent: "+ line.getIndentValue());
        Tools.debug("Line: "+ line.getLineNumber());
        Tools.debug("Score: "+devValue);
        Tools.debug("Error-Line: "+ errorLine.getLineNumber());                
        //Tools.debug(t);
    }
    
    private int findBeginIndent(IndentInfo indInf){ 
        int i = findIndexLine(indInf.structureStartPosition());
        if(i>=0)
            return newLinePoints.get(i).getIndentValue();
        return -1;
    }
    
    private int findIndexLine(int tokPos){        
        for (int i = newLinePoints.size()-1; i >= 0; i--) {
            IndentInfo lineInList=newLinePoints.get(i);
            if(lineInList.getTokensSeen()<= tokPos)
                return i;
        }        
        return -1;
    }

    private boolean lastLineRecovered() {        
        return indexLineRecovery>=newLinePoints.size()-1;
    }   
    
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ BP Integration &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    
        
    private Map<Integer, char[]> bpSuggestions;
    
    public void setBpSuggestions(Map<Integer, char[]> bpSuggestions) {
        this.bpSuggestions = bpSuggestions;
    }

    private void removeLinesAfterFirstBP() {
        int nextBPPos = getFirstBPSuggestPosition();
        if(nextBPPos >= 0){
            while (newLinePoints.size()>1) {
                if(newLinePoints.get(newLinePoints.size()-1).getTokensSeen()>=nextBPPos){
                    newLinePoints.remove(newLinePoints.size()-1);
                }
                else
                    break;
            }
        }
    }
    
    private int getFirstBPSuggestPosition(){
        int result = -1;
        for (Integer aKey : bpSuggestions.keySet()) {
            int keyValue = aKey.intValue();
            if(result ==-1 || keyValue<result)
                result = keyValue;
        }
        return result;
    }  
      
    private void handleBPSuggestions() throws IOException{
        Integer tokIndex=new Integer(getHistory().getTokenIndex());
        if(bpSuggestions.containsKey(tokIndex)){
            //Tools.debug((char)myParser.currentToken);
            processBPSuggestions(tokIndex);
        }
    }

    private void processBPSuggestions(Integer tokIndex) throws IOException {
        char[] insertions = bpSuggestions.get(tokIndex);
        for (int i = 0; i < insertions.length; i++) {
            ArrayDeque<Frame> oldAct = new ArrayDeque<Frame>();
            oldAct.addAll(myParser.activeStacks);
            myParser.currentToken = insertions[i];
            myParser.doParseStep();
            myParser.activeStacks.addAll(oldAct);
            Tools.debug("BP-Insertion: "+ insertions[i]);
        }
    }
    
    private void handleBPPriorSuggestions() throws IOException{
        if(newLinePoints.size()!=1)
            return;
        int firstRecoverPos=newLinePoints.get(0).getTokensSeen();   
        int firstBPSuggestion=getFirstBPSuggestPosition();
        if(-1 < firstBPSuggestion && firstBPSuggestion < firstRecoverPos){            
            processBPSuggestions(new Integer(firstBPSuggestion));
        }
    }
    
    boolean isWhiteSpace(char c){
        return c==' ' || c=='\t'|| c=='\n';
    }
}

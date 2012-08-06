package org.spoofax.jsglr;

import java.io.IOException;
import java.util.ArrayList;

public class ParserHistory {
    
    private final static int MAX_SIZE_NEW_LINE_POINTS = 150;
    private final static int MIN_SIZE_NEW_LINE_POINTS = 50;
    private IndentationHandler indentHandler;
    private int previousBigReduceIndex;
    private int bigReduceIndex;    
    private int indexConstruct; 
    
    public int getIndexConstruct() {
        return indexConstruct;
    }

    public void setIndexConstruct(int indexConstruct) {
        this.indexConstruct = indexConstruct;
    }

    private ArrayList<IndentInfo> newLinePoints;      
    public char[] recoverTokenStream;
    private int recoverTokenCount;
    private int tokenIndex;
    private boolean reduceIndexesSet;
    
    public int getTokenIndex() {
        return tokenIndex;
    }
    
    public int getIndexLastToken() {
        return recoverTokenCount-1;
    }

    public void setTokenIndex(int tokenIndex) {
        this.tokenIndex = tokenIndex;
    }
    
    public ParserHistory(){    
        newLinePoints=new ArrayList<IndentInfo>();        
        reset();
    }
     
    public void reset(){
        newLinePoints.clear();
        recoverTokenStream = new char[200];
        recoverTokenCount = 0;
        indexConstruct=0;
        tokenIndex=0;
        previousBigReduceIndex=0;
        bigReduceIndex=0;
        reduceIndexesSet=false;
        indentHandler = new IndentationHandler();
    }
    
    /*
     * Set current token of parser based on recover tokens or read from new tokens
     */
    public void readRecoverToken(SGLR myParser) throws IOException{        
        if (hasFinishedRecoverTokens()) {
            myParser.readNextToken();                
            indentHandler.updateIndentation(myParser.currentToken);
            keepToken((char)myParser.currentToken);
            
            if(indentHandler.lineMarginEnded())
                keepNewLinePoint(myParser, true);
        }
        myParser.currentToken = recoverTokenStream[tokenIndex];
        tokenIndex++;
    }
    
    public boolean hasFinishedRecoverTokens() {
        return tokenIndex >= recoverTokenCount;
    }
    
    public int getTokensSeenStartLine(int tokPosition){
        int tokIndexLine=tokPosition;
        while (recoverTokenStream[tokIndexLine] != '\n' && tokIndexLine>0) {
            tokIndexLine-=1;
        }
        return tokIndexLine;
    }

    public void keepTokenAndState(SGLR myParser) {
        indentHandler.updateIndentation(myParser.currentToken);
        keepToken((char)myParser.currentToken);
        tokenIndex++;
        if(indentHandler.lineMarginEnded())
            keepNewLinePoint(myParser, false);
    }
    
    public void keepInitialState(SGLR myParser) {        
        IndentInfo newLinePoint= new IndentInfo(0, 0, 0);
        newLinePoint.fillStackNodes(myParser.activeStacks);
        newLinePoints.add(newLinePoint);
    }

    private void keepToken(char currentToken) {
        recoverTokenStream[recoverTokenCount++] = currentToken;         
        if (recoverTokenCount == recoverTokenStream.length) {
            char[] copy = recoverTokenStream;
            recoverTokenStream = new char[recoverTokenStream.length * 2];
            System.arraycopy(copy, 0, recoverTokenStream, 0, copy.length);
        }
    }
    
    public boolean constructAfterEmptyLine(){
        return getConstructPoint().getLineNumber() > newLinePoints.get(indexConstruct-1).getLineNumber()+1;
    }
    
    private void keepNewLinePoint(SGLR myParser, boolean inRecoverMode) {
        int indent = indentHandler.getIndentValue();
        IndentInfo newLinePoint= new IndentInfo(myParser.lineNumber, myParser.tokensSeen-1, indent);
        newLinePoints.add(newLinePoint);
        if(!inRecoverMode){
            newLinePoint.fillStackNodes(myParser.activeStacks);           
            if(newLinePoints.size()> MAX_SIZE_NEW_LINE_POINTS)
                removeOldPoints();
        }
    }
    
    private void removeOldPoints() {
        setBigReducePoints();
        int firstPointIndex = Math.min(previousBigReduceIndex-1, nrOfLines()-MIN_SIZE_NEW_LINE_POINTS);
        ArrayList<IndentInfo> shrinkedList = new ArrayList<IndentInfo>();
        shrinkedList.ensureCapacity(newLinePoints.size());
        shrinkedList.addAll(newLinePoints.subList(firstPointIndex, newLinePoints.size()-1));
        newLinePoints = shrinkedList;
        bigReduceIndex-=firstPointIndex;
        previousBigReduceIndex-=firstPointIndex;
    }

    public void setBigReducePoints(){
        if(reduceIndexesSet==false){
            setBigReducesFirstTime();
            return;
        }
        int brLength=getBigReducePoint().maxReduceLength();
        int oldBR=bigReduceIndex;
        for (int i = newLinePoints.size()-1; i > bigReduceIndex; i--) {
            IndentInfo point=newLinePoints.get(i);                      
            if(point.maxReduceLength() >= brLength){                
                bigReduceIndex = i;
                previousBigReduceIndex=oldBR;
                break;
            }
        }
        for (int j = bigReduceIndex-1; j > oldBR; j--) {
            IndentInfo point=newLinePoints.get(j);                      
            if(point.maxReduceLength() >= brLength){                
                previousBigReduceIndex = j;
                break;
            }
        }
    }
    
    private void setBigReducesFirstTime() {
        bigReduceIndex=0;
        previousBigReduceIndex=0;
        int brLength=0;
        for (int i = 0; i < newLinePoints.size(); i++) {
            int reduceLength=newLinePoints.get(i).maxReduceLength();
            if(reduceLength>brLength){
                previousBigReduceIndex=bigReduceIndex;
                bigReduceIndex=i;
                brLength=reduceLength;
            }            
        }
        if(newLinePoints.size()>MIN_SIZE_NEW_LINE_POINTS-1)
            reduceIndexesSet=true;        
    }

    public String getFragment(int startTok, int endTok) {
        String fragment="";
        for (int i = startTok; i <= endTok; i++) {
            if(i >= recoverTokenCount)
                break;
            fragment+= recoverTokenStream[i];
        }        
        return fragment;
    }
    
    public String getFragment(StructureSkipSuggestion skip) {
        String fragment="";
        for (int i = skip.getStartSkip().getTokensSeen(); i <= skip.getEndSkip().getTokensSeen()-1; i++) {
            if(i >= recoverTokenCount)
                break;
            fragment+= recoverTokenStream[i];
        }        
        return fragment;
    }
    
    /*
     * current construct in navigation
     */
    public IndentInfo getConstructPoint() {
        return newLinePoints.get(indexConstruct);
    }
    
    public IndentInfo getBigReducePoint() {
        return newLinePoints.get(bigReduceIndex);
    }   
    
    public IndentInfo getPreviousBigReducePoint() {
        return newLinePoints.get(previousBigReduceIndex);
    } 
    
    public void moveToBigReducePoint() {
        indexConstruct=bigReduceIndex;
    }   
    
    public void moveToPreviousBigReducePoint() {
        indexConstruct = previousBigReduceIndex;
    } 
    
    public boolean moveToParentConstruct() {        
        int loopIndex = indexConstruct-1;//newLinePoints.size()-2;
        while ( loopIndex >= 0) {
            if(newLinePoints.get(loopIndex).getIndentValue()< getConstructPoint().getIndentValue()){
                indexConstruct = loopIndex;  
                return true;
            }
            loopIndex--;
        }
        return false;
    } 
    
    public int nrOfLines(){
        return newLinePoints.size();
    }
    
    public IndentInfo getLine(int index){
        if(index < 0 || index > getIndexLastLine())
            return null;
        return newLinePoints.get(index);
    }
    
    public IndentInfo getPreviousLine(){
        if(indexConstruct==0)
            return null;
        return newLinePoints.get(indexConstruct-1);
    }
    
    public IndentInfo getLastLine(){
        return newLinePoints.get(newLinePoints.size()-1);
    }
    
    public int getIndexLastLine(){
        return newLinePoints.size()-1;
    }
    
    public void moveToLastConstruct(){
        indexConstruct=newLinePoints.size()-1;        
    }

    public boolean moveToPreviousConstruct() {

        if(indexConstruct<=0)
            return false;
        int loopIndex = indexConstruct -1;
        IndentInfo currentLine=newLinePoints.get(indexConstruct);
        while ( loopIndex >= 0) {
            IndentInfo priorLine=newLinePoints.get(loopIndex);            
            if(priorLine.getIndentValue()==currentLine.getIndentValue()){
                if(loopIndex!=indexConstruct - 1 || priorLine.structureStartPosition() <= currentLine.structureStartPosition()){ //skip closing tag
                    indexConstruct = loopIndex;
                    return true;
                }          
            }
            if(priorLine.getIndentValue()< currentLine.getIndentValue()){
                return false;//first child               
            }
            loopIndex--;
        }        
        return false; 
    }
    
    public boolean moveToDirectPreviousConstruct() {

        if(indexConstruct<=0)
            return false;        
        IndentInfo currentLine=newLinePoints.get(indexConstruct);
        IndentInfo priorLine=newLinePoints.get(indexConstruct -1);      
        if(priorLine.getIndentValue()==currentLine.getIndentValue()){            
            indexConstruct -= 1;
            return true;
        }
        return false; 
    }
    
    public void addRecoverLines(ArrayList<IndentInfo> recoverNewLinePoints) {
        if(recoverNewLinePoints.size()==0)
            return;
        newLinePoints.remove(newLinePoints.size()-1); //remove line of error detection
        newLinePoints.addAll(recoverNewLinePoints);        
    }    

    public ArrayList<IndentInfo> getLinesFrom(int startIndex) {
        ArrayList<IndentInfo> recentHistory=new ArrayList<IndentInfo>();
        recentHistory.addAll(newLinePoints.subList(startIndex, newLinePoints.size()));
        return recentHistory;
    }
    
    public ArrayList<IndentInfo> getLinesFromTo(int startIndex, int endLocation) {
        int indexLine = startIndex;
        ArrayList<IndentInfo> result=new ArrayList<IndentInfo>();
        IndentInfo firstLine = newLinePoints.get(indexLine);
        while(indexLine < newLinePoints.size()){
             firstLine = newLinePoints.get(indexLine);
             if(firstLine.getTokensSeen() < endLocation){
                 result.add(firstLine);
                 indexLine++;
             }
             else{
                 indexLine=newLinePoints.size();
             }
        }
        return result;
    }

    public int getLastChar() {        
        return recoverTokenStream[recoverTokenCount-1];
    }    

    public boolean moveInward() {
        boolean result = false;
        if(indexConstruct<=1)
            return false;
        int prevIndent = getConstructPoint().getIndentValue();
        indexConstruct-=1;
        int currIndent = getConstructPoint().getIndentValue();
        while(indexConstruct>1 && currIndent > prevIndent){
            result = true;
            prevIndent=currIndent;
            indexConstruct-=1;
            currIndent = getConstructPoint().getIndentValue();
        }
        indexConstruct+=1;
        return result; 
    }

    
    /*
    ///////////////////////////////// LOG /////////////////////////////////////////////////////////////////
    public void logBigReductionList() {        
        for (int i = 0; i < newLinePoints.size(); i++) {
            logBigReduction(newLinePoints.get(i));
        }
       // Tools.debug(info);
        Tools.debug("**** BR-list ****");
        Tools.debug("***************************");
    }

    private void logBigReduction(IndentInfo brPoint) {
        Tools.debug("LINE: " +brPoint.getLineNumber());
        Tools.debug("INDENT: " +brPoint.getIndentValue());
        Tools.debug("REDUCE-LENGTH: " +brPoint.maxReduceLength());
        Tools.debug("TOKEN-POSITION: " +brPoint.getTokensSeen());        
        Tools.debug("........................");
    }*/
    
}

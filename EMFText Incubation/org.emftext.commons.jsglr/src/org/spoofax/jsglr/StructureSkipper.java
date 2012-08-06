package org.spoofax.jsglr;

import java.io.IOException;
import java.util.ArrayList;

public class StructureSkipper {
    
    //restrictions on area searched for erroneous region
    private final static int MAX_NR_OF_LINES=30;
    private final static int MAX_NR_OF_STRUCTURES=20;
    private int indexPrevChild;
    private int failureIndex;
    
    public void setFailureIndex(int failureIndex) {
        this.failureIndex = failureIndex;
    }
    
    public IndentInfo getFailureLine() {
        return getHistory().getLine(failureIndex);
    }

    enum indentShift{
        INDENT,
        DEDENT,
        SAME_INDENT
    }
    
    private boolean useOpeningClosingDefaults;
    private final static char[] closingTokens={'}', ')', ']', '>', '|'};
    private final static char[] openingTokens={'{', '(', '[', '<', '|'};
    
    private boolean isClosingChar(char c){
        return contains(c, closingTokens);
    }
    
    private boolean isOpeningChar(char c){
        return contains(c, openingTokens);
    }

    private boolean contains(char c, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==c)
                return true;
        }
        return false;
    }
    
    public boolean isUsingCurlyBraces() {
        return useOpeningClosingDefaults;
    }

    public void setUseCurlyBraces(boolean useCurlyBraces) {
        this.useOpeningClosingDefaults = useCurlyBraces;
    }

    private SGLR myParser;
    private IndentationHandler skipIndentHandler;
    
    private ParserHistory getHistory() {
        return myParser.getHistory();
    }
    
    public StructureSkipper(SGLR sglr){   
        myParser=sglr;
        skipIndentHandler=new IndentationHandler();
        clear();
    }

    public void clear() {
        indexPrevChild=-1;
    }
    
    public StructureSkipSuggestion getErroneousPrefix() throws IOException{
        getHistory().setTokenIndex(getFailureLine().getTokensSeen());
        IndentInfo nextLine = viewNextLine(getFailureLine());
        StructureSkipSuggestion prefix=new StructureSkipSuggestion();
        IndentInfo startLoc=IndentInfo.cloneIndentInfo(getHistory().getLine(0));        
        prefix.setSkipLocations(startLoc, nextLine, 0, failureIndex);
        return prefix;
    }
    
    public ArrayList<StructureSkipSuggestion> getCurrentSkipSuggestions() throws IOException{
        int indexLastLine=failureIndex;
        if (isErrorOnClosingLine(indexLastLine))
            return new ArrayList<StructureSkipSuggestion>();
        return selectRegion(indexLastLine);
    }

    private ArrayList<StructureSkipSuggestion> selectRegion(int indexLine)
            throws IOException {
        IndentInfo startLine = IndentInfo.cloneIndentInfo(getHistory().getLine(indexLine));
        ArrayList<IndentInfo> endLocations=findCurrentEnd(startLine);
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        for (IndentInfo endSkip : endLocations) {
            StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();
            skipConstruct.setSkipLocations(startLine, endSkip, indexLine, -1);            
            skipSuggestions.add(skipConstruct);
        }
        return skipSuggestions;
    }    
    
    public ArrayList<StructureSkipSuggestion> getPreviousSkipSuggestions() throws IOException{
        int indexEnd=failureIndex;
        return selectPreviousRegion(indexEnd);
    }

    private ArrayList<StructureSkipSuggestion> selectPreviousRegion(int indexEnd)
            throws IOException {
        IndentInfo endLocation=IndentInfo.cloneIndentInfo(getHistory().getLine(indexEnd));
        boolean errorOnClosingBrace=isErrorOnClosingLine(indexEnd);
        if(errorOnClosingBrace){
            getHistory().setTokenIndex(endLocation.getTokensSeen());
            endLocation=skipLine(endLocation);
        }
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>(); 
        int startSkip = findPreviousBegin(indexEnd);
        if(startSkip>=0){
            indexPrevChild=startSkip;
            StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion(); 
            IndentInfo startLoc = IndentInfo.cloneIndentInfo(getHistory().getLine(startSkip));
            skipConstruct.setSkipLocations(startLoc, endLocation, startSkip, indexEnd);
            skipSuggestions.add(skipConstruct); 
        }       
        return skipSuggestions;
    } 
    
    private ArrayList<StructureSkipSuggestion> selectLastChildRegion(int indexEnd, int indentValue) throws IOException {
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>(); 
        IndentInfo endLocation=IndentInfo.cloneIndentInfo(getHistory().getLine(indexEnd));
        int indentChilds=indentValue; 
        int indexStartBWSkip=indexEnd;
        if(possibleErrorOnClosingLine(indexEnd-1))
            indexStartBWSkip-=1;
        int startSkip = backwardsSkip(indexStartBWSkip, indentChilds);
        if(startSkip>=0){
            indexPrevChild=startSkip;
            StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion(); 
            IndentInfo startLoc = IndentInfo.cloneIndentInfo(getHistory().getLine(startSkip));
            skipConstruct.setSkipLocations(startLoc, endLocation, startSkip, indexEnd);
            //System.err.print(getHistory().getFragment(skipConstruct));
            skipSuggestions.add(skipConstruct); 
        }       
        return skipSuggestions;
    } 
    
    public ArrayList<StructureSkipSuggestion> getPriorSkipSuggestions() throws IOException{
        //int indexLastLine=failureIndex;
        return selectPriorRegions(indexPrevChild);
    }

    private ArrayList<StructureSkipSuggestion> selectPriorRegions(int indexLastLine) throws IOException {                     
        int indexEnd = indexLastLine;//findPreviousBegin(indexLastLine);
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        int startSkip = findPreviousBegin(indexEnd);        
        while(startSkip>=0 && skipSuggestions.size() < MAX_NR_OF_STRUCTURES && (indexLastLine - startSkip)<MAX_NR_OF_LINES){            
            IndentInfo endLocation=IndentInfo.cloneIndentInfo(getHistory().getLine(indexEnd));
            StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();
            IndentInfo startLoc=IndentInfo.cloneIndentInfo(getHistory().getLine(startSkip));
            skipConstruct.setSkipLocations(startLoc, endLocation, startSkip, indexEnd);
            skipSuggestions.add(skipConstruct); 
            //System.err.print(getHistory().getFragment(skipConstruct));
            indexEnd=startSkip;
            startSkip=findPreviousBegin(indexEnd);
        }       
        return skipSuggestions;
    } 

    public ArrayList<StructureSkipSuggestion> getParentSkipSuggestions() throws IOException{
        int errorLineIndex=failureIndex;
        IndentInfo startLine = getHistory().getLine(errorLineIndex);
        IndentInfo endSkip=findParentEnd(startLine);
        int startSkipIndex=findParentBegin(errorLineIndex);
        IndentInfo startSkip = IndentInfo.cloneIndentInfo(getHistory().getLine(startSkipIndex));
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();            
        skipConstruct.setSkipLocations(startSkip, endSkip, startSkipIndex, -1);
        skipSuggestions.add(skipConstruct);                
        return skipSuggestions;
    }    
    
    public ArrayList<StructureSkipSuggestion> getSibblingForwardSuggestions() throws IOException{        
        int startSkipIndex = findPreviousBegin(failureIndex);
        if(startSkipIndex<0)
            startSkipIndex=failureIndex;        
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        IndentInfo startLine = getFailureLine();
        IndentInfo forwardPosition = startLine;
        int loopCount=0;
        while(loopCount<MAX_NR_OF_STRUCTURES && forwardPosition.getIndentValue()==startLine.getIndentValue()&& (forwardPosition.getLineNumber()-startLine.getLineNumber()) < MAX_NR_OF_LINES) {
            ArrayList<IndentInfo> endLocations=findCurrentEnd(forwardPosition);
            forwardPosition =endLocations.get(endLocations.size()-1);    
            if(getHistory().recoverTokenStream[forwardPosition.getTokensSeen()]==SGLR.EOF)
                break;
            IndentInfo startSkip=IndentInfo.cloneIndentInfo(getHistory().getLine(startSkipIndex));
            for (IndentInfo endSkip : endLocations) {
                StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();               
                skipConstruct.setSkipLocations(startSkip, endSkip, startSkipIndex, -1);
                skipSuggestions.add(skipConstruct);                
            }            
            loopCount++;
            
        }        
        return skipSuggestions;
    }   
    
    public ArrayList<StructureSkipSuggestion> getSibblingBackwardSuggestions() throws IOException {
        int indexErrorLine=failureIndex;
        ArrayList<IndentInfo> endSkipLocations=findCurrentEnd(getFailureLine());
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        int backwardPositionIndex = indexErrorLine;
        int loopCount=0;       
        while(loopCount<MAX_NR_OF_STRUCTURES && (indexErrorLine - backwardPositionIndex)< MAX_NR_OF_LINES) {
            int startSkipIndex=findPreviousBegin(backwardPositionIndex);
            if(startSkipIndex<0)
                break;
            backwardPositionIndex = startSkipIndex;
            for (IndentInfo endSkip : endSkipLocations) {
                IndentInfo startSkip = IndentInfo.cloneIndentInfo(getHistory().getLine(startSkipIndex));
                StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();                
                skipConstruct.setSkipLocations(startSkip, IndentInfo.cloneIndentInfo(endSkip), startSkipIndex, -1);
                skipSuggestions.add(skipConstruct);
            }            
            loopCount++;
        }
        return skipSuggestions;
    }

    public ArrayList<StructureSkipSuggestion> getSibblingSurroundingSuggestions() throws IOException {        
        ArrayList<StructureSkipSuggestion> skipSuggestions=new ArrayList<StructureSkipSuggestion>();
        int indexErrorLine=failureIndex;
        int backwardPosition = indexErrorLine;
        IndentInfo startLine = getFailureLine();
        IndentInfo forwardPosition = startLine;        
        ArrayList<IndentInfo> endSkipLocations = findCurrentEnd(forwardPosition);
        int startSkipIndex = findPreviousBegin(backwardPosition);
        if(startSkipIndex >=0){            
            backwardPosition = startSkipIndex;            
        }
        else{
            startSkipIndex=backwardPosition;
        }
        boolean forWardsOn=true;
        boolean backwsEndReached=false;
        boolean forwardsEndReached=false;
        int loopCount=0;
        boolean doNext=false;
        int numberOflines=0;
        while(loopCount<2*MAX_NR_OF_STRUCTURES && !(backwsEndReached && forwardsEndReached)&& numberOflines<MAX_NR_OF_LINES) {
            doNext=false;
            if(forWardsOn){
                boolean eofReached=getHistory().recoverTokenStream[forwardPosition.getTokensSeen()]==SGLR.EOF;
                if(forwardPosition.getIndentValue()==startLine.getIndentValue() && !eofReached){
                    endSkipLocations=findCurrentEnd(forwardPosition);
                    forwardPosition =endSkipLocations.get(endSkipLocations.size()-1);
                    forWardsOn=backwsEndReached;
                }
                else{
                    forWardsOn=false;
                    forwardsEndReached=true;
                    doNext=true;
                }
            }
            else{
                int newStartOfSkipLocation=findPreviousBegin(backwardPosition);
                if(newStartOfSkipLocation>=0){
                    startSkipIndex = newStartOfSkipLocation;
                    backwardPosition =startSkipIndex;
                    forWardsOn=!forwardsEndReached;
                }
                else{
                    backwsEndReached=true;
                    forWardsOn=true;
                    doNext=true;
                }
            }
            if(!doNext){                
                IndentInfo startSkip=IndentInfo.cloneIndentInfo(getHistory().getLine(startSkipIndex));
                for (IndentInfo endSkip : endSkipLocations) {
                    StructureSkipSuggestion skipConstruct=new StructureSkipSuggestion();                    
                    skipConstruct.setSkipLocations(startSkip, endSkip, startSkipIndex, -1);
                    skipSuggestions.add(skipConstruct);
                    //System.err.print(getHistory().getFragment(skipConstruct));
                }                                
            loopCount++;
            numberOflines = forwardPosition.getLineNumber() - startSkip.getLineNumber();
            }            
        }        
        return skipSuggestions;
    }

    /*
     * * 
     */
    private ArrayList<IndentInfo> findCurrentEnd(IndentInfo startLine) throws IOException{
        getHistory().setTokenIndex(startLine.getTokensSeen());
        int indentStartLine=startLine.getIndentValue();        
        boolean hasIndentChilds=false;
        boolean isSecondLine=true;
        ArrayList<IndentInfo> endLocations=new ArrayList<IndentInfo>();
        IndentInfo nextLine = skipLine(startLine);
        while(myParser.currentToken!=SGLR.EOF){            
            int indentSkipPosition=nextLine.getIndentValue();
            indentShift shift=calculateShift(indentStartLine, indentSkipPosition);
            switch (shift) {
            case DEDENT:               
                endLocations.add(nextLine);                
                return endLocations;                
            case INDENT:
                hasIndentChilds=true;
                break;
            case SAME_INDENT:
                if(isSecondLine){
                    endLocations.add(nextLine); 
                    if(!isOpeningLine(nextLine))
                        return endLocations;
                }
                else if(hasIndentChilds){
                    if(isClosingLine(nextLine)){
                        nextLine = skipLine(nextLine);
                        if(nextLine==null)
                            break;
                    }
                    endLocations.add(nextLine);
                    return endLocations;
                }
                else{
                    return endLocations;
                }
                break;
            default:
                break;
            }
            isSecondLine=false;
            nextLine=skipLine(nextLine);
        }
        endLocations.add(nextLine); //EOF
        return endLocations;
    } 
    
    private int findPreviousBegin(int indexLine) throws IOException{ 
        if(indexLine<0 || indexLine>failureIndex)
            return -1;
        IndentInfo startLine=IndentInfo.cloneIndentInfo(getHistory().getLine(indexLine));
        int indentStartLine=startLine.getIndentValue();        
        return backwardsSkip(indexLine, indentStartLine);
    }

    private int backwardsSkip(int indexLine, int indentValue) {
        boolean prevLine=true;        
        int indexHistoryLines=indexLine;
        while(indexHistoryLines>0){
            indexHistoryLines-=1;
            int indentSkipPosition=getHistory().getLine(indexHistoryLines).getIndentValue();
            indentShift shift=calculateShift(indentValue, indentSkipPosition);
            switch (shift) {
            case DEDENT:                
                return -1;                
            case INDENT:                               
                break;
            case SAME_INDENT:                
                if(!prevLine && isOpeningLine(indexHistoryLines))
                {                    
                    return indexHistoryLines - 1;
                }
                else if(!prevLine || !isClosingLine(indexHistoryLines)){
                    return indexHistoryLines;
                }                
                break;
            default:
                break;
            }
            prevLine=false;
        }  
        if(indexLine != 0)
            return 0;//SOF
        return -1;
    }  
    
    private int findParentBegin(int startLineIndex) throws IOException{
        IndentInfo startLine = IndentInfo.cloneIndentInfo(getHistory().getLine(startLineIndex));
        int indentStartLine=startLine.getIndentValue();
        int indexHistoryLines=startLineIndex;
        while(indexHistoryLines > 0){
            indexHistoryLines-=1;
            IndentInfo currentLine=getHistory().getLine(indexHistoryLines);
            int indentSkipPosition=currentLine.getIndentValue();
            indentShift shift=calculateShift(indentStartLine, indentSkipPosition);
            if (shift==indentShift.DEDENT){
                if(isOpeningLine(indexHistoryLines))
                {
                        IndentInfo prevLine = getHistory().getLine(indexHistoryLines-1);
                        if(calculateShift(currentLine.getIndentValue(), prevLine.getIndentValue())==indentShift.SAME_INDENT){                            
                            return indexHistoryLines-1;
                        }
                        else{                            
                            return indexHistoryLines;
                        }
                }
                else {
                    return indexHistoryLines;
                }                
              
            }            
        }        
        return 0; //SOF
    } 
    
    private IndentInfo findParentEnd(IndentInfo startLine) throws IOException{
        getHistory().setTokenIndex(startLine.getTokensSeen());
        int indentStartLine=startLine.getIndentValue();
        IndentInfo nextLine=skipLine(startLine);
        while(myParser.currentToken!=SGLR.EOF){            
            int indentSkipPosition=nextLine.getIndentValue();
            indentShift shift=calculateShift(indentStartLine, indentSkipPosition);
            if (shift==indentShift.DEDENT) {  
                if(isClosingLine(nextLine)){
                    nextLine=skipLine(nextLine);
                    if(nextLine==null)
                        break;
                }                              
                return nextLine;                
            
            }
            nextLine=skipLine(nextLine);
        }         
        return nextLine; //EOF
    }
    
    public ArrayList<StructureSkipSuggestion> getZoomOnPreviousSuggestions(StructureSkipSuggestion prevRegion){
        ArrayList<StructureSkipSuggestion> result = new ArrayList<StructureSkipSuggestion>();
        if(!prevRegion.isPreviousRegion() || (prevRegion.getIndexHistoryEnd()-prevRegion.getIndexHistoryStart() < 3)){
            result.add(prevRegion);
            return result;
        }
        int indentOfLevel = Integer.MAX_VALUE; //lower for each loop till same indent as region indent 
        int regionIndent=prevRegion.getStartSkip().getIndentValue();
        int startlineIndex=Math.max(prevRegion.getIndexHistoryStart(),prevRegion.getIndexHistoryEnd()-MAX_NR_OF_LINES);
        while (indentOfLevel > regionIndent) {
            //find last child with a big indent (smaller then previous level)
            int bigIndent=-1;            
            for (int i = prevRegion.getIndexHistoryEnd(); i >= startlineIndex; i--) {
                int currentLineIndent = getHistory().getLine(i).getIndentValue();
                if (bigIndent < currentLineIndent && currentLineIndent < indentOfLevel) {
                    bigIndent = currentLineIndent;                    
                }
            }
            //find all (maximal ...) fragments of sequential code lines with indent = bigIndent 
            int indexEndFragment = prevRegion.getIndexHistoryEnd();
            if(bigIndent!=regionIndent){
                boolean hasSetRegionEnd = false;
                StructureSkipSuggestion indentLevelRegion = new StructureSkipSuggestion();
                IndentInfo currentLine = IndentInfo.cloneIndentInfo(getHistory().getLine(indexEndFragment));               
                indentLevelRegion.setEndSkip(currentLine, indexEndFragment);
                int nrOfFragments=0;
                for (int i = prevRegion.getIndexHistoryEnd(); i >= startlineIndex; i--) {
                    currentLine = getHistory().getLine(i);
                    if(currentLine.getIndentValue() < bigIndent)
                        indexEndFragment=i;
                    if (hasSetRegionEnd) {
                        if(currentLine.getIndentValue() < bigIndent){
                            indentLevelRegion.setStartSkip(IndentInfo.cloneIndentInfo(getHistory().getLine(i + 1)), i+1);
                            result.add(indentLevelRegion);
                            //System.err.print(getHistory().getFragment(indentLevelRegion.getStartSkip().getTokensSeen(), indentLevelRegion.getEndSkip().getTokensSeen()-1));
                            hasSetRegionEnd = false;
                            nrOfFragments+=1;                            
                        }
                    }
                    else{                        
                        if (currentLine.getIndentValue() == bigIndent) {
                            indentLevelRegion = new StructureSkipSuggestion();
                            indentLevelRegion.setEndSkip(IndentInfo.cloneIndentInfo(getHistory().getLine(indexEndFragment)), indexEndFragment);
                            hasSetRegionEnd = true;
                        }
                    }
                    if(nrOfFragments>=MAX_NR_OF_STRUCTURES)
                        break;
                }
            }
            indentOfLevel=bigIndent;
        }
        result.add(prevRegion);
        return result;
    }
    
    public ArrayList<StructureSkipSuggestion> getPickErroneousChild(StructureSkipSuggestion prevRegion) throws IOException{
        ArrayList<StructureSkipSuggestion> result=new ArrayList<StructureSkipSuggestion>();
        if(!prevRegion.isPreviousRegion() || (prevRegion.getIndexHistoryEnd()-prevRegion.getIndexHistoryStart() < 2)){            
            result.add(prevRegion);
            return result;
        }        
        //result.addAll(selectRegion(prevRegion.getIndexHistoryEnd()-1));
        //result.addAll(selectPreviousRegion(prevRegion.getIndexHistoryEnd()-1));
        result.addAll(selectLastChildRegion(prevRegion.getIndexHistoryEnd(), prevRegion.getStartSkip().getIndentValue()));   
        if(result.size()>0){
            StructureSkipSuggestion skipPrev=result.get(0);
            result.addAll(selectPriorRegions(skipPrev.getIndexHistoryStart()));
        }
        result.add(prevRegion);
        return result;
    }
    

    private boolean isClosingLine(int indexLine) {             
        IndentInfo currLine= getHistory().getLine(indexLine);  
        if (isClosingChar(getHistory().recoverTokenStream[currLine.getTokensSeen()]))
            return true;
        else if (useOpeningClosingDefaults)
            return false;  
        if(indexLine==0)
            return false;
        IndentInfo prevLine=getHistory().getLine(indexLine - 1);
        if(prevLine.getIndentValue()<=currLine.getIndentValue())
            return false;
        if(currLine.getStackNodes().size()==0)
            return true;
        IndentInfo nextLine=getHistory().getLine(indexLine + 1);        
        if (nextLine==null)
            return true;        
        if(nextLine.structureStartPosition()>=currLine.structureStartPosition())
            return false;
        return true;
    }
    
    private boolean isErrorOnClosingLine(int indexLine) throws IOException {
        IndentInfo line = getHistory().getLine(indexLine);
        if (isClosingChar(getHistory().recoverTokenStream[line.getTokensSeen()]))
            return true;
        else if (useOpeningClosingDefaults)
            return false;
        if (indexLine==0)
            return false;
        IndentInfo prevLine=getHistory().getLine(indexLine-1);
        if(prevLine.getIndentValue()<= line.getIndentValue())
            return false;
        IndentInfo nextLine=viewNextLine(line);
        if(nextLine.getIndentValue()>line.getIndentValue())
            return false;
        int startReduction=line.structureStartPosition();
        int startConstruct = getHistory().getLine(findParentBegin(indexLine-1)).getTokensSeen();
        if(startReduction==0 || startReduction > startConstruct) //construct unfinished
            return true;
        if(getHistory().getLastChar()==SGLR.EOF)
            return true;
        return false;
    }
    
    private boolean possibleErrorOnClosingLine(int indexLine) throws IOException {
        IndentInfo line = getHistory().getLine(indexLine);        
        IndentInfo prevLine=getHistory().getLine(indexLine-1);        
        IndentInfo nextLine=viewNextLine(line);             
        if(line.getIndentValue() < prevLine.getIndentValue() && line.getIndentValue()>=nextLine.getIndentValue())
            return true;
        return false;
    }

    private boolean isOpeningLine(int indexLine) {     
        if(indexLine==0)
            return false;
        IndentInfo line = getHistory().getLine(indexLine);
        if (isOpeningChar(getHistory().recoverTokenStream[line.getTokensSeen()]))
            return true;
        else if(useOpeningClosingDefaults)
            return false;
        IndentInfo prevLine = getHistory().getLine(indexLine-1);        
        boolean sameIndent = prevLine.getIndentValue()==line.getIndentValue();
        boolean smallReduce = line.structureStartPosition() >= prevLine.getTokensSeen()-1;
        return sameIndent && smallReduce;
    }

    private boolean isOpeningLine(IndentInfo currLine) throws IOException {
        if(isOpeningChar((char)myParser.currentToken))
            return true;
        else if (useOpeningClosingDefaults)
            return false;
        IndentInfo nextLine = viewNextLine(currLine);
        if(nextLine.getIndentValue()<=currLine.getIndentValue())
            return false;
        return true;
    }

    private boolean isClosingLine(IndentInfo currLine) throws IOException {
        if (isClosingChar((char)myParser.currentToken))
            return true;
        else if (useOpeningClosingDefaults)
            return false;
        IndentInfo nextLine = viewNextLine(currLine);
        if(nextLine.getIndentValue()>currLine.getIndentValue())
            return false;
        if(nextLine.getIndentValue() < currLine.getIndentValue())
            return true;        
        return true;//Alternative (more precise): try parse line, and check if closing occurs?
    }
    
    private IndentInfo viewNextLine(IndentInfo currLine) throws IOException {
        int currentLocation = getHistory().getTokenIndex()-1;
        getHistory().setTokenIndex(currLine.getTokensSeen()-1);
        IndentInfo nextLine = skipLine(currLine);
        getHistory().setTokenIndex(currentLocation);
        return nextLine;
    }   

    private IndentInfo skipLine(IndentInfo line) throws IOException {
        getHistory().setTokenIndex(Math.max(0, line.getTokensSeen()-1));
        int newLineNumber=line.getLineNumber();
        skipIndentHandler.setInLeftMargin(false);
        getHistory().readRecoverToken(myParser);
        while(myParser.currentToken!=SGLR.EOF){
            getHistory().readRecoverToken(myParser);
            if(myParser.currentToken=='\n')
                newLineNumber++;
            skipIndentHandler.updateIndentation(myParser.currentToken);
            if(skipIndentHandler.lineMarginEnded()){
                IndentInfo result = new IndentInfo(newLineNumber, getHistory().getTokenIndex()-1, skipIndentHandler.getIndentValue());
                return result;
            }            
        }
        return new IndentInfo(newLineNumber+1, getHistory().getTokenIndex()-1, 0);// EOF
    }

    private indentShift calculateShift(int indentStartLine, int indentSkipPosition) {
        int difference=indentStartLine-indentSkipPosition;
        if(difference>0)
            return indentShift.DEDENT;
        if(difference<0)
            return indentShift.INDENT;
        return indentShift.SAME_INDENT;
    } 
}

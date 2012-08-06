package org.spoofax.jsglr;

public class StructureSkipSuggestion {
    
    private IndentInfo startSkip;
    private IndentInfo endSkip; 
    private int indexHistoryStart;
    private int indexHistoryEnd;
    
    public int getIndexHistoryStart() {
        return indexHistoryStart;
    }
    
    public boolean isPreviousRegion(){
        return indexHistoryStart>=0 && indexHistoryEnd>=0;
    }

    public int getIndexHistoryEnd() {
        return indexHistoryEnd;
    }

    public void setStartSkip(IndentInfo startSkip) {
        this.startSkip = startSkip;
        if(endSkip!=null)
            getEndSkip().fillStackNodes(getStartSkip().getStackNodes());
    }

    public void setEndSkip(IndentInfo endSkip) {
        this.endSkip = endSkip;
        if(startSkip!=null)
            getEndSkip().fillStackNodes(getStartSkip().getStackNodes());
    }
    
    public void setStartSkip(IndentInfo startSkip, int indexStart) {
        indexHistoryStart=indexStart;
        setStartSkip(startSkip);        
    }

    public void setEndSkip(IndentInfo endSkip, int indexEnd) {
        indexHistoryEnd=indexEnd;
        setEndSkip(endSkip);
    }

    public StructureSkipSuggestion(){
        indexHistoryEnd=-1;
        indexHistoryStart=-1;
    }   
    
    public IndentInfo getStartSkip() {
        return startSkip;
    }
    
    public IndentInfo getEndSkip() {
        return endSkip;
    }
    
    public void setSkipLocations(IndentInfo startSkip, IndentInfo endSkip) {
        this.startSkip = startSkip;
        this.endSkip = endSkip;
        getEndSkip().fillStackNodes(getStartSkip().getStackNodes());
    }
    
    public void setSkipLocations(IndentInfo startSkip, IndentInfo endSkip, int indexStart, int indexEnd) {
        indexHistoryStart= indexStart;
        indexHistoryEnd=indexEnd;
        setSkipLocations(startSkip, endSkip);
    }
}

package org.spoofax.jsglr;

/*
 * Keeps up with indentation by inspecting characters
 * Use: inspect characters during parsing, or during the traversal of an ATerm
 */
public class IndentationHandler {
       
    private boolean isInLeftMargin; 
    private int indentValue; 
    private boolean lineMarginFound;  
    private boolean emptyLineFound;
    
    /*
     * Says whether the indenthandler is supposed to be in the left margin 
     */
    public void setInLeftMargin(boolean isInLeftMargin) {
        this.isInLeftMargin = isInLeftMargin;
    }

    /*
     * Says whether the indenthandler is in left margin of current line 
     * (Last characters were: '/n' + layout)
     */
    public boolean isInLeftMargin() {
        return isInLeftMargin;
    }

    /*
     * Value of indentation after last character
     */
    public int getIndentValue() {
        return indentValue;
    }
    
    public void setIndentValue(int startIndent) {
        indentValue = startIndent;
    }
    
    public boolean emptyLineParsed() {
        // TODO Auto-generated method stub
        return emptyLineFound;
    }   
    
    /*
     * The last inspected character marks the end of the margin 
     */
    public boolean lineMarginEnded() {
        return lineMarginFound;
    }    

    /*
     * Keeps up with the value of the left indentation
     */
    public IndentationHandler()
    {
        initEvaluationVariables();
    }
 
    void initEvaluationVariables() {
        indentValue = 0;        
        setInLeftMargin(true);
        lineMarginFound =false;
        emptyLineFound=false;
    }  
    
    /*
     * Set indentation fields for current token
     */
    public void updateIndentation(int curTok)
    {
        boolean oldLeftMargin = isInLeftMargin();
        updateLeftMargeFields(curTok);
        lineMarginFound = oldLeftMargin && !isInLeftMargin();   
        emptyLineFound = oldLeftMargin && curTok=='\n';
    }    
    
    private void updateLeftMargeFields(int charValue) {        
        switch (charValue) {
        case '\n':
            indentValue = 0;
            setInLeftMargin(true);   
            break;
        case ' ': 
            if (isInLeftMargin())
                indentValue += 1;
            break;
        case '\t':
            if (isInLeftMargin())
                indentValue += SGLR.TAB_SIZE;             
            break;
        case SGLR.EOF:
            break;
        default:
            setInLeftMargin(false); //Indent value is set after first non-whitespace character of a line
            break;
        }
    }

    
}

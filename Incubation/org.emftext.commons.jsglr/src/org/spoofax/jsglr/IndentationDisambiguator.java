package org.spoofax.jsglr;

import static org.spoofax.jsglr.Term.applAt;
import static org.spoofax.jsglr.Term.termAt;
import aterm.ATerm;
import aterm.ATermAppl;
import aterm.ATermInt;
import aterm.ATermList;

//TODO: implement all indentation rules 
// RULE 1: All list elements have same indentation
// RULE 2: If elements have same indentation, prefer sibling interpretation
// Rule 3: Closing tokens have same indentation as the first element
// Rule 4: No dedent for siblings
// Rule 5: ...

/*Summary:
 * This class offers the possibility to disambiguate based on layout considerations.
 * Assumption: list elements are expected to have the same indentation.
 * 
 * Use: 
 * Evaluate the indentation scores for both options,
 * and pick the option with the smallest deviation score or, if deviation is not conclusive, the highest congruence score. 
 * - A low deviation score means that few elements of the same list have differences in indentation    
 * - A high congruence score means that elements with the same indentation are contained in the same list, if possible
 */
public class IndentationDisambiguator {
     
    private IndentationHandler myIndentHandler; //keeps up with the indentation by dept-first inspection of the ATerm branch
    private IndentationHandler helperIndentHandler; //helps to find the start indent
    private int indentDeviationListElements;// Sum differences in indentation of list elements, calculated for the root term.
    private int indentCongruenceOfListElements; //Number of congruent list elements  
    private int indentDeviationClosingTokens; 
   
    public int getPosFirstErrorListElement() {
        return posFirstErrorListElement;
    }

    private int posFirstErrorListElement;
    private int charCount;       
    
  
    /*
     * Gets the indent deviation of closing tokens with respect to the first child
     * (does not work correct on the moment)
     */
    public int getIndentDeviationClosingTokens() {
        return indentDeviationClosingTokens;
    }

    /*
     * Gets the deviation-sum of list elements with respect to the first child
     * (Zero is good, high score shows a bad interpretation with respect to layout)
     */
    public int getIndentDeviationListElements() {
        return indentDeviationListElements;
    }    
    
    private void setStartIndentation(int indent){
        myIndentHandler.setIndentValue(indent);
    }

    /*
     * Class containing method to distinct between two alternate ATerm branches 
     * based on layout considerations
     */
    public IndentationDisambiguator()
    {
        myIndentHandler=new IndentationHandler();
        helperIndentHandler = new IndentationHandler();
        initEvaluationVariables();
    }
 
    private void initEvaluationVariables() {
        indentDeviationListElements = 0;
        indentCongruenceOfListElements = 0;
        indentDeviationClosingTokens=0;
        posFirstErrorListElement=-1;        
        charCount=0;
        myIndentHandler.initEvaluationVariables();        
    }
    
    /*
     * Calculates an evaluation score based on the difference in indentation between list elements.
     * - A deviation score zero means that no list contains elements with differences in indentation    
     * - A high congruence score means that elements with the same indentation are contained in the same list, if possible
     * Low deviation and high congruence indicate a good correspondence between syntax and layout.
     */
    public void evaluateIndentation(ATerm branch)
    {
        initEvaluationVariables();
        //Tools.debug(branch);
        calcIndentationScore(branch);
    } 
    
    /*
     * evaluates an ATerm assuming a start-indentation for the first character
     */
    public void evaluateIndentation(ATerm branch, int startIndent)
    {
        initEvaluationVariables();
        setStartIndentation(startIndent);
        //Tools.debug(branch);
        calcIndentationScore(branch);        
                
    } 
    
    private int findStartIndent(ATerm t, IndentationHandler myHandler)
    {   
        //update indentation by inspecting char values
        if (t.getType() == ATerm.INT) {
            ATermInt tInt = (ATermInt)t;
            int charValue = tInt.getInt();            
            myHandler.updateIndentation(charValue);
           // Tools.debug(" -- "+(char)charValue + "("+myHandler.getIndentValue()+")");
            if(myHandler.lineMarginEnded())
                return myHandler.getIndentValue();
        }
        //calculate score by depth-first traversal
        else if (t.getChildCount()>1)               
        {            
            ATermList contents = termAt(t, 1);  
            for (int i = 0; i < contents.getLength(); i++) { 
                int childIndent = findStartIndent(contents.elementAt(i), myHandler); //recursion
                if (childIndent>=0)
                    return childIndent;   
            }             
        }
        return -1;
     }
        
    private int calcIndentationScore(ATerm t)
    {   
        //update indentation by inspecting char values
        if (t.getType() == ATerm.INT) {
            ATermInt tInt = (ATermInt)t;
            int charValue = tInt.getInt();            
            myIndentHandler.updateIndentation(charValue);
            charCount++;
            //Tools.debug((char)charValue + "("+myIndentHandler.getIndentValue()+")");
        }
        //calculate score by depth-first traversal
        else if (t.getChildCount()>1)              
        {            
            helperIndentHandler.setIndentValue(myIndentHandler.getIndentValue());            
            ATermList contents = termAt(t, 1);           
            int prevSiblingIdentValue = -1; 
            int firstChildIndentValue=-1;            
            for (int i = 0; i < contents.getLength(); i++) { 
                //Tools.debug("child" +i);
                helperIndentHandler.setIndentValue(myIndentHandler.getIndentValue());
                int indentCurrentChild =findStartIndent(contents.elementAt(i), helperIndentHandler);
                if (indentCurrentChild >= 0 && prevSiblingIdentValue >=0) {
                    if(isListProduction(t)){                        
                        int diff = indentCurrentChild - prevSiblingIdentValue;                        
                        //Tools.debug("current indent: " + indentCurrentChild);
                        //Tools.debug("diff indent: " + diff);
                        indentDeviationListElements += Math.abs(diff);
                        if(diff!=0 && posFirstErrorListElement==-1){
                            posFirstErrorListElement=charCount;
                            if(myIndentHandler.isInLeftMargin()||myIndentHandler.lineMarginEnded())
                                posFirstErrorListElement-= myIndentHandler.getIndentValue();
                        }
                        if (diff == 0){
                            indentCongruenceOfListElements += 1;                            
                        }
                    }  
                    else if(isLiteralProduction(contents.elementAt(i))){   //(?)i==contents.getLength()-1 &&
                        //Tools.debug(" lit prod ");
                        int diff = indentCurrentChild - firstChildIndentValue;
                        if(diff!=0){
                           //Tools.debug("literal indent: " + indentCurrentChild);
                           //Tools.debug("diff indent: " + diff);
                           //Tools.debug("first Child: "+firstChildIndentValue);
                            //Tools.debug("prev sib: "+prevSiblingIdentValue);
                        }
                        indentDeviationClosingTokens += Math.abs(diff);                        
                    }

                }
                if(indentCurrentChild>=0){
                    prevSiblingIdentValue = indentCurrentChild;
                    //Tools.debug("prev sib: "+prevSiblingIdentValue);
                    if(firstChildIndentValue<0){
                        firstChildIndentValue=indentCurrentChild;
                        helperIndentHandler.setInLeftMargin(true);
                        //Tools.debug("first Child: "+firstChildIndentValue);
                    }
                    //Tools.debug("prev sib: "+prevSiblingIdentValue);
                }
                calcIndentationScore(contents.elementAt(i)); //recursion                
                
            }            
        }
        return indentDeviationListElements; //+ indentScoreChilds-flatTreeBonus;        
    }
    
    //TODO: see asfix imploder, asfix analyzer
    private static boolean isListProduction(ATerm appl)
    {
        ATermAppl prod = termAt(appl, 0); //production       
        ATermAppl rhs = termAt(prod, 1);  //1 => Right hand side
        return isList(rhs);
    }
    
    private static boolean isLiteralProduction(ATerm appl)
    {
        if(appl.getChildCount()==0){
            return false;
        }
        ATermAppl prod = termAt(appl, 0); //production       
        ATermAppl rhs = termAt(prod, 1);  //1 => Right hand side
        return isLiteral(rhs);
    }
    
    public static boolean isLiteral(ATermAppl sort) {
        return sort.getName().equals("lit") || sort.getName().equals("cilit");
    }
    
    //TODO: This code is copy-pasted from asfix analyzer
    private static boolean isList(ATermAppl sort) {
        ATermAppl details = sort.getName().equals("cf")
                          ? applAt(sort, 0)
                          : sort;
                        
        if (details.getName().equals("opt"))
            details = applAt(details, 0);
        
        String name = details.getName();
        
        return name.equals("iter") || name.equals("iter-star")  || name.equals("iter-plus")
                || name.equals("iter-sep") || name.equals("seq") || name.equals("iter-star-sep")
                || name.equals("iter-plus-sep");
    }    
}

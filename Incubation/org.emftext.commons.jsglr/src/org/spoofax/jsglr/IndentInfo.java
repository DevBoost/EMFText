package org.spoofax.jsglr;

import org.spoofax.ArrayDeque;

/*
 * Should be created before parsing the first character of a line
 * Keeps information about indentation of a line.
 * Keeps parser state in order to support backtracking
 */
public class IndentInfo {
    
    private final int lineNumber;
    private final int tokensSeen;
    private final int indentValue;
    private final ArrayDeque<Frame> stackNodes;
        
    public ArrayDeque<Frame> getStackNodes() {
        return stackNodes;
    }   
    
    public void fillStackNodes(ArrayDeque<Frame> nodes) {
        stackNodes.clear();        
        stackNodes.addAll(nodes);        
    } 

    public int getLineNumber() {
        return lineNumber;
    }

    public int getTokensSeen() {
        return tokensSeen;
    }

    public int getIndentValue() {
        return indentValue;
    }
    
    public static IndentInfo cloneIndentInfo(IndentInfo original){
        IndentInfo cloneResult = new IndentInfo(original.getLineNumber(), original.getTokensSeen(), original.getIndentValue());
        cloneResult.fillStackNodes(original.getStackNodes());
        return cloneResult;    
    }
    
    public IndentInfo(int line, int tok, int indent)
    {
        lineNumber=line;
        tokensSeen=tok;
        indentValue=indent;
        stackNodes=new ArrayDeque<Frame>();
    }

    public IndentInfo() {
        this(-1, -1, -1);
    }

    /*
     * Calculates the biggest reduce belonging to this backtrack point.
     */
    public int maxReduceLength() {
        int maxPathLength = 0;
        for (Frame activeStack : stackNodes) {
            for (Path p : activeStack.findAllPaths(3)) {//3=> shifted_LO, reduced_LO, ReducedCodeFragment
                int length = p.getLength(); //length => total_length, p => reduce_length, p.p => layout_length (-shift), p.p.p => shift_length (=1)                 
                if(length > maxPathLength){
                    maxPathLength = length;                   
                }
            }
        }
        return maxPathLength;
    }    
    
    //Calculates the start position of the biggest reduce
    public int structureStartPosition()
    {
        return tokensSeen - maxReduceLength();        
    }
    
    public Link getReductionLink() {
        int maxPathLength = -1;
        Link result=null;
        for (Frame activeStack : stackNodes) {
            for (Path p : activeStack.findAllPaths(3)) {//3=> shifted_LO, reduced_LO, ReducedCodeFragment
                int length = p.getLength(); //length => total_length, p => reduce_length, p.p => layout_length (-shift), p.p.p => shift_length (=1)                 
                if(length > maxPathLength){
                    maxPathLength = length;
                    if(p.parent.label!=null)
                        result =p.parent.lnk;
                }
            }
        }
        return result;
    }    
}

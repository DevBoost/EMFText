package org.spoofax.jsglr;

import static org.spoofax.jsglr.Term.*;
import aterm.ATerm;
import aterm.ATermAppl;
import aterm.ATermList;
import aterm.pure.ATermListImpl;

public class IndentationFilter {
    
    public static void resolveAmbiguitiesByIndentation(ATerm node)
    {
        if (node.getChildCount()>1)               
        {
            ATermList contents;
            if ("amb".equals(((ATermAppl) node).getName())){
                contents = termAt(node, 0);
            }
            else{
                contents = termAt(node, 1);
            }  
            for (int i = 0; i < contents.getLength(); i++) {
                resolveAmbiguitiesByIndentation(contents.elementAt(i));
            }
        } 

        if ("amb".equals(((ATermAppl) node).getName())){
            ATermListImpl ambs = termAt(node, 0);
            node = ambs.elementAt(0);
        }        
    }

}

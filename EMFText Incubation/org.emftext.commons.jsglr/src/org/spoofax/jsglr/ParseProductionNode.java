/*
 * Created on 30.mar.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import aterm.ATerm;

public class ParseProductionNode extends IParseNode {

    public final int prod;
    
    public ParseProductionNode(int prod) {
        this.prod = prod;
    }
    
    public ATerm toParseTree(ParseTable pt) {
    	return pt.getProduction(prod);
    }
    @Override
    public String toString() {
        return "" + prod;
    }
    
    public int getProduction() { return prod; }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ParseProductionNode))
            return false;
        return prod == ((ParseProductionNode)obj).prod;
    }
    
    @Override
    void clear() {}
    
    @Override
    public int hashCode() {
        return 6359 * prod;
    }

    @Override
    public String toStringShallow() {
        return "prod*(" + prod + ")";
    }
}

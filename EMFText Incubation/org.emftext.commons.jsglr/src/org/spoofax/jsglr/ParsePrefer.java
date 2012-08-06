/*
 * Created on 17.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import java.util.List;

import aterm.ATerm;

public class ParsePrefer extends ParseNode {

    public ParsePrefer(int label, List<IParseNode> kids) {
        super(label, kids);
    }

    @Override
    public ATerm toParseTree(ParseTable pt) {
        return super.toParseTree(pt);
        //throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "prefer(aprod(" + label + "), " + kids + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ParsePrefer))
            return false;
        return super.equals(obj);
    }
}

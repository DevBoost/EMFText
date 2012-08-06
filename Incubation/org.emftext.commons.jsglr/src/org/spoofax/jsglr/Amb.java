/*
 * Created on 30.mar.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import java.util.ArrayList;
import java.util.List;

import aterm.ATerm;
import aterm.ATermList;
import aterm.ATermFactory;

public class Amb extends IParseNode {

    private final List<IParseNode> alternatives;

    Amb(IParseNode left, IParseNode right) {
        alternatives = new ArrayList<IParseNode>();
        alternatives.add(left);
        alternatives.add(right);
    }

    public Amb(List<IParseNode> alternatives) {
        this.alternatives = alternatives;
    }

    public ATerm toParseTree(ParseTable pt) {

        ATermFactory factory = pt.getFactory();
        ATermList l1 = factory.makeList();
        for (int i = alternatives.size() - 1; i >= 0; i--) {
            l1 = factory.makeList(alternatives.get(i).toParseTree(pt), l1);
        }
        return pt.getFactory().makeAppl(pt.ambAFun, l1);
    }

    public void clear() {
        for (int i = 0; i < alternatives.size(); i++) {
            alternatives.get(i).clear();
        }
        alternatives.clear();
    }

    @Override
    public String toString() {
        return "amb(" + alternatives + ")";
    }

    public boolean hasAmbiguity(IParseNode newNode) {
        throw new NotImplementedException();
    }

    public List<IParseNode> getAlternatives() {
        return alternatives;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Amb))
            return false;
        Amb o = (Amb)obj;
        if(o.alternatives.size() != alternatives.size())
            return false;
        for(int i=0;i<alternatives.size();i++)
            if(!alternatives.get(i).equals(o.alternatives.get(i)))
                return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int r = 0;
        for(IParseNode n : alternatives)
            r += n.hashCode();
        return r;
    }

    @Override
    public String toStringShallow() {
        return "Amb";
    }
}

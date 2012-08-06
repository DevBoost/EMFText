/*
 * Created on 30.mar.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import java.util.List;

import aterm.ATerm;
import aterm.ATermFactory;
import aterm.ATermList;
import aterm.pure.PureFactory;

public class ParseNode extends IParseNode {

    public final int label;
    protected List<IParseNode> kids;

    public ParseNode(int label, List<IParseNode> kids) {
        this.label = label;
        this.kids = kids;
    }

    public ATerm toParseTree(ParseTable pt) {
        ATermFactory factory = pt.getFactory();

        ATermList l1 = factory.makeList();
        for (int i = kids.size() - 1; i >= 0; i--) {
            l1 = factory.makeList(kids.get(i).toParseTree(pt), l1);
        }

        return factory.makeAppl(pt.applAFun, pt.getProduction(label), l1);
    }

    /**
     * todo: stolen from TAFReader; move elsewhere
     */
    public static ATermList makeList(PureFactory factory, List<ATerm> terms) {
        ATermList result = factory.getEmpty();
        for (int i = terms.size() - 1; i >= 0; i--) {
            result = factory.makeList(terms.get(i), result);
        }
        return result;
    }

    @Override
    public String toString() {
        return "regular(aprod(" + label + ")," + kids + ")";
    }

    public int getLabel() { return label; }
    
    public List<IParseNode> getKids() { return kids; }

    void clear() {
        for (int i = 0; i < kids.size(); i++) {
            kids.get(i).clear();
        }
        kids.clear();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ParseNode))
            return false;
        if (obj == this)
            return true;
        ParseNode o = (ParseNode)obj;
        if(label != o.label)
            return false;
        if(kids.size() != o.kids.size())
            return false;
        for(int i=0;i<kids.size();i++) {
            if(!kids.get(i).equals(o.kids.get(i)))
                return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        // FIXME improve
        int r = 1337 * label ;
        for(IParseNode n : kids)
            r += n.hashCode();
        return r;
    }

    @Override
    public String toStringShallow() {
        return "regular*(" + label + ", {" +  kids.size() + "})";
    }
}

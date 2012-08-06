/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;


public class Link {

    public static int linksCreated =0; //mj Testing
    
    protected Frame parent;

    protected IParseNode label;

    private boolean rejected;
    
    public int length; //mj: private final (see sglr.reducer: replace link by link with less avoids)
    
    public int recoverCount;
    

    public Link(Frame destination, IParseNode t, int length) {
        this.parent = destination;
        label = t;
        rejected = false;
        this.length = length;
        recoverCount =0;
        linksCreated +=1;
    }

    public void reject() {
        if(Tools.tracing) {
            SGLR.TRACE("SG_MarkLinkRejected() - " + parent.state.stateNumber + ", " + length);
        }
        rejected = true;
    }

    public boolean isRejected() {
        return rejected;
    }

    public String toString() {
        return "" + parent.state.stateNumber;
    }

    public int getLength() {
        return length;
    }

    public void clear() {
        if(parent != null) {
            parent = null;//todo.clear();
        }
        this.label = null;
    }

    public void addAmbiguity(IParseNode t, int tokensSeen) {
        if(Tools.tracing) {
            SGLR.TRACE("SG_CreateAmbCluster() - " + tokensSeen);
        }
        
        label = new Amb(label, t);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Link))
            return false;
        Link o = (Link)obj;
        
        return o.parent == parent &&
        o.label == label &&
        o.rejected == rejected &&
        o.length == length;
    }
}
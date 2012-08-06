/*
 * Created on 05.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;

public class Goto implements Serializable {

    static final long serialVersionUID = 4361136767191244085L;
    
    private final RangeList ranges;
    public final int nextState;
    private transient int hashCode;
    
    public Goto(RangeList ranges, int nextState) {
        this.ranges = ranges;
        this.nextState = nextState;
    }

    public boolean hasProd(int label) {
        return ranges.within(label);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Goto))
            return false;
        Goto o = (Goto)obj;
        if(nextState != o.nextState)
            return false;
        return ranges.equals(o.ranges);
    }
    
    @Override
    public int hashCode() {
        if (hashCode == 0)
            hashCode = ranges.hashCode();
        return hashCode;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("goto(");
        sb.append(ranges);
        sb.append(", ");
        sb.append(nextState);
        sb.append(")");
        return sb.toString(); 
    }
}

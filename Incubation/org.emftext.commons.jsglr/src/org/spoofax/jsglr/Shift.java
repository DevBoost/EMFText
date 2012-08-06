/*
 * Created on 06.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

public class Shift extends ActionItem {

    private static final long serialVersionUID = -5777912109162535928L;
    
    public final int nextState;
    
    public Shift(int nextState) {
        super(SHIFT);
        this.nextState = nextState;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Shift))
            return false;
        return nextState == ((Shift)obj).nextState;
    }
    
    @Override
    public int hashCode() {
        return nextState;
    }
    
    public String toString() {
        return "shift(" + nextState + ")";
    }
}

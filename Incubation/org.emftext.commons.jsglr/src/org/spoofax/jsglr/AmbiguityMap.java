/*
 * Created on 17.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class AmbiguityMap {

    private boolean[] positions;
    
    public AmbiguityMap(int size) {
        positions = new boolean[size];
    }

    public boolean isMarked(int pos) {
        if(pos < 0 || pos > positions.length)
            return false;
        return positions[pos];
    }

    public void mark(int pos) {
        positions[pos] = true;
    }

    public void unmark(int pos) {
        positions[pos] = false;
    }
}

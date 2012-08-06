/*
 * Created on 17.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class PositionMap {

    private final int[] positions;

    public PositionMap(int maxNumberOfAmbiguities) {
        positions = new int[maxNumberOfAmbiguities];
        for (int i = 0; i < positions.length; i++)
            positions[i] = -1;
    }

    public int getValue(int pos) {
        if(pos > positions.length || pos < 0)
            return -1;
        return positions[pos];
    }

    public void put(int pos, int v) {
        positions[pos] = v;
    }
}

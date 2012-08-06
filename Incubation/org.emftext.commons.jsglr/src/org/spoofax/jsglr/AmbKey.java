/*
 * Created on 01.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class AmbKey {

    private IParseNode key;
    private int pos;
    
    AmbKey(IParseNode key, int pos) {
        this.key = key;
        this.pos = pos;
    }
    
    @Override
    public int hashCode() {
        return key.hashCode() ^ (pos * 129357);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AmbKey)) {
            return false;
        }
        AmbKey o = (AmbKey)obj;
        return pos == o.pos && key.equals(o.key);
    }
    
    @Override
    public String toString() {
        return "AmbKey(" + key + ", " + pos + ")";
    }
}

/*
 * Created on 30.mar.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import aterm.ATerm;

public abstract class IParseNode {

    public abstract ATerm toParseTree(ParseTable pt);

    abstract void clear();
    abstract public boolean equals(Object obj);
    abstract public int hashCode();
    
    abstract public String toStringShallow(); 
    abstract public String toString();
}

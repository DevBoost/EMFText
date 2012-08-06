/*
 * Created on 13. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class Associativity {

    public final int associativity;
    public final int production;
    
    public Associativity(int associativity, int production) {
        this.associativity = associativity;
        this.production = production;
    }

}

/*
 * Created on 06.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

public class Accept extends ActionItem {

    private static final long serialVersionUID = -3768565929814294895L;

    public Accept() {
        super(ACCEPT);
    }

    public String toString() {
        return "accept";
    }
}

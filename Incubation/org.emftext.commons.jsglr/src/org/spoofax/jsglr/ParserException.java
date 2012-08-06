/*
 * Created on 06.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

public class ParserException extends Exception {

 
    private static final long serialVersionUID = -7565203797064665307L;
    private String reason;
    
    public ParserException(String reason) {
        this.reason = reason;
    }

    public String toString() {
        return reason;
    }
}

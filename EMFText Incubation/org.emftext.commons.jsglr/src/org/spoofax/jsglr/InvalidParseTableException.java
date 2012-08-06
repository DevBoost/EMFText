/*
 * Created on 08.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;


public class InvalidParseTableException extends Exception {

    private static final long serialVersionUID = 7932152591235406499L;
    
    public InvalidParseTableException(String message) {
        super(message);
    }
}

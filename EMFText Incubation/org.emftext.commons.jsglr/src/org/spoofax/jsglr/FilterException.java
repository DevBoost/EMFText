/*
 * Created on 3. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class FilterException extends SGLRException {

    private static final long serialVersionUID = -3107849742654999518L;

    public FilterException(SGLR parser, String message, Throwable cause) {
        super(parser, message, cause);
    }

    public FilterException(SGLR parser, String message) {
        super(parser, message);
    }
    
    public FilterException(SGLR parser) {
        super(parser, "Filter exception");
    }

}

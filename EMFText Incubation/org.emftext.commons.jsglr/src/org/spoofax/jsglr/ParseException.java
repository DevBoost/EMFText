/*
 * Created on 3. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class ParseException extends SGLRException {

    private static final long serialVersionUID = -7341039998837389710L;

    public ParseException(SGLR parser, String message) {
        super(parser, message);
    }

}

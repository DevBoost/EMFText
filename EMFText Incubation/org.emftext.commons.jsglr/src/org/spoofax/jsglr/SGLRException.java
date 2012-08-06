/*
 * Created on 3. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import aterm.ATerm;
import aterm.ATermFactory;

public class SGLRException extends Exception {

    private static final long serialVersionUID = -8467572969588110480L;
    
    private final SGLR parser;
    
    public SGLRException(SGLR parser, String message, Throwable cause) {
        super(message, cause);
        this.parser = parser;
    }
    
    public SGLRException(SGLR parser, String message) {
        this(parser, message, null);
    }
    
    public SGLRException(SGLR parser) {
        this(parser, null, null);
    }
    
    public final SGLR getParser() {
        return parser;
    }
    
    public final ATerm toTerm() {
        return toTerm("-");
    }
    
    protected String getShortMessage() {
        return getMessage();
    }
    
    public ATerm toTerm(String filename) {
        if (parser == null)
            throw new UnsupportedOperationException();
        
        ATermFactory factory = parser.getFactory();
        return factory.makeAppl(
            factory.makeAFun("error", 2, false),
            factory.makeAppl(factory.makeAFun("Parse error", 0, true)),
            factory.makeList(
                factory.makeAppl(
                    factory.makeAFun("localized", 2, false),
                    factory.makeAppl(factory.makeAFun(getShortMessage(), 0, true)),
                    factory.makeAppl(
                        factory.makeAFun("area-in-file", 2, false),
                        factory.makeAppl(factory.makeAFun(filename, 0, true)),
                        toLocationATerm()
                    )
                )
            )
        );
    }
    
    protected ATerm toLocationATerm() {
        ATermFactory factory = parser.getFactory();
        return factory.makeAppl(
            factory.makeAFun("area", 6, false),
            factory.makeInt(0),
            factory.makeInt(0),
            factory.makeInt(0),
            factory.makeInt(0),
            factory.makeInt(0),
            factory.makeInt(0)
        );
    }
}

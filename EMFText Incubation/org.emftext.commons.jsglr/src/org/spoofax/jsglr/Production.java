/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import static org.spoofax.jsglr.ProductionType.*;

import java.io.Serializable;
import java.util.List;

public class Production implements Serializable {

    static final long serialVersionUID = 8767621343854666185L;

    public final int arity;

    public final int label;

    public final int status;
    
    private final boolean isRecover;

    public Production(int arity, int label, int status, boolean isRecover) {
        this.arity = arity;
        this.label = label;
        this.status = status;
        this.isRecover = isRecover;
    }

    public IParseNode apply(List<IParseNode> kids) {
        switch(status) {
        case REJECT:
            return new ParseReject(label, kids);
        case AVOID:
            return new ParseAvoid(label, kids);
        case PREFER:
            return new ParsePrefer(label, kids);
        case NO_TYPE:
            return new ParseNode(label, kids);
        }
        throw new IllegalStateException();
    }

    public boolean isRejectProduction() {
        return status == REJECT;
    }
    
    public boolean isRecoverProduction() {
        return isRecover;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Production))
            return false;
        Production o = (Production)obj;
        return arity == o.arity && label == o.label && status == o.status;
    }
}

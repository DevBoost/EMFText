/*
 * Created on 16.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import static org.spoofax.jsglr.ProductionType.*;

import java.io.Serializable;

import aterm.ATerm;

public class ProductionAttributes implements Serializable {

    private static final long serialVersionUID = 556855017447626835L;

    private final int type;
    
    private final boolean isRecover;

    private final transient ATerm abstractCtor;

    ProductionAttributes(ATerm ctor, int type, boolean isRecover) {
        this.type = type;
        this.abstractCtor = ctor;
        this.isRecover = isRecover;
    }

    public final int getType() {
        return type;
    }

    public final ATerm getTerm() {
        return abstractCtor;
    }
    
    public boolean isRecoverProduction() {
        return isRecover;
    }

    public boolean isMoreEager(ProductionAttributes other) {
        return type != other.type && (type == PREFER || other.type == AVOID);
    }
}

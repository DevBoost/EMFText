/*
 * Created on 06.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import aterm.ATermAppl;

import java.io.Serializable;

public class Label implements Serializable {

    static final long serialVersionUID = -4080621639747161438L;
    
    public final int labelNumber;
    public final transient ATermAppl prod;
    public final ProductionAttributes productionAttributes;
    public final boolean injection;
    
    public Label(int labelNumber, ATermAppl prod, ProductionAttributes productionAttributes, boolean injection) {
        this.labelNumber = labelNumber;
        this.prod = prod;
        this.productionAttributes = productionAttributes;
        this.injection = injection;
        
        if(productionAttributes == null)
            throw new RuntimeException();
    }

    public boolean isLeftAssociative() {
        return productionAttributes.getType() == ProductionType.LEFT_ASSOCIATIVE;
    }

    public boolean isRightAssociative() {
        return productionAttributes.getType() == ProductionType.RIGHT_ASSOCIATIVE;
    }
    
    public boolean isRecoverProduction() {
        return productionAttributes.isRecoverProduction();
    }

    public boolean isMoreEager(Label rightProd) {
        return productionAttributes.isMoreEager(rightProd.productionAttributes);
    }

    public ProductionAttributes getAttributes() {
        return productionAttributes;
    }

    public boolean isInjection() {
        return injection;
    }
}

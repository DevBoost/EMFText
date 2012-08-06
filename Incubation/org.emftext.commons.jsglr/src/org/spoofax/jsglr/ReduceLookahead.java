/*
 * Created on 30. des.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

public class ReduceLookahead extends ActionItem {

    private static final long serialVersionUID = 8620275049778432243L;

    public final int arity;

    public final int label;

    public final int status;

    public final Production production;

    protected final RangeList[] charRanges;
    
    public ReduceLookahead(int arity, int label, int status, RangeList[] charClasses) {
        super(REDUCE_LOOKAHEAD);

        this.arity = arity;
        this.label = label;
        this.status = status;
        this.charRanges = charClasses;

        production = new Production(arity, label, status, false);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Reduce))
            return false;
        Reduce o = (Reduce) obj;
        return arity == o.arity && label == o.label && status == o.status;
    }

    @Override
    public int hashCode() {
        return arity + status * 10 + label * 100;
    }

    public String toString() {
        return "reduce(" + arity + ", " + label + ", " + status + ")";
    }

    public RangeList[] getCharRanges() {
        return charRanges;
    }
}

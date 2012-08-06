/*
 * Created on 05.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;


public class Range implements Serializable, Comparable<Range> {

    static final long serialVersionUID = 3615037984707218175L;

    public int low;
    public int high;

    public Range(int low, int high) {

        this.low = low;
        this.high = high;
    }

    public Range(int n) {
        low = high = n;
    }

    boolean within(int c) {
        return c >= low && c <= high;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Range))
            return false;
        Range o = (Range)obj;
        return low == o.low && high == o.high;
    }

    @Override
    public int hashCode() {
        return low + high * 7919;
    }

    @Override
    public String toString() {
        if(low == high)
            return "" + low;
        return "range(" + low + ", " + high + ")";
    }

    public int compareTo(Range o) {
        return o.low < low ? 1 : o.low == low ? 0 : -1;
    }
}

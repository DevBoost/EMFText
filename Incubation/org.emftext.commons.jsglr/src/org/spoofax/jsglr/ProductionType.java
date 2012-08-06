package org.spoofax.jsglr;

/**
 * SGLR production types, used in the parse table format.
 * 
 * @author Lennart Kats <lennart add lclnet.nl>
 */
public final class ProductionType {
    
    // FIXME: The 3, 5, and 6 values may not correspond to the parse table format

    public final static int NO_TYPE = 0;

    public final static int REJECT = 1;

    public final static int PREFER = 2;

    protected final static int BRACKET = 3;

    public final static int AVOID = 4;

    protected final static int LEFT_ASSOCIATIVE = 5;

    protected final static int RIGHT_ASSOCIATIVE = 6;
    
    private ProductionType() {}
}

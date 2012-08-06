/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;


public class Action implements Serializable {

    static final long serialVersionUID = -2742456888004361679L;

    protected RangeList ranges;

    protected ActionItem[] items;

    public Action(RangeList ranges, ActionItem[] items) {
        this.ranges = ranges;
        this.items = items;
    }

    public ActionItem[] getActionItems() {
        return items;
    }

    public boolean accepts(int currentToken) {
        return ranges.within(currentToken);
    }
    
    /**
     * Gets the character of a single-character range.
     * 
     * @return  The single range character, or -1 if not applicable.
     */
    public int getSingularRange() {
        return ranges.getSingularRange();
    }
    
    /*
     * Returns a char value that can be used for "brute-force" recovery
     */
    public int getFirstCharValue() {
        return ranges.getFirstRangeElement();
    }

    public boolean rejectable() {
        for(ActionItem ai : items) {
            if(ai instanceof Reduce) {
                Reduce r = (Reduce) ai;
                if(r.status == ProductionType.REJECT)
                    return true;
            }
                
        }
        return false;
    }

    public boolean hasPrefer() {
        for(ActionItem ai : items)
            if(ai instanceof Reduce) {
                Reduce r = (Reduce) ai;
                if(r.status == ProductionType.PREFER)
                    return true;
            }
        return false;
    }

    public boolean hasAvoid() {
        for(ActionItem ai : items)
            if(ai instanceof Reduce) {
                Reduce r = (Reduce) ai;
                if(r.status == ProductionType.AVOID) {
                    if(SGLR.isDebugging()) {
                        Tools.debug(this);
                    }
                    return true;
                }

            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("action(");
        sb.append(ranges);
        sb.append(", [");
        for(int i=0;i<items.length;i++) {
            sb.append(items[i]);
            if(i < items.length - 1)
                sb.append(", ");
        }
        sb.append("])");
        return sb.toString();
    }
}

/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class State implements Serializable {

    static final long serialVersionUID = 3383369639779986307L;

    public final int stateNumber;
    private final Goto[] gotos;
    private final Action[] actions;

    public State(int stateNumber, Goto[] gotos, Action[] actions) {
        this.stateNumber = stateNumber;
        this.gotos = gotos;
        this.actions = actions;
    }

    /**
     * @deprecated Use getActions() instead. 
     */
    @Deprecated
    public List<ActionItem> getActionItems(int currentToken) {
        
        List <ActionItem> ret = new ArrayList<ActionItem>();
        
        for(Action a : actions) {
            if(a.accepts(currentToken))
                for(ActionItem it : a.getActionItems())
                    ret.add(it);
        }
        return ret;
    }
    
    public Action[] getActions() {
        return actions;
    }
    
    /**
     * @return  The single action associated with this state, or null if not applicable.
     */
    public Action getSingularAction() {
        return actions.length == 1 ? actions[0] : null;
    }

    public int go(int labelNumber) {
        for(Goto g : gotos) {
            if(g.hasProd(labelNumber))
                return g.nextState;
        }
        return -1;
    }

    public boolean rejectable() {
        for(Action a : actions) {
            if(a.rejectable()) 
                return true;
        }
        return false;
    }

    public int getActionItemCount() {
        int total = 0;
        for(Action a : actions) {
            total += a.getActionItems().length;
        }
        return total;
    }

    public int getGotoCount() {
        return gotos.length;
    }

    public int getActionCount() {
        return actions.length;
    }

    public boolean hasPrefer() {
        for(Action a : actions) {
            if (a.hasPrefer())
                return true;
        }
        return false;
    }

    public boolean hasAvoid() {
        for(Action a : actions) {
            if (a.hasAvoid())
                return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("State(");
        sb.append(stateNumber);
        sb.append(", #");
        sb.append(actions.length);
        sb.append(" actions, #");
        sb.append(gotos.length);
        sb.append(" gotos)");
        sb.append("\n - [");
        for(int i=0;i<gotos.length;i++) {
            sb.append(gotos[i]);
            if(i < gotos.length -1)
                sb.append(", ");
        }
        sb.append("]\n - [");
        for(int i=0;i<actions.length;i++) {
            sb.append(actions[i]);
            if(i < actions.length -1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

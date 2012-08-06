/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;


public class ActionState implements Serializable {
    static final long serialVersionUID = 2059615768756265051L;

    public Frame st;
    public State s;
    public int currentToken;

    public ActionState(Frame st, State s) {
        this.st = st;
        this.s = s;
    }

    public void clear(boolean all) {
        if(all) {
            this.st.clear();
        }
        this.st = null;
        this.s = null;
    }
}

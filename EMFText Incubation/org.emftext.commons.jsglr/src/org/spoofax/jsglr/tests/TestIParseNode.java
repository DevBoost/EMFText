/*
 * Created on 21.apr.2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr.tests;

import java.util.ArrayList;
import java.util.List;

import org.spoofax.jsglr.IParseNode;
import org.spoofax.jsglr.ParseNode;
import org.spoofax.jsglr.ParseProductionNode;

import junit.framework.TestCase;

public class TestIParseNode extends TestCase {

    private IParseNode pn0; 
    private IParseNode pn1;
    
    @Override
    protected void setUp() throws Exception {
        List<IParseNode> r0 = new ArrayList<IParseNode>();
        r0.add(new ParseProductionNode(123));
        pn0 = new ParseNode(233, r0);

        List<IParseNode> r1 = new ArrayList<IParseNode>();
        r1.add(new ParseProductionNode(123));
        pn1 = new ParseNode(233, r1);
    }

    public void testHashCode() {
        assertTrue(pn0.hashCode() == pn1.hashCode());
    }

    public void testEquals() {
        assertTrue(pn0.equals(pn1));
    }


}

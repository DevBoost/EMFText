/*
 * Created on 05.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.spoofax.jsglr.ParserException;
import org.spoofax.jsglr.InvalidParseTableException;

public class TestG_avoid_2 extends ParseTestCase {

    public void setUp() throws FileNotFoundException, IOException,
            ParserException, InvalidParseTableException {
        super.setUp("G-avoid-2", "txt");
    }


    public void testG_avoid_2_1() throws FileNotFoundException, IOException {
        doParseTest("g-avoid-2_1");
    }
}

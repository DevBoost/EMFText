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

public class TestG_prefer_1 extends ParseTestCase {

    public void setUp() throws FileNotFoundException, IOException,
            ParserException, InvalidParseTableException {
        super.setUp("G-prefer-1", "txt");
    }


    public void testG_prefer_1_1() throws FileNotFoundException, IOException {
        doParseTest("g-prefer-1_1");
    }
}

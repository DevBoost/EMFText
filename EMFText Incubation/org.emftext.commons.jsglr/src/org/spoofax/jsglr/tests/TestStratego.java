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

public class TestStratego extends ParseTestCase {

    public void setUp() throws FileNotFoundException, IOException,
            ParserException, InvalidParseTableException {
        super.setUp("Stratego", "str");
    }


    public void testS0() throws FileNotFoundException, IOException {
        doParseTest("s0");
    }

    public void testS1() throws FileNotFoundException, IOException {
        doParseTest("s1");
    }

    public void testS2() throws FileNotFoundException, IOException {
        doParseTest("s2");
    }

    public void testS3() throws FileNotFoundException, IOException {
        doParseTest("s3");
    }

    public void testS4() throws FileNotFoundException, IOException {
        doParseTest("s4");
    }

    public void testS5() throws FileNotFoundException, IOException {
        doParseTest("s5");
    }

    public void testS6() throws FileNotFoundException, IOException {
        doParseTest("s6");
    }

}

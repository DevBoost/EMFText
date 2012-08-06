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

public class TestBooleans extends ParseTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp("Booleans", "txt");
    }

    public void testB0() throws FileNotFoundException, IOException {
        doParseTest("b0");
    }

    public void testB1() throws FileNotFoundException, IOException {
        doParseTest("b1");
    }

    public void testB2() throws FileNotFoundException, IOException {
        doParseTest("b2");
    }

    public void testB3() throws FileNotFoundException, IOException {
        doParseTest("b3");
    }

    public void testB4() throws FileNotFoundException, IOException {
        doParseTest("b4");
    }

    public void testB5() throws FileNotFoundException, IOException {
        doParseTest("b5");
    }

    public void testB6() throws FileNotFoundException, IOException {
        doParseTest("b6");
    }
}

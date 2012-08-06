/*
 * Created on 13.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import junit.framework.TestCase;

import org.spoofax.jsglr.ParseTable;
import org.spoofax.jsglr.ParseTableManager;
import org.spoofax.jsglr.ParserException;
import org.spoofax.jsglr.InvalidParseTableException;
import org.spoofax.jsglr.SGLR;
import org.spoofax.jsglr.SGLRException;
import org.spoofax.jsglr.Tools;

import aterm.ATerm;
import aterm.pure.PureFactory;

public abstract class ParseTestCase extends TestCase {

    SGLR sglr;
    String suffix;
    // shared by all tests
    static final PureFactory pf = new PureFactory();

    public void setUp(String grammar, String suffix) throws FileNotFoundException, IOException, ParserException, InvalidParseTableException {
        this.suffix = suffix;
        Tools.setDebug(false);
        Tools.setLogging(false);
        ParseTableManager ptm = new ParseTableManager(pf);
        ParseTable pt = ptm.loadFromFile("tests/grammars/" + grammar + ".tbl");
        sglr = new SGLR(pf, pt);
    }

    protected void tearDown()
      throws Exception {
        super.tearDown();

        sglr.clear();
    }

    final static boolean doCompare = true;
    public void doParseTest(String s) throws FileNotFoundException, IOException {
        Tools.setOutput("tests/jsglr-full-trace-" + s);

        long parseTime = System.nanoTime();
        ATerm parsed = null;
        try {
             parsed = sglr.parse(new FileInputStream("tests/data/" + s + "." + suffix));
        } catch(SGLRException e) {
            e.printStackTrace();
        }
        parseTime = System.nanoTime() - parseTime;
        Tools.logger("Parsing ", s, " took " + parseTime/1000/1000, " millis.");
        System.out.println("Parsing " + s + " took " + parseTime/1000/1000 + " millis.");
        assertNotNull(parsed);

        // When running performance this is in the way due to the extra garbage created.
        if(doCompare) {
            ATerm loaded = sglr.getFactory().readFromFile("tests/data/" + s + ".trm");

            assertNotNull(loaded);

            if(parsed.match(loaded) == null) {
                PrintWriter printWriter = new PrintWriter(new FileOutputStream("tests/data/" + s + ".trm.parsed"));
                printWriter.print(parsed.toString());
                printWriter.flush();
                System.err.println("Saw    : " + parsed);
                System.err.println("Wanted : " + loaded);
                System.err.println("Trying to compare to the alternative file.");
                
                loaded = sglr.getFactory().readFromFile("tests/data/" + s + "-bis.trm");

                assertNotNull(loaded);

                if(parsed.match(loaded) == null) {
                    printWriter = new PrintWriter(new FileOutputStream("tests/data/" + s + ".trm.parsed"));
                    printWriter.print(parsed.toString());
                    printWriter.flush();
                    System.err.println("Saw    : " + parsed);
                    System.err.println("Wanted : " + loaded);
                    assertTrue(false);
                }
            }
        }
    }
}

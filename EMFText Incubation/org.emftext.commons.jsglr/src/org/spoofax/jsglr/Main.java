/*
 * Created on 03.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import aterm.ATerm;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidParseTableException {
        
        if(args.length < 2) {
            usage();
        }

        String parseTable = null;
        String input = null;
        String output = null;
        boolean debugging = false;
        boolean logging = false;
        boolean detectCycles = true;
        boolean filter = true;
        boolean waitForProfiler = false;
        boolean timing = false;
        
        int skip = 0;
        for(int i=0;i<args.length;i++) {
            if(skip > 0)
                skip--;
            if(args[i].equals("-p")) {
                parseTable = args[i + 1];
                skip = 1;
            } else if(args[i].equals("-i")) {
                input = args[i + 1];
                skip = 1;
            } else if(args[i].equals("-o")) {
                output = args[i + 1];
                skip = 1;
            } else if(args[i].equals("-d")) {
                debugging = true;
            } else if(args[i].equals("-v")) {
                logging = true;
            } else if(args[i].equals("-f")) {
                filter = false;
            } else if(args[i].equals("-c")) {
                detectCycles = false;
            } else if(args[i].equals("--wait-for-profiler")) {
                waitForProfiler = true;
            } else if(args[i].equals("--timing")) {
            	timing = true;
            }
        }

        if(parseTable == null)
            usage();
        

        ParseTableManager ptm = new ParseTableManager();
        long tableLoadingTime = System.currentTimeMillis(); 
        SGLR sglr = new SGLR(ptm.getFactory(), ptm.loadFromFile(parseTable));        

        tableLoadingTime = System.currentTimeMillis() - tableLoadingTime;

        Tools.setDebug(debugging);
        Tools.setLogging(logging);
        sglr.getDisambiguator().setFilterCycles(detectCycles);
        sglr.getDisambiguator().setFilterAny(filter);
        
        long parsingTime = parseFile(input, output, sglr);
        
        if(waitForProfiler)
            System.in.read();
        if(timing) {
        	System.err.println("Parse table loading time : " + tableLoadingTime + "ms");
        	System.err.println("Parsing time             : " + parsingTime + "ms");
        }
    }

    public static long parseFile(String input, String output, SGLR sglr)
            throws FileNotFoundException, IOException {
        InputStream fis = null;
        if(input == null)
            fis = System.in;
        else
            fis = new FileInputStream(input);
        OutputStream ous = null;
        if(output != null)
            ous = new FileOutputStream(output);
        else 
            ous = System.out;

        long parsingTime = 0;
        try {
        	parsingTime = System.currentTimeMillis();
            ATerm t=sglr.parse(fis);            
            parsingTime = System.currentTimeMillis() - parsingTime;
            if(t != null)
                ous.write(t.toString().getBytes());
        } catch(BadTokenException e) {
            System.err.println("Parsing failed : " + e.getMessage());
        } catch(SGLRException e) {
            // Detailed message for other exceptions
            System.err.println("Parsing failed : " + e);
        }
        return parsingTime;
    }

    private static void usage() {
        System.out.println("Usage: org.spoofax.jsglr.Main [-f -d -v] -p <parsetable.tbl> -i <inputfile>");
        System.exit(-1);
    }
}

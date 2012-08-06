/*
 * Created on 26. nov.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.jsglr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import aterm.ATerm;
import aterm.ATermFactory;
import aterm.pure.PureFactory;

public class ParseTableManager {
    
    private Map<String, ParseTable> knownTables;
    private ATermFactory factory;
    
    private static boolean cacheTables = false;
    
    public ParseTableManager() {
        factory = new PureFactory();
        knownTables = new HashMap<String, ParseTable>();
    }
    
    public ParseTableManager(ATermFactory factory) {
        this.factory = factory;
        knownTables = new HashMap<String, ParseTable>();
    }
    
    public ParseTable loadFromFile(String filename) throws FileNotFoundException, IOException, InvalidParseTableException {
        
    	if(knownTables.containsKey(filename))
            return knownTables.get(filename);
    	
    	ParseTable pt = null;
    	
        if(cacheTables) {
        	final String cachedTable = hashFilename(filename);
        	File cached = new File(cachedTable);
        	File table = new File(filename);
        	if(cached.exists() && 
        			cached.lastModified() >= table.lastModified()) {
        		try {
					pt = loadFromCache(cachedTable);
					pt.initAFuns(factory);
				} catch (ClassNotFoundException e) {
				}
        	}
        }

        if(pt == null) {
        	pt = loadFromStream(new FileInputStream(filename));
        	if(cacheTables) {
        		storeInCache(pt, filename);
        	}
        }
        
        knownTables.put(filename, pt);
        return pt;
    }
    
    private void storeInCache(ParseTable pt, String filename) throws FileNotFoundException, IOException {
    	String storeName = hashFilename(filename);
    	File dir = new File(System.getProperty("user.home") + "/.jsglr/cache/");
    	if(!dir.exists()) {
    		dir.mkdirs();
    	}
    	ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(storeName));
    	ous.writeObject(pt);
    	ous.close();
	}

	private ParseTable loadFromCache(String cachedTable) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Loading " + cachedTable);
    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cachedTable));
    	ParseTable pt = (ParseTable)ois.readObject();
    	return pt;
	}

	private String hashFilename(String filename) {
    	// FIXME use a real hash instead
    	return System.getProperty("user.home") + "/.jsglr/cache/" + String.format("%x", filename.hashCode());
	}

	public ParseTable loadFromStream(InputStream stream) throws IOException, InvalidParseTableException {
        if(SGLR.isDebugging()) {
            Tools.debug("loadFromStream()");
        }
        
        if (stream == null) {
            throw new InvalidParseTableException("stream is null");
        }

        return initializeParseTable(factory.readFromFile(stream));
    }

	private ParseTable initializeParseTable(ATerm pt) throws InvalidParseTableException {
        long start = System.currentTimeMillis();
		ParseTable parseTable = new ParseTable(pt);
        long elapsed = System.currentTimeMillis() - start;

        if (SGLR.isLogging()) {
            Tools.logger("Loading parse table took " + elapsed/1000.0f + "s");
            Tools.logger("No. of states: ", parseTable.getStateCount());
            Tools.logger("No. of productions: ", parseTable.getProductionCount());
            Tools.logger("No. of action entries: ", parseTable.getActionCount());
            Tools.logger("No. of gotos entries: ", parseTable.getGotoCount());

            Tools.logger((parseTable.hasRejects() ? "Includes" : "Excludes"), " rejects");
            Tools.logger((parseTable.hasPriorities() ? "Includes" : "Excludes"), " priorities");
            Tools.logger((parseTable.hasPrefers() ? "Includes" : "Excludes"), " prefer actions");
            Tools.logger((parseTable.hasAvoids() ? "Includes" : "Excludes"), " avoid actions");
        }
        
        return parseTable;
	}

    public ATermFactory getFactory() {
        return factory;
    }

	public ParseTable loadFromTerm(ATerm term) throws InvalidParseTableException {
		return initializeParseTable(term);
	}

}

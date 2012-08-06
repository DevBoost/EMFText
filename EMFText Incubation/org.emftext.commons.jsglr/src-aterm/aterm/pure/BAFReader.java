/*
 * Java version of the ATerm library
 * Copyright (C) 2006-2007, UiB, CWI, LORIA-INRIA
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 */
package aterm.pure;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;

import aterm.AFun;
import aterm.ATerm;
import aterm.ATermList;
import aterm.ParseError;

public class BAFReader {

    private static final int BAF_MAGIC = 0xBAF;
    
    public static final int BAF_MAGIC_SIZE = 8; // bytes in BAF header magic

    private static final int BAF_VERSION = 0x300;

    private static final int HEADER_BITS = 32;
    
    private static final ThreadLocal<ArrayList<ReadTermFrame>> readerStacks =
        new ThreadLocal<ArrayList<ReadTermFrame>>();

    private BitStream reader;

    private int nrUniqueSymbols = -1;

    private SymEntry[] symbols;

    private PureFactory factory;

    public final static boolean isDebugging = false;

    class SymEntry {

        public AFun fun;

        public int arity;

        public int nrTerms;

        public int termWidth;

        public ATerm[] terms;

        public int[] nrTopSyms;

        public int[] symWidth;

        public int[][] topSyms;

    }

    public BAFReader(PureFactory factory, InputStream inputStream) {
        this.factory = factory;
        if(inputStream instanceof FileInputStream) {
        	try {
        		reader = new MemoryMappedBitStream((FileInputStream)inputStream);
        	} catch(IOException e) {
        		reader = new BitStream(inputStream);
        	}
        } else {
        	reader = new BitStream(inputStream);
        }
    }

    public ATerm readFromBinaryFile(boolean headerAlreadyRead) throws ParseError, IOException {

        if(!headerAlreadyRead && !isBinaryATerm(reader))
            throw new ParseError("Input is not a BAF file");

        int val = reader.readInt();

        if (val != BAF_VERSION)
            throw new ParseError("Wrong BAF version (wanted " + BAF_VERSION + ", got " + val + "), giving up");

        nrUniqueSymbols = reader.readInt();
        int nrUniqueTerms = reader.readInt();

        if(isDebugging()) {
            debug("" + nrUniqueSymbols + " unique symbols");
            debug("" + nrUniqueTerms + " unique terms");
        }

        symbols = new SymEntry[nrUniqueSymbols];

        readAllSymbols();

        int i = reader.readInt();

        return readTerm(symbols[i]);
    }

    private boolean isDebugging() {
        return isDebugging;
    }

    public static boolean isBinaryATerm(BufferedInputStream in) throws IOException {
        in.mark(10);
        if(isBinaryATerm(new BitStream(in)))
            return true;
        in.reset();
        return false;
    }

    private static boolean isBinaryATerm(BitStream in) throws IOException {
        try {
            int w0 = in.readInt();
            int w1 = in.readInt();

            if (w0 == 0 && w1 == BAF_MAGIC)
                return true;
        } catch(EOFException e) {}

        return false;
    }

    public static boolean isBinaryATerm(PushbackInputStream in) throws IOException {
        byte[] header = new byte[BAF_MAGIC_SIZE];
        
        in.read(header);
        in.unread(header);
        
        return isBinaryATerm(new BitStream(new ByteArrayInputStream(header)));
    }


    private void debug(String s) {
        System.err.println(s);
    }

    int level = 0;
    
    static class ReadTermFrame {
        final SymEntry input;
        final ATerm[] outputArgs;
        
        int index;
        SymEntry argSym;
        int val;
        
        public ReadTermFrame(SymEntry input) {
            this.input = input;
            this.outputArgs = new ATerm[input.arity];
        }
    }
    
    private ATerm readTerm(SymEntry e) throws ParseError, IOException {
        // TODO: Optimize readTerm?
        //       e.g., throw in some rounds of native-stack based reading
        ArrayList<ReadTermFrame> stack = readerStacks.get();
        if (stack == null) readerStacks.set(stack = new ArrayList<ReadTermFrame>());
        
        ReadTermFrame frame = new ReadTermFrame(e);
        boolean resumingFrame = false;
        
     readTerm:
        for(;;) {
            final SymEntry input = frame.input;
            final ATerm[] outputArgs = frame.outputArgs;

            if (!resumingFrame) {
                level++;
                if(isDebugging()) debug("readTerm()/" + level + " - " + input.fun.getName() + "[" + input.arity + "]");
            }
            
            for (int i = frame.index, arity = input.arity; i < arity; i++) {
                final SymEntry argSym;
                final int val;
                
                if (!resumingFrame) {
                    final int symVal = reader.readBits(input.symWidth[i]);
                    if(isDebugging()) {
                        debug(" [" + i + "] - " + symVal);
                        debug(" [" + i + "] - " + input.topSyms[i].length);
                    }
                    
                    argSym = symbols[input.topSyms[i][symVal]];
                    val = reader.readBits(argSym.termWidth);
                    
                    if (argSym.terms[val] == null) {
                        if(isDebugging()) debug(" [" + i+  "] - recurse");

                        frame.index = i;
                        frame.argSym = argSym;
                        frame.val = val;
                        stack.add(frame);
                        
                        frame = new ReadTermFrame(argSym); // recurse: argSym.terms[val] = readTerm(argSym);
                        continue readTerm;
                    }
                } else {
                    // Re-entry after recursion
                    resumingFrame = false;
                    argSym = frame.argSym;
                    val = frame.val;
                }
    
                if (argSym.terms[val] == null) 
                	throw new ParseError("Malformed ATerm: Cannot be null");
    
                outputArgs[i] = argSym.terms[val];
            }
            
            final ATerm result = readTermTop(input, outputArgs);
            
            if (stack.isEmpty()) {
                return result;
            } else {
                // Add result to parent frame
                frame = stack.remove(stack.size() - 1);
                frame.argSym.terms[frame.val] = result;
                resumingFrame = true;
            }
        }
    }

    private ATerm readTermTop(SymEntry e, final ATerm[] args) throws IOException {
      /*
      switch (e.fun.getType()) {
      case ATerm.BLOB:
          reader.flushBitsFromReader();
          String t = reader.readString();
          return factory.makeBlob(t.getBytes());
      case ATerm.PLACEHOLDER:
          return factory.makePlaceholder(args[0]);
      }
      */

      final String name = e.fun.getName();
      final int LONGEST_BUILTIN_NAME = 6; // longest string length of "<int>", etc.
      
      if (name.length() <= LONGEST_BUILTIN_NAME) {
          if (name.equals("<int>")) {
              int val = reader.readBits(HEADER_BITS);
              level--;
              return factory.makeInt(val);
          }
          else if (name.equals("<real>")) {
              reader.flushBitsFromReader();
              String s = reader.readString();
              level--;
              return factory.makeReal(new Double(s).doubleValue());
          }
          else if (name.equals("[_,_]")) {
              if(isDebugging()) {
                  debug("--");
                  for (int i = 0; i < args.length; i++)
                      debug(" + " + args[i].getClass());
              }
              level--;
              return ((ATermList) args[1]).insert(args[0]);
          }
          else if (name.equals("[]")) {
              level--;
              return factory.makeList();
          } else if (name.equals("{_}")) {
              return args[0].setAnnotations((ATermList)args[1]);
          } else if (name.equals("<_>")) {
        	  return factory.makePlaceholder(args[0]);
          } else if(false) {
        	  // FIXME: test blobs properly
        	  reader.flushBitsFromReader();
              String t = reader.readString();
              return factory.makeBlob(t.getBytes());
          }
      }

      if(isDebugging()) {
          debug(e.fun + " / " + args);
          for (int i = 0; i < args.length; i++)
              debug("" + args[i]);
      }
      level--;
      return factory.makeAppl(e.fun, args);
    }

    private void readAllSymbols() throws IOException {

        for (int i = 0; i < nrUniqueSymbols; i++) {
            SymEntry e = new SymEntry();
            symbols[i] = e;

            AFun fun = readSymbol();
            e.fun = fun;
            int arity = e.arity = fun.getArity();

            int v = reader.readInt();
            e.nrTerms = v;
            e.termWidth = bitWidth(v);
            // FIXME: original code is inconsistent at this point!
            e.terms = (v == 0) ? null : new ATerm[v];

            if (arity == 0) {
                e.nrTopSyms = null;
                e.symWidth = null;
                e.topSyms = null;
            } else {

                e.nrTopSyms = new int[arity];
                e.symWidth = new int[arity];
                e.topSyms = new int[arity][];
            }
            for (int j = 0; j < arity; j++) {
                v = reader.readInt();
                e.nrTopSyms[j] = v;
                e.symWidth[j] = bitWidth(v);
                e.topSyms[j] = new int[v];

                for (int k = 0; k < e.nrTopSyms[j]; k++) {
                    v = reader.readInt();
                    e.topSyms[j][k] = v;
                }
            }
        }
    }

    private int bitWidth(int v) {
        int nrBits = 0;

        if (v <= 1)
            return 0;

        while (v != 0) {
            v >>= 1;
            nrBits++;
        }

        return nrBits;
    }

    private AFun readSymbol() throws IOException {
        String s = reader.readString();
        int arity = reader.readInt();
        int quoted = reader.readInt();

        if(isDebugging())
//            debug(s + " / " + arity + " / " + quoted);
            debug(s + " / " + arity + " / " + quoted);

        return factory.makeAFun(s, arity, quoted != 0);
    }
}

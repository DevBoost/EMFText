/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.analysis;

import org.antlr.misc.IntervalSet;
import org.antlr.misc.IntSet;
import org.antlr.tool.Grammar;

/** An LL(1) lookahead set; contains a set of token types and a "hasEOF"
 *  condition when the set contains EOF.  Since EOF is -1 everywhere and -1
 *  cannot be stored in my BitSet, I set a condition here.  There may be other
 *  reasons in the future to abstract a LookaheadSet over a raw BitSet.
 */
public class LookaheadSet {
	public IntSet tokenTypeSet;
	public boolean hasEOF;

	public LookaheadSet() {
		tokenTypeSet = new IntervalSet();
	}

	public LookaheadSet(IntSet s) {
		this();
		tokenTypeSet.addAll(s);
	}

	public LookaheadSet(int atom) {
		tokenTypeSet = IntervalSet.of(atom);
	}

	public void orInPlace(LookaheadSet other) {
		this.tokenTypeSet.addAll(other.tokenTypeSet);
		this.hasEOF = this.hasEOF || other.hasEOF;
	}

	public boolean member(int a) {
		return tokenTypeSet.member(a);
	}

	public void remove(int a) {
		tokenTypeSet = tokenTypeSet.subtract(IntervalSet.of(a));
	}

	public String toString(Grammar g) {
		if ( tokenTypeSet==null ) {
			if ( hasEOF ) {
				return "EOF";
			}
			return "";
		}
		String r = tokenTypeSet.toString(g);
		if ( hasEOF ) {
			return r+"+EOF";
		}
		return r;
	}

	public static LookaheadSet EOF() {
		LookaheadSet eof = new LookaheadSet();
		eof.hasEOF = true;
		return eof;
	}

	public String toString() {
		return toString(null);
	}
}

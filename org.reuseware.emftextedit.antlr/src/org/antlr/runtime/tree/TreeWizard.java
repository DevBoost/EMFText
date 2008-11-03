/*
 [The "BSD licence"]
 Copyright (c) 2005-2007 Terence Parr
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
package org.antlr.runtime.tree;

import org.antlr.runtime.Token;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/** Build and navigate trees with this object.  Must know about the names
 *  of tokens so you have to pass in a map or array of token names (from which
 *  this class can build the map).  I.e., Token DECL means nothing unless the
 *  class can translate it to a token type.
 *
 *  In order to create nodes and navigate, this class needs a TreeAdaptor.
 *
 *  This class can build a token type -> node index for repeated use or for
 *  iterating over the various nodes with a particular type.
 *
 *  This class works in conjunction with the TreeAdaptor rather than moving
 *  all this functionality into the adaptor.  An adaptor helps build and
 *  navigate trees using methods.  This class helps you do it with string
 *  patterns like "(A B C)".  You can create a tree from that pattern or
 *  match subtrees against it.
 */
public class TreeWizard {
	protected TreeAdaptor adaptor;
	protected Map tokenNameToTypeMap;

	public interface ContextVisitor {
		// TODO: should this be called visit or something else?
		public void visit(Object t, Object parent, int childIndex, Map labels);
	}

	public static abstract class Visitor implements ContextVisitor {
		public void visit(Object t, Object parent, int childIndex, Map labels) {
			visit(t);
		}
		public abstract void visit(Object t);
	}

	/** When using %label:TOKENNAME in a tree for parse(), we must
	 *  track the label.
	 */
	public static class TreePattern extends CommonTree {
		public String label;
		public boolean hasTextArg;
		public TreePattern(Token payload) {
			super(payload);
		}
		public String toString() {
			if ( label!=null ) {
				return "%"+label+":"+super.toString();
			}
			else {
				return super.toString();				
			}
		}
	}

	public static class WildcardTreePattern extends TreePattern {
		public WildcardTreePattern(Token payload) {
			super(payload);
		}
	}

	/** This adaptor creates TreePattern objects for use during scan() */
	public static class TreePatternTreeAdaptor extends CommonTreeAdaptor {
		public Object create(Token payload) {
			return new TreePattern(payload);
		}
	}

	public TreeWizard(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	public TreeWizard(TreeAdaptor adaptor, Map tokenNameToTypeMap) {
		this.adaptor = adaptor;
		this.tokenNameToTypeMap = tokenNameToTypeMap;
	}

	public TreeWizard(TreeAdaptor adaptor, String[] tokenNames) {
		this.adaptor = adaptor;
		this.tokenNameToTypeMap = computeTokenTypes(tokenNames);
	}

	public TreeWizard(String[] tokenNames) {
		this(null, tokenNames);
	}

	/** Compute a Map<String, Integer> that is an inverted index of
	 *  tokenNames (which maps int token types to names).
	 */
	public Map computeTokenTypes(String[] tokenNames) {
		Map m = new HashMap();
		for (int ttype = Token.MIN_TOKEN_TYPE; ttype < tokenNames.length; ttype++) {
			String name = tokenNames[ttype];
			m.put(name, new Integer(ttype));
		}
		return m;
	}

	/** Using the map of token names to token types, return the type. */
	public int getTokenType(String tokenName) {
	 	if ( tokenNameToTypeMap==null ) {
			 return Token.INVALID_TOKEN_TYPE;
		 }
		Integer ttypeI = (Integer)tokenNameToTypeMap.get(tokenName);
		if ( ttypeI!=null ) {
			return ttypeI.intValue();
		}
		return Token.INVALID_TOKEN_TYPE;
	}

	/** Walk the entire tree and make a node name to nodes mapping.
	 *  For now, use recursion but later nonrecursive version may be
	 *  more efficient.  Returns Map<Integer, List> where the List is
	 *  of your AST node type.  The Integer is the token type of the node.
	 *
	 *  TODO: save this index so that find and visit are faster
	 */
	public Map index(Object t) {
		Map m = new HashMap();
		_index(t, m);
		return m;
	}

	/** Do the work for index */
	protected void _index(Object t, Map m) {
		if ( t==null ) {
			return;
		}
		int ttype = adaptor.getType(t);
		List elements = (List)m.get(ttype);
		if ( elements==null ) {
			elements = new ArrayList();
			m.put(new Integer(ttype), elements);
		}
		elements.add(t);
		int n = adaptor.getChildCount(t);
		for (int i=0; i<n; i++) {
			Object child = adaptor.getChild(t, i);
			_index(child, m);
		}
	}

	/** Return a List of tree nodes with token type ttype */
	public List find(Object t, int ttype) {
		final List nodes = new ArrayList();
		visit(t, ttype, new TreeWizard.Visitor() {
			public void visit(Object t) {
				nodes.add(t);
			}
		});
		return nodes;
	}

	/** Return a List of subtrees matching pattern. */
	public List find(Object t, String pattern) {
		final List subtrees = new ArrayList();
		// Create a TreePattern from the pattern
		TreePatternLexer tokenizer = new TreePatternLexer(pattern);
		TreePatternParser parser =
			new TreePatternParser(tokenizer, this, new TreePatternTreeAdaptor());
		final TreePattern tpattern = (TreePattern)parser.pattern();
		// don't allow invalid patterns
		if ( tpattern==null ||
			 tpattern.isNil() ||
			 tpattern.getClass()==WildcardTreePattern.class )
		{
			return null;
		}
		int rootTokenType = tpattern.getType();
		visit(t, rootTokenType, new TreeWizard.ContextVisitor() {
			public void visit(Object t, Object parent, int childIndex, Map labels) {
				if ( _parse(t, tpattern, null) ) {
					subtrees.add(t);
				}
			}
		});
		return subtrees;
	}

	public Object findFirst(Object t, int ttype) {
		return null;
	}

	public Object findFirst(Object t, String pattern) {
		return null;
	}

	/** Visit every ttype node in t, invoking the visitor.  This is a quicker
	 *  version of the general visit(t, pattern) method.  The labels arg
	 *  of the visitor action method is never set (it's null) since using
	 *  a token type rather than a pattern doesn't let us set a label.
	 */
	public void visit(Object t, int ttype, ContextVisitor visitor) {
		_visit(t, null, 0, ttype, visitor);
	}

	/** Do the recursive work for visit */
	protected void _visit(Object t, Object parent, int childIndex, int ttype, ContextVisitor visitor) {
		if ( t==null ) {
			return;
		}
		if ( adaptor.getType(t)==ttype ) {
			visitor.visit(t, parent, childIndex, null);
		}
		int n = adaptor.getChildCount(t);
		for (int i=0; i<n; i++) {
			Object child = adaptor.getChild(t, i);
			_visit(child, t, i, ttype, visitor);
		}
	}

	/** For all subtrees that match the pattern, execute the visit action.
	 *  The implementation uses the root node of the pattern in combination
	 *  with visit(t, ttype, visitor) so nil-rooted patterns are not allowed.
	 *  Patterns with wildcard roots are also not allowed.
	 */
	public void visit(Object t, final String pattern, final ContextVisitor visitor) {
		// Create a TreePattern from the pattern
		TreePatternLexer tokenizer = new TreePatternLexer(pattern);
		TreePatternParser parser =
			new TreePatternParser(tokenizer, this, new TreePatternTreeAdaptor());
		final TreePattern tpattern = (TreePattern)parser.pattern();
		// don't allow invalid patterns
		if ( tpattern==null ||
			 tpattern.isNil() ||
			 tpattern.getClass()==WildcardTreePattern.class )
		{
			return;
		}
		final Map labels = new HashMap(); // reused for each _parse
		int rootTokenType = tpattern.getType();
		visit(t, rootTokenType, new TreeWizard.ContextVisitor() {
			public void visit(Object t, Object parent, int childIndex, Map unusedlabels) {
				// the unusedlabels arg is null as visit on token type doesn't set.
				labels.clear();
				if ( _parse(t, tpattern, labels) ) {
					visitor.visit(t, parent, childIndex, labels);
				}
			}
		});
	}

	/** Given a pattern like (ASSIGN %lhs:ID %rhs:.) with optional labels
	 *  on the various nodes and '.' (dot) as the node/subtree wildcard,
	 *  return true if the pattern matches and fill the labels Map with
	 *  the labels pointing at the appropriate nodes.  Return false if
	 *  the pattern is malformed or the tree does not match.
	 *
	 *  If a node specifies a text arg in pattern, then that must match
	 *  for that node in t.
	 *
	 *  TODO: what's a better way to indicate bad pattern? Exceptions are a hassle 
	 */
	public boolean parse(Object t, String pattern, Map labels) {
		TreePatternLexer tokenizer = new TreePatternLexer(pattern);
		TreePatternParser parser =
			new TreePatternParser(tokenizer, this, new TreePatternTreeAdaptor());
		TreePattern tpattern = (TreePattern)parser.pattern();
		/*
		System.out.println("t="+((Tree)t).toStringTree());
		System.out.println("scant="+tpattern.toStringTree());
		*/
		boolean matched = _parse(t, tpattern, labels);
		return matched;
	}

	public boolean parse(Object t, String pattern) {
		return parse(t, pattern, null);
	}

	/** Do the work for parse. Check to see if the t2 pattern fits the
	 *  structure and token types in t1.  Check text if the pattern has
	 *  text arguments on nodes.  Fill labels map with pointers to nodes
	 *  in tree matched against nodes in pattern with labels.
	 */
	protected boolean _parse(Object t1, TreePattern t2, Map labels) {
		// make sure both are non-null
		if ( t1==null || t2==null ) {
			return false;
		}
		// check roots (wildcard matches anything)
		if ( t2.getClass() != WildcardTreePattern.class ) {
			if ( adaptor.getType(t1) != t2.getType() ) {
				return false;
			}
			if ( t2.hasTextArg && !adaptor.getText(t1).equals(t2.getText()) ) {
				return false;
			}
		}
		if ( t2.label!=null && labels!=null ) {
			// map label in pattern to node in t1
			labels.put(t2.label, t1);
		}
		// check children
		int n1 = adaptor.getChildCount(t1);
		int n2 = t2.getChildCount();
		if ( n1 != n2 ) {
			return false;
		}
		for (int i=0; i<n1; i++) {
			Object child1 = adaptor.getChild(t1, i);
			TreePattern child2 = (TreePattern)t2.getChild(i);
			if ( !_parse(child1, child2, labels) ) {
				return false;
			}
		}
		return true;
	}

	/** Create a tree or node from the indicated tree pattern that closely
	 *  follows ANTLR tree grammar tree element syntax:
	 *
	 * 		(root child1 ... child2).
	 *
	 *  You can also just pass in a node: ID
	 * 
	 *  Any node can have a text argument: ID[foo]
	 *  (notice there are no quotes around foo--it's clear it's a string).
	 *
	 *  nil is a special name meaning "give me a nil node".  Useful for
	 *  making lists: (nil A B C) is a list of A B C.
 	 */
	public Object create(String pattern) {
		TreePatternLexer tokenizer = new TreePatternLexer(pattern);
		TreePatternParser parser = new TreePatternParser(tokenizer, this, adaptor);
		Object t = parser.pattern();
		return t;
	}

	/** Compare t1 and t2; return true if token types/text, structure match exactly.
	 *  The trees are examined in their entirety so that (A B) does not match
	 *  (A B C) nor (A (B C)). 
	 // TODO: allow them to pass in a comparator
	 *  TODO: have a version that is nonstatic so it can use instance adaptor
	 *
	 *  I cannot rely on the tree node's equals() implementation as I make
	 *  no constraints at all on the node types nor interface etc... 
	 */
	public static boolean equals(Object t1, Object t2, TreeAdaptor adaptor) {
		return _equals(t1, t2, adaptor);
	}

	/** Compare type, structure, and text of two trees, assuming adaptor in
	 *  this instance of a TreeWizard.
	 */
	public boolean equals(Object t1, Object t2) {
		return _equals(t1, t2, adaptor);
	}

	protected static boolean _equals(Object t1, Object t2, TreeAdaptor adaptor) {
		// make sure both are non-null
		if ( t1==null || t2==null ) {
			return false;
		}
		// check roots
		if ( adaptor.getType(t1) != adaptor.getType(t2) ) {
			return false;
		}
		if ( !adaptor.getText(t1).equals(adaptor.getText(t2)) ) {
			return false;
		}
		// check children
		int n1 = adaptor.getChildCount(t1);
		int n2 = adaptor.getChildCount(t2);
		if ( n1 != n2 ) {
			return false;
		}
		for (int i=0; i<n1; i++) {
			Object child1 = adaptor.getChild(t1, i);
			Object child2 = adaptor.getChild(t2, i);
			if ( !_equals(child1, child2, adaptor) ) {
				return false;
			}
		}
		return true;
	}
}
